package com.vector.util;

import h.w;
import h.z;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/vector/util/SizeofUtil;", "", "()V", "longSizeTable", "", "getLongSizeTable", "()[J", "longSizeTable$delegate", "Lkotlin/Lazy;", "ofLong", "", "x", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SizeofUtil {
    @d
    public static final SizeofUtil a = new SizeofUtil();
    @d
    private static final w b = z.c(SizeofUtil$longSizeTable$2.INSTANCE);

    private SizeofUtil() {
    }

    private final long[] a() {
        return (long[]) b.getValue();
    }

    public final int b(long j2) {
        int i2 = 0;
        while (j2 > a()[i2]) {
            i2++;
        }
        return i2 + 1;
    }
}
