package h;

import com.qiniu.android.collect.ReportItem;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2 = {"synchronized", "R", "lock", "", ReportItem.LogTypeBlock, "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/StandardKt")
/* loaded from: classes3.dex */
public class v0 extends u0 {
    @h.g2.f
    private static final <R> R l(Object obj, h.k2.u.a<? extends R> aVar) {
        R invoke;
        synchronized (obj) {
            try {
                invoke = aVar.invoke();
                h.k2.v.c0.d(1);
            } catch (Throwable th) {
                h.k2.v.c0.d(1);
                h.k2.v.c0.c(1);
                throw th;
            }
        }
        h.k2.v.c0.c(1);
        return invoke;
    }
}
