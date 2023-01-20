package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\n\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\u0005R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "", "", "prop", "minHeight", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "minWidth", "", "opacity", "(Ljava/lang/Float;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "scrollPositionX", "scrollPositionY", "Ljava/lang/Float;", "getOpacity", "()Ljava/lang/Float;", "setOpacity", "(Ljava/lang/Float;)V", "Ljava/lang/Number;", "getScrollPositionX", "()Ljava/lang/Number;", "setScrollPositionX", "(Ljava/lang/Number;)V", "getMinHeight", "setMinHeight", "getMinWidth", "setMinWidth", "getScrollPositionY", "setScrollPositionY", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAScrollablePlotArea {
    @e
    private Number minHeight;
    @e
    private Number minWidth;
    @e
    private Float opacity;
    @e
    private Number scrollPositionX;
    @e
    private Number scrollPositionY;

    @e
    public final Number getMinHeight() {
        return this.minHeight;
    }

    @e
    public final Number getMinWidth() {
        return this.minWidth;
    }

    @e
    public final Float getOpacity() {
        return this.opacity;
    }

    @e
    public final Number getScrollPositionX() {
        return this.scrollPositionX;
    }

    @e
    public final Number getScrollPositionY() {
        return this.scrollPositionY;
    }

    @d
    public final AAScrollablePlotArea minHeight(@e Number number) {
        this.minHeight = number;
        return this;
    }

    @d
    public final AAScrollablePlotArea minWidth(@e Number number) {
        this.minWidth = number;
        return this;
    }

    @d
    public final AAScrollablePlotArea opacity(@e Float f2) {
        this.opacity = f2;
        return this;
    }

    @d
    public final AAScrollablePlotArea scrollPositionX(@e Number number) {
        this.scrollPositionX = number;
        return this;
    }

    @d
    public final AAScrollablePlotArea scrollPositionY(@e Number number) {
        this.scrollPositionY = number;
        return this;
    }

    public final void setMinHeight(@e Number number) {
        this.minHeight = number;
    }

    public final void setMinWidth(@e Number number) {
        this.minWidth = number;
    }

    public final void setOpacity(@e Float f2) {
        this.opacity = f2;
    }

    public final void setScrollPositionX(@e Number number) {
        this.scrollPositionX = number;
    }

    public final void setScrollPositionY(@e Number number) {
        this.scrollPositionY = number;
    }
}
