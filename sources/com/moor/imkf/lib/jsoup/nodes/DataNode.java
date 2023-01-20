package com.moor.imkf.lib.jsoup.nodes;

import com.moor.imkf.lib.jsoup.nodes.Document;
import java.io.IOException;

/* loaded from: classes2.dex */
public class DataNode extends LeafNode {
    public DataNode(String str) {
        this.value = str;
    }

    public static DataNode createFromEncoded(String str, String str2) {
        return new DataNode(Entities.unescape(str));
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node attr(String str, String str2) {
        return super.attr(str, str2);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ int childNodeSize() {
        return super.childNodeSize();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node empty() {
        return super.empty();
    }

    public String getWholeData() {
        return coreValue();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String nodeName() {
        return "#data";
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(getWholeData());
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public DataNode setWholeData(String str) {
        coreValue(str);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public DataNode clone() {
        return (DataNode) super.m36clone();
    }
}
