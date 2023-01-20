package com.eth.adapter;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import l.d;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\n"}, d2 = {"<anonymous>", "", "R", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class FlowCallAdapter$adapt$1$1$2 extends Lambda implements l<Throwable, t1> {
    public final /* synthetic */ d<R> $call;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowCallAdapter$adapt$1$1$2(d<R> dVar) {
        super(1);
        this.$call = dVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Throwable th) {
        invoke2(th);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Throwable th) {
        this.$call.cancel();
    }
}
