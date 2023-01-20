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

/* loaded from: classes2.dex */
public abstract class kc extends ViewDataBinding {
    @Bindable
    public Boolean a;
    @Bindable
    public String b;

    public kc(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static kc a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static kc b(@NonNull View view, @Nullable Object obj) {
        return (kc) ViewDataBinding.bind(obj, view, R.layout.item_report_seller);
    }

    @NonNull
    public static kc e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static kc f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static kc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (kc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_report_seller, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static kc h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (kc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_report_seller, null, false, obj);
    }

    @Nullable
    public String c() {
        return this.b;
    }

    @Nullable
    public Boolean d() {
        return this.a;
    }

    public abstract void i(@Nullable String str);

    public abstract void j(@Nullable Boolean bool);
}
