package h.p2.b0.g.t.c.d1;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.c.x0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public abstract class o extends j implements h.p2.b0.g.t.c.v {
    private final CallableMemberDescriptor.Kind A;
    @k.e.a.e
    private h.p2.b0.g.t.c.v B;
    public Map<a.InterfaceC0434a<?>, Object> C;

    /* renamed from: e  reason: collision with root package name */
    private List<t0> f15128e;

    /* renamed from: f  reason: collision with root package name */
    private List<v0> f15129f;

    /* renamed from: g  reason: collision with root package name */
    private h.p2.b0.g.t.n.z f15130g;

    /* renamed from: h  reason: collision with root package name */
    private m0 f15131h;

    /* renamed from: i  reason: collision with root package name */
    private m0 f15132i;

    /* renamed from: j  reason: collision with root package name */
    private Modality f15133j;

    /* renamed from: k  reason: collision with root package name */
    private h.p2.b0.g.t.c.s f15134k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f15135l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f15136m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private Collection<? extends h.p2.b0.g.t.c.v> x;
    private volatile h.k2.u.a<Collection<h.p2.b0.g.t.c.v>> y;
    private final h.p2.b0.g.t.c.v z;

    /* loaded from: classes3.dex */
    public class a implements h.k2.u.a<Collection<h.p2.b0.g.t.c.v>> {
        public final /* synthetic */ TypeSubstitutor a;

        public a(TypeSubstitutor typeSubstitutor) {
            this.a = typeSubstitutor;
        }

        @Override // h.k2.u.a
        /* renamed from: a */
        public Collection<h.p2.b0.g.t.c.v> invoke() {
            h.p2.b0.g.t.p.d dVar = new h.p2.b0.g.t.p.d();
            for (h.p2.b0.g.t.c.v vVar : o.this.d()) {
                dVar.add(vVar.c(this.a));
            }
            return dVar;
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements h.k2.u.a<List<x0>> {
        public final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        @Override // h.k2.u.a
        /* renamed from: a */
        public List<x0> invoke() {
            return this.a;
        }
    }

    /* loaded from: classes3.dex */
    public class c implements v.a<h.p2.b0.g.t.c.v> {
        @k.e.a.d
        public h.p2.b0.g.t.n.v0 a;
        @k.e.a.d
        public h.p2.b0.g.t.c.k b;
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public Modality f15137c;
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        public h.p2.b0.g.t.c.s f15138d;
        @k.e.a.e

        /* renamed from: e  reason: collision with root package name */
        public h.p2.b0.g.t.c.v f15139e;
        @k.e.a.d

        /* renamed from: f  reason: collision with root package name */
        public CallableMemberDescriptor.Kind f15140f;
        @k.e.a.d

        /* renamed from: g  reason: collision with root package name */
        public List<v0> f15141g;
        @k.e.a.e

        /* renamed from: h  reason: collision with root package name */
        public m0 f15142h;
        @k.e.a.e

        /* renamed from: i  reason: collision with root package name */
        public m0 f15143i;
        @k.e.a.d

        /* renamed from: j  reason: collision with root package name */
        public h.p2.b0.g.t.n.z f15144j;
        @k.e.a.e

        /* renamed from: k  reason: collision with root package name */
        public h.p2.b0.g.t.g.f f15145k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f15146l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f15147m;
        public boolean n;
        public boolean o;
        private boolean p;
        private List<t0> q;
        private h.p2.b0.g.t.c.b1.e r;
        private boolean s;
        private Map<a.InterfaceC0434a<?>, Object> t;
        private Boolean u;
        public boolean v;
        public final /* synthetic */ o w;

        public c(@k.e.a.d o oVar, @k.e.a.d h.p2.b0.g.t.n.v0 v0Var, @k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d Modality modality, @k.e.a.d h.p2.b0.g.t.c.s sVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.e List<v0> list, @k.e.a.d m0 m0Var, @k.e.a.e h.p2.b0.g.t.n.z zVar, h.p2.b0.g.t.g.f fVar) {
            if (v0Var == null) {
                t(0);
            }
            if (kVar == null) {
                t(1);
            }
            if (modality == null) {
                t(2);
            }
            if (sVar == null) {
                t(3);
            }
            if (kind == null) {
                t(4);
            }
            if (list == null) {
                t(5);
            }
            if (zVar == null) {
                t(6);
            }
            this.w = oVar;
            this.f15139e = null;
            this.f15143i = oVar.f15132i;
            this.f15146l = true;
            this.f15147m = false;
            this.n = false;
            this.o = false;
            this.p = oVar.z0();
            this.q = null;
            this.r = null;
            this.s = oVar.B0();
            this.t = new LinkedHashMap();
            this.u = null;
            this.v = false;
            this.a = v0Var;
            this.b = kVar;
            this.f15137c = modality;
            this.f15138d = sVar;
            this.f15140f = kind;
            this.f15141g = list;
            this.f15142h = m0Var;
            this.f15144j = zVar;
            this.f15145k = fVar;
        }

        private static /* synthetic */ void t(int i2) {
            String str;
            int i3;
            switch (i2) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    str = "@NotNull method %s.%s must not return null";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            switch (i2) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    i3 = 2;
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    i3 = 3;
                    break;
            }
            Object[] objArr = new Object[i3];
            switch (i2) {
                case 1:
                    objArr[0] = "newOwner";
                    break;
                case 2:
                    objArr[0] = "newModality";
                    break;
                case 3:
                    objArr[0] = "newVisibility";
                    break;
                case 4:
                case 13:
                    objArr[0] = "kind";
                    break;
                case 5:
                    objArr[0] = "newValueParameterDescriptors";
                    break;
                case 6:
                    objArr[0] = "newReturnType";
                    break;
                case 7:
                    objArr[0] = TUIConstants.TUIChat.OWNER;
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 9:
                    objArr[0] = "modality";
                    break;
                case 11:
                    objArr[0] = "visibility";
                    break;
                case 16:
                    objArr[0] = "name";
                    break;
                case 18:
                case 20:
                    objArr[0] = PushConstants.PARAMS;
                    break;
                case 22:
                    objArr[0] = "type";
                    break;
                case 32:
                    objArr[0] = "additionalAnnotations";
                    break;
                case 34:
                default:
                    objArr[0] = "substitution";
                    break;
                case 36:
                    objArr[0] = "userDataKey";
                    break;
            }
            switch (i2) {
                case 8:
                    objArr[1] = "setOwner";
                    break;
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl$CopyConfiguration";
                    break;
                case 10:
                    objArr[1] = "setModality";
                    break;
                case 12:
                    objArr[1] = "setVisibility";
                    break;
                case 14:
                    objArr[1] = "setKind";
                    break;
                case 15:
                    objArr[1] = "setCopyOverrides";
                    break;
                case 17:
                    objArr[1] = "setName";
                    break;
                case 19:
                    objArr[1] = "setValueParameters";
                    break;
                case 21:
                    objArr[1] = "setTypeParameters";
                    break;
                case 23:
                    objArr[1] = "setReturnType";
                    break;
                case 24:
                    objArr[1] = "setExtensionReceiverParameter";
                    break;
                case 25:
                    objArr[1] = "setDispatchReceiverParameter";
                    break;
                case 26:
                    objArr[1] = "setOriginal";
                    break;
                case 27:
                    objArr[1] = "setSignatureChange";
                    break;
                case 28:
                    objArr[1] = "setPreserveSourceElement";
                    break;
                case 29:
                    objArr[1] = "setDropOriginalInContainingParts";
                    break;
                case 30:
                    objArr[1] = "setHiddenToOvercomeSignatureClash";
                    break;
                case 31:
                    objArr[1] = "setHiddenForResolutionEverywhereBesideSupercalls";
                    break;
                case 33:
                    objArr[1] = "setAdditionalAnnotations";
                    break;
                case 35:
                    objArr[1] = "setSubstitution";
                    break;
                case 37:
                    objArr[1] = "putUserData";
                    break;
                case 38:
                    objArr[1] = "getSubstitution";
                    break;
                case 39:
                    objArr[1] = "setJustForTypeSubstitution";
                    break;
            }
            switch (i2) {
                case 7:
                    objArr[2] = "setOwner";
                    break;
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    break;
                case 9:
                    objArr[2] = "setModality";
                    break;
                case 11:
                    objArr[2] = "setVisibility";
                    break;
                case 13:
                    objArr[2] = "setKind";
                    break;
                case 16:
                    objArr[2] = "setName";
                    break;
                case 18:
                    objArr[2] = "setValueParameters";
                    break;
                case 20:
                    objArr[2] = "setTypeParameters";
                    break;
                case 22:
                    objArr[2] = "setReturnType";
                    break;
                case 32:
                    objArr[2] = "setAdditionalAnnotations";
                    break;
                case 34:
                    objArr[2] = "setSubstitution";
                    break;
                case 36:
                    objArr[2] = "putUserData";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            switch (i2) {
                case 8:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                case 19:
                case 21:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 33:
                case 35:
                case 37:
                case 38:
                case 39:
                    throw new IllegalStateException(format);
                case 9:
                case 11:
                case 13:
                case 16:
                case 18:
                case 20:
                case 22:
                case 32:
                case 34:
                case 36:
                default:
                    throw new IllegalArgumentException(format);
            }
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: A */
        public c r(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
            if (eVar == null) {
                t(32);
            }
            this.r = eVar;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: B */
        public c n(boolean z) {
            this.f15146l = z;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: C */
        public c c(@k.e.a.e m0 m0Var) {
            this.f15143i = m0Var;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: D */
        public c a() {
            this.o = true;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: E */
        public c e(@k.e.a.e m0 m0Var) {
            this.f15142h = m0Var;
            return this;
        }

        public c F(boolean z) {
            this.u = Boolean.valueOf(z);
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: G */
        public c d() {
            this.s = true;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: H */
        public c h() {
            this.p = true;
            return this;
        }

        @k.e.a.d
        public c I(boolean z) {
            this.v = z;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: J */
        public c q(@k.e.a.d CallableMemberDescriptor.Kind kind) {
            if (kind == null) {
                t(13);
            }
            this.f15140f = kind;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: K */
        public c j(@k.e.a.d Modality modality) {
            if (modality == null) {
                t(9);
            }
            this.f15137c = modality;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: L */
        public c i(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
            if (fVar == null) {
                t(16);
            }
            this.f15145k = fVar;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: M */
        public c m(@k.e.a.e CallableMemberDescriptor callableMemberDescriptor) {
            this.f15139e = (h.p2.b0.g.t.c.v) callableMemberDescriptor;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: N */
        public c p(@k.e.a.d h.p2.b0.g.t.c.k kVar) {
            if (kVar == null) {
                t(7);
            }
            this.b = kVar;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: O */
        public c k() {
            this.n = true;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: P */
        public c l(@k.e.a.d h.p2.b0.g.t.n.z zVar) {
            if (zVar == null) {
                t(22);
            }
            this.f15144j = zVar;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: Q */
        public c s() {
            this.f15147m = true;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: R */
        public c f(@k.e.a.d h.p2.b0.g.t.n.v0 v0Var) {
            if (v0Var == null) {
                t(34);
            }
            this.a = v0Var;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: S */
        public c o(@k.e.a.d List<t0> list) {
            if (list == null) {
                t(20);
            }
            this.q = list;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: T */
        public c b(@k.e.a.d List<v0> list) {
            if (list == null) {
                t(18);
            }
            this.f15141g = list;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.d
        /* renamed from: U */
        public c g(@k.e.a.d h.p2.b0.g.t.c.s sVar) {
            if (sVar == null) {
                t(11);
            }
            this.f15138d = sVar;
            return this;
        }

        @Override // h.p2.b0.g.t.c.v.a
        @k.e.a.e
        public h.p2.b0.g.t.c.v build() {
            return this.w.I0(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.e h.p2.b0.g.t.c.v vVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d o0 o0Var) {
        super(kVar, eVar, fVar, o0Var);
        if (kVar == null) {
            A(0);
        }
        if (eVar == null) {
            A(1);
        }
        if (fVar == null) {
            A(2);
        }
        if (kind == null) {
            A(3);
        }
        if (o0Var == null) {
            A(4);
        }
        this.f15134k = h.p2.b0.g.t.c.r.f15215i;
        this.f15135l = false;
        this.f15136m = false;
        this.n = false;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = false;
        this.s = false;
        this.t = false;
        this.u = false;
        this.v = true;
        this.w = false;
        this.x = null;
        this.y = null;
        this.B = null;
        this.C = null;
        this.z = vVar == null ? this : vVar;
        this.A = kind;
    }

    private static /* synthetic */ void A(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                i3 = 2;
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "kind";
                break;
            case 4:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 5:
                objArr[0] = "typeParameters";
                break;
            case 6:
            case 26:
            case 28:
                objArr[0] = "unsubstitutedValueParameters";
                break;
            case 7:
            case 9:
                objArr[0] = "visibility";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 10:
                objArr[0] = "unsubstitutedReturnType";
                break;
            case 11:
                objArr[0] = "extensionReceiverParameter";
                break;
            case 15:
                objArr[0] = "overriddenDescriptors";
                break;
            case 20:
                objArr[0] = "originalSubstitutor";
                break;
            case 22:
            case 27:
            case 29:
                objArr[0] = "substitutor";
                break;
            case 23:
                objArr[0] = "configuration";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 8:
                objArr[1] = "initialize";
                break;
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/FunctionDescriptorImpl";
                break;
            case 12:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 13:
                objArr[1] = "getModality";
                break;
            case 14:
                objArr[1] = "getVisibility";
                break;
            case 16:
                objArr[1] = "getTypeParameters";
                break;
            case 17:
                objArr[1] = "getValueParameters";
                break;
            case 18:
                objArr[1] = "getOriginal";
                break;
            case 19:
                objArr[1] = "getKind";
                break;
            case 21:
                objArr[1] = "newCopyBuilder";
                break;
            case 24:
                objArr[1] = "copy";
                break;
            case 25:
                objArr[1] = "getSourceToUseForCopy";
                break;
        }
        switch (i2) {
            case 5:
            case 6:
            case 7:
                objArr[2] = "initialize";
                break;
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                break;
            case 9:
                objArr[2] = "setVisibility";
                break;
            case 10:
                objArr[2] = "setReturnType";
                break;
            case 11:
                objArr[2] = "setExtensionReceiverParameter";
                break;
            case 15:
                objArr[2] = "setOverriddenDescriptors";
                break;
            case 20:
                objArr[2] = "substitute";
                break;
            case 22:
                objArr[2] = "newCopyBuilder";
                break;
            case 23:
                objArr[2] = "doSubstitute";
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                objArr[2] = "getSubstitutedValueParameters";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 8:
            case 12:
            case 13:
            case 14:
            case 16:
            case 17:
            case 18:
            case 19:
            case 21:
            case 24:
            case 25:
                throw new IllegalStateException(format);
            case 9:
            case 10:
            case 11:
            case 15:
            case 20:
            case 22:
            case 23:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @k.e.a.d
    private o0 J0(boolean z, @k.e.a.e h.p2.b0.g.t.c.v vVar) {
        o0 o0Var;
        if (z) {
            if (vVar == null) {
                vVar = h0();
            }
            o0Var = vVar.getSource();
        } else {
            o0Var = o0.a;
        }
        if (o0Var == null) {
            A(25);
        }
        return o0Var;
    }

    @k.e.a.e
    public static List<v0> K0(h.p2.b0.g.t.c.v vVar, @k.e.a.d List<v0> list, @k.e.a.d TypeSubstitutor typeSubstitutor) {
        if (list == null) {
            A(26);
        }
        if (typeSubstitutor == null) {
            A(27);
        }
        return L0(vVar, list, typeSubstitutor, false, false, null);
    }

    @k.e.a.e
    public static List<v0> L0(h.p2.b0.g.t.c.v vVar, @k.e.a.d List<v0> list, @k.e.a.d TypeSubstitutor typeSubstitutor, boolean z, boolean z2, @k.e.a.e boolean[] zArr) {
        if (list == null) {
            A(28);
        }
        if (typeSubstitutor == null) {
            A(29);
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (v0 v0Var : list) {
            h.p2.b0.g.t.n.z type = v0Var.getType();
            Variance variance = Variance.IN_VARIANCE;
            h.p2.b0.g.t.n.z p = typeSubstitutor.p(type, variance);
            h.p2.b0.g.t.n.z t0 = v0Var.t0();
            h.p2.b0.g.t.n.z p2 = t0 == null ? null : typeSubstitutor.p(t0, variance);
            if (p == null) {
                return null;
            }
            if ((p != v0Var.getType() || t0 != p2) && zArr != null) {
                zArr[0] = true;
            }
            arrayList.add(ValueParameterDescriptorImpl.H0(vVar, z ? null : v0Var, v0Var.f(), v0Var.getAnnotations(), v0Var.getName(), p, v0Var.x0(), v0Var.p0(), v0Var.n0(), p2, z2 ? v0Var.getSource() : o0.a, v0Var instanceof ValueParameterDescriptorImpl.WithDestructuringDeclaration ? new b(((ValueParameterDescriptorImpl.WithDestructuringDeclaration) v0Var).K0()) : null));
        }
        return arrayList;
    }

    private void P0() {
        h.k2.u.a<Collection<h.p2.b0.g.t.c.v>> aVar = this.y;
        if (aVar != null) {
            this.x = aVar.invoke();
            this.y = null;
        }
    }

    private void W0(boolean z) {
        this.t = z;
    }

    private void X0(boolean z) {
        this.s = z;
    }

    private void Z0(@k.e.a.e h.p2.b0.g.t.c.v vVar) {
        this.B = vVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void A0(@k.e.a.d Collection<? extends CallableMemberDescriptor> collection) {
        if (collection == 0) {
            A(15);
        }
        this.x = collection;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((h.p2.b0.g.t.c.v) it.next()).B0()) {
                this.t = true;
                return;
            }
        }
    }

    public <R, D> R B(h.p2.b0.g.t.c.m<R, D> mVar, D d2) {
        return mVar.i(this, d2);
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean B0() {
        return this.t;
    }

    public boolean D() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @k.e.a.d
    /* renamed from: G0 */
    public h.p2.b0.g.t.c.v P(h.p2.b0.g.t.c.k kVar, Modality modality, h.p2.b0.g.t.c.s sVar, CallableMemberDescriptor.Kind kind, boolean z) {
        h.p2.b0.g.t.c.v build = x().p(kVar).j(modality).g(sVar).q(kind).n(z).build();
        if (build == null) {
            A(24);
        }
        return build;
    }

    @k.e.a.d
    public abstract o H0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.e h.p2.b0.g.t.c.v vVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.e h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d o0 o0Var);

    @k.e.a.e
    public h.p2.b0.g.t.c.v I0(@k.e.a.d c cVar) {
        c0 c0Var;
        m0 m0Var;
        h.p2.b0.g.t.n.z p;
        if (cVar == null) {
            A(23);
        }
        boolean[] zArr = new boolean[1];
        h.p2.b0.g.t.c.b1.e a2 = cVar.r != null ? h.p2.b0.g.t.c.b1.g.a(getAnnotations(), cVar.r) : getAnnotations();
        h.p2.b0.g.t.c.k kVar = cVar.b;
        h.p2.b0.g.t.c.v vVar = cVar.f15139e;
        o H0 = H0(kVar, vVar, cVar.f15140f, cVar.f15145k, a2, J0(cVar.n, vVar));
        List<t0> typeParameters = cVar.q == null ? getTypeParameters() : cVar.q;
        zArr[0] = zArr[0] | (!typeParameters.isEmpty());
        ArrayList arrayList = new ArrayList(typeParameters.size());
        TypeSubstitutor c2 = h.p2.b0.g.t.n.n.c(typeParameters, cVar.a, H0, arrayList, zArr);
        if (c2 == null) {
            return null;
        }
        m0 m0Var2 = cVar.f15142h;
        if (m0Var2 != null) {
            h.p2.b0.g.t.n.z p2 = c2.p(m0Var2.getType(), Variance.IN_VARIANCE);
            if (p2 == null) {
                return null;
            }
            c0 c0Var2 = new c0(H0, new h.p2.b0.g.t.k.r.i.b(H0, p2, cVar.f15142h.getValue()), cVar.f15142h.getAnnotations());
            zArr[0] = (p2 != cVar.f15142h.getType()) | zArr[0];
            c0Var = c0Var2;
        } else {
            c0Var = null;
        }
        m0 m0Var3 = cVar.f15143i;
        if (m0Var3 != null) {
            m0 c3 = m0Var3.c(c2);
            if (c3 == null) {
                return null;
            }
            zArr[0] = zArr[0] | (c3 != cVar.f15143i);
            m0Var = c3;
        } else {
            m0Var = null;
        }
        List<v0> L0 = L0(H0, cVar.f15141g, c2, cVar.o, cVar.n, zArr);
        if (L0 == null || (p = c2.p(cVar.f15144j, Variance.OUT_VARIANCE)) == null) {
            return null;
        }
        zArr[0] = zArr[0] | (p != cVar.f15144j);
        if (zArr[0] || !cVar.v) {
            H0.N0(c0Var, m0Var, arrayList, L0, p, cVar.f15137c, cVar.f15138d);
            H0.b1(this.f15135l);
            H0.Y0(this.f15136m);
            H0.T0(this.n);
            H0.a1(this.o);
            H0.e1(this.p);
            H0.d1(this.u);
            H0.S0(this.q);
            H0.R0(this.r);
            H0.U0(this.v);
            H0.X0(cVar.p);
            H0.W0(cVar.s);
            H0.V0(cVar.u != null ? cVar.u.booleanValue() : this.w);
            if (!cVar.t.isEmpty() || this.C != null) {
                Map<a.InterfaceC0434a<?>, Object> map = cVar.t;
                Map<a.InterfaceC0434a<?>, Object> map2 = this.C;
                if (map2 != null) {
                    for (Map.Entry<a.InterfaceC0434a<?>, Object> entry : map2.entrySet()) {
                        if (!map.containsKey(entry.getKey())) {
                            map.put(entry.getKey(), entry.getValue());
                        }
                    }
                }
                if (map.size() == 1) {
                    H0.C = Collections.singletonMap(map.keySet().iterator().next(), map.values().iterator().next());
                } else {
                    H0.C = map;
                }
            }
            if (cVar.f15147m || q0() != null) {
                H0.Z0((q0() != null ? q0() : this).c(c2));
            }
            if (cVar.f15146l && !h0().d().isEmpty()) {
                if (cVar.a.f()) {
                    h.k2.u.a<Collection<h.p2.b0.g.t.c.v>> aVar = this.y;
                    if (aVar != null) {
                        H0.y = aVar;
                    } else {
                        H0.A0(d());
                    }
                } else {
                    H0.y = new a(c2);
                }
            }
            return H0;
        }
        return this;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.e
    public m0 M() {
        return this.f15132i;
    }

    public boolean M0() {
        return this.v;
    }

    @k.e.a.d
    public o N0(@k.e.a.e m0 m0Var, @k.e.a.e m0 m0Var2, @k.e.a.d List<? extends t0> list, @k.e.a.d List<v0> list2, @k.e.a.e h.p2.b0.g.t.n.z zVar, @k.e.a.e Modality modality, @k.e.a.d h.p2.b0.g.t.c.s sVar) {
        if (list == null) {
            A(5);
        }
        if (list2 == null) {
            A(6);
        }
        if (sVar == null) {
            A(7);
        }
        this.f15128e = CollectionsKt___CollectionsKt.I5(list);
        this.f15129f = CollectionsKt___CollectionsKt.I5(list2);
        this.f15130g = zVar;
        this.f15133j = modality;
        this.f15134k = sVar;
        this.f15131h = m0Var;
        this.f15132i = m0Var2;
        for (int i2 = 0; i2 < list.size(); i2++) {
            t0 t0Var = list.get(i2);
            if (t0Var.f() != i2) {
                throw new IllegalStateException(t0Var + " index is " + t0Var.f() + " but position is " + i2);
            }
        }
        for (int i3 = 0; i3 < list2.size(); i3++) {
            v0 v0Var = list2.get(i3);
            if (v0Var.f() != i3 + 0) {
                throw new IllegalStateException(v0Var + "index is " + v0Var.f() + " but position is " + i3);
            }
        }
        return this;
    }

    @k.e.a.d
    public c O0(@k.e.a.d TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            A(22);
        }
        return new c(this, typeSubstitutor.j(), b(), t(), getVisibility(), i(), h(), Q(), getReturnType(), null);
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.e
    public m0 Q() {
        return this.f15131h;
    }

    public <V> void Q0(a.InterfaceC0434a<V> interfaceC0434a, Object obj) {
        if (this.C == null) {
            this.C = new LinkedHashMap();
        }
        this.C.put(interfaceC0434a, obj);
    }

    public void R0(boolean z) {
        this.r = z;
    }

    public void S0(boolean z) {
        this.q = z;
    }

    public void T0(boolean z) {
        this.n = z;
    }

    public void U0(boolean z) {
        this.v = z;
    }

    public void V0(boolean z) {
        this.w = z;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean X() {
        return this.r;
    }

    public void Y0(boolean z) {
        this.f15136m = z;
    }

    public void a1(boolean z) {
        this.o = z;
    }

    public void b1(boolean z) {
        this.f15135l = z;
    }

    public void c1(@k.e.a.d h.p2.b0.g.t.n.z zVar) {
        if (zVar == null) {
            A(10);
        }
        this.f15130g = zVar;
    }

    @k.e.a.d
    public Collection<? extends h.p2.b0.g.t.c.v> d() {
        P0();
        Collection<? extends h.p2.b0.g.t.c.v> collection = this.x;
        if (collection == null) {
            collection = Collections.emptyList();
        }
        if (collection == null) {
            A(12);
        }
        return collection;
    }

    public void d1(boolean z) {
        this.u = z;
    }

    @Override // h.p2.b0.g.t.c.a
    public boolean e0() {
        return this.w;
    }

    public void e1(boolean z) {
        this.p = z;
    }

    public void f1(@k.e.a.d h.p2.b0.g.t.c.s sVar) {
        if (sVar == null) {
            A(9);
        }
        this.f15134k = sVar;
    }

    @Override // h.p2.b0.g.t.c.a
    public h.p2.b0.g.t.n.z getReturnType() {
        return this.f15130g;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public List<t0> getTypeParameters() {
        List<t0> list = this.f15128e;
        if (list != null) {
            if (list == null) {
                A(16);
            }
            return list;
        }
        throw new IllegalStateException("typeParameters == null for " + this);
    }

    @Override // h.p2.b0.g.t.c.o, h.p2.b0.g.t.c.w
    @k.e.a.d
    public h.p2.b0.g.t.c.s getVisibility() {
        h.p2.b0.g.t.c.s sVar = this.f15134k;
        if (sVar == null) {
            A(14);
        }
        return sVar;
    }

    @Override // h.p2.b0.g.t.c.a
    @k.e.a.d
    public List<v0> h() {
        List<v0> list = this.f15129f;
        if (list == null) {
            A(17);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
    @k.e.a.d
    public CallableMemberDescriptor.Kind i() {
        CallableMemberDescriptor.Kind kind = this.A;
        if (kind == null) {
            A(19);
        }
        return kind;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean i0() {
        return this.q;
    }

    public boolean isExternal() {
        return this.n;
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean isInfix() {
        if (this.f15136m) {
            return true;
        }
        for (h.p2.b0.g.t.c.v vVar : h0().d()) {
            if (vVar.isInfix()) {
                return true;
            }
        }
        return false;
    }

    public boolean isInline() {
        return this.o;
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean isOperator() {
        if (this.f15135l) {
            return true;
        }
        for (h.p2.b0.g.t.c.v vVar : h0().d()) {
            if (vVar.isOperator()) {
                return true;
            }
        }
        return false;
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean isSuspend() {
        return this.u;
    }

    @Override // h.p2.b0.g.t.c.v
    @k.e.a.e
    public h.p2.b0.g.t.c.v q0() {
        return this.B;
    }

    @Override // h.p2.b0.g.t.c.a
    public <V> V s0(a.InterfaceC0434a<V> interfaceC0434a) {
        Map<a.InterfaceC0434a<?>, Object> map = this.C;
        if (map == null) {
            return null;
        }
        return (V) map.get(interfaceC0434a);
    }

    @Override // h.p2.b0.g.t.c.w
    @k.e.a.d
    public Modality t() {
        Modality modality = this.f15133j;
        if (modality == null) {
            A(13);
        }
        return modality;
    }

    @k.e.a.d
    public v.a<? extends h.p2.b0.g.t.c.v> x() {
        c O0 = O0(TypeSubstitutor.b);
        if (O0 == null) {
            A(21);
        }
        return O0;
    }

    @Override // h.p2.b0.g.t.c.v
    public boolean z0() {
        return this.s;
    }

    @Override // h.p2.b0.g.t.c.v, h.p2.b0.g.t.c.q0
    public h.p2.b0.g.t.c.v c(@k.e.a.d TypeSubstitutor typeSubstitutor) {
        if (typeSubstitutor == null) {
            A(20);
        }
        return typeSubstitutor.k() ? this : O0(typeSubstitutor).m(h0()).k().I(true).build();
    }

    @Override // h.p2.b0.g.t.c.d1.j
    @k.e.a.d
    /* renamed from: a */
    public h.p2.b0.g.t.c.v h0() {
        h.p2.b0.g.t.c.v vVar = this.z;
        h.p2.b0.g.t.c.v a2 = vVar == this ? this : vVar.a();
        if (a2 == null) {
            A(18);
        }
        return a2;
    }
}
