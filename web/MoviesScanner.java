/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nuyuyii
 */
public class MoviesScanner {

    /**
     * org.w3c.dom.Document document
     */
    org.w3c.dom.Document document;

    /**
     * Create new MoviesScanner with org.w3c.dom.Document.
     */
    public MoviesScanner(org.w3c.dom.Document document) {
        this.document = document;
    }

    /**
     * Scan through org.w3c.dom.Document document.
     */
    public void visitDocument() {
        org.w3c.dom.Element element = document.getDocumentElement();
        if ((element != null) && element.getTagName().equals("movies")) {
            visitElement_movies(element);
        }
        if ((element != null) && element.getTagName().equals("film")) {
            visitElement_film(element);
        }
        if ((element != null) && element.getTagName().equals("title")) {
            visitElement_title(element);
        }
        if ((element != null) && element.getTagName().equals("year")) {
            visitElement_year(element);
        }
        if ((element != null) && element.getTagName().equals("types")) {
            visitElement_types(element);
        }
        if ((element != null) && element.getTagName().equals("type1")) {
            visitElement_type1(element);
        }
        if ((element != null) && element.getTagName().equals("time")) {
            visitElement_time(element);
        }
        if ((element != null) && element.getTagName().equals("director")) {
            visitElement_director(element);
        }
        if ((element != null) && element.getTagName().equals("type2")) {
            visitElement_type2(element);
        }
        if ((element != null) && element.getTagName().equals("type3")) {
            visitElement_type3(element);
        }
    }

    /**
     * Scan through org.w3c.dom.Element named movies.
     */
    void visitElement_movies(org.w3c.dom.Element element) {
        // <movies>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("film")) {
                        visitElement_film(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named film.
     */
    void visitElement_film(org.w3c.dom.Element element) {
        // <film>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("title")) {
                        visitElement_title(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("year")) {
                        visitElement_year(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("types")) {
                        visitElement_types(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("time")) {
                        visitElement_time(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("director")) {
                        visitElement_director(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named title.
     */
    void visitElement_title(org.w3c.dom.Element element) {
        // <title>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
                case org.w3c.dom.Node.TEXT_NODE:
                    // ((org.w3c.dom.Text)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named year.
     */
    void visitElement_year(org.w3c.dom.Element element) {
        // <year>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
                case org.w3c.dom.Node.TEXT_NODE:
                    // ((org.w3c.dom.Text)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named types.
     */
    void visitElement_types(org.w3c.dom.Element element) {
        // <types>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    if (nodeElement.getTagName().equals("type1")) {
                        visitElement_type1(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("type2")) {
                        visitElement_type2(nodeElement);
                    }
                    if (nodeElement.getTagName().equals("type3")) {
                        visitElement_type3(nodeElement);
                    }
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named type1.
     */
    void visitElement_type1(org.w3c.dom.Element element) {
        // <type1>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
                case org.w3c.dom.Node.TEXT_NODE:
                    // ((org.w3c.dom.Text)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named time.
     */
    void visitElement_time(org.w3c.dom.Element element) {
        // <time>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
                case org.w3c.dom.Node.TEXT_NODE:
                    // ((org.w3c.dom.Text)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named director.
     */
    void visitElement_director(org.w3c.dom.Element element) {
        // <director>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
                case org.w3c.dom.Node.TEXT_NODE:
                    // ((org.w3c.dom.Text)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named type2.
     */
    void visitElement_type2(org.w3c.dom.Element element) {
        // <type2>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
                case org.w3c.dom.Node.TEXT_NODE:
                    // ((org.w3c.dom.Text)node).getData();
                    break;
            }
        }
    }

    /**
     * Scan through org.w3c.dom.Element named type3.
     */
    void visitElement_type3(org.w3c.dom.Element element) {
        // <type3>
        // element.getValue();
        org.w3c.dom.NodeList nodes = element.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            org.w3c.dom.Node node = nodes.item(i);
            switch (node.getNodeType()) {
                case org.w3c.dom.Node.CDATA_SECTION_NODE:
                    // ((org.w3c.dom.CDATASection)node).getData();
                    break;
                case org.w3c.dom.Node.ELEMENT_NODE:
                    org.w3c.dom.Element nodeElement = (org.w3c.dom.Element) node;
                    break;
                case org.w3c.dom.Node.PROCESSING_INSTRUCTION_NODE:
                    // ((org.w3c.dom.ProcessingInstruction)node).getTarget();
                    // ((org.w3c.dom.ProcessingInstruction)node).getData();
                    break;
                case org.w3c.dom.Node.TEXT_NODE:
                    // ((org.w3c.dom.Text)node).getData();
                    break;
            }
        }
    }
    
}
