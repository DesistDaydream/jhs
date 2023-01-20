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
import com.jihuanshe.model.SearchUser;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class uc extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13712c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13713d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13714e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public e.l.g.c1.b f13715f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public SearchUser f13716g;

    public uc(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13712c = textView2;
        this.f13713d = textView3;
        this.f13714e = textView4;
    }

    public static uc a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static uc b(@NonNull View view, @Nullable Object obj) {
        return (uc) ViewDataBinding.bind(obj, view, R.layout.item_search_user);
    }

    @NonNull
    public static uc e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static uc f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static uc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (uc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_user, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static uc h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (uc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_search_user, null, false, obj);
    }

    @Nullable
    public SearchUser c() {
        return this.f13716g;
    }

    @Nullable
    public e.l.g.c1.b d() {
        return this.f13715f;
    }

    public abstract void i(@Nullable SearchUser searchUser);

    public abstract void j(@Nullable e.l.g.c1.b bVar);
}
