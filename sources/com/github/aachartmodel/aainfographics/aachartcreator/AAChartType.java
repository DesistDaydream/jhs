package com.github.aachartmodel.aainfographics.aachartcreator;

import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Column", "Bar", "Area", "Areaspline", "Line", "Spline", "Scatter", "Pie", "Bubble", "Pyramid", "Funnel", "Columnrange", "Arearange", "Areasplinerange", "Boxplot", "Waterfall", "Polygon", "Gauge", "Errorbar", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public enum AAChartType {
    Column("column"),
    Bar("bar"),
    Area("area"),
    Areaspline("areaspline"),
    Line("line"),
    Spline("spline"),
    Scatter("scatter"),
    Pie("pie"),
    Bubble("bubble"),
    Pyramid("pyramid"),
    Funnel("funnel"),
    Columnrange("columnrange"),
    Arearange("arearange"),
    Areasplinerange("areasplinerange"),
    Boxplot("boxplot"),
    Waterfall("waterfall"),
    Polygon("polygon"),
    Gauge("gauge"),
    Errorbar("errorbar");
    
    @d
    private final String value;

    AAChartType(String str) {
        this.value = str;
    }

    @d
    public final String getValue() {
        return this.value;
    }
}
