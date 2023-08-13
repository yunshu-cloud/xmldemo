package com.wangzhixiong.jsoup;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import cn.wanghaomiao.xpath.model.JXNode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class Demo5 {
  // Document
  public static void main(String[] args) throws IOException, XpathSyntaxErrorException
  {
    String path = Demo5.class.getClassLoader().getResource("com/wangzhixiong/jsoup/student.xml").getPath();
    // 1. 获取`Document`对象
    Document document = Jsoup.parse(new File(path), "utf-8");
    //2. 将`Document`对象转为`JXDocument`对象
    JXDocument jxDocument = new JXDocument(document);
    //3. `JXDocument`调用`selN(String xpath)`，获取`List<JXNode>`对象。
//     List<JXNode> jxNodes = jxDocument.selN("//name");
    // 想拿到baizhan_0001的年龄
    List<JXNode> jxNodes = jxDocument.selN("//student[@id='baizhan_0001']/age");
    //4. 遍历`List<JXNode>`，调用`JXNode`的`getElement()`，转为`Element`对象。
    for (JXNode jxNode : jxNodes) {
      Element element = jxNode.getElement();
      //5. 处理`Element`对象。
      System.out.println(element);
    }
  }
}
