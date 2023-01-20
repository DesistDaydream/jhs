package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import h.t1;
import i.b.k0;
import i.b.t3.c0;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u001d\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\n8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Li/b/t3/v;", ExifInterface.LONGITUDE_EAST, "Li/b/t3/m;", "Li/b/t3/w;", "Lh/t1;", "value", "y1", "(Lh/t1;)V", "", "cause", "", "handled", "o1", "(Ljava/lang/Throwable;Z)V", "j", "()Z", "isActive", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Li/b/t3/l;", "channel", "<init>", "(Lkotlin/coroutines/CoroutineContext;Li/b/t3/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class v<E> extends m<E> implements w<E> {
    public v(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d l<E> lVar) {
        super(coroutineContext, lVar, true);
    }

    @Override // i.b.t3.m, i.b.t3.w
    public /* bridge */ /* synthetic */ c0 getChannel() {
        return getChannel();
    }

    @Override // i.b.a, kotlinx.coroutines.JobSupport, i.b.b2
    public boolean j() {
        return super.j();
    }

    @Override // i.b.a
    public void o1(@k.e.a.d Throwable th, boolean z) {
        if (t1().K(th) || z) {
            return;
        }
        k0.b(getContext(), th);
    }

    @Override // i.b.a
    /* renamed from: y1 */
    public void p1(@k.e.a.d t1 t1Var) {
        c0.a.a(t1(), null, 1, null);
    }
}
