package com.vector.ext.bind;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.p;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroidx/fragment/app/Fragment;", "Landroidx/fragment/app/FragmentActivity;", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BindFragmentKt$fragFinder$1 extends Lambda implements p<FragmentActivity, Integer, Fragment> {
    public static final BindFragmentKt$fragFinder$1 INSTANCE = new BindFragmentKt$fragFinder$1();

    public BindFragmentKt$fragFinder$1() {
        super(2);
    }

    @e
    public final Fragment invoke(@d FragmentActivity fragmentActivity, int i2) {
        return fragmentActivity.getSupportFragmentManager().findFragmentById(i2);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Fragment invoke(FragmentActivity fragmentActivity, Integer num) {
        return invoke(fragmentActivity, num.intValue());
    }
}
