package com.wangzhixiong.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element可以获取元素内的数据
 */
public class Demo4
{
  // Document
  public static void main(String[] args) throws IOException
  {
    String path = Demo4.class.getClassLoader().getResource("com/wangzhixiong/jsoup/student.xml").getPath();
    Document document = Jsoup.parse(new File(path), "utf-8");

    Elements elements = document.select("#baizhan_0001");
    Element element =elements.get(0);
    System.out.println(element.text());
    System.out.println(element.html());
    System.out.println(element.attr("id"));
  }
}

