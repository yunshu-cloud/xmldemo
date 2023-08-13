package com.wangzhixiong.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup解析器 （解析xml或者html）
 */
public class Demo2 {
    // Jsoup
    public static void main(String[] args) throws IOException {
        // 解析本地XML
        String path = Demo2.class.getClassLoader().getResource("com/wangzhixiong/xsd/student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);
        System.out.println("------------------");


        // 解析字符串
        Document document1 = Jsoup.parse("<?xml version=\"1.0\" ?>\n" +
                "<students\n" +
                "     xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "     xsi:schemaLocation=\"http://www.itbaizhan.cn/xml student.xsd\"\n" +
                "     xmlns=\"http://www.itbaizhan.cn/xml\">\n" +
                "\n" +
                "   <student number=\"baizhan_0001\">\n" +
                "     <name>baizhan</name>\n" +
                "     <age>10</age>\n" +
                "     <sex>male</sex>\n" +
                "   </student>\n" +
                "   <student number=\"baizhan_0002\">\n" +
                "     <name>sxt</name>\n" +
                "     <age>11</age>\n" +
                "     <sex>female</sex>\n" +
                "   </student>\n" +
                "</students>");
        System.out.println(document1);
        System.out.println("---------------------------------");


        // 解析网络资源
        Document document2 = Jsoup.parse(new URL("https://www.baidu.com"), 2000);
        System.out.println(document2);
    }
}
