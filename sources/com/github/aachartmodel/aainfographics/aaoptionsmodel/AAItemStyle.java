package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartFontWeightType;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;", "", "", "prop", "color", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;", "cursor", "pointer", "", "fontSize", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartFontWeightType;", "fontWeight", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartFontWeightType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;", "Ljava/lang/String;", "getFontSize", "()Ljava/lang/String;", "setFontSize", "(Ljava/lang/String;)V", "getPointer", "setPointer", "getCursor", "setCursor", "getFontWeight", "setFontWeight", "getColor", "setColor", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAItemStyle {
    @e
    private String color;
    @e
    private String cursor;
    @e
    private String fontSize;
    @e
    private String fontWeight;
    @e
    private String pointer;

    @d
    public final AAItemStyle color(@e String str) {
        this.color = str;
        return this;
    }

    @d
    public final AAItemStyle cursor(@d String str) {
        this.cursor = str;
        return this;
    }

    @d
    public final AAItemStyle fontSize(@e Number number) {
        if (number != null) {
            this.fontSize = number + "px";
        }
        return this;
    }

    @d
    public final AAItemStyle fontWeight(@e AAChartFontWeightType aAChartFontWeightType) {
        this.fontWeight = aAChartFontWeightType != null ? aAChartFontWeightType.getValue() : null;
        return this;
    }

    @e
    public final String getColor() {
        return this.color;
    }

    @e
    public final String getCursor() {
        return this.cursor;
    }

    @e
    public final String getFontSize() {
        return this.fontSize;
    }

    @e
    public final String getFontWeight() {
        return this.fontWeight;
    }

    @e
    public final String getPointer() {
        return this.pointer;
    }

    @d
    public final AAItemStyle pointer(@d String str) {
        this.pointer = str;
        return this;
    }

    public final void setColor(@e String str) {
        this.color = str;
    }

    public final void setCursor(@e String str) {
        this.cursor = str;
    }

    public final void setFontSize(@e String str) {
        this.fontSize = str;
    }

    public final void setFontWeight(@e String str) {
        this.fontWeight = str;
    }

    public final void setPointer(@e String str) {
        this.pointer = str;
    }
}
