package com.jihuanshe.viewmodel.main.me;

import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.User;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MeViewModel$refreshUser$1 extends Lambda implements l<User, t1> {
    public final /* synthetic */ MeViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MeViewModel$refreshUser$1(MeViewModel meViewModel) {
        super(1);
        this.this$0 = meViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(User user) {
        invoke2(user);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e User user) {
        this.this$0.s0().r(user);
        if (user == null) {
            return;
        }
        UserKV.f3913c.C(user);
    }
}
