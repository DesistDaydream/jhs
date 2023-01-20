package com.vector.ext.bind;

import android.app.Dialog;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import h.k2.u.p;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroid/view/View;", "Landroidx/fragment/app/DialogFragment;", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BindViewKt$viewFinder$7 extends Lambda implements p<DialogFragment, Integer, View> {
    public static final BindViewKt$viewFinder$7 INSTANCE = new BindViewKt$viewFinder$7();

    public BindViewKt$viewFinder$7() {
        super(2);
    }

    @e
    public final View invoke(@d DialogFragment dialogFragment, int i2) {
        Dialog dialog = dialogFragment.getDialog();
        View findViewById = dialog == null ? null : dialog.findViewById(i2);
        if (findViewById == null) {
            View view = dialogFragment.getView();
            if (view == null) {
                return null;
            }
            return view.findViewById(i2);
        }
        return findViewById;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ View invoke(DialogFragment dialogFragment, Integer num) {
        return invoke(dialogFragment, num.intValue());
    }
}
