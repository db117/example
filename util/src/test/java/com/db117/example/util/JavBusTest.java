package com.db117.example.util;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.junit.Test;

import java.util.HashMap;

public class JavBusTest {
    @Test
    public void v115() {
        HttpRequest request = HttpUtil.createPost("https://115.com/web/lixian/?ct=lixian&ac=add_task_urls");
        request.form(new HashMap<String, Object>() {{
            put("uid", "25249231");
            put("sign", "e3a7d71dca37a510198bc313f106e9b3a0e99b67");
            put("time", 1577801024);
            put("url", "magnet:?xt=urn:btih:F83E6AC3569E259EBB64B227AF37ACDBE670DF31&dn=MEYD422Cre");
        }});
        request.header("Cookie", "acw_tc=784e2c9515753882305851193e408c7a406385d5e2073bad73647cbad8d9fa; UID=25249231_A1_1577116022; CID=c7cc16c9cd46d54f6cf08d0889599e12; SEID=2beb6b112bfe502194a6b10bc8feed35f1909e170251bc6151c736a8d69f55c0eec1bd72b36f0c5bb5a3ce0aab9e19cd2de1d6cee098ba424ee3963c; 25249231_middle_act_dialog_not_show=1; PHPSESSID=nhb0ufpqvd4e4s58mkcf50epq9; 115_lang=zh");
        request.header("Host", "115.com");
        request.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        request.header("Origin", "https://115.com");
        request.header("Referer", "https://115.com/?cid=527486596136681657&offset=0&tab=download&mode=wangpan");
        request.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/62.0.3202.94 Safari/537.36 115Browser/11.0.0");
        request.header("X-Requested-With", "XMLHttpRequest");
//        request.header("", "");

        System.out.println(request.execute().body());

    }

    @Test
    public void process() {
        JavBus.process("6ei", "希美まゆ", "D:\\webmagic\\");
    }

