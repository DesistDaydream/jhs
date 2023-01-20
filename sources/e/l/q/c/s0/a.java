package e.l.q.c.s0;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.EtiquetteAnswer;
import com.jihuanshe.ui.widget.exam.ExamQuizView;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class a extends e.t.k.a.c.a<EtiquetteAnswer> {
    @d

    /* renamed from: d */
    private final ExamQuizView f14208d;

    /* renamed from: e */
    private int f14209e;

    public a(@d ExamQuizView examQuizView) {
        super(null, 1, null);
        this.f14208d = examQuizView;
        this.f14209e = -1;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_answer;
    }

    public final int v() {
        return this.f14209e;
    }

    @d
    public final ExamQuizView w() {
        return this.f14208d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: x */
    public void u(@d EtiquetteAnswer etiquetteAnswer, @d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, etiquetteAnswer);
        viewDataBinding.setVariable(7, String.valueOf((char) (j() + 65)));
        viewDataBinding.setVariable(15, Boolean.valueOf(j() == this.f14209e));
    }

    public final void y(int i2) {
        this.f14209e = i2;
    }
}
