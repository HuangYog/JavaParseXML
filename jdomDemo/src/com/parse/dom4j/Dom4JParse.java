package com.parse.dom4j;

import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by HuangYog on 2015/2/5.
 */
public class Dom4JParse {
    public static void read1() {
        try {
            SAXReader reader = new SAXReader();
            InputStream in = Dom4JParse.class.getClassLoader().getResourceAsStream("read.xml");
            Document doc = reader.read(in);
            Element root = doc.getRootElement();
            readNode(root, "");
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    private static void readNode(Element root, String s) {
        if (root == null) return;
        List<Attribute> attrs = root.attributes();
        if (attrs != null && attrs.size() > 0) {
            System.err.println(s);
            for (Attribute attr : attrs) {
                System.err.print(attr.getValue() + " ");
            }
            System.err.println();
        }
        List<Element> childNodes = root.elements();
        s += "\t";
        for (Element e : childNodes) {
            readNode(e, s);
        }
    }

    public static void read2() {
        try {
            SAXReader reader = new SAXReader();
            InputStream in = Dom4JParse.class.getClassLoader().getResourceAsStream("read.xml");
            Document doc = reader.read(in);
            doc.accept(new MyVistor());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    public static void write() {
        //创建一个xml文件
        try {
            Document doc = DocumentHelper.createDocument();
            Element university = doc.addElement("university");
            university.addAttribute("name", "tsu");
            university.addComment("這是个节点");
            Element college = university.addElement("college");
            college.addAttribute("name", "CCCC");
            college.setText("text");

            File file = new File("jdomDemo/src/dom4j.xml");
            if (file.exists()) {
                file.delete();
            }
            file.createNewFile();
            XMLWriter out = new XMLWriter(new FileWriter(file));
            out.write(doc);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
