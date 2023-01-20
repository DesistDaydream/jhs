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
import com.jihuanshe.ui.dialog.BaseUploadInfoDialogFragment;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class c5 extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final EditText f12396c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f12397d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f12398e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f12399f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final NImageView f12400g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final NImageView f12401h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final NImageView f12402i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final LabelsView f12403j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f12404k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f12405l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f12406m;
    @Bindable
    public BaseUploadInfoDialogFragment n;

    public c5(Object obj, View view, int i2, ConstraintLayout constraintLayout, LinearLayout linearLayout, EditText editText, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, NImageView nImageView, NImageView nImageView2, NImageView nImageView3, LabelsView labelsView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = linearLayout;
        this.f12396c = editText;
        this.f12397d = frameLayout;
        this.f12398e = frameLayout2;
        this.f12399f = frameLayout3;
        this.f12400g = nImageView;
        this.f12401h = nImageView2;
        this.f12402i = nImageView3;
        this.f12403j = labelsView;
        this.f12404k = textView;
        this.f12405l = textView2;
        this.f12406m = textView3;
    }

    public static c5 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c5 b(@NonNull View view, @Nullable Object obj) {
        return (c5) ViewDataBinding.bind(obj, view, R.layout.dialog_info_upload);
    }

    @NonNull
    public static c5 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c5 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c5 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_info_upload, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c5 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c5) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_info_upload, null, false, obj);
    }

    @Nullable
    public BaseUploadInfoDialogFragment c() {
        return this.n;
    }

    public abstract void h(@Nullable BaseUploadInfoDialogFragment baseUploadInfoDialogFragment);
}
