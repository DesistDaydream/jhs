package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u0002H\u0002 \u0003*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/KMutableProperty0Impl$Setter;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KMutableProperty0Impl$_setter$1 extends Lambda implements a<KMutableProperty0Impl.a<V>> {
    public final /* synthetic */ KMutableProperty0Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl$_setter$1(KMutableProperty0Impl kMutableProperty0Impl) {
        super(0);
        this.this$0 = kMutableProperty0Impl;
    }

    @Override // h.k2.u.a
    public final KMutableProperty0Impl.a<V> invoke() {
        return new KMutableProperty0Impl.a<>(this.this$0);
    }
}