    @Test
    public void getMagent() {
//        System.out.println(JavBus.getMagent("GNAX-021"));
        JavBus.MagentSearch.processMagent("<tr onmouseover=\"this.style.backgroundColor='#F4F9FD';this.style.cursor='pointer';\" onmouseout=\"this.style.backgroundColor='#FFFFFF'\" height=\"35px\" style=\" border-top:#DDDDDD solid 1px\">\n" +
                "                <td width=\"70%\" onclick=\"window.open('magnet:?xt=urn:btih:C27F154D11955F4FC6604818C3F8DA1930D98BF1&dn=FHD_6M-MIZD-168','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:C27F154D11955F4FC6604818C3F8DA1930D98BF1&dn=FHD_6M-MIZD-168\">\n" +
                "                \tFHD_6M-MIZD-168 <a class=\"btn btn-mini-new btn-primary disabled\" title=\"包含高清HD的磁力連結\">高清</a>                \t</a>\n" +
                "                </td>\n" +
                "                <td style=\"text-align:center;white-space:nowrap\" onclick=\"window.open('magnet:?xt=urn:btih:C27F154D11955F4FC6604818C3F8DA1930D98BF1&dn=FHD_6M-MIZD-168','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:C27F154D11955F4FC6604818C3F8DA1930D98BF1&dn=FHD_6M-MIZD-168\">\n" +
                "                \t10.28GB                \t</a>\n" +
                "                </td>\n" +
                "                <td style=\"text-align:center;white-space:nowrap\" onclick=\"window.open('magnet:?xt=urn:btih:C27F154D11955F4FC6604818C3F8DA1930D98BF1&dn=FHD_6M-MIZD-168','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:C27F154D11955F4FC6604818C3F8DA1930D98BF1&dn=FHD_6M-MIZD-168\">\n" +
                "                \t2019-12-23                \t</a>\n" +
                "                </td>            \n" +
                "            </tr>\n" +
                "\t\t         \n" +
                "            <tr onmouseover=\"this.style.backgroundColor='#F4F9FD';this.style.cursor='pointer';\" onmouseout=\"this.style.backgroundColor='#FFFFFF'\" height=\"35px\" style=\" border-top:#DDDDDD solid 1px\">\n" +
                "                <td width=\"70%\" onclick=\"window.open('magnet:?xt=urn:btih:A3F8BCE2DA271BDD4A4BC1665639820C9346E7FD&dn=MIZD-168.mp4','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:A3F8BCE2DA271BDD4A4BC1665639820C9346E7FD&dn=MIZD-168.mp4\">\n" +
                "                \tMIZD-168.mp4                 \t</a>\n" +
                "                </td>\n" +
                "                <td style=\"text-align:center;white-space:nowrap\" onclick=\"window.open('magnet:?xt=urn:btih:A3F8BCE2DA271BDD4A4BC1665639820C9346E7FD&dn=MIZD-168.mp4','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:A3F8BCE2DA271BDD4A4BC1665639820C9346E7FD&dn=MIZD-168.mp4\">\n" +
                "                \t2.21GB                \t</a>\n" +
                "                </td>\n" +
                "                <td style=\"text-align:center;white-space:nowrap\" onclick=\"window.open('magnet:?xt=urn:btih:A3F8BCE2DA271BDD4A4BC1665639820C9346E7FD&dn=MIZD-168.mp4','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:A3F8BCE2DA271BDD4A4BC1665639820C9346E7FD&dn=MIZD-168.mp4\">\n" +
                "                \t2019-12-22                \t</a>\n" +
                "                </td>            \n" +
                "            </tr>\n" +
                "\t\t         \n" +
                "            <tr onmouseover=\"this.style.backgroundColor='#F4F9FD';this.style.cursor='pointer';\" onmouseout=\"this.style.backgroundColor='#FFFFFF'\" height=\"35px\" style=\" border-top:#DDDDDD solid 1px\">\n" +
                "                <td width=\"70%\" onclick=\"window.open('magnet:?xt=urn:btih:C88A54A99D5C0E2640F9B239897157FAC6DD2007&dn=MIZD-168','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:C88A54A99D5C0E2640F9B239897157FAC6DD2007&dn=MIZD-168\">\n" +
                "                \tMIZD-168 <a class=\"btn btn-mini-new btn-primary disabled\" title=\"包含高清HD的磁力連結\">高清</a>                \t</a>\n" +
                "                </td>\n" +
                "                <td style=\"text-align:center;white-space:nowrap\" onclick=\"window.open('magnet:?xt=urn:btih:C88A54A99D5C0E2640F9B239897157FAC6DD2007&dn=MIZD-168','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:C88A54A99D5C0E2640F9B239897157FAC6DD2007&dn=MIZD-168\">\n" +
                "                \t10.30GB                \t</a>\n" +
                "                </td>\n" +
                "                <td style=\"text-align:center;white-space:nowrap\" onclick=\"window.open('magnet:?xt=urn:btih:C88A54A99D5C0E2640F9B239897157FAC6DD2007&dn=MIZD-168','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:C88A54A99D5C0E2640F9B239897157FAC6DD2007&dn=MIZD-168\">\n" +
                "                \t2019-12-22                \t</a>\n" +
                "                </td>            \n" +
                "            </tr>\n" +
                "\t\t         \n" +
                "            <tr onmouseover=\"this.style.backgroundColor='#F4F9FD';this.style.cursor='pointer';\" onmouseout=\"this.style.backgroundColor='#FFFFFF'\" height=\"35px\" style=\" border-top:#DDDDDD solid 1px\">\n" +
                "                <td width=\"70%\" onclick=\"window.open('magnet:?xt=urn:btih:ECF94F3A42E702E3D3144ECF1FFA13D17370F41F&dn=MIZD-168.mp4','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:ECF94F3A42E702E3D3144ECF1FFA13D17370F41F&dn=MIZD-168.mp4\">\n" +
                "                \tMIZD-168.mp4 <a class=\"btn btn-mini-new btn-primary disabled\" title=\"包含高清HD的磁力連結\">高清</a>                \t</a>\n" +
                "                </td>\n" +
                "                <td style=\"text-align:center;white-space:nowrap\" onclick=\"window.open('magnet:?xt=urn:btih:ECF94F3A42E702E3D3144ECF1FFA13D17370F41F&dn=MIZD-168.mp4','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:ECF94F3A42E702E3D3144ECF1FFA13D17370F41F&dn=MIZD-168.mp4\">\n" +
                "                \t10.28GB                \t</a>\n" +
                "                </td>\n" +
                "                <td style=\"text-align:center;white-space:nowrap\" onclick=\"window.open('magnet:?xt=urn:btih:ECF94F3A42E702E3D3144ECF1FFA13D17370F41F&dn=MIZD-168.mp4','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:ECF94F3A42E702E3D3144ECF1FFA13D17370F41F&dn=MIZD-168.mp4\">\n" +
                "                \t2019-12-21                \t</a>\n" +
                "                </td>            \n" +
                "            </tr>\n" +
                "\t\t         \n" +
                "            <tr onmouseover=\"this.style.backgroundColor='#F4F9FD';this.style.cursor='pointer';\" onmouseout=\"this.style.backgroundColor='#FFFFFF'\" height=\"35px\" style=\" border-top:#DDDDDD solid 1px\">\n" +
                "                <td width=\"70%\" onclick=\"window.open('magnet:?xt=urn:btih:3A634047419EF0F8133CFC2A0C6685CDF62D3C51&dn=MIZD-168++4Vol.2.mp4','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:3A634047419EF0F8133CFC2A0C6685CDF62D3C51&dn=MIZD-168++4Vol.2.mp4\">\n" +
                "                \tMIZD-168  4Vol.2.mp4                 \t</a>\n" +
                "                </td>\n" +
                "                <td style=\"text-align:center;white-space:nowrap\" onclick=\"window.open('magnet:?xt=urn:btih:3A634047419EF0F8133CFC2A0C6685CDF62D3C51&dn=MIZD-168++4Vol.2.mp4','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:3A634047419EF0F8133CFC2A0C6685CDF62D3C51&dn=MIZD-168++4Vol.2.mp4\">\n" +
                "                \t2.21GB                \t</a>\n" +
                "                </td>\n" +
                "                <td style=\"text-align:center;white-space:nowrap\" onclick=\"window.open('magnet:?xt=urn:btih:3A634047419EF0F8133CFC2A0C6685CDF62D3C51&dn=MIZD-168++4Vol.2.mp4','_self')\">\n" +
                "                \t<a style=\"color:#333\" rel=\"nofollow\" title=\"滑鼠右鍵點擊並選擇【複製連結網址】\" href=\"magnet:?xt=urn:btih:3A634047419EF0F8133CFC2A0C6685CDF62D3C51&dn=MIZD-168++4Vol.2.mp4\">\n" +
                "                \t2019-12-21                \t</a>\n" +
                "                </td>            \n" +
                "            </tr>\n" +
                "\t\t  \n" +
                "\t\t\t<script type=\"text/javascript\">\n" +
                "\t\t\t$('#movie-loading').hide();\n" +
                "\t\t\t</script>\n" +
                "        ");
    }
}