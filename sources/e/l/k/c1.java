package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.preview.ImagePreviewActivity;
import com.jihuanshe.ui.widget.imagepreview.wight.BezierBannerView;
import com.jihuanshe.ui.widget.imagepreview.wight.PhotoViewPager;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class c1 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final BezierBannerView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f12383c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12384d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12385e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12386f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final PhotoViewPager f12387g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public ImagePreviewActivity f12388h;

    public c1(Object obj, View view, int i2, NImageView nImageView, BezierBannerView bezierBannerView, ConstraintLayout constraintLayout, TextView textView, TextView textView2, TextView textView3, PhotoViewPager photoViewPager) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = bezierBannerView;
        this.f12383c = constraintLayout;
        this.f12384d = textView;
        this.f12385e = textView2;
        this.f12386f = textView3;
        this.f12387g = photoViewPager;
    }

    public static c1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c1 b(@NonNull View view, @Nullable Object obj) {
        return (c1) ViewDataBinding.bind(obj, view, R.layout.activity_image_preview);
    }

    @NonNull
    public static c1 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c1 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_image_preview, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c1 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_image_preview, null, false, obj);
    }

    @Nullable
    public ImagePreviewActivity c() {
        return this.f12388h;
    }

    public abstract void h(@Nullable ImagePreviewActivity imagePreviewActivity);
}
