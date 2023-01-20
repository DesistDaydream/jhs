package e.j.a.b.c.r;

import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.k;
import e.j.a.b.c.r.z;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class t0 implements k.a {
    private final /* synthetic */ e.j.a.b.c.n.k a;
    private final /* synthetic */ e.j.a.b.j.l b;

    /* renamed from: c */
    private final /* synthetic */ z.a f10440c;

    /* renamed from: d */
    private final /* synthetic */ z.b f10441d;

    public t0(e.j.a.b.c.n.k kVar, e.j.a.b.j.l lVar, z.a aVar, z.b bVar) {
        this.a = kVar;
        this.b = lVar;
        this.f10440c = aVar;
        this.f10441d = bVar;
    }

    @Override // e.j.a.b.c.n.k.a
    public final void a(Status status) {
        if (status.isSuccess()) {
            this.b.setResult(this.f10440c.a(this.a.d(0L, TimeUnit.MILLISECONDS)));
            return;
        }
        this.b.b(this.f10441d.a(status));
    }
}
