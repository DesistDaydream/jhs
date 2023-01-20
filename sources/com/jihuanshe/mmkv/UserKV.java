package com.jihuanshe.mmkv;

import com.eth.ext.FlowKt;
import com.jihuanshe.model.User;
import com.jihuanshe.model.WareCache;
import e.l.m.a;
import e.l.n.c.i;
import i.b.n0;
import i.b.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class UserKV extends a {
    @d

    /* renamed from: d  reason: collision with root package name */
    public static final String f3914d = "user";
    @d

    /* renamed from: e  reason: collision with root package name */
    public static final String f3915e = "token";
    @d

    /* renamed from: f  reason: collision with root package name */
    public static final String f3916f = "sig";
    @d

    /* renamed from: g  reason: collision with root package name */
    public static final String f3917g = "ware";

    /* renamed from: i  reason: collision with root package name */
    private static int f3919i;
    @e

    /* renamed from: j  reason: collision with root package name */
    private static String f3920j;
    @e

    /* renamed from: k  reason: collision with root package name */
    private static Boolean f3921k;
    @d

    /* renamed from: c  reason: collision with root package name */
    public static final UserKV f3913c = new UserKV();
    @d

    /* renamed from: h  reason: collision with root package name */
    private static String f3918h = "";

    private UserKV() {
    }

    public static /* synthetic */ e.g.d.a z(UserKV userKV, n0 n0Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            n0Var = t1.a;
        }
        return userKV.y(n0Var);
    }

    public final void A(@d String str) {
        o(f3916f, str);
    }

    public final void B(@d String str) {
        f3920j = str;
        o("token", str);
    }

    public final void C(@e User user) {
        f3921k = user == null ? null : user.getNeedExam();
        n(f3914d, user);
    }

    public final void D(boolean z) {
        f3921k = Boolean.valueOf(z);
        User w = w();
        if (w != null) {
            w.setNeedExam(Boolean.valueOf(z));
        }
        C(w);
    }

    public final void E(@e WareCache wareCache) {
        n(f3917g, wareCache);
    }

    @Override // e.l.m.a
    @d
    public String c() {
        return f3914d;
    }

    @Override // e.l.m.a
    public boolean j() {
        return true;
    }

    public final void q() {
        f3919i = 0;
        f3918h = "";
        f3921k = null;
        f3920j = null;
        a();
    }

    public final void r() {
        f().removeValueForKey(f3917g);
    }

    public final boolean s() {
        if (f3921k == null) {
            User w = w();
            f3921k = w == null ? null : w.getNeedExam();
        }
        Boolean bool = f3921k;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @d
    public final String t() {
        if (f3918h.length() == 0) {
            String i2 = i(f3916f, "");
            f3918h = i2 != null ? i2 : "";
        }
        return f3918h;
    }

    @d
    public final String u() {
        if (f3920j == null) {
            f3920j = i("token", "");
        }
        String str = f3920j;
        return str != null ? str : "";
    }

    public final int v() {
        if (f3919i == 0) {
            User w = w();
            f3919i = w == null ? 0 : w.getId();
        }
        return f3919i;
    }

    @e
    public final User w() {
        return (User) f().decodeParcelable(f3914d, User.class);
    }

    @e
    public final WareCache x() {
        return (WareCache) f().decodeParcelable(f3917g, WareCache.class);
    }

    @d
    public final e.g.d.a<User> y(@d n0 n0Var) {
        return e.g.d.a.h(e.g.d.a.j(FlowKt.c(i.a.a((i) e.l.n.a.d(i.class, true, false, false, 60L, true), null, 1, null)), null, UserKV$refreshUser$1.INSTANCE, 1, null), n0Var, null, 2, null);
    }
}
