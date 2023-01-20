package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLineDashStyleType;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACrosshair;", "", "", "prop", "width", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACrosshair;", "", "color", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACrosshair;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "dashStyle", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACrosshair;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "getDashStyle", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "setDashStyle", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;)V", "Ljava/lang/Number;", "getWidth", "()Ljava/lang/Number;", "setWidth", "(Ljava/lang/Number;)V", "Ljava/lang/String;", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AACrosshair {
    @e
    private String color;
    @e
    private AAChartLineDashStyleType dashStyle;
    @e
    private Number width;

    @d
    public final AACrosshair color(@d String str) {
        this.color = str;
        return this;
    }

    @d
    public final AACrosshair dashStyle(@d AAChartLineDashStyleType aAChartLineDashStyleType) {
        this.dashStyle = aAChartLineDashStyleType;
        return this;
    }

    @e
    public final String getColor() {
        return this.color;
    }

    @e
    public final AAChartLineDashStyleType getDashStyle() {
        return this.dashStyle;
    }

    @e
    public final Number getWidth() {
        return this.width;
    }

    public final void setColor(@e String str) {
        this.color = str;
    }

    public final void setDashStyle(@e AAChartLineDashStyleType aAChartLineDashStyleType) {
        this.dashStyle = aAChartLineDashStyleType;
    }

    public final void setWidth(@e Number number) {
        this.width = number;
    }

    @d
    public final AACrosshair width(@e Number number) {
        this.width = number;
        return this;
    }
}
