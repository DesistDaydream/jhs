package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000f\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0015\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019¨\u0006("}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "", "", "prop", "enabled", "(Z)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "", "href", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "position", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "style", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AACredits;", "text", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "getPosition", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;", "setPosition", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAPosition;)V", "Ljava/lang/String;", "getHref", "()Ljava/lang/String;", "setHref", "(Ljava/lang/String;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "getStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "setStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)V", "Ljava/lang/Boolean;", "getEnabled", "()Ljava/lang/Boolean;", "setEnabled", "(Ljava/lang/Boolean;)V", "getText", "setText", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AACredits {
    @e
    private Boolean enabled;
    @e
    private String href;
    @e
    private AAPosition position;
    @e
    private AAStyle style;
    @e
    private String text;

    @d
    public final AACredits enabled(boolean z) {
        this.enabled = Boolean.valueOf(z);
        return this;
    }

    @e
    public final Boolean getEnabled() {
        return this.enabled;
    }

    @e
    public final String getHref() {
        return this.href;
    }

    @e
    public final AAPosition getPosition() {
        return this.position;
    }

    @e
    public final AAStyle getStyle() {
        return this.style;
    }

    @e
    public final String getText() {
        return this.text;
    }

    @d
    public final AACredits href(@e String str) {
        this.href = str;
        return this;
    }

    @d
    public final AACredits position(@e AAPosition aAPosition) {
        this.position = aAPosition;
        return this;
    }

    public final void setEnabled(@e Boolean bool) {
        this.enabled = bool;
    }

    public final void setHref(@e String str) {
        this.href = str;
    }

    public final void setPosition(@e AAPosition aAPosition) {
        this.position = aAPosition;
    }

    public final void setStyle(@e AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setText(@e String str) {
        this.text = str;
    }

    @d
    public final AACredits style(@e AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @d
    public final AACredits text(@e String str) {
        this.text = str;
        return this;
    }
}
