package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.e2.c;
import h.e2.k.a.d;
import i.b.t3.o;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@d(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {2720, 1483}, m = "mapIndexedNotNullTo", n = {"$this$mapIndexedNotNullTo", "destination", "transform", "$this$consumeEachIndexed$iv", "index$iv", "$this$consumeEach$iv$iv", "$this$consume$iv$iv$iv", "cause$iv$iv$iv", "$this$consume$iv$iv", "$this$mapIndexedNotNullTo", "destination", "transform", "$this$consumeEachIndexed$iv", "index$iv", "$this$consumeEach$iv$iv", "$this$consume$iv$iv$iv", "cause$iv$iv$iv", "$this$consume$iv$iv", "e$iv$iv", "it$iv", "$dstr$index$element", "index", "element", AdvanceSetting.NETWORK_TYPE}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "I$0", "L$13", "L$14"})
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001\"\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00010\u0003*\b\u0012\u0004\u0012\u00028\u00000\u00052\u0006\u0010\u0006\u001a\u00028\u00022)\u0010\f\u001a%\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u00072\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00020\rH\u0087H"}, d2 = {ExifInterface.LONGITUDE_EAST, "", "R", "Li/b/t3/c0;", "C", "Li/b/t3/y;", "destination", "Lkotlin/Function2;", "", "Lh/k0;", "name", "index", "transform", "Lh/e2/c;", "continuation", "mapIndexedNotNullTo"}, k = 3, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3 extends ContinuationImpl {
    public int I$0;
    public Object L$0;
    public Object L$1;
    public Object L$10;
    public Object L$11;
    public Object L$12;
    public Object L$13;
    public Object L$14;
    public Object L$2;
    public Object L$3;
    public Object L$4;
    public Object L$5;
    public Object L$6;
    public Object L$7;
    public Object L$8;
    public Object L$9;
    public int label;
    public /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3(c cVar) {
        super(cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@k.e.a.d Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return o.c1(null, null, null, this);
    }
}
