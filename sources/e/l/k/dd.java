package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.jihuanshe.adapter.ShopCarAdapter;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.page.user.SellerDetailActivity;
import com.jihuanshe.ui.widget.CardImageView;
import easyswipemenu.EasySwipeMenuLayout;
import java.util.List;

/* loaded from: classes2.dex */
public class dd extends cd {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts v = null;
    @Nullable
    private static final SparseIntArray w;
    @NonNull
    private final EasySwipeMenuLayout n;
    @NonNull
    private final ImageView o;
    @NonNull
    private final TextView p;
    @NonNull
    private final ImageView q;
    @NonNull
    private final TextView r;
    @NonNull
    private final TextView s;
    @NonNull
    private final TextView t;
    private long u;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        w = sparseIntArray;
        sparseIntArray.put(R.id.contentView, 16);
    }

    public dd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 17, v, w));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        Game game;
        String str8;
        CharSequence charSequence;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z;
        int i11;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        String str9;
        e.t.j.h.g gVar4;
        long j3;
        String str10;
        List<e.t.r.a.n.c> list;
        e.t.j.h.g gVar5;
        String str11;
        int i12;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        CharSequence charSequence2;
        int i13;
        int i14;
        String str19;
        Game game2;
        int i15;
        long j4;
        long j5;
        synchronized (this) {
            j2 = this.u;
            this.u = 0L;
        }
        CardProduct cardProduct = this.f12453l;
        SellerDetailActivity sellerDetailActivity = this.f12452k;
        ShopCarAdapter shopCarAdapter = this.f12454m;
        String str20 = null;
        if ((15 & j2) != 0) {
            int i16 = ((j2 & 9) > 0L ? 1 : ((j2 & 9) == 0L ? 0 : -1));
            if (i16 != 0) {
                if (cardProduct != null) {
                    str12 = cardProduct.getNwName();
                    str13 = cardProduct.getProductLan();
                    str14 = cardProduct.getLocation();
                    str15 = cardProduct.getVersionNum();
                    str16 = cardProduct.getConditionText();
                    str17 = cardProduct.getQuantityStr();
                    str18 = cardProduct.getRarity();
                    charSequence2 = cardProduct.getPrice();
                } else {
                    str12 = null;
                    str13 = null;
                    str14 = null;
                    str15 = null;
                    str16 = null;
                    str17 = null;
                    str18 = null;
                    charSequence2 = null;
                }
                boolean z2 = str13 == null;
                if (i16 != 0) {
                    j2 |= z2 ? SVG.G : SVG.F;
                }
                boolean isEmpty = str14 != null ? str14.isEmpty() : false;
                if ((j2 & 9) != 0) {
                    j2 |= isEmpty ? SVG.A : 4096L;
                }
                i14 = z2 ? 8 : 0;
                i13 = isEmpty ? 8 : 0;
            } else {
                str12 = null;
                str13 = null;
                str14 = null;
                str15 = null;
                str16 = null;
                str17 = null;
                str18 = null;
                charSequence2 = null;
                i13 = 0;
                i14 = 0;
            }
            if ((j2 & 13) != 0) {
                if (cardProduct != null) {
                    str19 = cardProduct.getImage();
                    game2 = cardProduct.getGame();
                    i15 = cardProduct.getProductStatus();
                } else {
                    str19 = null;
                    game2 = null;
                    i15 = 0;
                }
                z = i15 == 0;
                if ((j2 & 9) != 0) {
                    if (z) {
                        j4 = j2 | 32 | 128 | 512 | SVG.C | SVG.E | SVG.I | SVG.K | SVG.O;
                        j5 = SVG.Q;
                    } else {
                        j4 = j2 | 16 | 64 | 256 | 16384 | SVG.D | SVG.H | SVG.J | SVG.N;
                        j5 = SVG.P;
                    }
                    j2 = j4 | j5;
                }
                if ((j2 & 13) != 0) {
                    j2 = z ? j2 | 2048 | SVG.M : j2 | 1024 | SVG.L;
                }
                if ((j2 & 9) != 0) {
                    TextView textView = this.b;
                    i4 = z ? ViewDataBinding.getColorFromResource(textView, R.color.text_b5b5b7) : ViewDataBinding.getColorFromResource(textView, R.color.black_99999b);
                    TextView textView2 = this.f12448g;
                    int colorFromResource = z ? ViewDataBinding.getColorFromResource(textView2, R.color.text_b5b5b7) : ViewDataBinding.getColorFromResource(textView2, R.color.black);
                    i5 = z ? 8 : 0;
                    TextView textView3 = this.f12445d;
                    i7 = z ? ViewDataBinding.getColorFromResource(textView3, R.color.text_b5b5b7) : ViewDataBinding.getColorFromResource(textView3, R.color.black_99999b);
                    TextView textView4 = this.f12451j;
                    int colorFromResource2 = z ? ViewDataBinding.getColorFromResource(textView4, R.color.text_b5b5b7) : ViewDataBinding.getColorFromResource(textView4, R.color.black_99999b);
                    TextView textView5 = this.s;
                    i2 = z ? ViewDataBinding.getColorFromResource(textView5, R.color.text_b5b5b7) : ViewDataBinding.getColorFromResource(textView5, R.color.black_99999b);
                    int i17 = z ? 0 : 8;
                    i3 = z ? ViewDataBinding.getColorFromResource(this.t, R.color.text_b5b5b7) : ViewDataBinding.getColorFromResource(this.t, R.color.black_99999b);
                    i8 = colorFromResource2;
                    i6 = i17;
                    str8 = str15;
                    str = str18;
                    charSequence = charSequence2;
                    i11 = i14;
                    game = game2;
                    str5 = str13;
                    i10 = i13;
                    str3 = str19;
                    i9 = colorFromResource;
                    str4 = str16;
                    str7 = str14;
                    str6 = str12;
                    str2 = str17;
                } else {
                    str5 = str13;
                    str8 = str15;
                    str4 = str16;
                    str = str18;
                    charSequence = charSequence2;
                    i11 = i14;
                    str3 = str19;
                    game = game2;
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                    i7 = 0;
                    i8 = 0;
                }
            } else {
                str5 = str13;
                str3 = null;
                str8 = str15;
                str4 = str16;
                str = str18;
                charSequence = charSequence2;
                i11 = i14;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                i5 = 0;
                i6 = 0;
                i7 = 0;
                i8 = 0;
                z = false;
                game = null;
            }
            i10 = i13;
            str7 = str14;
            i9 = 0;
            str6 = str12;
            str2 = str17;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            game = null;
            str8 = null;
            charSequence = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
            i9 = 0;
            i10 = 0;
            z = false;
            i11 = 0;
        }
        int i18 = ((j2 & 11) > 0L ? 1 : ((j2 & 11) == 0L ? 0 : -1));
        if (i18 == 0 || sellerDetailActivity == null) {
            gVar = null;
            gVar2 = null;
            gVar3 = null;
        } else {
            e.t.j.h.g l1 = sellerDetailActivity.l1(cardProduct);
            e.t.j.h.g j1 = sellerDetailActivity.j1(cardProduct);
            gVar = sellerDetailActivity.o1(cardProduct);
            gVar2 = l1;
            gVar3 = j1;
        }
        int i19 = ((j2 & 13) > 0L ? 1 : ((j2 & 13) == 0L ? 0 : -1));
        if (i19 == 0 || shopCarAdapter == null) {
            str9 = str3;
            gVar4 = null;
            j3 = SVG.M;
        } else {
            e.t.j.h.g y = shopCarAdapter.y(str3);
            j3 = SVG.M;
            str9 = str3;
            gVar4 = y;
        }
        List<e.t.r.a.n.c> w2 = ((j2 & j3) == 0 || shopCarAdapter == null) ? null : shopCarAdapter.w();
        if (i19 != 0) {
            str10 = z ? str9 : null;
        } else {
            str10 = null;
        }
        if ((j2 & SVG.N) != 0) {
            if (cardProduct != null) {
                i12 = cardProduct.getProductQuantity();
                list = w2;
            } else {
                list = w2;
                i12 = 0;
            }
            gVar5 = gVar4;
            str11 = this.f12445d.getResources().getString(R.string.shop_stock, Integer.valueOf(i12));
        } else {
            list = w2;
            gVar5 = gVar4;
            str11 = null;
        }
        List<e.t.r.a.n.c> list2 = (i19 == 0 || !z) ? null : list;
        int i20 = ((j2 & 9) > 0L ? 1 : ((j2 & 9) == 0L ? 0 : -1));
        if (i20 != 0) {
            if (z) {
                str11 = this.f12445d.getResources().getString(R.string.card_removed);
            }
            str20 = str11;
        }
        String str21 = str20;
        if (i20 != 0) {
            this.a.setVisibility(i5);
            this.b.setTextColor(i4);
            TextViewBindingAdapter.setText(this.b, str4);
            TextViewBindingAdapter.setText(this.f12445d, str21);
            this.f12445d.setTextColor(i7);
            TextViewBindingAdapter.setText(this.p, str2);
            this.r.setVisibility(i6);
            this.s.setTextColor(i2);
            TextViewBindingAdapter.setText(this.s, str);
            this.t.setTextColor(i3);
            TextViewBindingAdapter.setText(this.t, str7);
            this.t.setVisibility(i10);
            TextViewBindingAdapter.setText(this.f12448g, str6);
            this.f12448g.setTextColor(i9);
            TextViewBindingAdapter.setText(this.f12449h, charSequence);
            TextViewBindingAdapter.setText(this.f12450i, str5);
            this.f12450i.setVisibility(i11);
            TextViewBindingAdapter.setText(this.f12451j, str8);
            this.f12451j.setTextColor(i8);
        }
        if (i18 != 0) {
            e.t.j.g.e0.F(this.f12446e, gVar);
            e.t.j.g.e0.F(this.o, gVar2);
            e.t.j.g.e0.F(this.q, gVar3);
            e.t.j.g.e0.F(this.r, gVar);
        }
        if (i19 != 0) {
            e.t.j.g.e0.F(this.f12447f, gVar5);
            CardImageView cardImageView = this.f12447f;
            e.l.i.e.b(cardImageView, str9, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, list2, str10, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.u != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.u = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.cd
    public void j(@Nullable ShopCarAdapter shopCarAdapter) {
        this.f12454m = shopCarAdapter;
        synchronized (this) {
            this.u |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // e.l.k.cd
    public void k(@Nullable CardProduct cardProduct) {
        this.f12453l = cardProduct;
        synchronized (this) {
            this.u |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.cd
    public void l(@Nullable SellerDetailActivity sellerDetailActivity) {
        this.f12452k = sellerDetailActivity;
        synchronized (this) {
            this.u |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            k((CardProduct) obj);
        } else if (10 == i2) {
            l((SellerDetailActivity) obj);
        } else if (2 != i2) {
            return false;
        } else {
            j((ShopCarAdapter) obj);
        }
        return true;
    }

    private dd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[10], (TextView) objArr[7], (ConstraintLayout) objArr[16], (TextView) objArr[9], (TextView) objArr[15], (CardImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[5]);
        this.u = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12445d.setTag(null);
        this.f12446e.setTag(null);
        this.f12447f.setTag(null);
        EasySwipeMenuLayout easySwipeMenuLayout = (EasySwipeMenuLayout) objArr[0];
        this.n = easySwipeMenuLayout;
        easySwipeMenuLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[11];
        this.o = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.p = textView;
        textView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[13];
        this.q = imageView2;
        imageView2.setTag(null);
        TextView textView2 = (TextView) objArr[14];
        this.r = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[6];
        this.s = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[8];
        this.t = textView4;
        textView4.setTag(null);
        this.f12448g.setTag(null);
        this.f12449h.setTag(null);
        this.f12450i.setTag(null);
        this.f12451j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
