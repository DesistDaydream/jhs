package i.b.w3;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u000e\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0010R\u001e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0013¨\u0006\u0017"}, d2 = {"Li/b/w3/s0;", "", "value", "Lh/t1;", am.av, "(Ljava/lang/Object;)V", "c", "()Ljava/lang/Object;", "b", "()V", "Lkotlin/coroutines/CoroutineContext;", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "", ExpandableTextView.P, "i", "", "[Ljava/lang/Object;", "n", "<init>", "(Lkotlin/coroutines/CoroutineContext;I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class s0 {
    private Object[] a;
    private int b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final CoroutineContext f15901c;

    public s0(@k.e.a.d CoroutineContext coroutineContext, int i2) {
        this.f15901c = coroutineContext;
        this.a = new Object[i2];
    }

    public final void a(@k.e.a.e Object obj) {
        Object[] objArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        objArr[i2] = obj;
    }

    public final void b() {
        this.b = 0;
    }

    @k.e.a.e
    public final Object c() {
        Object[] objArr = this.a;
        int i2 = this.b;
        this.b = i2 + 1;
        return objArr[i2];
    }

    @k.e.a.d
    public final CoroutineContext getContext() {
        return this.f15901c;
    }
}
