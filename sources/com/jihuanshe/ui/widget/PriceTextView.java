package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import com.vector.util.Res;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class PriceTextView extends AppCompatTextView {
    @h
    public PriceTextView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ PriceTextView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private final int e(int i2) {
        return i2 != 1 ? i2 != 2 ? R.string.shop_price : R.string.shop_min_want_price : R.string.shop_min_price;
    }

    public final void f(float f2, boolean z, int i2, boolean z2, int i3, int i4) {
        setText(StringUtil.a.b(f2, e(i4), z, i3, i2, z2));
    }

    @h
    public PriceTextView(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        setTextColor(Res.k(R.color.price_red));
        setTypeface(null, 1);
    }
}
