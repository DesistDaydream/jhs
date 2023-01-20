package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.photo.ChoosePhotoActivity;

/* loaded from: classes2.dex */
public abstract class y extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final FrameLayout b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public ChoosePhotoActivity f13935c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public e.l.s.k.a f13936d;

    public y(Object obj, View view, int i2, LinearLayout linearLayout, FrameLayout frameLayout) {
        super(obj, view, i2);
        this.a = linearLayout;
        this.b = frameLayout;
    }

    public static y a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y b(@NonNull View view, @Nullable Object obj) {
        return (y) ViewDataBinding.bind(obj, view, R.layout.activity_choose_photo);
    }

    @NonNull
    public static y e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_choose_photo, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_choose_photo, null, false, obj);
    }

    @Nullable
    public ChoosePhotoActivity c() {
        return this.f13935c;
    }

    @Nullable
    public e.l.s.k.a d() {
        return this.f13936d;
    }

    public abstract void i(@Nullable ChoosePhotoActivity choosePhotoActivity);

    public abstract void j(@Nullable e.l.s.k.a aVar);
}
