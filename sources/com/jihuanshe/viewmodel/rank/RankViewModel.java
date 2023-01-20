package com.jihuanshe.viewmodel.rank;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.RankTypeInfo;
import e.g.d.a;
import e.l.h.i.f;
import e.l.h.l.b;
import e.l.n.c.q;
import e.n.l;
import e.t.k.a.c.h.c;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class RankViewModel extends b {
    @d
    private final f b = new f();
    @d

    /* renamed from: c  reason: collision with root package name */
    private final e.n.f<List<RankTypeInfo>> f4506c = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final e.n.f<c> f4507d = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: e  reason: collision with root package name */
    private final e.n.f<RankTypeInfo> f4508e = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: f  reason: collision with root package name */
    private final e.n.f<Game> f4509f = new e.n.f<>(null, 1, null);
    @d

    /* renamed from: g  reason: collision with root package name */
    private final l f4510g = new l(0);
    @d

    /* renamed from: h  reason: collision with root package name */
    private final l f4511h = new l(null, 1, null);
    @d

    /* renamed from: i  reason: collision with root package name */
    private final l f4512i = new l(null, 1, null);
    @d

    /* renamed from: j  reason: collision with root package name */
    private final l f4513j = new l(null, 1, null);
    @d

    /* renamed from: k  reason: collision with root package name */
    private final l f4514k = new l(null, 1, null);

    @d
    public final a<List<RankTypeInfo>> A0() {
        return a.h(a.j(FlowKt.c(((q) e.l.n.a.d(q.class, true, false, false, 60L, true)).a()), null, new RankViewModel$rankTypeList$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    @d
    public final l p0() {
        return this.f4510g;
    }

    @d
    public final e.n.f<RankTypeInfo> q0() {
        return this.f4508e;
    }

    @d
    public final e.n.f<Game> r0() {
        return this.f4509f;
    }

    @d
    public final l s0() {
        return this.f4513j;
    }

    @d
    public final l t0() {
        return this.f4514k;
    }

    @d
    public final f u0() {
        return this.b;
    }

    @d
    public final e.n.f<c> v0() {
        return this.f4507d;
    }

    @d
    public final l w0() {
        return this.f4512i;
    }

    @d
    public final l x0() {
        return this.f4511h;
    }

    @d
    public final e.n.f<List<RankTypeInfo>> y0() {
        return this.f4506c;
    }

    public final void z0(int i2) {
        RankTypeInfo rankTypeInfo;
        e.n.f<RankTypeInfo> fVar = this.f4508e;
        List<RankTypeInfo> value = this.f4506c.getValue();
        String str = null;
        fVar.setValue(value == null ? null : value.get(i2));
        List<RankTypeInfo> value2 = this.f4506c.getValue();
        if (value2 != null && (rankTypeInfo = value2.get(i2)) != null) {
            str = rankTypeInfo.getTheme();
        }
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == 2041946) {
                if (str.equals("BLUE")) {
                    l lVar = this.f4511h;
                    Constants.Companion companion = Constants.Companion;
                    lVar.setValue(companion.getBLUE_THEME().get(0));
                    this.f4512i.setValue(companion.getBLUE_THEME().get(1));
                    this.f4513j.setValue(companion.getBLUE_THEME().get(2));
                    this.f4514k.setValue(companion.getBLUE_THEME().get(3));
                }
            } else if (hashCode == 63473942) {
                if (str.equals("BROWN")) {
                    l lVar2 = this.f4511h;
                    Constants.Companion companion2 = Constants.Companion;
                    lVar2.setValue(companion2.getBROWN_THEME().get(0));
                    this.f4512i.setValue(companion2.getBROWN_THEME().get(1));
                    this.f4513j.setValue(companion2.getBROWN_THEME().get(2));
                    this.f4514k.setValue(companion2.getBROWN_THEME().get(3));
                }
            } else if (hashCode == 68081379 && str.equals("GREEN")) {
                l lVar3 = this.f4511h;
                Constants.Companion companion3 = Constants.Companion;
                lVar3.setValue(companion3.getGREEN_THEME().get(0));
                this.f4512i.setValue(companion3.getGREEN_THEME().get(1));
                this.f4513j.setValue(companion3.getGREEN_THEME().get(2));
                this.f4514k.setValue(companion3.getGREEN_THEME().get(3));
            }
        }
    }
}
