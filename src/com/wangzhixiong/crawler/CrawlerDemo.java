package com.wangzhixiong.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.URL;

public class CrawlerDemo {
    public static void main(String[] args) {
        int min = 9734020;
        int max = 9734346;

        // 循环爬取数据
        for (int i = min; i <= max; i++) {
            try {
                //1. 使用Jsoup获取网页HTML源文件，转为Document对象
                Document document = Jsoup.parse(new URL("http://daily.zhihu.com/story/"+i), 3000);
                //     System.out.println(document);
                //2. 通过Document对象，获取需要的Element对象
                Elements headerImgEle = document.getElementsByAttributeValue("alt", "头图");
                Elements titleEle = document.select(".DailyHeader-title");
                Elements authorEle = document.select(".author");
                Elements contentELe = document.select(".content");
                //3. 获取Element对象的数据。
                System.out.println(headerImgEle.get(0).attr("src"));
                System.out.println(titleEle.get(0).text());
                System.out.println(authorEle.get(0).text());
                System.out.println(contentELe.get(0).text());
            }catch (Exception e){}
        }
    }
}

