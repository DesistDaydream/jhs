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
import com.jihuanshe.model.Game;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.ScoreView;

/* loaded from: classes2.dex */
public class tc extends sc {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13637m = null;
    @Nullable
    private static final SparseIntArray n = null;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f13638j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ScoreView f13639k;

    /* renamed from: l  reason: collision with root package name */
    private long f13640l;

    public tc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f13637m, n));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        Float f2;
        String str5;
        Game game;
        String str6;
        CharSequence charSequence;
        boolean z;
        boolean z2;
        int i2;
        int i3;
        int i4;
        CharSequence charSequence2;
        String str7;
        Float f3;
        String str8;
        String str9;
        String str10;
        String str11;
        Game game2;
        boolean z3;
        synchronized (this) {
            j2 = this.f13640l;
            this.f13640l = 0L;
        }
        Product product = this.f13571i;
        int i5 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i5 != 0) {
            if (product != null) {
                str7 = product.getNameCN();
                f3 = product.getScoreNum();
                str8 = product.getRarity();
                z3 = product.getShowScore();
                str9 = product.getNameOri();
                str10 = product.getNum();
                str11 = product.getImage();
                game2 = product.getGame();
                charSequence2 = product.getPrice();
            } else {
                charSequence2 = null;
                str7 = null;
                f3 = null;
                str8 = null;
                str9 = null;
                str10 = null;
                str11 = null;
                game2 = null;
                z3 = false;
            }
            if (i5 != 0) {
                j2 |= z3 ? 1024L : 512L;
            }
            boolean z4 = str8 == null;
            int i6 = z3 ? 0 : 8;
            z2 = str10 == null;
            if ((j2 & 5) != 0) {
                j2 = z4 ? j2 | 256 : j2 | 128;
            }
            if ((j2 & 5) != 0) {
                j2 = z2 ? j2 | 64 : j2 | 32;
            }
            charSequence = charSequence2;
            str4 = str7;
            f2 = f3;
            str3 = game2 != null ? game2.getName() : null;
            str2 = str8;
            i2 = i6;
            str6 = str9;
            str = str10;
            str5 = str11;
            game = game2;
            z = z4;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            f2 = null;
            str5 = null;
            game = null;
            str6 = null;
            charSequence = null;
            z = false;
            z2 = false;
            i2 = 0;
        }
        boolean isEmpty = ((32 & j2) == 0 || str == null) ? false : str.isEmpty();
        boolean isEmpty2 = ((128 & j2) == 0 || str2 == null) ? false : str2.isEmpty();
        int i7 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i7 != 0) {
            if (z2) {
                isEmpty = true;
            }
            boolean z5 = z ? true : isEmpty2;
            if (i7 != 0) {
                j2 |= isEmpty ? 4096L : 2048L;
            }
            if ((j2 & 5) != 0) {
                j2 |= z5 ? 16L : 8L;
            }
            i4 = isEmpty ? 8 : 0;
            i3 = z5 ? 8 : 0;
        } else {
            i3 = 0;
            i4 = 0;
        }
        if ((j2 & 5) != 0) {
            TextViewBindingAdapter.setText(this.a, str4);
            TextViewBindingAdapter.setText(this.b, str6);
            CardImageView cardImageView = this.f13565c;
            e.l.i.e.b(cardImageView, str5, null, AppCompatResources.getDrawable(cardImageView.getContext(), R.drawable.bg_err_image), game, null, null, null);
            TextViewBindingAdapter.setText(this.f13566d, str3);
            e.l.i.a0.a(this.f13639k, f2);
            this.f13639k.setVisibility(i2);
            TextViewBindingAdapter.setText(this.f13567e, charSequence);
            TextViewBindingAdapter.setText(this.f13568f, str2);
            this.f13568f.setVisibility(i3);
            TextViewBindingAdapter.setText(this.f13569g, str);
            this.f13569g.setVisibility(i4);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13640l != 0;
        }
    }

    @Override // e.l.k.sc
    public void i(@Nullable Product product) {
        this.f13571i = product;
        synchronized (this) {
            this.f13640l |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13640l = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.sc
    public void j(@Nullable e.l.g.c1.a aVar) {
        this.f13570h = aVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((Product) obj);
        } else if (10 != i2) {
            return false;
        } else {
            j((e.l.g.c1.a) obj);
        }
        return true;
    }

    private tc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (TextView) objArr[3], (CardImageView) objArr[1], (TextView) objArr[8], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[5]);
        this.f13640l = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13565c.setTag(null);
        this.f13566d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13638j = constraintLayout;
        constraintLayout.setTag(null);
        ScoreView scoreView = (ScoreView) objArr[4];
        this.f13639k = scoreView;
        scoreView.setTag(null);
        this.f13567e.setTag(null);
        this.f13568f.setTag(null);
        this.f13569g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
