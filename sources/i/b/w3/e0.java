package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import i.b.b2;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001d\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a¢\u0006\u0004\b \u0010!J\u0015\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014¢\u0006\u0004\b\u000e\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8@@\u0000X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0015\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048F@\u0006¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\u001a8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006\""}, d2 = {"Li/b/w3/e0;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/a;", "Lh/e2/k/a/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "", "state", "Lh/t1;", "U", "(Ljava/lang/Object;)V", "l1", "Li/b/b2;", "t1", "()Li/b/b2;", "parent", "getCallerFrame", "()Lh/e2/k/a/c;", "callerFrame", "", "F0", "()Z", "isScopedCoroutine", "Lh/e2/c;", e.j.a.b.c.f.f10128d, "Lh/e2/c;", "uCont", "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lh/e2/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class e0<T> extends i.b.a<T> implements h.e2.k.a.c {
    @h.k2.d
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public final h.e2.c<T> f15877d;

    /* JADX WARN: Multi-variable type inference failed */
    public e0(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d h.e2.c<? super T> cVar) {
        super(coroutineContext, true);
        this.f15877d = cVar;
    }

    @Override // kotlinx.coroutines.JobSupport
    public final boolean F0() {
        return true;
    }

    @Override // kotlinx.coroutines.JobSupport
    public void U(@k.e.a.e Object obj) {
        k.g(IntrinsicsKt__IntrinsicsJvmKt.d(this.f15877d), i.b.g0.a(obj, this.f15877d), null, 2, null);
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public final h.e2.k.a.c getCallerFrame() {
        return (h.e2.k.a.c) this.f15877d;
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public final StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // i.b.a
    public void l1(@k.e.a.e Object obj) {
        h.e2.c<T> cVar = this.f15877d;
        cVar.resumeWith(i.b.g0.a(obj, cVar));
    }

    @k.e.a.e
    public final b2 t1() {
        return (b2) this.f15713c.get(b2.y0);
    }
}
