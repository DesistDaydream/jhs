package com.vector.design.ui.activity;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import e.t.u.a0;
import h.k2.u.l;
import h.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SimpleActivityEx$onCreate$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ SimpleActivityEx this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SimpleActivityEx$onCreate$1(SimpleActivityEx simpleActivityEx) {
        super(1);
        this.this$0 = simpleActivityEx;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        a0.a.k(this.this$0.getWindow(), i2);
    }
}
