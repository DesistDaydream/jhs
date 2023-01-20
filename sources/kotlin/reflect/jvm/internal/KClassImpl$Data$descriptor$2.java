package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.p2.b0.g.t.c.d;
import h.p2.b0.g.t.c.f1.a.k;
import h.p2.b0.g.t.g.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.FindClassInModuleKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "kotlin.jvm.PlatformType", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$descriptor$2 extends Lambda implements a<d> {
    public final /* synthetic */ KClassImpl.Data this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$descriptor$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    public final d invoke() {
        b X;
        X = KClassImpl.this.X();
        k a = ((KClassImpl.Data) KClassImpl.this.Y().invoke()).a();
        d b = X.k() ? a.a().b(X) : FindClassInModuleKt.a(a.b(), X);
        if (b != null) {
            return b;
        }
        KClassImpl.this.c0();
        throw null;
    }
}
