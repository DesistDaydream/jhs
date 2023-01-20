package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartLineDashStyleType;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0015R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;", "", "prop", "color", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;", "dashStyle", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartLineDashStyleType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;", "", "width", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;", "value", "", "zIndex", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", TTDownloadField.TT_LABEL, "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotLinesElement;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "Ljava/lang/Number;", "Ljava/lang/Integer;", "Ljava/lang/Object;", "", "Ljava/lang/String;", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAPlotLinesElement {
    private Object color;
    private String dashStyle;
    private AALabel label;
    private Number value;
    private Number width;
    private Integer zIndex;

    @d
    public final AAPlotLinesElement color(@d Object obj) {
        this.color = obj;
        return this;
    }

    @d
    public final AAPlotLinesElement dashStyle(@d AAChartLineDashStyleType aAChartLineDashStyleType) {
        this.dashStyle = aAChartLineDashStyleType.getValue();
        return this;
    }

    @d
    public final AAPlotLinesElement label(@d AALabel aALabel) {
        this.label = aALabel;
        return this;
    }

    @d
    public final AAPlotLinesElement value(@e Number number) {
        this.value = number;
        return this;
    }

    @d
    public final AAPlotLinesElement width(@e Number number) {
        this.width = number;
        return this;
    }

    @d
    public final AAPlotLinesElement zIndex(@e Integer num) {
        this.zIndex = num;
        return this;
    }
}
