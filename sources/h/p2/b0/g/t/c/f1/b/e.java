package h.p2.b0.g.t.c.f1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public interface e extends h.p2.b0.g.t.e.a.x.d {

    /* loaded from: classes3.dex */
    public static final class a {
        @k.e.a.e
        public static b a(@k.e.a.d e eVar, @k.e.a.d h.p2.b0.g.t.g.c cVar) {
            Annotation[] declaredAnnotations;
            AnnotatedElement r = eVar.r();
            if (r == null || (declaredAnnotations = r.getDeclaredAnnotations()) == null) {
                return null;
            }
            return f.a(declaredAnnotations, cVar);
        }

        @k.e.a.d
        public static List<b> b(@k.e.a.d e eVar) {
            AnnotatedElement r = eVar.r();
            Annotation[] declaredAnnotations = r == null ? null : r.getDeclaredAnnotations();
            return declaredAnnotations == null ? CollectionsKt__CollectionsKt.E() : f.b(declaredAnnotations);
        }

        public static boolean c(@k.e.a.d e eVar) {
            return false;
        }
    }

    @k.e.a.e
    AnnotatedElement r();
}
