package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.CountDownTextView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class s2 extends ViewDataBinding {
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final CountDownTextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f13542c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final NImageView f13543d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f13544e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f13545f;

    public s2(Object obj, View view, int i2, FrameLayout frameLayout, CountDownTextView countDownTextView, ConstraintLayout constraintLayout, NImageView nImageView, FrameLayout frameLayout2, LinearLayout linearLayout) {
        super(obj, view, i2);
        this.a = frameLayout;
        this.b = countDownTextView;
        this.f13542c = constraintLayout;
        this.f13543d = nImageView;
        this.f13544e = frameLayout2;
        this.f13545f = linearLayout;
    }

    public static s2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s2 b(@NonNull View view, @Nullable Object obj) {
        return (s2) ViewDataBinding.bind(obj, view, R.layout.activity_splash);
    }

    @NonNull
    public static s2 c(@NonNull LayoutInflater layoutInflater) {
        return f(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s2 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return e(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s2 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_splash, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s2 f(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_splash, null, false, obj);
    }
}
