package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.caverock.androidsvg.SVG;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.ShopCartItem;
import com.jihuanshe.ui.page.user.ShopCarActivity;
import com.jihuanshe.ui.widget.CardImageView;
import com.vector.network.image.NImageView;
import java.util.List;

/* loaded from: classes2.dex */
public class fd extends ed {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o = null;
    @Nullable
    private static final SparseIntArray p;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f12654j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final TextView f12655k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f12656l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f12657m;
    private long n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.rightIv, 9);
        sparseIntArray.put(R.id.divider, 10);
    }

    public fd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, o, p));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        e.t.j.h.g gVar;
        String str2;
        String str3;
        String str4;
        Game game;
        Game game2;
        String str5;
        String str6;
        Game game3;
        String str7;
        e.t.r.a.a aVar;
        boolean z;
        boolean z2;
        boolean z3;
        int i2;
        int i3;
        String str8;
        List<CardProduct> list;
        Game game4;
        String str9;
        Game game5;
        String str10;
        String str11;
        Integer num;
        synchronized (this) {
            j2 = this.n;
            this.n = 0L;
        }
        ShopCartItem shopCartItem = this.f12593i;
        ShopCarActivity shopCarActivity = this.f12592h;
        List<CardProduct> list2 = null;
        if ((j2 & 7) != 0) {
            int i4 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
            if (i4 != 0) {
                if (shopCartItem != null) {
                    str4 = shopCartItem.getSellerName();
                    list = shopCartItem.getCarts();
                    game4 = shopCartItem.getGame(2);
                    str9 = shopCartItem.getAllName();
                    game5 = shopCartItem.getGame(1);
                    game = shopCartItem.getGame(0);
                    num = shopCartItem.getCartCount();
                    str10 = shopCartItem.getCartCover(2);
                    str11 = shopCartItem.getCartCover(1);
                    str5 = shopCartItem.getCartCover(0);
                } else {
                    str4 = null;
                    list = null;
                    game4 = null;
                    str9 = null;
                    game5 = null;
                    game = null;
                    num = null;
                    str10 = null;
                    str11 = null;
                    str5 = null;
                }
                z = list == null;
                str8 = this.f12657m.getResources().getString(R.string.shop_product_num, num);
                if (i4 != 0) {
                    j2 = z ? j2 | 16 | 64 | 4096 : j2 | 8 | 32 | 2048;
                }
            } else {
                str8 = null;
                str4 = null;
                list = null;
                game4 = null;
                str9 = null;
                game5 = null;
                game = null;
                str10 = null;
                str11 = null;
                str5 = null;
                z = false;
            }
            String sellerAvatar = shopCartItem != null ? shopCartItem.getSellerAvatar() : null;
            if (shopCarActivity != null) {
                e.t.r.a.a e0 = shopCarActivity.e0();
                e.t.j.h.g W = shopCarActivity.W(shopCartItem);
                str7 = sellerAvatar;
                aVar = e0;
                game2 = game4;
                game3 = game5;
                str3 = str10;
                str6 = str11;
                str2 = str8;
                list2 = list;
                gVar = W;
                str = str9;
            } else {
                str7 = sellerAvatar;
                aVar = null;
                game2 = game4;
                str = str9;
                game3 = game5;
                str3 = str10;
                str6 = str11;
                str2 = str8;
                gVar = null;
                list2 = list;
            }
        } else {
            str = null;
            gVar = null;
            str2 = null;
            str3 = null;
            str4 = null;
            game = null;
            game2 = null;
            str5 = null;
            str6 = null;
            game3 = null;
            str7 = null;
            aVar = null;
            z = false;
        }
        if ((j2 & 2080) != 0) {
            int size = list2 != null ? list2.size() : 0;
            z3 = (j2 & 32) != 0 && size < 2;
            z2 = (2048 & j2) != 0 && size < 3;
        } else {
            z2 = false;
            z3 = false;
        }
        boolean isEmpty = ((j2 & 8) == 0 || list2 == null) ? false : list2.isEmpty();
        int i5 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i5 != 0) {
            if (z) {
                isEmpty = true;
            }
            if (z) {
                z3 = true;
            }
            boolean z4 = z ? true : z2;
            if (i5 != 0) {
                j2 |= isEmpty ? 16384L : SVG.A;
            }
            if ((j2 & 5) != 0) {
                j2 |= z3 ? 1024L : 512L;
            }
            if ((j2 & 5) != 0) {
                j2 |= z4 ? 256L : 128L;
            }
            int i6 = isEmpty ? 4 : 0;
            i3 = z3 ? 4 : 0;
            i2 = z4 ? 4 : 0;
            r11 = i6;
        } else {
            i2 = 0;
            i3 = 0;
        }
        if ((7 & j2) != 0) {
            e.t.j.g.y.a(this.a, str7, null, null, null, null, null, null, null, null, null, aVar, null, null, null, null, null);
            e.t.j.g.e0.F(this.f12589e, gVar);
        }
        if ((j2 & 5) != 0) {
            this.b.setVisibility(r11);
            CardImageView cardImageView = this.b;
            e.l.i.e.b(cardImageView, str5, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            this.f12587c.setVisibility(i3);
            CardImageView cardImageView2 = this.f12587c;
            e.l.i.e.b(cardImageView2, str6, null, AppCompatResources.getDrawable(cardImageView2.getContext(), R.drawable.bg_err_image), game3, null, null, null);
            this.f12588d.setVisibility(i2);
            CardImageView cardImageView3 = this.f12588d;
            e.l.i.e.b(cardImageView3, null, null, AppCompatResources.getDrawable(cardImageView3.getContext(), R.drawable.bg_err_image), game2, null, null, null);
            e.t.j.g.y.a(this.f12588d, str3, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setText(this.f12655k, str4);
            TextViewBindingAdapter.setText(this.f12656l, str);
            TextViewBindingAdapter.setText(this.f12657m, str2);
        }
    }

    @Override // e.l.k.ed
    public void h(@Nullable ShopCarActivity shopCarActivity) {
        this.f12592h = shopCarActivity;
        synchronized (this) {
            this.n |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // e.l.k.ed
    public void i(@Nullable ShopCartItem shopCartItem) {
        this.f12593i = shopCartItem;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((ShopCartItem) obj);
            return true;
        } else if (1 == i2) {
            h((ShopCarActivity) obj);
            return true;
        } else {
            return false;
        }
    }

    private fd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (CardImageView) objArr[4], (CardImageView) objArr[5], (CardImageView) objArr[6], (ImageView) objArr[3], (View) objArr[10], (ImageView) objArr[9]);
        this.n = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12587c.setTag(null);
        this.f12588d.setTag(null);
        this.f12589e.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12654j = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12655k = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.f12656l = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[8];
        this.f12657m = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
