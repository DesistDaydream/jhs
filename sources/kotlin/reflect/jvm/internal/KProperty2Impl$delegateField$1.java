package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import java.lang.reflect.Field;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0006\b\u0002\u0010\u0004 \u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", "D", ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KProperty2Impl$delegateField$1 extends Lambda implements a<Field> {
    public final /* synthetic */ KProperty2Impl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KProperty2Impl$delegateField$1(KProperty2Impl kProperty2Impl) {
        super(0);
        this.this$0 = kProperty2Impl;
    }

    @Override // h.k2.u.a
    @e
    public final Field invoke() {
        return this.this$0.N();
    }
}
