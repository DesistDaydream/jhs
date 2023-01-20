package com.jihuanshe.utils;

import android.content.Intent;
import com.jihuanshe.R;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.main.MainActivityCreator;
import com.tencent.qcloud.tuicore.TUILogin;
import com.tencent.qcloud.tuicore.interfaces.TUICallback;
import com.tencent.qcloud.tuicore.interfaces.TUILoginListener;
import com.vector.util.Res;
import e.l.h.k.b;
import e.l.r.r;
import e.n.l;
import h.k2.v.f0;
import i.b.i;
import i.b.t1;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ImManager {
    @d
    private static final String b = "ImManager";

    /* renamed from: c */
    public static final int f4324c = 0;

    /* renamed from: d */
    public static final int f4325d = 1;

    /* renamed from: e */
    public static final int f4326e = 2;

    /* renamed from: f */
    public static final int f4327f = 3;

    /* renamed from: g */
    public static final int f4328g = 4;

    /* renamed from: h */
    public static final int f4329h = 5;

    /* renamed from: j */
    private static int f4331j;

    /* renamed from: k */
    private static int f4332k;

    /* renamed from: l */
    private static boolean f4333l;
    @d
    public static final ImManager a = new ImManager();
    @d

    /* renamed from: i */
    private static l f4330i = new l(0);

    /* loaded from: classes2.dex */
    public static final class a extends TUILoginListener {
        @Override // com.tencent.qcloud.tuicore.interfaces.TUILoginListener
        public void onConnectFailed(int i2, @e String str) {
            e.l.h.k.b bVar = e.l.h.k.b.a;
            bVar.b(ImManager.b, "im connect fail. code: " + i2 + ", reason: " + ((Object) str));
            if (i2 == 9512) {
                ImManager.a.h().setValue(5);
            }
        }

        @Override // com.tencent.qcloud.tuicore.interfaces.TUILoginListener
        public void onConnectSuccess() {
            e.l.h.k.b.a.d(ImManager.b, "onConnectSuccess");
            ImManager.a.h().setValue(1);
        }

        @Override // com.tencent.qcloud.tuicore.interfaces.TUILoginListener
        public void onConnecting() {
            e.l.h.k.b.a.d(ImManager.b, "onConnecting");
        }

        @Override // com.tencent.qcloud.tuicore.interfaces.TUILoginListener
        public void onKickedOffline() {
            e.l.h.k.b.a.d(ImManager.b, "onKickedOffline");
            ImManager.a.h().setValue(2);
        }

        @Override // com.tencent.qcloud.tuicore.interfaces.TUILoginListener
        public void onUserSigExpired() {
            e.l.h.k.b.a.d(ImManager.b, "onUserSigExpired");
            ImManager imManager = ImManager.a;
            imManager.h().setValue(0);
            imManager.l();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements TUICallback {
        @Override // com.tencent.qcloud.tuicore.interfaces.TUICallback
        public void onError(int i2, @e String str) {
            e.l.h.k.b bVar = e.l.h.k.b.a;
            bVar.g(ImManager.b, "tim login fail. code = " + i2 + ", msg = " + ((Object) str));
            ImManager imManager = ImManager.a;
            ImManager.f4331j = ImManager.f4331j + (-1);
            if (ImManager.f4331j >= 0) {
                imManager.i();
            } else {
                imManager.h().setValue(4);
            }
        }

        @Override // com.tencent.qcloud.tuicore.interfaces.TUICallback
        public void onSuccess() {
            ImManager.a.h().setValue(1);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements TUICallback {
        @Override // com.tencent.qcloud.tuicore.interfaces.TUICallback
        public void onError(int i2, @e String str) {
            e.l.h.k.b.a.g(ImManager.b, f0.C("logout fail, ", str));
            if (!TUILogin.isUserLogined()) {
                ImManager.a.m();
            } else {
                e.l.h.j.b.e.f(this, Res.w(Res.a, R.string.fail_logout, null, 2, null), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            }
            ImManager imManager = ImManager.a;
            ImManager.f4333l = false;
        }

        @Override // com.tencent.qcloud.tuicore.interfaces.TUICallback
        public void onSuccess() {
            ImManager.a.m();
            ImManager.f4333l = false;
        }
    }

    static {
        TUILogin.addLoginListener(new a());
        f4331j = 2;
        f4332k = 2;
    }

    private ImManager() {
    }

    public final void i() {
        UserKV userKV = UserKV.f3913c;
        User w = userKV.w();
        TUILogin.login(e.t.a.b(), 1400373046, String.valueOf(w == null ? null : Integer.valueOf(w.getId())), userKV.t(), new b());
    }

    public static /* synthetic */ void k(ImManager imManager, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        imManager.j(z);
    }

    public final void m() {
        f4330i.setValue(0);
        UserKV.f3913c.q();
        r.a.c();
        Intent newIntent = MainActivityCreator.newIntent(e.t.a.b(), null, null);
        newIntent.setFlags(268468224);
        e.t.a.b().startActivity(newIntent);
    }

    @d
    public final l h() {
        return f4330i;
    }

    public final void j(boolean z) {
        if (!z) {
            Integer value = f4330i.getValue();
            if (value != null && value.intValue() == 3) {
                return;
            }
            f4332k = 2;
            f4331j = 2;
            f4330i.setValue(3);
        }
        if (TUILogin.isUserLogined()) {
            TUILogin.logout(new TUICallback() { // from class: com.jihuanshe.utils.ImManager$loginTIM$1
                @Override // com.tencent.qcloud.tuicore.interfaces.TUICallback
                public void onError(int i2, @e String str) {
                    int i3;
                    int i4;
                    b bVar = b.a;
                    bVar.b("ImManager", "tim logout fail. " + i2 + ", " + ((Object) str));
                    if (!TUILogin.isUserLogined()) {
                        ImManager.a.i();
                        return;
                    }
                    ImManager imManager = ImManager.a;
                    i3 = ImManager.f4332k;
                    ImManager.f4332k = i3 - 1;
                    i4 = ImManager.f4332k;
                    if (i4 >= 0) {
                        i.f(t1.a, null, null, new ImManager$loginTIM$1$onError$1(null), 3, null);
                    } else {
                        imManager.h().setValue(4);
                    }
                }

                @Override // com.tencent.qcloud.tuicore.interfaces.TUICallback
                public void onSuccess() {
                    ImManager.a.i();
                }
            });
        } else {
            i();
        }
    }

    public final void l() {
        if (f4333l) {
            return;
        }
        f4333l = true;
        TUILogin.logout(new c());
    }

    public final void n(@d l lVar) {
        f4330i = lVar;
    }
}
