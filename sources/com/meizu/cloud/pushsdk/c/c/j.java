package com.meizu.cloud.pushsdk.c.c;

import java.io.File;
import java.nio.charset.Charset;
import java.util.Objects;

/* loaded from: classes2.dex */
public abstract class j {
    public static j a(final g gVar, final File file) {
        Objects.requireNonNull(file, "content == null");
        return new j() { // from class: com.meizu.cloud.pushsdk.c.c.j.2
            @Override // com.meizu.cloud.pushsdk.c.c.j
            public g a() {
                return g.this;
            }

            @Override // com.meizu.cloud.pushsdk.c.c.j
            public void a(com.meizu.cloud.pushsdk.c.g.c cVar) {
                com.meizu.cloud.pushsdk.c.g.m mVar = null;
                try {
                    mVar = com.meizu.cloud.pushsdk.c.g.g.a(file);
                    cVar.a(mVar);
                } finally {
                    m.a(mVar);
                }
            }

            @Override // com.meizu.cloud.pushsdk.c.c.j
            public long b() {
                return file.length();
            }
        };
    }

    public static j a(g gVar, String str) {
        Charset charset = m.f4784c;
        if (gVar != null) {
            Charset b = gVar.b();
            if (b == null) {
                gVar = g.a(gVar + "; charset=utf-8");
            } else {
                charset = b;
            }
        }
        return a(gVar, str.getBytes(charset));
    }

    public static j a(g gVar, byte[] bArr) {
        return a(gVar, bArr, 0, bArr.length);
    }

    public static j a(final g gVar, final byte[] bArr, final int i2, final int i3) {
        Objects.requireNonNull(bArr, "content == null");
        m.a(bArr.length, i2, i3);
        return new j() { // from class: com.meizu.cloud.pushsdk.c.c.j.1
            @Override // com.meizu.cloud.pushsdk.c.c.j
            public g a() {
                return g.this;
            }

            @Override // com.meizu.cloud.pushsdk.c.c.j
            public void a(com.meizu.cloud.pushsdk.c.g.c cVar) {
                cVar.c(bArr, i2, i3);
            }

            @Override // com.meizu.cloud.pushsdk.c.c.j
            public long b() {
                return i3;
            }
        };
    }

    public abstract g a();

    public abstract void a(com.meizu.cloud.pushsdk.c.g.c cVar);

    public long b() {
        return -1L;
    }
}
