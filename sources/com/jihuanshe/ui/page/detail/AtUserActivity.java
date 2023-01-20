package com.jihuanshe.ui.page.detail;

import android.content.Intent;
import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.user.FollowActivity;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.util.UIUtil;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class AtUserActivity extends FollowActivity {
    @d
    public static final String C = "at_user";
    @e
    private User y;
    @d
    private final h.m2.e z = BindViewKt.n(this, R.id.searchLayout);
    public static final /* synthetic */ n<Object>[] B = {n0.r(new PropertyReference1Impl(n0.d(AtUserActivity.class), "searchLayout", "getSearchLayout()Landroid/view/View;"))};
    @d
    public static final a A = new a(null);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    private final View k0() {
        return (View) this.z.a(this, B[0]);
    }

    @Override // com.jihuanshe.ui.page.user.FollowActivity, com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        ViewKt.I(k0());
        k0().setBackgroundColor(-1);
        k0().setPadding(0, UIUtil.c(), 0, 0);
        super.d();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, android.app.Activity
    public void finish() {
        if (this.y != null) {
            setResult(-1, new Intent().putExtra(C, this.y));
        } else {
            setResult(0);
        }
        super.finish();
    }

    @Override // com.jihuanshe.ui.page.user.FollowActivity
    public void h0(@d User user) {
        this.y = user;
        finish();
    }

    @Override // com.jihuanshe.ui.page.user.FollowActivity, com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
    }
}
