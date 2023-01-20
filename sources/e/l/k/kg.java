package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.adapter.RarityAdapter;
import com.jihuanshe.model.Rarity;

/* loaded from: classes2.dex */
public abstract class kg extends ViewDataBinding {
    @Bindable
    public Rarity a;
    @Bindable
    public RarityAdapter b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public Integer f13029c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public Boolean f13030d;

    public kg(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static kg a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static kg b(@NonNull View view, @Nullable Object obj) {
        return (kg) ViewDataBinding.bind(obj, view, R.layout.view_rarity);
    }

    @NonNull
    public static kg g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static kg h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static kg i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (kg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_rarity, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static kg j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (kg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_rarity, null, false, obj);
    }

    @Nullable
    public Rarity c() {
        return this.a;
    }

    @Nullable
    public RarityAdapter d() {
        return this.b;
    }

    @Nullable
    public Integer e() {
        return this.f13029c;
    }

    @Nullable
    public Boolean f() {
        return this.f13030d;
    }

    public abstract void k(@Nullable Rarity rarity);

    public abstract void l(@Nullable RarityAdapter rarityAdapter);

    public abstract void m(@Nullable Integer num);

    public abstract void n(@Nullable Boolean bool);
}
