package com.jihuanshe.ui.page.common.card;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.ConditionView;
import e.l.q.b.b.a.c;
import e.t.j.h.g;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class ConditionOpImpl implements c {
    @e
    private View a;
    @d
    private final g b = e.t.j.h.d.a.a(ConditionOpImpl$onClick$1.INSTANCE);

    public ConditionOpImpl(@d View view) {
        this.a = view;
    }

    private final ConditionView c() {
        View view = this.a;
        if (view == null) {
            return null;
        }
        return (ConditionView) view.findViewById(R.id.conditionView);
    }

    @Override // e.l.q.b.b.a.c
    @d
    public g a() {
        return this.b;
    }

    @Override // e.l.q.b.b.a.c
    public int b() {
        ConditionView c2 = c();
        if (c2 == null) {
            return -1;
        }
        return c2.getSelectCondition();
    }

    @d
    public final g d() {
        return this.b;
    }
}
