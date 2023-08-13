package com.wangzhixiong.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Demo1
{
    // 获取XML中所有学生的姓名
    public static void main(String[] args) throws IOException
    {
        // 获取类加载器
        ClassLoader classLoader = Demo1.class.getClassLoader();

        // 找到XML文档路径
        String path = classLoader.getResource("com/wangzhixiong/xsd/student.xml").getPath();

        // 加载XML文档进内存
        Document document = Jsoup.parse(new File(path), "utf-8");

        // 获取对应的标签Element对象
        Elements name = document.getElementsByTag("name");

        // 获取数据
        for (Element element : name)
        {
            String text = element.text();
            System.out.println(text);
        }
    }
}
