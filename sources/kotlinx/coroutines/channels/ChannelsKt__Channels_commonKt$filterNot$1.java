package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.a;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$filterNot$1", f = "Channels.common.kt", i = {0}, l = {832}, m = "invokeSuspend", n = {AdvanceSetting.NETWORK_TYPE}, s = {"L$0"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {ExifInterface.LONGITUDE_EAST, AdvanceSetting.NETWORK_TYPE, "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$filterNot$1 extends SuspendLambda implements p<E, c<? super Boolean>, Object> {
    public final /* synthetic */ p $predicate;
    public Object L$0;
    public int label;
    private Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelsKt__Channels_commonKt$filterNot$1(p pVar, c cVar) {
        super(2, cVar);
        this.$predicate = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        ChannelsKt__Channels_commonKt$filterNot$1 channelsKt__Channels_commonKt$filterNot$1 = new ChannelsKt__Channels_commonKt$filterNot$1(this.$predicate, cVar);
        channelsKt__Channels_commonKt$filterNot$1.p$0 = obj;
        return channelsKt__Channels_commonKt$filterNot$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, c<? super Boolean> cVar) {
        return ((ChannelsKt__Channels_commonKt$filterNot$1) create(obj, cVar)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        Object h2 = b.h();
        int i2 = this.label;
        if (i2 == 0) {
            r0.n(obj);
            Object obj2 = this.p$0;
            p pVar = this.$predicate;
            this.L$0 = obj2;
            this.label = 1;
            obj = pVar.invoke(obj2, this);
            if (obj == h2) {
                return h2;
            }
        } else if (i2 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            r0.n(obj);
        }
        return a.a(!((Boolean) obj).booleanValue());
    }
}
