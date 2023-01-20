package com.moor.imkf.lib.jsoup.safety;

import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.nodes.Attribute;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.moor.imkf.lib.jsoup.nodes.DataNode;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.nodes.Element;
import com.moor.imkf.lib.jsoup.nodes.Node;
import com.moor.imkf.lib.jsoup.nodes.TextNode;
import com.moor.imkf.lib.jsoup.parser.ParseErrorList;
import com.moor.imkf.lib.jsoup.parser.Parser;
import com.moor.imkf.lib.jsoup.parser.Tag;
import com.moor.imkf.lib.jsoup.select.NodeTraversor;
import com.moor.imkf.lib.jsoup.select.NodeVisitor;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class Cleaner {
    private Whitelist whitelist;

    /* loaded from: classes2.dex */
    public final class CleaningVisitor implements NodeVisitor {
        private Element destination;
        private int numDiscarded;
        private final Element root;

        @Override // com.moor.imkf.lib.jsoup.select.NodeVisitor
        public void head(Node node, int i2) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (Cleaner.this.whitelist.isSafeTag(element.normalName())) {
                    ElementMeta createSafeElement = Cleaner.this.createSafeElement(element);
                    Element element2 = createSafeElement.el;
                    this.destination.appendChild(element2);
                    this.numDiscarded += createSafeElement.numAttribsDiscarded;
                    this.destination = element2;
                } else if (node != this.root) {
                    this.numDiscarded++;
                }
            } else if (node instanceof TextNode) {
                this.destination.appendChild(new TextNode(((TextNode) node).getWholeText()));
            } else if ((node instanceof DataNode) && Cleaner.this.whitelist.isSafeTag(node.parent().nodeName())) {
                this.destination.appendChild(new DataNode(((DataNode) node).getWholeData()));
            } else {
                this.numDiscarded++;
            }
        }

        @Override // com.moor.imkf.lib.jsoup.select.NodeVisitor
        public void tail(Node node, int i2) {
            if ((node instanceof Element) && Cleaner.this.whitelist.isSafeTag(node.nodeName())) {
                this.destination = this.destination.parent();
            }
        }

        private CleaningVisitor(Element element, Element element2) {
            this.numDiscarded = 0;
            this.root = element;
            this.destination = element2;
        }
    }

    /* loaded from: classes2.dex */
    public static class ElementMeta {
        public Element el;
        public int numAttribsDiscarded;

        public ElementMeta(Element element, int i2) {
            this.el = element;
            this.numAttribsDiscarded = i2;
        }
    }

    public Cleaner(Whitelist whitelist) {
        Validate.notNull(whitelist);
        this.whitelist = whitelist;
    }

    private int copySafeNodes(Element element, Element element2) {
        CleaningVisitor cleaningVisitor = new CleaningVisitor(element, element2);
        NodeTraversor.traverse(cleaningVisitor, element);
        return cleaningVisitor.numDiscarded;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ElementMeta createSafeElement(Element element) {
        String tagName = element.tagName();
        Attributes attributes = new Attributes();
        Element element2 = new Element(Tag.valueOf(tagName), element.baseUri(), attributes);
        Iterator<Attribute> it = element.attributes().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Attribute next = it.next();
            if (this.whitelist.isSafeAttribute(tagName, element, next)) {
                attributes.put(next);
            } else {
                i2++;
            }
        }
        attributes.addAll(this.whitelist.getEnforcedAttributes(tagName));
        return new ElementMeta(element2, i2);
    }

    public Document clean(Document document) {
        Validate.notNull(document);
        Document createShell = Document.createShell(document.baseUri());
        if (document.body() != null) {
            copySafeNodes(document.body(), createShell.body());
        }
        return createShell;
    }

    public boolean isValid(Document document) {
        Validate.notNull(document);
        return copySafeNodes(document.body(), Document.createShell(document.baseUri()).body()) == 0 && document.head().childNodes().isEmpty();
    }

    public boolean isValidBodyHtml(String str) {
        Document createShell = Document.createShell("");
        Document createShell2 = Document.createShell("");
        ParseErrorList tracking = ParseErrorList.tracking(1);
        createShell2.body().insertChildren(0, Parser.parseFragment(str, createShell2.body(), "", tracking));
        return copySafeNodes(createShell2.body(), createShell.body()) == 0 && tracking.isEmpty();
    }
}
