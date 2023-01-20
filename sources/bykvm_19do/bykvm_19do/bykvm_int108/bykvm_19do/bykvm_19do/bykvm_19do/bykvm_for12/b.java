package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class b {
    public static void a(AtomicLong atomicLong, int i2) {
        g b = j.l().b();
        if (b == null || !b.e() || atomicLong == null) {
            return;
        }
        atomicLong.getAndAdd(i2);
    }
}
