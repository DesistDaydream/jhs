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
import com.jihuanshe.model.CardPackage;

/* loaded from: classes2.dex */
public abstract class ob extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @Bindable
    public CardPackage b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public Integer f13269c;

    public ob(Object obj, View view, int i2, TextView textView) {
        super(obj, view, i2);
        this.a = textView;
    }

    public static ob a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ob b(@NonNull View view, @Nullable Object obj) {
        return (ob) ViewDataBinding.bind(obj, view, R.layout.item_pack);
    }

    @NonNull
    public static ob e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ob f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ob g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ob) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pack, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ob h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ob) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_pack, null, false, obj);
    }

    @Nullable
    public CardPackage c() {
        return this.b;
    }

    @Nullable
    public Integer d() {
        return this.f13269c;
    }

    public abstract void i(@Nullable CardPackage cardPackage);

    public abstract void j(@Nullable Integer num);
}
