package com.meizu.cloud.pushsdk.c.e;

import com.meizu.cloud.pushsdk.c.c.g;
import com.meizu.cloud.pushsdk.c.c.j;
import com.meizu.cloud.pushsdk.c.g.f;
import com.meizu.cloud.pushsdk.c.g.l;

/* loaded from: classes2.dex */
public class b extends j {
    private final j a;
    private com.meizu.cloud.pushsdk.c.g.c b;

    /* renamed from: c  reason: collision with root package name */
    private d f4787c;

    public b(j jVar, com.meizu.cloud.pushsdk.c.d.a aVar) {
        this.a = jVar;
        if (aVar != null) {
            this.f4787c = new d(aVar);
        }
    }

    private l a(l lVar) {
        return new f(lVar) { // from class: com.meizu.cloud.pushsdk.c.e.b.1
            public long a = 0;
            public long b = 0;

            @Override // com.meizu.cloud.pushsdk.c.g.f, com.meizu.cloud.pushsdk.c.g.l
            public void a(com.meizu.cloud.pushsdk.c.g.b bVar, long j2) {
                super.a(bVar, j2);
                if (this.b == 0) {
                    this.b = b.this.b();
                }
                this.a += j2;
                if (b.this.f4787c != null) {
                    b.this.f4787c.obtainMessage(1, new com.meizu.cloud.pushsdk.c.f.a(this.a, this.b)).sendToTarget();
                }
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public g a() {
        return this.a.a();
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public void a(com.meizu.cloud.pushsdk.c.g.c cVar) {
        if (this.b == null) {
            this.b = com.meizu.cloud.pushsdk.c.g.g.a(a((l) cVar));
        }
        this.a.a(this.b);
        this.b.flush();
    }

    @Override // com.meizu.cloud.pushsdk.c.c.j
    public long b() {
        return this.a.b();
    }
}
