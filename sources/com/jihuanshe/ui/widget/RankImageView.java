package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.jihuanshe.model.GlobalConfig;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import com.jihuanshe.ui.widget.RankImageView;
import e.l.r.o0;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class RankImageView extends AppCompatImageView {
    private boolean a;

    @h
    public RankImageView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ RankImageView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public static /* synthetic */ void B(RankImageView rankImageView, Context context, View view) {
        z(rankImageView, context, view);
    }

    public static final void z(RankImageView rankImageView, Context context, View view) {
        if (rankImageView.A()) {
            o0 o0Var = o0.f14291c;
            GlobalConfig u = o0Var.u();
            String creditRankIntro = u == null ? null : u.getCreditRankIntro();
            if (creditRankIntro == null || creditRankIntro.length() == 0) {
                return;
            }
            GlobalConfig u2 = o0Var.u();
            CommonWebViewActivityCreator.create(u2 != null ? u2.getCreditRankIntro() : null).start(context);
        }
    }

    public final boolean A() {
        return this.a;
    }

    public final void setOnClick(boolean z) {
        this.a = z;
    }

    @h
    public RankImageView(@d final Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        setOnClickListener(new View.OnClickListener() { // from class: e.l.q.c.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RankImageView.B(RankImageView.this, context, view);
            }
        });
    }
}
