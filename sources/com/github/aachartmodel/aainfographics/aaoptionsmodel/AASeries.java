package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartStackingType;
import com.umeng.analytics.pro.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b[\u0018\u00002\u00020\u0001B\t¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\r\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u000e\u0010\u000bJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u0019\u001a\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u001b¢\u0006\u0004\b\u001e\u0010\u001dJ\u0015\u0010 \u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u0015\u0010#\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u0015\u0010&\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020%¢\u0006\u0004\b&\u0010'J\u0015\u0010)\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020(¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020+¢\u0006\u0004\b,\u0010-J\u0015\u0010/\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020.¢\u0006\u0004\b/\u00100J\u0015\u00101\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b1\u0010\u0005J\u0015\u00102\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b2\u0010\u000bJ\u0015\u00103\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0004\b3\u0010\bR$\u0010#\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R$\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u00103\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR$\u00101\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b1\u0010C\u001a\u0004\bH\u0010E\"\u0004\bI\u0010GR$\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR$\u0010&\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010C\u001a\u0004\bT\u0010E\"\u0004\bU\u0010GR$\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010J\u001a\u0004\bV\u0010L\"\u0004\bW\u0010NR$\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u00109\u001a\u0004\bX\u0010;\"\u0004\bY\u0010=R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010>\u001a\u0004\bZ\u0010@\"\u0004\b[\u0010BR$\u0010/\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b/\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R$\u0010\n\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010J\u001a\u0004\ba\u0010L\"\u0004\bb\u0010NR$\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010J\u001a\u0004\bc\u0010L\"\u0004\bd\u0010NR$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR$\u00102\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b2\u0010J\u001a\u0004\bt\u0010L\"\u0004\bu\u0010NR$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b)\u0010v\u001a\u0004\bw\u0010x\"\u0004\by\u0010zR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010{\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR)\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0005\b,\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R&\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0014\n\u0004\b\t\u0010>\u001a\u0005\b\u0085\u0001\u0010@\"\u0005\b\u0086\u0001\u0010B¨\u0006\u0089\u0001"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "", "", "prop", "borderColor", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "", "borderWidth", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "borderRadius", "borderRadiusTopLeft", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "borderRadiusTopRight", "borderRadiusBottomLeft", "borderRadiusBottomRight", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "marker", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;", "stacking", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartStackingType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAnimation;", "animation", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAnimation;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "", "keys", "([Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "", "colorByPoint", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "connectNulls", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeriesEvents;", d.ar, "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeriesEvents;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;", "shadow", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "dataLabels", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "states", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPoint;", "point", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPoint;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "", "pointInterval", "(I)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeries;", "pointIntervalUnit", "pointPlacement", "pointStart", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;", "getShadow", "()Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;", "setShadow", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAShadow;)V", "Ljava/lang/Boolean;", "getColorByPoint", "()Ljava/lang/Boolean;", "setColorByPoint", "(Ljava/lang/Boolean;)V", "Ljava/lang/Number;", "getPointStart", "()Ljava/lang/Number;", "setPointStart", "(Ljava/lang/Number;)V", "Ljava/lang/String;", "getStacking", "()Ljava/lang/String;", "setStacking", "(Ljava/lang/String;)V", "getPointIntervalUnit", "setPointIntervalUnit", "Ljava/lang/Object;", "getBorderRadiusTopRight", "()Ljava/lang/Object;", "setBorderRadiusTopRight", "(Ljava/lang/Object;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "getDataLabels", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "setDataLabels", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;)V", "getBorderColor", "setBorderColor", "getBorderRadiusBottomRight", "setBorderRadiusBottomRight", "getConnectNulls", "setConnectNulls", "getBorderWidth", "setBorderWidth", "Ljava/lang/Integer;", "getPointInterval", "()Ljava/lang/Integer;", "setPointInterval", "(Ljava/lang/Integer;)V", "getBorderRadiusTopLeft", "setBorderRadiusTopLeft", "getBorderRadiusBottomLeft", "setBorderRadiusBottomLeft", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAnimation;", "getAnimation", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAnimation;", "setAnimation", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAAnimation;)V", "[Ljava/lang/String;", "getKeys", "()[Ljava/lang/String;", "setKeys", "([Ljava/lang/String;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeriesEvents;", "getEvents", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeriesEvents;", "setEvents", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeriesEvents;)V", "getPointPlacement", "setPointPlacement", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "getStates", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "setStates", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "getMarker", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "setMarker", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPoint;", "getPoint", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPoint;", "setPoint", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPoint;)V", "getBorderRadius", "setBorderRadius", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AASeries {
    @e
    private AAAnimation animation;
    @e
    private String borderColor;
    @e
    private Number borderRadius;
    @e
    private Object borderRadiusBottomLeft;
    @e
    private Object borderRadiusBottomRight;
    @e
    private Object borderRadiusTopLeft;
    @e
    private Object borderRadiusTopRight;
    @e
    private Number borderWidth;
    @e
    private Boolean colorByPoint;
    @e
    private Boolean connectNulls;
    @e
    private AADataLabels dataLabels;
    @e
    private AASeriesEvents events;
    @e
    private String[] keys;
    @e
    private AAMarker marker;
    @e
    private AAPoint point;
    @e
    private Integer pointInterval;
    @e
    private String pointIntervalUnit;
    @e
    private Object pointPlacement;
    @e
    private Number pointStart;
    @e
    private com.github.aachartmodel.aainfographics.aachartcreator.AAShadow shadow;
    @e
    private String stacking;
    @e
    private AAStates states;

    @k.e.a.d
    public final AASeries animation(@k.e.a.d AAAnimation aAAnimation) {
        this.animation = aAAnimation;
        return this;
    }

    @k.e.a.d
    public final AASeries borderColor(@e String str) {
        this.borderColor = str;
        return this;
    }

    @k.e.a.d
    public final AASeries borderRadius(@e Number number) {
        this.borderRadius = number;
        return this;
    }

    @k.e.a.d
    public final AASeries borderRadiusBottomLeft(@e Object obj) {
        this.borderRadiusBottomLeft = obj;
        return this;
    }

    @k.e.a.d
    public final AASeries borderRadiusBottomRight(@e Object obj) {
        this.borderRadiusBottomRight = obj;
        return this;
    }

    @k.e.a.d
    public final AASeries borderRadiusTopLeft(@e Object obj) {
        this.borderRadiusTopLeft = obj;
        return this;
    }

    @k.e.a.d
    public final AASeries borderRadiusTopRight(@e Object obj) {
        this.borderRadiusTopRight = obj;
        return this;
    }

    @k.e.a.d
    public final AASeries borderWidth(@e Number number) {
        this.borderWidth = number;
        return this;
    }

    @k.e.a.d
    public final AASeries colorByPoint(@e Boolean bool) {
        this.colorByPoint = bool;
        return this;
    }

    @k.e.a.d
    public final AASeries connectNulls(@e Boolean bool) {
        this.connectNulls = bool;
        return this;
    }

    @k.e.a.d
    public final AASeries dataLabels(@k.e.a.d AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
        return this;
    }

    @k.e.a.d
    public final AASeries events(@k.e.a.d AASeriesEvents aASeriesEvents) {
        this.events = aASeriesEvents;
        return this;
    }

    @e
    public final AAAnimation getAnimation() {
        return this.animation;
    }

    @e
    public final String getBorderColor() {
        return this.borderColor;
    }

    @e
    public final Number getBorderRadius() {
        return this.borderRadius;
    }

    @e
    public final Object getBorderRadiusBottomLeft() {
        return this.borderRadiusBottomLeft;
    }

    @e
    public final Object getBorderRadiusBottomRight() {
        return this.borderRadiusBottomRight;
    }

    @e
    public final Object getBorderRadiusTopLeft() {
        return this.borderRadiusTopLeft;
    }

    @e
    public final Object getBorderRadiusTopRight() {
        return this.borderRadiusTopRight;
    }

    @e
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @e
    public final Boolean getColorByPoint() {
        return this.colorByPoint;
    }

    @e
    public final Boolean getConnectNulls() {
        return this.connectNulls;
    }

    @e
    public final AADataLabels getDataLabels() {
        return this.dataLabels;
    }

    @e
    public final AASeriesEvents getEvents() {
        return this.events;
    }

    @e
    public final String[] getKeys() {
        return this.keys;
    }

    @e
    public final AAMarker getMarker() {
        return this.marker;
    }

    @e
    public final AAPoint getPoint() {
        return this.point;
    }

    @e
    public final Integer getPointInterval() {
        return this.pointInterval;
    }

    @e
    public final String getPointIntervalUnit() {
        return this.pointIntervalUnit;
    }

    @e
    public final Object getPointPlacement() {
        return this.pointPlacement;
    }

    @e
    public final Number getPointStart() {
        return this.pointStart;
    }

    @e
    public final com.github.aachartmodel.aainfographics.aachartcreator.AAShadow getShadow() {
        return this.shadow;
    }

    @e
    public final String getStacking() {
        return this.stacking;
    }

    @e
    public final AAStates getStates() {
        return this.states;
    }

    @k.e.a.d
    public final AASeries keys(@k.e.a.d String[] strArr) {
        this.keys = strArr;
        return this;
    }

    @k.e.a.d
    public final AASeries marker(@k.e.a.d AAMarker aAMarker) {
        this.marker = aAMarker;
        return this;
    }

    @k.e.a.d
    public final AASeries point(@k.e.a.d AAPoint aAPoint) {
        this.point = aAPoint;
        return this;
    }

    @k.e.a.d
    public final AASeries pointInterval(int i2) {
        this.pointInterval = Integer.valueOf(i2);
        return this;
    }

    @k.e.a.d
    public final AASeries pointIntervalUnit(@k.e.a.d String str) {
        this.pointIntervalUnit = str;
        return this;
    }

    @k.e.a.d
    public final AASeries pointPlacement(@k.e.a.d Object obj) {
        this.pointPlacement = obj;
        return this;
    }

    @k.e.a.d
    public final AASeries pointStart(@k.e.a.d Number number) {
        this.pointStart = number;
        return this;
    }

    public final void setAnimation(@e AAAnimation aAAnimation) {
        this.animation = aAAnimation;
    }

    public final void setBorderColor(@e String str) {
        this.borderColor = str;
    }

    public final void setBorderRadius(@e Number number) {
        this.borderRadius = number;
    }

    public final void setBorderRadiusBottomLeft(@e Object obj) {
        this.borderRadiusBottomLeft = obj;
    }

    public final void setBorderRadiusBottomRight(@e Object obj) {
        this.borderRadiusBottomRight = obj;
    }

    public final void setBorderRadiusTopLeft(@e Object obj) {
        this.borderRadiusTopLeft = obj;
    }

    public final void setBorderRadiusTopRight(@e Object obj) {
        this.borderRadiusTopRight = obj;
    }

    public final void setBorderWidth(@e Number number) {
        this.borderWidth = number;
    }

    public final void setColorByPoint(@e Boolean bool) {
        this.colorByPoint = bool;
    }

    public final void setConnectNulls(@e Boolean bool) {
        this.connectNulls = bool;
    }

    public final void setDataLabels(@e AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
    }

    public final void setEvents(@e AASeriesEvents aASeriesEvents) {
        this.events = aASeriesEvents;
    }

    public final void setKeys(@e String[] strArr) {
        this.keys = strArr;
    }

    public final void setMarker(@e AAMarker aAMarker) {
        this.marker = aAMarker;
    }

    public final void setPoint(@e AAPoint aAPoint) {
        this.point = aAPoint;
    }

    public final void setPointInterval(@e Integer num) {
        this.pointInterval = num;
    }

    public final void setPointIntervalUnit(@e String str) {
        this.pointIntervalUnit = str;
    }

    public final void setPointPlacement(@e Object obj) {
        this.pointPlacement = obj;
    }

    public final void setPointStart(@e Number number) {
        this.pointStart = number;
    }

    public final void setShadow(@e com.github.aachartmodel.aainfographics.aachartcreator.AAShadow aAShadow) {
        this.shadow = aAShadow;
    }

    public final void setStacking(@e String str) {
        this.stacking = str;
    }

    public final void setStates(@e AAStates aAStates) {
        this.states = aAStates;
    }

    @k.e.a.d
    public final AASeries shadow(@k.e.a.d com.github.aachartmodel.aainfographics.aachartcreator.AAShadow aAShadow) {
        this.shadow = aAShadow;
        return this;
    }

    @k.e.a.d
    public final AASeries stacking(@e AAChartStackingType aAChartStackingType) {
        this.stacking = aAChartStackingType != null ? aAChartStackingType.getValue() : null;
        return this;
    }

    @k.e.a.d
    public final AASeries states(@k.e.a.d AAStates aAStates) {
        this.states = aAStates;
        return this;
    }
}
