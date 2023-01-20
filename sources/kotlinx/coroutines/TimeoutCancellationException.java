package kotlinx.coroutines;

import h.k2.d;
import i.b.b2;
import i.b.h0;
import java.util.concurrent.CancellationException;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B\u001b\b\u0000\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fB\u0011\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\rJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0000@\u0001X\u0081\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/TimeoutCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Li/b/h0;", "createCopy", "()Lkotlinx/coroutines/TimeoutCancellationException;", "Li/b/b2;", "coroutine", "Li/b/b2;", "", "message", "<init>", "(Ljava/lang/String;Li/b/b2;)V", "(Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class TimeoutCancellationException extends CancellationException implements h0<TimeoutCancellationException> {
    @d
    @e
    public final b2 coroutine;

    public TimeoutCancellationException(@k.e.a.d String str, @e b2 b2Var) {
        super(str);
        this.coroutine = b2Var;
    }

    public TimeoutCancellationException(@k.e.a.d String str) {
        this(str, null);
    }

    @Override // i.b.h0
    @e
    public TimeoutCancellationException createCopy() {
        String message = getMessage();
        if (message == null) {
            message = "";
        }
        TimeoutCancellationException timeoutCancellationException = new TimeoutCancellationException(message, this.coroutine);
        timeoutCancellationException.initCause(this);
        return timeoutCancellationException;
    }
}
