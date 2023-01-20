package kotlin.reflect.jvm.internal.impl.load.java.components;

import h.a2.d1;
import h.a2.t0;
import h.a2.u;
import h.a2.y;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.e.a.x.b;
import h.p2.b0.g.t.e.a.x.m;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.n.g;
import h.p2.b0.g.t.k.n.i;
import h.z0;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinRetention;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.KotlinTarget;

/* loaded from: classes3.dex */
public final class JavaAnnotationTargetMapper {
    @d
    public static final JavaAnnotationTargetMapper a = new JavaAnnotationTargetMapper();
    @d
    private static final Map<String, EnumSet<KotlinTarget>> b = t0.W(z0.a("PACKAGE", EnumSet.noneOf(KotlinTarget.class)), z0.a("TYPE", EnumSet.of(KotlinTarget.CLASS, KotlinTarget.FILE)), z0.a("ANNOTATION_TYPE", EnumSet.of(KotlinTarget.ANNOTATION_CLASS)), z0.a("TYPE_PARAMETER", EnumSet.of(KotlinTarget.TYPE_PARAMETER)), z0.a("FIELD", EnumSet.of(KotlinTarget.FIELD)), z0.a("LOCAL_VARIABLE", EnumSet.of(KotlinTarget.LOCAL_VARIABLE)), z0.a("PARAMETER", EnumSet.of(KotlinTarget.VALUE_PARAMETER)), z0.a("CONSTRUCTOR", EnumSet.of(KotlinTarget.CONSTRUCTOR)), z0.a("METHOD", EnumSet.of(KotlinTarget.FUNCTION, KotlinTarget.PROPERTY_GETTER, KotlinTarget.PROPERTY_SETTER)), z0.a("TYPE_USE", EnumSet.of(KotlinTarget.TYPE)));
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, KotlinRetention> f16495c = t0.W(z0.a("RUNTIME", KotlinRetention.RUNTIME), z0.a("CLASS", KotlinRetention.BINARY), z0.a("SOURCE", KotlinRetention.SOURCE));

    private JavaAnnotationTargetMapper() {
    }

    @e
    public final g<?> a(@e b bVar) {
        m mVar = bVar instanceof m ? (m) bVar : null;
        if (mVar == null) {
            return null;
        }
        Map<String, KotlinRetention> map = f16495c;
        f e2 = mVar.e();
        KotlinRetention kotlinRetention = map.get(e2 == null ? null : e2.b());
        if (kotlinRetention == null) {
            return null;
        }
        return new i(h.p2.b0.g.t.g.b.m(g.a.H), f.f(kotlinRetention.name()));
    }

    @d
    public final Set<KotlinTarget> b(@e String str) {
        EnumSet<KotlinTarget> enumSet = b.get(str);
        return enumSet == null ? d1.k() : enumSet;
    }

    @d
    public final h.p2.b0.g.t.k.n.g<?> c(@d List<? extends b> list) {
        ArrayList<m> arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof m) {
                arrayList.add(obj);
            }
        }
        ArrayList<KotlinTarget> arrayList2 = new ArrayList();
        for (m mVar : arrayList) {
            JavaAnnotationTargetMapper javaAnnotationTargetMapper = a;
            f e2 = mVar.e();
            y.q0(arrayList2, javaAnnotationTargetMapper.b(e2 == null ? null : e2.b()));
        }
        ArrayList arrayList3 = new ArrayList(u.Y(arrayList2, 10));
        for (KotlinTarget kotlinTarget : arrayList2) {
            arrayList3.add(new i(h.p2.b0.g.t.g.b.m(g.a.G), f.f(kotlinTarget.name())));
        }
        return new h.p2.b0.g.t.k.n.b(arrayList3, JavaAnnotationTargetMapper$mapJavaTargetArguments$1.INSTANCE);
    }
}
