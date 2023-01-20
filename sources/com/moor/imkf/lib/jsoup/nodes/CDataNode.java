package com.moor.imkf.lib.jsoup.nodes;

import com.moor.imkf.lib.jsoup.UncheckedIOException;
import com.moor.imkf.lib.jsoup.nodes.Document;
import java.io.IOException;

/* loaded from: classes2.dex */
public class CDataNode extends TextNode {
    public CDataNode(String str) {
        super(str);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.TextNode, com.moor.imkf.lib.jsoup.nodes.Node
    public String nodeName() {
        return "#cdata";
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.TextNode, com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        appendable.append("<![CDATA[").append(getWholeText());
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.TextNode, com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
        try {
            appendable.append("]]>");
        } catch (IOException e2) {
            throw new UncheckedIOException(e2);
        }
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.TextNode
    public String text() {
        return getWholeText();
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.TextNode, com.moor.imkf.lib.jsoup.nodes.Node
    public CDataNode clone() {
        return (CDataNode) super.clone();
    }
}
