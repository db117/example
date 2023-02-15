package com.db117;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication()
@EnableKafka
@Slf4j
public class Main {
    @Autowired
    KafkaTemplate kafkaTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    //    @KafkaListener(groupId = "mcmt",topicPartitions={@TopicPartition(topic = "s4.mmr-basic.tst",partitionOffsets=@PartitionOffset(partition = "1",initialOffset = "1"))})
    public void listen(String input) {
        log.info(input);
    }
}