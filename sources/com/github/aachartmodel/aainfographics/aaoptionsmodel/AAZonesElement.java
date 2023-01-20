package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;", "", "", "prop", "value", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;", "color", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;", "fillColor", "", "dashStyle", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;", "Ljava/lang/Number;", "getValue", "()Ljava/lang/Number;", "setValue", "(Ljava/lang/Number;)V", "Ljava/lang/Object;", "getColor", "()Ljava/lang/Object;", "setColor", "(Ljava/lang/Object;)V", "getFillColor", "setFillColor", "Ljava/lang/String;", "getDashStyle", "()Ljava/lang/String;", "setDashStyle", "(Ljava/lang/String;)V", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAZonesElement {
    @e
    private Object color;
    @e
    private String dashStyle;
    @e
    private Object fillColor;
    @e
    private Number value;

    @d
    public final AAZonesElement color(@e Object obj) {
        this.color = obj;
        return this;
    }

    @d
    public final AAZonesElement dashStyle(@e String str) {
        this.dashStyle = str;
        return this;
    }

    @d
    public final AAZonesElement fillColor(@e Object obj) {
        this.fillColor = obj;
        return this;
    }

    @e
    public final Object getColor() {
        return this.color;
    }

    @e
    public final String getDashStyle() {
        return this.dashStyle;
    }

    @e
    public final Object getFillColor() {
        return this.fillColor;
    }

    @e
    public final Number getValue() {
        return this.value;
    }

    public final void setColor(@e Object obj) {
        this.color = obj;
    }

    public final void setDashStyle(@e String str) {
        this.dashStyle = str;
    }

    public final void setFillColor(@e Object obj) {
        this.fillColor = obj;
    }

    public final void setValue(@e Number number) {
        this.value = number;
    }

    @d
    public final AAZonesElement value(@e Number number) {
        this.value = number;
        return this;
    }
}
