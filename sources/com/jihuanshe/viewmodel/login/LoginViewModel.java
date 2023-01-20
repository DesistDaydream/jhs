package com.jihuanshe.viewmodel.login;

import android.net.Uri;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.model.UpdateUserInfoResult;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.login.LoginActivity;
import com.jihuanshe.viewmodel.UploadViewModel;
import e.g.d.a;
import e.l.n.c.i;
import e.l.n.c.k;
import e.l.r.r;
import e.n.f;
import e.n.i;
import e.n.l;
import e.n.p;
import h.t1;
import i.b.v3.h;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public class LoginViewModel extends UploadViewModel {

    /* renamed from: d */
    private final int f4463d = 120;
    @d

    /* renamed from: e */
    private final l f4464e = new l(Integer.valueOf(LoginActivity.H.k()));
    @d

    /* renamed from: f */
    private final p f4465f = new p(null, 1, null);
    @d

    /* renamed from: g */
    private final i f4466g;
    @d

    /* renamed from: h */
    private final p f4467h;
    @d

    /* renamed from: i */
    private final f<Uri> f4468i;
    @d

    /* renamed from: j */
    private final i f4469j;

    /* renamed from: k */
    private boolean f4470k;
    @e

    /* renamed from: l */
    private a<?> f4471l;

    public LoginViewModel() {
        Boolean bool = Boolean.FALSE;
        this.f4466g = new i(bool);
        this.f4467h = new p(null, 1, null);
        this.f4468i = new f<>(null, 1, null);
        this.f4469j = new i(bool);
    }

    public final void P0(User user, String str, boolean z, String str2) {
        r.a.g(str, z, user == null ? null : Boolean.valueOf(user.isNewUser()), str2);
    }

    public static /* synthetic */ void Q0(LoginViewModel loginViewModel, User user, String str, boolean z, String str2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stat");
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        loginViewModel.P0(user, str, z, str2);
    }

    @d
    public final a<t1> B0(@d String str, @d String str2, @e String str3) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).K(str, str2, str3)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<?> C0() {
        a<?> aVar = this.f4471l;
        if (aVar != null) {
            aVar.b();
        }
        a<?> h2 = a.h(a.j(FlowKt.c(h.N0(new LoginViewModel$countResend$1(this, null))), null, new LoginViewModel$countResend$2(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
        this.f4471l = h2;
        return h2;
    }

    @d
    public final f<Uri> D0() {
        return this.f4468i;
    }

    @d
    public final a<t1> E0(@d String str) {
        return a.h(FlowKt.c(((e.l.n.c.i) e.l.n.a.d(e.l.n.c.i.class, true, false, false, 60L, true)).h(str)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final p F0() {
        return this.f4465f;
    }

    @d
    public final i G0() {
        return this.f4466g;
    }

    @d
    public final p H0() {
        return this.f4467h;
    }

    @e
    public final a<?> I0() {
        return this.f4471l;
    }

    @d
    public final i J0() {
        return this.f4469j;
    }

    public final boolean K0() {
        return this.f4470k;
    }

    @e
    public final a<User> L0(@d String str) {
        if (this.f4470k) {
            return null;
        }
        this.f4470k = true;
        return a.h(a.o(a.j(FlowKt.c(h.F0(((e.l.n.c.i) e.l.n.a.d(e.l.n.c.i.class, true, false, false, 60L, true)).c(str), new LoginViewModel$login$1(this, null))), null, new LoginViewModel$login$2(this), 1, null), null, new LoginViewModel$login$3(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @e
    public final a<User> M0(@d String str, @d String str2) {
        if (this.f4470k) {
            return null;
        }
        this.f4470k = true;
        return a.h(a.o(a.j(FlowKt.c(h.F0(((e.l.n.c.i) e.l.n.a.d(e.l.n.c.i.class, true, false, false, 60L, true)).e(str, str2), new LoginViewModel$loginOrSignup$1(this, null))), null, new LoginViewModel$loginOrSignup$2(this), 1, null), null, new LoginViewModel$loginOrSignup$3(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final void N0(boolean z) {
        this.f4470k = z;
    }

    public final void O0(@e a<?> aVar) {
        this.f4471l = aVar;
    }

    @d
    public final a<UpdateUserInfoResult> R0(@d String str, @e String str2, @e String str3) {
        return a.h(FlowKt.c(i.a.b((e.l.n.c.i) e.l.n.a.d(e.l.n.c.i.class, true, false, false, 60L, true), str, null, null, null, null, null, null, str2, str3, 126, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final l getType() {
        return this.f4464e;
    }
}
