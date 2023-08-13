package com.wangzhixiong.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document可以获取元素对象
 */
public class Demo3 {
  // Document
  public static void main(String[] args) throws IOException
  {
    String path = Demo3.class.getClassLoader().getResource("com/wangzhixiong/jsoup/student.xml").getPath();
    Document document = Jsoup.parse(new File(path), "utf-8");


    // 根据id获取元素
    Element baizhan_0001 = document.getElementById("baizhan_0001");
    System.out.println(baizhan_0001);
    System.out.println("----------------------");


    // 根据标签获取元素
    Elements age = document.getElementsByTag("age");
    for (Element element : age) {
      System.out.println(element);
    }
    System.out.println("----------------------");


    // 根据属性获取元素
    Elements english = document.getElementsByAttribute("english");
    for (Element element : english) {
      System.out.println(element);
    }
    System.out.println("----------------------");


    // 根据属性名=属性值获取元素
    Elements elementsByAttributeValue = document.getElementsByAttributeValue("english", "bz");
    for (Element element : elementsByAttributeValue) {
      System.out.println(element);
    }
    System.out.println("----------------------");


    // 使用CSS选择器获取元素
    Elements select = document.select("#baizhan_0001");
    System.out.println(select);
    System.out.println("----------------------");
    Elements sex = document.select("sex");
    System.out.println(sex);
    System.out.println("----------------------");
    Elements select1 = document.select(".aa");
    System.out.println(select1);
  }
}

