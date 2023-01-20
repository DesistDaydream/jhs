package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.eth.model.NLive;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.button.MaterialButton;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.ShopCarInfo;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.user.SellerDetailActivity;
import com.jihuanshe.ui.widget.CopyTextView;
import com.jihuanshe.ui.widget.MinConstraintLayout;
import com.jihuanshe.ui.widget.RankImageView;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import com.vector.network.image.NImageView;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class j2 extends i2 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts b0;
    @Nullable
    private static final SparseIntArray c0;
    @NonNull
    private final ConstraintLayout J;
    @NonNull
    private final AppBarLayout K;
    @NonNull
    private final RankImageView L;
    @NonNull
    private final TextView M;
    @Nullable
    private final Cif N;
    @NonNull
    private final ImageView O;
    @NonNull
    private final TextView P;
    @NonNull
    private final TextView Q;
    @NonNull
    private final TextView R;
    @NonNull
    private final ConstraintLayout S;
    @NonNull
    private final ImageView T;
    @NonNull
    private final TextView U;
    @NonNull
    private final ImageView V;
    @NonNull
    private final ConstraintLayout W;
    @NonNull
    private final ConstraintLayout X;
    @NonNull
    private final TextView Y;
    @NonNull
    private final LinearLayout Z;
    private long a0;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(50);
        b0 = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"view_filter_bar_user_shop"}, new int[]{36}, new int[]{R.layout.view_filter_bar_user_shop});
        SparseIntArray sparseIntArray = new SparseIntArray();
        c0 = sparseIntArray;
        sparseIntArray.put(R.id.coordinatorView, 37);
        sparseIntArray.put(R.id.minView, 38);
        sparseIntArray.put(R.id.llContent, 39);
        sparseIntArray.put(R.id.fanNumTv, 40);
        sparseIntArray.put(R.id.fanTv, 41);
        sparseIntArray.put(R.id.orderTv, 42);
        sparseIntArray.put(R.id.ll_parent, 43);
        sparseIntArray.put(R.id.clTop, 44);
        sparseIntArray.put(R.id.ll_left, 45);
        sparseIntArray.put(R.id.ll_center, 46);
        sparseIntArray.put(R.id.ll_right, 47);
        sparseIntArray.put(R.id.ll_fans, 48);
        sparseIntArray.put(R.id.shopCarBar, 49);
    }

    public j2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 50, b0, c0));
    }

    private boolean k(e.n.f<List<Game>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.a0 |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<List<GameCard>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.a0 |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.a0 |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean n(NLive<List<CardProduct>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.a0 |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.a0 |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.f<ShopCarInfo> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.a0 |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean q(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.a0 |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean r(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.a0 |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean s(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.a0 |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean t(e.n.f<User> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.a0 |= 64;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:143:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03d0  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0449  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x06a4  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x06c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x06fd  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x070b  */
    /* JADX WARN: Removed duplicated region for block: B:326:0x072c  */
    /* JADX WARN: Removed duplicated region for block: B:329:0x073a  */
    /* JADX WARN: Removed duplicated region for block: B:336:0x074b  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x0755  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x076f  */
    /* JADX WARN: Removed duplicated region for block: B:354:0x0778  */
    /* JADX WARN: Removed duplicated region for block: B:358:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:365:0x0791  */
    /* JADX WARN: Removed duplicated region for block: B:368:0x079c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:373:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:376:0x07c0  */
    /* JADX WARN: Removed duplicated region for block: B:378:0x07c5  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x07dc  */
    /* JADX WARN: Removed duplicated region for block: B:384:0x083d  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x088d  */
    /* JADX WARN: Removed duplicated region for block: B:389:0x089a  */
    /* JADX WARN: Removed duplicated region for block: B:392:0x0932  */
    /* JADX WARN: Removed duplicated region for block: B:394:0x0947  */
    /* JADX WARN: Removed duplicated region for block: B:397:0x097c  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x09b2  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x09d2  */
    /* JADX WARN: Removed duplicated region for block: B:406:0x09eb  */
    /* JADX WARN: Removed duplicated region for block: B:409:0x09ff  */
    /* JADX WARN: Removed duplicated region for block: B:412:0x0a14  */
    /* JADX WARN: Removed duplicated region for block: B:415:0x0a22  */
    /* JADX WARN: Removed duplicated region for block: B:418:0x0a2f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0119  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 2631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.j2.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.a0 != 0) {
                return true;
            }
            return this.N.hasPendingBindings();
        }
    }

    @Override // e.l.k.i2
    public void i(@Nullable SellerDetailActivity sellerDetailActivity) {
        this.H = sellerDetailActivity;
        synchronized (this) {
            this.a0 |= 2048;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.a0 = 4096L;
        }
        this.N.invalidateAll();
        requestRebind();
    }

    @Override // e.l.k.i2
    public void j(@Nullable SellerDetailViewModel sellerDetailViewModel) {
        this.I = sellerDetailViewModel;
        synchronized (this) {
            this.a0 |= 1024;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return l((NLive) obj, i3);
            case 1:
                return o((e.n.l) obj, i3);
            case 2:
                return p((e.n.f) obj, i3);
            case 3:
                return m((e.n.i) obj, i3);
            case 4:
                return r((e.n.i) obj, i3);
            case 5:
                return n((NLive) obj, i3);
            case 6:
                return t((e.n.f) obj, i3);
            case 7:
                return k((e.n.f) obj, i3);
            case 8:
                return s((e.n.i) obj, i3);
            case 9:
                return q((e.n.i) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.N.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (21 == i2) {
            j((SellerDetailViewModel) obj);
        } else if (10 != i2) {
            return false;
        } else {
            i((SellerDetailActivity) obj);
        }
        return true;
    }

    private j2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (ConstraintLayout) objArr[44], (CoordinatorLayout) objArr[37], (TextView) objArr[30], (ExpandableTextView) objArr[10], (View) objArr[8], (LinearLayout) objArr[40], (TextView) objArr[41], (MaterialButton) objArr[15], (NImageView) objArr[3], (TextView) objArr[9], (View) objArr[6], (ListView) objArr[21], (ListView) objArr[35], (LinearLayout) objArr[46], (LinearLayout) objArr[39], (LinearLayout) objArr[48], (LinearLayout) objArr[45], (LinearLayout) objArr[43], (LinearLayout) objArr[47], (TextView) objArr[7], (MaterialButton) objArr[20], (ConstraintLayout) objArr[16], (MinConstraintLayout) objArr[38], (CopyTextView) objArr[4], (TextView) objArr[13], (TextView) objArr[42], (TextView) objArr[31], (LinearLayout) objArr[49], (ConstraintLayout) objArr[22], (ConstraintLayout) objArr[23], (LinearLayout) objArr[28], (RecyclerView) objArr[27], (CopyTextView) objArr[5]);
        this.a0 = -1L;
        this.f12835c.setTag(null);
        this.f12836d.setTag(null);
        this.f12837e.setTag(null);
        this.f12840h.setTag(null);
        this.f12841i.setTag(null);
        this.f12842j.setTag(null);
        this.f12843k.setTag(null);
        this.f12844l.setTag(null);
        this.f12845m.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.J = constraintLayout;
        constraintLayout.setTag(null);
        AppBarLayout appBarLayout = (AppBarLayout) objArr[1];
        this.K = appBarLayout;
        appBarLayout.setTag(null);
        RankImageView rankImageView = (RankImageView) objArr[11];
        this.L = rankImageView;
        rankImageView.setTag(null);
        TextView textView = (TextView) objArr[12];
        this.M = textView;
        textView.setTag(null);
        Cif cif = (Cif) objArr[36];
        this.N = cif;
        setContainedBinding(cif);
        ImageView imageView = (ImageView) objArr[14];
        this.O = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[17];
        this.P = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[18];
        this.Q = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[19];
        this.R = textView4;
        textView4.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[2];
        this.S = constraintLayout2;
        constraintLayout2.setTag(null);
        ImageView imageView2 = (ImageView) objArr[24];
        this.T = imageView2;
        imageView2.setTag(null);
        TextView textView5 = (TextView) objArr[25];
        this.U = textView5;
        textView5.setTag(null);
        ImageView imageView3 = (ImageView) objArr[26];
        this.V = imageView3;
        imageView3.setTag(null);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) objArr[29];
        this.W = constraintLayout3;
        constraintLayout3.setTag(null);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) objArr[32];
        this.X = constraintLayout4;
        constraintLayout4.setTag(null);
        TextView textView6 = (TextView) objArr[33];
        this.Y = textView6;
        textView6.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[34];
        this.Z = linearLayout;
        linearLayout.setTag(null);
        this.v.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.A.setTag(null);
        this.C.setTag(null);
        this.D.setTag(null);
        this.E.setTag(null);
        this.F.setTag(null);
        this.G.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
