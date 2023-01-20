package com.moor.imkf.lib.jsoup.nodes;

import com.j256.ormlite.stmt.query.SimpleComparison;
import com.moor.imkf.lib.jsoup.Jsoup;
import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.parser.Parser;

/* loaded from: classes2.dex */
public class Comment extends LeafNode {
    public Comment(String str) {
        this.value = str;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    public XmlDeclaration asXmlDeclaration() {
        String data = getData();
        Document parse = Jsoup.parse(SimpleComparison.LESS_THAN_OPERATION + data.substring(1, data.length() - 1) + SimpleComparison.GREATER_THAN_OPERATION, baseUri(), Parser.xmlParser());
        if (parse.children().size() > 0) {
            Element child = parse.child(0);
            XmlDeclaration xmlDeclaration = new XmlDeclaration(NodeUtils.parser(parse).settings().normalizeTag(child.tagName()), data.startsWith("!"));
            xmlDeclaration.attributes().addAll(child.attributes());
            return xmlDeclaration;
        }
        return null;
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

    public String getData() {
        return coreValue();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public boolean isXmlDeclaration() {
        String data = getData();
        return data.length() > 1 && (data.startsWith("!") || data.startsWith("?"));
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String nodeName() {
        return "#comment";
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0022, code lost:
        if (r5.outline() != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        indent(r3, r4, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (((com.moor.imkf.lib.jsoup.nodes.Element) r0).tag().formatAsBlock() != false) goto L9;
     */
    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void outerHtmlHead(java.lang.Appendable r3, int r4, com.moor.imkf.lib.jsoup.nodes.Document.OutputSettings r5) throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r5.prettyPrint()
            if (r0 == 0) goto L27
            int r0 = r2.siblingIndex()
            if (r0 != 0) goto L1e
            com.moor.imkf.lib.jsoup.nodes.Node r0 = r2.parentNode
            boolean r1 = r0 instanceof com.moor.imkf.lib.jsoup.nodes.Element
            if (r1 == 0) goto L1e
            com.moor.imkf.lib.jsoup.nodes.Element r0 = (com.moor.imkf.lib.jsoup.nodes.Element) r0
            com.moor.imkf.lib.jsoup.parser.Tag r0 = r0.tag()
            boolean r0 = r0.formatAsBlock()
            if (r0 != 0) goto L24
        L1e:
            boolean r0 = r5.outline()
            if (r0 == 0) goto L27
        L24:
            r2.indent(r3, r4, r5)
        L27:
            java.lang.String r4 = "<!--"
            java.lang.Appendable r3 = r3.append(r4)
            java.lang.String r4 = r2.getData()
            java.lang.Appendable r3 = r3.append(r4)
            java.lang.String r4 = "-->"
            r3.append(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.jsoup.nodes.Comment.outerHtmlHead(java.lang.Appendable, int, com.moor.imkf.lib.jsoup.nodes.Document$OutputSettings):void");
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public Comment setData(String str) {
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
    public Comment clone() {
        return (Comment) super.m36clone();
    }
}
