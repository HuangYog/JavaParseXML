package com.parse.jdom;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by HuangYog on 2015/2/3.
 * JDom 读写xml文件
 */
public class ReadAndWriteXML {

    public static void read(){
        try {
            boolean validate = false;
            SAXBuilder builder = new SAXBuilder(validate);
            InputStream in = ReadAndWriteXML.class.getClassLoader().getResourceAsStream("read.xml");
            Document doc = builder.build(in);
            Element root = doc.getRootElement();
            readNode(root,"");
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readNode(Element root, String prefix) {
        if (root==null)return ;
        //获取root下的属性
        List<Attribute> attrs = root.getAttributes();
        if (attrs!=null && attrs.size()>0){
            System.err.print(prefix);
            for (Attribute attr:attrs){
                System.err.print(attr.getValue() + " ");
            }
            System.err.println();//换行
        }
        //获取其他节点
        List<Element> childNodes = root.getChildren();
        prefix += "\t";
        for (Element e:childNodes){
            readNode(e,prefix);
        }
    }

    public static void write(){
        boolean validate = false;
        try {
            SAXBuilder builder = new SAXBuilder(validate);
            InputStream in = ReadAndWriteXML.class.getClassLoader().getResourceAsStream("read.xml");
            Document doc = builder.build(in);
            Element root = doc.getRootElement();
            root.setAttribute("name","tsu");
            boolean isRemoved = root.removeChildren("college");
            System.err.println(isRemoved);
            Element newCollege = new Element("college");
            newCollege.setAttribute("name","new_college");
            Element newClass = new Element("class");
            newClass.setAttribute("name","clazz");
            newCollege.addContent(newClass);
            root.addContent(newCollege);
            XMLOutputter out = new XMLOutputter();
            File file = new File("write.xml");
            if (file.exists()){
                file.delete();
            }
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            out.output(doc,fos);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
