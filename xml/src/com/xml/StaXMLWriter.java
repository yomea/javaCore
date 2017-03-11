package com.xml;

import java.io.File;
import java.io.FileOutputStream;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

public class StaXMLWriter {
	
	
	public static void main(String[] args) throws Exception {
		
		XMLOutputFactory factory = XMLOutputFactory.newInstance();
		XMLStreamWriter writer  =factory.createXMLStreamWriter(new FileOutputStream(new File("src/book.xml")));
		writer.writeStartDocument("utf-8", "1.0");
		writer.writeStartElement("bookstore");
		writer.writeStartElement("book");
		writer.writeStartElement("name");
		writer.writeCharacters("水浒传");
		writer.writeEndElement();
		writer.writeEndElement();
		writer.writeEndElement();
		
		writer.flush();
		writer.close();
		
		
	}

}
