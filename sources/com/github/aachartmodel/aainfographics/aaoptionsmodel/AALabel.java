package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import androidx.constraintlayout.motion.widget.Key;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b.\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0011\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0014\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0005R$\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0017\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR$\u0010\u0011\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010%\u001a\u0004\b1\u0010'\"\u0004\b2\u0010)R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b3\u0010\u0019\"\u0004\b4\u0010\u001bR$\u0010\u0014\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010%\u001a\u0004\b5\u0010'\"\u0004\b6\u0010)R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0017\u001a\u0004\b7\u0010\u0019\"\u0004\b8\u0010\u001b¨\u0006;"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "", "", "prop", "align", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "", Key.ROTATION, "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "text", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "textAlign", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "", "useHTML", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "verticalAlign", "style", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabel;", "x", "y", "format", "formatter", "Ljava/lang/String;", "getTextAlign", "()Ljava/lang/String;", "setTextAlign", "(Ljava/lang/String;)V", "Ljava/lang/Boolean;", "getUseHTML", "()Ljava/lang/Boolean;", "setUseHTML", "(Ljava/lang/Boolean;)V", "getText", "setText", "getFormatter", "setFormatter", "Ljava/lang/Number;", "getRotation", "()Ljava/lang/Number;", "setRotation", "(Ljava/lang/Number;)V", "getVerticalAlign", "setVerticalAlign", "Ljava/lang/Object;", "getStyle", "()Ljava/lang/Object;", "setStyle", "(Ljava/lang/Object;)V", "getX", "setX", "getAlign", "setAlign", "getY", "setY", "getFormat", "setFormat", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AALabel {
    @e
    private String align;
    @e
    private String format;
    @e
    private String formatter;
    @e
    private Number rotation;
    @e
    private Object style;
    @e
    private String text;
    @e
    private String textAlign;
    @e
    private Boolean useHTML;
    @e
    private String verticalAlign;
    @e
    private Number x;
    @e
    private Number y;

    @d
    public final AALabel align(@e String str) {
        this.align = str;
        return this;
    }

    @d
    public final AALabel format(@e String str) {
        this.format = str;
        return this;
    }

    @d
    public final AALabel formatter(@e String str) {
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @e
    public final String getAlign() {
        return this.align;
    }

    @e
    public final String getFormat() {
        return this.format;
    }

    @e
    public final String getFormatter() {
        return this.formatter;
    }

    @e
    public final Number getRotation() {
        return this.rotation;
    }

    @e
    public final Object getStyle() {
        return this.style;
    }

    @e
    public final String getText() {
        return this.text;
    }

    @e
    public final String getTextAlign() {
        return this.textAlign;
    }

    @e
    public final Boolean getUseHTML() {
        return this.useHTML;
    }

    @e
    public final String getVerticalAlign() {
        return this.verticalAlign;
    }

    @e
    public final Number getX() {
        return this.x;
    }

    @e
    public final Number getY() {
        return this.y;
    }

    @d
    public final AALabel rotation(@e Number number) {
        this.rotation = number;
        return this;
    }

    public final void setAlign(@e String str) {
        this.align = str;
    }

    public final void setFormat(@e String str) {
        this.format = str;
    }

    public final void setFormatter(@e String str) {
        this.formatter = str;
    }

    public final void setRotation(@e Number number) {
        this.rotation = number;
    }

    public final void setStyle(@e Object obj) {
        this.style = obj;
    }

    public final void setText(@e String str) {
        this.text = str;
    }

    public final void setTextAlign(@e String str) {
        this.textAlign = str;
    }

    public final void setUseHTML(@e Boolean bool) {
        this.useHTML = bool;
    }

    public final void setVerticalAlign(@e String str) {
        this.verticalAlign = str;
    }

    public final void setX(@e Number number) {
        this.x = number;
    }

    public final void setY(@e Number number) {
        this.y = number;
    }

    @d
    public final AALabel style(@e Object obj) {
        this.style = obj;
        return this;
    }

    @d
    public final AALabel text(@e String str) {
        this.text = str;
        return this;
    }

    @d
    public final AALabel textAlign(@e AAChartAlignType aAChartAlignType) {
        this.textAlign = aAChartAlignType != null ? aAChartAlignType.getValue() : null;
        return this;
    }

    @d
    public final AALabel useHTML(@e Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @d
    public final AALabel verticalAlign(@e String str) {
        this.verticalAlign = str;
        return this;
    }

    @d
    public final AALabel x(@e Number number) {
        this.x = number;
        return this;
    }

    @d
    public final AALabel y(@e Number number) {
        this.y = number;
        return this;
    }
}
