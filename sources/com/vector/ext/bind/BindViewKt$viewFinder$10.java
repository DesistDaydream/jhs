package com.vector.ext.bind;

import android.view.View;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import e.t.k.a.c.b;
import h.k2.u.p;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, d2 = {"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "Lcom/vector/design/ui/adapter/BaseViewHolder;", AdvanceSetting.NETWORK_TYPE, ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class BindViewKt$viewFinder$10 extends Lambda implements p<b, Integer, View> {
    public static final BindViewKt$viewFinder$10 INSTANCE = new BindViewKt$viewFinder$10();

    public BindViewKt$viewFinder$10() {
        super(2);
    }

    public final View invoke(@d b bVar, int i2) {
        return bVar.itemView.findViewById(i2);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ View invoke(b bVar, Integer num) {
        return invoke(bVar, num.intValue());
    }
}
