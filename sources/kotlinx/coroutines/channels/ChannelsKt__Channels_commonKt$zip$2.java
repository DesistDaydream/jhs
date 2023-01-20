package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import h.t1;
import i.b.t3.w;
import i.b.t3.y;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {2196, 2186, 2188}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "element1", "$this$produce", "otherIterator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv", "e$iv", "element1", "element2"}, s = {"L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$0", "L$1", "L$2", "L$4", "L$5", "L$6", "L$8", "L$9", "L$10"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00020\u0003H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {ExifInterface.LONGITUDE_EAST, "R", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Li/b/t3/w;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$zip$2 extends SuspendLambda implements p<w<? super V>, c<? super t1>, Object> {
    public final /* synthetic */ y $other;
    public final /* synthetic */ y $this_zip;
    public final /* synthetic */ p $transform;
    public Object L$0;
    public Object L$1;
    public Object L$10;
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
    public ChannelsKt__Channels_commonKt$zip$2(y yVar, y yVar2, p pVar, c cVar) {
        super(2, cVar);
        this.$this_zip = yVar;
        this.$other = yVar2;
        this.$transform = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        ChannelsKt__Channels_commonKt$zip$2 channelsKt__Channels_commonKt$zip$2 = new ChannelsKt__Channels_commonKt$zip$2(this.$this_zip, this.$other, this.$transform, cVar);
        channelsKt__Channels_commonKt$zip$2.p$ = (w) obj;
        return channelsKt__Channels_commonKt$zip$2;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((ChannelsKt__Channels_commonKt$zip$2) create(obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00dd A[Catch: all -> 0x0148, TryCatch #1 {all -> 0x0148, blocks: (B:8:0x0033, B:22:0x00bc, B:25:0x00d5, B:27:0x00dd, B:31:0x0103, B:34:0x0111, B:39:0x0142, B:18:0x009c, B:21:0x00b1), top: B:50:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0111 A[Catch: all -> 0x0148, TryCatch #1 {all -> 0x0148, blocks: (B:8:0x0033, B:22:0x00bc, B:25:0x00d5, B:27:0x00dd, B:31:0x0103, B:34:0x0111, B:39:0x0142, B:18:0x009c, B:21:0x00b1), top: B:50:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0142 A[Catch: all -> 0x0148, TRY_LEAVE, TryCatch #1 {all -> 0x0148, blocks: (B:8:0x0033, B:22:0x00bc, B:25:0x00d5, B:27:0x00dd, B:31:0x0103, B:34:0x0111, B:39:0x0142, B:18:0x009c, B:21:0x00b1), top: B:50:0x000b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x010b -> B:22:0x00bc). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x013a -> B:38:0x013e). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 337
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
