package com.moor.imkf.lib.jsoup.helper;

import com.baidu.mobads.sdk.internal.a;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Attribute;
import com.moor.imkf.lib.jsoup.nodes.Comment;
import com.moor.imkf.lib.jsoup.nodes.DataNode;
import com.moor.imkf.lib.jsoup.nodes.Node;
import com.moor.imkf.lib.jsoup.nodes.TextNode;
import com.moor.imkf.lib.jsoup.select.NodeTraversor;
import com.moor.imkf.lib.jsoup.select.NodeVisitor;
import com.xiaomi.mipush.sdk.Constants;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;

/* loaded from: classes2.dex */
public class W3CDom {
    public DocumentBuilderFactory factory;

    /* loaded from: classes2.dex */
    public static class W3CBuilder implements NodeVisitor {
        private static final String xmlnsKey = "xmlns";
        private static final String xmlnsPrefix = "xmlns:";
        private Element dest;
        private final Document doc;
        private final Stack<HashMap<String, String>> namespacesStack;

        public W3CBuilder(Document document) {
            Stack<HashMap<String, String>> stack = new Stack<>();
            this.namespacesStack = stack;
            this.doc = document;
            stack.push(new HashMap<>());
        }

        private void copyAttributes(Node node, Element element) {
            Iterator<Attribute> it = node.attributes().iterator();
            while (it.hasNext()) {
                Attribute next = it.next();
                String replaceAll = next.getKey().replaceAll("[^-a-zA-Z0-9_:.]", "");
                if (replaceAll.matches("[a-zA-Z_:][-a-zA-Z0-9_:.]*")) {
                    element.setAttribute(replaceAll, next.getValue());
                }
            }
        }

        private String updateNamespaces(com.moor.imkf.lib.jsoup.nodes.Element element) {
            Iterator<Attribute> it = element.attributes().iterator();
            while (true) {
                String str = "";
                if (!it.hasNext()) {
                    break;
                }
                Attribute next = it.next();
                String key = next.getKey();
                if (!key.equals(xmlnsKey)) {
                    if (key.startsWith(xmlnsPrefix)) {
                        str = key.substring(6);
                    }
                }
                this.namespacesStack.peek().put(str, next.getValue());
            }
            int indexOf = element.tagName().indexOf(Constants.COLON_SEPARATOR);
            return indexOf > 0 ? element.tagName().substring(0, indexOf) : "";
        }

        @Override // com.moor.imkf.lib.jsoup.select.NodeVisitor
        public void head(Node node, int i2) {
            Element createElementNS;
            this.namespacesStack.push(new HashMap<>(this.namespacesStack.peek()));
            if (node instanceof com.moor.imkf.lib.jsoup.nodes.Element) {
                com.moor.imkf.lib.jsoup.nodes.Element element = (com.moor.imkf.lib.jsoup.nodes.Element) node;
                String str = this.namespacesStack.peek().get(updateNamespaces(element));
                String tagName = element.tagName();
                if (str == null && tagName.contains(Constants.COLON_SEPARATOR)) {
                    createElementNS = this.doc.createElementNS("", tagName);
                } else {
                    createElementNS = this.doc.createElementNS(str, tagName);
                }
                copyAttributes(element, createElementNS);
                Element element2 = this.dest;
                if (element2 == null) {
                    this.doc.appendChild(createElementNS);
                } else {
                    element2.appendChild(createElementNS);
                }
                this.dest = createElementNS;
            } else if (node instanceof TextNode) {
                this.dest.appendChild(this.doc.createTextNode(((TextNode) node).getWholeText()));
            } else if (node instanceof Comment) {
                this.dest.appendChild(this.doc.createComment(((Comment) node).getData()));
            } else if (node instanceof DataNode) {
                this.dest.appendChild(this.doc.createTextNode(((DataNode) node).getWholeData()));
            }
        }

        @Override // com.moor.imkf.lib.jsoup.select.NodeVisitor
        public void tail(Node node, int i2) {
            if ((node instanceof com.moor.imkf.lib.jsoup.nodes.Element) && (this.dest.getParentNode() instanceof Element)) {
                this.dest = (Element) this.dest.getParentNode();
            }
            this.namespacesStack.pop();
        }
    }

    public W3CDom() {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        this.factory = newInstance;
        newInstance.setNamespaceAware(true);
    }

    public static HashMap<String, String> OutputHtml() {
        return methodMap(a.f1401f);
    }

    public static HashMap<String, String> OutputXml() {
        return methodMap("xml");
    }

    public static String asString(Document document, Map<String, String> map) {
        try {
            DOMSource dOMSource = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            StreamResult streamResult = new StreamResult(stringWriter);
            Transformer newTransformer = TransformerFactory.newInstance().newTransformer();
            if (map != null) {
                newTransformer.setOutputProperties(propertiesFromMap(map));
            }
            if (document.getDoctype() != null) {
                DocumentType doctype = document.getDoctype();
                if (!StringUtil.isBlank(doctype.getPublicId())) {
                    newTransformer.setOutputProperty("doctype-public", doctype.getPublicId());
                }
                if (!StringUtil.isBlank(doctype.getSystemId())) {
                    newTransformer.setOutputProperty("doctype-system", doctype.getSystemId());
                } else if (doctype.getName().equalsIgnoreCase(a.f1401f) && StringUtil.isBlank(doctype.getPublicId()) && StringUtil.isBlank(doctype.getSystemId())) {
                    newTransformer.setOutputProperty("doctype-system", "about:legacy-compat");
                }
            }
            newTransformer.transform(dOMSource, streamResult);
            return stringWriter.toString();
        } catch (TransformerException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Document convert(com.moor.imkf.lib.jsoup.nodes.Document document) {
        return new W3CDom().fromJsoup(document);
    }

    private static HashMap<String, String> methodMap(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(PushConstants.MZ_PUSH_MESSAGE_METHOD, str);
        return hashMap;
    }

    public static Properties propertiesFromMap(Map<String, String> map) {
        Properties properties = new Properties();
        properties.putAll(map);
        return properties;
    }

    public Document fromJsoup(com.moor.imkf.lib.jsoup.nodes.Document document) {
        Validate.notNull(document);
        try {
            DocumentBuilder newDocumentBuilder = this.factory.newDocumentBuilder();
            DOMImplementation dOMImplementation = newDocumentBuilder.getDOMImplementation();
            Document newDocument = newDocumentBuilder.newDocument();
            com.moor.imkf.lib.jsoup.nodes.DocumentType documentType = document.documentType();
            if (documentType != null) {
                newDocument.appendChild(dOMImplementation.createDocumentType(documentType.name(), documentType.publicId(), documentType.systemId()));
            }
            newDocument.setXmlStandalone(true);
            convert(document, newDocument);
            return newDocument;
        } catch (ParserConfigurationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public void convert(com.moor.imkf.lib.jsoup.nodes.Document document, Document document2) {
        if (!StringUtil.isBlank(document.location())) {
            document2.setDocumentURI(document.location());
        }
        NodeTraversor.traverse(new W3CBuilder(document2), document.child(0));
    }

    public String asString(Document document) {
        return asString(document, null);
    }
}
