package com.moor.imkf.lib.jsoup.nodes;

import com.moor.imkf.lib.jsoup.nodes.Document;
import com.moor.imkf.lib.jsoup.parser.HtmlTreeBuilder;
import com.moor.imkf.lib.jsoup.parser.Parser;

/* loaded from: classes2.dex */
public final class NodeUtils {
    public static Document.OutputSettings outputSettings(Node node) {
        Document ownerDocument = node.ownerDocument();
        if (ownerDocument == null) {
            ownerDocument = new Document("");
        }
        return ownerDocument.outputSettings();
    }

    public static Parser parser(Node node) {
        Document ownerDocument = node.ownerDocument();
        return (ownerDocument == null || ownerDocument.parser() == null) ? new Parser(new HtmlTreeBuilder()) : ownerDocument.parser();
    }
}
