package k.c.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import org.greenrobot.eventbus.EventBusException;

/* loaded from: classes4.dex */
public class e extends Handler implements k {
    private final j a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final c f16273c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16274d;

    public e(c cVar, Looper looper, int i2) {
        super(looper);
        this.f16273c = cVar;
        this.b = i2;
        this.a = new j();
    }

    @Override // k.c.a.k
    public void a(p pVar, Object obj) {
        i a = i.a(pVar, obj);
        synchronized (this) {
            this.a.a(a);
            if (!this.f16274d) {
                this.f16274d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new EventBusException("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                i b = this.a.b();
                if (b == null) {
                    synchronized (this) {
                        b = this.a.b();
                        if (b == null) {
                            this.f16274d = false;
                            return;
                        }
                    }
                }
                this.f16273c.l(b);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.b);
            if (sendMessage(obtainMessage())) {
                this.f16274d = true;
                return;
            }
            throw new EventBusException("Could not send handler message");
        } finally {
            this.f16274d = false;
        }
    }
}
