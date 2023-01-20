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
public abstract class aa extends ViewDataBinding {
    @Bindable
    public e.l.g.r a;
    @Bindable
    public String b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public Integer f12283c;

    public aa(Object obj, View view, int i2) {
        super(obj, view, i2);
    }

    public static aa a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static aa b(@NonNull View view, @Nullable Object obj) {
        return (aa) ViewDataBinding.bind(obj, view, R.layout.item_condition);
    }

    @NonNull
    public static aa f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static aa g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static aa h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (aa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_condition, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static aa i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (aa) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_condition, null, false, obj);
    }

    @Nullable
    public String c() {
        return this.b;
    }

    @Nullable
    public e.l.g.r d() {
        return this.a;
    }

    @Nullable
    public Integer e() {
        return this.f12283c;
    }

    public abstract void j(@Nullable String str);

    public abstract void k(@Nullable e.l.g.r rVar);

    public abstract void l(@Nullable Integer num);
}
