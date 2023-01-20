package com.moor.imkf.lib.jsoup.nodes;

import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.parser.Tag;

/* loaded from: classes2.dex */
public class PseudoTextElement extends Element {
    public PseudoTextElement(Tag tag, String str, Attributes attributes) {
        super(tag, str, attributes);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Element, com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Element, com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }
}
