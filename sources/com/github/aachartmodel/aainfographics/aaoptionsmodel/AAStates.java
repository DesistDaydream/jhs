package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;", "prop", "hover", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;", "select", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAInactive;", "inactive", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAInactive;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStates;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;", "getHover", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;", "setHover", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHover;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAInactive;", "getInactive", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAInactive;", "setInactive", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAInactive;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;", "getSelect", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;", "setSelect", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASelect;)V", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAStates {
    @e
    private AAHover hover;
    @e
    private AAInactive inactive;
    @e
    private AASelect select;

    @e
    public final AAHover getHover() {
        return this.hover;
    }

    @e
    public final AAInactive getInactive() {
        return this.inactive;
    }

    @e
    public final AASelect getSelect() {
        return this.select;
    }

    @d
    public final AAStates hover(@e AAHover aAHover) {
        this.hover = aAHover;
        return this;
    }

    @d
    public final AAStates inactive(@e AAInactive aAInactive) {
        this.inactive = aAInactive;
        return this;
    }

    @d
    public final AAStates select(@e AASelect aASelect) {
        this.select = aASelect;
        return this;
    }

    public final void setHover(@e AAHover aAHover) {
        this.hover = aAHover;
    }

    public final void setInactive(@e AAInactive aAInactive) {
        this.inactive = aAInactive;
    }

    public final void setSelect(@e AASelect aASelect) {
        this.select = aASelect;
    }
}
