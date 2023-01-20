package com.moor.imkf.lib.jsoup.nodes;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.moor.imkf.lib.jsoup.SerializationException;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Document;
import java.io.IOException;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class XmlDeclaration extends LeafNode {
    private final boolean isProcessingInstruction;

    public XmlDeclaration(String str, boolean z) {
        Validate.notNull(str);
        this.value = str;
        this.isProcessingInstruction = z;
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

    public String getWholeDeclaration() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        try {
            getWholeDeclaration(borrowBuilder, new Document.OutputSettings());
            return StringUtil.releaseBuilder(borrowBuilder).trim();
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public String name() {
        return coreValue();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String nodeName() {
        return "#declaration";
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(SimpleComparison.LESS_THAN_OPERATION).append(this.isProcessingInstruction ? "!" : "?").append(coreValue());
        getWholeDeclaration(appendable, outputSettings);
        appendable.append(this.isProcessingInstruction ? "!" : "?").append(SimpleComparison.GREATER_THAN_OPERATION);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
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
    public XmlDeclaration clone() {
        return (XmlDeclaration) super.m36clone();
    }

    private void getWholeDeclaration(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        Iterator<Attribute> it = attributes().iterator();
        while (it.hasNext()) {
            Attribute next = it.next();
            if (!next.getKey().equals(nodeName())) {
                appendable.append(' ');
                next.html(appendable, outputSettings);
            }
        }
    }
}
