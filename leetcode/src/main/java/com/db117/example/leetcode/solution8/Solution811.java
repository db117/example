//一个网站域名，如"discuss.leetcode.com"，包含了多个子域名。作为顶级域名，常用的有"com"，下一级则有"leetcode.com"，最
//低的一级为"discuss.leetcode.com"。当我们访问域名"discuss.leetcode.com"时，也同时访问了其父域名"leetcode.c
//om"以及顶级域名 "com"。 
//
// 给定一个带访问次数和域名的组合，要求分别计算每个域名被访问的次数。其格式为访问次数+空格+地址，例如："9001 discuss.leetcode.com
//"。 
//
// 接下来会给出一组访问次数和域名组合的列表cpdomains 。要求解析出所有域名的访问次数，输出格式和输入格式相同，不限定先后顺序。 
//
// 
//示例 1:
//输入: 
//["9001 discuss.leetcode.com"]
//输出: 
//["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
//说明: 
//例子中仅包含一个网站域名："discuss.leetcode.com"。按照前文假设，子域名"leetcode.com"和"com"都会被访问，所以它们都被
//访问了9001次。
// 
//
// 
//示例 2
//输入: 
//["900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"]
//输出: 
//["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 i
//ntel.mail.com","951 com"]
//说明: 
//按照假设，会访问"google.mail.com" 900次，"yahoo.com" 50次，"intel.mail.com" 1次，"wiki.org" 
//5次。
//而对于父域名，会访问"mail.com" 900+1 = 901次，"com" 900 + 50 + 1 = 951次，和 "org" 5 次。
// 
//
// 注意事项： 
//
// 
// cpdomains 的长度小于 100。 
// 每个域名的长度小于100。 
// 每个域名地址包含一个或两个"."符号。 
// 输入中任意一个域名的访问次数都小于10000。 
// 
// Related Topics 哈希表 
// 👍 76 👎 0

package com.db117.example.leetcode.solution8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811.子域名访问计数.subdomain-visit-count
 *
 * @author db117
 * @date 2020-10-27 16:58:00
 **/
public class Solution811 {
    public static void main(String[] args) {
        Solution solution = new Solution811().new Solution();
        System.out.println(solution.subdomainVisits(new String[]{
                "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"
        }));
        System.out.println((int) ' ');
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> subdomainVisits(String[] cpdomains) {
            Map</*域名*/ String,/*访问次数*/ Integer> map = new HashMap<>();
            for (String cpdomain : cpdomains) {
                // 空格位置
                int blankIndex = cpdomain.indexOf(32);
                // 访问次数
                int num = Integer.parseInt(cpdomain.substring(0, blankIndex));

                // 域名
                String domain = cpdomain.substring(blankIndex + 1);
                // 第一个.
                int first = domain.indexOf(46);
                // 最后一个.
                int last = domain.lastIndexOf(46);

                // 第一个
                String sub = domain;
                map.put(sub, map.getOrDefault(sub, 0) + num);

                // 有2个.
                if (first != last) {
                    // 中间的
                    sub = domain.substring(first + 1);
                    map.put(sub, map.getOrDefault(sub, 0) + num);

                }

                // 最后一个
                sub = domain.substring(last + 1);
                map.put(sub, map.getOrDefault(sub, 0) + num);
            }

            // 拼接返回值
            List<String> res = new ArrayList<>(map.size());
            map.forEach((s, integer) -> res.add(integer + " " + s));
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}