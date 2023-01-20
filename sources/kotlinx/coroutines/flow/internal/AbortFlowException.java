package kotlinx.coroutines.flow.internal;

import com.tencent.qcloud.tuicore.TUIConstants;
import i.b.q0;
import i.b.v3.f;
import java.util.concurrent.CancellationException;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001d\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "fillInStackTrace", "()Ljava/lang/Throwable;", "Li/b/v3/f;", TUIConstants.TUIChat.OWNER, "Li/b/v3/f;", "getOwner", "()Li/b/v3/f;", "<init>", "(Li/b/v3/f;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class AbortFlowException extends CancellationException {
    @d
    private final f<?> owner;

    public AbortFlowException(@d f<?> fVar) {
        super("Flow was aborted, no more elements needed");
        this.owner = fVar;
    }

    @Override // java.lang.Throwable
    @d
    public Throwable fillInStackTrace() {
        if (q0.d()) {
            return super.fillInStackTrace();
        }
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @d
    public final f<?> getOwner() {
        return this.owner;
    }
}
