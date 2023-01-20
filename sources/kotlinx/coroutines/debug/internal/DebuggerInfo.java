package kotlinx.coroutines.debug.internal;

import com.tencent.android.tpush.common.MessageKey;
import h.p0;
import i.b.l0;
import i.b.m0;
import java.io.Serializable;
import java.lang.Thread;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@p0
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#R\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0012\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006R\u001b\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006¨\u0006$"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "Ljava/io/Serializable;", "", "lastObservedThreadName", "Ljava/lang/String;", "getLastObservedThreadName", "()Ljava/lang/String;", "name", "getName", "state", "getState", "", "Ljava/lang/StackTraceElement;", "lastObservedStackTrace", "Ljava/util/List;", "getLastObservedStackTrace", "()Ljava/util/List;", "", "sequenceNumber", "J", "getSequenceNumber", "()J", "dispatcher", "getDispatcher", "coroutineId", "Ljava/lang/Long;", "getCoroutineId", "()Ljava/lang/Long;", "lastObservedThreadState", "getLastObservedThreadState", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", MessageKey.MSG_SOURCE, "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DebuggerInfo implements Serializable {
    @e
    private final Long coroutineId;
    @e
    private final String dispatcher;
    @d
    private final List<StackTraceElement> lastObservedStackTrace;
    @e
    private final String lastObservedThreadName;
    @e
    private final String lastObservedThreadState;
    @e
    private final String name;
    private final long sequenceNumber;
    @d
    private final String state;

    public DebuggerInfo(@d DebugCoroutineInfoImpl debugCoroutineInfoImpl, @d CoroutineContext coroutineContext) {
        Thread.State state;
        l0 l0Var = (l0) coroutineContext.get(l0.b);
        this.coroutineId = l0Var != null ? Long.valueOf(l0Var.C0()) : null;
        h.e2.d dVar = (h.e2.d) coroutineContext.get(h.e2.d.v0);
        this.dispatcher = dVar != null ? dVar.toString() : null;
        m0 m0Var = (m0) coroutineContext.get(m0.b);
        this.name = m0Var != null ? m0Var.C0() : null;
        this.state = debugCoroutineInfoImpl.e();
        Thread thread = debugCoroutineInfoImpl.f16932c;
        this.lastObservedThreadState = (thread == null || (state = thread.getState()) == null) ? null : state.toString();
        Thread thread2 = debugCoroutineInfoImpl.f16932c;
        this.lastObservedThreadName = thread2 != null ? thread2.getName() : null;
        this.lastObservedStackTrace = debugCoroutineInfoImpl.f();
        this.sequenceNumber = debugCoroutineInfoImpl.f16935f;
    }

    @e
    public final Long getCoroutineId() {
        return this.coroutineId;
    }

    @e
    public final String getDispatcher() {
        return this.dispatcher;
    }

    @d
    public final List<StackTraceElement> getLastObservedStackTrace() {
        return this.lastObservedStackTrace;
    }

    @e
    public final String getLastObservedThreadName() {
        return this.lastObservedThreadName;
    }

    @e
    public final String getLastObservedThreadState() {
        return this.lastObservedThreadState;
    }

    @e
    public final String getName() {
        return this.name;
    }

    public final long getSequenceNumber() {
        return this.sequenceNumber;
    }

    @d
    public final String getState() {
        return this.state;
    }
}
