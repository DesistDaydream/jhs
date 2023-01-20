package e.j.a.b.c.n.u;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* loaded from: classes2.dex */
public final class c1 extends e.j.a.b.f.a.o {
    private final /* synthetic */ w0 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c1(w0 w0Var, Looper looper) {
        super(looper);
        this.b = w0Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            this.b.P();
        } else if (i2 == 2) {
            this.b.J();
        } else {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GoogleApiClientImpl", sb.toString());
        }
    }
}
