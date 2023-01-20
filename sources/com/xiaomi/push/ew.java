package com.xiaomi.push;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public final class ew extends eq {
    public ew() {
        a("PING", (String) null);
        a("0");
        a(0);
    }

    @Override // com.xiaomi.push.eq
    public ByteBuffer a(ByteBuffer byteBuffer) {
        return k().length == 0 ? byteBuffer : super.a(byteBuffer);
    }

    @Override // com.xiaomi.push.eq
    public int l() {
        if (k().length == 0) {
            return 0;
        }
        return super.l();
    }
}
