package kotlin.reflect.jvm.internal.impl.renderer;

import h.a2.d1;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.n0;
import h.m2.c;
import h.m2.f;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.j.a;
import h.p2.b0.g.t.j.b;
import h.p2.b0.g.t.n.z;
import h.p2.n;
import h.t2.u;
import java.lang.reflect.Field;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;

/* loaded from: classes3.dex */
public final class DescriptorRendererOptionsImpl implements b {
    public static final /* synthetic */ n<Object>[] X = {n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "classifierNamePolicy", "getClassifierNamePolicy()Lorg/jetbrains/kotlin/renderer/ClassifierNamePolicy;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "withDefinedIn", "getWithDefinedIn()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "withSourceFileForTopLevel", "getWithSourceFileForTopLevel()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "modifiers", "getModifiers()Ljava/util/Set;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "startFromName", "getStartFromName()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "startFromDeclarationKeyword", "getStartFromDeclarationKeyword()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "debugMode", "getDebugMode()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "classWithPrimaryConstructor", "getClassWithPrimaryConstructor()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "verbose", "getVerbose()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "unitReturnType", "getUnitReturnType()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "withoutReturnType", "getWithoutReturnType()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "enhancedTypes", "getEnhancedTypes()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "normalizedVisibilities", "getNormalizedVisibilities()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "renderDefaultVisibility", "getRenderDefaultVisibility()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "renderDefaultModality", "getRenderDefaultModality()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "renderConstructorDelegation", "getRenderConstructorDelegation()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "renderPrimaryConstructorParametersAsProperties", "getRenderPrimaryConstructorParametersAsProperties()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "actualPropertiesInPrimaryConstructor", "getActualPropertiesInPrimaryConstructor()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "uninferredTypeParameterAsName", "getUninferredTypeParameterAsName()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "includePropertyConstant", "getIncludePropertyConstant()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "withoutTypeParameters", "getWithoutTypeParameters()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "withoutSuperTypes", "getWithoutSuperTypes()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "typeNormalizer", "getTypeNormalizer()Lkotlin/jvm/functions/Function1;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "defaultParameterValueRenderer", "getDefaultParameterValueRenderer()Lkotlin/jvm/functions/Function1;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "secondaryConstructorsAsPrimary", "getSecondaryConstructorsAsPrimary()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "overrideRenderingPolicy", "getOverrideRenderingPolicy()Lorg/jetbrains/kotlin/renderer/OverrideRenderingPolicy;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "valueParametersHandler", "getValueParametersHandler()Lorg/jetbrains/kotlin/renderer/DescriptorRenderer$ValueParametersHandler;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "textFormat", "getTextFormat()Lorg/jetbrains/kotlin/renderer/RenderingFormat;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "parameterNameRenderingPolicy", "getParameterNameRenderingPolicy()Lorg/jetbrains/kotlin/renderer/ParameterNameRenderingPolicy;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "receiverAfterName", "getReceiverAfterName()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "renderCompanionObjectName", "getRenderCompanionObjectName()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "propertyAccessorRenderingPolicy", "getPropertyAccessorRenderingPolicy()Lorg/jetbrains/kotlin/renderer/PropertyAccessorRenderingPolicy;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "renderDefaultAnnotationArguments", "getRenderDefaultAnnotationArguments()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "eachAnnotationOnNewLine", "getEachAnnotationOnNewLine()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "excludedAnnotationClasses", "getExcludedAnnotationClasses()Ljava/util/Set;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "excludedTypeAnnotationClasses", "getExcludedTypeAnnotationClasses()Ljava/util/Set;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "annotationFilter", "getAnnotationFilter()Lkotlin/jvm/functions/Function1;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "annotationArgumentsRenderingPolicy", "getAnnotationArgumentsRenderingPolicy()Lorg/jetbrains/kotlin/renderer/AnnotationArgumentsRenderingPolicy;")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "alwaysRenderModifiers", "getAlwaysRenderModifiers()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "renderConstructorKeyword", "getRenderConstructorKeyword()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "renderUnabbreviatedType", "getRenderUnabbreviatedType()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "renderTypeExpansions", "getRenderTypeExpansions()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "includeAdditionalModifiers", "getIncludeAdditionalModifiers()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "parameterNamesInFunctionalTypes", "getParameterNamesInFunctionalTypes()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "renderFunctionContracts", "getRenderFunctionContracts()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "presentableUnresolvedTypes", "getPresentableUnresolvedTypes()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "boldOnlyForNamesInHtml", "getBoldOnlyForNamesInHtml()Z")), n0.j(new MutablePropertyReference1Impl(n0.d(DescriptorRendererOptionsImpl.class), "informativeErrorType", "getInformativeErrorType()Z"))};
    @d
    private final f A;
    @d
    private final f B;
    @d
    private final f C;
    @d
    private final f D;
    @d
    private final f E;
    @d
    private final f F;
    @d
    private final f G;
    @d
    private final f H;
    @d
    private final f I;
    @d
    private final f J;
    @d
    private final f K;
    @d
    private final f L;
    @d
    private final f M;
    @d
    private final f N;
    @d
    private final f O;
    @d
    private final f P;
    @d
    private final f Q;
    @d
    private final f R;
    @d
    private final f S;
    @d
    private final f T;
    @d
    private final f U;
    @d
    private final f V;
    @d
    private final f W;
    private boolean a;
    @d
    private final f b = o0(a.c.a);
    @d

    /* renamed from: c  reason: collision with root package name */
    private final f f16757c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f f16758d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final f f16759e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final f f16760f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final f f16761g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final f f16762h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final f f16763i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final f f16764j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final f f16765k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final f f16766l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final f f16767m;
    @d
    private final f n;
    @d
    private final f o;
    @d
    private final f p;
    @d
    private final f q;
    @d
    private final f r;
    @d
    private final f s;
    @d
    private final f t;
    @d
    private final f u;
    @d
    private final f v;
    @d
    private final f w;
    @d
    private final f x;
    @d
    private final f y;
    @d
    private final f z;

    /* loaded from: classes3.dex */
    public static final class a extends c<T> {
        public final /* synthetic */ Object b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ DescriptorRendererOptionsImpl f16768c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, Object obj2, DescriptorRendererOptionsImpl descriptorRendererOptionsImpl) {
            super(obj2);
            this.b = obj;
            this.f16768c = descriptorRendererOptionsImpl;
        }

        @Override // h.m2.c
        public boolean d(@d n<?> nVar, T t, T t2) {
            if (this.f16768c.m0()) {
                throw new IllegalStateException("Cannot modify readonly DescriptorRendererOptions");
            }
            return true;
        }
    }

