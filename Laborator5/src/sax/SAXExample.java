package sax;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;


public class SAXExample {

	public static void main(String[] args) throws IOException {
      
		String argument = "movies.xml";
		try {
			XMLReader parser = XMLReaderFactory.createXMLReader();
			ContentHandler handler = new TextExtractor();
			parser.setContentHandler(handler);

			parser.parse(argument);
			System.out.println(argument + " is well-formed.");
		}
		catch (SAXException e) {
			System.out.println(argument + " is not well-formed.");
		}
	}

}