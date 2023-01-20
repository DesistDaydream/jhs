package e.t.j.i.d;

import h.k2.u.l;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J6\u0010\u000b\u001a\u00020\t2'\u0010\u0003\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\nH\u0000¢\u0006\u0002\b\fJ\u0017\u0010\r\u001a\u00020\t2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000eR3\u0010\u0003\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/vector/databinding/trigger/list/ListToTopTrigger;", "", "()V", "action", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "smoothScroll", "", "Lcom/vector/databinding/trigger/list/ToTopAction;", "observe", "observe$vector_release", "trigger", "(Ljava/lang/Boolean;)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class g {
    @k.e.a.e
    private l<? super Boolean, t1> a;

    public static /* synthetic */ void c(g gVar, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = null;
        }
        gVar.b(bool);
    }

    public final void a(@k.e.a.d l<? super Boolean, t1> lVar) {
        this.a = lVar;
    }

    public final void b(@k.e.a.e Boolean bool) {
        l<? super Boolean, t1> lVar = this.a;
        if (lVar == null) {
            return;
        }
        lVar.invoke(bool);
    }
}
