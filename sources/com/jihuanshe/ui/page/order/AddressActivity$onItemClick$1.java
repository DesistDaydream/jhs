package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.model.UserAddress;
import e.l.h.d.f;
import e.l.s.j.a;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddressActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ AddressActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddressActivity$onItemClick$1(AddressActivity addressActivity) {
        super(2);
        this.this$0 = addressActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        UserAddress userAddress;
        if (!this.this$0.Z()) {
            f fVar = f.b;
            List<UserAddress> value = ((a) this.this$0.L()).q0().getValue();
            fVar.c(e.l.j.a.f12235e, value == null ? null : (UserAddress) CollectionsKt___CollectionsKt.J2(value, i2));
            this.this$0.finish();
            return;
        }
        List<UserAddress> value2 = ((a) this.this$0.L()).q0().getValue();
        if (value2 == null || (userAddress = (UserAddress) CollectionsKt___CollectionsKt.J2(value2, i2)) == null) {
            return;
        }
        this.this$0.W().w(userAddress).a().invoke(view);
    }
}
