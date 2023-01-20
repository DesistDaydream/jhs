package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import h.t1;
import i.b.x1;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0015\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ!\u0010\u0011\u001a\u00020\u00102\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000eH\u0097Aø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00138\u0016@\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Li/b/v3/m;", ExifInterface.GPS_DIRECTION_TRUE, "Li/b/v3/p;", "Li/b/v3/a;", "Li/b/v3/c0/k;", "Lkotlin/coroutines/CoroutineContext;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", am.av, "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "Li/b/v3/f;", "collector", "Lh/t1;", com.huawei.hms.push.e.a, "(Li/b/v3/f;Lh/e2/c;)Ljava/lang/Object;", "", e.j.a.b.c.f.f10128d, "()Ljava/util/List;", "replayCache", "flow", "<init>", "(Li/b/v3/p;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class m<T> implements p<T>, a<T>, i.b.v3.c0.k<T> {
    private final /* synthetic */ p<? extends T> a;

    public m(@k.e.a.d p<? extends T> pVar) {
        this.a = pVar;
    }

    @Override // i.b.v3.c0.k
    @k.e.a.d
    public Flow<T> a(@k.e.a.d CoroutineContext coroutineContext, int i2, @k.e.a.d BufferOverflow bufferOverflow) {
        return r.e(this, coroutineContext, i2, bufferOverflow);
    }

    @Override // i.b.v3.p
    @k.e.a.d
    public List<T> d() {
        return (List<? extends T>) this.a.d();
    }

    @Override // kotlinx.coroutines.flow.Flow
    @x1
    @k.e.a.e
    public Object e(@k.e.a.d f<? super T> fVar, @k.e.a.d h.e2.c<? super t1> cVar) {
        return this.a.e(fVar, cVar);
    }
}
