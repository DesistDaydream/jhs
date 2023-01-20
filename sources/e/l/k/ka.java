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
import com.jihuanshe.adapter.FansAdapter;
import com.jihuanshe.model.User;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ka extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13014c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13015d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public FansAdapter f13016e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public User f13017f;

    public ka(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13014c = textView2;
        this.f13015d = textView3;
    }

    public static ka a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ka b(@NonNull View view, @Nullable Object obj) {
        return (ka) ViewDataBinding.bind(obj, view, R.layout.item_fans);
    }

    @NonNull
    public static ka e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ka f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ka g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ka) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fans, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ka h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ka) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_fans, null, false, obj);
    }

    @Nullable
    public User c() {
        return this.f13017f;
    }

    @Nullable
    public FansAdapter d() {
        return this.f13016e;
    }

    public abstract void i(@Nullable User user);

    public abstract void j(@Nullable FansAdapter fansAdapter);
}
