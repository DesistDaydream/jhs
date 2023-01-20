package com.jihuanshe.model;

import h.k2.v.u;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class UpdateReviewBody {
    @d
    private final String content;
    private final float score;

    public UpdateReviewBody() {
        this(null, 0.0f, 3, null);
    }

    public UpdateReviewBody(@d String str, float f2) {
        this.content = str;
        this.score = f2;
    }

    @d
    public final String getContent() {
        return this.content;
    }

    public final float getScore() {
        return this.score;
    }

    public /* synthetic */ UpdateReviewBody(String str, float f2, int i2, u uVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0.0f : f2);
    }
}