    public DescriptorRendererOptionsImpl() {
        Boolean bool = Boolean.TRUE;
        this.f16757c = o0(bool);
        this.f16758d = o0(bool);
        this.f16759e = o0(DescriptorRendererModifier.ALL_EXCEPT_ANNOTATIONS);
        Boolean bool2 = Boolean.FALSE;
        this.f16760f = o0(bool2);
        this.f16761g = o0(bool2);
        this.f16762h = o0(bool2);
        this.f16763i = o0(bool2);
        this.f16764j = o0(bool2);
        this.f16765k = o0(bool);
        this.f16766l = o0(bool2);
        this.f16767m = o0(bool2);
        this.n = o0(bool2);
        this.o = o0(bool);
        this.p = o0(bool);
        this.q = o0(bool2);
        this.r = o0(bool2);
        this.s = o0(bool2);
        this.t = o0(bool2);
        this.u = o0(bool2);
        this.v = o0(bool2);
        this.w = o0(bool2);
        this.x = o0(DescriptorRendererOptionsImpl$typeNormalizer$2.INSTANCE);
        this.y = o0(DescriptorRendererOptionsImpl$defaultParameterValueRenderer$2.INSTANCE);
        this.z = o0(bool);
        this.A = o0(OverrideRenderingPolicy.RENDER_OPEN);
        this.B = o0(DescriptorRenderer.b.a.a);
        this.C = o0(RenderingFormat.PLAIN);
        this.D = o0(ParameterNameRenderingPolicy.ALL);
        this.E = o0(bool2);
        this.F = o0(bool2);
        this.G = o0(PropertyAccessorRenderingPolicy.DEBUG);
        this.H = o0(bool2);
        this.I = o0(bool2);
        this.J = o0(d1.k());
        this.K = o0(h.p2.b0.g.t.j.c.a.a());
        this.L = o0(null);
        this.M = o0(AnnotationArgumentsRenderingPolicy.NO_ARGUMENTS);
        this.N = o0(bool2);
        this.O = o0(bool);
        this.P = o0(bool);
        this.Q = o0(bool2);
        this.R = o0(bool);
        this.S = o0(bool);
        this.T = o0(bool2);
        this.U = o0(bool2);
        this.V = o0(bool2);
        this.W = o0(bool);
    }

    private final <T> f<DescriptorRendererOptionsImpl, T> o0(T t) {
        h.m2.a aVar = h.m2.a.a;
        return new a(t, t, this);
    }

    public boolean A() {
        return ((Boolean) this.I.a(this, X[33])).booleanValue();
    }

    @d
    public Set<h.p2.b0.g.t.g.c> B() {
        return (Set) this.J.a(this, X[34]);
    }

