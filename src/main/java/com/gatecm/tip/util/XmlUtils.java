package com.gatecm.tip.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


/**
 * Created by yaoguang on 2019/6/19 15:50.
 * Description:
 *
 * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
 */
public class XmlUtils {


    // 从本地读取XML
    public synchronized static Document read_local_XML(String filePath) {
        Document document = null;
        try {
            SAXReader r = new SAXReader();
            document = r.read(new FileInputStream(filePath));
        } catch (FileNotFoundException | DocumentException e) {
            System.out.println("读取失败：" + e.getMessage());
        }
        return document;
    }

    // 将XML写入本地
    public static void write_local_XML(Document document, String filePath) {
        try {
            XMLWriter w = new XMLWriter(new FileOutputStream(filePath));
            w.write(document);
        } catch (IOException e) {
            System.out.println("写入失败：" + e.getMessage());
        }
    }


}
