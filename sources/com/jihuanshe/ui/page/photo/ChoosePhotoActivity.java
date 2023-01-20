package com.jihuanshe.ui.page.photo;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import androidx.core.view.ViewCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentTransaction;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.model.GameKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.utils.ImagePicker;
import e.l.k.y;
import e.l.s.k.a;
import e.t.j.h.g;
import e.t.u.a0;
import e.t.u.m;
import h.t1;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class ChoosePhotoActivity extends BaseActivity<a> {
    @f.a.a.a
    @e
    private String gameKey;
    private final int n = Color.parseColor("#222224");
    @d
    private final ImagePicker o = new ImagePicker(this, 1, GameKt.ratio(GameBar.b.a().getValue()), new ChoosePhotoActivity$imagePicker$1(this));
    @d
    private final g p;
    @d
    private final g q;
    @f.a.a.a
    @e
    private Integer versionId;

    public ChoosePhotoActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.p = dVar.a(new ChoosePhotoActivity$onClickTakePhoto$1(this));
        this.q = dVar.a(new ChoosePhotoActivity$onClickAlbum$1(this));
    }

    private final void b0() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.replace(R.id.fragmentContainer, RecentPhotoFragmentCreator.create(this.gameKey, this.versionId).get());
        beginTransaction.commitAllowingStateLoss();
    }

    @Override // com.jihuanshe.ui.BaseActivity
    public void V() {
        e.t.l.d.d(this, new m.a(this.n));
    }

    @e
    public final String X() {
        return this.gameKey;
    }

    @d
    public final g Y() {
        return this.q;
    }

    @d
    public final g Z() {
        return this.p;
    }

    @e
    public final Integer a0() {
        return this.versionId;
    }

    public final void c0(@e String str) {
        this.gameKey = str;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        a0.a.k(getWindow(), -1);
        b0();
    }

    public final void d0(@e Integer num) {
        this.versionId = num;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.d(w(), this, 0, null, 6, null);
        b(ViewCompat.MEASURED_STATE_MASK);
        w().setBackgroundColor(this.n);
    }

    @Override // com.vector.design.ui.activity.ActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 30 && i3 == -1) {
            String stringExtra = intent == null ? null : intent.getStringExtra("choose");
            if (stringExtra == null) {
                return;
            }
            if (stringExtra.length() > 0) {
                Intent intent2 = new Intent();
                intent2.putExtra("result", Uri.parse(stringExtra));
                t1 t1Var = t1.a;
                setResult(-1, intent2);
                finish();
            }
        }
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        y e2 = y.e(getLayoutInflater());
        e2.i(this);
        e2.j((a) L());
        return e2;
    }
}
