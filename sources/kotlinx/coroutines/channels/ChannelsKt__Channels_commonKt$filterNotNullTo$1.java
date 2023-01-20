package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import i.b.t3.o;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0}, l = {2460}, m = "filterNotNullTo", n = {"$this$filterNotNullTo", "destination", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0010\b\u0001\u0010\u0003*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0002*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00042\u0006\u0010\u0005\u001a\u00028\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0087@"}, d2 = {"", ExifInterface.LONGITUDE_EAST, "", "C", "Li/b/t3/y;", "destination", "Lh/e2/c;", "continuation", "filterNotNullTo"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$filterNotNullTo$1 extends ContinuationImpl {
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$filterNotNullTo$1(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return o.b0(null, null, this);
    }
}
