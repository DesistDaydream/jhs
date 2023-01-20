package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.p;
import h.k2.u.q;
import h.k2.v.c0;
import h.t1;
import i.b.b2;
import i.b.n0;
import i.b.v3.c0.m;
import i.b.v3.h;
import i.b.v3.i;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u0000H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a%\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\t\u001aX\u0010\u0011\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000023\b\u0004\u0010\u0010\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\nH\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001am\u0010\u0016\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00002H\b\u0004\u0010\u0010\u001aB\b\u0001\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u0013H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001aV\u0010\u0018\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u000021\u0010\u0010\u001a-\b\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\nH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0012\u001a1\u0010\u001b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0087Hø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lkotlinx/coroutines/flow/Flow;", "Lh/t1;", am.av, "(Lkotlinx/coroutines/flow/Flow;Lh/e2/c;)Ljava/lang/Object;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/n0;", "scope", "Li/b/b2;", "i", "(Lkotlinx/coroutines/flow/Flow;Li/b/n0;)Li/b/b2;", "Lkotlin/Function2;", "Lh/k0;", "name", "value", "Lh/e2/c;", "", "action", "b", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/Function3;", "", "index", f.f10128d, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;Lh/e2/c;)Ljava/lang/Object;", "f", "Li/b/v3/f;", "flow", "g", "(Li/b/v3/f;Lkotlinx/coroutines/flow/Flow;Lh/e2/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__CollectKt {
    @e
    public static final Object a(@d Flow<?> flow, @d c<? super t1> cVar) {
        Object e2 = flow.e(m.a, cVar);
        return e2 == b.h() ? e2 : t1.a;
    }

    @e
    public static final <T> Object b(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super t1>, ? extends Object> pVar, @d c<? super t1> cVar) {
        Object e2 = flow.e(new FlowKt__CollectKt$collect$3(pVar), cVar);
        return e2 == b.h() ? e2 : t1.a;
    }

    @e
    private static final Object c(@d Flow flow, @d p pVar, @d c cVar) {
        FlowKt__CollectKt$collect$3 flowKt__CollectKt$collect$3 = new FlowKt__CollectKt$collect$3(pVar);
        c0.e(0);
        Object e2 = flow.e(flowKt__CollectKt$collect$3, cVar);
        c0.e(2);
        c0.e(1);
        return e2;
    }

    @e
    public static final <T> Object d(@d Flow<? extends T> flow, @d q<? super Integer, ? super T, ? super c<? super t1>, ? extends Object> qVar, @d c<? super t1> cVar) {
        Object e2 = flow.e(new FlowKt__CollectKt$collectIndexed$2(qVar), cVar);
        return e2 == b.h() ? e2 : t1.a;
    }

    @e
    private static final Object e(@d Flow flow, @d q qVar, @d c cVar) {
        FlowKt__CollectKt$collectIndexed$2 flowKt__CollectKt$collectIndexed$2 = new FlowKt__CollectKt$collectIndexed$2(qVar);
        c0.e(0);
        Object e2 = flow.e(flowKt__CollectKt$collectIndexed$2, cVar);
        c0.e(2);
        c0.e(1);
        return e2;
    }

    @e
    public static final <T> Object f(@d Flow<? extends T> flow, @d p<? super T, ? super c<? super t1>, ? extends Object> pVar, @d c<? super t1> cVar) {
        Flow d2;
        d2 = i.d(h.e1(flow, pVar), 0, null, 2, null);
        Object z = h.z(d2, cVar);
        return z == b.h() ? z : t1.a;
    }

    @h.b
    @e
    public static final <T> Object g(@d i.b.v3.f<? super T> fVar, @d Flow<? extends T> flow, @d c<? super t1> cVar) {
        Object e2 = flow.e(fVar, cVar);
        return e2 == b.h() ? e2 : t1.a;
    }

    @h.b
    @e
    private static final Object h(@d i.b.v3.f fVar, @d Flow flow, @d c cVar) {
        c0.e(0);
        Object e2 = flow.e(fVar, cVar);
        c0.e(2);
        c0.e(1);
        return e2;
    }

    @d
    public static final <T> b2 i(@d Flow<? extends T> flow, @d n0 n0Var) {
        b2 f2;
        f2 = i.b.i.f(n0Var, null, null, new FlowKt__CollectKt$launchIn$1(flow, null), 3, null);
        return f2;
    }
}
