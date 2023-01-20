package h.p2.b0.g.t.c.f1.b;

import h.p2.b0.g.t.c.a1;
import h.p2.b0.g.t.c.e1.a;
import h.p2.b0.g.t.c.z0;
import java.lang.reflect.Modifier;

/* loaded from: classes3.dex */
public interface r extends h.p2.b0.g.t.e.a.x.s {

    /* loaded from: classes3.dex */
    public static final class a {
        @k.e.a.d
        public static a1 a(@k.e.a.d r rVar) {
            int I = rVar.I();
            if (Modifier.isPublic(I)) {
                return z0.h.f15228c;
            }
            if (Modifier.isPrivate(I)) {
                return z0.e.f15225c;
            }
            if (Modifier.isProtected(I)) {
                return Modifier.isStatic(I) ? a.c.f15189c : a.b.f15188c;
            }
            return a.C0440a.f15187c;
        }

        public static boolean b(@k.e.a.d r rVar) {
            return Modifier.isAbstract(rVar.I());
        }

        public static boolean c(@k.e.a.d r rVar) {
            return Modifier.isFinal(rVar.I());
        }

        public static boolean d(@k.e.a.d r rVar) {
            return Modifier.isStatic(rVar.I());
        }
    }

    int I();
}
