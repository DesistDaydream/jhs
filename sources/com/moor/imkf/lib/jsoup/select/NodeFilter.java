package com.moor.imkf.lib.jsoup.select;

import com.moor.imkf.lib.jsoup.nodes.Node;

/* loaded from: classes2.dex */
public interface NodeFilter {

    /* loaded from: classes2.dex */
    public enum FilterResult {
        CONTINUE,
        SKIP_CHILDREN,
        SKIP_ENTIRELY,
        REMOVE,
        STOP
    }

    FilterResult head(Node node, int i2);

    FilterResult tail(Node node, int i2);
}
