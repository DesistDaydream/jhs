package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.detail.ReviewListActivity;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;

/* loaded from: classes2.dex */
public abstract class ag extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @Bindable
    public ReviewListActivity b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public ReviewListViewModel f12304c;

    public ag(Object obj, View view, int i2, TextView textView) {
        super(obj, view, i2);
        this.a = textView;
    }

    public static ag a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ag b(@NonNull View view, @Nullable Object obj) {
        return (ag) ViewDataBinding.bind(obj, view, R.layout.view_header_review_list);
    }

    @NonNull
    public static ag e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ag f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ag g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ag) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_review_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ag h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ag) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_review_list, null, false, obj);
    }

    @Nullable
    public ReviewListActivity c() {
        return this.b;
    }

    @Nullable
    public ReviewListViewModel d() {
        return this.f12304c;
    }

    public abstract void i(@Nullable ReviewListActivity reviewListActivity);

    public abstract void j(@Nullable ReviewListViewModel reviewListViewModel);
}
