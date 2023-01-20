package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import i.b.k0;
import i.b.n1;
import i.b.r0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\u0012\u0006\u0010\u0011\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Li/b/t3/c;", ExifInterface.LONGITUDE_EAST, "Li/b/t3/m;", "Li/b/t3/e;", "", "cause", "Lh/t1;", "S0", "(Ljava/lang/Throwable;)V", "exception", "", "A0", "(Ljava/lang/Throwable;)Z", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Li/b/t3/l;", "channel", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Li/b/t3/l;Z)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class c<E> extends m<E> implements e<E> {
    public c(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d l<E> lVar, boolean z) {
        super(coroutineContext, lVar, z);
    }

    @Override // kotlinx.coroutines.JobSupport
    public boolean A0(@k.e.a.d Throwable th) {
        k0.b(getContext(), th);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.JobSupport
    public void S0(@k.e.a.e Throwable th) {
        l<E> t1 = t1();
        if (th != null) {
            r1 = th instanceof CancellationException ? th : null;
            if (r1 == null) {
                r1 = n1.a(r0.a(this) + " was cancelled", th);
            }
        }
        t1.b(r1);
    }
}
