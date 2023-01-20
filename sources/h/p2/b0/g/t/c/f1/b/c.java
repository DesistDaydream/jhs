package h.p2.b0.g.t.c.f1.b;

import java.lang.annotation.Annotation;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* loaded from: classes3.dex */
public abstract class c implements h.p2.b0.g.t.e.a.x.b {
    @k.e.a.d
    public static final a b = new a(null);
    @k.e.a.e
    private final h.p2.b0.g.t.g.f a;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        @k.e.a.d
        public final c a(@k.e.a.d Object obj, @k.e.a.e h.p2.b0.g.t.g.f fVar) {
            return ReflectClassUtilKt.h(obj.getClass()) ? new m(fVar, (Enum) obj) : obj instanceof Annotation ? new d(fVar, (Annotation) obj) : obj instanceof Object[] ? new g(fVar, (Object[]) obj) : obj instanceof Class ? new i(fVar, (Class) obj) : new o(fVar, obj);
        }
    }

    private c(h.p2.b0.g.t.g.f fVar) {
        this.a = fVar;
    }

    public /* synthetic */ c(h.p2.b0.g.t.g.f fVar, h.k2.v.u uVar) {
        this(fVar);
    }

    @Override // h.p2.b0.g.t.e.a.x.b
    @k.e.a.e
    public h.p2.b0.g.t.g.f getName() {
        return this.a;
    }
}
