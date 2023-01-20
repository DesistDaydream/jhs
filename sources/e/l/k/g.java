package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.shop.AddCardActivity;
import com.jihuanshe.viewmodel.shop.AddCardViewModel;

/* loaded from: classes2.dex */
public abstract class g extends ViewDataBinding {
    @NonNull
    public final RecyclerView a;
    @NonNull
    public final RecyclerView b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public AddCardActivity f12673c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public AddCardViewModel f12674d;

    public g(Object obj, View view, int i2, RecyclerView recyclerView, RecyclerView recyclerView2) {
        super(obj, view, i2);
        this.a = recyclerView;
        this.b = recyclerView2;
    }

    public static g a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g b(@NonNull View view, @Nullable Object obj) {
        return (g) ViewDataBinding.bind(obj, view, R.layout.activity_add_card);
    }

    @NonNull
    public static g e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_add_card, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_add_card, null, false, obj);
    }

    @Nullable
    public AddCardActivity c() {
        return this.f12673c;
    }

    @Nullable
    public AddCardViewModel d() {
        return this.f12674d;
    }

    public abstract void i(@Nullable AddCardActivity addCardActivity);

    public abstract void j(@Nullable AddCardViewModel addCardViewModel);
}
