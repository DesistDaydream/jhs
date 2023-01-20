package i.b.v3;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00078\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Li/b/v3/t;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/Flow;", am.av, "Lkotlinx/coroutines/flow/Flow;", "upstream", "", "b", ExpandableTextView.P, "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "c", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/coroutines/CoroutineContext;", e.j.a.b.c.f.f10128d, "Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlinx/coroutines/flow/Flow;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class t<T> {
    @h.k2.d
    @k.e.a.d
    public final Flow<T> a;
    @h.k2.d
    public final int b;
    @h.k2.d
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public final BufferOverflow f15870c;
    @h.k2.d
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public final CoroutineContext f15871d;

    /* JADX WARN: Multi-variable type inference failed */
    public t(@k.e.a.d Flow<? extends T> flow, int i2, @k.e.a.d BufferOverflow bufferOverflow, @k.e.a.d CoroutineContext coroutineContext) {
        this.a = flow;
        this.b = i2;
        this.f15870c = bufferOverflow;
        this.f15871d = coroutineContext;
    }
}
