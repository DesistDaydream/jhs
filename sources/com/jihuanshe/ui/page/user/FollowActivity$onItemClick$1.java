package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.user.FollowViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FollowActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ FollowActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FollowActivity$onItemClick$1(FollowActivity followActivity) {
        super(2);
        this.this$0 = followActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<User> value = ((FollowViewModel) this.this$0.L()).q0().getValue();
        User user = value == null ? null : (User) CollectionsKt___CollectionsKt.J2(value, i2);
        if (user == null) {
            return;
        }
        this.this$0.h0(user);
    }
}
