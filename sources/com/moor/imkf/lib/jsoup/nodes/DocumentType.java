package com.moor.imkf.lib.jsoup.nodes;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.moor.imkf.lib.jsoup.helper.Validate;
import com.moor.imkf.lib.jsoup.internal.StringUtil;
import com.moor.imkf.lib.jsoup.nodes.Document;
import h.t2.y;
import java.io.IOException;

/* loaded from: classes2.dex */
public class DocumentType extends LeafNode {
    private static final String NAME = "name";
    private static final String PUBLIC_ID = "publicId";
    public static final String PUBLIC_KEY = "PUBLIC";
    private static final String PUB_SYS_KEY = "pubSysKey";
    private static final String SYSTEM_ID = "systemId";
    public static final String SYSTEM_KEY = "SYSTEM";

    public DocumentType(String str, String str2, String str3) {
        Validate.notNull(str);
        Validate.notNull(str2);
        Validate.notNull(str3);
        attr(NAME, str);
        attr(PUBLIC_ID, str2);
        attr(SYSTEM_ID, str3);
        updatePubSyskey();
    }

    private boolean has(String str) {
        return !StringUtil.isBlank(attr(str));
    }

    private void updatePubSyskey() {
        if (has(PUBLIC_ID)) {
            attr(PUB_SYS_KEY, PUBLIC_KEY);
        } else if (has(SYSTEM_ID)) {
            attr(PUB_SYS_KEY, SYSTEM_KEY);
        }
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

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public String name() {
        return attr(NAME);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public String nodeName() {
        return "#doctype";
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlHead(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.syntax() == Document.OutputSettings.Syntax.html && !has(PUBLIC_ID) && !has(SYSTEM_ID)) {
            appendable.append("<!doctype");
        } else {
            appendable.append("<!DOCTYPE");
        }
        if (has(NAME)) {
            appendable.append(ExpandableTextView.N).append(attr(NAME));
        }
        if (has(PUB_SYS_KEY)) {
            appendable.append(ExpandableTextView.N).append(attr(PUB_SYS_KEY));
        }
        if (has(PUBLIC_ID)) {
            appendable.append(" \"").append(attr(PUBLIC_ID)).append(y.a);
        }
        if (has(SYSTEM_ID)) {
            appendable.append(" \"").append(attr(SYSTEM_ID)).append(y.a);
        }
        appendable.append(y.f15692e);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.Node
    public void outerHtmlTail(Appendable appendable, int i2, Document.OutputSettings outputSettings) {
    }

    public String publicId() {
        return attr(PUBLIC_ID);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public void setPubSysKey(String str) {
        if (str != null) {
            attr(PUB_SYS_KEY, str);
        }
    }

    public String systemId() {
        return attr(SYSTEM_ID);
    }

    @Override // com.moor.imkf.lib.jsoup.nodes.LeafNode, com.moor.imkf.lib.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }
}
