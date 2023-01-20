package e.q.a.g;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\tJ\r\u0010\n\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/permissionx/guolindev/request/RequestChain;", "", "()V", "headTask", "Lcom/permissionx/guolindev/request/BaseTask;", "tailTask", "addTaskToChain", "", "task", "addTaskToChain$permissionx_release", "runTask", "runTask$permissionx_release", "permissionx_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class t {
    @k.e.a.e
    private m a;
    @k.e.a.e
    private m b;

    public final void a(@k.e.a.d m mVar) {
        if (this.a == null) {
            this.a = mVar;
        }
        m mVar2 = this.b;
        if (mVar2 != null) {
            mVar2.b = mVar;
        }
        this.b = mVar;
    }

    public final void b() {
        m mVar = this.a;
        if (mVar == null) {
            return;
        }
        mVar.request();
    }
}
