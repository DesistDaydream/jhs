package androidx.core.os;

import h.k2.u.a;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class HandlerKt$postAtTime$runnable$1 implements Runnable {
    public final /* synthetic */ a<t1> $action;

    public HandlerKt$postAtTime$runnable$1(a<t1> aVar) {
        this.$action = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
