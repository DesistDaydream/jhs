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

@d(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1, 1}, l = {51, 52}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast", e.a}, s = {"L$0", "L$0", "L$1"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.LONGITUDE_EAST, "Li/b/t3/w;", "Lh/t1;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class BroadcastKt$broadcast$2 extends SuspendLambda implements p<w<? super E>, c<? super t1>, Object> {
    public final /* synthetic */ y $this_broadcast;
    public Object L$0;
    public Object L$1;
    public Object L$2;
    public int label;
    private w p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BroadcastKt$broadcast$2(y yVar, c cVar) {
        super(2, cVar);
        this.$this_broadcast = yVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@k.e.a.e Object obj, @k.e.a.d c<?> cVar) {
        BroadcastKt$broadcast$2 broadcastKt$broadcast$2 = new BroadcastKt$broadcast$2(this.$this_broadcast, cVar);
        broadcastKt$broadcast$2.p$ = (w) obj;
        return broadcastKt$broadcast$2;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super t1> cVar) {
        return ((BroadcastKt$broadcast$2) create(obj, cVar)).invokeSuspend(t1.a);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x0068 -> B:12:0x003c). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(@k.e.a.d java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = h.e2.j.b.h()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L30
            if (r1 == r3) goto L23
            if (r1 != r2) goto L1b
            java.lang.Object r1 = r7.L$2
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r7.L$0
            i.b.t3.w r4 = (i.b.t3.w) r4
            h.r0.n(r8)
            r8 = r4
            goto L3b
        L1b:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L23:
            java.lang.Object r1 = r7.L$1
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r7.L$0
            i.b.t3.w r4 = (i.b.t3.w) r4
            h.r0.n(r8)
            r5 = r7
            goto L4d
        L30:
            h.r0.n(r8)
            i.b.t3.w r8 = r7.p$
            i.b.t3.y r1 = r7.$this_broadcast
            kotlinx.coroutines.channels.ChannelIterator r1 = r1.iterator()
        L3b:
            r4 = r7
        L3c:
            r4.L$0 = r8
            r4.L$1 = r1
            r4.label = r3
            java.lang.Object r5 = r1.b(r4)
            if (r5 != r0) goto L49
            return r0
        L49:
            r6 = r4
            r4 = r8
            r8 = r5
            r5 = r6
        L4d:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L6b
            java.lang.Object r8 = r1.next()
            r5.L$0 = r4
            r5.L$1 = r8
            r5.L$2 = r1
            r5.label = r2
            java.lang.Object r8 = r4.N(r8, r5)
            if (r8 != r0) goto L68
            return r0
        L68:
            r8 = r4
            r4 = r5
            goto L3c
        L6b:
            h.t1 r8 = h.t1.a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.BroadcastKt$broadcast$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
