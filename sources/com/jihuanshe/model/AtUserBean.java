package com.jihuanshe.model;

import k.e.a.d;

/* loaded from: classes2.dex */
public final class AtUserBean {
    @d
    private AtRange range;
    private long userId;
    @d
    private String userName;

    /* loaded from: classes2.dex */
    public static final class AtRange {
        private int length;
        private int start;

        public final int getEnd() {
            return this.start + this.length;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getStart() {
            return this.start;
        }

        public final void setLength(int i2) {
            this.length = i2;
        }

        public final void setStart(int i2) {
            this.start = i2;
        }
    }

    public AtUserBean(long j2, @d String str, int i2, int i3) {
        this.userId = j2;
        this.userName = str;
        AtRange atRange = new AtRange();
        this.range = atRange;
        atRange.setStart(i2);
        this.range.setLength(i3);
    }

    @d
    public final AtRange getRange() {
        return this.range;
    }

    public final long getUserId() {
        return this.userId;
    }

    @d
    public final String getUserName() {
        return this.userName;
    }

    public final void setRange(@d AtRange atRange) {
        this.range = atRange;
    }

    public final void setUserId(long j2) {
        this.userId = j2;
    }

    public final void setUserName(@d String str) {
        this.userName = str;
    }
}
