package e.l.k;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.caverock.androidsvg.SVG;
import com.jihuanshe.R;
import com.jihuanshe.model.GameCard;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class j9 extends i9 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o = null;
    @Nullable
    private static final SparseIntArray p = null;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final ConstraintLayout f12946l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f12947m;
    private long n;

    public j9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, o, p));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v3 */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        int i2;
        int i3;
        int i4;
        int i5;
        boolean z;
        Drawable drawable;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        CharSequence charSequence;
        int i6;
        int i7;
        int i8;
        int i9;
        Drawable drawable2;
        String str7;
        CharSequence charSequence2;
        int i10;
        String str8;
        Drawable drawable3;
        int i11;
        int i12;
        int i13;
        String str9;
        String str10;
        String str11;
        String str12;
        int i14;
        int i15;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        synchronized (this) {
            j2 = this.n;
            this.n = 0L;
        }
        GameCard gameCard = this.f12877j;
        e.t.r.a.h hVar = this.f12878k;
        if ((j2 & 7) != 0) {
            int i16 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
            if (i16 != 0) {
                if (gameCard != null) {
                    i15 = gameCard.getQuantity();
                    z = gameCard.isOnSale();
                    str9 = gameCard.getNwName();
                    str10 = gameCard.getSellerName();
                    int sellerId = gameCard.getSellerId();
                    z2 = gameCard.showLocationCity();
                    z3 = gameCard.isRealName();
                    z4 = gameCard.isSelling();
                    str11 = gameCard.getVer();
                    str12 = gameCard.getImage();
                    z5 = gameCard.isRealStore();
                    i14 = sellerId;
                } else {
                    i14 = 0;
                    i15 = 0;
                    z = false;
                    str9 = null;
                    str10 = null;
                    z2 = false;
                    z3 = false;
                    z4 = false;
                    str11 = null;
                    str12 = null;
                    z5 = false;
                }
                if (i16 != 0) {
                    j2 = z ? j2 | 1024 | 4096 : j2 | 512 | 2048;
                }
                if ((j2 & 5) != 0) {
                    j2 |= z2 ? 16384L : SVG.A;
                }
                if ((j2 & 5) != 0) {
                    j2 |= z3 ? 256L : 128L;
                }
                if ((j2 & 5) != 0) {
                    j2 = z4 ? j2 | 16 : j2 | 8;
                }
                if ((j2 & 5) != 0) {
                    j2 |= z5 ? 64L : 32L;
                }
                str8 = this.f12871d.getResources().getString(R.string.common_cache_number2, Integer.valueOf(i15));
                i11 = z ? 0 : 8;
                boolean z6 = i14 == 1000;
                int i17 = z2 ? 0 : 8;
                i13 = z3 ? 0 : 8;
                r22 = z5 ? 0 : 8;
                if ((j2 & 5) != 0) {
                    j2 |= z6 ? SVG.D : SVG.C;
                }
                drawable3 = AppCompatResources.getDrawable(this.f12946l.getContext(), z6 ? R.drawable.ripple_card_highlight : R.drawable.ripple_card);
                i12 = i17;
                i10 = r22;
                r22 = z4;
            } else {
                i10 = 0;
                str8 = null;
                drawable3 = null;
                i11 = 0;
                z = false;
                i12 = 0;
                i13 = 0;
                str9 = null;
                str10 = null;
                str11 = null;
                str12 = null;
            }
            if (gameCard != null) {
                str2 = gameCard.getSellerAvatar();
                str3 = str9;
                str4 = str10;
                str5 = str11;
                str6 = str12;
            } else {
                str3 = str9;
                str4 = str10;
                str5 = str11;
                str6 = str12;
                str2 = null;
            }
            int i18 = i11;
            i5 = i10;
            i2 = i12;
            drawable = drawable3;
            i4 = i13;
            str = str8;
            i3 = i18;
            r22 = r22;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            z = false;
            drawable = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
        }
        String locationCity = ((j2 & 16) == 0 || gameCard == null) ? null : gameCard.getLocationCity();
        CharSequence wishPrice = ((j2 & 2048) == 0 || gameCard == null) ? null : gameCard.getWishPrice();
        CharSequence minP = ((4096 & j2) == 0 || gameCard == null) ? null : gameCard.getMinP();
        String buyLocationCity = ((j2 & 8) == 0 || gameCard == null) ? null : gameCard.getBuyLocationCity();
        int i19 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i19 != 0) {
            if (r22 != 0) {
                buyLocationCity = locationCity;
            }
            if (z) {
                wishPrice = minP;
            }
            charSequence = wishPrice;
        } else {
            buyLocationCity = null;
            charSequence = null;
        }
        if ((j2 & 7) != 0) {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            drawable2 = drawable;
            str7 = str;
            i9 = i5;
            charSequence2 = charSequence;
            e.t.j.g.y.a(this.a, str2, null, null, null, null, null, null, null, null, null, hVar, null, null, null, null, null);
        } else {
            i6 = i2;
            i7 = i3;
            i8 = i4;
            i9 = i5;
            drawable2 = drawable;
            str7 = str;
            charSequence2 = charSequence;
        }
        if (i19 != 0) {
            NImageView nImageView = this.b;
            e.t.j.g.y.a(nImageView, str6, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, null, null, null, null);
            ViewBindingAdapter.setBackground(this.f12946l, drawable2);
            TextViewBindingAdapter.setText(this.f12947m, buyLocationCity);
            this.f12947m.setVisibility(i6);
            TextViewBindingAdapter.setText(this.f12870c, str3);
            this.f12871d.setVisibility(i7);
            TextViewBindingAdapter.setText(this.f12871d, str7);
            TextViewBindingAdapter.setText(this.f12872e, charSequence2);
            this.f12873f.setVisibility(i8);
            TextViewBindingAdapter.setText(this.f12874g, str4);
            this.f12875h.setVisibility(i9);
            TextViewBindingAdapter.setText(this.f12876i, str5);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // e.l.k.i9
    public void i(@Nullable GameCard gameCard) {
        this.f12877j = gameCard;
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

    @Override // e.l.k.i9
    public void j(@Nullable e.t.r.a.h hVar) {
        this.f12878k = hVar;
        synchronized (this) {
            this.n |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((GameCard) obj);
        } else if (17 != i2) {
            return false;
        } else {
            j((e.t.r.a.h) obj);
        }
        return true;
    }

    private j9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[5], (NImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[10], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[8], (TextView) objArr[4]);
        this.n = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12946l = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[9];
        this.f12947m = textView;
        textView.setTag(null);
        this.f12870c.setTag(null);
        this.f12871d.setTag(null);
        this.f12872e.setTag(null);
        this.f12873f.setTag(null);
        this.f12874g.setTag(null);
        this.f12875h.setTag(null);
        this.f12876i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
