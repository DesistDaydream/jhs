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
import com.jihuanshe.ui.dialog.CardProductDialogFragment;
import com.jihuanshe.ui.widget.MaxHeightRecyclerView;
import com.jihuanshe.ui.widget.NumberView;

/* loaded from: classes2.dex */
public abstract class y4 extends ViewDataBinding {
    @NonNull
    public final NumberView a;
    @NonNull
    public final ImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f13950c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final gg f13951d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final MaxHeightRecyclerView f13952e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f13953f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f13954g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f13955h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public CardProductDialogFragment f13956i;

    public y4(Object obj, View view, int i2, NumberView numberView, ImageView imageView, View view2, gg ggVar, MaxHeightRecyclerView maxHeightRecyclerView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = numberView;
        this.b = imageView;
        this.f13950c = view2;
        this.f13951d = ggVar;
        this.f13952e = maxHeightRecyclerView;
        this.f13953f = textView;
        this.f13954g = textView2;
        this.f13955h = textView3;
    }

    public static y4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y4 b(@NonNull View view, @Nullable Object obj) {
        return (y4) ViewDataBinding.bind(obj, view, R.layout.dialog_fragment_card_product);
    }

    @NonNull
    public static y4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_fragment_card_product, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_fragment_card_product, null, false, obj);
    }

    @Nullable
    public CardProductDialogFragment c() {
        return this.f13956i;
    }

    public abstract void h(@Nullable CardProductDialogFragment cardProductDialogFragment);
}
