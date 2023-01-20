package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.t0;
import i.b.v3.x;
import java.util.Objects;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u000e\u001a#\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0002\u0010\u0003\u001a[\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u000126\u0010\n\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a=\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\r*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001aw\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e2:\u0010\n\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0015\u0012\u0013\u0018\u00010\u0012¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\"2\u0010\u001a\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u000e8\u0002@\u0003X\u0083\u0004¢\u0006\u0012\n\u0004\b\u0002\u0010\u0015\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017\"8\u0010\u001f\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\t0\u00048\u0002@\u0003X\u0083\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010\u001b\u0012\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001c\u0010\u001d¨\u0006 "}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", am.av, "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function2;", "Lh/k0;", "name", "old", "new", "", "areEquivalent", "b", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "K", "Lkotlin/Function1;", "keySelector", "c", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/l;)Lkotlinx/coroutines/flow/Flow;", "", f.f10128d, "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/l;Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "Lh/k2/u/l;", "g", "()Lh/k2/u/l;", "getDefaultKeySelector$FlowKt__DistinctKt$annotations", "()V", "defaultKeySelector", "Lh/k2/u/p;", e.a, "()Lh/k2/u/p;", "getDefaultAreEquivalent$FlowKt__DistinctKt$annotations", "defaultAreEquivalent", "kotlinx-coroutines-core"}, k = 5, mv = {1, 4, 0}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes4.dex */
public final /* synthetic */ class FlowKt__DistinctKt {
    private static final l<Object, Object> a = FlowKt__DistinctKt$defaultKeySelector$1.INSTANCE;
    private static final p<Object, Object, Boolean> b = FlowKt__DistinctKt$defaultAreEquivalent$1.INSTANCE;

    /* JADX WARN: Multi-variable type inference failed */
    @d
    public static final <T> Flow<T> a(@d Flow<? extends T> flow) {
        return flow instanceof x ? flow : d(flow, a, b);
    }

    @d
    public static final <T> Flow<T> b(@d Flow<? extends T> flow, @d p<? super T, ? super T, Boolean> pVar) {
        l<Object, Object> lVar = a;
        Objects.requireNonNull(pVar, "null cannot be cast to non-null type (kotlin.Any?, kotlin.Any?) -> kotlin.Boolean");
        return d(flow, lVar, (p) t0.q(pVar, 2));
    }

    @d
    public static final <T, K> Flow<T> c(@d Flow<? extends T> flow, @d l<? super T, ? extends K> lVar) {
        return d(flow, lVar, b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <T> Flow<T> d(Flow<? extends T> flow, l<? super T, ? extends Object> lVar, p<Object, Object, Boolean> pVar) {
        if (flow instanceof DistinctFlowImpl) {
            DistinctFlowImpl distinctFlowImpl = (DistinctFlowImpl) flow;
            if (distinctFlowImpl.b == lVar && distinctFlowImpl.f16948c == pVar) {
                return flow;
            }
        }
        return new DistinctFlowImpl(flow, lVar, pVar);
    }

    private static final p<Object, Object, Boolean> e() {
        return b;
    }

    private static /* synthetic */ void f() {
    }

    private static final l<Object, Object> g() {
        return a;
    }

    private static /* synthetic */ void h() {
    }
}
