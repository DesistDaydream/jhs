package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.github.aachartmodel.aainfographics.aachartcreator.AAChartAlignType;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartVerticalAlignType;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0012\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0017R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0018R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0019R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "", "", "prop", "text", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "style", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;", "align", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartAlignType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartVerticalAlignType;", "verticalAlign", "(Lcom/github/aachartmodel/aainfographics/aachartcreator/AAChartVerticalAlignType;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "", "x", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "y", "", "userHTML", "(Ljava/lang/Boolean;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AATitle;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAStyle;", "Ljava/lang/String;", "Ljava/lang/Number;", "Ljava/lang/Boolean;", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AATitle {
    private String align;
    private AAStyle style;
    private String text;
    private Boolean userHTML;
    private String verticalAlign;
    private Number x;
    private Number y;

    @d
    public final AATitle align(@d AAChartAlignType aAChartAlignType) {
        this.align = aAChartAlignType.toString();
        return this;
    }

    @d
    public final AATitle style(@e AAStyle aAStyle) {
        this.style = aAStyle;
        return this;
    }

    @d
    public final AATitle text(@e String str) {
        this.text = str;
        return this;
    }

    @d
    public final AATitle userHTML(@e Boolean bool) {
        this.userHTML = bool;
        return this;
    }

    @d
    public final AATitle verticalAlign(@d AAChartVerticalAlignType aAChartVerticalAlignType) {
        this.verticalAlign = aAChartVerticalAlignType.toString();
        return this;
    }

    @d
    public final AATitle x(@e Number number) {
        this.x = number;
        return this;
    }

    @d
    public final AATitle y(@e Number number) {
        this.y = number;
        return this;
    }
}
