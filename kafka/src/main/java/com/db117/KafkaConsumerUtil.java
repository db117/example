package com.db117;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndTimestamp;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author db117
 * @since 2023/2/9
 */
@Slf4j
public class KafkaConsumerUtil {

    /**
     * 消费者所有数据
     *
     * @param properties   配置
     * @param topic        主题
     * @param dataConsumer 数据消费者
     */
    public static void kktConsumerDataForBeginning(Properties properties, String topic,
                                                   Consumer<ConsumerRecord<String, String>> dataConsumer) {
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {

            List<PartitionInfo> partitions = consumer.partitionsFor(topic);

            List<TopicPartition> topicPartitionList = partitions.stream()
                    .map(partition -> new TopicPartition(partition.topic(), partition.partition()))
                    .collect(Collectors.toList());

            consumer.assign(topicPartitionList);

            consumer.seekToBeginning(topicPartitionList);

            // 记录每个 partition 结束位置
            Map<TopicPartition, Long> topicPartitionLongMap = consumer.endOffsets(topicPartitionList);
            Map<Integer, Long> partitionEndOffset = new HashMap<>();
            topicPartitionLongMap.forEach((topicPartition, offset) -> {
                partitionEndOffset.put(topicPartition.partition(), offset);
            });

            // 标记是否结束
            boolean flag = true;
            while (flag) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
                if (consumerRecords.isEmpty()) {
                    break;
                }
                for (ConsumerRecord<String, String> record : consumerRecords) {
                    dataConsumer.accept(record);

                    if (partitionEndOffset.get(record.partition()) <= record.offset()) {
                        flag = false;
                    }
                }
            }
        }
    }

    /**
     * 消费者最后一段时间的数据
     *
     * @param properties   配置
     * @param topic        主题
     * @param duration     时间
     * @param dataConsumer 数据消费者
     */
    public static void kktConsumerDataForTime(Properties properties, String topic, Duration duration, Consumer<ConsumerRecord<String, String>> dataConsumer) {
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {

            List<PartitionInfo> partitions = consumer.partitionsFor(topic);

            // 所有 Partition
            List<TopicPartition> topicPartitionList = partitions.stream()
                    .map(partition -> new TopicPartition(partition.topic(), partition.partition()))
                    .collect(Collectors.toList());

            // 设置时间戳
            long startMillis = System.currentTimeMillis() - duration.toMillis();

            Map<TopicPartition, Long> timestampsToSearch = new HashMap<>();
            for (TopicPartition topicPartition : topicPartitionList) {
                timestampsToSearch.put(topicPartition, startMillis);
            }
            // 获取指定时间的 offset
            Map<TopicPartition, OffsetAndTimestamp> offsetsForTimes = consumer.offsetsForTimes(timestampsToSearch);

            consumer.assign(topicPartitionList);

            // 修改 offset 到指定位置
            offsetsForTimes.forEach((topicPartition, offsetAndTimestamp) ->
                    consumer.seek(topicPartition, offsetAndTimestamp.offset()));

            // 记录每个 partition 结束位置
            Map<TopicPartition, Long> topicPartitionLongMap = consumer.endOffsets(topicPartitionList);
            Map<Integer, Long> partitionEndOffset = new HashMap<>();
            topicPartitionLongMap.forEach((topicPartition, offset) -> {
                partitionEndOffset.put(topicPartition.partition(), offset);
            });

            // 标记是否结束
            boolean flag = true;
            while (flag) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
                if (consumerRecords.isEmpty()) {
                    break;
                }
                for (ConsumerRecord<String, String> record : consumerRecords) {
                    dataConsumer.accept(record);

                    if (partitionEndOffset.get(record.partition()) <= record.offset()) {
                        flag = false;
                    }
                }
            }
        }
    }

    /**
     * 消费最后数据
     *
     * @param properties   配置
     * @param topic        主题
     * @param last         最后多少条
     * @param dataConsumer 数据消费者
     */
    public static void kktConsumerDataForLast(Properties properties, String topic, int last, Consumer<ConsumerRecord<String, String>> dataConsumer) {
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties)) {

            // 所有 Partition
            List<PartitionInfo> partitions = consumer.partitionsFor(topic);
            List<TopicPartition> topicPartitionList = partitions.stream()
                    .map(partition -> new TopicPartition(partition.topic(), partition.partition()))
                    .collect(Collectors.toList());

            // 指定 Partition
            consumer.assign(topicPartitionList);

            // 记录每个 partition 结束位置
            Map<TopicPartition, Long> endOffsets = consumer.endOffsets(topicPartitionList);
            Map<TopicPartition, Long> beginningOffsets = consumer.beginningOffsets(topicPartitionList);

            Map<Integer, Long> partitionEndOffset = new HashMap<>();
            endOffsets.forEach((topicPartition, offset) -> partitionEndOffset.put(topicPartition.partition(), offset));

            // 设置 offset
            for (TopicPartition topicPartition : topicPartitionList) {
                Long end = endOffsets.get(topicPartition);
                Long begin = beginningOffsets.get(topicPartition);
                // 设置 offset 为最后 last 条的开始位置
                consumer.seek(topicPartition, Math.max(begin, end - last + 1));
            }

            // 标记是否结束
            boolean flag = true;
            while (flag) {
                ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
                if (consumerRecords.isEmpty()) {
                    break;
                }
                for (ConsumerRecord<String, String> record : consumerRecords) {
                    dataConsumer.accept(record);

                    if (partitionEndOffset.get(record.partition()) <= record.offset()) {
                        flag = false;
                    }
                }
            }
        }
    }
}
