package com.jihuanshe.ui.widget;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.drawable.DrawableCompat;
import com.jihuanshe.R;
import com.jihuanshe.model.Rarity;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConditionFilterBtn$1$1 extends Lambda implements l<List<? extends Rarity>, t1> {
    public final /* synthetic */ ConditionFilterBtn this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConditionFilterBtn$1$1(ConditionFilterBtn conditionFilterBtn) {
        super(1);
        this.this$0 = conditionFilterBtn;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Rarity> list) {
        invoke2((List<Rarity>) list);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@e List<Rarity> list) {
        l<List<Rarity>, t1> listener = this.this$0.getListener();
        if (listener != null) {
            listener.invoke(list);
        }
        Drawable drawable = this.this$0.getDrawable();
        if (drawable == null) {
            return;
        }
        if (list == null || list.isEmpty()) {
            DrawableCompat.setTintList(drawable, null);
        } else {
            DrawableCompat.setTintList(drawable, ColorStateList.valueOf(Res.k(R.color.common_color_1)));
        }
    }
}
