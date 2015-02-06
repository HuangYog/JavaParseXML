package com.parse.dom4j;

import org.dom4j.Attribute;
import org.dom4j.Element;
import org.dom4j.VisitorSupport;


/**
 * Created by HuangYog on 2015/2/5.
 */
public class MyVistor extends VisitorSupport {
    public void visit(Attribute node) {
        System.out.println("Attribute" + node.getName() + "=" + node.getValue());
    }

    public void visit(Element node) {
        if (node.isTextOnly()) {
            System.out.println("Element:" + node.getName() +
                    "=" + node.getText());
        } else {
            System.out.println(node.getName());
        }
    }

    @Override
    public void visit(org.dom4j.ProcessingInstruction node) {
        System.out.println("PI:" + node.getTarget() + " " + node.getText());

    }
}
