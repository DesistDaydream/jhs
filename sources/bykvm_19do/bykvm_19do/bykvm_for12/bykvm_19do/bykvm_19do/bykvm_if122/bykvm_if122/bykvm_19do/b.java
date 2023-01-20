package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do;

import com.bytedance.msdk.adapter.util.ThreadHelper;

/* loaded from: classes.dex */
public abstract class b implements Runnable {
    public final String a;

    public b(String str, Object... objArr) {
        this.a = c.a(str, objArr);
    }

    public abstract void b();

    @Override // java.lang.Runnable
    public final void run() {
        String name = Thread.currentThread().getName();
        Thread currentThread = Thread.currentThread();
        currentThread.setName(ThreadHelper.THREDA_NAME_PREFIX + this.a);
        try {
            b();
        } finally {
            Thread.currentThread().setName(name);
        }
    }
}
