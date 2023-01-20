package com.jihuanshe.model;

import k.e.a.d;

/* loaded from: classes2.dex */
public final class CommentBean {
    @d
    private String content;
    private int score;

    public CommentBean(int i2, @d String str) {
        this.score = i2;
        this.content = str;
    }

    @d
    public final String getContent() {
        return this.content;
    }

    public final int getScore() {
        return this.score;
    }

    public final void setContent(@d String str) {
        this.content = str;
    }

    public final void setScore(int i2) {
        this.score = i2;
    }
}
