package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import androidx.constraintlayout.motion.widget.Key;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b8\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bO\u0010PJ\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u000b\u0010\nJ\u0017\u0010\r\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0013\u0010\nJ\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0014\u0010\nJ\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0018\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001c\u0010\nJ\u0017\u0010\u001d\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001d\u0010\nJ\u0017\u0010\u001e\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u001e\u0010\u000eR$\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u0004\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010$\u001a\u0004\b.\u0010&\"\u0004\b/\u0010(R$\u0010\u0006\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010$\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R$\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R$\u0010\u001c\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u00105\u001a\u0004\bA\u00107\"\u0004\bB\u00109R$\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u00105\u001a\u0004\bC\u00107\"\u0004\bD\u00109R$\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u00105\u001a\u0004\bE\u00107\"\u0004\bF\u00109R$\u0010\u0014\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u00105\u001a\u0004\bG\u00107\"\u0004\bH\u00109R$\u0010\u001d\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u00105\u001a\u0004\bI\u00107\"\u0004\bJ\u00109R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010<\u001a\u0004\bK\u0010>\"\u0004\bL\u0010@R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u001f\u001a\u0004\bM\u0010!\"\u0004\bN\u0010#¨\u0006Q"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "prop", "align", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "autoRotation", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "", "autoRotationLimit", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "distance", "", "enabled", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "", "format", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "formatter", "padding", Key.ROTATION, "", "staggerLines", "(Ljava/lang/Integer;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "step", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "style", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AALabels;", "x", "y", "useHTML", "Ljava/lang/Integer;", "getStep", "()Ljava/lang/Integer;", "setStep", "(Ljava/lang/Integer;)V", "Ljava/lang/String;", "getAlign", "()Ljava/lang/String;", "setAlign", "(Ljava/lang/String;)V", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "getStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "setStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)V", "getFormatter", "setFormatter", "Ljava/lang/Object;", "getAutoRotation", "()Ljava/lang/Object;", "setAutoRotation", "(Ljava/lang/Object;)V", "Ljava/lang/Number;", "getPadding", "()Ljava/lang/Number;", "setPadding", "(Ljava/lang/Number;)V", "getFormat", "setFormat", "Ljava/lang/Boolean;", "getUseHTML", "()Ljava/lang/Boolean;", "setUseHTML", "(Ljava/lang/Boolean;)V", "getX", "setX", "getDistance", "setDistance", "getAutoRotationLimit", "setAutoRotationLimit", "getRotation", "setRotation", "getY", "setY", "getEnabled", "setEnabled", "getStaggerLines", "setStaggerLines", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AALabels {
    @e
    private String align;
    @e
    private Object autoRotation;
    @e
    private Number autoRotationLimit;
    @e
    private Number distance;
    @e
    private Boolean enabled;
    @e
    private String format;
    @e
    private String formatter;
    @e
    private Number padding;
    @e
    private Number rotation;
    @e
    private Integer staggerLines;
    @e
    private Integer step;
    @e
    private AAStyle style;
    @e
    private Boolean useHTML;
    @e
    private Number x;
    @e
    private Number y;

    @d
    public final AALabels align(@d AAChartAlignType aAChartAlignType) {
        this.align = aAChartAlignType.getValue();
        return this;
    }

    @d
    public final AALabels autoRotation(@d Object obj) {
        this.autoRotation = obj;
        return this;
    }

    @d
    public final AALabels autoRotationLimit(@e Number number) {
        this.autoRotationLimit = number;
        return this;
    }

    @d
    public final AALabels distance(@e Number number) {
        this.distance = number;
        return this;
    }

    @d
    public final AALabels enabled(@e Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @d
    public final AALabels format(@d String str) {
        this.format = str;
        return this;
    }

    @d
    public final AALabels formatter(@d String str) {
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @e
    public final String getAlign() {
        return this.align;
    }

    @e
    public final Object getAutoRotation() {
        return this.autoRotation;
    }

    @e
    public final Number getAutoRotationLimit() {
        return this.autoRotationLimit;
    }

    @e
    public final Number getDistance() {
        return this.distance;
    }

    @e
    public final Boolean getEnabled() {
        return this.enabled;
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
    public final Number getPadding() {
        return this.padding;
    }

    @e
    public final Number getRotation() {
        return this.rotation;
    }

    @e
    public final Integer getStaggerLines() {
        return this.staggerLines;
    }

    @e
    public final Integer getStep() {
        return this.step;
    }

    @e
    public final AAStyle getStyle() {
        return this.style;
    }

    @e
    public final Boolean getUseHTML() {
        return this.useHTML;
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
    public final AALabels padding(@e Number number) {
        this.padding = number;
        return this;
    }

    @d
    public final AALabels rotation(@e Number number) {
        this.rotation = number;
        return this;
    }

    public final void setAlign(@e String str) {
        this.align = str;
    }

    public final void setAutoRotation(@e Object obj) {
        this.autoRotation = obj;
    }

    public final void setAutoRotationLimit(@e Number number) {
        this.autoRotationLimit = number;
    }

    public final void setDistance(@e Number number) {
        this.distance = number;
    }

    public final void setEnabled(@e Boolean bool) {
        this.enabled = bool;
    }

    public final void setFormat(@e String str) {
        this.format = str;
    }

    public final void setFormatter(@e String str) {
        this.formatter = str;
    }

    public final void setPadding(@e Number number) {
        this.padding = number;
    }

    public final void setRotation(@e Number number) {
        this.rotation = number;
    }

    public final void setStaggerLines(@e Integer num) {
        this.staggerLines = num;
    }

    public final void setStep(@e Integer num) {
        this.step = num;
    }

    public final void setStyle(@e AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setUseHTML(@e Boolean bool) {
        this.useHTML = bool;
    }

    public final void setX(@e Number number) {
        this.x = number;
    }

    public final void setY(@e Number number) {
        this.y = number;
    }

    @d
    public final AALabels staggerLines(@e Integer num) {
        this.staggerLines = num;
        return this;
    }

    @d
    public final AALabels step(@e Integer num) {
        this.step = num;
        return this;
    }

    @d
    public final AALabels style(@d AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @d
    public final AALabels useHTML(@e Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @d
    public final AALabels x(@e Number number) {
        this.x = number;
        return this;
    }

    @d
    public final AALabels y(@e Number number) {
        this.y = number;
        return this;
    }
}
