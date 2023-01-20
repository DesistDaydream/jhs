package com.github.aachartmodel.aainfographics.aachartcreator;

import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAChart;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AACredits;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AALang;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AALegend;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAPane;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAPlotOptions;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AASubtitle;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AATitle;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AATooltip;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAXAxis;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAYAxis;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bR\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b|\u0010}J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0013\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\f0\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u001b\u0010\u0015\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u001a¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001d\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\"¢\u0006\u0004\b#\u0010$J\u001d\u0010%\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0012¢\u0006\u0004\b%\u0010\u001eJ\u0015\u0010'\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020&¢\u0006\u0004\b'\u0010(J\u0015\u0010*\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020)¢\u0006\u0004\b*\u0010+J\u0017\u0010-\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010,¢\u0006\u0004\b-\u0010.R$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR*\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010R\u001a\u0004\bS\u0010T\"\u0004\bU\u0010VR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R$\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b*\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010'\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR*\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR*\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010p\u001a\u0004\bz\u0010r\"\u0004\b{\u0010t¨\u0006~"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "prop", "chart", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "title", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASubtitle;", "subtitle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASubtitle;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "xAxis", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "yAxis", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "", "xAxisArray", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "yAxisArray", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "tooltip", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotOptions;", "plotOptions", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotOptions;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "series", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "legend", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "pane", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "colors", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "credits", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALang;", "defaultOptions", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALang;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "", "touchEventEnabled", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AAOptions;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "getLegend", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;", "setLegend", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALegend;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "getYAxis", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "setYAxis", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "getXAxis", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "setXAxis", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "getTitle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "setTitle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASubtitle;", "getSubtitle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASubtitle;", "setSubtitle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASubtitle;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "getTooltip", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "setTooltip", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;)V", "[Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "getYAxisArray", "()[Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;", "setYAxisArray", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAYAxis;)V", "[Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "getXAxisArray", "()[Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;", "setXAxisArray", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAXAxis;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "getPane", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;", "setPane", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPane;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALang;", "getDefaultOptions", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALang;", "setDefaultOptions", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALang;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "getChart", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "setChart", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotOptions;", "getPlotOptions", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotOptions;", "setPlotOptions", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotOptions;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "getCredits", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "setCredits", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;)V", "[Ljava/lang/Object;", "getColors", "()[Ljava/lang/Object;", "setColors", "([Ljava/lang/Object;)V", "Ljava/lang/Boolean;", "getTouchEventEnabled", "()Ljava/lang/Boolean;", "setTouchEventEnabled", "(Ljava/lang/Boolean;)V", "getSeries", "setSeries", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAOptions {
    @e
    private AAChart chart;
    @e
    private Object[] colors;
    @e
    private AACredits credits;
    @e
    private AALang defaultOptions;
    @e
    private AALegend legend;
    @e
    private AAPane pane;
    @e
    private AAPlotOptions plotOptions;
    @e
    private Object[] series;
    @e
    private AASubtitle subtitle;
    @e
    private AATitle title;
    @e
    private AATooltip tooltip;
    @e
    private Boolean touchEventEnabled;
    @e
    private AAXAxis xAxis;
    @e
    private AAXAxis[] xAxisArray;
    @e
    private AAYAxis yAxis;
    @e
    private AAYAxis[] yAxisArray;

    public AAOptions() {
        AACredits aACredits = new AACredits();
        aACredits.setEnabled(Boolean.FALSE);
        this.credits = aACredits;
    }

    @d
    public final AAOptions chart(@d AAChart aAChart) {
        this.chart = aAChart;
        return this;
    }

    @d
    public final AAOptions colors(@e Object[] objArr) {
        this.colors = objArr;
        return this;
    }

    @d
    public final AAOptions credits(@d AACredits aACredits) {
        this.credits = aACredits;
        return this;
    }

    @d
    public final AAOptions defaultOptions(@d AALang aALang) {
        this.defaultOptions = aALang;
        return this;
    }

    @e
    public final AAChart getChart() {
        return this.chart;
    }

    @e
    public final Object[] getColors() {
        return this.colors;
    }

    @e
    public final AACredits getCredits() {
        return this.credits;
    }

    @e
    public final AALang getDefaultOptions() {
        return this.defaultOptions;
    }

    @e
    public final AALegend getLegend() {
        return this.legend;
    }

    @e
    public final AAPane getPane() {
        return this.pane;
    }

    @e
    public final AAPlotOptions getPlotOptions() {
        return this.plotOptions;
    }

    @e
    public final Object[] getSeries() {
        return this.series;
    }

    @e
    public final AASubtitle getSubtitle() {
        return this.subtitle;
    }

    @e
    public final AATitle getTitle() {
        return this.title;
    }

    @e
    public final AATooltip getTooltip() {
        return this.tooltip;
    }

    @e
    public final Boolean getTouchEventEnabled() {
        return this.touchEventEnabled;
    }

    @e
    public final AAXAxis getXAxis() {
        return this.xAxis;
    }

    @e
    public final AAXAxis[] getXAxisArray() {
        return this.xAxisArray;
    }

    @e
    public final AAYAxis getYAxis() {
        return this.yAxis;
    }

    @e
    public final AAYAxis[] getYAxisArray() {
        return this.yAxisArray;
    }

    @d
    public final AAOptions legend(@d AALegend aALegend) {
        this.legend = aALegend;
        return this;
    }

    @d
    public final AAOptions pane(@e AAPane aAPane) {
        this.pane = aAPane;
        return this;
    }

    @d
    public final AAOptions plotOptions(@d AAPlotOptions aAPlotOptions) {
        this.plotOptions = aAPlotOptions;
        return this;
    }

    @d
    public final AAOptions series(@e Object[] objArr) {
        this.series = objArr;
        return this;
    }

    public final void setChart(@e AAChart aAChart) {
        this.chart = aAChart;
    }

    public final void setColors(@e Object[] objArr) {
        this.colors = objArr;
    }

    public final void setCredits(@e AACredits aACredits) {
        this.credits = aACredits;
    }

    public final void setDefaultOptions(@e AALang aALang) {
        this.defaultOptions = aALang;
    }

    public final void setLegend(@e AALegend aALegend) {
        this.legend = aALegend;
    }

    public final void setPane(@e AAPane aAPane) {
        this.pane = aAPane;
    }

    public final void setPlotOptions(@e AAPlotOptions aAPlotOptions) {
        this.plotOptions = aAPlotOptions;
    }

    public final void setSeries(@e Object[] objArr) {
        this.series = objArr;
    }

    public final void setSubtitle(@e AASubtitle aASubtitle) {
        this.subtitle = aASubtitle;
    }

    public final void setTitle(@e AATitle aATitle) {
        this.title = aATitle;
    }

    public final void setTooltip(@e AATooltip aATooltip) {
        this.tooltip = aATooltip;
    }

    public final void setTouchEventEnabled(@e Boolean bool) {
        this.touchEventEnabled = bool;
    }

    public final void setXAxis(@e AAXAxis aAXAxis) {
        this.xAxis = aAXAxis;
    }

    public final void setXAxisArray(@e AAXAxis[] aAXAxisArr) {
        this.xAxisArray = aAXAxisArr;
    }

    public final void setYAxis(@e AAYAxis aAYAxis) {
        this.yAxis = aAYAxis;
    }

    public final void setYAxisArray(@e AAYAxis[] aAYAxisArr) {
        this.yAxisArray = aAYAxisArr;
    }

    @d
    public final AAOptions subtitle(@d AASubtitle aASubtitle) {
        this.subtitle = aASubtitle;
        return this;
    }

    @d
    public final AAOptions title(@d AATitle aATitle) {
        this.title = aATitle;
        return this;
    }

    @d
    public final AAOptions tooltip(@d AATooltip aATooltip) {
        this.tooltip = aATooltip;
        return this;
    }

    @d
    public final AAOptions touchEventEnabled(@e Boolean bool) {
        this.touchEventEnabled = bool;
        return this;
    }

    @d
    public final AAOptions xAxis(@d AAXAxis aAXAxis) {
        this.xAxis = aAXAxis;
        return this;
    }

    @d
    public final AAOptions xAxisArray(@d AAXAxis[] aAXAxisArr) {
        this.xAxisArray = aAXAxisArr;
        return this;
    }

    @d
    public final AAOptions yAxis(@d AAYAxis aAYAxis) {
        this.yAxis = aAYAxis;
        return this;
    }

    @d
    public final AAOptions yAxisArray(@d AAYAxis[] aAYAxisArr) {
        this.yAxisArray = aAYAxisArr;
        return this;
    }
}
