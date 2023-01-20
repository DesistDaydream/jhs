package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u001a\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001b\u0010\u0007\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\r\u0010\u000bR*\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\r\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\f\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u001f\u0010\u0015\"\u0004\b \u0010\u0017¨\u0006#"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;", "prop", "background", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "", "center", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "", "endAngle", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "size", "startAngle", "[Ljava/lang/Object;", "getCenter", "()[Ljava/lang/Object;", "setCenter", "([Ljava/lang/Object;)V", "Ljava/lang/Number;", "getStartAngle", "()Ljava/lang/Number;", "setStartAngle", "(Ljava/lang/Number;)V", "getSize", "setSize", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;", "getBackground", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;", "setBackground", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;)V", "getEndAngle", "setEndAngle", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAPane {
    @e
    private AABackground background;
    @e
    private Object[] center;
    @e
    private Number endAngle;
    @e
    private Number size;
    @e
    private Number startAngle;

    @d
    public final AAPane background(@e AABackground aABackground) {
        this.background = aABackground;
        return this;
    }

    @d
    public final AAPane center(@d Object[] objArr) {
        this.center = objArr;
        return this;
    }

    @d
    public final AAPane endAngle(@e Number number) {
        this.endAngle = number;
        return this;
    }

    @e
    public final AABackground getBackground() {
        return this.background;
    }

    @e
    public final Object[] getCenter() {
        return this.center;
    }

    @e
    public final Number getEndAngle() {
        return this.endAngle;
    }

    @e
    public final Number getSize() {
        return this.size;
    }

    @e
    public final Number getStartAngle() {
        return this.startAngle;
    }

    public final void setBackground(@e AABackground aABackground) {
        this.background = aABackground;
    }

    public final void setCenter(@e Object[] objArr) {
        this.center = objArr;
    }

    public final void setEndAngle(@e Number number) {
        this.endAngle = number;
    }

    public final void setSize(@e Number number) {
        this.size = number;
    }

    public final void setStartAngle(@e Number number) {
        this.startAngle = number;
    }

    @d
    public final AAPane size(@e Number number) {
        this.size = number;
        return this;
    }

    @d
    public final AAPane startAngle(@e Number number) {
        this.startAngle = number;
        return this;
    }
}
