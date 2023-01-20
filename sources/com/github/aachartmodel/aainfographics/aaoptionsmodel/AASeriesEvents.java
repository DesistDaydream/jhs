package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeriesEvents;", "", "", "prop", "legendItemClick", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASeriesEvents;", "Ljava/lang/String;", "getLegendItemClick", "()Ljava/lang/String;", "setLegendItemClick", "(Ljava/lang/String;)V", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AASeriesEvents {
    @e
    private String legendItemClick;

    @e
    public final String getLegendItemClick() {
        return this.legendItemClick;
    }

    @d
    public final AASeriesEvents legendItemClick(@d String str) {
        this.legendItemClick = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    public final void setLegendItemClick(@e String str) {
        this.legendItemClick = str;
    }
}
