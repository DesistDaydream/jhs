package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.exam.EtiquetteExamActivity;
import com.jihuanshe.ui.widget.exam.ExamIndicatorView;
import com.jihuanshe.ui.widget.exam.ExamQuizView;
import com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel;

/* loaded from: classes2.dex */
public abstract class s0 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ExamIndicatorView f13532c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13533d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ExamQuizView f13534e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f13535f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13536g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13537h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public EtiquetteExamActivity f13538i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public EtiquetteExamViewModel f13539j;

    public s0(Object obj, View view, int i2, TextView textView, ConstraintLayout constraintLayout, ExamIndicatorView examIndicatorView, TextView textView2, ExamQuizView examQuizView, LinearLayout linearLayout, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = textView;
        this.b = constraintLayout;
        this.f13532c = examIndicatorView;
        this.f13533d = textView2;
        this.f13534e = examQuizView;
        this.f13535f = linearLayout;
        this.f13536g = textView3;
        this.f13537h = textView4;
    }

    public static s0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s0 b(@NonNull View view, @Nullable Object obj) {
        return (s0) ViewDataBinding.bind(obj, view, R.layout.activity_etiquette_exam);
    }

    @NonNull
    public static s0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_etiquette_exam, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_etiquette_exam, null, false, obj);
    }

    @Nullable
    public EtiquetteExamActivity c() {
        return this.f13538i;
    }

    @Nullable
    public EtiquetteExamViewModel d() {
        return this.f13539j;
    }

    public abstract void i(@Nullable EtiquetteExamActivity etiquetteExamActivity);

    public abstract void j(@Nullable EtiquetteExamViewModel etiquetteExamViewModel);
}
