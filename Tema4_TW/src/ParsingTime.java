import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import dom.DOMExample;
import sax.TextExtractor;

public class ParsingTime {
  private static String path;

  public static void main(String[] args) throws IOException {
    long startTimeDOM = System.currentTimeMillis();
    parseWithDOM();
    long stopTimeDOM = System.currentTimeMillis();
    long parsingTimeDOM = stopTimeDOM - startTimeDOM;

    long startTimeSAX = System.currentTimeMillis();
    parseWithSAX();
    long stopTimeSAX = System.currentTimeMillis();
    long parsingTimeSAX = stopTimeSAX - startTimeSAX;
    System.out.println();
    System.out.println();
    System.out.println();
    System.out.println("DOM PARSING TIME: " + parsingTimeDOM);
    System.out.println("SAX PARSING TIME: " + parsingTimeSAX);

  }

  private static void parseWithSAX() throws IOException {
    path = "movies.xml";
    try {
      XMLReader parser = XMLReaderFactory.createXMLReader();
      ContentHandler handler = new TextExtractor();
      parser.setContentHandler(handler);

      parser.parse(path);
      System.out.println(path + " is well-formed.");
    } catch (SAXException e) {
      System.out.println(path + " is not well-formed.");
    }
  }

  private static void parseWithDOM() {
    DOMExample iterator = new DOMExample();
    String argument = "resources/students.xml";
    try {
      // Use JAXP to find a parser
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      // Turn on namespace support
      factory.setNamespaceAware(true);
      DocumentBuilder parser = factory.newDocumentBuilder();

      // Read the entire document into memory
      Node document = parser.parse(argument);

      // Process it starting at the root
      iterator.followNode(document);
      System.out.println(argument + " is well-formed.");

    } catch (SAXException e) {
      System.out.println(argument + " is not well-formed.");
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e);
    } catch (ParserConfigurationException e) {
      System.out.println("Could not locate a JAXP parser");
    }
  }

}
