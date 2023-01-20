package com.github.aachartmodel.aainfographics.aachartcreator;

import com.google.gson.internal.LinkedTreeMap;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b$\u0010%R0\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010!\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\u001c\u001a\u0004\b\"\u0010\u001e\"\u0004\b#\u0010 ¨\u0006&"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aachartcreator/AAMoveOverEventMessageModel;", "", "Lcom/google/gson/internal/LinkedTreeMap;", "", "offset", "Lcom/google/gson/internal/LinkedTreeMap;", "getOffset", "()Lcom/google/gson/internal/LinkedTreeMap;", "setOffset", "(Lcom/google/gson/internal/LinkedTreeMap;)V", "", "y", "Ljava/lang/Double;", "getY", "()Ljava/lang/Double;", "setY", "(Ljava/lang/Double;)V", "x", "getX", "setX", "", "index", "Ljava/lang/Integer;", "getIndex", "()Ljava/lang/Integer;", "setIndex", "(Ljava/lang/Integer;)V", "category", "Ljava/lang/String;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "name", "getName", "setName", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAMoveOverEventMessageModel {
    @e
    private String category;
    @e
    private Integer index;
    @e
    private String name;
    @e
    private LinkedTreeMap<String, Object> offset;
    @e
    private Double x;
    @e
    private Double y;

    @e
    public final String getCategory() {
        return this.category;
    }

    @e
    public final Integer getIndex() {
        return this.index;
    }

    @e
    public final String getName() {
        return this.name;
    }

    @e
    public final LinkedTreeMap<String, Object> getOffset() {
        return this.offset;
    }

    @e
    public final Double getX() {
        return this.x;
    }

    @e
    public final Double getY() {
        return this.y;
    }

    public final void setCategory(@e String str) {
        this.category = str;
    }

    public final void setIndex(@e Integer num) {
        this.index = num;
    }

    public final void setName(@e String str) {
        this.name = str;
    }

    public final void setOffset(@e LinkedTreeMap<String, Object> linkedTreeMap) {
        this.offset = linkedTreeMap;
    }

    public final void setX(@e Double d2) {
        this.x = d2;
    }

    public final void setY(@e Double d2) {
        this.y = d2;
    }
}
