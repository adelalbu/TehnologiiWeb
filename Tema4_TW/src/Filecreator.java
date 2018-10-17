import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Filecreator {

  public static void main(String[] av) throws TransformerException {
    Filecreator dc = new Filecreator();
    Document doc = dc.makeXML();

    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    StreamResult result = new StreamResult(new File("movies_dom.xml"));
    DOMSource source = new DOMSource(doc);
    transformer.transform(source, result);
  }

  public Document makeXML() {
    try {

      DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
      DocumentBuilder parser = fact.newDocumentBuilder();
      Document doc = parser.newDocument();

      Node root = doc.createElement("superheroMovies");
      doc.appendChild(root);

      createMovie(doc, root, "Spider-Man", "USA", "2002", "121", "Sam Raimi");
      createMovie(doc, root, "Hulk", "USA", "2003", "138", "Ang Lee");
      createMovie(doc, root, "Iron Man", "USA", "2008", "126", "Jon Favreau");
      createMovie(doc, root, "Thor", "USA", "2011", "115", "Kenneth Branagh");
      createMovie(doc, root, "The Avengers", "USA", "2012", "143", "Joss Whedon");
      createMovie(doc, root, "Deadpool", "USA", "2016", "108", "Tim Miller");

      return doc;

    } catch (Exception ex) {
      ex.printStackTrace();
      return null;
    }
  }

  private void createMovie(Document doc, Node root, String nume, String tara, String an, String timp, String regizor) {
    Node movies = doc.createElement("movie");
    Node name = doc.createElement("name");
    name.appendChild(doc.createTextNode(nume));
    Node details = doc.createElement("details");
    Node country = doc.createElement("country");
    country.appendChild(doc.createTextNode(tara));
    Node relaseyear = doc.createElement("relaseyear");
    relaseyear.appendChild(doc.createTextNode(an));
    Node runtime = doc.createElement("runtime");
    runtime.appendChild(doc.createTextNode(timp));
    details.appendChild(country);
    details.appendChild(relaseyear);
    details.appendChild(runtime);
    Node director = doc.createElement("director");
    director.appendChild(doc.createTextNode(regizor));
    movies.appendChild(name);
    movies.appendChild(details);
    movies.appendChild(director);
    root.appendChild(movies);
  }

}
