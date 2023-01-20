package kotlin.reflect.jvm.internal.impl.builtins;

import h.k2.v.n0;
import h.p2.b0.g.t.c.c0;
import h.p2.b0.g.t.c.c1.a;
import h.p2.b0.g.t.c.c1.b;
import h.p2.b0.g.t.c.c1.c;
import h.p2.b0.g.t.m.m;
import h.p2.n;
import h.w;
import h.z;
import k.e.a.d;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes3.dex */
public interface BuiltInsLoader {
    @d
    public static final Companion a = Companion.a;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ n<Object>[] b = {n0.r(new PropertyReference1Impl(n0.d(Companion.class), "Instance", "getInstance()Lorg/jetbrains/kotlin/builtins/BuiltInsLoader;"))};
        public static final /* synthetic */ Companion a = new Companion();
        @d

        /* renamed from: c  reason: collision with root package name */
        private static final w<BuiltInsLoader> f16410c = z.b(LazyThreadSafetyMode.PUBLICATION, BuiltInsLoader$Companion$Instance$2.INSTANCE);

        private Companion() {
        }

        @d
        public final BuiltInsLoader a() {
            return f16410c.getValue();
        }
    }

    @d
    c0 a(@d m mVar, @d h.p2.b0.g.t.c.z zVar, @d Iterable<? extends b> iterable, @d c cVar, @d a aVar, boolean z);
}
