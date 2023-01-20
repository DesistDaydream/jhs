package com.jihuanshe.base.bus;

import com.jihuanshe.base.bus.BaseBus;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Lcom/jihuanshe/base/bus/BaseBus$Event;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class BaseBus$BusObserver$onMessage$1 extends Lambda implements l<BaseBus.b<?>, t1> {
    public final /* synthetic */ a<t1> $block;
    public final /* synthetic */ String $eventId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseBus$BusObserver$onMessage$1(String str, a<t1> aVar) {
        super(1);
        this.$eventId = str;
        this.$block = aVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(BaseBus.b<?> bVar) {
        invoke2(bVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d BaseBus.b<?> bVar) {
        if (f0.g(bVar.b(), this.$eventId)) {
            this.$block.invoke();
        }
    }
}
