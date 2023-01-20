package h.p2.b0;

import h.k2.g;
import h.p2.b0.g.q;
import h.p2.i;
import h.p2.j;
import h.p2.n;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.KCallableImpl;

@g(name = "KCallablesJvm")
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"value", "", "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class b {
    public static final boolean a(@k.e.a.d h.p2.c<?> cVar) {
        h.p2.b0.g.s.b<?> I;
        if (cVar instanceof j) {
            n nVar = (n) cVar;
            Field c2 = f.c(nVar);
            if (!(c2 != null ? c2.isAccessible() : true)) {
                return false;
            }
            Method d2 = f.d(nVar);
            if (!(d2 != null ? d2.isAccessible() : true)) {
                return false;
            }
            Method f2 = f.f((j) cVar);
            if (!(f2 != null ? f2.isAccessible() : true)) {
                return false;
            }
        } else if (cVar instanceof n) {
            n nVar2 = (n) cVar;
            Field c3 = f.c(nVar2);
            if (!(c3 != null ? c3.isAccessible() : true)) {
                return false;
            }
            Method d3 = f.d(nVar2);
            if (!(d3 != null ? d3.isAccessible() : true)) {
                return false;
            }
        } else if (cVar instanceof n.c) {
            Field c4 = f.c(((n.c) cVar).d());
            if (!(c4 != null ? c4.isAccessible() : true)) {
                return false;
            }
            Method e2 = f.e((i) cVar);
            if (!(e2 != null ? e2.isAccessible() : true)) {
                return false;
            }
        } else if (cVar instanceof j.a) {
            Field c5 = f.c(((j.a) cVar).d());
            if (!(c5 != null ? c5.isAccessible() : true)) {
                return false;
            }
            Method e3 = f.e((i) cVar);
            if (!(e3 != null ? e3.isAccessible() : true)) {
                return false;
            }
        } else if (cVar instanceof i) {
            i iVar = (i) cVar;
            Method e4 = f.e(iVar);
            if (!(e4 != null ? e4.isAccessible() : true)) {
                return false;
            }
            KCallableImpl<?> a = q.a(cVar);
            Object b = (a == null || (I = a.I()) == null) ? null : I.b();
            AccessibleObject accessibleObject = b instanceof AccessibleObject ? b : null;
            if (!(accessibleObject != null ? accessibleObject.isAccessible() : true)) {
                return false;
            }
            Constructor a2 = f.a(iVar);
            if (!(a2 != null ? a2.isAccessible() : true)) {
                return false;
            }
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
        }
        return true;
    }

    public static final void b(@k.e.a.d h.p2.c<?> cVar, boolean z) {
        h.p2.b0.g.s.b<?> I;
        if (cVar instanceof j) {
            n nVar = (n) cVar;
            Field c2 = f.c(nVar);
            if (c2 != null) {
                c2.setAccessible(z);
            }
            Method d2 = f.d(nVar);
            if (d2 != null) {
                d2.setAccessible(z);
            }
            Method f2 = f.f((j) cVar);
            if (f2 != null) {
                f2.setAccessible(z);
            }
        } else if (cVar instanceof n) {
            n nVar2 = (n) cVar;
            Field c3 = f.c(nVar2);
            if (c3 != null) {
                c3.setAccessible(z);
            }
            Method d3 = f.d(nVar2);
            if (d3 != null) {
                d3.setAccessible(z);
            }
        } else if (cVar instanceof n.c) {
            Field c4 = f.c(((n.c) cVar).d());
            if (c4 != null) {
                c4.setAccessible(z);
            }
            Method e2 = f.e((i) cVar);
            if (e2 != null) {
                e2.setAccessible(z);
            }
        } else if (cVar instanceof j.a) {
            Field c5 = f.c(((j.a) cVar).d());
            if (c5 != null) {
                c5.setAccessible(z);
            }
            Method e3 = f.e((i) cVar);
            if (e3 != null) {
                e3.setAccessible(z);
            }
        } else if (cVar instanceof i) {
            i iVar = (i) cVar;
            Method e4 = f.e(iVar);
            if (e4 != null) {
                e4.setAccessible(z);
            }
            KCallableImpl<?> a = q.a(cVar);
            Object b = (a == null || (I = a.I()) == null) ? null : I.b();
            AccessibleObject accessibleObject = b instanceof AccessibleObject ? b : null;
            if (accessibleObject != null) {
                accessibleObject.setAccessible(true);
            }
            Constructor a2 = f.a(iVar);
            if (a2 != null) {
                a2.setAccessible(z);
            }
        } else {
            throw new UnsupportedOperationException("Unknown callable: " + cVar + " (" + cVar.getClass() + ')');
        }
    }
}
