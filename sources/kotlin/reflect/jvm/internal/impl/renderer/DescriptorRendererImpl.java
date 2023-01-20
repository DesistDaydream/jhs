package kotlin.reflect.jvm.internal.impl.renderer;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.Constants;
import h.a2.t;
import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.b.e;
import h.p2.b0.g.t.b.f;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.h0;
import h.p2.b0.g.t.c.i0;
import h.p2.b0.g.t.c.j;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.k0;
import h.p2.b0.g.t.c.l0;
import h.p2.b0.g.t.c.m;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.n;
import h.p2.b0.g.t.c.r;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.u;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.c.x0;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.g.h;
import h.p2.b0.g.t.k.c;
import h.p2.b0.g.t.k.n.o;
import h.p2.b0.g.t.n.a0;
import h.p2.b0.g.t.n.b1;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.d1;
import h.p2.b0.g.t.n.q0;
import h.p2.b0.g.t.n.s;
import h.p2.b0.g.t.n.y0;
import h.t1;
import h.t2.y;
import h.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import k.e.a.d;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.NotFoundClasses;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterUtilsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.AnnotationUseSiteTarget;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

/* loaded from: classes3.dex */
public final class DescriptorRendererImpl extends DescriptorRenderer implements h.p2.b0.g.t.j.b {
    @d

    /* renamed from: l  reason: collision with root package name */
    private final DescriptorRendererOptionsImpl f16755l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final w f16756m;

    /* loaded from: classes3.dex */
    public final class a implements m<t1, StringBuilder> {

