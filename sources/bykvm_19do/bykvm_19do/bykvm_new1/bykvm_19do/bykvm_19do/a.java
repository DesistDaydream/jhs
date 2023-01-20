package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do;

import android.os.FileObserver;
import android.os.SystemClock;
import android.text.TextUtils;

/* loaded from: classes.dex */
public class a extends FileObserver {
    private final c a;
    private volatile boolean b;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0052a extends Thread {
        private int a;

        public C0052a(int i2) {
            this.a = i2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            SystemClock.sleep(this.a);
            a.this.b = true;
        }
    }

    public a(c cVar, String str, int i2) {
        super(str, i2);
        this.b = true;
        if (cVar == null || TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("params is not right path is null or ANRManager is null");
        }
        this.a = cVar;
    }

    @Override // android.os.FileObserver
    public void onEvent(int i2, String str) {
        c cVar;
        if (this.b && i2 == 8 && !TextUtils.isEmpty(str) && str.contains("trace") && (cVar = this.a) != null) {
            this.b = false;
            cVar.a(200, "/data/anr/" + str, 80);
            new C0052a(5000).start();
        }
    }
}
