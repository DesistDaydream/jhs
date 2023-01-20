package e.l.k;

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
import com.jihuanshe.R;
import com.jihuanshe.adapter.OrderProductAdapter;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.CardImageView;

/* loaded from: classes2.dex */
public class lb extends kb {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o = null;
    @Nullable
    private static final SparseIntArray p = null;
    private long n;

    public lb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, o, p));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        long j3;
        CharSequence charSequence;
        e.t.j.h.g gVar;
        String str;
        String str2;
        String str3;
        String str4;
        int i2;
        String str5;
        String str6;
        Game game;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        Game game2;
        CharSequence charSequence2;
        int i3;
        boolean z;
        synchronized (this) {
            j2 = this.n;
            this.n = 0L;
        }
        CardProduct cardProduct = this.f13028m;
        OrderProductAdapter orderProductAdapter = this.f13027l;
        int i4 = 0;
        if ((j2 & 7) != 0) {
            int i5 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
            if (i5 != 0) {
                if (cardProduct != null) {
                    i3 = cardProduct.getQuantity();
                    str4 = cardProduct.getNwName();
                    str11 = cardProduct.getProductLan();
                    str12 = cardProduct.getRarity();
                    str13 = cardProduct.getSubName();
                    z = cardProduct.isShowSubName();
                    str14 = cardProduct.getVersionNum();
                    str15 = cardProduct.getConditionStr();
                    str16 = cardProduct.getProductRemark();
                    game2 = cardProduct.getGame();
                    charSequence2 = cardProduct.getPrice();
                } else {
                    i3 = 0;
                    str4 = null;
                    str11 = null;
                    str12 = null;
                    str13 = null;
                    z = false;
                    str14 = null;
                    str15 = null;
                    str16 = null;
                    game2 = null;
                    charSequence2 = null;
                }
                if (i5 != 0) {
                    j2 |= z ? 64L : 32L;
                }
                str10 = this.f13022g.getResources().getString(R.string.common_number, Integer.valueOf(i3));
                boolean z2 = str11 == null;
                i2 = z ? 0 : 8;
                if ((j2 & 5) != 0) {
                    j2 |= z2 ? 16L : 8L;
                }
                if (z2) {
                    i4 = 8;
                }
            } else {
                str10 = null;
                str4 = null;
                i2 = 0;
                str11 = null;
                str12 = null;
                str13 = null;
                str14 = null;
                str15 = null;
                str16 = null;
                game2 = null;
                charSequence2 = null;
            }
            String image = cardProduct != null ? cardProduct.getImage() : null;
            gVar = orderProductAdapter != null ? orderProductAdapter.j(image, this.b) : null;
            str3 = str10;
            str2 = str11;
            str7 = str12;
            str9 = str13;
            str5 = str14;
            str = str15;
            str8 = str16;
            game = game2;
            j3 = 7;
            str6 = image;
            charSequence = charSequence2;
        } else {
            j3 = 7;
            charSequence = null;
            gVar = null;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            i2 = 0;
            str5 = null;
            str6 = null;
            game = null;
            str7 = null;
            str8 = null;
            str9 = null;
        }
        if ((j2 & j3) != 0) {
            e.t.j.g.e0.F(this.b, gVar);
        }
        if ((j2 & 5) != 0) {
            CardImageView cardImageView = this.b;
            e.l.i.e.b(cardImageView, str6, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            TextViewBindingAdapter.setText(this.f13018c, str4);
            TextViewBindingAdapter.setText(this.f13019d, charSequence);
            TextViewBindingAdapter.setText(this.f13020e, str);
            TextViewBindingAdapter.setText(this.f13021f, str2);
            this.f13021f.setVisibility(i4);
            TextViewBindingAdapter.setText(this.f13022g, str3);
            TextViewBindingAdapter.setText(this.f13023h, str5);
            TextViewBindingAdapter.setText(this.f13024i, str7);
            TextViewBindingAdapter.setText(this.f13025j, str8);
            this.f13026k.setVisibility(i2);
            TextViewBindingAdapter.setText(this.f13026k, str9);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // e.l.k.kb
    public void i(@Nullable OrderProductAdapter orderProductAdapter) {
        this.f13027l = orderProductAdapter;
        synchronized (this) {
            this.n |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.kb
    public void j(@Nullable CardProduct cardProduct) {
        this.f13028m = cardProduct;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            j((CardProduct) obj);
        } else if (2 != i2) {
            return false;
        } else {
            i((OrderProductAdapter) obj);
        }
        return true;
    }

    private lb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[0], (CardImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[3], (TextView) objArr[7], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[8], (TextView) objArr[4]);
        this.n = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13018c.setTag(null);
        this.f13019d.setTag(null);
        this.f13020e.setTag(null);
        this.f13021f.setTag(null);
        this.f13022g.setTag(null);
        this.f13023h.setTag(null);
        this.f13024i.setTag(null);
        this.f13025j.setTag(null);
        this.f13026k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
