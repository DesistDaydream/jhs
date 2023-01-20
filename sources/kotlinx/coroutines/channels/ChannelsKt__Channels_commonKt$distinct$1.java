package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.j.b;
import h.e2.k.a.d;
import h.k2.u.p;
import h.r0;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$distinct$1", f = "Channels.common.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0004\n\u0002\b\u0005\u0010\u0004\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {ExifInterface.LONGITUDE_EAST, AdvanceSetting.NETWORK_TYPE, "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$distinct$1 extends SuspendLambda implements p<E, c<? super E>, Object> {
    public int label;
    private Object p$0;

    public ChannelsKt__Channels_commonKt$distinct$1(c cVar) {
        super(2, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k.e.a.d
    public final c<t1> create(@e Object obj, @k.e.a.d c<?> cVar) {
        ChannelsKt__Channels_commonKt$distinct$1 channelsKt__Channels_commonKt$distinct$1 = new ChannelsKt__Channels_commonKt$distinct$1(cVar);
        channelsKt__Channels_commonKt$distinct$1.p$0 = obj;
        return channelsKt__Channels_commonKt$distinct$1;
    }

    @Override // h.k2.u.p
    public final Object invoke(Object obj, Object obj2) {
        return ((ChannelsKt__Channels_commonKt$distinct$1) create(obj, (c) obj2)).invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            return this.p$0;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
