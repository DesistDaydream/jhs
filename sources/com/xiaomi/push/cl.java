package com.xiaomi.push;

import com.xiaomi.push.cj;
import com.xiaomi.push.p;

/* loaded from: classes3.dex */
public class cl extends p.b {
    public p.b a;
    public final /* synthetic */ cj b;

    public cl(cj cjVar) {
        this.b = cjVar;
    }

    @Override // com.xiaomi.push.p.b
    public void b() {
        cj.b bVar = (cj.b) this.b.a.peek();
        if (bVar == null || !bVar.d()) {
            return;
        }
        if (this.b.a.remove(bVar)) {
            this.a = bVar;
        }
        p.b bVar2 = this.a;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    @Override // com.xiaomi.push.p.b
    public void c() {
        p.b bVar = this.a;
        if (bVar != null) {
            bVar.c();
        }
    }
}
