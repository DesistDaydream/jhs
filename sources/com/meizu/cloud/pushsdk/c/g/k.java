package com.meizu.cloud.pushsdk.c.g;

import com.caverock.androidsvg.SVG;

/* loaded from: classes2.dex */
public final class k {
    private static j a;
    private static long b;

    private k() {
    }

    public static j a() {
        synchronized (k.class) {
            j jVar = a;
            if (jVar != null) {
                a = jVar.f4798f;
                jVar.f4798f = null;
                b -= 2048;
                return jVar;
            }
            return new j();
        }
    }

    public static void a(j jVar) {
        if (jVar.f4798f != null || jVar.f4799g != null) {
            throw new IllegalArgumentException();
        }
        if (jVar.f4796d) {
            return;
        }
        synchronized (k.class) {
            long j2 = b;
            if (j2 + 2048 > SVG.D) {
                return;
            }
            b = j2 + 2048;
            jVar.f4798f = a;
            jVar.f4795c = 0;
            jVar.b = 0;
            a = jVar;
        }
    }
}
