package com.vector.databinding.adapter;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import e.t.j.h.i0;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewBinding$setOnTitleChanged$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ i0 $binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewBinding$setOnTitleChanged$1(i0 i0Var) {
        super(1);
        this.$binding = i0Var;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        this.$binding.a().invoke(str);
    }
}
