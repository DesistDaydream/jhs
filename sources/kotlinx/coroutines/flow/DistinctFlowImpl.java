package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import com.umeng.analytics.pro.am;
import h.e2.c;
import h.e2.j.b;
import h.k2.d;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import i.b.v3.c0.n;
import i.b.v3.f;
import i.b.x1;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002Bg\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0014\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0015\u0012:\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\b¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007RJ\u0010\u0011\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u0018\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00158\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/flow/DistinctFlowImpl;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "Lh/k0;", "name", "old", "new", "", "c", "Lh/k2/u/p;", "areEquivalent", am.av, "Lkotlinx/coroutines/flow/Flow;", "upstream", "Lkotlin/Function1;", "b", "Lh/k2/u/l;", "keySelector", "<init>", "(Lkotlinx/coroutines/flow/Flow;Lh/k2/u/l;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class DistinctFlowImpl<T> implements Flow<T> {
    private final Flow<T> a;
    @d
    @k.e.a.d
    public final l<T, Object> b;
    @d
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public final p<Object, Object, Boolean> f16948c;

    /* JADX WARN: Multi-variable type inference failed */
    public DistinctFlowImpl(@k.e.a.d Flow<? extends T> flow, @k.e.a.d l<? super T, ? extends Object> lVar, @k.e.a.d p<Object, Object, Boolean> pVar) {
        this.a = flow;
        this.b = lVar;
        this.f16948c = pVar;
    }

    @Override // kotlinx.coroutines.flow.Flow
    @x1
    @k.e.a.e
    public Object e(@k.e.a.d f<? super T> fVar, @k.e.a.d c<? super t1> cVar) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (T) n.a;
        Object e2 = this.a.e(new DistinctFlowImpl$collect$$inlined$collect$1(this, objectRef, fVar), cVar);
        return e2 == b.h() ? e2 : t1.a;
    }
}
