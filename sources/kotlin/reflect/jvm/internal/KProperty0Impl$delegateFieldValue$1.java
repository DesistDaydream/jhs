package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KProperty0Impl$delegateFieldValue$1 extends Lambda implements a<Object> {
    public final /* synthetic */ KProperty0Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty0Impl$delegateFieldValue$1(KProperty0Impl kProperty0Impl) {
        super(0);
        this.this$0 = kProperty0Impl;
    }

    @Override // h.k2.u.a
    @e
    public final Object invoke() {
        KProperty0Impl kProperty0Impl = this.this$0;
        return kProperty0Impl.P(kProperty0Impl.N(), this.this$0.O());
    }
}
