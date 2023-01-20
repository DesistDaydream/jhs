package e.b.a.p.k;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: classes.dex */
public class v {
    private boolean a;
    private final Handler b = new Handler(Looper.getMainLooper(), new a());

    /* loaded from: classes.dex */
    public static final class a implements Handler.Callback {
        public static final int a = 1;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((s) message.obj).recycle();
                return true;
            }
            return false;
        }
    }

    public synchronized void a(s<?> sVar, boolean z) {
        if (!this.a && !z) {
            this.a = true;
            sVar.recycle();
            this.a = false;
        }
        this.b.obtainMessage(1, sVar).sendToTarget();
    }
}
