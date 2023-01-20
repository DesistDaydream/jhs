package com.jihuanshe.ui.page.user;

import android.widget.TextView;
import com.jihuanshe.R;
import com.jihuanshe.viewmodel.user.CoinViewModel;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CoinActivity$flowOfSetup$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ CoinActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoinActivity$flowOfSetup$1(CoinActivity coinActivity) {
        super(1);
        this.this$0 = coinActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        TextView textView;
        textView = this.this$0.z;
        if (textView != null) {
            textView.setText(Res.w(Res.a, i2 == 0 ? R.string.common_coin : R.string.common_wx_coin, null, 2, null));
        }
        TextView e0 = this.this$0.e0();
        if (e0 != null) {
            e0.setText("");
        }
        ((CoinViewModel) this.this$0.L()).r0().setValue(new ArrayList());
        ((CoinViewModel) this.this$0.L()).q0(i2);
        this.this$0.c0().h();
    }
}
