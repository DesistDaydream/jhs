package com.github.aachartmodel.aainfographics.aachartcreator;

import com.github.aachartmodel.aainfographics.aaoptionsmodel.AADataLabels;
import com.github.aachartmodel.aainfographics.aaoptionsmodel.AAMarker;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\t\u0010\bJ\u0015\u0010\n\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0012R\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0014R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0014R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AADataElement;", "", "", "prop", "name", "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AADataElement;", "", "x", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AADataElement;", "y", "color", "(Ljava/lang/Object;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AADataElement;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "dataLabels", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AADataElement;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "marker", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;)Lcom/github/aachartmodel/aainfographics/aachartcreator/AADataElement;", "Ljava/lang/Object;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AADataLabels;", "Ljava/lang/Number;", "Ljava/lang/String;", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAMarker;", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AADataElement {
    private Object color;
    private AADataLabels dataLabels;
    private AAMarker marker;
    private String name;
    private Number x;
    private Number y;

    @d
    public final AADataElement color(@d Object obj) {
        this.color = obj;
        return this;
    }

    @d
    public final AADataElement dataLabels(@d AADataLabels aADataLabels) {
        this.dataLabels = aADataLabels;
        return this;
    }

    @d
    public final AADataElement marker(@d AAMarker aAMarker) {
        this.marker = aAMarker;
        return this;
    }

    @d
    public final AADataElement name(@d String str) {
        this.name = str;
        return this;
    }

    @d
    public final AADataElement x(@d Number number) {
        this.x = number;
        return this;
    }

    @d
    public final AADataElement y(@e Number number) {
        this.y = number;
        return this;
    }
}
