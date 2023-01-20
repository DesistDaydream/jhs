package kotlinx.coroutines.channels;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import h.t1;
import i.b.t3.w;
import i.b.t3.y;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 2, 2, 2}, l = {695, 700, TypedValues.Transition.TYPE_FROM}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining", "$this$produce", "remaining", e.a}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$1"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.LONGITUDE_EAST, "Li/b/t3/w;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$drop$1 extends SuspendLambda implements p<w<? super E>, c<? super t1>, Object> {
    public final /* synthetic */ int $n;
    public final /* synthetic */ y $this_drop;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private w p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__Channels_commonKt$drop$1(y yVar, int i2, c cVar) {
        super(2, cVar);
        this.$this_drop = yVar;
        this.$n = i2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@k.e.a.e Object obj, @k.e.a.d c<?> cVar) {
        ChannelsKt__Channels_commonKt$drop$1 channelsKt__Channels_commonKt$drop$1 = new ChannelsKt__Channels_commonKt$drop$1(this.$this_drop, this.$n, cVar);
        channelsKt__Channels_commonKt$drop$1.p$ = (w) obj;
        return channelsKt__Channels_commonKt$drop$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((ChannelsKt__Channels_commonKt$drop$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x007d -> B:23:0x0084). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x00d6 -> B:33:0x00a7). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$drop$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
