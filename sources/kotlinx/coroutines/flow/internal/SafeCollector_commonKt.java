package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.b;
import h.e2.c;
import h.k2.g;
import h.k2.u.p;
import h.p0;
import h.t1;
import i.b.b2;
import i.b.v3.f;
import i.b.w3.e0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u0006\u0012\u0002\b\u00030\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\"\u0010\b\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0080\u0010¢\u0006\u0004\b\b\u0010\t\u001aP\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011\"\u0004\b\u0000\u0010\n2/\b\u0005\u0010\u0010\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\r\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\u000b¢\u0006\u0002\b\u000fH\u0081\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "Lkotlin/coroutines/CoroutineContext;", "currentContext", "Lh/t1;", am.av, "(Lkotlinx/coroutines/flow/internal/SafeCollector;Lkotlin/coroutines/CoroutineContext;)V", "Li/b/b2;", "collectJob", "b", "(Li/b/b2;Li/b/b2;)Li/b/b2;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function2;", "Li/b/v3/f;", "Lh/e2/c;", "", "Lh/q;", ReportItem.LogTypeBlock, "Lkotlinx/coroutines/flow/Flow;", "c", "(Lh/k2/u/p;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class SafeCollector_commonKt {
    @g(name = "checkContext")
    public static final void a(@d SafeCollector<?> safeCollector, @d CoroutineContext coroutineContext) {
        if (((Number) coroutineContext.fold(0, new SafeCollector_commonKt$checkContext$result$1(safeCollector))).intValue() == safeCollector.collectContextSize) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + safeCollector.collectContext + ",\n\t\tbut emission happened in " + coroutineContext + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    @e
    public static final b2 b(@e b2 b2Var, @e b2 b2Var2) {
        while (b2Var != null) {
            if (b2Var == b2Var2 || !(b2Var instanceof e0)) {
                return b2Var;
            }
            b2Var = ((e0) b2Var).t1();
        }
        return null;
    }

    @p0
    @d
    public static final <T> Flow<T> c(@b @d p<? super f<? super T>, ? super c<? super t1>, ? extends Object> pVar) {
        return new SafeCollector_commonKt$unsafeFlow$1(pVar);
    }
}
