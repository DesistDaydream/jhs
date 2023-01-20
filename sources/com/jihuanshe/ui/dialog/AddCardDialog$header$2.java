package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.widget.TextView;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardDialog$header$2 extends Lambda implements a<TextView> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCardDialog$header$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final TextView invoke() {
        TextView textView = new TextView(this.$context);
        textView.setText("已有商品");
        textView.setTextColor(Res.k(R.color.black_333333));
        textView.setTextSize(12.0f);
        return textView;
    }
}
