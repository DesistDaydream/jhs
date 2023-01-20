package e.t.j.i.d;

import h.k2.u.q;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J`\u0010\u000e\u001a\u00020\f2Q\u0010\u0003\u001aM\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0004j\u0002`\rH\u0000¢\u0006\u0002\b\u000fJ+\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011R]\u0010\u0003\u001aQ\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\u0004j\u0004\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/vector/databinding/trigger/list/ListScrollByTrigger;", "", "()V", "action", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "x", "y", "", "smoothScroll", "", "Lcom/vector/databinding/trigger/list/ScrollByAction;", "observe", "observe$vector_release", "trigger", "(IILjava/lang/Boolean;)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c {
    @k.e.a.e
    private q<? super Integer, ? super Integer, ? super Boolean, t1> a;

    public static /* synthetic */ void c(c cVar, int i2, int i3, Boolean bool, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = 0;
        }
        if ((i4 & 4) != 0) {
            bool = null;
        }
        cVar.b(i2, i3, bool);
    }

    public final void a(@k.e.a.d q<? super Integer, ? super Integer, ? super Boolean, t1> qVar) {
        this.a = qVar;
    }

    public final void b(int i2, int i3, @k.e.a.e Boolean bool) {
        q<? super Integer, ? super Integer, ? super Boolean, t1> qVar = this.a;
        if (qVar == null) {
            return;
        }
        qVar.invoke(Integer.valueOf(i2), Integer.valueOf(i3), bool);
    }
}
