package i.b.b4;

import com.umeng.analytics.pro.am;
import h.i;
import h.k2.u.l;
import h.q0;
import h.t1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import k.e.a.d;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a2\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\b\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Li/b/b4/a;", "testContext", "Lkotlin/Function1;", "Lh/t1;", "Lh/q;", "testBody", am.av, "(Li/b/b4/a;Lh/k2/u/l;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class b {
    @i(level = DeprecationLevel.WARNING, message = "This API has been deprecated to integrate with Structured Concurrency.", replaceWith = @q0(expression = "testContext.runBlockingTest(testBody)", imports = {"kotlin.coroutines.test"}))
    public static final void a(@d a aVar, @d l<? super a, t1> lVar) {
        lVar.invoke(aVar);
        List<Throwable> G = aVar.G();
        boolean z = true;
        if (!(G instanceof Collection) || !G.isEmpty()) {
            Iterator<T> it = G.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!(((Throwable) it.next()) instanceof CancellationException)) {
                    z = false;
                    break;
                }
            }
        }
        if (z) {
            return;
        }
        throw new AssertionError("Coroutine encountered unhandled exceptions:\n" + aVar.G());
    }

    public static /* synthetic */ void b(a aVar, l lVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            aVar = new a(null, 1, null);
        }
        a(aVar, lVar);
    }
}
