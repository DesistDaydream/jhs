package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ShopCartItem;
import com.jihuanshe.ui.page.user.ShopCarActivity;
import com.jihuanshe.ui.widget.CardImageView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ed extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final CardImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CardImageView f12587c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CardImageView f12588d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f12589e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f12590f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f12591g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public ShopCarActivity f12592h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public ShopCartItem f12593i;

    public ed(Object obj, View view, int i2, NImageView nImageView, CardImageView cardImageView, CardImageView cardImageView2, CardImageView cardImageView3, ImageView imageView, View view2, ImageView imageView2) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = cardImageView;
        this.f12587c = cardImageView2;
        this.f12588d = cardImageView3;
        this.f12589e = imageView;
        this.f12590f = view2;
        this.f12591g = imageView2;
    }

    public static ed a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ed b(@NonNull View view, @Nullable Object obj) {
        return (ed) ViewDataBinding.bind(obj, view, R.layout.item_shop_cart);
    }

    @NonNull
    public static ed d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ed e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ed f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ed) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_shop_cart, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ed g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ed) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_shop_cart, null, false, obj);
    }

    @Nullable
    public ShopCartItem c() {
        return this.f12593i;
    }

    @Nullable
    public ShopCarActivity getActivity() {
        return this.f12592h;
    }

    public abstract void h(@Nullable ShopCarActivity shopCarActivity);

    public abstract void i(@Nullable ShopCartItem shopCartItem);
}
