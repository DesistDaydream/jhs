package com.jihuanshe.ui.widget;

import android.content.res.ColorStateList;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.jihuanshe.R;
import com.jihuanshe.model.Constants;
import com.vector.util.Res;
import e.l.s.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterInfoBtn$showPopWindow$filterPopupWindow$2 extends Lambda implements l<a, t1> {
    public final /* synthetic */ FilterInfoBtn this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterInfoBtn$showPopWindow$filterPopupWindow$2(FilterInfoBtn filterInfoBtn) {
        super(1);
        this.this$0 = filterInfoBtn;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@d a aVar) {
        if (f0.g(aVar, this.this$0.getData().get(0))) {
            TextView tvName = this.this$0.getTvName();
            if (tvName != null) {
                tvName.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_down, 0);
                TextViewCompat.setCompoundDrawableTintList(tvName, ColorStateList.valueOf(Res.k(R.color.black)));
            }
        } else {
            TextView tvName2 = this.this$0.getTvName();
            if (tvName2 != null) {
                TextViewCompat.setCompoundDrawableTintList(tvName2, ColorStateList.valueOf(Res.k(R.color.common_color_1)));
            }
            Constants.Companion companion = Constants.Companion;
            if (f0.g(aVar, companion.getFILTER_INFO_PRICE_ASC())) {
                TextView tvName3 = this.this$0.getTvName();
                if (tvName3 != null) {
                    tvName3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.svg_up, 0);
                }
            } else if (f0.g(aVar, companion.getFILTER_INFO_PRICE_DESC())) {
                TextView tvName4 = this.this$0.getTvName();
                if (tvName4 != null) {
                    tvName4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_down, 0);
                }
            } else {
                TextView tvName5 = this.this$0.getTvName();
                if (tvName5 != null) {
                    tvName5.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_down, 0);
                }
            }
        }
        l<a, t1> listener = this.this$0.getListener();
        if (listener != null) {
            listener.invoke(aVar);
        }
        TextView tvName6 = this.this$0.getTvName();
        if (tvName6 == null) {
            return;
        }
        tvName6.setText(aVar.f());
    }
}
