package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import androidx.constraintlayout.motion.widget.Key;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartVerticalAlignType;
import com.github.aachartmodel.aainfographics.aatools.AAJSStringPurer;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\bR\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bg\u0010hJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\u0005J\u0017\u0010\u000b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0010\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0005J\u0017\u0010\u0015\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0005J\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001a\u0010\u0013J\u0017\u0010\u001b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001b\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001c\u0010\u000fJ\u0017\u0010\u001d\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001d\u0010\u000fJ\u0017\u0010\u001e\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u001e\u0010\u000fJ\u0017\u0010\u001f\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u001f\u0010\u0013J\u0017\u0010 \u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b \u0010\u0013J\u0017\u0010!\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b!\u0010\u000fJ\u0017\u0010\"\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\"\u0010\u0005J\u0017\u0010#\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b#\u0010\u000fJ\u0017\u0010$\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b$\u0010\u0005J\u0017\u0010%\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b%\u0010&J\u0017\u0010'\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b'\u0010&R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010#\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b#\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R$\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010-\u001a\u0004\b7\u0010/\"\u0004\b8\u00101R$\u0010\u001c\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010-\u001a\u0004\b9\u0010/\"\u0004\b:\u00101R$\u0010%\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b%\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R$\u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010-\u001a\u0004\b@\u0010/\"\u0004\bA\u00101R$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010(\u001a\u0004\bB\u0010*\"\u0004\bC\u0010,R$\u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010-\u001a\u0004\bD\u0010/\"\u0004\bE\u00101R$\u0010 \u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u00102\u001a\u0004\bF\u00104\"\u0004\bG\u00106R$\u0010\u0007\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010-\u001a\u0004\bH\u0010/\"\u0004\bI\u00101R$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010-\u001a\u0004\bJ\u0010/\"\u0004\bK\u00101R$\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010-\u001a\u0004\bL\u0010/\"\u0004\bM\u00101R$\u0010\u001b\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u00102\u001a\u0004\bN\u00104\"\u0004\bO\u00106R$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010(\u001a\u0004\bP\u0010*\"\u0004\bQ\u0010,R$\u0010\u001a\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u00102\u001a\u0004\bR\u00104\"\u0004\bS\u00106R$\u0010\u001f\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001f\u00102\u001a\u0004\bT\u00104\"\u0004\bU\u00106R$\u0010\"\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\"\u0010(\u001a\u0004\bV\u0010*\"\u0004\bW\u0010,R$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R$\u0010$\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010(\u001a\u0004\b]\u0010*\"\u0004\b^\u0010,R$\u0010!\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010-\u001a\u0004\b_\u0010/\"\u0004\b`\u00101R$\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010(\u001a\u0004\ba\u0010*\"\u0004\bb\u0010,R$\u0010'\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b'\u0010;\u001a\u0004\bc\u0010=\"\u0004\bd\u0010?R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u00102\u001a\u0004\be\u00104\"\u0004\bf\u00106¨\u0006i"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "", "", "prop", "enabled", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "align", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "inside", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "style", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "", "format", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "formatter", "", Key.ROTATION, "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "allowOverlap", "useHTML", "distance", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartVerticalAlignType;", "verticalAlign", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartVerticalAlignType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "x", "y", "color", "backgroundColor", "borderColor", "borderRadius", "borderWidth", "shape", "crop", "overflow", "softConnector", "textPath", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "filter", "Ljava/lang/Boolean;", "getInside", "()Ljava/lang/Boolean;", "setInside", "(Ljava/lang/Boolean;)V", "Ljava/lang/String;", "getOverflow", "()Ljava/lang/String;", "setOverflow", "(Ljava/lang/String;)V", "Ljava/lang/Number;", "getDistance", "()Ljava/lang/Number;", "setDistance", "(Ljava/lang/Number;)V", "getBackgroundColor", "setBackgroundColor", "getColor", "setColor", "Ljava/lang/Object;", "getTextPath", "()Ljava/lang/Object;", "setTextPath", "(Ljava/lang/Object;)V", "getBorderColor", "setBorderColor", "getUseHTML", "setUseHTML", "getVerticalAlign", "setVerticalAlign", "getBorderWidth", "setBorderWidth", "getAlign", "setAlign", "getFormat", "setFormat", "getFormatter", "setFormatter", "getY", "setY", "getEnabled", "setEnabled", "getX", "setX", "getBorderRadius", "setBorderRadius", "getCrop", "setCrop", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "getStyle", "()Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "setStyle", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)V", "getSoftConnector", "setSoftConnector", "getShape", "setShape", "getAllowOverlap", "setAllowOverlap", "getFilter", "setFilter", "getRotation", "setRotation", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AADataLabels {
    @e
    private String align;
    @e
    private Boolean allowOverlap;
    @e
    private String backgroundColor;
    @e
    private String borderColor;
    @e
    private Number borderRadius;
    @e
    private Number borderWidth;
    @e
    private String color;
    @e
    private Boolean crop;
    @e
    private Number distance;
    @e
    private Boolean enabled;
    @e
    private Object filter;
    @e
    private String format;
    @e
    private String formatter;
    @e
    private Boolean inside;
    @e
    private String overflow;
    @e
    private Number rotation;
    @e
    private String shape;
    @e
    private Boolean softConnector;
    @e
    private AAStyle style;
    @e
    private Object textPath;
    @e
    private Boolean useHTML;
    @e
    private String verticalAlign;
    @e
    private Number x;
    @e
    private Number y;

    @d
    public final AADataLabels align(@e AAChartAlignType aAChartAlignType) {
        this.align = aAChartAlignType != null ? aAChartAlignType.getValue() : null;
        return this;
    }

    @d
    public final AADataLabels allowOverlap(@e Boolean bool) {
        this.allowOverlap = bool;
        return this;
    }

    @d
    public final AADataLabels backgroundColor(@e String str) {
        this.backgroundColor = str;
        return this;
    }

    @d
    public final AADataLabels borderColor(@e String str) {
        this.borderColor = str;
        return this;
    }

    @d
    public final AADataLabels borderRadius(@e Number number) {
        this.borderRadius = number;
        return this;
    }

    @d
    public final AADataLabels borderWidth(@e Number number) {
        this.borderWidth = number;
        return this;
    }

    @d
    public final AADataLabels color(@e String str) {
        this.color = str;
        return this;
    }

    @d
    public final AADataLabels crop(@e Boolean bool) {
        this.crop = bool;
        return this;
    }

    @d
    public final AADataLabels distance(@e Number number) {
        this.distance = number;
        return this;
    }

    @d
    public final AADataLabels enabled(@e Boolean bool) {
        this.enabled = bool;
        return this;
    }

    @d
    public final AADataLabels filter(@e Object obj) {
        this.filter = obj;
        return this;
    }

    @d
    public final AADataLabels format(@e String str) {
        this.format = str;
        return this;
    }

    @d
    public final AADataLabels formatter(@e String str) {
        this.formatter = AAJSStringPurer.INSTANCE.pureAnonymousJSFunctionString(str);
        return this;
    }

    @e
    public final String getAlign() {
        return this.align;
    }

    @e
    public final Boolean getAllowOverlap() {
        return this.allowOverlap;
    }

    @e
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    @e
    public final String getBorderColor() {
        return this.borderColor;
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
    public final String getColor() {
        return this.color;
    }

    @e
    public final Boolean getCrop() {
        return this.crop;
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
    public final Object getFilter() {
        return this.filter;
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
    public final Boolean getInside() {
        return this.inside;
    }

    @e
    public final String getOverflow() {
        return this.overflow;
    }

    @e
    public final Number getRotation() {
        return this.rotation;
    }

    @e
    public final String getShape() {
        return this.shape;
    }

    @e
    public final Boolean getSoftConnector() {
        return this.softConnector;
    }

    @e
    public final AAStyle getStyle() {
        return this.style;
    }

    @e
    public final Object getTextPath() {
        return this.textPath;
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
    public final AADataLabels inside(@e Boolean bool) {
        this.inside = bool;
        return this;
    }

    @d
    public final AADataLabels overflow(@e String str) {
        this.overflow = str;
        return this;
    }

    @d
    public final AADataLabels rotation(@e Number number) {
        this.rotation = number;
        return this;
    }

    public final void setAlign(@e String str) {
        this.align = str;
    }

    public final void setAllowOverlap(@e Boolean bool) {
        this.allowOverlap = bool;
    }

    public final void setBackgroundColor(@e String str) {
        this.backgroundColor = str;
    }

    public final void setBorderColor(@e String str) {
        this.borderColor = str;
    }

    public final void setBorderRadius(@e Number number) {
        this.borderRadius = number;
    }

    public final void setBorderWidth(@e Number number) {
        this.borderWidth = number;
    }

    public final void setColor(@e String str) {
        this.color = str;
    }

    public final void setCrop(@e Boolean bool) {
        this.crop = bool;
    }

    public final void setDistance(@e Number number) {
        this.distance = number;
    }

    public final void setEnabled(@e Boolean bool) {
        this.enabled = bool;
    }

    public final void setFilter(@e Object obj) {
        this.filter = obj;
    }

    public final void setFormat(@e String str) {
        this.format = str;
    }

    public final void setFormatter(@e String str) {
        this.formatter = str;
    }

    public final void setInside(@e Boolean bool) {
        this.inside = bool;
    }

    public final void setOverflow(@e String str) {
        this.overflow = str;
    }

    public final void setRotation(@e Number number) {
        this.rotation = number;
    }

    public final void setShape(@e String str) {
        this.shape = str;
    }

    public final void setSoftConnector(@e Boolean bool) {
        this.softConnector = bool;
    }

    public final void setStyle(@e AAStyle aAStyle) {
        this.style = aAStyle;
    }

    public final void setTextPath(@e Object obj) {
        this.textPath = obj;
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
    public final AADataLabels shape(@e String str) {
        this.shape = str;
        return this;
    }

    @d
    public final AADataLabels softConnector(@e Boolean bool) {
        this.softConnector = bool;
        return this;
    }

    @d
    public final AADataLabels style(@e AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @d
    public final AADataLabels textPath(@e Object obj) {
        this.textPath = obj;
        return this;
    }

    @d
    public final AADataLabels useHTML(@e Boolean bool) {
        this.useHTML = bool;
        return this;
    }

    @d
    public final AADataLabels verticalAlign(@e AAChartVerticalAlignType aAChartVerticalAlignType) {
        this.verticalAlign = aAChartVerticalAlignType != null ? aAChartVerticalAlignType.getValue() : null;
        return this;
    }

    @d
    public final AADataLabels x(@e Number number) {
        this.x = number;
        return this;
    }

    @d
    public final AADataLabels y(@e Number number) {
        this.y = number;
        return this;
    }
}
