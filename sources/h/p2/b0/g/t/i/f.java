package h.p2.b0.g.t.i;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* loaded from: classes3.dex */
public class f {
    private static volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static final f f15440c = new f(true);
    private final Map<a, GeneratedMessageLite.f<?, ?>> a;

    /* loaded from: classes3.dex */
    public static final class a {
        private final Object a;
        private final int b;

        public a(Object obj, int i2) {
            this.a = obj;
            this.b = i2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a == aVar.a && this.b == aVar.b;
            }
            return false;
        }

        public int hashCode() {
            return (System.identityHashCode(this.a) * 65535) + this.b;
        }
    }

    public f() {
        this.a = new HashMap();
    }

    public static f c() {
        return f15440c;
    }

    public static f d() {
        return new f();
    }

    public final void a(GeneratedMessageLite.f<?, ?> fVar) {
        this.a.put(new a(fVar.b(), fVar.d()), fVar);
    }

    public <ContainingType extends n> GeneratedMessageLite.f<ContainingType, ?> b(ContainingType containingtype, int i2) {
        return (GeneratedMessageLite.f<ContainingType, ?>) this.a.get(new a(containingtype, i2));
    }

    private f(boolean z) {
        this.a = Collections.emptyMap();
    }
}
