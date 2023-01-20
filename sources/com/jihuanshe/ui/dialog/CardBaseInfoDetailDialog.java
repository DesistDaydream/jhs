package com.jihuanshe.ui.dialog;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardBaseInfo;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.vector.network.image.NImageView;
import e.l.g.x0;
import e.l.k.q3;
import e.l.n.c.b;
import e.l.q.a.w;
import e.n.f;
import e.t.j.h.g;
import h.k2.v.u;
import h.z;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class CardBaseInfoDetailDialog extends w {
    @d

    /* renamed from: m  reason: collision with root package name */
    public static final a f3950m = new a(null);
    @e

    /* renamed from: e  reason: collision with root package name */
    private Integer f3951e;
    @e

    /* renamed from: f  reason: collision with root package name */
    private Integer f3952f;
    @e

    /* renamed from: g  reason: collision with root package name */
    private String f3953g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final h.w f3954h = z.c(new CardBaseInfoDetailDialog$game$2(this));
    @d

    /* renamed from: i  reason: collision with root package name */
    private final h.w f3955i = z.c(CardBaseInfoDetailDialog$starAdapter$2.INSTANCE);
    @d

    /* renamed from: j  reason: collision with root package name */
    private final f<CardBaseInfo> f3956j = new f<>(null, 1, null);
    @d

    /* renamed from: k  reason: collision with root package name */
    private final g f3957k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final g f3958l;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final CardBaseInfoDetailDialog a(int i2, int i3, @d String str) {
            CardBaseInfoDetailDialog cardBaseInfoDetailDialog = new CardBaseInfoDetailDialog();
            Bundle bundle = new Bundle();
            bundle.putInt(Constants.KEY_PARAM_CARD_ID, i2);
            bundle.putInt(Constants.KEY_PARAM_CARD_VERSION_ID, i3);
            bundle.putString(Constants.KEY_PARAM_GAME_KEY, str);
            cardBaseInfoDetailDialog.setArguments(bundle);
            return cardBaseInfoDetailDialog;
        }
    }

    public CardBaseInfoDetailDialog() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.f3957k = dVar.a(new CardBaseInfoDetailDialog$onClickClose$1(this));
        this.f3958l = dVar.a(new CardBaseInfoDetailDialog$onClickError$1(this));
    }

    @e
    public final Integer B() {
        return this.f3951e;
    }

    @d
    public final f<CardBaseInfo> C() {
        return this.f3956j;
    }

    @e
    public final Integer D() {
        return this.f3952f;
    }

    @e
    public final Game E() {
        return (Game) this.f3954h.getValue();
    }

    @e
    public final String F() {
        return this.f3953g;
    }

    @d
    public final g G() {
        return this.f3957k;
    }

    @d
    public final g H() {
        return this.f3958l;
    }

    @d
    public final x0 I() {
        return (x0) this.f3955i.getValue();
    }

    @d
    public final g J(@d NImageView nImageView) {
        return e.t.j.h.d.a.a(new CardBaseInfoDetailDialog$onClickPreview$1(this, nImageView));
    }

    public final void K(@e Integer num) {
        this.f3951e = num;
    }

    public final void L(@e Integer num) {
        this.f3952f = num;
    }

    public final void M(@e String str) {
        this.f3953g = str;
    }

    @Override // e.l.q.a.w
    public void d() {
        b bVar = (b) e.l.n.a.d(b.class, true, true, true, 60L, true);
        String str = this.f3953g;
        Integer num = this.f3952f;
        BinderKt.p(e.g.d.a.h(e.g.d.a.j(FlowKt.c(bVar.c(str, num == null ? 0 : num.intValue())), null, new CardBaseInfoDetailDialog$flowOfSetup$1(this), 1, null), LifecycleOwnerKt.getLifecycleScope(this), null, 2, null));
    }

    @Override // e.l.q.a.w
    @d
    public ViewDataBinding p(@e ViewGroup viewGroup) {
        q3 d2 = q3.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }

    @Override // e.l.q.a.w
    public int u() {
        return 80;
    }

    @Override // e.l.q.a.w
    public void y(@e Bundle bundle) {
        if (bundle == null) {
            dismiss();
            return;
        }
        this.f3951e = Integer.valueOf(bundle.getInt(Constants.KEY_PARAM_CARD_ID));
        this.f3952f = Integer.valueOf(bundle.getInt(Constants.KEY_PARAM_CARD_VERSION_ID));
        this.f3953g = bundle.getString(Constants.KEY_PARAM_GAME_KEY);
    }
}
