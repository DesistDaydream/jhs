package com.vector.ext.bind;

import androidx.fragment.app.Fragment;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.p;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BindFragmentKt$fragFinder$2 extends Lambda implements p<Fragment, Integer, Fragment> {
    public static final BindFragmentKt$fragFinder$2 INSTANCE = new BindFragmentKt$fragFinder$2();

    public BindFragmentKt$fragFinder$2() {
        super(2);
    }

    @e
    public final Fragment invoke(@d Fragment fragment, int i2) {
        return fragment.getParentFragmentManager().findFragmentById(i2);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Fragment invoke(Fragment fragment, Integer num) {
        return invoke(fragment, num.intValue());
    }
}
