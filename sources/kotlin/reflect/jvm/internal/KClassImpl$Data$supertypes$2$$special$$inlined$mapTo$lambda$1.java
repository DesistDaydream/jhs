package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.k2.v.f0;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.n.z;
import java.lang.reflect.Type;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "Ljava/lang/reflect/Type;", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "kotlin/reflect/jvm/internal/KClassImpl$Data$supertypes$2$1$1"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1 extends Lambda implements a<Type> {
    public final /* synthetic */ z $kotlinType;
    public final /* synthetic */ KClassImpl$Data$supertypes$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$supertypes$2$$special$$inlined$mapTo$lambda$1(z zVar, KClassImpl$Data$supertypes$2 kClassImpl$Data$supertypes$2) {
        super(0);
        this.$kotlinType = zVar;
        this.this$0 = kClassImpl$Data$supertypes$2;
    }

    @Override // h.k2.u.a
    @d
    public final Type invoke() {
        f c2 = this.$kotlinType.I0().c();
        if (c2 instanceof h.p2.b0.g.t.c.d) {
            Class<?> o = q.o((h.p2.b0.g.t.c.d) c2);
            if (o != null) {
                if (f0.g(KClassImpl.this.d().getSuperclass(), o)) {
                    return KClassImpl.this.d().getGenericSuperclass();
                }
                int ff = ArraysKt___ArraysKt.ff(KClassImpl.this.d().getInterfaces(), o);
                if (ff >= 0) {
                    return KClassImpl.this.d().getGenericInterfaces()[ff];
                }
                throw new KotlinReflectionInternalError("No superclass of " + this.this$0.this$0 + " in Java reflection for " + c2);
            }
            throw new KotlinReflectionInternalError("Unsupported superclass of " + this.this$0.this$0 + ": " + c2);
        }
        throw new KotlinReflectionInternalError("Supertype not a class: " + c2);
    }
}
