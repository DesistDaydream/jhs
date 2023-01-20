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
import com.jihuanshe.ui.page.shop.AddProductActivity;
import com.jihuanshe.ui.widget.MaxHeightRecyclerView;

/* loaded from: classes2.dex */
public abstract class i extends ViewDataBinding {
    @NonNull
    public final af a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f12820c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f12821d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final gg f12822e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ig f12823f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final MaxHeightRecyclerView f12824g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12825h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12826i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public AddProductActivity f12827j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public e.l.s.n.a f12828k;

    public i(Object obj, View view, int i2, af afVar, View view2, View view3, View view4, gg ggVar, ig igVar, MaxHeightRecyclerView maxHeightRecyclerView, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.a = afVar;
        this.b = view2;
        this.f12820c = view3;
        this.f12821d = view4;
        this.f12822e = ggVar;
        this.f12823f = igVar;
        this.f12824g = maxHeightRecyclerView;
        this.f12825h = textView;
        this.f12826i = textView2;
    }

    public static i a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i b(@NonNull View view, @Nullable Object obj) {
        return (i) ViewDataBinding.bind(obj, view, R.layout.activity_add_product);
    }

    @NonNull
    public static i e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_add_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_add_product, null, false, obj);
    }

    @Nullable
    public AddProductActivity c() {
        return this.f12827j;
    }

    @Nullable
    public e.l.s.n.a d() {
        return this.f12828k;
    }

    public abstract void i(@Nullable AddProductActivity addProductActivity);

    public abstract void j(@Nullable e.l.s.n.a aVar);
}
