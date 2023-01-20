package com.jihuanshe.viewmodel.user;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GlobalConfig;
import com.jihuanshe.model.WarehouseInfo;
import com.vector.util.Res;
import e.g.d.a;
import e.l.h.l.b;
import e.l.n.c.k;
import e.l.r.o0;
import e.n.f;
import e.n.l;
import h.k2.v.f0;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class MineEntrepotViewModel extends b {
    @d
    private final f<CharSequence> b = new f<>(null, 1, null);
    @d

    /* renamed from: c  reason: collision with root package name */
    private final l f4569c = new l(0);
    @d

    /* renamed from: d  reason: collision with root package name */
    private final f<WarehouseInfo> f4570d = new f<>(null, 1, null);

    @d
    public final l p0() {
        return this.f4569c;
    }

    @e
    public final String q0() {
        GlobalConfig u = o0.f14291c.u();
        if (u == null) {
            return null;
        }
        return u.getWarehouseSellerNotice();
    }

    @d
    public final f<WarehouseInfo> r0() {
        return this.f4570d;
    }

    public final boolean s0() {
        return e.l.m.b.f14084c.y();
    }

    @d
    public final f<CharSequence> t0() {
        return this.b;
    }

    @d
    public final a<WarehouseInfo> u0() {
        return a.h(a.j(FlowKt.c(k.a.i((k) e.l.n.a.d(k.class, true, false, false, 60L, true), null, null, 3, null)), null, new MineEntrepotViewModel$getWarehouseInfo$1(this), 1, null), ViewModelKt.getViewModelScope(this), null, 2, null);
    }

    public final void v0(@d List<Game> list) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("集换仓目前仅支持");
        for (Game game : list) {
            Integer warehouse = game.getWarehouse();
            if (warehouse != null && warehouse.intValue() == 1) {
                spannableStringBuilder.append(f0.C(game.getShortName(), "、"), new ForegroundColorSpan(Res.k(R.color.price_red)), 33);
            }
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        spannableStringBuilder.append((CharSequence) "的卡牌寄售，其他品类的寄售功能敬请期待。");
        this.b.setValue(spannableStringBuilder);
    }
}
