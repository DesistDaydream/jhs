package kotlin.reflect.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import h.k2.u.a;
import h.p2.b0.g.t.b.b;
import h.p2.b0.g.t.c.d;
import java.lang.reflect.Field;
import java.util.Objects;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.impl.builtins.CompanionObjectMapping;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", ExifInterface.GPS_DIRECTION_TRUE, "", "invoke", "()Ljava/lang/Object;"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KClassImpl$Data$objectInstance$2 extends Lambda implements a<T> {
    public final /* synthetic */ KClassImpl.Data this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KClassImpl$Data$objectInstance$2(KClassImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [T, java.lang.Object] */
    @Override // h.k2.u.a
    @e
    public final T invoke() {
        Field declaredField;
        d o = this.this$0.o();
        if (o.i() != ClassKind.OBJECT) {
            return null;
        }
        if (o.a0() && !b.a(CompanionObjectMapping.a, o)) {
            declaredField = KClassImpl.this.d().getEnclosingClass().getDeclaredField(o.getName().b());
        } else {
            declaredField = KClassImpl.this.d().getDeclaredField("INSTANCE");
        }
        ?? r0 = declaredField.get(null);
        Objects.requireNonNull(r0, "null cannot be cast to non-null type T");
        return r0;
    }
}
