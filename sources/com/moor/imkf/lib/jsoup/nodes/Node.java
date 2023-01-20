package com.moor.imkf.lib.jsoup.nodes;

import com.moor.imkf.lib.jsoup.SerializationException;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.select.Elements;
import com.moor.imkf.lib.jsoup.select.NodeFilter;
import com.moor.imkf.lib.jsoup.select.NodeTraversor;
import com.moor.imkf.lib.jsoup.select.NodeVisitor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class Node implements Cloneable {
    public static final String EmptyString = "";
    public Node parentNode;
    public int siblingIndex;

    /* loaded from: classes2.dex */
    public static class OuterHtmlVisitor implements NodeVisitor {
        private Appendable accum;
        private Document.OutputSettings out;

        public OuterHtmlVisitor(Appendable appendable, Document.OutputSettings outputSettings) {
            this.accum = appendable;
            this.out = outputSettings;
            outputSettings.prepareEncoder();
        }

        @Override // com.moor.imkf.lib.jsoup.select.NodeVisitor
        public void head(Node node, int i2) {
            try {
                node.outerHtmlHead(this.accum, i2, this.out);
            } catch (IOException e2) {
                throw new SerializationException(e2);
            }
        }

        @Override // com.moor.imkf.lib.jsoup.select.NodeVisitor
        public void tail(Node node, int i2) {
            if (node.nodeName().equals("#text")) {
                return;
            }
            try {
                node.outerHtmlTail(this.accum, i2, this.out);
            } catch (IOException e2) {
                throw new SerializationException(e2);
            }
        }
    }

    private void addSiblingHtml(int i2, String str) {
        Validate.notNull(str);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(i2, (Node[]) NodeUtils.parser(this).parseFragmentInput(str, parent() instanceof Element ? (Element) parent() : null, baseUri()).toArray(new Node[0]));
    }

    private Element getDeepChild(Element element) {
        Elements children = element.children();
        return children.size() > 0 ? getDeepChild(children.get(0)) : element;
    }

    private void reindexChildren(int i2) {
        List<Node> ensureChildNodes = ensureChildNodes();
        while (i2 < ensureChildNodes.size()) {
            ensureChildNodes.get(i2).setSiblingIndex(i2);
            i2++;
        }
    }

    public String absUrl(String str) {
        Validate.notEmpty(str);
        return !hasAttr(str) ? "" : StringUtil.resolve(baseUri(), attr(str));
    }

    public void addChildren(Node... nodeArr) {
        List<Node> ensureChildNodes = ensureChildNodes();
        for (Node node : nodeArr) {
            reparentChild(node);
            ensureChildNodes.add(node);
            node.setSiblingIndex(ensureChildNodes.size() - 1);
        }
    }

    public Node after(String str) {
        addSiblingHtml(this.siblingIndex + 1, str);
        return this;
    }

    public String attr(String str) {
        Validate.notNull(str);
        if (hasAttributes()) {
            String ignoreCase = attributes().getIgnoreCase(str);
            return ignoreCase.length() > 0 ? ignoreCase : str.startsWith("abs:") ? absUrl(str.substring(4)) : "";
        }
        return "";
    }

    public abstract Attributes attributes();

    public abstract String baseUri();

    public Node before(String str) {
        addSiblingHtml(this.siblingIndex, str);
        return this;
    }

    public Node childNode(int i2) {
        return ensureChildNodes().get(i2);
    }

    public abstract int childNodeSize();

    public List<Node> childNodes() {
        return Collections.unmodifiableList(ensureChildNodes());
    }

    public Node[] childNodesAsArray() {
        return (Node[]) ensureChildNodes().toArray(new Node[0]);
    }

    public List<Node> childNodesCopy() {
        List<Node> ensureChildNodes = ensureChildNodes();
        ArrayList arrayList = new ArrayList(ensureChildNodes.size());
        for (Node node : ensureChildNodes) {
            arrayList.add(node.m36clone());
        }
        return arrayList;
    }

    public Node clearAttributes() {
        Iterator<Attribute> it = attributes().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        return this;
    }

    public Node doClone(Node node) {
        try {
            Node node2 = (Node) super.clone();
            node2.parentNode = node;
            node2.siblingIndex = node == null ? 0 : this.siblingIndex;
            return node2;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public abstract void doSetBaseUri(String str);

    public abstract Node empty();

    public abstract List<Node> ensureChildNodes();

    public boolean equals(Object obj) {
        return this == obj;
    }

    public Node filter(NodeFilter nodeFilter) {
        Validate.notNull(nodeFilter);
        NodeTraversor.filter(nodeFilter, this);
        return this;
    }

    public boolean hasAttr(String str) {
        Validate.notNull(str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if (attributes().hasKeyIgnoreCase(substring) && !absUrl(substring).equals("")) {
                return true;
            }
        }
        return attributes().hasKeyIgnoreCase(str);
    }

    public abstract boolean hasAttributes();

    public boolean hasParent() {
        return this.parentNode != null;
    }

    public boolean hasSameValue(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return outerHtml().equals(((Node) obj).outerHtml());
    }

    public <T extends Appendable> T html(T t) {
        outerHtml(t);
        return t;
    }

    public void indent(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append('\n').append(StringUtil.padding(i2 * outputSettings.indentAmount()));
    }

    public Node nextSibling() {
        Node node = this.parentNode;
        if (node == null) {
            return null;
        }
        List<Node> ensureChildNodes = node.ensureChildNodes();
        int i2 = this.siblingIndex + 1;
        if (ensureChildNodes.size() > i2) {
            return ensureChildNodes.get(i2);
        }
        return null;
    }

    public abstract String nodeName();

    public void nodelistChanged() {
    }

    public String outerHtml() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        outerHtml(borrowBuilder);
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public abstract void outerHtmlHead(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException;

    public abstract void outerHtmlTail(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException;

    public Document ownerDocument() {
        Node root = root();
        if (root instanceof Document) {
            return (Document) root;
        }
        return null;
    }

    public Node parent() {
        return this.parentNode;
    }

    public final Node parentNode() {
        return this.parentNode;
    }

    public Node previousSibling() {
        Node node = this.parentNode;
        if (node != null && this.siblingIndex > 0) {
            return node.ensureChildNodes().get(this.siblingIndex - 1);
        }
        return null;
    }

    public void remove() {
        Validate.notNull(this.parentNode);
        this.parentNode.removeChild(this);
    }

    public Node removeAttr(String str) {
        Validate.notNull(str);
        attributes().removeIgnoreCase(str);
        return this;
    }

    public void removeChild(Node node) {
        Validate.isTrue(node.parentNode == this);
        int i2 = node.siblingIndex;
        ensureChildNodes().remove(i2);
        reindexChildren(i2);
        node.parentNode = null;
    }

    public void reparentChild(Node node) {
        node.setParentNode(this);
    }

    public void replaceChild(Node node, Node node2) {
        Validate.isTrue(node.parentNode == this);
        Validate.notNull(node2);
        Node node3 = node2.parentNode;
        if (node3 != null) {
            node3.removeChild(node2);
        }
        int i2 = node.siblingIndex;
        ensureChildNodes().set(i2, node2);
        node2.parentNode = this;
        node2.setSiblingIndex(i2);
        node.parentNode = null;
    }

    public void replaceWith(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.replaceChild(this, node);
    }

    public Node root() {
        Node node = this;
        while (true) {
            Node node2 = node.parentNode;
            if (node2 == null) {
                return node;
            }
            node = node2;
        }
    }

    public void setBaseUri(String str) {
        Validate.notNull(str);
        doSetBaseUri(str);
    }

    public void setParentNode(Node node) {
        Validate.notNull(node);
        Node node2 = this.parentNode;
        if (node2 != null) {
            node2.removeChild(this);
        }
        this.parentNode = node;
    }

    public void setSiblingIndex(int i2) {
        this.siblingIndex = i2;
    }

    public Node shallowClone() {
        return doClone(null);
    }

    public int siblingIndex() {
        return this.siblingIndex;
    }

    public List<Node> siblingNodes() {
        Node node = this.parentNode;
        if (node == null) {
            return Collections.emptyList();
        }
        List<Node> ensureChildNodes = node.ensureChildNodes();
        ArrayList arrayList = new ArrayList(ensureChildNodes.size() - 1);
        for (Node node2 : ensureChildNodes) {
            if (node2 != this) {
                arrayList.add(node2);
            }
        }
        return arrayList;
    }

    public String toString() {
        return outerHtml();
    }

    public Node traverse(NodeVisitor nodeVisitor) {
        Validate.notNull(nodeVisitor);
        NodeTraversor.traverse(nodeVisitor, this);
        return this;
    }

    public Node unwrap() {
        Validate.notNull(this.parentNode);
        List<Node> ensureChildNodes = ensureChildNodes();
        Node node = ensureChildNodes.size() > 0 ? ensureChildNodes.get(0) : null;
        this.parentNode.addChildren(this.siblingIndex, childNodesAsArray());
        remove();
        return node;
    }

    public Node wrap(String str) {
        Validate.notEmpty(str);
        List<Node> parseFragmentInput = NodeUtils.parser(this).parseFragmentInput(str, parent() instanceof Element ? (Element) parent() : null, baseUri());
        Node node = parseFragmentInput.get(0);
        if (node instanceof Element) {
            Element element = (Element) node;
            Element deepChild = getDeepChild(element);
            this.parentNode.replaceChild(this, element);
            deepChild.addChildren(this);
            if (parseFragmentInput.size() > 0) {
                for (int i2 = 0; i2 < parseFragmentInput.size(); i2++) {
                    Node node2 = parseFragmentInput.get(i2);
                    node2.parentNode.removeChild(node2);
                    element.appendChild(node2);
                }
            }
            return this;
        }
        return null;
    }

    public Node after(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(this.siblingIndex + 1, node);
        return this;
    }

    public Node before(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.parentNode);
        this.parentNode.addChildren(this.siblingIndex, node);
        return this;
    }

    /* renamed from: clone */
    public Node m36clone() {
        Node doClone = doClone(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(doClone);
        while (!linkedList.isEmpty()) {
            Node node = (Node) linkedList.remove();
            int childNodeSize = node.childNodeSize();
            for (int i2 = 0; i2 < childNodeSize; i2++) {
                List<Node> ensureChildNodes = node.ensureChildNodes();
                Node doClone2 = ensureChildNodes.get(i2).doClone(node);
                ensureChildNodes.set(i2, doClone2);
                linkedList.add(doClone2);
            }
        }
        return doClone;
    }

    public void outerHtml(Appendable appendable) {
        NodeTraversor.traverse(new OuterHtmlVisitor(appendable, NodeUtils.outputSettings(this)), this);
    }

    public void addChildren(int i2, Node... nodeArr) {
        Validate.notNull(nodeArr);
        if (nodeArr.length == 0) {
            return;
        }
        List<Node> ensureChildNodes = ensureChildNodes();
        Node parent = nodeArr[0].parent();
        if (parent != null && parent.childNodeSize() == nodeArr.length) {
            List<Node> childNodes = parent.childNodes();
            int length = nodeArr.length;
            while (true) {
                int i3 = length - 1;
                if (length <= 0 || nodeArr[i3] != childNodes.get(i3)) {
                    break;
                }
                length = i3;
            }
            parent.empty();
            ensureChildNodes.addAll(i2, Arrays.asList(nodeArr));
            int length2 = nodeArr.length;
            while (true) {
                int i4 = length2 - 1;
                if (length2 > 0) {
                    nodeArr[i4].parentNode = this;
                    length2 = i4;
                } else {
                    reindexChildren(i2);
                    return;
                }
            }
        } else {
            Validate.noNullElements(nodeArr);
            for (Node node : nodeArr) {
                reparentChild(node);
            }
            ensureChildNodes.addAll(i2, Arrays.asList(nodeArr));
            reindexChildren(i2);
        }
    }

    public Node attr(String str, String str2) {
        attributes().putIgnoreCase(NodeUtils.parser(this).settings().normalizeAttribute(str), str2);
        return this;
    }
}
