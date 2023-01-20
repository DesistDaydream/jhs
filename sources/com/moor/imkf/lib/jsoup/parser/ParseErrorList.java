package com.moor.imkf.lib.jsoup.parser;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ParseErrorList extends ArrayList<ParseError> {
    private static final int INITIAL_CAPACITY = 16;
    private final int maxSize;

    public ParseErrorList(int i2, int i3) {
        super(i2);
        this.maxSize = i3;
    }

    public static ParseErrorList noTracking() {
        return new ParseErrorList(0, 0);
    }

    public static ParseErrorList tracking(int i2) {
        return new ParseErrorList(16, i2);
    }

    public boolean canAddError() {
        return size() < this.maxSize;
    }

    public int getMaxSize() {
        return this.maxSize;
    }
}
