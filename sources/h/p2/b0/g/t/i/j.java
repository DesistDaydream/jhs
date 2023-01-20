package h.p2.b0.g.t.i;

import java.io.IOException;

/* loaded from: classes3.dex */
public class j {
    private d a;
    private f b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f15444c;

    /* renamed from: d  reason: collision with root package name */
    public volatile n f15445d;

    public void a(n nVar) {
        if (this.f15445d != null) {
            return;
        }
        synchronized (this) {
            if (this.f15445d != null) {
                return;
            }
            try {
                if (this.a != null) {
                    this.f15445d = nVar.getParserForType().b(this.a, this.b);
                } else {
                    this.f15445d = nVar;
                }
            } catch (IOException unused) {
            }
        }
    }

    public int b() {
        if (this.f15444c) {
            return this.f15445d.getSerializedSize();
        }
        return this.a.size();
    }

    public n c(n nVar) {
        a(nVar);
        return this.f15445d;
    }

    public n d(n nVar) {
        n nVar2 = this.f15445d;
        this.f15445d = nVar;
        this.a = null;
        this.f15444c = true;
        return nVar2;
    }
}
