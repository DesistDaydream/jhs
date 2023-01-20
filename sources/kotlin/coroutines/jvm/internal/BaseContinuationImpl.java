package kotlin.coroutines.jvm.internal;

import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.f;
import h.r0;
import h.s0;
import h.t1;
import java.io.Serializable;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b!\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0004B\u0017\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\u0002\u0010\u0006J$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013H$ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\b\u0010\u0015\u001a\u00020\rH\u0014J\u001e\u0010\u0016\u001a\u00020\r2\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0013ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Ljava/io/Serializable;", "completion", "(Lkotlin/coroutines/Continuation;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getCompletion", "()Lkotlin/coroutines/Continuation;", "create", "", "value", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "resumeWith", "(Ljava/lang/Object;)V", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
@s0(version = "1.3")
/* loaded from: classes3.dex */
public abstract class BaseContinuationImpl implements c<Object>, h.e2.k.a.c, Serializable {
    @e
    private final c<Object> completion;

    public BaseContinuationImpl(@e c<Object> cVar) {
        this.completion = cVar;
    }

    @d
    public c<t1> create(@d c<?> cVar) {
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // h.e2.k.a.c
    @e
    public h.e2.k.a.c getCallerFrame() {
        c<Object> cVar = this.completion;
        if (!(cVar instanceof h.e2.k.a.c)) {
            cVar = null;
        }
        return (h.e2.k.a.c) cVar;
    }

    @e
    public final c<Object> getCompletion() {
        return this.completion;
    }

    @Override // h.e2.k.a.c
    @e
    public StackTraceElement getStackTraceElement() {
        return h.e2.k.a.e.e(this);
    }

    @e
    public abstract Object invokeSuspend(@d Object obj);

    public void releaseIntercepted() {
    }

    @Override // h.e2.c
    public final void resumeWith(@d Object obj) {
        Object invokeSuspend;
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            f.b(baseContinuationImpl);
            c<Object> cVar = baseContinuationImpl.completion;
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
            } catch (Throwable th) {
                Result.a aVar = Result.Companion;
                obj = Result.m106constructorimpl(r0.a(th));
            }
            if (invokeSuspend == b.h()) {
                return;
            }
            Result.a aVar2 = Result.Companion;
            obj = Result.m106constructorimpl(invokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (cVar instanceof BaseContinuationImpl) {
                baseContinuationImpl = (BaseContinuationImpl) cVar;
            } else {
                cVar.resumeWith(obj);
                return;
            }
        }
    }

    @d
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    @d
    public c<t1> create(@e Object obj, @d c<?> cVar) {
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
