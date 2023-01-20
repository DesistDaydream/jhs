package com.vector.ext.bind;

import android.view.View;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vector.design.ui.dialog.DialogEx;
import h.k2.u.p;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Landroid/view/View;", "Lcom/vector/design/ui/dialog/DialogEx;", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BindViewKt$viewFinder$4 extends Lambda implements p<DialogEx, Integer, View> {
    public static final BindViewKt$viewFinder$4 INSTANCE = new BindViewKt$viewFinder$4();

    public BindViewKt$viewFinder$4() {
        super(2);
    }

    @e
    public final View invoke(@d DialogEx dialogEx, int i2) {
        View l2 = dialogEx.l();
        if (l2 == null) {
            return null;
        }
        return l2.findViewById(i2);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ View invoke(DialogEx dialogEx, Integer num) {
        return invoke(dialogEx, num.intValue());
    }
}
