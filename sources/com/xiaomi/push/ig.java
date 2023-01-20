package com.xiaomi.push;

import com.xiaomi.push.ik;

/* loaded from: classes3.dex */
public class ig {
    private final io a;
    private final ix b;

    public ig() {
        this(new ik.a());
    }

    public ig(iq iqVar) {
        ix ixVar = new ix();
        this.b = ixVar;
        this.a = iqVar.a(ixVar);
    }

    public void a(ic icVar, byte[] bArr) {
        try {
            this.b.a(bArr);
            icVar.a(this.a);
        } finally {
            this.a.x();
        }
    }
}
