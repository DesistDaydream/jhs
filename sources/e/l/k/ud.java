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
import com.jihuanshe.model.Product;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ud extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final NImageView f13717c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13718d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13719e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13720f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final View f13721g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final View f13722h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public Product f13723i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public e.l.g.b1 f13724j;

    public ud(Object obj, View view, int i2, TextView textView, TextView textView2, NImageView nImageView, TextView textView3, TextView textView4, TextView textView5, View view2, View view3) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f13717c = nImageView;
        this.f13718d = textView3;
        this.f13719e = textView4;
        this.f13720f = textView5;
        this.f13721g = view2;
        this.f13722h = view3;
    }

    public static ud a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ud b(@NonNull View view, @Nullable Object obj) {
        return (ud) ViewDataBinding.bind(obj, view, R.layout.item_wish_pack);
    }

    @NonNull
    public static ud e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ud f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ud g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ud) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_wish_pack, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ud h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ud) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_wish_pack, null, false, obj);
    }

    @Nullable
    public Product c() {
        return this.f13723i;
    }

    @Nullable
    public e.l.g.b1 d() {
        return this.f13724j;
    }

    public abstract void i(@Nullable Product product);

    public abstract void j(@Nullable e.l.g.b1 b1Var);
}
