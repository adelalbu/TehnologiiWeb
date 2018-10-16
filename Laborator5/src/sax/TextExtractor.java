package sax;
import org.xml.sax.*;
import java.io.*;

public class TextExtractor implements ContentHandler {
 
	public TextExtractor() { }
    
	// Handle the #PCDATA i.e. the text nodes
	public void characters(char[] text, int start, int length) throws SAXException {
		System.out.println("Found text node: ");
		System.out.println(new String(text).substring(start, start+length)); 		
    
	}  
    
	public void setDocumentLocator(Locator locator) {}
	// Handles the start of a document event.
	public void startDocument() {
		System.out.println("Entering document");
	}
	// Handles the end of a document event.
	public void endDocument() {
		System.out.println("Leaving document");
	}
	// Handles the beginning of the scope of a prefix-URI Namespace mapping.
	public void startPrefixMapping(String prefix, String uri) {}
	// Handles the ending of the scope of a prefix-URI Namespace mapping.
	public void endPrefixMapping(String prefix) {}
	// Triggers each time a start element is found.
	public void startElement(String namespaceURI, String localName,	String qualifiedName, Attributes atts) {
		System.out.println("Found element: " + localName);

		System.out.println("Attributes:");
		for (int i=0; i<atts.getLength(); i++) {
			System.out.println("Found attribute: " + atts.getLocalName(i) + " with value: " + atts.getValue(i));
		}
	}
	// Triggers each time an end element is found.
	public void endElement(String namespaceURI, String localName, String qualifiedName) {
		System.out.println("Leaving element: " + localName);
	}
	// Handles white characters.
	public void ignorableWhitespace(char[] text, int start, int length) throws SAXException {}
	// Handles the processing instruction. For example it can be called xml with version=1.0 and a certain encoding.
	public void processingInstruction(String target, String data){}
	// Handles a skipped entity.
	public void skippedEntity(String name) {}
}