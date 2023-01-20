package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlinx.coroutines.channels.ChannelIterator;

@d(c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", f = "Channel.kt", i = {0}, l = {458}, m = "next", n = {"$this"}, s = {"L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\u0006\b\u0000\u0010\u0000 \u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0097@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LONGITUDE_EAST, "Lh/e2/c;", "continuation", "", "next0", "(Lh/e2/c;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelIterator$next0$1 extends ContinuationImpl {
    public Object L$0;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ ChannelIterator this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelIterator$next0$1(ChannelIterator channelIterator, c cVar) {
        super(cVar);
        this.this$0 = channelIterator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelIterator.DefaultImpls.a(null, this);
    }
}
