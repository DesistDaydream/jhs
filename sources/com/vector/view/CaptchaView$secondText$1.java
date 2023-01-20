package com.vector.view;

import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.l;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CaptchaView$secondText$1 extends Lambda implements l<Long, String> {
    public final /* synthetic */ CaptchaView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaView$secondText$1(CaptchaView captchaView) {
        super(1);
        this.this$0 = captchaView;
    }

    @Override // h.k2.u.l
    @d
    public final String invoke(@e Long l2) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(l2);
        str = this.this$0.b;
        sb.append(str);
        return sb.toString();
    }
}
