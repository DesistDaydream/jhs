package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import e.l.k.a5;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class HomeWantSellDialog extends BaseDialog {
    @e
    private final Integer t;
    @e
    private final Integer u;
    @d
    private final g v;
    @d
    private final g w;
    @d
    private final g x;
    @d
    public static final a y = new a(null);
    private static final int z = 1;
    private static final int A = 2;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final int a() {
            return HomeWantSellDialog.A;
        }

        public final int b() {
            return HomeWantSellDialog.z;
        }
    }

    public /* synthetic */ HomeWantSellDialog(Context context, Integer num, Integer num2, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        a5 e2 = a5.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @Override // android.view.View
    @e
    public final Integer getId() {
        return this.u;
    }

    @d
    public final g getOnClickClose() {
        return this.v;
    }

    @d
    public final g getOnClickHouse() {
        return this.x;
    }

    @d
    public final g getOnClickSell() {
        return this.w;
    }

    @e
    public final Integer getType() {
        return this.t;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        super.k();
        setGravity(81);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }

    public HomeWantSellDialog(@d Context context, @e Integer num, @e Integer num2) {
        super(context);
        this.t = num;
        this.u = num2;
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.v = dVar.a(new HomeWantSellDialog$onClickClose$1(this));
        this.w = dVar.a(new HomeWantSellDialog$onClickSell$1(this, context));
        this.x = dVar.a(new HomeWantSellDialog$onClickHouse$1(context));
    }
}
