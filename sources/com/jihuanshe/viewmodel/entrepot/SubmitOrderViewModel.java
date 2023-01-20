package com.jihuanshe.viewmodel.entrepot;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.ExpressList;
import com.jihuanshe.model.WareCache;
import com.jihuanshe.viewmodel.UploadViewModel;
import e.g.d.a;
import e.l.n.c.k;
import e.l.n.c.x;
import e.n.f;
import h.t1;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class SubmitOrderViewModel extends UploadViewModel {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f<List<String>> f4447d = new f<>(null, 1, null);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final f<WareCache> f4448e;

    public SubmitOrderViewModel() {
        WareCache x = UserKV.f3913c.x();
        this.f4448e = new f<>(x == null ? new WareCache(null, null, null, 7, null) : x);
    }

    public static /* synthetic */ a D0(SubmitOrderViewModel submitOrderViewModel, int i2, String str, String str2, String str3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return submitOrderViewModel.C0(i2, str, str2, str3);
    }

    @d
    public final a<ExpressList> A0() {
        return a.h(a.j(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).T()), null, new SubmitOrderViewModel$getExpressList$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final f<WareCache> B0() {
        return this.f4448e;
    }

    @d
    public final a<t1> C0(int i2, @d String str, @d String str2, @d String str3) {
        return a.h(FlowKt.c(x.a.e((x) e.l.n.a.d(x.class, true, false, false, 60L, true), i2, str, str2, str3, null, null, 48, null)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final f<List<String>> z0() {
        return this.f4447d;
    }
}
