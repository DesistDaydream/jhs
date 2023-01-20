package e.l.s.o.c;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.model.UpdateUserInfoResult;
import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.UploadViewModel;
import e.l.n.c.i;
import e.n.f;
import e.n.p;
import e.t.u.t;
import h.k2.v.f0;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class a extends UploadViewModel {
    @d

    /* renamed from: d */
    private final f<User> f14352d = new f<>(null, 1, null);
    @d

    /* renamed from: e */
    private final p f14353e = new p(f0.C("Copyright © 2020-2022 集换社 v", t.a.e()));

    public static /* synthetic */ e.g.d.a C0(a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = null;
        }
        if ((i2 & 2) != 0) {
            str2 = null;
        }
        if ((i2 & 4) != 0) {
            str3 = null;
        }
        if ((i2 & 8) != 0) {
            str4 = null;
        }
        if ((i2 & 16) != 0) {
            str5 = null;
        }
        if ((i2 & 32) != 0) {
            str6 = null;
        }
        if ((i2 & 64) != 0) {
            str7 = null;
        }
        if ((i2 & 128) != 0) {
            str8 = null;
        }
        return aVar.B0(str, str2, str3, str4, str5, str6, str7, str8);
    }

    @d
    public final f<User> A0() {
        return this.f14352d;
    }

    @d
    public final e.g.d.a<UpdateUserInfoResult> B0(@e String str, @e String str2, @e String str3, @e String str4, @e String str5, @e String str6, @e String str7, @e String str8) {
        return e.g.d.a.h(FlowKt.c(i.a.b((i) e.l.n.a.d(i.class, true, false, false, 60L, true), str, str2, str3, str4, str5, str6, str7, str8, null, 256, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final p z0() {
        return this.f14353e;
    }
}
