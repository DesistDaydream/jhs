package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.vivo.push.PushClientConstants;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'J\u0017\u0010\u0003\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\f\u0010\nJ\u0017\u0010\r\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\r\u0010\nJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000e\u0010\u0007R$\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\f\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0014\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R$\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u000f\u001a\u0004\b\"\u0010\u0011\"\u0004\b#\u0010\u0013R$\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0013¨\u0006("}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;", "", "prop", "backgroundColor", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;", "", "borderColor", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;", "", "borderWidth", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AABackground;", PushClientConstants.TAG_CLASS_NAME, "innerRadius", "outerRadius", "shape", "Ljava/lang/String;", "getClassName", "()Ljava/lang/String;", "setClassName", "(Ljava/lang/String;)V", "Ljava/lang/Number;", "getOuterRadius", "()Ljava/lang/Number;", "setOuterRadius", "(Ljava/lang/Number;)V", "getInnerRadius", "setInnerRadius", "Ljava/lang/Object;", "getBackgroundColor", "()Ljava/lang/Object;", "setBackgroundColor", "(Ljava/lang/Object;)V", "getBorderWidth", "setBorderWidth", "getBorderColor", "setBorderColor", "getShape", "setShape", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AABackground {
    @e
    private Object backgroundColor;
    @e
    private String borderColor;
    @e
    private Number borderWidth;
    @e
    private String className;
    @e
    private Number innerRadius;
    @e
    private Number outerRadius;
    @e
    private String shape;

    @d
    public final AABackground backgroundColor(@e Object obj) {
        this.backgroundColor = obj;
        return this;
    }

    @d
    public final AABackground borderColor(@e String str) {
        this.borderColor = str;
        return this;
    }

    @d
    public final AABackground borderWidth(@e Number number) {
        this.borderWidth = number;
        return this;
    }

    @d
    public final AABackground className(@e String str) {
        this.className = str;
        return this;
    }

    @e
    public final Object getBackgroundColor() {
        return this.backgroundColor;
    }

    @e
    public final String getBorderColor() {
        return this.borderColor;
    }

    @e
    public final Number getBorderWidth() {
        return this.borderWidth;
    }

    @e
    public final String getClassName() {
        return this.className;
    }

    @e
    public final Number getInnerRadius() {
        return this.innerRadius;
    }

    @e
    public final Number getOuterRadius() {
        return this.outerRadius;
    }

    @e
    public final String getShape() {
        return this.shape;
    }

    @d
    public final AABackground innerRadius(@e Number number) {
        this.innerRadius = number;
        return this;
    }

    @d
    public final AABackground outerRadius(@e Number number) {
        this.outerRadius = number;
        return this;
    }

    public final void setBackgroundColor(@e Object obj) {
        this.backgroundColor = obj;
    }

    public final void setBorderColor(@e String str) {
        this.borderColor = str;
    }

    public final void setBorderWidth(@e Number number) {
        this.borderWidth = number;
    }

    public final void setClassName(@e String str) {
        this.className = str;
    }

    public final void setInnerRadius(@e Number number) {
        this.innerRadius = number;
    }

    public final void setOuterRadius(@e Number number) {
        this.outerRadius = number;
    }

    public final void setShape(@e String str) {
        this.shape = str;
    }

    @d
    public final AABackground shape(@e String str) {
        this.shape = str;
        return this;
    }
}
