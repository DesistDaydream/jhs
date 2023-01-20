package e.l.k;

import android.graphics.drawable.Drawable;
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
import androidx.databinding.adapters.ViewBindingAdapter;
import com.caverock.androidsvg.SVG;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.RankImageView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class l9 extends k9 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o = null;
    @Nullable
    private static final SparseIntArray p = null;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final ConstraintLayout f13067l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f13068m;
    private long n;

    public l9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, o, p));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r21v2 */
    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        Drawable drawable;
        String str2;
        String str3;
        Integer num;
        String str4;
        Game game;
        String str5;
        e.t.r.a.a aVar;
        int i2;
        boolean z;
        int i3;
        int i4;
        String str6;
        String str7;
        String str8;
        Integer num2;
        int i5;
        boolean z2;
        int i6;
        boolean z3;
        boolean z4;
        synchronized (this) {
            j2 = this.n;
            this.n = 0L;
        }
        GameCard gameCard = this.f13012j;
        e.l.g.h hVar = this.f13011i;
        if ((j2 & 13) != 0) {
            int i7 = ((j2 & 9) > 0L ? 1 : ((j2 & 9) == 0L ? 0 : -1));
            if (i7 != 0) {
                if (gameCard != null) {
                    i6 = gameCard.getQuantity();
                    z = gameCard.isOnSale();
                    str7 = gameCard.getNwName();
                    str8 = gameCard.getSellerName();
                    int sellerId = gameCard.getSellerId();
                    boolean showLocationCity = gameCard.showLocationCity();
                    str4 = gameCard.getImg();
                    z3 = gameCard.isSelling();
                    game = gameCard.getGame();
                    num2 = gameCard.getCreditRankDrawable();
                    z4 = gameCard.isRealStore();
                    i5 = sellerId;
                    z2 = showLocationCity;
                } else {
                    str7 = null;
                    str8 = null;
                    str4 = null;
                    game = null;
                    num2 = null;
                    i5 = 0;
                    z2 = false;
                    i6 = 0;
                    z = false;
                    z3 = false;
                    z4 = false;
                }
                if (i7 != 0) {
                    j2 = z ? j2 | 512 | 2048 : j2 | 256 | 1024;
                }
                if ((j2 & 9) != 0) {
                    j2 |= z2 ? SVG.A : 4096L;
                }
                if ((j2 & 9) != 0) {
                    j2 = z3 ? j2 | 32 : j2 | 16;
                }
                if ((j2 & 9) != 0) {
                    j2 |= z4 ? 128L : 64L;
                }
                str2 = this.f13007e.getResources().getString(R.string.common_number, Integer.valueOf(i6));
                i4 = z ? 0 : 8;
                boolean z5 = i5 == 1000;
                int i8 = z2 ? 0 : 8;
                r21 = z4 ? 0 : 8;
                if ((j2 & 9) != 0) {
                    j2 |= z5 ? SVG.C : 16384L;
                }
                drawable = AppCompatResources.getDrawable(this.f13067l.getContext(), z5 ? R.drawable.ripple_card_highlight_0 : R.drawable.ripple_default);
                i3 = i8;
                i2 = r21;
                r21 = z3;
            } else {
                drawable = null;
                str2 = null;
                str7 = null;
                str8 = null;
                str4 = null;
                game = null;
                num2 = null;
                i2 = 0;
                z = false;
                i3 = 0;
                i4 = 0;
            }
            String sellerAvatar = gameCard != null ? gameCard.getSellerAvatar() : null;
            if (hVar != null) {
                aVar = hVar.w();
                str5 = sellerAvatar;
            } else {
                str5 = sellerAvatar;
                aVar = null;
            }
            str = str7;
            str3 = str8;
            num = num2;
            r21 = r21;
        } else {
            str = null;
            drawable = null;
            str2 = null;
            str3 = null;
            num = null;
            str4 = null;
            game = null;
            str5 = null;
            aVar = null;
            i2 = 0;
            z = false;
            i3 = 0;
            i4 = 0;
        }
        String locationCity = ((j2 & 32) == 0 || gameCard == null) ? null : gameCard.getLocationCity();
        CharSequence wishPrice = ((1024 & j2) == 0 || gameCard == null) ? null : gameCard.getWishPrice();
        CharSequence minP = ((j2 & 2048) == 0 || gameCard == null) ? null : gameCard.getMinP();
        String buyLocationCity = ((j2 & 16) == 0 || gameCard == null) ? null : gameCard.getBuyLocationCity();
        int i9 = ((j2 & 9) > 0L ? 1 : ((j2 & 9) == 0L ? 0 : -1));
        if (i9 != 0) {
            String str9 = r21 != 0 ? locationCity : buyLocationCity;
            if (z) {
                wishPrice = minP;
            }
            str6 = str9;
        } else {
            str6 = null;
            wishPrice = null;
        }
        if ((j2 & 13) != 0) {
            e.t.j.g.y.a(this.a, str5, null, null, null, null, null, null, null, null, null, aVar, null, null, null, null, null);
        }
        if (i9 != 0) {
            CardImageView cardImageView = this.b;
            e.l.i.e.b(cardImageView, str4, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            e.t.j.g.x.e(this.f13005c, num);
            ViewBindingAdapter.setBackground(this.f13067l, drawable);
            TextViewBindingAdapter.setText(this.f13068m, str6);
            this.f13068m.setVisibility(i3);
            TextViewBindingAdapter.setText(this.f13006d, str);
            TextViewBindingAdapter.setText(this.f13007e, str2);
            this.f13007e.setVisibility(i4);
            TextViewBindingAdapter.setText(this.f13008f, wishPrice);
            TextViewBindingAdapter.setText(this.f13009g, str3);
            this.f13010h.setVisibility(i2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.k9
    public void j(@Nullable e.l.g.h hVar) {
        this.f13011i = hVar;
        synchronized (this) {
            this.n |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // e.l.k.k9
    public void k(@Nullable GameCard gameCard) {
        this.f13012j = gameCard;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.k9
    public void l(@Nullable e.t.r.a.h hVar) {
        this.f13013k = hVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            k((GameCard) obj);
        } else if (17 == i2) {
            l((e.t.r.a.h) obj);
        } else if (2 != i2) {
            return false;
        } else {
            j((e.l.g.h) obj);
        }
        return true;
    }

    private l9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[4], (CardImageView) objArr[1], (RankImageView) objArr[8], (TextView) objArr[2], (TextView) objArr[9], (TextView) objArr[3], (TextView) objArr[5], (ImageView) objArr[6]);
        this.n = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13005c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13067l = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[7];
        this.f13068m = textView;
        textView.setTag(null);
        this.f13006d.setTag(null);
        this.f13007e.setTag(null);
        this.f13008f.setTag(null);
        this.f13009g.setTag(null);
        this.f13010h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
