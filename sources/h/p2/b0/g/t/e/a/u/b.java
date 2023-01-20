package h.p2.b0.g.t.e.a.u;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.a;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.n.z;
import java.util.List;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;

/* loaded from: classes3.dex */
public class b extends h.p2.b0.g.t.c.d1.e implements a {
    public static final /* synthetic */ boolean I = false;
    private Boolean G;
    private Boolean H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.e b bVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, boolean z, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d o0 o0Var) {
        super(dVar, bVar, eVar, z, kind, o0Var);
        if (dVar == null) {
            A(0);
        }
        if (eVar == null) {
            A(1);
        }
        if (kind == null) {
            A(2);
        }
        if (o0Var == null) {
            A(3);
        }
        this.G = null;
        this.H = null;
    }

    private static /* synthetic */ void A(int i2) {
        String str = (i2 == 11 || i2 == 18) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 11 || i2 == 18) ? 2 : 3];
        switch (i2) {
            case 1:
            case 5:
            case 9:
            case 15:
                objArr[0] = "annotations";
                break;
            case 2:
            case 8:
            case 13:
                objArr[0] = "kind";
                break;
            case 3:
            case 6:
            case 10:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 4:
            default:
                objArr[0] = "containingDeclaration";
                break;
            case 7:
            case 12:
                objArr[0] = "newOwner";
                break;
            case 11:
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
                break;
            case 14:
                objArr[0] = "sourceElement";
                break;
            case 16:
                objArr[0] = "enhancedValueParametersData";
                break;
            case 17:
                objArr[0] = "enhancedReturnType";
                break;
        }
        if (i2 == 11) {
            objArr[1] = "createSubstitutedCopy";
        } else if (i2 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/descriptors/JavaClassConstructorDescriptor";
        } else {
            objArr[1] = "enhance";
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
                objArr[2] = "createJavaConstructor";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[2] = "createSubstitutedCopy";
                break;
            case 11:
            case 18:
                break;
            case 12:
            case 13:
            case 14:
            case 15:
                objArr[2] = "createDescriptor";
                break;
            case 16:
            case 17:
                objArr[2] = "enhance";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 11 && i2 != 18) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @k.e.a.d
    public static b o1(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, boolean z, @k.e.a.d o0 o0Var) {
        if (dVar == null) {
            A(4);
        }
        if (eVar == null) {
            A(5);
        }
        if (o0Var == null) {
            A(6);
        }
        return new b(dVar, null, eVar, z, CallableMemberDescriptor.Kind.DECLARATION, o0Var);
    }

    @Override // h.p2.b0.g.t.c.d1.o
    public boolean M0() {
        return this.G.booleanValue();
    }

    @Override // h.p2.b0.g.t.c.d1.o
    public void U0(boolean z) {
        this.G = Boolean.valueOf(z);
    }

    @Override // h.p2.b0.g.t.c.d1.o
    public void V0(boolean z) {
        this.H = Boolean.valueOf(z);
    }

    @Override // h.p2.b0.g.t.c.d1.o, h.p2.b0.g.t.c.a
    public boolean e0() {
        return this.H.booleanValue();
    }

    @k.e.a.d
    public b n1(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.e b bVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.d o0 o0Var, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        if (dVar == null) {
            A(12);
        }
        if (kind == null) {
            A(13);
        }
        if (o0Var == null) {
            A(14);
        }
        if (eVar == null) {
            A(15);
        }
        return new b(dVar, bVar, eVar, this.D, kind, o0Var);
    }

    @Override // h.p2.b0.g.t.c.d1.e
    @k.e.a.d
    /* renamed from: p1 */
    public b j1(@k.e.a.d k kVar, @k.e.a.e v vVar, @k.e.a.d CallableMemberDescriptor.Kind kind, @k.e.a.e h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d o0 o0Var) {
        if (kVar == null) {
            A(7);
        }
        if (kind == null) {
            A(8);
        }
        if (eVar == null) {
            A(9);
        }
        if (o0Var == null) {
            A(10);
        }
        if (kind != CallableMemberDescriptor.Kind.DECLARATION && kind != CallableMemberDescriptor.Kind.SYNTHESIZED) {
            throw new IllegalStateException("Attempt at creating a constructor that is not a declaration: \ncopy from: " + this + "\nnewOwner: " + kVar + "\nkind: " + kind);
        }
        b n1 = n1((h.p2.b0.g.t.c.d) kVar, (b) vVar, kind, o0Var, eVar);
        n1.U0(M0());
        n1.V0(e0());
        if (n1 == null) {
            A(11);
        }
        return n1;
    }

    @Override // h.p2.b0.g.t.e.a.u.a
    @k.e.a.d
    /* renamed from: q1 */
    public b Z(@k.e.a.e z zVar, @k.e.a.d List<h> list, @k.e.a.d z zVar2, @k.e.a.e Pair<a.InterfaceC0434a<?>, ?> pair) {
        if (list == null) {
            A(16);
        }
        if (zVar2 == null) {
            A(17);
        }
        b j1 = j1(b(), null, i(), null, getAnnotations(), getSource());
        j1.N0(zVar == null ? null : h.p2.b0.g.t.k.b.f(j1, zVar, h.p2.b0.g.t.c.b1.e.w0.b()), M(), getTypeParameters(), g.a(list, h(), j1), zVar2, t(), getVisibility());
        if (pair != null) {
            j1.Q0(pair.getFirst(), pair.getSecond());
        }
        if (j1 == null) {
            A(18);
        }
        return j1;
    }
}