        /* renamed from: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public /* synthetic */ class C0497a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[PropertyAccessorRenderingPolicy.values().length];
                iArr[PropertyAccessorRenderingPolicy.PRETTY.ordinal()] = 1;
                iArr[PropertyAccessorRenderingPolicy.DEBUG.ordinal()] = 2;
                iArr[PropertyAccessorRenderingPolicy.NONE.ordinal()] = 3;
                a = iArr;
            }
        }

        public a() {
        }

        private final void t(i0 i0Var, StringBuilder sb, String str) {
            int i2 = C0497a.a[DescriptorRendererImpl.this.o0().ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    return;
                }
                p(i0Var, sb);
                return;
            }
            DescriptorRendererImpl.this.U0(i0Var, sb);
            sb.append(f0.C(str, " for "));
            DescriptorRendererImpl.this.B1(i0Var.V(), sb);
        }

        public void A(@d v0 v0Var, @d StringBuilder sb) {
            DescriptorRendererImpl.this.T1(v0Var, true, sb, true);
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 a(h.p2.b0.g.t.c.d dVar, StringBuilder sb) {
            n(dVar, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 b(h.p2.b0.g.t.c.f0 f0Var, StringBuilder sb) {
            s(f0Var, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 c(j0 j0Var, StringBuilder sb) {
            u(j0Var, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 d(s0 s0Var, StringBuilder sb) {
            y(s0Var, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 e(l0 l0Var, StringBuilder sb) {
            w(l0Var, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 f(v0 v0Var, StringBuilder sb) {
            A(v0Var, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 g(k0 k0Var, StringBuilder sb) {
            v(k0Var, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 h(b0 b0Var, StringBuilder sb) {
            r(b0Var, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 i(v vVar, StringBuilder sb) {
            p(vVar, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 j(j jVar, StringBuilder sb) {
            o(jVar, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 k(z zVar, StringBuilder sb) {
            q(zVar, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 l(m0 m0Var, StringBuilder sb) {
            x(m0Var, sb);
            return t1.a;
        }

        @Override // h.p2.b0.g.t.c.m
        public /* bridge */ /* synthetic */ t1 m(t0 t0Var, StringBuilder sb) {
            z(t0Var, sb);
            return t1.a;
        }

        public void n(@d h.p2.b0.g.t.c.d dVar, @d StringBuilder sb) {
            DescriptorRendererImpl.this.a1(dVar, sb);
        }

        public void o(@d j jVar, @d StringBuilder sb) {
            DescriptorRendererImpl.this.f1(jVar, sb);
        }

        public void p(@d v vVar, @d StringBuilder sb) {
            DescriptorRendererImpl.this.j1(vVar, sb);
        }

        public void q(@d z zVar, @d StringBuilder sb) {
            DescriptorRendererImpl.this.t1(zVar, sb, true);
        }

        public void r(@d b0 b0Var, @d StringBuilder sb) {
            DescriptorRendererImpl.this.x1(b0Var, sb);
        }

        public void s(@d h.p2.b0.g.t.c.f0 f0Var, @d StringBuilder sb) {
            DescriptorRendererImpl.this.z1(f0Var, sb);
        }

        public void u(@d j0 j0Var, @d StringBuilder sb) {
            DescriptorRendererImpl.this.B1(j0Var, sb);
        }

        public void v(@d k0 k0Var, @d StringBuilder sb) {
            t(k0Var, sb, "getter");
        }

        public void w(@d l0 l0Var, @d StringBuilder sb) {
            t(l0Var, sb, "setter");
        }

        public void x(@d m0 m0Var, @d StringBuilder sb) {
            sb.append(m0Var.getName());
        }

        public void y(@d s0 s0Var, @d StringBuilder sb) {
            DescriptorRendererImpl.this.J1(s0Var, sb);
        }

        public void z(@d t0 t0Var, @d StringBuilder sb) {
            DescriptorRendererImpl.this.O1(t0Var, sb, true);
        }
    }

    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[RenderingFormat.values().length];
            iArr[RenderingFormat.PLAIN.ordinal()] = 1;
            iArr[RenderingFormat.HTML.ordinal()] = 2;
            a = iArr;
            int[] iArr2 = new int[ParameterNameRenderingPolicy.values().length];
            iArr2[ParameterNameRenderingPolicy.ALL.ordinal()] = 1;
            iArr2[ParameterNameRenderingPolicy.ONLY_NON_SYNTHESIZED.ordinal()] = 2;
            iArr2[ParameterNameRenderingPolicy.NONE.ordinal()] = 3;
            b = iArr2;
        }
    }

    public DescriptorRendererImpl(@d DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
        this.f16755l = descriptorRendererOptionsImpl;
        descriptorRendererOptionsImpl.m0();
        this.f16756m = h.z.c(new DescriptorRendererImpl$functionTypeAnnotationsRenderer$2(this));
    }

    private final void A1(StringBuilder sb, h0 h0Var) {
        StringBuilder sb2;
        h0 c2 = h0Var.c();
        if (c2 == null) {
            sb2 = null;
        } else {
            A1(sb, c2);
            sb.append('.');
            sb.append(x(h0Var.b().getName(), false));
            sb2 = sb;
        }
        if (sb2 == null) {
            sb.append(L1(h0Var.b().j()));
        }
        sb.append(K1(h0Var.a()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B1(j0 j0Var, StringBuilder sb) {
        if (!B0()) {
            if (!A0()) {
                C1(j0Var, sb);
                W1(j0Var.getVisibility(), sb);
                boolean z = false;
                s1(sb, h0().contains(DescriptorRendererModifier.CONST) && j0Var.isConst(), "const");
                o1(j0Var, sb);
                r1(j0Var, sb);
                w1(j0Var, sb);
                if (h0().contains(DescriptorRendererModifier.LATEINIT) && j0Var.v0()) {
                    z = true;
                }
                s1(sb, z, "lateinit");
                n1(j0Var, sb);
            }
            S1(this, j0Var, sb, false, 4, null);
            Q1(j0Var.getTypeParameters(), sb, true);
            D1(j0Var, sb);
        }
        t1(j0Var, sb, true);
        sb.append(": ");
        sb.append(y(j0Var.getType()));
        E1(j0Var, sb);
        l1(j0Var, sb);
        X1(j0Var.getTypeParameters(), sb);
    }

    private final void C1(j0 j0Var, StringBuilder sb) {
        if (h0().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Y0(this, sb, j0Var, null, 2, null);
            u u0 = j0Var.u0();
            if (u0 != null) {
                X0(sb, u0, AnnotationUseSiteTarget.FIELD);
            }
            u R = j0Var.R();
            if (R != null) {
                X0(sb, R, AnnotationUseSiteTarget.PROPERTY_DELEGATE_FIELD);
            }
            if (o0() == PropertyAccessorRenderingPolicy.NONE) {
                k0 getter = j0Var.getGetter();
                if (getter != null) {
                    X0(sb, getter, AnnotationUseSiteTarget.PROPERTY_GETTER);
                }
                l0 setter = j0Var.getSetter();
                if (setter == null) {
                    return;
                }
                X0(sb, setter, AnnotationUseSiteTarget.PROPERTY_SETTER);
                X0(sb, (v0) CollectionsKt___CollectionsKt.U4(setter.h()), AnnotationUseSiteTarget.SETTER_PARAMETER);
            }
        }
    }

    private final void D1(h.p2.b0.g.t.c.a aVar, StringBuilder sb) {
        m0 Q = aVar.Q();
        if (Q != null) {
            X0(sb, Q, AnnotationUseSiteTarget.RECEIVER);
            h.p2.b0.g.t.n.z type = Q.getType();
            String y = y(type);
            if (Z1(type) && !y0.l(type)) {
                y = '(' + y + ')';
            }
            sb.append(y);
            sb.append(".");
        }
    }

    private final void E1(h.p2.b0.g.t.c.a aVar, StringBuilder sb) {
        m0 Q;
        if (p0() && (Q = aVar.Q()) != null) {
            sb.append(" on ");
            sb.append(y(Q.getType()));
        }
    }

    private final void F1(StringBuilder sb, h.p2.b0.g.t.n.f0 f0Var) {
        if (!f0.g(f0Var, y0.b) && !y0.k(f0Var)) {
            if (s.t(f0Var)) {
                if (E0()) {
                    sb.append(h1(((s.f) f0Var.I0()).f().getName().toString()));
                    return;
                } else {
                    sb.append("???");
                    return;
                }
            } else if (a0.a(f0Var)) {
                g1(sb, f0Var);
                return;
            } else if (Z1(f0Var)) {
                k1(sb, f0Var);
                return;
            } else {
                g1(sb, f0Var);
                return;
            }
        }
        sb.append("???");
    }

    private final void G1(StringBuilder sb) {
        int length = sb.length();
        if (length == 0 || sb.charAt(length - 1) != ' ') {
            sb.append(' ');
        }
    }

    private final void H1(h.p2.b0.g.t.c.d dVar, StringBuilder sb) {
        if (L0() || f.k0(dVar.r())) {
            return;
        }
        Collection<h.p2.b0.g.t.n.z> j2 = dVar.j().j();
        if (j2.isEmpty()) {
            return;
        }
        if (j2.size() == 1 && f.a0(j2.iterator().next())) {
            return;
        }
        G1(sb);
        sb.append(": ");
        CollectionsKt___CollectionsKt.W2(j2, sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new DescriptorRendererImpl$renderSuperTypes$1(this));
    }

    private final void I1(v vVar, StringBuilder sb) {
        s1(sb, vVar.isSuspend(), "suspend");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void J1(s0 s0Var, StringBuilder sb) {
        Y0(this, sb, s0Var, null, 2, null);
        W1(s0Var.getVisibility(), sb);
        o1(s0Var, sb);
        sb.append(m1("typealias"));
        sb.append(ExpandableTextView.N);
        t1(s0Var, sb, true);
        Q1(s0Var.s(), sb, false);
        Z0(s0Var, sb);
        sb.append(" = ");
        sb.append(y(s0Var.r0()));
    }

    private final void M1(StringBuilder sb, h.p2.b0.g.t.n.z zVar, q0 q0Var) {
        h0 a2 = TypeParameterUtilsKt.a(zVar);
        if (a2 == null) {
            sb.append(L1(q0Var));
            sb.append(K1(zVar.H0()));
            return;
        }
        A1(sb, a2);
    }

    private final void N(StringBuilder sb, k kVar) {
        String name;
        if ((kVar instanceof b0) || (kVar instanceof h.p2.b0.g.t.c.f0)) {
            return;
        }
        if (kVar instanceof z) {
            sb.append(" is a module");
            return;
        }
        k b2 = kVar.b();
        if (b2 == null || (b2 instanceof z)) {
            return;
        }
        sb.append(ExpandableTextView.N);
        sb.append(p1("defined in"));
        sb.append(ExpandableTextView.N);
        h.p2.b0.g.t.g.d m2 = c.m(b2);
        sb.append(m2.e() ? "root package" : w(m2));
        if (J0() && (b2 instanceof b0) && (kVar instanceof n) && (name = ((n) kVar).getSource().b().getName()) != null) {
            sb.append(ExpandableTextView.N);
            sb.append(p1("in file"));
            sb.append(ExpandableTextView.N);
            sb.append(name);
        }
    }

    private final String N0() {
        return R(SimpleComparison.GREATER_THAN_OPERATION);
    }

    public static /* synthetic */ void N1(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, h.p2.b0.g.t.n.z zVar, q0 q0Var, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            q0Var = zVar.I0();
        }
        descriptorRendererImpl.M1(sb, zVar, q0Var);
    }

    private final void O(StringBuilder sb, List<? extends h.p2.b0.g.t.n.s0> list) {
        CollectionsKt___CollectionsKt.W2(list, sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : new DescriptorRendererImpl$appendTypeProjections$1(this));
    }

    private final boolean O0(h.p2.b0.g.t.n.z zVar) {
        return e.o(zVar) || !zVar.getAnnotations().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O1(t0 t0Var, StringBuilder sb, boolean z) {
        if (z) {
            sb.append(R0());
        }
        if (H0()) {
            sb.append(k.b.a.a.n.n.e.f16212d);
            sb.append(t0Var.f());
            sb.append("*/ ");
        }
        s1(sb, t0Var.l(), "reified");
        String label = t0Var.o().getLabel();
        boolean z2 = true;
        s1(sb, label.length() > 0, label);
        Y0(this, sb, t0Var, null, 2, null);
        t1(t0Var, sb, z);
        int size = t0Var.getUpperBounds().size();
        if ((size > 1 && !z) || size == 1) {
            h.p2.b0.g.t.n.z next = t0Var.getUpperBounds().iterator().next();
            if (!f.g0(next)) {
                sb.append(" : ");
                sb.append(y(next));
            }
        } else if (z) {
            for (h.p2.b0.g.t.n.z zVar : t0Var.getUpperBounds()) {
                if (!f.g0(zVar)) {
                    if (z2) {
                        sb.append(" : ");
                    } else {
                        sb.append(" & ");
                    }
                    sb.append(y(zVar));
                    z2 = false;
                }
            }
        }
        if (z) {
            sb.append(N0());
        }
    }

    private final String P() {
        int i2 = b.a[C0().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return "&rarr;";
            }
            throw new NoWhenBranchMatchedException();
        }
        return R("->");
    }

    private final Modality P0(h.p2.b0.g.t.c.w wVar) {
        if (wVar instanceof h.p2.b0.g.t.c.d) {
            return ((h.p2.b0.g.t.c.d) wVar).i() == ClassKind.INTERFACE ? Modality.ABSTRACT : Modality.FINAL;
        }
        k b2 = wVar.b();
        h.p2.b0.g.t.c.d dVar = b2 instanceof h.p2.b0.g.t.c.d ? (h.p2.b0.g.t.c.d) b2 : null;
        if (dVar != null && (wVar instanceof CallableMemberDescriptor)) {
            CallableMemberDescriptor callableMemberDescriptor = (CallableMemberDescriptor) wVar;
            if (!(!callableMemberDescriptor.d().isEmpty()) || dVar.t() == Modality.FINAL) {
                if (dVar.i() == ClassKind.INTERFACE && !f0.g(callableMemberDescriptor.getVisibility(), r.a)) {
                    Modality t = callableMemberDescriptor.t();
                    Modality modality = Modality.ABSTRACT;
                    return t == modality ? modality : Modality.OPEN;
                }
                return Modality.FINAL;
            }
            return Modality.OPEN;
        }
        return Modality.FINAL;
    }

    private final void P1(StringBuilder sb, List<? extends t0> list) {
        Iterator<? extends t0> it = list.iterator();
        while (it.hasNext()) {
            O1(it.next(), sb, false);
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
    }

    private final boolean Q(String str, String str2) {
        if (!f0.g(str, h.t2.u.k2(str2, "?", "", false, 4, null)) && (!h.t2.u.J1(str2, "?", false, 2, null) || !f0.g(f0.C(str, "?"), str2))) {
            if (!f0.g('(' + str + ")?", str2)) {
                return false;
            }
        }
        return true;
    }

    private final boolean Q0(h.p2.b0.g.t.c.b1.c cVar) {
        return f0.g(cVar.e(), g.a.D);
    }

    private final void Q1(List<? extends t0> list, StringBuilder sb, boolean z) {
        if (!M0() && (!list.isEmpty())) {
            sb.append(R0());
            P1(sb, list);
            sb.append(N0());
            if (z) {
                sb.append(ExpandableTextView.N);
            }
        }
    }

    private final String R(String str) {
        return C0().escape(str);
    }

    private final String R0() {
        return R(SimpleComparison.LESS_THAN_OPERATION);
    }

    private final void R1(x0 x0Var, StringBuilder sb, boolean z) {
        if (z || !(x0Var instanceof v0)) {
            sb.append(m1(x0Var.O() ? "var" : "val"));
            sb.append(ExpandableTextView.N);
        }
    }

    private final boolean S0(CallableMemberDescriptor callableMemberDescriptor) {
        return !callableMemberDescriptor.d().isEmpty();
    }

    public static /* synthetic */ void S1(DescriptorRendererImpl descriptorRendererImpl, x0 x0Var, StringBuilder sb, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        descriptorRendererImpl.R1(x0Var, sb, z);
    }

    private final void T0(StringBuilder sb, h.p2.b0.g.t.n.a aVar) {
        RenderingFormat C0 = C0();
        RenderingFormat renderingFormat = RenderingFormat.HTML;
        if (C0 == renderingFormat) {
            sb.append("<font color=\"808080\"><i>");
        }
        sb.append(" /* = ");
        v1(sb, aVar.H());
        sb.append(" */");
        if (C0() == renderingFormat) {
            sb.append("</i></font>");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0095, code lost:
        if ((j() ? r10.x0() : kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.a(r10)) != false) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void T1(h.p2.b0.g.t.c.v0 r10, boolean r11, java.lang.StringBuilder r12, boolean r13) {
        /*
            r9 = this;
            if (r13 == 0) goto L10
            java.lang.String r0 = "value-parameter"
            java.lang.String r0 = r9.m1(r0)
            r12.append(r0)
            java.lang.String r0 = " "
            r12.append(r0)
        L10:
            boolean r0 = r9.H0()
            if (r0 == 0) goto L27
            java.lang.String r0 = "/*"
            r12.append(r0)
            int r0 = r10.f()
            r12.append(r0)
        */
        //  java.lang.String r0 = "*/ "
        /*
            r12.append(r0)
        L27:
            r4 = 0
            r5 = 2
            r6 = 0
            r1 = r9
            r2 = r12
            r3 = r10
            Y0(r1, r2, r3, r4, r5, r6)
            boolean r0 = r10.p0()
            java.lang.String r1 = "crossinline"
            r9.s1(r12, r0, r1)
            boolean r0 = r10.n0()
            java.lang.String r1 = "noinline"
            r9.s1(r12, r0, r1)
            boolean r0 = r9.w0()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L6c
            h.p2.b0.g.t.c.a r0 = r10.b()
            boolean r3 = r0 instanceof h.p2.b0.g.t.c.c
            r4 = 0
            if (r3 == 0) goto L56
            h.p2.b0.g.t.c.c r0 = (h.p2.b0.g.t.c.c) r0
            goto L57
        L56:
            r0 = r4
        L57:
            if (r0 != 0) goto L5a
            goto L62
        L5a:
            boolean r0 = r0.b0()
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
        L62:
            java.lang.Boolean r0 = java.lang.Boolean.TRUE
            boolean r0 = h.k2.v.f0.g(r4, r0)
            if (r0 == 0) goto L6c
            r8 = 1
            goto L6d
        L6c:
            r8 = 0
        L6d:
            if (r8 == 0) goto L78
            boolean r0 = r9.S()
            java.lang.String r3 = "actual"
            r9.s1(r12, r0, r3)
        L78:
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r3.V1(r4, r5, r6, r7, r8)
            h.k2.u.l r11 = r9.Y()
            if (r11 == 0) goto L98
            boolean r11 = r9.j()
            if (r11 == 0) goto L91
            boolean r11 = r10.x0()
            goto L95
        L91:
            boolean r11 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt.a(r10)
        L95:
            if (r11 == 0) goto L98
            goto L99
        L98:
            r1 = 0
        L99:
            if (r1 == 0) goto Lac
            h.k2.u.l r11 = r9.Y()
            java.lang.Object r10 = r11.invoke(r10)
            java.lang.String r11 = " = "
            java.lang.String r10 = h.k2.v.f0.C(r11, r10)
            r12.append(r10)
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.T1(h.p2.b0.g.t.c.v0, boolean, java.lang.StringBuilder, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U0(i0 i0Var, StringBuilder sb) {
        o1(i0Var, sb);
    }

    private final void U1(Collection<? extends v0> collection, boolean z, StringBuilder sb) {
        boolean a2 = a2(z);
        int size = collection.size();
        G0().b(size, sb);
        int i2 = 0;
        for (v0 v0Var : collection) {
            G0().a(v0Var, i2, size, sb);
            T1(v0Var, a2, sb, false);
            G0().c(v0Var, i2, size, sb);
            i2++;
        }
        G0().d(size, sb);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void V0(h.p2.b0.g.t.c.v r6, java.lang.StringBuilder r7) {
        /*
            r5 = this;
            boolean r0 = r6.isOperator()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L35
            java.util.Collection r0 = r6.d()
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L14
        L12:
            r0 = 1
            goto L2b
        L14:
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L12
            java.lang.Object r3 = r0.next()
            h.p2.b0.g.t.c.v r3 = (h.p2.b0.g.t.c.v) r3
            boolean r3 = r3.isOperator()
            if (r3 == 0) goto L18
            r0 = 0
        L2b:
            if (r0 != 0) goto L33
            boolean r0 = r5.T()
            if (r0 == 0) goto L35
        L33:
            r0 = 1
            goto L36
        L35:
            r0 = 0
        L36:
            boolean r3 = r6.isInfix()
            if (r3 == 0) goto L68
            java.util.Collection r3 = r6.d()
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L48
        L46:
            r3 = 1
            goto L5f
        L48:
            java.util.Iterator r3 = r3.iterator()
        L4c:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L46
            java.lang.Object r4 = r3.next()
            h.p2.b0.g.t.c.v r4 = (h.p2.b0.g.t.c.v) r4
            boolean r4 = r4.isInfix()
            if (r4 == 0) goto L4c
            r3 = 0
        L5f:
            if (r3 != 0) goto L67
            boolean r3 = r5.T()
            if (r3 == 0) goto L68
        L67:
            r1 = 1
        L68:
            boolean r2 = r6.D()
            java.lang.String r3 = "tailrec"
            r5.s1(r7, r2, r3)
            r5.I1(r6, r7)
            boolean r6 = r6.isInline()
            java.lang.String r2 = "inline"
            r5.s1(r7, r6, r2)
            java.lang.String r6 = "infix"
            r5.s1(r7, r1, r6)
            java.lang.String r6 = "operator"
            r5.s1(r7, r0, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererImpl.V0(h.p2.b0.g.t.c.v, java.lang.StringBuilder):void");
    }

    private final void V1(x0 x0Var, boolean z, StringBuilder sb, boolean z2, boolean z3) {
        h.p2.b0.g.t.n.z type = x0Var.getType();
        v0 v0Var = x0Var instanceof v0 ? (v0) x0Var : null;
        h.p2.b0.g.t.n.z t0 = v0Var != null ? v0Var.t0() : null;
        h.p2.b0.g.t.n.z zVar = t0 == null ? type : t0;
        s1(sb, t0 != null, "vararg");
        if (z3 || (z2 && !B0())) {
            R1(x0Var, sb, z3);
        }
        if (z) {
            t1(x0Var, sb, z2);
            sb.append(": ");
        }
        sb.append(y(zVar));
        l1(x0Var, sb);
        if (!H0() || t0 == null) {
            return;
        }
        sb.append(" /*");
        sb.append(y(type));
        sb.append(k.b.a.a.n.n.e.f16211c);
    }

    private final List<String> W0(h.p2.b0.g.t.c.b1.c cVar) {
        h.p2.b0.g.t.c.c E;
        Map<h.p2.b0.g.t.g.f, h.p2.b0.g.t.k.n.g<?>> a2 = cVar.a();
        List list = null;
        h.p2.b0.g.t.c.d f2 = t0() ? DescriptorUtilsKt.f(cVar) : null;
        List<v0> h2 = (f2 == null || (E = f2.E()) == null) ? null : E.h();
        if (h2 != null) {
            ArrayList<v0> arrayList = new ArrayList();
            for (Object obj : h2) {
                if (((v0) obj).x0()) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList(h.a2.u.Y(arrayList, 10));
            for (v0 v0Var : arrayList) {
                arrayList2.add(v0Var.getName());
            }
            list = arrayList2;
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        ArrayList<h.p2.b0.g.t.g.f> arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (!a2.containsKey((h.p2.b0.g.t.g.f) obj2)) {
                arrayList3.add(obj2);
            }
        }
        ArrayList arrayList4 = new ArrayList(h.a2.u.Y(arrayList3, 10));
        for (h.p2.b0.g.t.g.f fVar : arrayList3) {
            arrayList4.add(f0.C(fVar.b(), " = ..."));
        }
        Set<Map.Entry<h.p2.b0.g.t.g.f, h.p2.b0.g.t.k.n.g<?>>> entrySet = a2.entrySet();
        ArrayList arrayList5 = new ArrayList(h.a2.u.Y(entrySet, 10));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            h.p2.b0.g.t.g.f fVar2 = (h.p2.b0.g.t.g.f) entry.getKey();
            h.p2.b0.g.t.k.n.g<?> gVar = (h.p2.b0.g.t.k.n.g) entry.getValue();
            StringBuilder sb = new StringBuilder();
            sb.append(fVar2.b());
            sb.append(" = ");
            sb.append(!list.contains(fVar2) ? e1(gVar) : "...");
            arrayList5.add(sb.toString());
        }
        return CollectionsKt___CollectionsKt.d5(CollectionsKt___CollectionsKt.q4(arrayList4, arrayList5));
    }

    private final boolean W1(h.p2.b0.g.t.c.s sVar, StringBuilder sb) {
        if (h0().contains(DescriptorRendererModifier.VISIBILITY)) {
            if (i0()) {
                sVar = sVar.f();
            }
            if (v0() || !f0.g(sVar, r.f15218l)) {
                sb.append(m1(sVar.c()));
                sb.append(ExpandableTextView.N);
                return true;
            }
            return false;
        }
        return false;
    }

    private final void X0(StringBuilder sb, h.p2.b0.g.t.c.b1.a aVar, AnnotationUseSiteTarget annotationUseSiteTarget) {
        if (h0().contains(DescriptorRendererModifier.ANNOTATIONS)) {
            Set<h.p2.b0.g.t.g.c> i2 = aVar instanceof h.p2.b0.g.t.n.z ? i() : a0();
            l<h.p2.b0.g.t.c.b1.c, Boolean> U = U();
            for (h.p2.b0.g.t.c.b1.c cVar : aVar.getAnnotations()) {
                if (!CollectionsKt___CollectionsKt.J1(i2, cVar.e()) && !Q0(cVar) && (U == null || U.invoke(cVar).booleanValue())) {
                    sb.append(t(cVar, annotationUseSiteTarget));
                    if (Z()) {
                        sb.append('\n');
                    } else {
                        sb.append(ExpandableTextView.N);
                    }
                }
            }
        }
    }

    private final void X1(List<? extends t0> list, StringBuilder sb) {
        if (M0()) {
            return;
        }
        ArrayList arrayList = new ArrayList(0);
        for (t0 t0Var : list) {
            Iterator it = CollectionsKt___CollectionsKt.P1(t0Var.getUpperBounds(), 1).iterator();
            while (it.hasNext()) {
                arrayList.add(x(t0Var.getName(), false) + " : " + y((h.p2.b0.g.t.n.z) it.next()));
            }
        }
        if (!arrayList.isEmpty()) {
            sb.append(ExpandableTextView.N);
            sb.append(m1("where"));
            sb.append(ExpandableTextView.N);
            CollectionsKt___CollectionsKt.W2(arrayList, sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        }
    }

    public static /* synthetic */ void Y0(DescriptorRendererImpl descriptorRendererImpl, StringBuilder sb, h.p2.b0.g.t.c.b1.a aVar, AnnotationUseSiteTarget annotationUseSiteTarget, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            annotationUseSiteTarget = null;
        }
        descriptorRendererImpl.X0(sb, aVar, annotationUseSiteTarget);
    }

    private final String Y1(String str, String str2, String str3, String str4, String str5) {
        if (h.t2.u.u2(str, str2, false, 2, null) && h.t2.u.u2(str3, str4, false, 2, null)) {
            int length = str2.length();
            Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
            String substring = str.substring(length);
            int length2 = str4.length();
            Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
            String substring2 = str3.substring(length2);
            String C = f0.C(str5, substring);
            if (f0.g(substring, substring2)) {
                return C;
            }
            if (Q(substring, substring2)) {
                return f0.C(C, "!");
            }
        }
        return null;
    }

    private final void Z0(h.p2.b0.g.t.c.g gVar, StringBuilder sb) {
        List<t0> s = gVar.s();
        List<t0> parameters = gVar.j().getParameters();
        if (H0() && gVar.n() && parameters.size() > s.size()) {
            sb.append(" /*captured type parameters: ");
            P1(sb, parameters.subList(s.size(), parameters.size()));
            sb.append(k.b.a.a.n.n.e.f16211c);
        }
    }

    private final boolean Z1(h.p2.b0.g.t.n.z zVar) {
        boolean z;
        if (e.m(zVar)) {
            List<h.p2.b0.g.t.n.s0> H0 = zVar.H0();
            if (!(H0 instanceof Collection) || !H0.isEmpty()) {
                for (h.p2.b0.g.t.n.s0 s0Var : H0) {
                    if (s0Var.b()) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            return z;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1(h.p2.b0.g.t.c.d dVar, StringBuilder sb) {
        h.p2.b0.g.t.c.c E;
        boolean z = dVar.i() == ClassKind.ENUM_ENTRY;
        if (!B0()) {
            Y0(this, sb, dVar, null, 2, null);
            if (!z) {
                W1(dVar.getVisibility(), sb);
            }
            if ((dVar.i() != ClassKind.INTERFACE || dVar.t() != Modality.ABSTRACT) && (!dVar.i().isSingleton() || dVar.t() != Modality.FINAL)) {
                q1(dVar.t(), sb, P0(dVar));
            }
            o1(dVar, sb);
            s1(sb, h0().contains(DescriptorRendererModifier.INNER) && dVar.n(), "inner");
            s1(sb, h0().contains(DescriptorRendererModifier.DATA) && dVar.y(), "data");
            s1(sb, h0().contains(DescriptorRendererModifier.INLINE) && dVar.isInline(), "inline");
            s1(sb, h0().contains(DescriptorRendererModifier.VALUE) && dVar.w(), "value");
            s1(sb, h0().contains(DescriptorRendererModifier.FUN) && dVar.v(), "fun");
            b1(dVar, sb);
        }
        if (!c.x(dVar)) {
            if (!B0()) {
                G1(sb);
            }
            t1(dVar, sb, true);
        } else {
            d1(dVar, sb);
        }
        if (z) {
            return;
        }
        List<t0> s = dVar.s();
        Q1(s, sb, false);
        Z0(dVar, sb);
        if (!dVar.i().isSingleton() && W() && (E = dVar.E()) != null) {
            sb.append(ExpandableTextView.N);
            Y0(this, sb, E, null, 2, null);
            W1(E.getVisibility(), sb);
            sb.append(m1("constructor"));
            U1(E.h(), E.e0(), sb);
        }
        H1(dVar, sb);
        X1(s, sb);
    }

    private final boolean a2(boolean z) {
        int i2 = b.b[l0().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    return false;
                }
                throw new NoWhenBranchMatchedException();
            } else if (z) {
                return false;
            }
        }
        return true;
    }

    private final DescriptorRendererImpl b0() {
        return (DescriptorRendererImpl) this.f16756m.getValue();
    }

    private final void b1(h.p2.b0.g.t.c.d dVar, StringBuilder sb) {
        sb.append(m1(DescriptorRenderer.a.a(dVar)));
    }

    private final void d1(k kVar, StringBuilder sb) {
        if (q0()) {
            if (B0()) {
                sb.append("companion object");
            }
            G1(sb);
            k b2 = kVar.b();
            if (b2 != null) {
                sb.append("of ");
                sb.append(x(b2.getName(), false));
            }
        }
        if (H0() || !f0.g(kVar.getName(), h.f15419c)) {
            if (!B0()) {
                G1(sb);
            }
            sb.append(x(kVar.getName(), true));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String e1(h.p2.b0.g.t.k.n.g<?> gVar) {
        if (gVar instanceof h.p2.b0.g.t.k.n.b) {
            return CollectionsKt___CollectionsKt.Z2(((h.p2.b0.g.t.k.n.b) gVar).a(), ", ", "{", "}", 0, null, new DescriptorRendererImpl$renderConstant$1(this), 24, null);
        }
        if (gVar instanceof h.p2.b0.g.t.k.n.a) {
            return StringsKt__StringsKt.c4(DescriptorRenderer.u(this, ((h.p2.b0.g.t.k.n.a) gVar).a(), null, 2, null), TIMMentionEditText.TIM_MENTION_TAG);
        }
        if (gVar instanceof o) {
            o.b a2 = ((o) gVar).a();
            if (a2 instanceof o.b.a) {
                return ((o.b.a) a2).getType() + "::class";
            } else if (a2 instanceof o.b.C0463b) {
                o.b.C0463b c0463b = (o.b.C0463b) a2;
                String b2 = c0463b.b().b().b();
                for (int i2 = 0; i2 < c0463b.a(); i2++) {
                    b2 = "kotlin.Array<" + b2 + y.f15692e;
                }
                return f0.C(b2, "::class");
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        return gVar.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f1(j jVar, StringBuilder sb) {
        h.p2.b0.g.t.c.c E;
        Y0(this, sb, jVar, null, 2, null);
        boolean z = (this.f16755l.U() || jVar.c0().t() != Modality.SEALED) && W1(jVar.getVisibility(), sb);
        n1(jVar, sb);
        boolean z2 = s0() || !jVar.b0() || z;
        if (z2) {
            sb.append(m1("constructor"));
        }
        h.p2.b0.g.t.c.g b2 = jVar.b();
        if (z0()) {
            if (z2) {
                sb.append(ExpandableTextView.N);
            }
            t1(b2, sb, true);
            Q1(jVar.getTypeParameters(), sb, false);
        }
        U1(jVar.h(), jVar.e0(), sb);
        if (r0() && !jVar.b0() && (b2 instanceof h.p2.b0.g.t.c.d) && (E = ((h.p2.b0.g.t.c.d) b2).E()) != null) {
            List<v0> h2 = E.h();
            ArrayList arrayList = new ArrayList();
            for (Object obj : h2) {
                v0 v0Var = (v0) obj;
                if (!v0Var.x0() && v0Var.t0() == null) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                sb.append(" : ");
                sb.append(m1("this"));
                sb.append(CollectionsKt___CollectionsKt.Z2(arrayList, ", ", "(", ")", 0, null, DescriptorRendererImpl$renderConstructor$1.INSTANCE, 24, null));
            }
        }
        if (z0()) {
            X1(jVar.getTypeParameters(), sb);
        }
    }

    private final void g1(StringBuilder sb, h.p2.b0.g.t.n.z zVar) {
        Y0(this, sb, zVar, null, 2, null);
        if (a0.a(zVar)) {
            if ((zVar instanceof b1) && n0()) {
                sb.append(((b1) zVar).R0());
            } else if ((zVar instanceof h.p2.b0.g.t.n.r) && !g0()) {
                sb.append(((h.p2.b0.g.t.n.r) zVar).R0());
            } else {
                sb.append(zVar.I0().toString());
            }
            sb.append(K1(zVar.H0()));
        } else {
            N1(this, sb, zVar, null, 2, null);
        }
        if (zVar.J0()) {
            sb.append("?");
        }
        if (h.p2.b0.g.t.n.i0.c(zVar)) {
            sb.append("!!");
        }
    }

    private final String h1(String str) {
        int i2 = b.a[C0().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return "<font color=red><b>" + str + "</b></font>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final String i1(List<h.p2.b0.g.t.g.f> list) {
        return R(h.p2.b0.g.t.j.e.c(list));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j1(v vVar, StringBuilder sb) {
        if (!B0()) {
            if (!A0()) {
                Y0(this, sb, vVar, null, 2, null);
                W1(vVar.getVisibility(), sb);
                r1(vVar, sb);
                if (c0()) {
                    o1(vVar, sb);
                }
                w1(vVar, sb);
                if (c0()) {
                    V0(vVar, sb);
                } else {
                    I1(vVar, sb);
                }
                n1(vVar, sb);
                if (H0()) {
                    if (vVar.z0()) {
                        sb.append("/*isHiddenToOvercomeSignatureClash*/ ");
                    }
                    if (vVar.B0()) {
                        sb.append("/*isHiddenForResolutionEverywhereBesideSupercalls*/ ");
                    }
                }
            }
            sb.append(m1("fun"));
            sb.append(ExpandableTextView.N);
            Q1(vVar.getTypeParameters(), sb, true);
            D1(vVar, sb);
        }
        t1(vVar, sb, true);
        U1(vVar.h(), vVar.e0(), sb);
        E1(vVar, sb);
        h.p2.b0.g.t.n.z returnType = vVar.getReturnType();
        if (!K0() && (F0() || returnType == null || !f.z0(returnType))) {
            sb.append(": ");
            sb.append(returnType == null ? "[NULL]" : y(returnType));
        }
        X1(vVar.getTypeParameters(), sb);
    }

    private final void k1(StringBuilder sb, h.p2.b0.g.t.n.z zVar) {
        int length = sb.length();
        Y0(b0(), sb, zVar, null, 2, null);
        boolean z = true;
        boolean z2 = sb.length() != length;
        boolean o = e.o(zVar);
        boolean J0 = zVar.J0();
        h.p2.b0.g.t.n.z h2 = e.h(zVar);
        boolean z3 = J0 || (z2 && h2 != null);
        if (z3) {
            if (o) {
                sb.insert(length, '(');
            } else {
                if (z2) {
                    h.t2.b.r(StringsKt___StringsKt.k7(sb));
                    if (sb.charAt(StringsKt__StringsKt.i3(sb) - 1) != ')') {
                        sb.insert(StringsKt__StringsKt.i3(sb), "()");
                    }
                }
                sb.append("(");
            }
        }
        s1(sb, o, "suspend");
        if (h2 != null) {
            if ((!Z1(h2) || h2.J0()) && !O0(h2)) {
                z = false;
            }
            if (z) {
                sb.append("(");
            }
            u1(sb, h2);
            if (z) {
                sb.append(")");
            }
            sb.append(".");
        }
        sb.append("(");
        int i2 = 0;
        for (h.p2.b0.g.t.n.s0 s0Var : e.j(zVar)) {
            int i3 = i2 + 1;
            if (i2 > 0) {
                sb.append(", ");
            }
            h.p2.b0.g.t.g.f c2 = m0() ? e.c(s0Var.getType()) : null;
            if (c2 != null) {
                sb.append(x(c2, false));
                sb.append(": ");
            }
            sb.append(z(s0Var));
            i2 = i3;
        }
        sb.append(") ");
        sb.append(P());
        sb.append(ExpandableTextView.N);
        u1(sb, e.i(zVar));
        if (z3) {
            sb.append(")");
        }
        if (J0) {
            sb.append("?");
        }
    }

    private final void l1(x0 x0Var, StringBuilder sb) {
        h.p2.b0.g.t.k.n.g<?> m0;
        if (!f0() || (m0 = x0Var.m0()) == null) {
            return;
        }
        sb.append(" = ");
        sb.append(R(e1(m0)));
    }

    private final String m1(String str) {
        int i2 = b.a[C0().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                if (V()) {
                    return str;
                }
                return "<b>" + str + "</b>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    private final void n1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (h0().contains(DescriptorRendererModifier.MEMBER_KIND) && H0() && callableMemberDescriptor.i() != CallableMemberDescriptor.Kind.DECLARATION) {
            sb.append(k.b.a.a.n.n.e.f16212d);
            sb.append(h.p2.b0.g.t.o.j.a.f(callableMemberDescriptor.i().name()));
            sb.append("*/ ");
        }
    }

    private final void o1(h.p2.b0.g.t.c.w wVar, StringBuilder sb) {
        s1(sb, wVar.isExternal(), "external");
        boolean z = true;
        s1(sb, h0().contains(DescriptorRendererModifier.EXPECT) && wVar.i0(), "expect");
        s1(sb, (h0().contains(DescriptorRendererModifier.ACTUAL) && wVar.X()) ? false : false, "actual");
    }

    private final void q1(Modality modality, StringBuilder sb, Modality modality2) {
        if (u0() || modality != modality2) {
            s1(sb, h0().contains(DescriptorRendererModifier.MODALITY), h.p2.b0.g.t.o.j.a.f(modality.name()));
        }
    }

    private final void r1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (c.J(callableMemberDescriptor) && callableMemberDescriptor.t() == Modality.FINAL) {
            return;
        }
        if (k0() == OverrideRenderingPolicy.RENDER_OVERRIDE && callableMemberDescriptor.t() == Modality.OPEN && S0(callableMemberDescriptor)) {
            return;
        }
        q1(callableMemberDescriptor.t(), sb, P0(callableMemberDescriptor));
    }

    private final void s1(StringBuilder sb, boolean z, String str) {
        if (z) {
            sb.append(m1(str));
            sb.append(ExpandableTextView.N);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t1(k kVar, StringBuilder sb, boolean z) {
        sb.append(x(kVar.getName(), z));
    }

    private final void u1(StringBuilder sb, h.p2.b0.g.t.n.z zVar) {
        c1 L0 = zVar.L0();
        h.p2.b0.g.t.n.a aVar = L0 instanceof h.p2.b0.g.t.n.a ? (h.p2.b0.g.t.n.a) L0 : null;
        if (aVar != null) {
            if (x0()) {
                v1(sb, aVar.H());
                return;
            }
            v1(sb, aVar.U0());
            if (y0()) {
                T0(sb, aVar);
                return;
            }
            return;
        }
        v1(sb, zVar);
    }

    private final void v1(StringBuilder sb, h.p2.b0.g.t.n.z zVar) {
        if ((zVar instanceof d1) && j() && !((d1) zVar).N0()) {
            sb.append("<Not computed yet>");
            return;
        }
        c1 L0 = zVar.L0();
        if (L0 instanceof h.p2.b0.g.t.n.u) {
            sb.append(((h.p2.b0.g.t.n.u) L0).S0(this, this));
        } else if (L0 instanceof h.p2.b0.g.t.n.f0) {
            F1(sb, (h.p2.b0.g.t.n.f0) L0);
        }
    }

    private final void w1(CallableMemberDescriptor callableMemberDescriptor, StringBuilder sb) {
        if (h0().contains(DescriptorRendererModifier.OVERRIDE) && S0(callableMemberDescriptor) && k0() != OverrideRenderingPolicy.RENDER_OPEN) {
            s1(sb, true, "override");
            if (H0()) {
                sb.append(k.b.a.a.n.n.e.f16212d);
                sb.append(callableMemberDescriptor.d().size());
                sb.append("*/ ");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x1(b0 b0Var, StringBuilder sb) {
        y1(b0Var.e(), "package-fragment", sb);
        if (j()) {
            sb.append(" in ");
            t1(b0Var.b(), sb, false);
        }
    }

    private final void y1(h.p2.b0.g.t.g.c cVar, String str, StringBuilder sb) {
        sb.append(m1(str));
        String w = w(cVar.j());
        if (w.length() > 0) {
            sb.append(ExpandableTextView.N);
            sb.append(w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z1(h.p2.b0.g.t.c.f0 f0Var, StringBuilder sb) {
        y1(f0Var.e(), "package", sb);
        if (j()) {
            sb.append(" in context of ");
            t1(f0Var.y0(), sb, false);
        }
    }

    public boolean A0() {
        return this.f16755l.Z();
    }

    public boolean B0() {
        return this.f16755l.a0();
    }

    @d
    public RenderingFormat C0() {
        return this.f16755l.b0();
    }

    @d
    public l<h.p2.b0.g.t.n.z, h.p2.b0.g.t.n.z> D0() {
        return this.f16755l.c0();
    }

    public boolean E0() {
        return this.f16755l.d0();
    }

    public boolean F0() {
        return this.f16755l.e0();
    }

    @d
    public DescriptorRenderer.b G0() {
        return this.f16755l.f0();
    }

    public boolean H0() {
        return this.f16755l.g0();
    }

    public boolean I0() {
        return this.f16755l.h0();
    }

    public boolean J0() {
        return this.f16755l.i0();
    }

    public boolean K0() {
        return this.f16755l.j0();
    }

    @d
    public String K1(@d List<? extends h.p2.b0.g.t.n.s0> list) {
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(R0());
        O(sb, list);
        sb.append(N0());
        return sb.toString();
    }

    public boolean L0() {
        return this.f16755l.k0();
    }

    @d
    public String L1(@d q0 q0Var) {
        h.p2.b0.g.t.c.f c2 = q0Var.c();
        if (c2 instanceof t0 ? true : c2 instanceof h.p2.b0.g.t.c.d ? true : c2 instanceof s0) {
            return c1(c2);
        }
        if (c2 == null) {
            return q0Var.toString();
        }
        throw new IllegalStateException(f0.C("Unexpected classifier: ", c2.getClass()).toString());
    }

    public boolean M0() {
        return this.f16755l.l0();
    }

    public boolean S() {
        return this.f16755l.t();
    }

    public boolean T() {
        return this.f16755l.u();
    }

    @k.e.a.e
    public l<h.p2.b0.g.t.c.b1.c, Boolean> U() {
        return this.f16755l.v();
    }

    public boolean V() {
        return this.f16755l.w();
    }

    public boolean W() {
        return this.f16755l.x();
    }

    @d
    public h.p2.b0.g.t.j.a X() {
        return this.f16755l.y();
    }

    @k.e.a.e
    public l<v0, String> Y() {
        return this.f16755l.z();
    }

    public boolean Z() {
        return this.f16755l.A();
    }

    @Override // h.p2.b0.g.t.j.b
    public void a(boolean z) {
        this.f16755l.a(z);
    }

    @d
    public Set<h.p2.b0.g.t.g.c> a0() {
        return this.f16755l.B();
    }

    @Override // h.p2.b0.g.t.j.b
    public void b(@d ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        this.f16755l.b(parameterNameRenderingPolicy);
    }

    @Override // h.p2.b0.g.t.j.b
    public void c(boolean z) {
        this.f16755l.c(z);
    }

    public boolean c0() {
        return this.f16755l.C();
    }

    @d
    public String c1(@d h.p2.b0.g.t.c.f fVar) {
        if (s.r(fVar)) {
            return fVar.j().toString();
        }
        return X().a(fVar, this);
    }

    @Override // h.p2.b0.g.t.j.b
    public boolean d() {
        return this.f16755l.d();
    }

    public boolean d0() {
        return this.f16755l.D();
    }

    @Override // h.p2.b0.g.t.j.b
    public void e(boolean z) {
        this.f16755l.e(z);
    }

    public boolean e0() {
        return this.f16755l.E();
    }

    @Override // h.p2.b0.g.t.j.b
    public void f(boolean z) {
        this.f16755l.f(z);
    }

    public boolean f0() {
        return this.f16755l.F();
    }

    @Override // h.p2.b0.g.t.j.b
    public void g(@d RenderingFormat renderingFormat) {
        this.f16755l.g(renderingFormat);
    }

    public boolean g0() {
        return this.f16755l.G();
    }

    @Override // h.p2.b0.g.t.j.b
    public void h(@d AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        this.f16755l.h(annotationArgumentsRenderingPolicy);
    }

    @d
    public Set<DescriptorRendererModifier> h0() {
        return this.f16755l.H();
    }

    @Override // h.p2.b0.g.t.j.b
    @d
    public Set<h.p2.b0.g.t.g.c> i() {
        return this.f16755l.i();
    }

    public boolean i0() {
        return this.f16755l.I();
    }

    @Override // h.p2.b0.g.t.j.b
    public boolean j() {
        return this.f16755l.j();
    }

    @d
    public final DescriptorRendererOptionsImpl j0() {
        return this.f16755l;
    }

    @Override // h.p2.b0.g.t.j.b
    @d
    public AnnotationArgumentsRenderingPolicy k() {
        return this.f16755l.k();
    }

    @d
    public OverrideRenderingPolicy k0() {
        return this.f16755l.J();
    }

    @Override // h.p2.b0.g.t.j.b
    public void l(@d Set<h.p2.b0.g.t.g.c> set) {
        this.f16755l.l(set);
    }

    @d
    public ParameterNameRenderingPolicy l0() {
        return this.f16755l.K();
    }

    @Override // h.p2.b0.g.t.j.b
    public void m(@d Set<? extends DescriptorRendererModifier> set) {
        this.f16755l.m(set);
    }

    public boolean m0() {
        return this.f16755l.L();
    }

    @Override // h.p2.b0.g.t.j.b
    public void n(boolean z) {
        this.f16755l.n(z);
    }

    public boolean n0() {
        return this.f16755l.M();
    }

    @Override // h.p2.b0.g.t.j.b
    public void o(@d h.p2.b0.g.t.j.a aVar) {
        this.f16755l.o(aVar);
    }

    @d
    public PropertyAccessorRenderingPolicy o0() {
        return this.f16755l.N();
    }

    @Override // h.p2.b0.g.t.j.b
    public void p(boolean z) {
        this.f16755l.p(z);
    }

    public boolean p0() {
        return this.f16755l.O();
    }

    @d
    public String p1(@d String str) {
        int i2 = b.a[C0().ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                return "<i>" + str + "</i>";
            }
            throw new NoWhenBranchMatchedException();
        }
        return str;
    }

    @Override // h.p2.b0.g.t.j.b
    public void q(boolean z) {
        this.f16755l.q(z);
    }

    public boolean q0() {
        return this.f16755l.P();
    }

    @Override // h.p2.b0.g.t.j.b
    public void r(boolean z) {
        this.f16755l.r(z);
    }

    public boolean r0() {
        return this.f16755l.Q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @d
    public String s(@d k kVar) {
        StringBuilder sb = new StringBuilder();
        kVar.B(new a(), sb);
        if (I0()) {
            N(sb, kVar);
        }
        return sb.toString();
    }

    public boolean s0() {
        return this.f16755l.R();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @d
    public String t(@d h.p2.b0.g.t.c.b1.c cVar, @k.e.a.e AnnotationUseSiteTarget annotationUseSiteTarget) {
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        if (annotationUseSiteTarget != null) {
            sb.append(f0.C(annotationUseSiteTarget.getRenderName(), Constants.COLON_SEPARATOR));
        }
        h.p2.b0.g.t.n.z type = cVar.getType();
        sb.append(y(type));
        if (d0()) {
            List<String> W0 = W0(cVar);
            if (e0() || (!W0.isEmpty())) {
                CollectionsKt___CollectionsKt.W2(W0, sb, (r14 & 2) != 0 ? ", " : ", ", (r14 & 4) != 0 ? "" : "(", (r14 & 8) == 0 ? ")" : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
            }
        }
        if (H0() && (a0.a(type) || (type.I0().c() instanceof NotFoundClasses.b))) {
            sb.append(" /* annotation class not found */");
        }
        return sb.toString();
    }

    public boolean t0() {
        return this.f16755l.S();
    }

    public boolean u0() {
        return this.f16755l.T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @d
    public String v(@d String str, @d String str2, @d f fVar) {
        if (Q(str, str2)) {
            if (h.t2.u.u2(str2, "(", false, 2, null)) {
                return '(' + str + ")!";
            }
            return f0.C(str, "!");
        }
        String u5 = StringsKt__StringsKt.u5(X().a(fVar.w(), this), "Collection", null, 2, null);
        String C = f0.C(u5, "Mutable");
        String Y1 = Y1(str, C, str2, u5, u5 + "(Mutable)");
        if (Y1 != null) {
            return Y1;
        }
        String Y12 = Y1(str, f0.C(u5, "MutableMap.MutableEntry"), str2, f0.C(u5, "Map.Entry"), f0.C(u5, "(Mutable)Map.(Mutable)Entry"));
        if (Y12 != null) {
            return Y12;
        }
        String u52 = StringsKt__StringsKt.u5(X().a(fVar.j(), this), "Array", null, 2, null);
        String Y13 = Y1(str, f0.C(u52, R("Array<")), str2, f0.C(u52, R("Array<out ")), f0.C(u52, R("Array<(out) ")));
        if (Y13 != null) {
            return Y13;
        }
        return '(' + str + ".." + str2 + ')';
    }

    public boolean v0() {
        return this.f16755l.U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @d
    public String w(@d h.p2.b0.g.t.g.d dVar) {
        return i1(dVar.h());
    }

    public boolean w0() {
        return this.f16755l.V();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @d
    public String x(@d h.p2.b0.g.t.g.f fVar, boolean z) {
        String R = R(h.p2.b0.g.t.j.e.b(fVar));
        if (V() && C0() == RenderingFormat.HTML && z) {
            return "<b>" + R + "</b>";
        }
        return R;
    }

    public boolean x0() {
        return this.f16755l.W();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @d
    public String y(@d h.p2.b0.g.t.n.z zVar) {
        StringBuilder sb = new StringBuilder();
        u1(sb, D0().invoke(zVar));
        return sb.toString();
    }

    public boolean y0() {
        return this.f16755l.X();
    }

    @Override // kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer
    @d
    public String z(@d h.p2.b0.g.t.n.s0 s0Var) {
        StringBuilder sb = new StringBuilder();
        O(sb, t.k(s0Var));
        return sb.toString();
    }

    public boolean z0() {
        return this.f16755l.Y();
    }
}