    public boolean C() {
        return ((Boolean) this.R.a(this, X[42])).booleanValue();
    }

    public boolean D() {
        return b.a.a(this);
    }

    public boolean E() {
        return b.a.b(this);
    }

    public boolean F() {
        return ((Boolean) this.u.a(this, X[19])).booleanValue();
    }

    public boolean G() {
        return ((Boolean) this.W.a(this, X[47])).booleanValue();
    }

    @d
    public Set<DescriptorRendererModifier> H() {
        return (Set) this.f16759e.a(this, X[3]);
    }

    public boolean I() {
        return ((Boolean) this.n.a(this, X[12])).booleanValue();
    }

    @d
    public OverrideRenderingPolicy J() {
        return (OverrideRenderingPolicy) this.A.a(this, X[25]);
    }

    @d
    public ParameterNameRenderingPolicy K() {
        return (ParameterNameRenderingPolicy) this.D.a(this, X[28]);
    }

    public boolean L() {
        return ((Boolean) this.S.a(this, X[43])).booleanValue();
    }

    public boolean M() {
        return ((Boolean) this.U.a(this, X[45])).booleanValue();
    }

    @d
    public PropertyAccessorRenderingPolicy N() {
        return (PropertyAccessorRenderingPolicy) this.G.a(this, X[31]);
    }

    public boolean O() {
        return ((Boolean) this.E.a(this, X[29])).booleanValue();
    }

    public boolean P() {
        return ((Boolean) this.F.a(this, X[30])).booleanValue();
    }

    public boolean Q() {
        return ((Boolean) this.q.a(this, X[15])).booleanValue();
    }

    public boolean R() {
        return ((Boolean) this.O.a(this, X[39])).booleanValue();
    }

    public boolean S() {
        return ((Boolean) this.H.a(this, X[32])).booleanValue();
    }

    public boolean T() {
        return ((Boolean) this.p.a(this, X[14])).booleanValue();
    }

    public boolean U() {
        return ((Boolean) this.o.a(this, X[13])).booleanValue();
    }

    public boolean V() {
        return ((Boolean) this.r.a(this, X[16])).booleanValue();
    }

    public boolean W() {
        return ((Boolean) this.Q.a(this, X[41])).booleanValue();
    }

    public boolean X() {
        return ((Boolean) this.P.a(this, X[40])).booleanValue();
    }

    public boolean Y() {
        return ((Boolean) this.z.a(this, X[24])).booleanValue();
    }

    public boolean Z() {
        return ((Boolean) this.f16761g.a(this, X[5])).booleanValue();
    }

    @Override // h.p2.b0.g.t.j.b
    public void a(boolean z) {
        this.f16760f.b(this, X[4], Boolean.valueOf(z));
    }

    public boolean a0() {
        return ((Boolean) this.f16760f.a(this, X[4])).booleanValue();
    }

    @Override // h.p2.b0.g.t.j.b
    public void b(@d ParameterNameRenderingPolicy parameterNameRenderingPolicy) {
        this.D.b(this, X[28], parameterNameRenderingPolicy);
    }

    @d
    public RenderingFormat b0() {
        return (RenderingFormat) this.C.a(this, X[27]);
    }

    @Override // h.p2.b0.g.t.j.b
    public void c(boolean z) {
        this.f16757c.b(this, X[1], Boolean.valueOf(z));
    }

    @d
    public l<z, z> c0() {
        return (l) this.x.a(this, X[22]);
    }

    @Override // h.p2.b0.g.t.j.b
    public boolean d() {
        return ((Boolean) this.f16767m.a(this, X[11])).booleanValue();
    }

    public boolean d0() {
        return ((Boolean) this.t.a(this, X[18])).booleanValue();
    }

    @Override // h.p2.b0.g.t.j.b
    public void e(boolean z) {
        this.w.b(this, X[21], Boolean.valueOf(z));
    }

    public boolean e0() {
        return ((Boolean) this.f16765k.a(this, X[9])).booleanValue();
    }

    @Override // h.p2.b0.g.t.j.b
    public void f(boolean z) {
        this.E.b(this, X[29], Boolean.valueOf(z));
    }

    @d
    public DescriptorRenderer.b f0() {
        return (DescriptorRenderer.b) this.B.a(this, X[26]);
    }

    @Override // h.p2.b0.g.t.j.b
    public void g(@d RenderingFormat renderingFormat) {
        this.C.b(this, X[27], renderingFormat);
    }

    public boolean g0() {
        return ((Boolean) this.f16764j.a(this, X[8])).booleanValue();
    }

