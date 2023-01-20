package i.b;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Li/b/p3;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/w3/e0;", "", "state", "Lh/t1;", "l1", "(Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", "context", "Lh/e2/c;", "uCont", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lh/e2/c;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class p3<T> extends i.b.w3.e0<T> {
    public p3(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d h.e2.c<? super T> cVar) {
        super(coroutineContext, cVar);
    }

    @Override // i.b.w3.e0, i.b.a
    public void l1(@k.e.a.e Object obj) {
        Object a = g0.a(obj, this.f15877d);
        CoroutineContext context = this.f15877d.getContext();
        Object c2 = ThreadContextKt.c(context, null);
        try {
            this.f15877d.resumeWith(a);
            h.t1 t1Var = h.t1.a;
        } finally {
            ThreadContextKt.a(context, c2);
        }
    }
}
