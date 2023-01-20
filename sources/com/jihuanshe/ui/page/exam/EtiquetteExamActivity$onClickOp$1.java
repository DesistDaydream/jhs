package com.jihuanshe.ui.page.exam;

import android.view.View;
import android.widget.TextView;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel;
import com.vector.util.Res;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EtiquetteExamActivity$onClickOp$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ EtiquetteExamActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EtiquetteExamActivity$onClickOp$1(EtiquetteExamActivity etiquetteExamActivity) {
        super(1);
        this.this$0 = etiquetteExamActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            Res res = Res.a;
            if (f0.g(text, Res.w(res, R.string.etiquette_next, null, 2, null))) {
                ((EtiquetteExamViewModel) this.this$0.L()).B0();
            } else if (f0.g(text, Res.w(res, R.string.etiquette_commit, null, 2, null))) {
                ((EtiquetteExamViewModel) this.this$0.L()).s0().setValue(Integer.valueOf(((EtiquetteExamViewModel) this.this$0.L()).u0().size() + 1));
                BinderKt.p(BinderKt.k(((EtiquetteExamViewModel) this.this$0.L()).p0(), this.this$0, false, 2, null));
            } else if (f0.g(text, Res.w(res, R.string.etiquette_reanswer, null, 2, null))) {
                ((EtiquetteExamViewModel) this.this$0.L()).A0().setValue(1);
                ((EtiquetteExamViewModel) this.this$0.L()).s0().setValue(-1);
                ((EtiquetteExamViewModel) this.this$0.L()).B0();
            } else if (f0.g(text, Res.w(res, R.string.etiquette_back, null, 2, null))) {
                this.this$0.finish();
            }
        }
    }
}
