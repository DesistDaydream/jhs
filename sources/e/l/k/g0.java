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
import com.jihuanshe.ui.page.entrepot.ConOrderDetailsActivity;
import com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class g0 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @NonNull
    public final ListView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ListView f12675c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12676d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12677e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12678f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12679g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12680h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12681i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12682j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f12683k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f12684l;
    @Bindable

    /* renamed from: m  reason: collision with root package name */
    public ConOrderDetailsActivity f12685m;
    @Bindable
    public ConOrderDetailsViewModel n;

    public g0(Object obj, View view, int i2, ListView listView, ListView listView2, ListView listView3, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9) {
        super(obj, view, i2);
        this.a = listView;
        this.b = listView2;
        this.f12675c = listView3;
        this.f12676d = textView;
        this.f12677e = textView2;
        this.f12678f = textView3;
        this.f12679g = textView4;
        this.f12680h = textView5;
        this.f12681i = textView6;
        this.f12682j = textView7;
        this.f12683k = textView8;
        this.f12684l = textView9;
    }

    public static g0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static g0 b(@NonNull View view, @Nullable Object obj) {
        return (g0) ViewDataBinding.bind(obj, view, R.layout.activity_con_order_details);
    }

    @NonNull
    public static g0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static g0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static g0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (g0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_con_order_details, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static g0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (g0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_con_order_details, null, false, obj);
    }

    @Nullable
    public ConOrderDetailsActivity c() {
        return this.f12685m;
    }

    @Nullable
    public ConOrderDetailsViewModel d() {
        return this.n;
    }

    public abstract void i(@Nullable ConOrderDetailsActivity conOrderDetailsActivity);

    public abstract void j(@Nullable ConOrderDetailsViewModel conOrderDetailsViewModel);
}
