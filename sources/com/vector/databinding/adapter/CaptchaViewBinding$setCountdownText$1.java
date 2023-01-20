package com.vector.databinding.adapter;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import h.k2.v.s0;
import java.util.Arrays;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CaptchaViewBinding$setCountdownText$1 extends Lambda implements l<Long, String> {
    public final /* synthetic */ String $text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaViewBinding$setCountdownText$1(String str) {
        super(1);
        this.$text = str;
    }

    @Override // h.k2.u.l
    @d
    public final String invoke(@e Long l2) {
        s0 s0Var = s0.a;
        return String.format(this.$text, Arrays.copyOf(new Object[]{l2}, 1));
    }
}
