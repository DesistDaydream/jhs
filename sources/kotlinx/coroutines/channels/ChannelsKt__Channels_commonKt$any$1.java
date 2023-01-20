package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import h.e2.k.a.d;
import i.b.t3.o;
import k.b.a.a.n.n.c;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0, 0, 0}, l = {1757}, m = c.b, n = {"$this$any", "$this$consume$iv", "cause$iv", "$this$consume"}, s = {"L$0", "L$1", "L$2", "L$3"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0087@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {ExifInterface.LONGITUDE_EAST, "Li/b/t3/y;", "Lh/e2/c;", "", "continuation", "", c.b, "(Li/b/t3/y;Lh/e2/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$any$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$any$1(h.e2.c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return o.c(null, this);
    }
}
