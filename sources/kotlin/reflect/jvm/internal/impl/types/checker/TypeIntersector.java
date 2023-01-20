package kotlin.reflect.jvm.internal.impl.types.checker;

import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import h.k2.u.p;
import h.k2.v.u;
import h.p2.b0.g.t.n.c1;
import h.p2.b0.g.t.n.e1.j;
import h.p2.b0.g.t.n.e1.l;
import h.p2.b0.g.t.n.e1.m;
import h.p2.b0.g.t.n.e1.o;
import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.i0;
import h.p2.b0.g.t.n.x;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor;

/* loaded from: classes3.dex */
public final class TypeIntersector {
    @d
    public static final TypeIntersector a = new TypeIntersector();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* loaded from: classes3.dex */
    public static final class ResultNullability {
        public static final ResultNullability START = new START("START", 0);
        public static final ResultNullability ACCEPT_NULL = new ACCEPT_NULL("ACCEPT_NULL", 1);
        public static final ResultNullability UNKNOWN = new UNKNOWN(GrsBaseInfo.CountryCodeSource.UNKNOWN, 2);
        public static final ResultNullability NOT_NULL = new NOT_NULL("NOT_NULL", 3);
        private static final /* synthetic */ ResultNullability[] $VALUES = $values();

        /* loaded from: classes3.dex */
        public static final class ACCEPT_NULL extends ResultNullability {
            public ACCEPT_NULL(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            @d
            public ResultNullability combine(@d c1 c1Var) {
                return getResultNullability(c1Var);
            }
        }

        /* loaded from: classes3.dex */
        public static final class NOT_NULL extends ResultNullability {
            public NOT_NULL(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            @d
            public NOT_NULL combine(@d c1 c1Var) {
                return this;
            }
        }

        /* loaded from: classes3.dex */
        public static final class START extends ResultNullability {
            public START(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            @d
            public ResultNullability combine(@d c1 c1Var) {
                return getResultNullability(c1Var);
            }
        }

        /* loaded from: classes3.dex */
        public static final class UNKNOWN extends ResultNullability {
            public UNKNOWN(String str, int i2) {
                super(str, i2, null);
            }

            @Override // kotlin.reflect.jvm.internal.impl.types.checker.TypeIntersector.ResultNullability
            @d
            public ResultNullability combine(@d c1 c1Var) {
                ResultNullability resultNullability = getResultNullability(c1Var);
                return resultNullability == ResultNullability.ACCEPT_NULL ? this : resultNullability;
            }
        }

        private static final /* synthetic */ ResultNullability[] $values() {
            return new ResultNullability[]{START, ACCEPT_NULL, UNKNOWN, NOT_NULL};
        }

        private ResultNullability(String str, int i2) {
        }

        public /* synthetic */ ResultNullability(String str, int i2, u uVar) {
            this(str, i2);
        }

        public static ResultNullability valueOf(String str) {
            return (ResultNullability) Enum.valueOf(ResultNullability.class, str);
        }

        public static ResultNullability[] values() {
            return (ResultNullability[]) $VALUES.clone();
        }

        @d
        public abstract ResultNullability combine(@d c1 c1Var);

        @d
        public final ResultNullability getResultNullability(@d c1 c1Var) {
            return c1Var.J0() ? ACCEPT_NULL : o.a.a(c1Var) ? NOT_NULL : UNKNOWN;
        }
    }

    private TypeIntersector() {
    }

    private final Collection<f0> b(Collection<? extends f0> collection, p<? super f0, ? super f0, Boolean> pVar) {
        boolean z;
        ArrayList<f0> arrayList = new ArrayList(collection);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f0 f0Var = (f0) it.next();
            boolean z2 = true;
            if (!arrayList.isEmpty()) {
                for (f0 f0Var2 : arrayList) {
                    if (f0Var2 == f0Var || !pVar.invoke(f0Var2, f0Var).booleanValue()) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
            }
            z2 = false;
            if (z2) {
                it.remove();
            }
        }
        return arrayList;
    }

    private final f0 d(Set<? extends f0> set) {
        if (set.size() == 1) {
            return (f0) CollectionsKt___CollectionsKt.S4(set);
        }
        new TypeIntersector$intersectTypesWithoutIntersectionType$errorMessage$1(set);
        Collection<f0> b = b(set, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredEqualTypes$1(this));
        b.isEmpty();
        f0 b2 = IntegerLiteralTypeConstructor.f16778f.b(b);
        if (b2 == null) {
            Collection<f0> b3 = b(b, new TypeIntersector$intersectTypesWithoutIntersectionType$filteredSuperAndEqualTypes$1(l.b.a()));
            b3.isEmpty();
            return b3.size() < 2 ? (f0) CollectionsKt___CollectionsKt.S4(b3) : new IntersectionTypeConstructor(set).f();
        }
        return b2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(z zVar, z zVar2) {
        m a2 = l.b.a();
        return a2.d(zVar, zVar2) && !a2.d(zVar2, zVar);
    }

    @d
    public final f0 c(@d List<? extends f0> list) {
        list.size();
        ArrayList<c1> arrayList = new ArrayList();
        for (f0 f0Var : list) {
            if (f0Var.I0() instanceof IntersectionTypeConstructor) {
                Collection<z> j2 = f0Var.I0().j();
                ArrayList arrayList2 = new ArrayList(h.a2.u.Y(j2, 10));
                for (z zVar : j2) {
                    f0 d2 = x.d(zVar);
                    if (f0Var.J0()) {
                        d2 = d2.P0(true);
                    }
                    arrayList2.add(d2);
                }
                arrayList.addAll(arrayList2);
            } else {
                arrayList.add(f0Var);
            }
        }
        ResultNullability resultNullability = ResultNullability.START;
        for (c1 c1Var : arrayList) {
            resultNullability = resultNullability.combine(c1Var);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            f0 f0Var2 = (f0) it.next();
            if (resultNullability == ResultNullability.NOT_NULL) {
                if (f0Var2 instanceof j) {
                    f0Var2 = i0.k((j) f0Var2);
                }
                f0Var2 = i0.i(f0Var2, false, 1, null);
            }
            linkedHashSet.add(f0Var2);
        }
        return d(linkedHashSet);
    }
}
