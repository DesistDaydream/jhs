package com.jihuanshe.mmkv;

import com.jihuanshe.model.User;
import e.l.r.r;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class UserKV$refreshUser$1 extends Lambda implements l<User, t1> {
    public static final UserKV$refreshUser$1 INSTANCE = new UserKV$refreshUser$1();

    public UserKV$refreshUser$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(User user) {
        invoke2(user);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@e User user) {
        if (user == null) {
            return;
        }
        UserKV.f3913c.C(user);
        r.a.b();
    }
}
