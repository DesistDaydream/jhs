package h.s2;

import com.qiniu.android.collect.ReportItem;
import h.k2.g;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;

@g(name = "TimingKt")
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a'\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2 = {"measureNanoTime", "", ReportItem.LogTypeBlock, "Lkotlin/Function0;", "", "measureTimeMillis", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class b {
    public static final long a(@d h.k2.u.a<t1> aVar) {
        long nanoTime = System.nanoTime();
        aVar.invoke();
        return System.nanoTime() - nanoTime;
    }

    public static final long b(@d h.k2.u.a<t1> aVar) {
        long currentTimeMillis = System.currentTimeMillis();
        aVar.invoke();
        return System.currentTimeMillis() - currentTimeMillis;
    }
}
