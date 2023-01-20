package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.vector.design.ui.adapter.RecyclerClickSupport;
import com.vector.util.LayoutManagers;
import com.vector.util.Res;
import e.l.g.r;
import e.l.h.j.b.f.b;
import e.t.o.d;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConditionView extends RecyclerView {
    @d
    private final r a;

    /* renamed from: com.jihuanshe.ui.widget.ConditionView$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<b, t1> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(b bVar) {
            invoke2(bVar);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d b bVar) {
            bVar.K(d.a.c(e.t.o.d.a, null, 1, null).d(9));
            bVar.x(R.color.transparent);
        }
    }

    @h
    public ConditionView(@k.e.a.d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ ConditionView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public final int getSelectCondition() {
        if (this.a.v() < 0) {
            return -1;
        }
        return this.a.v() + 1;
    }

    public final void setCondition(int i2) {
        if (i2 < 0) {
            return;
        }
        this.a.x(i2 - 1);
    }

    @h
    public ConditionView(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        r rVar = new r();
        this.a = rVar;
        setAdapter(rVar);
        Res res = Res.a;
        rVar.setData(CollectionsKt__CollectionsKt.P(Res.w(res, R.string.card_detail_condition_1, null, 2, null), Res.w(res, R.string.card_detail_condition_2, null, 2, null), Res.w(res, R.string.card_detail_condition_3, null, 2, null), Res.w(res, R.string.card_detail_condition_4, null, 2, null)));
        setLayoutManager(LayoutManagers.j(LayoutManagers.a, LayoutManagers.Orientation.HORIZONTAL, false, 2, null).create(context));
        addItemDecoration(b.o.a(AnonymousClass1.INSTANCE));
        setOverScrollMode(2);
        RecyclerClickSupport.f7735d.a(this).d(new ConditionView$2$1(this));
    }
}
