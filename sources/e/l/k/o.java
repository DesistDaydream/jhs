package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.view.PreviewView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.camera.CaptureActivity;
import com.yalantis.ucrop.view.MOverlayView;

/* loaded from: classes2.dex */
public abstract class o extends ViewDataBinding {
    @NonNull
    public final MOverlayView a;
    @NonNull
    public final PreviewView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f13229c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public CaptureActivity f13230d;

    public o(Object obj, View view, int i2, MOverlayView mOverlayView, PreviewView previewView, ImageView imageView) {
        super(obj, view, i2);
        this.a = mOverlayView;
        this.b = previewView;
        this.f13229c = imageView;
    }

    public static o a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o b(@NonNull View view, @Nullable Object obj) {
        return (o) ViewDataBinding.bind(obj, view, R.layout.activity_capture);
    }

    @NonNull
    public static o d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_capture, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_capture, null, false, obj);
    }

    @Nullable
    public CaptureActivity c() {
        return this.f13230d;
    }

    public abstract void h(@Nullable CaptureActivity captureActivity);
}
