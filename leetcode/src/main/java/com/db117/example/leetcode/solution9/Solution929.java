package com.db117.example.leetcode.solution9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 929. 独特的电子邮件地址
 * 每封电子邮件都由一个本地名称和一个域名组成，以 @ 符号分隔。
 * <p>
 * 例如，在 alice@leetcode.com中， alice 是本地名称，而 leetcode.com 是域名。
 * <p>
 * 除了小写字母，这些电子邮件还可能包含 '.' 或 '+'。
 * <p>
 * 如果在电子邮件地址的本地名称部分中的某些字符之间添加句点（'.'），则发往那里的邮件将会转发到本地名称中没有点的同一地址。例如，"alice.z@leetcode.com” 和 “alicez@leetcode.com” 会转发到同一电子邮件地址。 （请注意，此规则不适用于域名。）
 * <p>
 * 如果在本地名称中添加加号（'+'），则会忽略第一个加号后面的所有内容。这允许过滤某些电子邮件，例如 m.y+name@email.com 将转发到 my@email.com。 （同样，此规则不适用于域名。）
 * <p>
 * 可以同时使用这两个规则。
 * <p>
 * 给定电子邮件列表 emails，我们会向列表中的每个地址发送一封电子邮件。实际收到邮件的不同地址有多少？
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"]
 * 输出：2
 * 解释：实际收到邮件的是 "testemail@leetcode.com" 和 "testemail@lee.tcode.com"。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= emails[i].length <= 100
 * 1 <= emails.length <= 100
 * 每封 emails[i] 都包含有且仅有一个 '@' 字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-email-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author db117
 * @date 2019/12/17/017 16:06
 */
public class Solution929 {
    public static void main(String[] args) {
        System.out.println(new Solution929().numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com", "test.email@leetcode.com"
        }));
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        StringBuilder builder = new StringBuilder();
        for (String email : emails) {
            // 状态机
            // + 0->1
            // @ 1->2
            int flag = 0;
            for (char c : email.toCharArray()) {
                if (flag == 0 && c == '+') {
                    flag = 1;
                }
                if (flag != 2 && c == '@') {
                    flag = 2;
                }

                // 状态为1则不进行操作
                switch (flag) {
                    case 0:
                        if (c != '.') {
                            // 过滤 .
                            builder.append(c);
                        }
                        break;
                    case 2:
                        builder.append(c);
                        break;
                    default:
                        break;
                }
            }
            set.add(builder.toString());
            builder.setLength(0);
        }
        return set.size();
    }

    public int numUniqueEmails1(String[] emails) {
        return (int) Arrays.stream(emails)
                .map(StringBuilder::new)
                .map(email -> {
                    // 删除掉+后面的
                    int i = email.indexOf("+");
                    int j = email.indexOf("@");
                    if (i != -1 && i < j) {
                        email.delete(i, j);
                    }
                    // 去掉 .
                    j = email.indexOf("@");
                    int x = email.indexOf(".");
                    while (x != -1 && x < j) {
                        email.deleteCharAt(x);
                        x = email.indexOf(".");
                    }
                    return email.toString();
                })
                .distinct()
                .count();
    }
}
