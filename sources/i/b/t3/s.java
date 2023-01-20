package i.b.t3;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.t1;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u0003BO\u0012\u0006\u0010#\u001a\u00020\"\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000$\u0012-\u0010\u0019\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016¢\u0006\u0002\b'ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011JX\u0010\u001a\u001a\u00020\u0005\"\u0004\b\u0001\u0010\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00132\u0006\u0010\u0015\u001a\u00028\u00002(\u0010\u0019\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR(\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00040\u00038V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 \u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Li/b/t3/s;", ExifInterface.LONGITUDE_EAST, "Li/b/t3/c;", "Li/b/z3/e;", "Li/b/t3/c0;", "Lh/t1;", "q1", "()V", "element", "N", "(Ljava/lang/Object;Lh/e2/c;)Ljava/lang/Object;", "", "offer", "(Ljava/lang/Object;)Z", "", "cause", "K", "(Ljava/lang/Throwable;)Z", "R", "Li/b/z3/f;", "select", RemoteMessageConst.MessageBody.PARAM, "Lkotlin/Function2;", "Lh/e2/c;", "", ReportItem.LogTypeBlock, am.aD, "(Li/b/z3/f;Ljava/lang/Object;Lh/k2/u/p;)V", "h", "()Li/b/z3/e;", "onSend", com.huawei.hms.push.e.a, "Lh/e2/c;", "continuation", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Li/b/t3/l;", "channel", "Li/b/t3/e;", "Lh/q;", "<init>", "(Lkotlin/coroutines/CoroutineContext;Li/b/t3/l;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class s<E> extends c<E> implements i.b.z3.e<E, c0<? super E>> {

    /* renamed from: e  reason: collision with root package name */
    private h.e2.c<? super t1> f15844e;

    public s(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d l<E> lVar, @k.e.a.d h.k2.u.p<? super e<E>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        super(coroutineContext, lVar, false);
        this.f15844e = IntrinsicsKt__IntrinsicsJvmKt.c(pVar, this, this);
    }

    @Override // i.b.t3.m, i.b.t3.c0
    public boolean K(@k.e.a.e Throwable th) {
        boolean K = super.K(th);
        start();
        return K;
    }

    @Override // i.b.t3.m, i.b.t3.c0
    @k.e.a.e
    public Object N(E e2, @k.e.a.d h.e2.c<? super t1> cVar) {
        start();
        Object N = super.N(e2, cVar);
        return N == h.e2.j.b.h() ? N : t1.a;
    }

    @Override // i.b.t3.m, i.b.t3.c0
    @k.e.a.d
    public i.b.z3.e<E, c0<E>> h() {
        return this;
    }

    @Override // i.b.t3.m, i.b.t3.c0
    public boolean offer(E e2) {
        start();
        return super.offer(e2);
    }

    @Override // i.b.a
    public void q1() {
        i.b.x3.a.b(this.f15844e, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // i.b.z3.e
    public <R> void z(@k.e.a.d i.b.z3.f<? super R> fVar, E e2, @k.e.a.d h.k2.u.p<? super c0<? super E>, ? super h.e2.c<? super R>, ? extends Object> pVar) {
        start();
        super.h().z(fVar, e2, pVar);
    }
}
