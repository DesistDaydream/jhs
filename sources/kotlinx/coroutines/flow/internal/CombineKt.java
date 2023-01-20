package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.a;
import h.k2.u.q;
import h.p0;
import h.t1;
import i.b.v3.f;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0092\u0001\u0010\u000e\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0010\u0005\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00028\u00010\u00040\u00032\u0016\u0010\u0007\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00018\u0001\u0018\u00010\u00030\u000629\u0010\r\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\b¢\u0006\u0002\b\fH\u0081@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001ap\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00042(\u0010\r\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bH\u0000ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015*\u001c\b\u0002\u0010\u0017\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u00162\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0016\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"R", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/f;", "", "Lkotlinx/coroutines/flow/Flow;", "flows", "Lkotlin/Function0;", "arrayFactory", "Lkotlin/Function3;", "Lh/e2/c;", "Lh/t1;", "", "Lh/q;", "transform", am.av, "(Li/b/v3/f;[Lkotlinx/coroutines/flow/Flow;Lh/k2/u/a;Lh/k2/u/q;Lh/e2/c;)Ljava/lang/Object;", "T1", "T2", "flow", "flow2", "b", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lh/k2/u/q;)Lkotlinx/coroutines/flow/Flow;", "Lh/a2/i0;", "Update", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class CombineKt {
    @p0
    @e
    public static final <R, T> Object a(@d f<? super R> fVar, @d Flow<? extends T>[] flowArr, @d a<T[]> aVar, @d q<? super f<? super R>, ? super T[], ? super c<? super t1>, ? extends Object> qVar, @d c<? super t1> cVar) {
        Object c2 = FlowCoroutineKt.c(new CombineKt$combineInternal$2(fVar, flowArr, aVar, qVar, null), cVar);
        return c2 == b.h() ? c2 : t1.a;
    }

    @d
    public static final <T1, T2, R> Flow<R> b(@d Flow<? extends T1> flow, @d Flow<? extends T2> flow2, @d q<? super T1, ? super T2, ? super c<? super R>, ? extends Object> qVar) {
        return new CombineKt$zipImpl$$inlined$unsafeFlow$1(flow2, flow, qVar);
    }
}
