package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public class g {
    private static final AtomicReference<Long> a = new AtomicReference<>(0L);

    public static void a(long j2) {
        for (int i2 = 0; i2 < 5; i2++) {
            AtomicReference<Long> atomicReference = a;
            long longValue = atomicReference.get().longValue();
            if (atomicReference.compareAndSet(Long.valueOf(longValue), Long.valueOf(longValue | j2))) {
                return;
            }
        }
    }
}
