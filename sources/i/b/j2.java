package i.b;

import androidx.exifinterface.media.ExifInterface;
import com.qiniu.android.collect.ReportItem;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlinx.coroutines.DeferredCoroutine;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B;\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012'\u0010\u0010\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\f¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Li/b/j2;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/DeferredCoroutine;", "Lh/t1;", "q1", "()V", "Lh/e2/c;", e.j.a.b.c.f.f10128d, "Lh/e2/c;", "continuation", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "Lkotlin/Function2;", "Li/b/n0;", "", "Lh/q;", ReportItem.LogTypeBlock, "<init>", "(Lkotlin/coroutines/CoroutineContext;Lh/k2/u/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class j2<T> extends DeferredCoroutine<T> {

    /* renamed from: d  reason: collision with root package name */
    private final h.e2.c<h.t1> f15761d;

    public j2(@k.e.a.d CoroutineContext coroutineContext, @k.e.a.d h.k2.u.p<? super n0, ? super h.e2.c<? super T>, ? extends Object> pVar) {
        super(coroutineContext, false);
        this.f15761d = IntrinsicsKt__IntrinsicsJvmKt.c(pVar, this, this);
    }

    @Override // i.b.a
    public void q1() {
        i.b.x3.a.b(this.f15761d, this);
    }
}
