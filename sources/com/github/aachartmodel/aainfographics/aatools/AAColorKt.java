package com.github.aachartmodel.aainfographics.aatools;

import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a/\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a/\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"", "red", "green", "blue", "", "alpha", "", "AARgba", "(IIIF)Ljava/lang/String;", "AARgb", "charts_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes.dex */
public final class AAColorKt {
    @d
    public static final String AARgb(int i2, int i3, int i4, float f2) {
        return AARgba(i2, i3, i4, 1.0f);
    }

    public static /* synthetic */ String AARgb$default(int i2, int i3, int i4, float f2, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            f2 = 1.0f;
        }
        return AARgb(i2, i3, i4, f2);
    }

    @d
    public static final String AARgba(int i2, int i3, int i4, float f2) {
        return "rgba(" + i2 + ',' + i3 + ',' + i4 + ',' + f2 + ')';
    }

    public static /* synthetic */ String AARgba$default(int i2, int i3, int i4, float f2, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            f2 = 1.0f;
        }
        return AARgba(i2, i3, i4, f2);
    }
}
