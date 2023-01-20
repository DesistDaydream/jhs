package com.vector.databinding.adapter;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import e.t.j.h.b0;
import h.k2.u.l;
import h.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewBinding$setOnProgressChanged$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ b0 $binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewBinding$setOnProgressChanged$1(b0 b0Var) {
        super(1);
        this.$binding = b0Var;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        this.$binding.a().invoke(Integer.valueOf(i2));
    }
}
