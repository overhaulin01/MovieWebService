//package ReadXML;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//transformer
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult;
//import static serverpack.mvWebService.callXML;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nuyuyii
 */
public class ReadXML {
    
    public static void main(String[] args) throws Exception {
        InputStream in = ReadXML.class.getResourceAsStream("/serverpack/movies.xml");
        //InputStream os = this.getResourceAsStream("web/movies.xml");
        File xmlFile = new File("web/movies.xml");
        //InputStream inS = ReadXML.class.getResourceAsStream("/serverpack/Updatemoviesj.xml");
        String filepath = "web/Updatemovies.xml";
        URL url = ReadXML.class.getResource("/serverpack/movies.xml"); //this.getClass().getResourceAsStream("myfile.txt");
        String path = url.getPath();
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(path);
        NodeList nList = doc.getElementsByTagName("film");
        System.out.println(url);
        
        //NodeList nList = doc.getElementsByTagName("film");
        //showNode(nList,60);
        //deleteElement(nList,"director",60);
        //deleteMovie(nList,60);
        //addMovie(doc, "boxset","$500",59);
        //showNode(nList,59);
        //getMovie(doc, "1", "Paypal", "Payment", "1000");
        //getMovie(doc, "Pete's Dragon ", "2016", "Animation,Adventure", 102, "David Lowery");
        //editMoive(doc,"Pete's Dragon ", "201", "Animation,Adventure,d", 102, "David Lowery", 60);
        //showNode(nList,60);
        // Use a Transformer for output
        // URL url = ReadXML.class.getResource("/serverpack/UpdatemoviesSr.xml"); 
        // String path = url.getPath();
        // System.out.println(path);
        String pp = searchQue1(doc, "time", "non-between", 2007, 2012);
        System.out.println(pp);
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File(filepath));
        //StreamResult result = new StreamResult(new FileOutputStream(xmlFile));
        //StreamResult result = new StreamResult(inS);//System.out);
        transformer.transform(source, result);
        
    }
    
    private static void showNode(NodeList nList,int nodeid){
          Element nfilm = (Element) nList.item(nodeid-1);
          NodeList childfilm = nfilm.getChildNodes();
          /*if (nfilm.getNodeType() == Node.ELEMENT_NODE) {
              //Print each employee's detail
              Element eElement = (Element) nfilm;
              //System.out.println("Employee id : "    + eElement.getAttribute("id"));
              System.out.println("First Namenfilm.removeChild(typ); : "  + eElement.getElementsByTagName("firstName").item(0).getTextContent());
              System.out.println("Last Name : "   + eElement.getElementsByTagName("lastName").item(0).getTextContent());
              System.out.println("Location : "    + eElement.getElementsByTagName("location").item(0).getTextContent());
          }*/
          for (int j= 0; j < childfilm.getLength(); j++){
            Node temp = childfilm.item(j);
            //System.out.println(temp.getNodeName());
            NodeList childtemp = temp.getChildNodes();
            if(childtemp.getLength() > 1){
                System.out.print(temp.getNodeName()+ ": ");                
                for (int i = 0; i<childtemp.getLength();i++){
                    Node child = childtemp.item(i);
                    NodeList childnode = child.getChildNodes();                    
                    if (i==1){                        
                        System.out.println(child.getTextContent());
                    }else if (childnode.getLength()>0){
                        System.out.println("       " 
                                + child.getTextContent());
                    }
                }
                
            //We got more childs; Let's visit them as well
            }else if(childtemp.getLength() > 0){
                System.out.println(temp.getNodeName() + ": " + temp.getTextContent());
            }
          }
          System.out.println("-----------------");
    }
    
    private static void searchMovie(NodeList nList, String search){
        System.out.println("\n\nsearch about : " + search);
        System.out.println("----------------------------");
        for (int i = 0; i < nList.getLength(); i++) {  //all film
                 Element film = (Element) nList.item(i);
                 NodeList childfilm = film.getChildNodes();  
                      for (int j= 0; j < childfilm.getLength(); j++){ //all node in film
                               Node temp = childfilm.item(j);
                               NodeList childElement = temp.getChildNodes();
                               if (childElement.getLength() > 1){ 
                                        for (int l=1; l<childElement.getLength();l++){  // For item(0) is types element
                                                 Node child = childElement.item(l);  // Start item(1) is type1 element
                                                 if (child.getTextContent().toLowerCase().contains(search.toLowerCase())){
                                      System.out.println(temp.getNodeName() + " ChildNode " + child.getNodeName()+ ": "
                                                                  + child.getTextContent()+",  nodeId: "+(i+1));
                                                 }
                                        }   //end forLoop l
                               }else if (temp.getTextContent().toLowerCase().contains(search.toLowerCase())){
                                        System.out.println(temp.getNodeName()+ ": "
                                           + temp.getTextContent()+",  nodeId: "+(i+1)); 
                               }
                      }  //end forLoop j
        }  //end forLoop i
    }  //end function
    
    private static void deleteElement(NodeList nList, String delname, int nodeid){
        Element nfilm = (Element) nList.item(nodeid-1);
        Node delNode = nfilm.getElementsByTagName(delname).item(0);
        nfilm.removeChild(delNode);
        System.out.println("XML file delete element successfully");
    }
    
    private static void deleteMovie(NodeList nList, int nodeid){
        Element nfilm = (Element) nList.item(nodeid-1);
        nfilm.getParentNode().removeChild(nfilm);
        System.out.println("XML file delete movie successfully");
    }
    
    private static void addElement(Document doc, String newname, String value, int nodeid) {
            NodeList film = doc.getElementsByTagName("film");
            Element nfilm = (Element) film.item(nodeid-1);
            Element newElement = doc.createElement(newname);
            newElement.appendChild(doc.createTextNode(value));
            nfilm.appendChild(newElement);
    }
    
    private static void updateElementValue(NodeList nList, String elementname, String newValue, int nodeid) {
          Element nfilm =  (Element) nList.item(nodeid-1);
          Node name = nfilm.getElementsByTagName(elementname).item(0).getFirstChild();
          name.setNodeValue(newValue);          
          System.out.println("XML file update movie successfully");
    }
    
    private static void editMoive(Document doc, String _title, String _year,String _types, int _time,String _director, int nodeid) {
        NodeList nList = doc.getElementsByTagName("film");
        String mins =_time+"min";
        Element nfilm =  (Element) nList.item(nodeid-1);
        Node title = nfilm.getElementsByTagName("title").item(0).getFirstChild();
        title.setNodeValue(_title);
        Node year = nfilm.getElementsByTagName("year").item(0).getFirstChild();
        year.setNodeValue(_year);    
        Node time = nfilm.getElementsByTagName("time").item(0).getFirstChild();
        time.setNodeValue(mins);  
        Node dir = nfilm.getElementsByTagName("director").item(0).getFirstChild();
        dir.setNodeValue(_director);  
        Node alltype = nfilm.getElementsByTagName("types").item(0);
        //nfilm.removeChild(typ);
        //nfilm.appendChild(getMovieElement(doc, "types", ""));
        //Element alltype = (Element) nfilm.item();
        NodeList atype = alltype.getChildNodes();
        //deleteElement(atype,"type1", 0);
        for (int i= 0; i < atype.getLength(); i++){ 
            Node child = atype.item(i);
            //Node up = atype.item(i);            
            //NodeList childElement = child.getChildNodes();
            if (child.getNodeName() == "type" ){
                alltype.removeChild(child);
            }/*else if(child.getNodeName() == "type2" ){
                alltype.removeChild(child);
            }else if(child.getNodeName() == "type3" ){
                alltype.removeChild(child);
            }*/
              // for (int l=1; l<childElement.getLength();l++){
                    System.out.println(child.getNodeName());
              //  }
            //}
            System.out.println(child.getNodeName());
            //alltype.removeChild(all);
        }
        for (String type: _types.split(",")){
            String name = "type";//+index;
            alltype.appendChild(getMovieElement(doc, name, type));
        }
        
        //nfilm.removeChild(alltype);
        System.out.println("XML file update movie successfully");
    }
    
    private static void addMovie(Document doc, String newname, String value, int nodeid) {
        NodeList film = doc.getElementsByTagName("film");
        Element nfilm = (Element) film.item(nodeid-1);
        Element newElement = doc.createElement(newname);
        newElement.appendChild(doc.createTextNode(value));
        //System.out.println("Insert OK");
        nfilm.appendChild(newElement);
    }
    private static void getMovie(Document doc, String title, String year, String types, int time, String director) {
        Element movie = (Element) doc.getDocumentElement();//getElementsByTagName("film");
        Element newfilm = doc.createElement("film");
        //newfilm.setAttribute("id", id);
        String mins = time+" min";
        newfilm.appendChild(getMovieElement(doc, "title", title));
        newfilm.appendChild(getMovieElement(doc, "year", year));
        newfilm.appendChild(getMovieElement(doc, "types", ""));
        newfilm.appendChild(getMovieElement(doc, "time", mins));
        newfilm.appendChild(getMovieElement(doc, "director", director));
        Element addtype = (Element) newfilm.getElementsByTagName("types").item(0);
        //Node addtype = 
        int index = 1;
        for (String type: types.split(",")){
            String name = "type"+index;
            addtype.appendChild(getMovieElement(doc, name, type));
            index++;
            //System.out.println(type);
        }
        // NodeList childfilm = newfilm.getChildNodes();
        //System.out.println("-----"+newfilm.getTextContent());
        movie.appendChild(newfilm);
        //return company;
    }
    private static Node getMovieElement(Document doc, String name, String value){
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        System.out.println("Insert OK "+node.getTextContent());
        return node;
    }
    private static String searchQue1(Document doc, String category, String conditon, int firstNum, int secondNum){
        System.out.println("\n\nsearch about: " + category +" condition: "+ conditon);
        System.out.println("----------------------------");
        String result="";
        //if(category.equals("year")){
        //String ff = String.valueOf(firstNum);
        //System.out.println(ff);
        //String ff={};      
        NodeList nList = doc.getElementsByTagName("film");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            Element eElement = (Element) nNode;
            Element nfilm =  (Element) nList.item(temp);
            NodeList childfilm = nfilm.getChildNodes();

            int prt = 0;
            int Intval = 0;
            String Strval = eElement.getElementsByTagName(category).item(0).getTextContent();
            if(category.equals("time")){
                String[] Tim = Strval.split(" min",2);
                Intval = Integer.valueOf(Tim[0]);
                System.out.println(temp+": "+Intval);

                
            }else{
                Intval = Integer.parseInt(Strval);
            }
            //System.out.println();
            /*if (conditon.equals("more")){
               if(Intval > firstNum ){
                    System.out.println(Intval);
                    prt = 1;
               }
            }else if(conditon.equals("little")){
               if(Intval < firstNum ){
                    System.out.println(Intval);
                    prt = 1;
               } 
            }else if(conditon.equals("between")){
               if(firstNum < Intval && Intval < secondNum){
                    System.out.println(Intval);
                    prt = 1;
               } 
            }else if(conditon.equals("non-between")){
               if(firstNum > Intval || Intval > secondNum){
                    System.out.println(Intval);
                    prt = 1;
               } 
            }  
            //String ff = String.valueOf(firstNum);
            if (prt == 1){
                //System.out.println("-----------------------------");
                result = result + "-----------------------------\n";
                result = result + "<table><tr><td> NODEID:</td><td> ::" + (temp+1)+"::";
                for (int j= 0; j < childfilm.getLength(); j++){
                Node cnode = childfilm.item(j);
                        NodeList childtemp = cnode.getChildNodes();
                        int p=0;
                        if(childtemp.getLength() > 1){
                            for (int i = 0; i<childtemp.getLength();i++){
                                Node child = childtemp.item(i);
                                NodeList childnode = child.getChildNodes();
                                if (p==0&&childnode.getLength()>0){
                                  //  result = String.format("%s</td></tr>\n<tr><td> %s:</td><td> %s ", result, cnode.getNodeName().toUpperCase(), child.getTextContent());
                                    p=1;
                                }else if (childnode.getLength()>0){
                                    result = String.format("%s,%s", result, child.getTextContent());
                                }
                            }

                            //We got more childs; Let's visit them as well
                        }else if(childtemp.getLength() > 0){
                        //    result = String.format("%s</td></tr>\n<tr><td> %s:</td><td> %s ", result, cnode.getNodeName().toUpperCase(), cnode.getTextContent());
                        } 

                    }
                    //result = result+"</td></tr></table>---\n";            
            }
            //int First = Integer.getInteger(Fnum);
            //if (eElement.getElementsByTagName(category).item(0).getTextContent().toLowerCase().contains(search.toLowerCase())) {       */   

        }
        return result;

    }
    private static String prnt(Document doc, String category, String conditon, int firstNum, int secondNum){
        String result="";
        return result;
    }

    
}