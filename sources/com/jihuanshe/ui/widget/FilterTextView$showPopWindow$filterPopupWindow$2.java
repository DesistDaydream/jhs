package com.jihuanshe.ui.widget;

import android.content.res.ColorStateList;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterTextView$showPopWindow$filterPopupWindow$2 extends Lambda implements l<Pair<? extends String, ? extends String>, t1> {
    public final /* synthetic */ FilterTextView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterTextView$showPopWindow$filterPopupWindow$2(FilterTextView filterTextView) {
        super(1);
        this.this$0 = filterTextView;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Pair<? extends String, ? extends String> pair) {
        invoke2((Pair<String, String>) pair);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@d Pair<String, String> pair) {
        if (f0.g(pair.getFirst(), this.this$0.getData().get(0).getFirst())) {
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
            String first = pair.getFirst();
            if (f0.g(first, "价钱低到高")) {
                TextView tvName3 = this.this$0.getTvName();
                if (tvName3 != null) {
                    tvName3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.svg_up, 0);
                }
            } else if (f0.g(first, "价钱高到低")) {
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
        l<Pair<String, String>, t1> statListener = this.this$0.getStatListener();
        if (statListener != null) {
            statListener.invoke(pair);
        }
        l<Pair<String, String>, t1> listener = this.this$0.getListener();
        if (listener != null) {
            listener.invoke(pair);
        }
        TextView tvName6 = this.this$0.getTvName();
        if (tvName6 == null) {
            return;
        }
        tvName6.setText(pair.getFirst());
    }
}
