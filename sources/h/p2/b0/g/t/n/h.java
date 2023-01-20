package h.p2.b0.g.t.n;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import h.p2.b0.g.t.c.r0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class h extends b implements q0 {

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.c.d f15579d;

    /* renamed from: e  reason: collision with root package name */
    private final List<h.p2.b0.g.t.c.t0> f15580e;

    /* renamed from: f  reason: collision with root package name */
    private final Collection<z> f15581f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@k.e.a.d h.p2.b0.g.t.c.d dVar, @k.e.a.d List<? extends h.p2.b0.g.t.c.t0> list, @k.e.a.d Collection<z> collection, @k.e.a.d h.p2.b0.g.t.m.m mVar) {
        super(mVar);
        if (dVar == null) {
            u(0);
        }
        if (list == null) {
            u(1);
        }
        if (collection == null) {
            u(2);
        }
        if (mVar == null) {
            u(3);
        }
        this.f15579d = dVar;
        this.f15580e = Collections.unmodifiableList(new ArrayList(list));
        this.f15581f = Collections.unmodifiableCollection(collection);
    }

    private static /* synthetic */ void u(int i2) {
        String str = (i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = PushConstants.PARAMS;
                break;
            case 2:
                objArr[0] = "supertypes";
                break;
            case 3:
                objArr[0] = "storageManager";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
                break;
            default:
                objArr[0] = "classDescriptor";
                break;
        }
        if (i2 == 4) {
            objArr[1] = "getParameters";
        } else if (i2 == 5) {
            objArr[1] = "getDeclarationDescriptor";
        } else if (i2 == 6) {
            objArr[1] = "computeSupertypes";
        } else if (i2 != 7) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/ClassTypeConstructorImpl";
        } else {
            objArr[1] = "getSupertypeLoopChecker";
        }
        if (i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 != 4 && i2 != 5 && i2 != 6 && i2 != 7) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // h.p2.b0.g.t.n.q0
    public boolean d() {
        return true;
    }

    @Override // h.p2.b0.g.t.n.q0
    @k.e.a.d
    public List<h.p2.b0.g.t.c.t0> getParameters() {
        List<h.p2.b0.g.t.c.t0> list = this.f15580e;
        if (list == null) {
            u(4);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    @k.e.a.d
    public Collection<z> h() {
        Collection<z> collection = this.f15581f;
        if (collection == null) {
            u(6);
        }
        return collection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor
    @k.e.a.d
    public h.p2.b0.g.t.c.r0 n() {
        r0.a aVar = r0.a.a;
        if (aVar == null) {
            u(7);
        }
        return aVar;
    }

    public String toString() {
        return h.p2.b0.g.t.k.c.m(this.f15579d).b();
    }

    @Override // h.p2.b0.g.t.n.b, kotlin.reflect.jvm.internal.impl.types.AbstractTypeConstructor, h.p2.b0.g.t.n.q0
    @k.e.a.d
    /* renamed from: v */
    public h.p2.b0.g.t.c.d c() {
        h.p2.b0.g.t.c.d dVar = this.f15579d;
        if (dVar == null) {
            u(5);
        }
        return dVar;
    }
}
