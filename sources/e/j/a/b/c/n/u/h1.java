package e.j.a.b.c.n.u;

import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* loaded from: classes2.dex */
public final class h1 extends e.j.a.b.f.a.o {
    private final /* synthetic */ f1 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h1(f1 f1Var, Looper looper) {
        super(looper);
        this.b = f1Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            ((g1) message.obj).b(this.b);
        } else if (i2 != 2) {
            StringBuilder sb = new StringBuilder(31);
            sb.append("Unknown message id: ");
            sb.append(i2);
            Log.w("GACStateManager", sb.toString());
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
