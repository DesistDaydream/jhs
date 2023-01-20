package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.vivo.push.PushClientConstants;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\f\u0010\u0005J\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\r\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0015R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0016R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0017R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "", "", "prop", "from", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "to", "color", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "", "borderColor", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "borderWidth", PushClientConstants.TAG_CLASS_NAME, "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", TTDownloadField.TT_LABEL, "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "", "index", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPlotBandsElement;", "Ljava/lang/String;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "Ljava/lang/Integer;", "Ljava/lang/Number;", "Ljava/lang/Object;", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAPlotBandsElement {
    private String borderColor;
    private Number borderWidth;
    private String className;
    private Object color;
    private Number from;
    private Integer index;
    private AALabel label;
    private Number to;

    @d
    public final AAPlotBandsElement borderColor(@d String str) {
        this.borderColor = str;
        return this;
    }

    @d
    public final AAPlotBandsElement borderWidth(@e Number number) {
        this.borderWidth = number;
        return this;
    }

    @d
    public final AAPlotBandsElement className(@d String str) {
        this.className = str;
        return this;
    }

    @d
    public final AAPlotBandsElement color(@d Object obj) {
        this.color = obj;
        return this;
    }

    @d
    public final AAPlotBandsElement from(@e Number number) {
        this.from = number;
        return this;
    }

    @d
    public final AAPlotBandsElement index(@e Integer num) {
        this.index = num;
        return this;
    }

    @d
    public final AAPlotBandsElement label(@d AALabel aALabel) {
        this.label = aALabel;
        return this;
    }

    @d
    public final AAPlotBandsElement to(@e Number number) {
        this.to = number;
        return this;
    }
}
