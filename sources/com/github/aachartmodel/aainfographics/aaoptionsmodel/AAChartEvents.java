package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005R$\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\t\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\rR$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\t\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR$\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\t\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\r¨\u0006\u0016"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;", "", "", "prop", "load", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAChartEvents;", "redraw", "render", "selection", "Ljava/lang/String;", "getSelection", "()Ljava/lang/String;", "setSelection", "(Ljava/lang/String;)V", "getLoad", "setLoad", "getRedraw", "setRedraw", "getRender", "setRender", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAChartEvents {
    @e
    private String load;
    @e
    private String redraw;
    @e
    private String render;
    @e
    private String selection;

    @e
    public final String getLoad() {
        return this.load;
    }

    @e
    public final String getRedraw() {
        return this.redraw;
    }

    @e
    public final String getRender() {
        return this.render;
    }

    @e
    public final String getSelection() {
        return this.selection;
    }

    @d
    public final AAChartEvents load(@d String str) {
        this.load = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @d
    public final AAChartEvents redraw(@d String str) {
        this.redraw = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @d
    public final AAChartEvents render(@d String str) {
        this.render = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @d
    public final AAChartEvents selection(@d String str) {
        this.selection = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    public final void setLoad(@e String str) {
        this.load = str;
    }

    public final void setRedraw(@e String str) {
        this.redraw = str;
    }

    public final void setRender(@e String str) {
        this.render = str;
    }

    public final void setSelection(@e String str) {
        this.selection = str;
    }
}
