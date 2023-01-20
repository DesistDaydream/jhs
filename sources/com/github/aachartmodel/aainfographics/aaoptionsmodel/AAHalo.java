package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bR.\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0002\b\u0003\u0018\u00010\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "", "Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASVGAttributes;", "prop", "attributes", "(Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASVGAttributes;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "", "opacity", "(Ljava/lang/Float;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "", "size", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AAHalo;", "", "", "Ljava/util/Map;", "getAttributes", "()Ljava/util/Map;", "setAttributes", "(Ljava/util/Map;)V", "Ljava/lang/Number;", "getSize", "()Ljava/lang/Number;", "setSize", "(Ljava/lang/Number;)V", "Ljava/lang/Float;", "getOpacity", "()Ljava/lang/Float;", "setOpacity", "(Ljava/lang/Float;)V", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAHalo {
    @e
    private Map<String, ?> attributes;
    @e
    private Float opacity;
    @e
    private Number size;

    @d
    public final AAHalo attributes(@e AASVGAttributes aASVGAttributes) {
        this.attributes = aASVGAttributes != null ? aASVGAttributes.toDic() : null;
        return this;
    }

    @e
    public final Map<String, ?> getAttributes() {
        return this.attributes;
    }

    @e
    public final Float getOpacity() {
        return this.opacity;
    }

    @e
    public final Number getSize() {
        return this.size;
    }

    @d
    public final AAHalo opacity(@e Float f2) {
        this.opacity = f2;
        return this;
    }

    public final void setAttributes(@e Map<String, ?> map) {
        this.attributes = map;
    }

    public final void setOpacity(@e Float f2) {
        this.opacity = f2;
    }

    public final void setSize(@e Number number) {
        this.size = number;
    }

    @d
    public final AAHalo size(@e Number number) {
        this.size = number;
        return this;
    }
}
