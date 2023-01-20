package com.jihuanshe.base.bus;

import androidx.exifinterface.media.ExifInterface;
import com.jihuanshe.base.bus.BaseBus;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H\n"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, AdvanceSetting.NETWORK_TYPE, "Lcom/jihuanshe/base/bus/BaseBus$Event;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BaseBus$BusObserver$onValue$1 extends Lambda implements l<BaseBus.b<?>, t1> {
    public final /* synthetic */ l<T, t1> $block;
    public final /* synthetic */ String $eventId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BaseBus$BusObserver$onValue$1(String str, l<? super T, t1> lVar) {
        super(1);
        this.$eventId = str;
        this.$block = lVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(BaseBus.b<?> bVar) {
        invoke2(bVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d BaseBus.b<?> bVar) {
        Object a;
        if (!f0.g(bVar.b(), this.$eventId) || (a = bVar.a()) == null) {
            return;
        }
        this.$block.invoke(a);
    }
}
