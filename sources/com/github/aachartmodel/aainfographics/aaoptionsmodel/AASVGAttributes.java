package com.github.aachartmodel.aainfographics.aaoptionsmodel;

import com.bytedance.msdk.adapter.util.TTLogUtil;
import java.util.HashMap;
import java.util.Map;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0004\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0004\b\u000b\u0010\fR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011¨\u0006\u001b"}, d2 = {"Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASVGAttributes;", "", "", "prop", TTLogUtil.TAG_EVENT_FILL, "(Ljava/lang/String;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASVGAttributes;", "stroke", "", "strokeWidth", "(Ljava/lang/Number;)Lcom/github/aachartmodel/aainfographics/aaoptionsmodel/AASVGAttributes;", "", "toDic", "()Ljava/util/Map;", "Ljava/lang/String;", "getFill", "()Ljava/lang/String;", "setFill", "(Ljava/lang/String;)V", "Ljava/lang/Number;", "getStrokeWidth", "()Ljava/lang/Number;", "setStrokeWidth", "(Ljava/lang/Number;)V", "getStroke", "setStroke", "<init>", "()V", "charts_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AASVGAttributes {
    @e
    private String fill;
    @e
    private String stroke;
    @e
    private Number strokeWidth;

    @d
    public final AASVGAttributes fill(@e String str) {
        this.fill = str;
        return this;
    }

    @e
    public final String getFill() {
        return this.fill;
    }

    @e
    public final String getStroke() {
        return this.stroke;
    }

    @e
    public final Number getStrokeWidth() {
        return this.strokeWidth;
    }

    public final void setFill(@e String str) {
        this.fill = str;
    }

    public final void setStroke(@e String str) {
        this.stroke = str;
    }

    public final void setStrokeWidth(@e Number number) {
        this.strokeWidth = number;
    }

    @d
    public final AASVGAttributes stroke(@e String str) {
        this.stroke = str;
        return this;
    }

    @d
    public final AASVGAttributes strokeWidth(@e Number number) {
        this.strokeWidth = number;
        return this;
    }

    @d
    public final Map<String, Object> toDic() {
        HashMap hashMap = new HashMap();
        Number number = this.strokeWidth;
        if (number != null) {
            hashMap.put("stroke-width", number);
        }
        String str = this.fill;
        if (str != null) {
            hashMap.put(TTLogUtil.TAG_EVENT_FILL, str);
        }
        String str2 = this.stroke;
        if (str2 != null) {
            hashMap.put("stroke", str2);
        }
        return hashMap;
    }
}
