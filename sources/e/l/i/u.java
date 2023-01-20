package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.model.EtiquetteQuestion;
import com.jihuanshe.ui.widget.exam.ExamQuizView;
import h.t1;

/* loaded from: classes2.dex */
public final class u {
    @k.e.a.d
    public static final u a = new u();
    @k.e.a.d
    private static final String b = "android:quiz_question";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12216c = "android:quiz_listener";

    private u() {
    }

    @BindingAdapter({b, f12216c})
    @h.k2.k
    public static final void a(@k.e.a.d ExamQuizView examQuizView, @k.e.a.e EtiquetteQuestion etiquetteQuestion, @k.e.a.e h.k2.u.l<? super Integer, t1> lVar) {
        if (etiquetteQuestion == null) {
            return;
        }
        examQuizView.setQuestion(etiquetteQuestion);
        examQuizView.setListener(lVar);
    }
}