    @Override // h.p2.b0.g.t.j.b
    public void h(@d AnnotationArgumentsRenderingPolicy annotationArgumentsRenderingPolicy) {
        this.M.b(this, X[37], annotationArgumentsRenderingPolicy);
    }

    public boolean h0() {
        return ((Boolean) this.f16757c.a(this, X[1])).booleanValue();
    }

    @Override // h.p2.b0.g.t.j.b
    @d
    public Set<h.p2.b0.g.t.g.c> i() {
        return (Set) this.K.a(this, X[35]);
    }

    public boolean i0() {
        return ((Boolean) this.f16758d.a(this, X[2])).booleanValue();
    }

    @Override // h.p2.b0.g.t.j.b
    public boolean j() {
        return ((Boolean) this.f16762h.a(this, X[6])).booleanValue();
    }

    public boolean j0() {
        return ((Boolean) this.f16766l.a(this, X[10])).booleanValue();
    }

    @Override // h.p2.b0.g.t.j.b
    @d
    public AnnotationArgumentsRenderingPolicy k() {
        return (AnnotationArgumentsRenderingPolicy) this.M.a(this, X[37]);
    }

    public boolean k0() {
        return ((Boolean) this.w.a(this, X[21])).booleanValue();
    }

    @Override // h.p2.b0.g.t.j.b
    public void l(@d Set<h.p2.b0.g.t.g.c> set) {
        this.K.b(this, X[35], set);
    }

    public boolean l0() {
        return ((Boolean) this.v.a(this, X[20])).booleanValue();
    }

    @Override // h.p2.b0.g.t.j.b
    public void m(@d Set<? extends DescriptorRendererModifier> set) {
        this.f16759e.b(this, X[3], set);
    }

    public final boolean m0() {
        return this.a;
    }

    @Override // h.p2.b0.g.t.j.b
    public void n(boolean z) {
        this.f16764j.b(this, X[8], Boolean.valueOf(z));
    }

    public final void n0() {
        this.a = true;
    }

    @Override // h.p2.b0.g.t.j.b
    public void o(@d h.p2.b0.g.t.j.a aVar) {
        this.b.b(this, X[0], aVar);
    }

    @Override // h.p2.b0.g.t.j.b
    public void p(boolean z) {
        this.f16762h.b(this, X[6], Boolean.valueOf(z));
    }

    @Override // h.p2.b0.g.t.j.b
    public void q(boolean z) {
        this.F.b(this, X[30], Boolean.valueOf(z));
    }

    @Override // h.p2.b0.g.t.j.b
    public void r(boolean z) {
        this.v.b(this, X[20], Boolean.valueOf(z));
    }

    @d
    public final DescriptorRendererOptionsImpl s() {
        DescriptorRendererOptionsImpl descriptorRendererOptionsImpl = new DescriptorRendererOptionsImpl();
        Field[] declaredFields = DescriptorRendererOptionsImpl.class.getDeclaredFields();
        int length = declaredFields.length;
        int i2 = 0;
        while (i2 < length) {
            Field field = declaredFields[i2];
            i2++;
            if ((field.getModifiers() & 8) == 0) {
                field.setAccessible(true);
                Object obj = field.get(this);
                c cVar = obj instanceof c ? (c) obj : null;
                if (cVar != null) {
                    u.u2(field.getName(), "is", false, 2, null);
                    h.p2.d d2 = n0.d(DescriptorRendererOptionsImpl.class);
                    String name = field.getName();
                    String name2 = field.getName();
                    if (name2.length() > 0) {
                        char upperCase = Character.toUpperCase(name2.charAt(0));
                        name2 = String.valueOf(upperCase) + name2.substring(1);
                    }
                    field.set(descriptorRendererOptionsImpl, descriptorRendererOptionsImpl.o0(cVar.a(this, new PropertyReference1Impl(d2, name, f0.C("get", name2)))));
                }
            }
        }
        return descriptorRendererOptionsImpl;
    }

    public boolean t() {
        return ((Boolean) this.s.a(this, X[17])).booleanValue();
    }

    public boolean u() {
        return ((Boolean) this.N.a(this, X[38])).booleanValue();
    }

    @e
    public l<h.p2.b0.g.t.c.b1.c, Boolean> v() {
        return (l) this.L.a(this, X[36]);
    }

    public boolean w() {
        return ((Boolean) this.V.a(this, X[46])).booleanValue();
    }

    public boolean x() {
        return ((Boolean) this.f16763i.a(this, X[7])).booleanValue();
    }

    @d
    public h.p2.b0.g.t.j.a y() {
        return (h.p2.b0.g.t.j.a) this.b.a(this, X[0]);
    }

    @e
    public l<v0, String> z() {
        return (l) this.y.a(this, X[23]);
    }
}
