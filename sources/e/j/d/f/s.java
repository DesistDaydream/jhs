package e.j.d.f;

import android.os.Looper;
import android.os.Message;

/* loaded from: classes2.dex */
public final class s extends e.j.a.b.f.c.e {
    private final /* synthetic */ p b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(p pVar, Looper looper) {
        super(looper);
        this.b = pVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        this.b.d(message);
    }
}
