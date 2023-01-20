package com.moor.imkf.lib.jsoup.nodes;

import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Document;

/* loaded from: classes2.dex */
public class TextNode extends LeafNode {
    public TextNode(String str) {
        this.value = str;
    }

    public static TextNode createFromEncoded(String str) {
        return new TextNode(Entities.unescape(str));
    }

    public static boolean lastCharIsWhitespace(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
    }

    public static String normaliseWhitespace(String str) {
        return StringUtil.normaliseWhitespace(str);
    }

    public static String stripLeadingWhitespace(String str) {
        return str.replaceFirst("^\\s+", "");
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

    public String getWholeText() {
        return coreValue();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public boolean isBlank() {
        return StringUtil.isBlank(coreValue());
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String nodeName() {
        return "#text";
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0022, code lost:
        if (isBlank() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0038, code lost:
        if (isBlank() == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x003a, code lost:
        indent(r10, r11, r12);
     */
    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void outerHtmlHead(java.lang.Appendable r10, int r11, com.moor.imkf.lib.jsoup.nodes.Document.OutputSettings r12) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r12.prettyPrint()
            if (r0 == 0) goto L3d
            int r1 = r9.siblingIndex()
            if (r1 != 0) goto L24
            com.moor.imkf.lib.jsoup.nodes.Node r1 = r9.parentNode
            boolean r2 = r1 instanceof com.moor.imkf.lib.jsoup.nodes.Element
            if (r2 == 0) goto L24
            com.moor.imkf.lib.jsoup.nodes.Element r1 = (com.moor.imkf.lib.jsoup.nodes.Element) r1
            com.moor.imkf.lib.jsoup.parser.Tag r1 = r1.tag()
            boolean r1 = r1.formatAsBlock()
            if (r1 == 0) goto L24
            boolean r1 = r9.isBlank()
            if (r1 == 0) goto L3a
        L24:
            boolean r1 = r12.outline()
            if (r1 == 0) goto L3d
            java.util.List r1 = r9.siblingNodes()
            int r1 = r1.size()
            if (r1 <= 0) goto L3d
            boolean r1 = r9.isBlank()
            if (r1 != 0) goto L3d
        L3a:
            r9.indent(r10, r11, r12)
        L3d:
            r11 = 1
            r1 = 0
            if (r0 == 0) goto L4b
            com.moor.imkf.lib.jsoup.nodes.Node r2 = r9.parentNode
            boolean r2 = com.moor.imkf.lib.jsoup.nodes.Element.preserveWhitespace(r2)
            if (r2 != 0) goto L4b
            r7 = 1
            goto L4c
        L4b:
            r7 = 0
        L4c:
            if (r0 == 0) goto L56
            com.moor.imkf.lib.jsoup.nodes.Node r0 = r9.parentNode
            boolean r0 = r0 instanceof com.moor.imkf.lib.jsoup.nodes.Document
            if (r0 == 0) goto L56
            r8 = 1
            goto L57
        L56:
            r8 = 0
        L57:
            java.lang.String r4 = r9.coreValue()
            r6 = 0
            r3 = r10
            r5 = r12
            com.moor.imkf.lib.jsoup.nodes.Entities.escape(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.moor.imkf.lib.jsoup.nodes.TextNode.outerHtmlHead(java.lang.Appendable, int, com.moor.imkf.lib.jsoup.nodes.Document$OutputSettings):void");
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public TextNode splitText(int i2) {
        String coreValue = coreValue();
        Validate.isTrue(i2 >= 0, "Split offset must be not be negative");
        Validate.isTrue(i2 < coreValue.length(), "Split offset must not be greater than current text length");
        String substring = coreValue.substring(0, i2);
        String substring2 = coreValue.substring(i2);
        text(substring);
        TextNode textNode = new TextNode(substring2);
        if (parent() != null) {
            parent().addChildren(siblingIndex() + 1, textNode);
        }
        return textNode;
    }

    public String text() {
        return StringUtil.normaliseWhitespace(getWholeText());
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String toString() {
        return outerHtml();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    public TextNode text(String str) {
        coreValue(str);
        return this;
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public TextNode clone() {
        return (TextNode) super.m36clone();
    }
}
