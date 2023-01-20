package com.jihuanshe.viewmodel.shop;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.eth.model.NLive;
import com.jihuanshe.model.BankDetail;
import com.jihuanshe.model.CityCodeSet;
import com.jihuanshe.model.ConfirmState;
import com.jihuanshe.model.UseBank;
import com.jihuanshe.model.VerifyInfo;
import com.jihuanshe.viewmodel.UploadViewModel;
import e.g.d.a;
import e.l.n.c.k;
import e.n.f;
import e.n.i;
import e.n.p;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public class SellerConfirmViewModel extends UploadViewModel {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final i f4554d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private f<String> f4555e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private f<String> f4556f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private f<CharSequence> f4557g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private f<List<String>> f4558h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final p f4559i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final f<BankDetail> f4560j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final i f4561k;
    @e

    /* renamed from: l  reason: collision with root package name */
    private CityCodeSet f4562l;
    @d

    /* renamed from: m  reason: collision with root package name */
    private final p f4563m;
    @d
    private final NLive<ConfirmState> n;
    @d
    private final NLive<UseBank> o;
    @d
    private final f<Bitmap> p;
    @d
    private final f<Integer> q;

    public SellerConfirmViewModel() {
        Boolean bool = Boolean.FALSE;
        this.f4554d = new i(bool);
        this.f4555e = new f<>(null, 1, null);
        this.f4556f = new f<>(null, 1, null);
        this.f4557g = new f<>(null, 1, null);
        this.f4558h = new f<>(null, 1, null);
        this.f4559i = new p(null, 1, null);
        this.f4560j = new f<>(null, 1, null);
        this.f4561k = new i(bool);
        this.f4563m = new p(null, 1, null);
        this.n = new NLive<>(null, 1, null);
        this.o = new NLive<>(null, 1, null);
        this.p = new f<>(null, 1, null);
        this.q = new f<>(0);
    }

    @d
    public final a<CityCodeSet> A0() {
        return a.h(a.j(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).J()), null, new SellerConfirmViewModel$fetchCityCode$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<VerifyInfo> B0(@d Context context) {
        return a.h(a.j(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).D()), null, new SellerConfirmViewModel$fetchVerifyInfo$1(this, context), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final f<String> C0() {
        return this.f4556f;
    }

    @d
    public final f<Integer> D0() {
        return this.q;
    }

    @d
    public final f<BankDetail> E0() {
        return this.f4560j;
    }

    @d
    public final f<List<String>> F0() {
        return this.f4558h;
    }

    @d
    public final p G0() {
        return this.f4559i;
    }

    @e
    public final CityCodeSet H0() {
        return this.f4562l;
    }

    @d
    public final f<String> I0() {
        return this.f4555e;
    }

    @d
    public final p J0() {
        return this.f4563m;
    }

    @d
    public final f<Bitmap> K0() {
        return this.p;
    }

    @d
    public final i L0() {
        return this.f4561k;
    }

    @d
    public final NLive<ConfirmState> M0() {
        return this.n;
    }

    @d
    public final f<CharSequence> N0() {
        return this.f4557g;
    }

    @d
    public final NLive<UseBank> O0() {
        return this.o;
    }

    @d
    public final i P0() {
        return this.f4554d;
    }

    @d
    public final a<ConfirmState> Q0() {
        return a.h(a.j(FlowKt.a(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).G(), this.n), null, new SellerConfirmViewModel$queryState$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<UseBank> R0() {
        return a.h(FlowKt.a(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).O(), this.o), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final a<t1> S0(@d String str, @d String str2, @d String str3, @d String str4, @d String str5, @d String str6, @d String str7, @d String str8, @e BankDetail bankDetail, @d String str9, @d String str10) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).N(str, str3, str4, str5, str2, str6, str7, str8, str9, bankDetail == null ? null : bankDetail.getName(), str10)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final void T0(@d f<String> fVar) {
        this.f4556f = fVar;
    }

    public final void U0(@d f<List<String>> fVar) {
        this.f4558h = fVar;
    }

    public final void V0(@e CityCodeSet cityCodeSet) {
        this.f4562l = cityCodeSet;
    }

    public final void W0(@d f<String> fVar) {
        this.f4555e = fVar;
    }

    public final void X0(@d f<CharSequence> fVar) {
        this.f4557g = fVar;
    }

    @d
    public final a<t1> z0(@d String str, @d String str2, @d String str3) {
        return a.h(FlowKt.c(((k) e.l.n.a.d(k.class, true, false, false, 60L, true)).Z(str, str2, null, null, str3)), ViewModelKt.getViewModelScope(this), null, 2, null);
    }
}
