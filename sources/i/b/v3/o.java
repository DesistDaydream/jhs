package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import h.t1;
import kotlin.Metadata;
import kotlinx.coroutines.flow.AbstractFlow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B9\u0012-\u0010\u000e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000bø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007R@\u0010\u000e\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\u0002\b\u000b8\u0002@\u0002X\u0082\u0004ø\u0001\u0000¢\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Li/b/v3/o;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/AbstractFlow;", "Li/b/v3/f;", "collector", "Lh/t1;", "h", "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "Lkotlin/Function2;", "Lh/e2/c;", "", "Lh/q;", am.av, "Lh/k2/u/p;", ReportItem.LogTypeBlock, "<init>", "(Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class o<T> extends AbstractFlow<T> {
    private final h.k2.u.p<f<? super T>, h.e2.c<? super t1>, Object> a;

    /* JADX WARN: Multi-variable type inference failed */
    public o(@k.e.a.d h.k2.u.p<? super f<? super T>, ? super h.e2.c<? super t1>, ? extends Object> pVar) {
        this.a = pVar;
    }

    @Override // kotlinx.coroutines.flow.AbstractFlow
    @k.e.a.e
    public Object h(@k.e.a.d f<? super T> fVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        Object invoke = this.a.invoke(fVar, cVar);
        return invoke == h.e2.j.b.h() ? invoke : t1.a;
    }
}
