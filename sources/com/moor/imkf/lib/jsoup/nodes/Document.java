package com.moor.imkf.lib.jsoup.nodes;

import com.baidu.mobads.sdk.internal.a;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Entities;
import com.moor.imkf.lib.jsoup.parser.ParseSettings;
import com.moor.imkf.lib.jsoup.parser.Parser;
import com.moor.imkf.lib.jsoup.parser.Tag;
import com.moor.imkf.lib.jsoup.select.Elements;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class Document extends Element {
    private String location;
    private OutputSettings outputSettings;
    private Parser parser;
    private QuirksMode quirksMode;
    private boolean updateMetaCharset;

    /* loaded from: classes2.dex */
    public static class OutputSettings implements Cloneable {
        private Charset charset;
        public Entities.CoreCharset coreCharset;
        private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
        private ThreadLocal<CharsetEncoder> encoderThreadLocal = new ThreadLocal<>();
        private boolean prettyPrint = true;
        private boolean outline = false;
        private int indentAmount = 1;
        private Syntax syntax = Syntax.html;

        /* loaded from: classes2.dex */
        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            charset(Charset.forName("UTF8"));
        }

        public Charset charset() {
            return this.charset;
        }

        public CharsetEncoder encoder() {
            CharsetEncoder charsetEncoder = this.encoderThreadLocal.get();
            return charsetEncoder != null ? charsetEncoder : prepareEncoder();
        }

        public Entities.EscapeMode escapeMode() {
            return this.escapeMode;
        }

        public int indentAmount() {
            return this.indentAmount;
        }

        public boolean outline() {
            return this.outline;
        }

        public CharsetEncoder prepareEncoder() {
            CharsetEncoder newEncoder = this.charset.newEncoder();
            this.encoderThreadLocal.set(newEncoder);
            this.coreCharset = Entities.CoreCharset.byName(newEncoder.charset().name());
            return newEncoder;
        }

        public boolean prettyPrint() {
            return this.prettyPrint;
        }

        public Syntax syntax() {
            return this.syntax;
        }

        public OutputSettings charset(Charset charset) {
            this.charset = charset;
            return this;
        }

        /* renamed from: clone */
        public OutputSettings m35clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.charset(this.charset.name());
                outputSettings.escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
                return outputSettings;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }

        public OutputSettings escapeMode(Entities.EscapeMode escapeMode) {
            this.escapeMode = escapeMode;
            return this;
        }

        public OutputSettings indentAmount(int i2) {
            Validate.isTrue(i2 >= 0);
            this.indentAmount = i2;
            return this;
        }

        public OutputSettings outline(boolean z) {
            this.outline = z;
            return this;
        }

        public OutputSettings prettyPrint(boolean z) {
            this.prettyPrint = z;
            return this;
        }

        public OutputSettings syntax(Syntax syntax) {
            this.syntax = syntax;
            return this;
        }

        public OutputSettings charset(String str) {
            charset(Charset.forName(str));
            return this;
        }
    }

    /* loaded from: classes2.dex */
    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.valueOf("#root", ParseSettings.htmlDefault), str);
        this.outputSettings = new OutputSettings();
        this.quirksMode = QuirksMode.noQuirks;
        this.updateMetaCharset = false;
        this.location = str;
    }

    public static Document createShell(String str) {
        Validate.notNull(str);
        Document document = new Document(str);
        document.parser = document.parser();
        Element appendElement = document.appendElement(a.f1401f);
        appendElement.appendElement("head");
        appendElement.appendElement("body");
        return document;
    }

    private void ensureMetaCharsetElement() {
        if (this.updateMetaCharset) {
            OutputSettings.Syntax syntax = outputSettings().syntax();
            if (syntax == OutputSettings.Syntax.html) {
                Element first = select("meta[charset]").first();
                if (first != null) {
                    first.attr("charset", charset().displayName());
                } else {
                    Element head = head();
                    if (head != null) {
                        head.appendElement(TTDownloadField.TT_META).attr("charset", charset().displayName());
                    }
                }
                select("meta[name=charset]").remove();
            } else if (syntax == OutputSettings.Syntax.xml) {
                Node node = childNodes().get(0);
                if (node instanceof XmlDeclaration) {
                    XmlDeclaration xmlDeclaration = (XmlDeclaration) node;
                    if (xmlDeclaration.name().equals("xml")) {
                        xmlDeclaration.attr("encoding", charset().displayName());
                        if (xmlDeclaration.attr("version") != null) {
                            xmlDeclaration.attr("version", "1.0");
                            return;
                        }
                        return;
                    }
                    XmlDeclaration xmlDeclaration2 = new XmlDeclaration("xml", false);
                    xmlDeclaration2.attr("version", "1.0");
                    xmlDeclaration2.attr("encoding", charset().displayName());
                    prependChild(xmlDeclaration2);
                    return;
                }
                XmlDeclaration xmlDeclaration3 = new XmlDeclaration("xml", false);
                xmlDeclaration3.attr("version", "1.0");
                xmlDeclaration3.attr("encoding", charset().displayName());
                prependChild(xmlDeclaration3);
            }
        }
    }

    private Element findFirstElementByTagName(String str, Node node) {
        if (node.nodeName().equals(str)) {
            return (Element) node;
        }
        int childNodeSize = node.childNodeSize();
        for (int i2 = 0; i2 < childNodeSize; i2++) {
            Element findFirstElementByTagName = findFirstElementByTagName(str, node.childNode(i2));
            if (findFirstElementByTagName != null) {
                return findFirstElementByTagName;
            }
        }
        return null;
    }

    private void normaliseStructure(String str, Element element) {
        Elements elementsByTag = getElementsByTag(str);
        Element first = elementsByTag.first();
        if (elementsByTag.size() > 1) {
            ArrayList<Node> arrayList = new ArrayList();
            for (int i2 = 1; i2 < elementsByTag.size(); i2++) {
                Element element2 = elementsByTag.get(i2);
                arrayList.addAll(element2.ensureChildNodes());
                element2.remove();
            }
            for (Node node : arrayList) {
                first.appendChild(node);
            }
        }
        if (first.parent().equals(element)) {
            return;
        }
        element.appendChild(first);
    }

    private void normaliseTextNodes(Element element) {
        ArrayList arrayList = new ArrayList();
        for (Node node : element.childNodes) {
            if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                if (!textNode.isBlank()) {
                    arrayList.add(textNode);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Node node2 = (Node) arrayList.get(size);
            element.removeChild(node2);
            body().prependChild(new TextNode(ExpandableTextView.N));
            body().prependChild(node2);
        }
    }

    public Element body() {
        return findFirstElementByTagName("body", this);
    }

    public void charset(Charset charset) {
        updateMetaCharsetElement(true);
        this.outputSettings.charset(charset);
        ensureMetaCharsetElement();
    }

    public Element createElement(String str) {
        return new Element(Tag.valueOf(str, ParseSettings.preserveCase), baseUri());
    }

    public DocumentType documentType() {
        for (Node node : this.childNodes) {
            if (node instanceof DocumentType) {
                return (DocumentType) node;
            }
            if (!(node instanceof LeafNode)) {
                return null;
            }
        }
        return null;
    }

    public Element head() {
        return findFirstElementByTagName("head", this);
    }

    public String location() {
        return this.location;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Element, com.moor.imkf.lib.jsoup.nodes.Node
    public String nodeName() {
        return "#document";
    }

    public Document normalise() {
        Element findFirstElementByTagName = findFirstElementByTagName(a.f1401f, this);
        if (findFirstElementByTagName == null) {
            findFirstElementByTagName = appendElement(a.f1401f);
        }
        if (head() == null) {
            findFirstElementByTagName.prependElement("head");
        }
        if (body() == null) {
            findFirstElementByTagName.appendElement("body");
        }
        normaliseTextNodes(head());
        normaliseTextNodes(findFirstElementByTagName);
        normaliseTextNodes(this);
        normaliseStructure("head", findFirstElementByTagName);
        normaliseStructure("body", findFirstElementByTagName);
        ensureMetaCharsetElement();
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String outerHtml() {
        return super.html();
    }

    public OutputSettings outputSettings() {
        return this.outputSettings;
    }

    public Parser parser() {
        return this.parser;
    }

    public QuirksMode quirksMode() {
        return this.quirksMode;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Element
    public Element text(String str) {
        body().text(str);
        return this;
    }

    public String title() {
        Element first = getElementsByTag("title").first();
        return first != null ? StringUtil.normaliseWhitespace(first.text()).trim() : "";
    }

    public void updateMetaCharsetElement(boolean z) {
        this.updateMetaCharset = z;
    }

    public Document outputSettings(OutputSettings outputSettings) {
        Validate.notNull(outputSettings);
        this.outputSettings = outputSettings;
        return this;
    }

    public Document parser(Parser parser) {
        this.parser = parser;
        return this;
    }

    public Document quirksMode(QuirksMode quirksMode) {
        this.quirksMode = quirksMode;
        return this;
    }

    public boolean updateMetaCharsetElement() {
        return this.updateMetaCharset;
    }

    public void title(String str) {
        Validate.notNull(str);
        Element first = getElementsByTag("title").first();
        if (first == null) {
            head().appendElement("title").text(str);
        } else {
            first.text(str);
        }
    }

    public Charset charset() {
        return this.outputSettings.charset();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Element, com.moor.imkf.lib.jsoup.nodes.Node
    public Document clone() {
        Document document = (Document) super.clone();
        document.outputSettings = this.outputSettings.m35clone();
        return document;
    }
}
