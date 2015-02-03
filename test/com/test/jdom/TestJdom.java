package com.test.jdom;

import com.parseXML.jdom.ReadAndWriteXML;
import org.junit.Test;

/**
 * Created by Top on 2015/2/3.
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
}
