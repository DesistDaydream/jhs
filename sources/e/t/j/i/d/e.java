package e.t.j.i.d;

import h.k2.u.p;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002JK\u0010\r\u001a\u00020\u000b2<\u0010\u0003\u001a8\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0004j\u0002`\fH\u0000¢\u0006\u0002\b\u000eJ\u001f\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010RH\u0010\u0003\u001a<\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0004j\u0004\u0018\u0001`\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/vector/databinding/trigger/list/ListScrollToPositionTrigger;", "", "()V", "action", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "", "smoothScroll", "", "Lcom/vector/databinding/trigger/list/ScrollToPositionAction;", "observe", "observe$vector_release", "trigger", "(ILjava/lang/Boolean;)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    @k.e.a.e
    private p<? super Integer, ? super Boolean, t1> a;

    public static /* synthetic */ void c(e eVar, int i2, Boolean bool, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bool = null;
        }
        eVar.b(i2, bool);
    }

    public final void a(@k.e.a.d p<? super Integer, ? super Boolean, t1> pVar) {
        this.a = pVar;
    }

    public final void b(int i2, @k.e.a.e Boolean bool) {
        p<? super Integer, ? super Boolean, t1> pVar = this.a;
        if (pVar == null) {
            return;
        }
        pVar.invoke(Integer.valueOf(i2), bool);
    }
}
