package com.vector.ext;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.w;
import h.z;
import k.e.a.d;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u001b\u0010\r\u001a\u00028\u00008FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/vector/ext/LazyData;", ExifInterface.GPS_DIRECTION_TRUE, "", "mode", "Lkotlin/LazyThreadSafetyMode;", "initializer", "Lkotlin/Function0;", "(Lkotlin/LazyThreadSafetyMode;Lkotlin/jvm/functions/Function0;)V", "delegate", "Lkotlin/Lazy;", "isInitialized", "", "()Z", "value", "getValue", "()Ljava/lang/Object;", "value$delegate", "Lkotlin/Lazy;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LazyData<T> {
    @d
    private final a<T> a;
    @d
    private final w<T> b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final w f7807c;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyData(@d LazyThreadSafetyMode lazyThreadSafetyMode, @d a<? extends T> aVar) {
        this.a = aVar;
        w<T> b = z.b(lazyThreadSafetyMode, new LazyData$delegate$1(this));
        this.b = b;
        this.f7807c = b;
    }

    public final T b() {
        return (T) this.f7807c.getValue();
    }

    public final boolean c() {
        return this.b.isInitialized();
    }
}
