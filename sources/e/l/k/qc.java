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
import com.jihuanshe.model.Product;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class qc extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final NImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13437c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13438d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13439e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f13440f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final View f13441g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final View f13442h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public Product f13443i;

    public qc(Object obj, View view, int i2, TextView textView, NImageView nImageView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView, View view2, View view3) {
        super(obj, view, i2);
        this.a = textView;
        this.b = nImageView;
        this.f13437c = textView2;
        this.f13438d = textView3;
        this.f13439e = textView4;
        this.f13440f = imageView;
        this.f13441g = view2;
        this.f13442h = view3;
    }

    public static qc a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static qc b(@NonNull View view, @Nullable Object obj) {
        return (qc) ViewDataBinding.bind(obj, view, R.layout.item_search_pack);
    }

    @NonNull
    public static qc d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static qc e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static qc f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (qc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_pack, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static qc g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (qc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_pack, null, false, obj);
    }

    @Nullable
    public Product c() {
        return this.f13443i;
    }

    public abstract void h(@Nullable Product product);
}
