package com.github.aachartmodel.aainfographics.aachartcreator;

import com.github.aachartmodel.aainfographics.aaoptionsmodel.AADataLabels;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAMarker;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AATooltip;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAZonesElement;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bP\u0010QJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\r\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0012\u0010\u000bJ\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0014\u0010\u0011J\u0017\u0010\u0015\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0017\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0018\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0019\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001a\u0010\u0016J\u0017\u0010\u001b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001b\u0010\u0016J\u0017\u0010\u001d\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u001f\u0010\u0011J\u0017\u0010 \u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b \u0010\u000bJ\u0017\u0010!\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b!\u0010\u0016J\u0017\u0010\"\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\"\u0010\u0016J\u0017\u0010#\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b#\u0010\u0016J\u0017\u0010%\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010$¢\u0006\u0004\b%\u0010&J\u0017\u0010(\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010*¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010-¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b0\u0010\u0016J\u0017\u00101\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b1\u0010\u0016J\u0017\u00102\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b2\u0010\bJ\u0017\u00103\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010'¢\u0006\u0004\b3\u0010)J\u001b\u00105\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002040\f¢\u0006\u0004\b5\u00106J\u0017\u00107\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b7\u0010\u000bJ\u0017\u00109\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u000108¢\u0006\u0004\b9\u0010:J\u0017\u0010;\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b;\u0010\u000bJ\u0017\u0010=\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010<¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b?\u0010\bJ\u0017\u0010@\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b@\u0010\bJ\u0017\u0010A\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bA\u0010\bJ\u0017\u0010B\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\bB\u0010\u000bJ\u0017\u0010C\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\bC\u0010\bR\u0018\u00103\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u0010DR\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010ER\u0018\u0010\"\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010FR\u0018\u0010#\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010FR\u0018\u00101\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010FR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010FR\u0018\u0010!\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010FR\u0018\u00109\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010GR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010FR\u0018\u00107\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010HR\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010IR\u0018\u0010B\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u0010HR\u0018\u00102\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u0010JR\u0018\u0010?\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b?\u0010JR\u0018\u0010A\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u0010JR\u0018\u0010=\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u0010KR\u0018\u0010C\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010JR\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010HR\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010FR\u001e\u00105\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010LR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010HR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010FR\u0018\u0010;\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010HR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010FR\u0018\u00100\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010FR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010MR\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010DR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010NR\u0018\u0010 \u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010HR\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010OR\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010FR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010NR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010JR\u0018\u0010@\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010JR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010NR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010NR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010HR\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010H¨\u0006R"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "prop", "type", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "", "allowPointSelect", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "", "name", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "", "data", "([Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "", "lineWidth", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "borderColor", "borderWidth", "borderRadius", "borderRadiusTopLeft", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "borderRadiusTopRight", "borderRadiusBottomLeft", "borderRadiusBottomRight", "color", "fillColor", "", "fillOpacity", "(Ljava/lang/Float;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "threshold", "negativeColor", "negativeFillColor", "size", "innerSize", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "dashStyle", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "", "yAxis", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "dataLabels", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "marker", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "step", "states", "colorByPoint", "zIndex", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;", "zones", "([Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "zoneAxis", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;", "shadow", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "stack", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "tooltip", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AASeriesElement;", "showInLegend", "enableMouseTracking", "reversed", "id", "connectNulls", "Ljava/lang/Integer;", "[Ljava/lang/Object;", "Ljava/lang/Object;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;", "Ljava/lang/String;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "Ljava/lang/Boolean;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATooltip;", "[Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAZonesElement;", "Ljava/lang/Float;", "Ljava/lang/Number;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AASeriesElement {
    private Boolean allowPointSelect;
    private String borderColor;
    private Number borderRadius;
    private Object borderRadiusBottomLeft;
    private Object borderRadiusBottomRight;
    private Object borderRadiusTopLeft;
    private Object borderRadiusTopRight;
    private Number borderWidth;
    private Object color;
    private Boolean colorByPoint;
    private Boolean connectNulls;
    private String dashStyle;
    private Object[] data;
    private AADataLabels dataLabels;
    private Boolean enableMouseTracking;
    private Object fillColor;
    private Float fillOpacity;
    private String id;
    private Object innerSize;
    private Number lineWidth;
    private AAMarker marker;
    private String name;
    private String negativeColor;
    private Object negativeFillColor;
    private Boolean reversed;
    private AAShadow shadow;
    private Boolean showInLegend;
    private Object size;
    private String stack;
    private Object states;
    private Object step;
    private Number threshold;
    private AATooltip tooltip;
    private String type;
    private Integer yAxis;
    private Integer zIndex;
    private String zoneAxis;
    private AAZonesElement[] zones;

    @d
    public final AASeriesElement allowPointSelect(@e Boolean bool) {
        this.allowPointSelect = bool;
        return this;
    }

    @d
    public final AASeriesElement borderColor(@e String str) {
        this.borderColor = str;
        return this;
    }

    @d
    public final AASeriesElement borderRadius(@e Number number) {
        this.borderRadius = number;
        return this;
    }

    @d
    public final AASeriesElement borderRadiusBottomLeft(@e Object obj) {
        this.borderRadiusBottomLeft = obj;
        return this;
    }

    @d
    public final AASeriesElement borderRadiusBottomRight(@e Object obj) {
        this.borderRadiusBottomRight = obj;
        return this;
    }

    @d
    public final AASeriesElement borderRadiusTopLeft(@e Object obj) {
        this.borderRadiusTopLeft = obj;
        return this;
    }

    @d
    public final AASeriesElement borderRadiusTopRight(@e Object obj) {
        this.borderRadiusTopRight = obj;
        return this;
    }

    @d
    public final AASeriesElement borderWidth(@e Number number) {
        this.borderWidth = number;
        return this;
    }

    @d
    public final AASeriesElement color(@e Object obj) {
        this.color = obj;
        return this;
    }

    @d
    public final AASeriesElement colorByPoint(@e Boolean bool) {
        this.colorByPoint = bool;
        return this;
    }

    @d
    public final AASeriesElement connectNulls(@e Boolean bool) {
        this.connectNulls = bool;
        return this;
    }

    @d
    public final AASeriesElement dashStyle(@e AAChartLineDashStyleType aAChartLineDashStyleType) {
        this.dashStyle = aAChartLineDashStyleType != null ? aAChartLineDashStyleType.getValue() : null;
        return this;
    }

    @d
    public final AASeriesElement data(@d Object[] objArr) {
        this.data = objArr;
        return this;
    }

    @d
    public final AASeriesElement dataLabels(@e AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
        return this;
    }

    @d
    public final AASeriesElement enableMouseTracking(@e Boolean bool) {
        this.enableMouseTracking = bool;
        return this;
    }

    @d
    public final AASeriesElement fillColor(@e Object obj) {
        this.fillColor = obj;
        return this;
    }

    @d
    public final AASeriesElement fillOpacity(@e Float f2) {
        this.fillOpacity = f2;
        return this;
    }

    @d
    public final AASeriesElement id(@e String str) {
        this.id = str;
        return this;
    }

    @d
    public final AASeriesElement innerSize(@e Object obj) {
        this.innerSize = obj;
        return this;
    }

    @d
    public final AASeriesElement lineWidth(@e Number number) {
        this.lineWidth = number;
        return this;
    }

    @d
    public final AASeriesElement marker(@e AAMarker aAMarker) {
        this.marker = aAMarker;
        return this;
    }

    @d
    public final AASeriesElement name(@e String str) {
        this.name = str;
        return this;
    }

    @d
    public final AASeriesElement negativeColor(@e String str) {
        this.negativeColor = str;
        return this;
    }

    @d
    public final AASeriesElement negativeFillColor(@e Object obj) {
        this.negativeFillColor = obj;
        return this;
    }

    @d
    public final AASeriesElement reversed(@e Boolean bool) {
        this.reversed = bool;
        return this;
    }

    @d
    public final AASeriesElement shadow(@e AAShadow aAShadow) {
        this.shadow = aAShadow;
        return this;
    }

    @d
    public final AASeriesElement showInLegend(@e Boolean bool) {
        this.showInLegend = bool;
        return this;
    }

    @d
    public final AASeriesElement size(@e Object obj) {
        this.size = obj;
        return this;
    }

    @d
    public final AASeriesElement stack(@e String str) {
        this.stack = str;
        return this;
    }

    @d
    public final AASeriesElement states(@e Object obj) {
        this.states = obj;
        return this;
    }

    @d
    public final AASeriesElement step(@e Object obj) {
        this.step = obj;
        return this;
    }

    @d
    public final AASeriesElement threshold(@e Number number) {
        this.threshold = number;
        return this;
    }

    @d
    public final AASeriesElement tooltip(@e AATooltip aATooltip) {
        this.tooltip = aATooltip;
        return this;
    }

    @d
    public final AASeriesElement type(@e AAChartType aAChartType) {
        this.type = aAChartType != null ? aAChartType.getValue() : null;
        return this;
    }

    @d
    public final AASeriesElement yAxis(@e Integer num) {
        this.yAxis = num;
        return this;
    }

    @d
    public final AASeriesElement zIndex(@e Integer num) {
        this.zIndex = num;
        return this;
    }

    @d
    public final AASeriesElement zoneAxis(@e String str) {
        this.zoneAxis = str;
        return this;
    }

    @d
    public final AASeriesElement zones(@d AAZonesElement[] aAZonesElementArr) {
        this.zones = aAZonesElementArr;
        return this;
    }
}
