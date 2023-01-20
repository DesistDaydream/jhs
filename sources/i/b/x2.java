package i.b;

import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006*\n\u0010\u0007\"\u00020\u00032\u00020\u0003¨\u0006\b"}, d2 = {"Lkotlin/Function0;", "Lh/t1;", ReportItem.LogTypeBlock, "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", am.av, "(Lh/k2/u/a;)Ljava/lang/Runnable;", "Runnable", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class x2 {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lh/t1;", "run", "()V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a implements Runnable {
        public final /* synthetic */ h.k2.u.a a;

        public a(h.k2.u.a aVar) {
            this.a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.invoke();
        }
    }

    @k.e.a.d
    public static final Runnable a(@k.e.a.d h.k2.u.a<h.t1> aVar) {
        return new a(aVar);
    }
}
