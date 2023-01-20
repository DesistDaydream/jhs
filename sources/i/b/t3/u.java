package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.w3.i0;
import kotlin.Metadata;
import kotlinx.coroutines.channels.AbstractChannel;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u0017\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\u0001\u0010\tR\u0016\u0010\r\u001a\u00020\n8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u000f\u001a\u00020\n8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\fR\u0016\u0010\u0011\u001a\u00020\n8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\fR\u0016\u0010\u0013\u001a\u00020\n8D@\u0004X\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\f¨\u0006\u001a"}, d2 = {"Li/b/t3/u;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "element", "", "D", "(Ljava/lang/Object;)Ljava/lang/Object;", "Li/b/z3/f;", "select", "(Ljava/lang/Object;Li/b/z3/f;)Ljava/lang/Object;", "", IAdInterListener.AdReqParam.WIDTH, "()Z", "isBufferFull", "a0", "isBufferEmpty", "Z", "isBufferAlwaysEmpty", am.aH, "isBufferAlwaysFull", "Lkotlin/Function1;", "Lh/t1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lh/k2/u/l;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class u<E> extends AbstractChannel<E> {
    public u(@k.e.a.e h.k2.u.l<? super E, t1> lVar) {
        super(lVar);
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public Object D(E e2) {
        z<?> H;
        do {
            Object D = super.D(e2);
            i0 i0Var = a.f15799e;
            if (D == i0Var) {
                return i0Var;
            }
            if (D == a.f15800f) {
                H = H(e2);
                if (H == null) {
                    return i0Var;
                }
            } else if (D instanceof p) {
                return D;
            } else {
                throw new IllegalStateException(("Invalid offerInternal result " + D).toString());
            }
        } while (!(H instanceof p));
        return H;
    }

    @Override // i.b.t3.b
    @k.e.a.d
    public Object E(E e2, @k.e.a.d i.b.z3.f<?> fVar) {
        Object z;
        while (true) {
            if (Y()) {
                z = super.E(e2, fVar);
            } else {
                z = fVar.z(i(e2));
                if (z == null) {
                    z = a.f15799e;
                }
            }
            if (z == i.b.z3.g.d()) {
                return i.b.z3.g.d();
            }
            i0 i0Var = a.f15799e;
            if (z == i0Var) {
                return i0Var;
            }
            if (z != a.f15800f && z != i.b.w3.c.b) {
                if (z instanceof p) {
                    return z;
                }
                throw new IllegalStateException(("Invalid result " + z).toString());
            }
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean Z() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final boolean a0() {
        return true;
    }

    @Override // i.b.t3.b
    public final boolean u() {
        return false;
    }

    @Override // i.b.t3.b
    public final boolean w() {
        return false;
    }
}
