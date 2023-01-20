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
import com.jihuanshe.model.User;
import com.jihuanshe.ui.widget.RankImageView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ma extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RankImageView f13126c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13127d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13128e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public e.l.g.w f13129f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public User f13130g;

    public ma(Object obj, View view, int i2, NImageView nImageView, TextView textView, RankImageView rankImageView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13126c = rankImageView;
        this.f13127d = textView2;
        this.f13128e = textView3;
    }

    public static ma a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ma b(@NonNull View view, @Nullable Object obj) {
        return (ma) ViewDataBinding.bind(obj, view, R.layout.item_follow);
    }

    @NonNull
    public static ma e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ma f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ma g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ma) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_follow, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ma h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ma) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_follow, null, false, obj);
    }

    @Nullable
    public User c() {
        return this.f13130g;
    }

    @Nullable
    public e.l.g.w d() {
        return this.f13129f;
    }

    public abstract void i(@Nullable User user);

    public abstract void j(@Nullable e.l.g.w wVar);
}
