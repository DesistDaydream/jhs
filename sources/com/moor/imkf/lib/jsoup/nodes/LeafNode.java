package com.moor.imkf.lib.jsoup.nodes;

import com.moor.imkf.lib.jsoup.helper.Validate;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class LeafNode extends Node {
    private static final List<Node> EmptyNodes = Collections.emptyList();
    public Object value;

    private void ensureAttributes() {
        if (hasAttributes()) {
            return;
        }
        Object obj = this.value;
        Attributes attributes = new Attributes();
        this.value = attributes;
        if (obj != null) {
            attributes.put(nodeName(), (String) obj);
        }
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String absUrl(String str) {
        ensureAttributes();
        return super.absUrl(str);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String attr(String str) {
        Validate.notNull(str);
        if (hasAttributes()) {
            return super.attr(str);
        }
        return str.equals(nodeName()) ? (String) this.value : "";
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public final Attributes attributes() {
        ensureAttributes();
        return (Attributes) this.value;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String baseUri() {
        return hasParent() ? parent().baseUri() : "";
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public int childNodeSize() {
        return 0;
    }

    public String coreValue() {
        return attr(nodeName());
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void doSetBaseUri(String str) {
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Node empty() {
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public List<Node> ensureChildNodes() {
        return EmptyNodes;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public boolean hasAttr(String str) {
        ensureAttributes();
        return super.hasAttr(str);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public final boolean hasAttributes() {
        return this.value instanceof Attributes;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Node removeAttr(String str) {
        ensureAttributes();
        return super.removeAttr(str);
    }

    public void coreValue(String str) {
        attr(nodeName(), str);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public LeafNode doClone(Node node) {
        LeafNode leafNode = (LeafNode) super.doClone(node);
        if (hasAttributes()) {
            leafNode.value = ((Attributes) this.value).m34clone();
        }
        return leafNode;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public Node attr(String str, String str2) {
        if (!hasAttributes() && str.equals(nodeName())) {
            this.value = str2;
        } else {
            ensureAttributes();
            super.attr(str, str2);
        }
        return this;
    }
}
