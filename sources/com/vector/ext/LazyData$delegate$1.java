package com.vector.ext;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001H\n"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LazyData$delegate$1 extends Lambda implements a<T> {
    public final /* synthetic */ LazyData<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyData$delegate$1(LazyData<T> lazyData) {
        super(0);
        this.this$0 = lazyData;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Object] */
    @Override // h.k2.u.a
    public final T invoke() {
        a aVar;
        aVar = ((LazyData) this.this$0).a;
        return aVar.invoke();
    }
}
