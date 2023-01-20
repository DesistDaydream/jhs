package com.jihuanshe.ui.page.user.selling;

import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ui.BaseActivity;
import e.l.k.m2;
import e.l.s.o.d.a;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class SellingActivity extends BaseActivity<a> {
    @e
    private ImageView n;

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().b(new SellingActivity$flowOfAppBar$1(this));
        this.n = (ImageView) ((ViewGroup) w().getEnd().d(new SellingActivity$flowOfAppBar$2(this))).getChildAt(0);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        m2 e2 = m2.e(getLayoutInflater());
        e2.i(this);
        e2.j((a) L());
        return e2;
    }
}
