package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.t1;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.SubscribedFlowCollector;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002BG\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u000e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R@\u0010\u000e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000b8\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f8\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, d2 = {"Li/b/v3/a0;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/p;", "Li/b/v3/f;", "collector", "Lh/t1;", com.huawei.hms.push.e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lh/e2/c;", "", "Lh/q;", "b", "Lh/k2/u/p;", "action", "", e.j.a.b.c.f.f10128d, "()Ljava/util/List;", "replayCache", am.av, "Li/b/v3/p;", "sharedFlow", "<init>", "(Li/b/v3/p;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class a0<T> implements p<T> {
    private final p<T> a;
    private final h.k2.u.p<f<? super T>, h.e2.c<? super t1>, Object> b;

    /* JADX WARN: Multi-variable type inference failed */
    public a0(@k.e.a.d p<? extends T> pVar, @k.e.a.d h.k2.u.p<? super f<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar2) {
        this.a = pVar;
        this.b = pVar2;
    }

    @Override // i.b.v3.p
    @k.e.a.d
    public List<T> d() {
        return this.a.d();
    }

    @Override // kotlinx.coroutines.flow.Flow
    @k.e.a.e
    public Object e(@k.e.a.d f<? super T> fVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        Object e2 = this.a.e(new SubscribedFlowCollector(fVar, this.b), cVar);
        return e2 == h.e2.j.b.h() ? e2 : t1.a;
    }
}
