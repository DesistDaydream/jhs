package e.t.j.i.d;

import h.k2.u.p;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002JK\u0010\f\u001a\u00020\n2<\u0010\u0003\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0004j\u0002`\u000bH\u0000¢\u0006\u0002\b\rJ!\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\u000fRH\u0010\u0003\u001a<\u0012\u0015\u0012\u0013\u0018\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/vector/databinding/trigger/list/ListRefreshTrigger;", "", "()V", "action", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "smoothScroll", "toTop", "", "Lcom/vector/databinding/trigger/list/RefreshAction;", "observe", "observe$vector_release", "trigger", "(Ljava/lang/Boolean;Z)V", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    @k.e.a.e
    private p<? super Boolean, ? super Boolean, t1> a;

    public static /* synthetic */ void c(a aVar, Boolean bool, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            bool = null;
        }
        if ((i2 & 2) != 0) {
            z = true;
        }
        aVar.b(bool, z);
    }

    public final void a(@k.e.a.d p<? super Boolean, ? super Boolean, t1> pVar) {
        this.a = pVar;
    }

    public final void b(@k.e.a.e Boolean bool, boolean z) {
        p<? super Boolean, ? super Boolean, t1> pVar = this.a;
        if (pVar == null) {
            return;
        }
        pVar.invoke(bool, Boolean.valueOf(z));
    }
}
