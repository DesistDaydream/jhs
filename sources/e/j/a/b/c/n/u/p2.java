package e.j.a.b.c.n.u;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public final class p2 extends e.j.a.b.f.a.o {
    private final /* synthetic */ n2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(n2 n2Var, Looper looper) {
        super(looper);
        this.b = n2Var;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        Object obj;
        n2 n2Var;
        n2 n2Var2;
        n2 n2Var3;
        int i2 = message.what;
        if (i2 != 0) {
            if (i2 != 1) {
                StringBuilder sb = new StringBuilder(70);
                sb.append("TransformationResultHandler received unknown message type: ");
                sb.append(i2);
                Log.e("TransformedResultImpl", sb.toString());
                return;
            }
            RuntimeException runtimeException = (RuntimeException) message.obj;
            String valueOf = String.valueOf(runtimeException.getMessage());
            Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
            throw runtimeException;
        }
        e.j.a.b.c.n.k<?> kVar = (e.j.a.b.c.n.k) message.obj;
        obj = this.b.f10290e;
        synchronized (obj) {
            if (kVar == null) {
                n2Var3 = this.b.b;
                n2Var3.m(new Status(13, "Transform returned null"));
            } else if (kVar instanceof e2) {
                n2Var2 = this.b.b;
                n2Var2.m(((e2) kVar).k());
            } else {
                n2Var = this.b.b;
                n2Var.d(kVar);
            }
        }
    }
}
