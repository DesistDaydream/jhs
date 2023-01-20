package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.k0;
import h.p2.b0.g.t.k.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0003 \u0001\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyGetterDescriptor;", "kotlin.jvm.PlatformType", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KPropertyImpl$Getter$descriptor$2 extends Lambda implements a<k0> {
    public final /* synthetic */ KPropertyImpl.Getter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl$Getter$descriptor$2(KPropertyImpl.Getter getter) {
        super(0);
        this.this$0 = getter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    public final k0 invoke() {
        k0 getter = this.this$0.N().J().getGetter();
        return getter != null ? getter : b.b(this.this$0.N().J(), e.w0.b());
    }
}
