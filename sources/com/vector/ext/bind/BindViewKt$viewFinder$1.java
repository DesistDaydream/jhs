package com.vector.ext.bind;

import android.view.View;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.p;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BindViewKt$viewFinder$1 extends Lambda implements p<View, Integer, View> {
    public static final BindViewKt$viewFinder$1 INSTANCE = new BindViewKt$viewFinder$1();

    public BindViewKt$viewFinder$1() {
        super(2);
    }

    public final View invoke(@d View view, int i2) {
        return view.findViewById(i2);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ View invoke(View view, Integer num) {
        return invoke(view, num.intValue());
    }
}
