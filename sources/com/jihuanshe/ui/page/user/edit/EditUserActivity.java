package com.jihuanshe.ui.page.user.edit;

import android.content.Intent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.utils.ImagePicker;
import com.yalantis.ucrop.UCrop;
import e.l.h.d.f;
import e.l.h.k.b;
import e.l.k.m0;
import e.l.s.o.c.a;
import e.t.j.h.g;
import h.k2.v.u;
import i.b.b1;
import i.b.i;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class EditUserActivity extends BaseActivity<a> {
    @d
    private final e.t.r.a.a n = new e.t.r.a.a(0, 0, 3, null);
    @d
    private final ImagePicker o = new ImagePicker(this, 0, 0.0f, new EditUserActivity$imagePicker$1(this), 6, (u) null);
    @d
    private final g p;
    @d
    private final g q;
    @d
    private final g r;
    @d
    private final g s;
    @d
    private final g t;
    @f.a.a.a
    @e
    private User user;

    public EditUserActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.p = dVar.a(new EditUserActivity$onClickAvatar$1(this));
        this.q = dVar.a(new EditUserActivity$onEditPhone$1(this));
        this.r = dVar.a(new EditUserActivity$onLogoutClick$1(this));
        this.s = dVar.a(new EditUserActivity$onClickAddress$1(this));
        this.t = dVar.a(new EditUserActivity$onClickAddressManager$1(this));
    }

    public static /* synthetic */ g f0(EditUserActivity editUserActivity, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return editUserActivity.e0(str);
    }

    public static /* synthetic */ g h0(EditUserActivity editUserActivity, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return editUserActivity.g0(str);
    }

    public static /* synthetic */ g j0(EditUserActivity editUserActivity, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return editUserActivity.i0(str);
    }

    public static /* synthetic */ g l0(EditUserActivity editUserActivity, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = "";
        }
        return editUserActivity.k0(str);
    }

    @d
    public final g X() {
        return this.s;
    }

    @d
    public final g Y() {
        return this.t;
    }

    @d
    public final g Z() {
        return this.p;
    }

    @d
    public final g a0() {
        return this.q;
    }

    @d
    public final g b0() {
        return this.r;
    }

    @d
    public final e.t.r.a.a c0() {
        return this.n;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        ((a) L()).A0().r(this.user);
        f.b.e(this).g(e.l.j.a.B, new EditUserActivity$flowOfSetup$1(this));
    }

    @e
    public final User d0() {
        return this.user;
    }

    @d
    public final g e0(@e String str) {
        return e.t.j.h.d.a.a(new EditUserActivity$onClickBio$1(this, str));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, android.app.Activity
    public void finish() {
        f.b.c(e.l.j.a.f12239i, this.user);
        super.finish();
    }

    @d
    public final g g0(@e String str) {
        return e.t.j.h.d.a.a(new EditUserActivity$onClickFree$1(this, str));
    }

    @d
    public final g i0(@e String str) {
        return e.t.j.h.d.a.a(new EditUserActivity$onClickName$1(this, str));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        w().setBackgroundResource(R.color.white);
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(EditUserActivity$flowOfAppBar$1.INSTANCE);
    }

    @d
    public final g k0(@e String str) {
        return e.t.j.h.d.a.a(new EditUserActivity$onClickShipping$1(this, str));
    }

    public final void m0(@e User user) {
        this.user = user;
    }

    @Override // com.vector.design.ui.activity.ActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @e Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 69) {
            i.f(LifecycleOwnerKt.getLifecycleScope(this), b1.c(), null, new EditUserActivity$onActivityResult$1(intent, this, null), 2, null);
        } else if (i3 == 96) {
            Throwable error = UCrop.getError(intent);
            b bVar = b.a;
            String simpleName = EditUserActivity.class.getSimpleName();
            String message = error != null ? error.getMessage() : null;
            if (message == null) {
                message = "";
            }
            bVar.b(simpleName, message);
            e.l.h.j.b.e.h(this, "裁剪失败", null, null, null, 0, null, 62, null);
        }
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        m0 e2 = m0.e(getLayoutInflater());
        e2.i(this);
        e2.j((a) L());
        return e2;
    }
}
