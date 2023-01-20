package e.j.a.b.c.n.u;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public final class b1 implements e.j.a.b.c.n.q<Status> {
    private final /* synthetic */ v a;
    private final /* synthetic */ boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ e.j.a.b.c.n.i f10198c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ w0 f10199d;

    public b1(w0 w0Var, v vVar, boolean z, e.j.a.b.c.n.i iVar) {
        this.f10199d = w0Var;
        this.a = vVar;
        this.b = z;
        this.f10198c = iVar;
    }

    @Override // e.j.a.b.c.n.q
    public final /* synthetic */ void a(@NonNull Status status) {
        Context context;
        Status status2 = status;
        context = this.f10199d.f10336j;
        e.j.a.b.b.a.a.b.b.b(context).l();
        if (status2.isSuccess() && this.f10199d.t()) {
            this.f10199d.z();
        }
        this.a.setResult(status2);
        if (this.b) {
            this.f10198c.i();
        }
    }
}
