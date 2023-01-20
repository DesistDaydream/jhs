package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;", "", "", "prop", "borderColor", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;", "color", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "halo", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;", "Ljava/lang/String;", "getColor", "()Ljava/lang/String;", "setColor", "(Ljava/lang/String;)V", "getBorderColor", "setBorderColor", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "getHalo", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "setHalo", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;)V", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AASelect {
    @e
    private String borderColor;
    @e
    private String color;
    @e
    private AAHalo halo;

    @d
    public final AASelect borderColor(@e String str) {
        this.borderColor = str;
        return this;
    }

    @d
    public final AASelect color(@e String str) {
        this.color = str;
        return this;
    }

    @e
    public final String getBorderColor() {
        return this.borderColor;
    }

    @e
    public final String getColor() {
        return this.color;
    }

    @e
    public final AAHalo getHalo() {
        return this.halo;
    }

    @d
    public final AASelect halo(@e AAHalo aAHalo) {
        this.halo = aAHalo;
        return this;
    }

    public final void setBorderColor(@e String str) {
        this.borderColor = str;
    }

    public final void setColor(@e String str) {
        this.color = str;
    }

    public final void setHalo(@e AAHalo aAHalo) {
        this.halo = aAHalo;
    }
}
