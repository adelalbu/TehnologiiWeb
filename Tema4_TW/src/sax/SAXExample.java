
package sax;

import java.io.IOException;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class SAXExample {

  public static void main(String[] args) throws IOException {

    String argument = "movies.xml";
    try {
      XMLReader parser = XMLReaderFactory.createXMLReader();
      ContentHandler handler = new TextExtractor();
      parser.setContentHandler(handler);

      parser.parse(argument);
      System.out.println(argument + " is well-formed.");
    } catch (SAXException e) {
      System.out.println(argument + " is not well-formed.");
    }
  }

}