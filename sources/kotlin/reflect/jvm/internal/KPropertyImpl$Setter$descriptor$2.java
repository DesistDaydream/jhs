package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.p2.b0.g.t.c.b1.e;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.l0;
import h.p2.b0.g.t.k.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPropertyImpl;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0003\"\u0006\b\u0001\u0010\u0003 \u0001H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertySetterDescriptor;", "kotlin.jvm.PlatformType", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KPropertyImpl$Setter$descriptor$2 extends Lambda implements a<l0> {
    public final /* synthetic */ KPropertyImpl.Setter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl$Setter$descriptor$2(KPropertyImpl.Setter setter) {
        super(0);
        this.this$0 = setter;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    public final l0 invoke() {
        l0 setter = this.this$0.N().J().getSetter();
        if (setter != null) {
            return setter;
        }
        j0 J = this.this$0.N().J();
        e.a aVar = e.w0;
        return b.c(J, aVar.b(), aVar.b());
    }
}
