package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAColumnrange;", "", "", "prop", "borderRadius", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAColumnrange;", "borderWidth", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "dataLabels", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAColumnrange;", "Ljava/lang/Number;", "getBorderWidth", "()Ljava/lang/Number;", "setBorderWidth", "(Ljava/lang/Number;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "getDataLabels", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "setDataLabels", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;)V", "getBorderRadius", "setBorderRadius", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAColumnrange {
    @e
    private Number borderRadius;
    @e
    private Number borderWidth;
    @e
    private AADataLabels dataLabels;

    @d
    public final AAColumnrange borderRadius(@e Number number) {
        this.borderRadius = number;
        return this;
    }

    @d
    public final AAColumnrange borderWidth(@e Number number) {
        this.borderWidth = number;
        return this;
    }

    @d
    public final AAColumnrange dataLabels(@d AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
        return this;
    }

    @e
    public final Number getBorderRadius() {
        return this.borderRadius;
    }

    @e
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @e
    public final AADataLabels getDataLabels() {
        return this.dataLabels;
    }

    public final void setBorderRadius(@e Number number) {
        this.borderRadius = number;
    }

    public final void setBorderWidth(@e Number number) {
        this.borderWidth = number;
    }

    public final void setDataLabels(@e AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
    }
}
