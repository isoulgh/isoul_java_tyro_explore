package com.dong.old;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roger
 * @date 2020/5/29 10:18
 */
public class XMLTest {

    public static void main(String[] args) throws DocumentException, ParseException {
        SAXReader reader = new SAXReader();
        File file = new File("D:/test.xml");
        Document document = reader.read(file);
        Element root = document.getRootElement();
        List<Element> childs = root.elements();
        Student[] students = new Student[100];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        int length = 0;
        for (Element element : childs) {
            List<Element> cs = element.elements();
            Map<String, String> hashMap = new HashMap<>();
            for (Element element2 : cs) {
                hashMap.put(element2.getName(), element2.getText());
            }
            Student student = new Student(hashMap.get("sno"), hashMap.get("sname"), hashMap.get("ssex"), new Date(simpleDateFormat.parse(hashMap.get("sbirthday")).getTime()), Integer.parseInt(hashMap.get("sc")));
            students[length] = student;
            length++;
        }
        length--;

        //打印输出Student对象
        for (int i = 0; i <= length; i++) {
            System.out.println("-------------------");
            System.out.println(students[i]);
        }
    }

}
