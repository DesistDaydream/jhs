package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.photo.RecentPhotoFragment;
import com.jihuanshe.viewmodel.photo.RecentPhotoViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class i7 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @Bindable
    public RecentPhotoFragment b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public RecentPhotoViewModel f12861c;

    public i7(Object obj, View view, int i2, ListView listView) {
        super(obj, view, i2);
        this.a = listView;
    }

    public static i7 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i7 b(@NonNull View view, @Nullable Object obj) {
        return (i7) ViewDataBinding.bind(obj, view, R.layout.fragment_recent_photo);
    }

    @NonNull
    public static i7 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i7 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i7 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_recent_photo, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i7 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i7) ViewDataBinding.inflateInternal(layoutInflater, R.layout.fragment_recent_photo, null, false, obj);
    }

    @Nullable
    public RecentPhotoFragment c() {
        return this.b;
    }

    @Nullable
    public RecentPhotoViewModel d() {
        return this.f12861c;
    }

    public abstract void i(@Nullable RecentPhotoFragment recentPhotoFragment);

    public abstract void j(@Nullable RecentPhotoViewModel recentPhotoViewModel);
}
