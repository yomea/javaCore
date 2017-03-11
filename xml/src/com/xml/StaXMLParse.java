package com.xml;

import java.io.File;
import java.io.FileInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;

public class StaXMLParse {

	public static void main(String[] args) throws Exception {

		File file = new File("src/test.xml");

		XMLInputFactory factory = XMLInputFactory.newInstance();
		XMLStreamReader parser = factory.createXMLStreamReader(new FileInputStream(file));
		while (parser.hasNext()) {
			int event = parser.next();
			if (event == XMLStreamConstants.START_ELEMENT) {

				if (parser.getName().toString().equals("name")) {
					/**
					 * 红楼梦 西游记
					 */
					System.out.print(parser.getElementText() + "-->");
				}

				if (parser.getName().toString().equals("author")) {
					/**
					 * 罗贯中 
					 * 吴承恩
					 */
					System.out.println(parser.getElementText());
				}

			}

		}

	}

}
