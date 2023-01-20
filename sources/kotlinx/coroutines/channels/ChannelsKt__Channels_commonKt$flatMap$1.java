package kotlinx.coroutines.channels;

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

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$flatMap$1", f = "Channels.common.kt", i = {0, 1, 1, 2, 2}, l = {1286, 1287, 1287}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", e.a, "$this$produce", e.a}, s = {"L$0", "L$0", "L$1", "L$0", "L$1"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00010\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LONGITUDE_EAST, "R", "Li/b/t3/w;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$flatMap$1 extends SuspendLambda implements p<w<? super R>, c<? super t1>, Object> {
    public final /* synthetic */ y $this_flatMap;
    public final /* synthetic */ p $transform;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private w p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__Channels_commonKt$flatMap$1(y yVar, p pVar, c cVar) {
        super(2, cVar);
        this.$this_flatMap = yVar;
        this.$transform = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@k.e.a.e Object obj, @k.e.a.d c<?> cVar) {
        ChannelsKt__Channels_commonKt$flatMap$1 channelsKt__Channels_commonKt$flatMap$1 = new ChannelsKt__Channels_commonKt$flatMap$1(this.$this_flatMap, this.$transform, cVar);
        channelsKt__Channels_commonKt$flatMap$1.p$ = (w) obj;
        return channelsKt__Channels_commonKt$flatMap$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((ChannelsKt__Channels_commonKt$flatMap$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0060 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0097 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0098 -> B:14:0x0054). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r9.label
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L47
            if (r1 == r4) goto L37
            if (r1 == r3) goto L25
            if (r1 != r2) goto L1d
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            i.b.t3.w r5 = (i.b.t3.w) r5
            h.r0.n(r10)
            goto L53
        L1d:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L25:
            java.lang.Object r1 = r9.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$1
            java.lang.Object r6 = r9.L$0
            i.b.t3.w r6 = (i.b.t3.w) r6
            h.r0.n(r10)
            r7 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L87
        L37:
            java.lang.Object r1 = r9.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r5 = r9.L$0
            i.b.t3.w r5 = (i.b.t3.w) r5
            h.r0.n(r10)
            r6 = r5
            r5 = r1
            r1 = r0
            r0 = r9
            goto L67
        L47:
            h.r0.n(r10)
            i.b.t3.w r10 = r9.p$
            i.b.t3.y r1 = r9.$this_flatMap
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
            r5 = r10
        L53:
            r10 = r9
        L54:
            r10.L$0 = r5
            r10.L$1 = r1
            r10.label = r4
            java.lang.Object r6 = r1.b(r10)
            if (r6 != r0) goto L61
            return r0
        L61:
            r8 = r0
            r0 = r10
            r10 = r6
            r6 = r5
            r5 = r1
            r1 = r8
        L67:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L9d
            java.lang.Object r10 = r5.next()
            h.k2.u.p r7 = r0.$transform
            r0.L$0 = r6
            r0.L$1 = r10
            r0.L$2 = r5
            r0.label = r3
            java.lang.Object r7 = r7.invoke(r10, r0)
            if (r7 != r1) goto L84
            return r1
        L84:
            r8 = r7
            r7 = r10
            r10 = r8
        L87:
            i.b.t3.y r10 = (i.b.t3.y) r10
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r5
            r0.label = r2
            java.lang.Object r10 = i.b.t3.o.a2(r10, r6, r0)
            if (r10 != r1) goto L98
            return r1
        L98:
            r10 = r0
            r0 = r1
            r1 = r5
            r5 = r6
            goto L54
        L9d:
            h.t1 r10 = h.t1.a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$flatMap$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
