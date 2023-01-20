package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do;

import java.io.File;

/* loaded from: classes.dex */
public class d implements Runnable {
    private final c a;
    private volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f1152c = new a();

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.b = false;
        }
    }

    public d(c cVar) {
        this.a = cVar;
        a();
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.g.a(2L);
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.f.e().a(4500L, this.f1152c);
        bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.f.e().a(5000L, this, 40, 5000L);
    }

    private long a() {
        File file = new File("/data/anr/traces.txt");
        if (file.exists()) {
            return file.lastModified();
        }
        return 0L;
    }

    private boolean b() {
        File file = new File("/data/anr/traces.txt");
        return file.exists() && file.canRead();
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int i2;
        if (this.b) {
            return;
        }
        if (b()) {
            i2 = 200;
            str = "/data/anr/traces.txt";
        } else {
            str = null;
            i2 = 100;
        }
        if (this.a.a(i2, str, 25)) {
            this.b = true;
        }
    }
}
