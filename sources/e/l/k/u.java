package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.detail.CardPackListActivity;
import com.jihuanshe.viewmodel.detail.CardPackListViewModel;
import com.vector.network.image.NImageView;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class u extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final NImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ListView f13654c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f13655d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13656e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13657f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13658g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13659h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13660i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f13661j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public CardPackListActivity f13662k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public CardPackListViewModel f13663l;

    public u(Object obj, View view, int i2, ConstraintLayout constraintLayout, NImageView nImageView, ListView listView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = nImageView;
        this.f13654c = listView;
        this.f13655d = linearLayout;
        this.f13656e = textView;
        this.f13657f = textView2;
        this.f13658g = textView3;
        this.f13659h = textView4;
        this.f13660i = textView5;
        this.f13661j = textView6;
    }

    public static u a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static u b(@NonNull View view, @Nullable Object obj) {
        return (u) ViewDataBinding.bind(obj, view, R.layout.activity_card_pack_list);
    }

    @NonNull
    public static u e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static u f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static u g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (u) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_card_pack_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static u h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (u) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_card_pack_list, null, false, obj);
    }

    @Nullable
    public CardPackListActivity c() {
        return this.f13662k;
    }

    @Nullable
    public CardPackListViewModel d() {
        return this.f13663l;
    }

    public abstract void i(@Nullable CardPackListActivity cardPackListActivity);

    public abstract void j(@Nullable CardPackListViewModel cardPackListViewModel);
}
