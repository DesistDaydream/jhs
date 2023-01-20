package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.BaseUploadInfoDialog;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class w3 extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final EditText f13815c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f13816d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f13817e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f13818f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final NImageView f13819g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final NImageView f13820h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final NImageView f13821i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final LabelsView f13822j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f13823k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f13824l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f13825m;
    @Bindable
    public BaseUploadInfoDialog n;

    public w3(Object obj, View view, int i2, ConstraintLayout constraintLayout, LinearLayout linearLayout, EditText editText, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, NImageView nImageView, NImageView nImageView2, NImageView nImageView3, LabelsView labelsView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = linearLayout;
        this.f13815c = editText;
        this.f13816d = frameLayout;
        this.f13817e = frameLayout2;
        this.f13818f = frameLayout3;
        this.f13819g = nImageView;
        this.f13820h = nImageView2;
        this.f13821i = nImageView3;
        this.f13822j = labelsView;
        this.f13823k = textView;
        this.f13824l = textView2;
        this.f13825m = textView3;
    }

    public static w3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w3 b(@NonNull View view, @Nullable Object obj) {
        return (w3) ViewDataBinding.bind(obj, view, R.layout.dialog_card_error_correct);
    }

    @NonNull
    public static w3 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_card_error_correct, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w3 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_card_error_correct, null, false, obj);
    }

    @Nullable
    public BaseUploadInfoDialog c() {
        return this.n;
    }

    public abstract void h(@Nullable BaseUploadInfoDialog baseUploadInfoDialog);
}
