package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.entrepot.ApplyForActivity;
import com.jihuanshe.viewmodel.entrepot.ApplyForViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class o0 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @NonNull
    public final ImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13231c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13232d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public ApplyForActivity f13233e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public ApplyForViewModel f13234f;

    public o0(Object obj, View view, int i2, ListView listView, ImageView imageView, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.a = listView;
        this.b = imageView;
        this.f13231c = textView;
        this.f13232d = textView2;
    }

    public static o0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static o0 b(@NonNull View view, @Nullable Object obj) {
        return (o0) ViewDataBinding.bind(obj, view, R.layout.activity_entrepot_apply_for);
    }

    @NonNull
    public static o0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static o0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static o0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (o0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_entrepot_apply_for, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static o0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (o0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_entrepot_apply_for, null, false, obj);
    }

    @Nullable
    public ApplyForActivity c() {
        return this.f13233e;
    }

    @Nullable
    public ApplyForViewModel d() {
        return this.f13234f;
    }

    public abstract void i(@Nullable ApplyForActivity applyForActivity);

    public abstract void j(@Nullable ApplyForViewModel applyForViewModel);
}
