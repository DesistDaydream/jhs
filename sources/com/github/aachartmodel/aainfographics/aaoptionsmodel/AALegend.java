package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLayoutType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartVerticalAlignType;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b-\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bA\u0010BJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0019\u0010\u0014J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001a\u0010\u0014J\u0017\u0010\u001b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001b\u0010\u000eJ\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001c\u0010\u0011R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010\u001a\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010'\u001a\u0004\b,\u0010)\"\u0004\b-\u0010+R$\u0010\u0007\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\"\u001a\u0004\b.\u0010$\"\u0004\b/\u0010&R$\u0010\n\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\"\u001a\u0004\b0\u0010$\"\u0004\b1\u0010&R$\u0010\u001b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001d\u001a\u0004\b2\u0010\u001f\"\u0004\b3\u0010!R$\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010'\u001a\u0004\b4\u0010)\"\u0004\b5\u0010+R$\u0010\u001c\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\"\u001a\u0004\b6\u0010$\"\u0004\b7\u0010&R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010\u0004\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\"\u001a\u0004\b=\u0010$\"\u0004\b>\u0010&R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010'\u001a\u0004\b?\u0010)\"\u0004\b@\u0010+¨\u0006C"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLayoutType;", "prop", "layout", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLayoutType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "align", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartVerticalAlignType;", "verticalAlign", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartVerticalAlignType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "", "enabled", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "", "borderColor", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "", "borderWidth", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "itemMarginTop", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;", "itemStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "x", "y", "floating", "labelFormat", "Ljava/lang/Boolean;", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "Ljava/lang/String;", "getBorderColor", "()Ljava/lang/String;", "setBorderColor", "(Ljava/lang/String;)V", "Ljava/lang/Number;", "getItemMarginTop", "()Ljava/lang/Number;", "setItemMarginTop", "(Ljava/lang/Number;)V", "getY", "setY", "getAlign", "setAlign", "getVerticalAlign", "setVerticalAlign", "getFloating", "setFloating", "getBorderWidth", "setBorderWidth", "getLabelFormat", "setLabelFormat", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;", "getItemStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;", "setItemStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAItemStyle;)V", "getLayout", "setLayout", "getX", "setX", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AALegend {
    @e
    private String align;
    @e
    private String borderColor;
    @e
    private Number borderWidth;
    @e
    private Boolean enabled;
    @e
    private Boolean floating;
    @e
    private Number itemMarginTop;
    @e
    private AAItemStyle itemStyle;
    @e
    private String labelFormat;
    @e
    private String layout;
    @e
    private String verticalAlign;
    @e
    private Number x;
    @e
    private Number y;

    @d
    public final AALegend align(@d AAChartAlignType aAChartAlignType) {
        this.align = aAChartAlignType.getValue();
        return this;
    }

    @d
    public final AALegend borderColor(@d String str) {
        this.borderColor = str;
        return this;
    }

    @d
    public final AALegend borderWidth(@e Number number) {
        this.borderWidth = number;
        return this;
    }

    @d
    public final AALegend enabled(@e Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @d
    public final AALegend floating(@e Boolean bool) {
        this.floating = bool;
        return this;
    }

    @e
    public final String getAlign() {
        return this.align;
    }

    @e
    public final String getBorderColor() {
        return this.borderColor;
    }

    @e
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @e
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @e
    public final Boolean getFloating() {
        return this.floating;
    }

    @e
    public final Number getItemMarginTop() {
        return this.itemMarginTop;
    }

    @e
    public final AAItemStyle getItemStyle() {
        return this.itemStyle;
    }

    @e
    public final String getLabelFormat() {
        return this.labelFormat;
    }

    @e
    public final String getLayout() {
        return this.layout;
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

    @d
    public final AALegend itemMarginTop(@e Number number) {
        this.itemMarginTop = number;
        return this;
    }

    @d
    public final AALegend itemStyle(@d AAItemStyle aAItemStyle) {
        this.itemStyle = aAItemStyle;
        return this;
    }

    @d
    public final AALegend labelFormat(@e String str) {
        this.labelFormat = str;
        return this;
    }

    @d
    public final AALegend layout(@d AAChartLayoutType aAChartLayoutType) {
        this.layout = aAChartLayoutType.getValue();
        return this;
    }

    public final void setAlign(@e String str) {
        this.align = str;
    }

    public final void setBorderColor(@e String str) {
        this.borderColor = str;
    }

    public final void setBorderWidth(@e Number number) {
        this.borderWidth = number;
    }

    public final void setEnabled(@e Boolean bool) {
        this.enabled = bool;
    }

    public final void setFloating(@e Boolean bool) {
        this.floating = bool;
    }

    public final void setItemMarginTop(@e Number number) {
        this.itemMarginTop = number;
    }

    public final void setItemStyle(@e AAItemStyle aAItemStyle) {
        this.itemStyle = aAItemStyle;
    }

    public final void setLabelFormat(@e String str) {
        this.labelFormat = str;
    }

    public final void setLayout(@e String str) {
        this.layout = str;
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
    public final AALegend verticalAlign(@d AAChartVerticalAlignType aAChartVerticalAlignType) {
        this.verticalAlign = aAChartVerticalAlignType.getValue();
        return this;
    }

    @d
    public final AALegend x(@e Number number) {
        this.x = number;
        return this;
    }

    @d
    public final AALegend y(@e Number number) {
        this.y = number;
        return this;
    }
}
