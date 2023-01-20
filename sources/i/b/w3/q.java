package i.b.w3;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import h.t1;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u000fJ4\u0010\u0007\u001a\u00020\u0005\"\u000e\b\u0000\u0010\u0003\u0018\u0001*\u00060\u0001j\u0002`\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\u0086\b¢\u0006\u0004\b\u0007\u0010\bJ\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0011\u001a\u00020\t8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000bR\u0016\u0010\u0013\u001a\u00020\t8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000b¨\u0006\u0015"}, d2 = {"Li/b/w3/q;", "Li/b/w3/s;", "Lkotlinx/coroutines/internal/Node;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lh/t1;", ReportItem.LogTypeBlock, "j0", "(Lh/k2/u/l;)V", "", "c0", "()Z", "b0", "()Li/b/w3/s;", "l0", "()V", "k0", "isEmpty", "Z", "isRemoved", "<init>", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class q extends s {
    @Override // i.b.w3.s
    public boolean Z() {
        return false;
    }

    @Override // i.b.w3.s
    @k.e.a.e
    public s b0() {
        return null;
    }

    @Override // i.b.w3.s
    public final boolean c0() {
        throw new IllegalStateException("head cannot be removed".toString());
    }

    public final /* synthetic */ <T extends s> void j0(@k.e.a.d h.k2.u.l<? super T, t1> lVar) {
        Object U = U();
        Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        for (s sVar = (s) U; !h.k2.v.f0.g(sVar, this); sVar = sVar.V()) {
            h.k2.v.f0.y(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (sVar instanceof s) {
                lVar.invoke(sVar);
            }
        }
    }

    public final boolean k0() {
        return U() == this;
    }

    public final void l0() {
        Object U = U();
        Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        s sVar = (s) U;
        s sVar2 = this;
        while (!h.k2.v.f0.g(sVar, this)) {
            s V = sVar.V();
            sVar.i0(sVar2, V);
            sVar2 = sVar;
            sVar = V;
        }
        Object U2 = U();
        Objects.requireNonNull(U2, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        i0(sVar2, (s) U2);
    }
}
