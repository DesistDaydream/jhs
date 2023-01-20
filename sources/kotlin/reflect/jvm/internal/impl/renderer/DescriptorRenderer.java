package kotlin.reflect.jvm.internal.impl.renderer;

import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.u;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.c.b1.c;
import h.p2.b0.g.t.c.g;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.n.z;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;

/* loaded from: classes3.dex */
public abstract class DescriptorRenderer {
    @d
    public static final a a;
    @h.k2.d
    @d
    public static final DescriptorRenderer b;
    @h.k2.d
    @d

    /* renamed from: c */
    public static final DescriptorRenderer f16746c;
    @h.k2.d
    @d

    /* renamed from: d */
    public static final DescriptorRenderer f16747d;
    @h.k2.d
    @d

    /* renamed from: e */
    public static final DescriptorRenderer f16748e;
    @h.k2.d
    @d

    /* renamed from: f */
    public static final DescriptorRenderer f16749f;
    @h.k2.d
    @d

    /* renamed from: g */
    public static final DescriptorRenderer f16750g;
    @h.k2.d
    @d

    /* renamed from: h */
    public static final DescriptorRenderer f16751h;
    @h.k2.d
    @d

    /* renamed from: i */
    public static final DescriptorRenderer f16752i;
    @h.k2.d
    @d

    /* renamed from: j */
    public static final DescriptorRenderer f16753j;
    @h.k2.d
    @d

    /* renamed from: k */
    public static final DescriptorRenderer f16754k;

    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer$a$a */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0496a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[ClassKind.values().length];
                iArr[ClassKind.CLASS.ordinal()] = 1;
                iArr[ClassKind.INTERFACE.ordinal()] = 2;
                iArr[ClassKind.ENUM_CLASS.ordinal()] = 3;
                iArr[ClassKind.OBJECT.ordinal()] = 4;
                iArr[ClassKind.ANNOTATION_CLASS.ordinal()] = 5;
                iArr[ClassKind.ENUM_ENTRY.ordinal()] = 6;
                a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final String a(@d g gVar) {
            if (gVar instanceof s0) {
                return "typealias";
            }
            if (gVar instanceof h.p2.b0.g.t.c.d) {
                h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) gVar;
                if (dVar.a0()) {
                    return "companion object";
                }
                switch (C0496a.a[dVar.i().ordinal()]) {
                    case 1:
                        return "class";
                    case 2:
                        return "interface";
                    case 3:
                        return "enum class";
                    case 4:
                        return "object";
                    case 5:
                        return "annotation class";
                    case 6:
                        return "enum entry";
                    default:
                        throw new NoWhenBranchMatchedException();
                }
            }
            throw new AssertionError(f0.C("Unexpected classifier: ", gVar));
        }

        @d
        public final DescriptorRenderer b(@d l<? super h.p2.b0.g.t.j.b, t1> lVar) {
            DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
            lVar.invoke(descriptorRendererOptionsImpl);
            descriptorRendererOptionsImpl.n0();
            return new DescriptorRendererImpl(descriptorRendererOptionsImpl);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {

        /* loaded from: classes3.dex */
        public static final class a implements b {
            @d
            public static final a a = new a();

            private a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.b
            public void a(@d v0 v0Var, int i2, int i3, @d StringBuilder sb) {
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.b
            public void b(int i2, @d StringBuilder sb) {
                sb.append("(");
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.b
            public void c(@d v0 v0Var, int i2, int i3, @d StringBuilder sb) {
                if (i2 != i3 - 1) {
                    sb.append(", ");
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer.b
            public void d(int i2, @d StringBuilder sb) {
                sb.append(")");
            }
        }

        void a(@d v0 v0Var, int i2, int i3, @d StringBuilder sb);

        void b(int i2, @d StringBuilder sb);

        void c(@d v0 v0Var, int i2, int i3, @d StringBuilder sb);

        void d(int i2, @d StringBuilder sb);
    }

    static {
        a aVar = new a(null);
        a = aVar;
        b = aVar.b(DescriptorRenderer$Companion$COMPACT_WITH_MODIFIERS$1.INSTANCE);
        f16746c = aVar.b(DescriptorRenderer$Companion$COMPACT$1.INSTANCE);
        f16747d = aVar.b(DescriptorRenderer$Companion$COMPACT_WITHOUT_SUPERTYPES$1.INSTANCE);
        f16748e = aVar.b(DescriptorRenderer$Companion$COMPACT_WITH_SHORT_TYPES$1.INSTANCE);
        f16749f = aVar.b(DescriptorRenderer$Companion$ONLY_NAMES_WITH_SHORT_TYPES$1.INSTANCE);
        f16750g = aVar.b(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES$1.INSTANCE);
        f16751h = aVar.b(DescriptorRenderer$Companion$FQ_NAMES_IN_TYPES_WITH_ANNOTATIONS$1.INSTANCE);
        f16752i = aVar.b(DescriptorRenderer$Companion$SHORT_NAMES_IN_TYPES$1.INSTANCE);
        f16753j = aVar.b(DescriptorRenderer$Companion$DEBUG_TEXT$1.INSTANCE);
        f16754k = aVar.b(DescriptorRenderer$Companion$HTML$1.INSTANCE);
    }

    public static /* synthetic */ String u(DescriptorRenderer descriptorRenderer, c cVar, AnnotationUseSiteTarget annotationUseSiteTarget, int i2, Object obj) {
        if (obj == null) {
            if ((i2 & 2) != 0) {
                annotationUseSiteTarget = null;
            }
            return descriptorRenderer.t(cVar, annotationUseSiteTarget);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: renderAnnotation");
    }

    @d
    public final DescriptorRenderer A(@d l<? super h.p2.b0.g.t.j.b, t1> lVar) {
        DescriptorRendererOptionsImpl s = ((DescriptorRendererImpl) this).j0().s();
        lVar.invoke(s);
        s.n0();
        return new DescriptorRendererImpl(s);
    }

    @d
    public abstract String s(@d k kVar);

    @d
    public abstract String t(@d c cVar, @e AnnotationUseSiteTarget annotationUseSiteTarget);

    @d
    public abstract String v(@d String str, @d String str2, @d f fVar);

    @d
    public abstract String w(@d h.p2.b0.g.t.g.d dVar);

    @d
    public abstract String x(@d h.p2.b0.g.t.g.f fVar, boolean z);

    @d
    public abstract String y(@d z zVar);

    @d
    public abstract String z(@d h.p2.b0.g.t.n.s0 s0Var);
}
