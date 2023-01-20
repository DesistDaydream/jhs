package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartZoomType;
import com.umeng.analytics.pro.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0004\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\bD\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bg\u0010hJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\nJ\u0017\u0010\u0012\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0007J\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0010J\u001d\u0010\u0017\u001a\u00020\u00002\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0016¢\u0006\u0004\b\u001b\u0010\u001aJ\u0015\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0016¢\u0006\u0004\b\u001c\u0010\u001aJ\u0015\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0016¢\u0006\u0004\b\u001d\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b$\u0010\nJ\u0017\u0010&\u001a\u00020\u00002\b\u0010&\u001a\u0004\u0018\u00010%¢\u0006\u0004\b&\u0010'J\u0017\u0010(\u001a\u00020\u00002\b\u0010(\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b(\u0010\u001aR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010$\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u0010\u001d\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010(\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u00103\u001a\u0004\b=\u00105\"\u0004\b>\u00107R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR$\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u00103\u001a\u0004\bN\u00105\"\u0004\bO\u00107R$\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010.\u001a\u0004\bP\u00100\"\u0004\bQ\u00102R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010.\u001a\u0004\bR\u00100\"\u0004\bS\u00102R$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR$\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u00103\u001a\u0004\bY\u00105\"\u0004\bZ\u00107R$\u0010\u0004\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010.\u001a\u0004\b[\u00100\"\u0004\b\\\u00102R$\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010I\u001a\u0004\b]\u0010K\"\u0004\b^\u0010MR$\u0010\u0013\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u00108\u001a\u0004\b_\u0010:\"\u0004\b`\u0010<R$\u0010\u0011\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010.\u001a\u0004\ba\u00100\"\u0004\bb\u00102R$\u0010\u0014\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010I\u001a\u0004\bc\u0010K\"\u0004\bd\u0010MR$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00103\u001a\u0004\be\u00105\"\u0004\bf\u00107¨\u0006i"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "prop", "type", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "backgroundColor", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "", "plotBackgroundImage", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;", "pinchType", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartZoomType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "", "panning", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "panKey", "polar", "animation", "inverted", "", "", "margin", "([Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "marginTop", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "marginRight", "marginBottom", "marginLeft", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "scrollablePlotArea", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;", "resetZoomButton", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "zoomType", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;", d.ar, "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChart;", "height", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "getScrollablePlotArea", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;", "setScrollablePlotArea", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAScrollablePlotArea;)V", "Ljava/lang/String;", "getZoomType", "()Ljava/lang/String;", "setZoomType", "(Ljava/lang/String;)V", "Ljava/lang/Number;", "getMarginLeft", "()Ljava/lang/Number;", "setMarginLeft", "(Ljava/lang/Number;)V", "Ljava/lang/Object;", "getBackgroundColor", "()Ljava/lang/Object;", "setBackgroundColor", "(Ljava/lang/Object;)V", "getHeight", "setHeight", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;", "getResetZoomButton", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;", "setResetZoomButton", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAResetZoomButton;)V", "[Ljava/lang/Number;", "getMargin", "()[Ljava/lang/Number;", "setMargin", "([Ljava/lang/Number;)V", "Ljava/lang/Boolean;", "getPanning", "()Ljava/lang/Boolean;", "setPanning", "(Ljava/lang/Boolean;)V", "getMarginTop", "setMarginTop", "getPinchType", "setPinchType", "getPlotBackgroundImage", "setPlotBackgroundImage", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;", "getEvents", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;", "setEvents", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;)V", "getMarginRight", "setMarginRight", "getType", "setType", "getPolar", "setPolar", "getAnimation", "setAnimation", "getPanKey", "setPanKey", "getInverted", "setInverted", "getMarginBottom", "setMarginBottom", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAChart {
    @e
    private Object animation;
    @e
    private Object backgroundColor;
    @e
    private AAChartEvents events;
    @e
    private Number height;
    @e
    private Boolean inverted;
    @e
    private Number[] margin;
    @e
    private Number marginBottom;
    @e
    private Number marginLeft;
    @e
    private Number marginRight;
    @e
    private Number marginTop;
    @e
    private String panKey;
    @e
    private Boolean panning;
    @e
    private String pinchType;
    @e
    private String plotBackgroundImage;
    @e
    private Boolean polar;
    @e
    private AAResetZoomButton resetZoomButton;
    @e
    private AAScrollablePlotArea scrollablePlotArea;
    @e
    private String type;
    @e
    private String zoomType;

    @k.e.a.d
    public final AAChart animation(@k.e.a.d Object obj) {
        this.animation = obj;
        return this;
    }

    @k.e.a.d
    public final AAChart backgroundColor(@e Object obj) {
        this.backgroundColor = obj;
        return this;
    }

    @k.e.a.d
    public final AAChart events(@e AAChartEvents aAChartEvents) {
        this.events = aAChartEvents;
        return this;
    }

    @e
    public final Object getAnimation() {
        return this.animation;
    }

    @e
    public final Object getBackgroundColor() {
        return this.backgroundColor;
    }

    @e
    public final AAChartEvents getEvents() {
        return this.events;
    }

    @e
    public final Number getHeight() {
        return this.height;
    }

    @e
    public final Boolean getInverted() {
        return this.inverted;
    }

    @e
    public final Number[] getMargin() {
        return this.margin;
    }

    @e
    public final Number getMarginBottom() {
        return this.marginBottom;
    }

    @e
    public final Number getMarginLeft() {
        return this.marginLeft;
    }

    @e
    public final Number getMarginRight() {
        return this.marginRight;
    }

    @e
    public final Number getMarginTop() {
        return this.marginTop;
    }

    @e
    public final String getPanKey() {
        return this.panKey;
    }

    @e
    public final Boolean getPanning() {
        return this.panning;
    }

    @e
    public final String getPinchType() {
        return this.pinchType;
    }

    @e
    public final String getPlotBackgroundImage() {
        return this.plotBackgroundImage;
    }

    @e
    public final Boolean getPolar() {
        return this.polar;
    }

    @e
    public final AAResetZoomButton getResetZoomButton() {
        return this.resetZoomButton;
    }

    @e
    public final AAScrollablePlotArea getScrollablePlotArea() {
        return this.scrollablePlotArea;
    }

    @e
    public final String getType() {
        return this.type;
    }

    @e
    public final String getZoomType() {
        return this.zoomType;
    }

    @k.e.a.d
    public final AAChart height(@e Number number) {
        this.height = number;
        return this;
    }

    @k.e.a.d
    public final AAChart inverted(@e Boolean bool) {
        this.inverted = bool;
        return this;
    }

    @k.e.a.d
    public final AAChart margin(@e Number[] numberArr) {
        this.margin = numberArr;
        return this;
    }

    @k.e.a.d
    public final AAChart marginBottom(@k.e.a.d Number number) {
        this.marginBottom = number;
        return this;
    }

    @k.e.a.d
    public final AAChart marginLeft(@k.e.a.d Number number) {
        this.marginLeft = number;
        return this;
    }

    @k.e.a.d
    public final AAChart marginRight(@k.e.a.d Number number) {
        this.marginRight = number;
        return this;
    }

    @k.e.a.d
    public final AAChart marginTop(@k.e.a.d Number number) {
        this.marginTop = number;
        return this;
    }

    @k.e.a.d
    public final AAChart panKey(@k.e.a.d String str) {
        this.panKey = str;
        return this;
    }

    @k.e.a.d
    public final AAChart panning(@e Boolean bool) {
        this.panning = bool;
        return this;
    }

    @k.e.a.d
    public final AAChart pinchType(@e AAChartZoomType aAChartZoomType) {
        this.pinchType = aAChartZoomType != null ? aAChartZoomType.getValue() : null;
        return this;
    }

    @k.e.a.d
    public final AAChart plotBackgroundImage(@k.e.a.d String str) {
        this.plotBackgroundImage = str;
        return this;
    }

    @k.e.a.d
    public final AAChart polar(@e Boolean bool) {
        this.polar = bool;
        return this;
    }

    @k.e.a.d
    public final AAChart resetZoomButton(@k.e.a.d AAResetZoomButton aAResetZoomButton) {
        this.resetZoomButton = aAResetZoomButton;
        return this;
    }

    @k.e.a.d
    public final AAChart scrollablePlotArea(@e AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
        return this;
    }

    public final void setAnimation(@e Object obj) {
        this.animation = obj;
    }

    public final void setBackgroundColor(@e Object obj) {
        this.backgroundColor = obj;
    }

    public final void setEvents(@e AAChartEvents aAChartEvents) {
        this.events = aAChartEvents;
    }

    public final void setHeight(@e Number number) {
        this.height = number;
    }

    public final void setInverted(@e Boolean bool) {
        this.inverted = bool;
    }

    public final void setMargin(@e Number[] numberArr) {
        this.margin = numberArr;
    }

    public final void setMarginBottom(@e Number number) {
        this.marginBottom = number;
    }

    public final void setMarginLeft(@e Number number) {
        this.marginLeft = number;
    }

    public final void setMarginRight(@e Number number) {
        this.marginRight = number;
    }

    public final void setMarginTop(@e Number number) {
        this.marginTop = number;
    }

    public final void setPanKey(@e String str) {
        this.panKey = str;
    }

    public final void setPanning(@e Boolean bool) {
        this.panning = bool;
    }

    public final void setPinchType(@e String str) {
        this.pinchType = str;
    }

    public final void setPlotBackgroundImage(@e String str) {
        this.plotBackgroundImage = str;
    }

    public final void setPolar(@e Boolean bool) {
        this.polar = bool;
    }

    public final void setResetZoomButton(@e AAResetZoomButton aAResetZoomButton) {
        this.resetZoomButton = aAResetZoomButton;
    }

    public final void setScrollablePlotArea(@e AAScrollablePlotArea aAScrollablePlotArea) {
        this.scrollablePlotArea = aAScrollablePlotArea;
    }

    public final void setType(@e String str) {
        this.type = str;
    }

    public final void setZoomType(@e String str) {
        this.zoomType = str;
    }

    @k.e.a.d
    public final AAChart type(@e AAChartType aAChartType) {
        this.type = aAChartType != null ? aAChartType.getValue() : null;
        return this;
    }

    @k.e.a.d
    public final AAChart zoomType(@e String str) {
        this.zoomType = str;
        return this;
    }
}
