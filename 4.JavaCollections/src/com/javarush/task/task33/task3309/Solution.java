package com.javarush.task.task33.task3309;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Комментарий внутри xml
*/

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException, IOException {
        StringBuilder sb = new StringBuilder();
        StringWriter writer = new StringWriter();

        JAXBContext context =JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(obj,writer);

        StringReader reader = new StringReader(writer.toString());
        BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null)
        {
            if (line.contains(tagName)){
                sb.append("<!--" + comment + "-->" + "\n");
            }
            sb.append(line + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws JAXBException, IOException {
        Test t = new Test();
        for (int i = 0; i < 10 ; i++) {
            t.second.add("some string" + i);
        }
        System.out.println(toXmlWithComment(t,"some","commnet"));
    }

    @XmlType(name = "test")
    @XmlRootElement
    public static class Test{
        public List<String> second = new ArrayList<>();
    }
}
