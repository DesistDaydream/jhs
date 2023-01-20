package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0017\u0010\t\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u000b\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "", "", "prop", "align", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "verticalAlign", "", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "y", "x", "Ljava/lang/Number;", "getX", "()Ljava/lang/Number;", "setX", "(Ljava/lang/Number;)V", "getY", "setY", "Ljava/lang/String;", "getAlign", "()Ljava/lang/String;", "setAlign", "(Ljava/lang/String;)V", "getVerticalAlign", "setVerticalAlign", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAPosition {
    @e
    private String align;
    @e
    private String verticalAlign;
    @e
    private Number x;
    @e
    private Number y;

    @d
    public final AAPosition align(@e String str) {
        this.align = str;
        return this;
    }

    @e
    public final String getAlign() {
        return this.align;
    }

    @e
    public final String getVerticalAlign() {
        return this.verticalAlign;
    }

    @e
    public final Number getX() {
        return this.x;
    }

    @e
    public final Number getY() {
        return this.y;
    }

    public final void setAlign(@e String str) {
        this.align = str;
    }

    public final void setVerticalAlign(@e String str) {
        this.verticalAlign = str;
    }

    public final void setX(@e Number number) {
        this.x = number;
    }

    public final void setY(@e Number number) {
        this.y = number;
    }

    @d
    public final AAPosition verticalAlign(@e String str) {
        this.verticalAlign = str;
        return this;
    }

    @d
    public final AAPosition y(@e Number number) {
        this.y = number;
        return this;
    }

    @d
    public final AAPosition align(@e Number number) {
        this.x = number;
        return this;
    }
}
