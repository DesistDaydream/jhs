package com.jihuanshe.ui.page.im;

import android.widget.TextView;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class InteractMessageActivity$onPageSelect$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ InteractMessageActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractMessageActivity$onPageSelect$1(InteractMessageActivity interactMessageActivity) {
        super(1);
        this.this$0 = interactMessageActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        TextView c0;
        TextView c02;
        TextView j0;
        TextView j02;
        TextView d0;
        TextView d02;
        TextView d03;
        TextView d04;
        TextView c03;
        TextView c04;
        TextView j03;
        TextView j04;
        TextView j05;
        TextView j06;
        TextView c05;
        TextView c06;
        TextView d05;
        TextView d06;
        if (i2 == 1) {
            c0 = this.this$0.c0();
            c0.setTextSize(2, 16.0f);
            c02 = this.this$0.c0();
            c02.setTextColor(Res.k(R.color.common_color));
            j0 = this.this$0.j0();
            j0.setTextSize(2, 14.0f);
            j02 = this.this$0.j0();
            j02.setTextColor(Res.k(R.color.black));
            d0 = this.this$0.d0();
            d0.setTextSize(2, 14.0f);
            d02 = this.this$0.d0();
            d02.setTextColor(Res.k(R.color.black));
        } else if (i2 != 2) {
            j05 = this.this$0.j0();
            j05.setTextSize(2, 16.0f);
            j06 = this.this$0.j0();
            j06.setTextColor(Res.k(R.color.common_color));
            c05 = this.this$0.c0();
            c05.setTextSize(2, 14.0f);
            c06 = this.this$0.c0();
            c06.setTextColor(Res.k(R.color.black));
            d05 = this.this$0.d0();
            d05.setTextSize(2, 14.0f);
            d06 = this.this$0.d0();
            d06.setTextColor(Res.k(R.color.black));
        } else {
            d03 = this.this$0.d0();
            d03.setTextSize(2, 16.0f);
            d04 = this.this$0.d0();
            d04.setTextColor(Res.k(R.color.common_color));
            c03 = this.this$0.c0();
            c03.setTextSize(2, 14.0f);
            c04 = this.this$0.c0();
            c04.setTextColor(Res.k(R.color.black));
            j03 = this.this$0.j0();
            j03.setTextSize(2, 14.0f);
            j04 = this.this$0.j0();
            j04.setTextColor(Res.k(R.color.black));
        }
    }
}
