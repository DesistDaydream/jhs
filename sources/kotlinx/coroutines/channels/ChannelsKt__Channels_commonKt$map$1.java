package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import h.t1;
import i.b.t3.w;
import i.b.t3.y;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2}, l = {2196, 1395, 1395}, m = "invokeSuspend", n = {"$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", AdvanceSetting.NETWORK_TYPE, "$this$produce", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$3", "L$4", "L$5", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8", "L$0", "L$1", "L$3", "L$4", "L$5", "L$7", "L$8"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LONGITUDE_EAST, "R", "Li/b/t3/w;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$map$1 extends SuspendLambda implements p<w<? super R>, c<? super t1>, Object> {
    public final /* synthetic */ y $this_map;
    public final /* synthetic */ p $transform;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public Object L$7;
    public Object L$8;
    public Object L$9;
    public int label;
    private w p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__Channels_commonKt$map$1(y yVar, p pVar, c cVar) {
        super(2, cVar);
        this.$this_map = yVar;
        this.$transform = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        ChannelsKt__Channels_commonKt$map$1 channelsKt__Channels_commonKt$map$1 = new ChannelsKt__Channels_commonKt$map$1(this.$this_map, this.$transform, cVar);
        channelsKt__Channels_commonKt$map$1.p$ = (w) obj;
        return channelsKt__Channels_commonKt$map$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((ChannelsKt__Channels_commonKt$map$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e0 A[Catch: all -> 0x013c, TRY_LEAVE, TryCatch #3 {all -> 0x013c, blocks: (B:23:0x00c1, B:26:0x00d8, B:28:0x00e0, B:37:0x0136), top: B:53:0x00c1 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x012d A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0136 A[Catch: all -> 0x013c, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x013c, blocks: (B:23:0x00c1, B:26:0x00d8, B:28:0x00e0, B:37:0x0136), top: B:53:0x00c1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x012e -> B:36:0x0134). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$map$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
