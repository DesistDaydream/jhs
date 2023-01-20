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
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.page.user.WantBuyActivity;

/* loaded from: classes2.dex */
public abstract class qd extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f13444c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f13445d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13446e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public WantBuyList f13447f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public WantBuyActivity f13448g;

    public qd(Object obj, View view, int i2, TextView textView, TextView textView2, ImageView imageView, ImageView imageView2, TextView textView3) {
        super(obj, view, i2);
        this.a = textView;
        this.b = textView2;
        this.f13444c = imageView;
        this.f13445d = imageView2;
        this.f13446e = textView3;
    }

    public static qd a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static qd b(@NonNull View view, @Nullable Object obj) {
        return (qd) ViewDataBinding.bind(obj, view, R.layout.item_want_buy_list);
    }

    @NonNull
    public static qd d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static qd e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static qd f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (qd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_want_buy_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static qd g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (qd) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_want_buy_list, null, false, obj);
    }

    @Nullable
    public WantBuyList c() {
        return this.f13447f;
    }

    @Nullable
    public WantBuyActivity getActivity() {
        return this.f13448g;
    }

    public abstract void h(@Nullable WantBuyActivity wantBuyActivity);

    public abstract void i(@Nullable WantBuyList wantBuyList);
}
