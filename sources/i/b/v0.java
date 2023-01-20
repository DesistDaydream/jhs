package i.b;

import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@x1
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J%\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH&¢\u0006\u0004\b\n\u0010\u000bJ+\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00022\n\u0010\u000e\u001a\u00060\fj\u0002`\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Li/b/v0;", "", "", "time", "Lh/t1;", "m0", "(JLh/e2/c;)Ljava/lang/Object;", "timeMillis", "Li/b/n;", "continuation", "c", "(JLi/b/n;)V", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", ReportItem.LogTypeBlock, "Lkotlin/coroutines/CoroutineContext;", "context", "Li/b/e1;", am.aI, "(JLjava/lang/Runnable;Lkotlin/coroutines/CoroutineContext;)Li/b/e1;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public interface v0 {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        @k.e.a.e
        public static Object a(@k.e.a.d v0 v0Var, long j2, @k.e.a.d h.e2.c<? super h.t1> cVar) {
            if (j2 <= 0) {
                return h.t1.a;
            }
            o oVar = new o(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
            oVar.G();
            v0Var.c(j2, oVar);
            Object B = oVar.B();
            if (B == h.e2.j.b.h()) {
                h.e2.k.a.f.c(cVar);
            }
            return B;
        }

        @k.e.a.d
        public static e1 b(@k.e.a.d v0 v0Var, long j2, @k.e.a.d Runnable runnable, @k.e.a.d CoroutineContext coroutineContext) {
            return t0.a().t(j2, runnable, coroutineContext);
        }
    }

    void c(long j2, @k.e.a.d n<? super h.t1> nVar);

    @k.e.a.e
    Object m0(long j2, @k.e.a.d h.e2.c<? super h.t1> cVar);

    @k.e.a.d
    e1 t(long j2, @k.e.a.d Runnable runnable, @k.e.a.d CoroutineContext coroutineContext);
}
