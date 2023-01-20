package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.e;
import h.a2.i0;
import h.e2.c;
import h.e2.k.a.d;
import h.k2.u.p;
import h.t1;
import i.b.t3.w;
import i.b.t3.y;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$withIndex$1", f = "Channels.common.kt", i = {0, 0, 1, 1, 1}, l = {1653, 1654}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", e.a}, s = {"L$0", "I$0", "L$0", "I$0", "L$1"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {ExifInterface.LONGITUDE_EAST, "Li/b/t3/w;", "Lh/a2/i0;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$withIndex$1 extends SuspendLambda implements p<w<? super i0<? extends E>>, c<? super t1>, Object> {
    public final /* synthetic */ y $this_withIndex;
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private w p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__Channels_commonKt$withIndex$1(y yVar, c cVar) {
        super(2, cVar);
        this.$this_withIndex = yVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@k.e.a.e Object obj, @k.e.a.d c<?> cVar) {
        ChannelsKt__Channels_commonKt$withIndex$1 channelsKt__Channels_commonKt$withIndex$1 = new ChannelsKt__Channels_commonKt$withIndex$1(this.$this_withIndex, cVar);
        channelsKt__Channels_commonKt$withIndex$1.p$ = (w) obj;
        return channelsKt__Channels_commonKt$withIndex$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((ChannelsKt__Channels_commonKt$withIndex$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0084  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x007f -> B:11:0x0045). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L38
            if (r1 == r3) goto L29
            if (r1 != r2) goto L21
            java.lang.Object r1 = r11.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r4 = r11.I$0
            java.lang.Object r5 = r11.L$0
            i.b.t3.w r5 = (i.b.t3.w) r5
            h.r0.n(r12)
            r12 = r5
            r5 = r11
            r9 = r4
            r4 = r1
            r1 = r9
            goto L45
        L21:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L29:
            java.lang.Object r1 = r11.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            int r4 = r11.I$0
            java.lang.Object r5 = r11.L$0
            i.b.t3.w r5 = (i.b.t3.w) r5
            h.r0.n(r12)
            r6 = r11
            goto L5b
        L38:
            h.r0.n(r12)
            i.b.t3.w r12 = r11.p$
            r1 = 0
            i.b.t3.y r4 = r11.$this_withIndex
            kotlinx.coroutines.channels.ChannelIterator r4 = r4.iterator()
            r5 = r11
        L45:
            r5.L$0 = r12
            r5.I$0 = r1
            r5.L$1 = r4
            r5.label = r3
            java.lang.Object r6 = r4.b(r5)
            if (r6 != r0) goto L54
            return r0
        L54:
            r9 = r5
            r5 = r12
            r12 = r6
            r6 = r9
            r10 = r4
            r4 = r1
            r1 = r10
        L5b:
            java.lang.Boolean r12 = (java.lang.Boolean) r12
            boolean r12 = r12.booleanValue()
            if (r12 == 0) goto L84
            java.lang.Object r12 = r1.next()
            h.a2.i0 r7 = new h.a2.i0
            int r8 = r4 + 1
            r7.<init>(r4, r12)
            r6.L$0 = r5
            r6.I$0 = r8
            r6.L$1 = r12
            r6.L$2 = r1
            r6.label = r2
            java.lang.Object r12 = r5.N(r7, r6)
            if (r12 != r0) goto L7f
            return r0
        L7f:
            r4 = r1
            r12 = r5
            r5 = r6
            r1 = r8
            goto L45
        L84:
            h.t1 r12 = h.t1.a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$withIndex$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
