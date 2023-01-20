package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.user.FollowViewModel;
import e.g.d.a;
import e.l.h.i.e;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class FollowActivity$onClickSearch$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ FollowActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowActivity$onClickSearch$1(FollowActivity followActivity) {
        super(1);
        this.this$0 = followActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        this.this$0.i0(StringsKt__StringsKt.B5(this.this$0.Y().getText()).toString());
        FollowViewModel followViewModel = (FollowViewModel) this.this$0.L();
        Integer g0 = this.this$0.g0();
        a<e<User>> r0 = followViewModel.r0(g0 == null ? 0 : g0.intValue(), this.this$0.Z(), null);
        FollowActivity followActivity = this.this$0;
        BinderKt.p(BinderKt.k(BinderKt.e(r0, followActivity, followActivity.b0(), false, 4, null), this.this$0, false, 2, null));
    }
}
