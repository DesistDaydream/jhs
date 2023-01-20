package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.p2.b0.g.d;
import h.p2.b0.g.o;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.e.a.f;
import h.p2.b0.g.t.f.a0.f.d;
import h.p2.b0.g.t.f.a0.f.g;
import java.lang.reflect.Field;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002 \u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Field;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KPropertyImpl$_javaField$1 extends Lambda implements a<Field> {
    public final /* synthetic */ KPropertyImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPropertyImpl$_javaField$1(KPropertyImpl kPropertyImpl) {
        super(0);
        this.this$0 = kPropertyImpl;
    }

    @Override // h.k2.u.a
    @e
    public final Field invoke() {
        Class<?> enclosingClass;
        d f2 = o.b.f(this.this$0.J());
        if (f2 instanceof d.c) {
            d.c cVar = (d.c) f2;
            j0 b = cVar.b();
            d.a d2 = g.d(g.a, cVar.e(), cVar.d(), cVar.g(), false, 8, null);
            if (d2 != null) {
                if (!f.e(b) && !g.f(cVar.e())) {
                    k b2 = b.b();
                    enclosingClass = b2 instanceof h.p2.b0.g.t.c.d ? q.o((h.p2.b0.g.t.c.d) b2) : this.this$0.H().d();
                } else {
                    enclosingClass = this.this$0.H().d().getEnclosingClass();
                }
                if (enclosingClass != null) {
                    try {
                        return enclosingClass.getDeclaredField(d2.c());
                    } catch (NoSuchFieldException unused) {
                        return null;
                    }
                }
                return null;
            }
            return null;
        } else if (f2 instanceof d.a) {
            return ((d.a) f2).b();
        } else {
            if ((f2 instanceof d.b) || (f2 instanceof d.C0427d)) {
                return null;
            }
            throw new NoWhenBranchMatchedException();
        }
    }
}
