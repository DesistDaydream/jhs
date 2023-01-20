package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.model.Banner;
import com.jihuanshe.model.BannerPack;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Category;
import com.jihuanshe.ui.page.main.shop.ShopFragment;
import com.jihuanshe.ui.widget.StarRatingBar;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class tf extends sf {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts t = null;
    @Nullable
    private static final SparseIntArray u = null;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final LinearLayout f13652l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final LinearLayout f13653m;
    @NonNull
    private final LinearLayout n;
    @NonNull
    private final NImageView o;
    @NonNull
    private final NImageView p;
    @NonNull
    private final ConstraintLayout q;
    @NonNull
    private final NImageView r;
    private long s;

    public tf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, t, u));
    }

    private boolean k(e.n.f<Banner> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.s |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<BannerPack> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.s |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean m(NLive<CardPackage> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.s |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean n(NLive<Category> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.s |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.s |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x0390 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:252:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x044f  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x04a4  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x0500  */
    /* JADX WARN: Removed duplicated region for block: B:297:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0104  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 1290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.tf.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.s != 0;
        }
    }

    @Override // e.l.k.sf
    public void i(@Nullable ShopFragment shopFragment) {
        this.f13583j = shopFragment;
        synchronized (this) {
            this.s |= 32;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.s = 128L;
        }
        requestRebind();
    }

    @Override // e.l.k.sf
    public void j(@Nullable ShopViewModel shopViewModel) {
        this.f13584k = shopViewModel;
        synchronized (this) {
            this.s |= 64;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return false;
                        }
                        return l((e.n.f) obj, i3);
                    }
                    return n((NLive) obj, i3);
                }
                return m((NLive) obj, i3);
            }
            return o((e.n.i) obj, i3);
        }
        return k((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ShopFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ShopViewModel) obj);
        }
        return true;
    }

    private tf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (NImageView) objArr[9], (ConstraintLayout) objArr[4], (LinearLayout) objArr[1], (StarRatingBar) objArr[12], (TextView) objArr[15], (TextView) objArr[13], (TextView) objArr[10], (TextView) objArr[14], (TextView) objArr[11]);
        this.s = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13576c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13652l = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[2];
        this.f13653m = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[3];
        this.n = linearLayout3;
        linearLayout3.setTag(null);
        NImageView nImageView = (NImageView) objArr[5];
        this.o = nImageView;
        nImageView.setTag(null);
        NImageView nImageView2 = (NImageView) objArr[6];
        this.p = nImageView2;
        nImageView2.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[7];
        this.q = constraintLayout;
        constraintLayout.setTag(null);
        NImageView nImageView3 = (NImageView) objArr[8];
        this.r = nImageView3;
        nImageView3.setTag(null);
        this.f13577d.setTag(null);
        this.f13578e.setTag(null);
        this.f13579f.setTag(null);
        this.f13580g.setTag(null);
        this.f13581h.setTag(null);
        this.f13582i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
