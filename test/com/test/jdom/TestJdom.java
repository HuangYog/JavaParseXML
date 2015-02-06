package com.test.jdom;

import com.parse.dom4j.Dom4JParse;
import com.parse.jdom.ReadAndWriteXML;
import org.junit.Test;

/**
 * Created by HuangYog on 2015/2/3.
 */
public class TestJdom {

    @Test
    public void testJdomRead(){
        ReadAndWriteXML.read();
    }

    @Test
    public void testJdomWrite(){
        ReadAndWriteXML.write();
    }

    @Test
    public void testDom4JRead1() {
        Dom4JParse.read1();
    }

    @Test
    public void testDom4JRead2() {
        Dom4JParse.read2();
    }

    @Test
    public void testDom4JWrite() {
        Dom4JParse.write();
    }

}
