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
import com.eth.model.NLive;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.google.android.material.appbar.AppBarLayout;
import com.jihuanshe.R;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.DatePrice;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.model.TopCommentInfo;
import com.jihuanshe.ui.page.detail.CardDetailActivity;
import com.jihuanshe.ui.page.detail.CardViewInfo;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.ConditionFilterBtn;
import com.jihuanshe.ui.widget.CopyTextView;
import com.jihuanshe.ui.widget.NestedRecyclerView;
import com.jihuanshe.ui.widget.ScoreNumView;
import com.jihuanshe.ui.widget.ScoreView;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class r extends q {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts i0 = null;
    @Nullable
    private static final SparseIntArray j0;
    @NonNull
    private final ConstraintLayout K;
    @NonNull
    private final AppBarLayout L;
    @NonNull
    private final ScoreNumView M;
    @NonNull
    private final LinearLayout N;
    @NonNull
    private final TextView O;
    @NonNull
    private final TextView P;
    @NonNull
    private final TextView Q;
    @NonNull
    private final TextView R;
    @NonNull
    private final TextView S;
    @NonNull
    private final TextView T;
    @NonNull
    private final CopyTextView U;
    @NonNull
    private final TextView V;
    @NonNull
    private final NestedRecyclerView W;
    @NonNull
    private final ConstraintLayout X;
    @NonNull
    private final TextView Y;
    @NonNull
    private final ConstraintLayout Z;
    @NonNull
    private final TextView a0;
    @NonNull
    private final ConstraintLayout b0;
    @NonNull
    private final TextView c0;
    @NonNull
    private final TextView d0;
    @NonNull
    private final TextView e0;
    @NonNull
    private final TextView f0;
    @NonNull
    private final TextView g0;
    private long h0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j0 = sparseIntArray;
        sparseIntArray.put(R.id.coordinatorView, 48);
        sparseIntArray.put(R.id.ll_Left, 49);
        sparseIntArray.put(R.id.viewLine, 50);
        sparseIntArray.put(R.id.llCenter, 51);
        sparseIntArray.put(R.id.llLeft, 52);
        sparseIntArray.put(R.id.viewLine2, 53);
        sparseIntArray.put(R.id.chartView, 54);
        sparseIntArray.put(R.id.tvTopComments, 55);
        sparseIntArray.put(R.id.llBot, 56);
    }

    public r(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 57, i0, j0));
    }

    private boolean k(NLive<CardDetailInfo> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<List<GameCard>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean m(NLive<List<CardViewInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.f<List<Rarity>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 512;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean q(e.n.f<DatePrice> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean r(e.n.f<CharSequence> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean s(NLive<List<TopCommentInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean t(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.h0 |= 4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:170:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0146  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 2596
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.r.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h0 != 0;
        }
    }

    @Override // e.l.k.q
    public void i(@Nullable CardDetailActivity cardDetailActivity) {
        this.I = cardDetailActivity;
        synchronized (this) {
            this.h0 |= 2048;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h0 = 4096L;
        }
        requestRebind();
    }

    @Override // e.l.k.q
    public void j(@Nullable CardDetailViewModel cardDetailViewModel) {
        this.J = cardDetailViewModel;
        synchronized (this) {
            this.h0 |= 1024;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return m((NLive) obj, i3);
            case 1:
                return q((e.n.f) obj, i3);
            case 2:
                return t((e.n.p) obj, i3);
            case 3:
                return r((e.n.f) obj, i3);
            case 4:
                return s((NLive) obj, i3);
            case 5:
                return k((NLive) obj, i3);
            case 6:
                return n((e.n.f) obj, i3);
            case 7:
                return p((e.n.l) obj, i3);
            case 8:
                return l((NLive) obj, i3);
            case 9:
                return o((e.n.l) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (21 == i2) {
            j((CardDetailViewModel) obj);
        } else if (10 != i2) {
            return false;
        } else {
            i((CardDetailActivity) obj);
        }
        return true;
    }

    private r(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 10, (TextView) objArr[35], (AAChartView) objArr[54], (ConditionFilterBtn) objArr[36], (CoordinatorLayout) objArr[48], (CardImageView) objArr[2], (ImageView) objArr[39], (ImageView) objArr[42], (ImageView) objArr[45], (ListView) objArr[37], (LinearLayout) objArr[10], (LinearLayout) objArr[56], (LinearLayout) objArr[51], (LinearLayout) objArr[49], (LinearLayout) objArr[52], (LinearLayout) objArr[7], (TextView) objArr[34], (ScoreView) objArr[17], (TextView) objArr[22], (TextView) objArr[32], (TextView) objArr[21], (TextView) objArr[12], (CopyTextView) objArr[4], (CopyTextView) objArr[5], (TextView) objArr[11], (TextView) objArr[18], (TextView) objArr[20], (TextView) objArr[15], (ScoreView) objArr[16], (TextView) objArr[14], (TextView) objArr[13], (TextView) objArr[55], (TextView) objArr[31], (View) objArr[50], (View) objArr[53]);
        this.h0 = -1L;
        this.a.setTag(null);
        this.f13364c.setTag(null);
        this.f13366e.setTag(null);
        this.f13367f.setTag(null);
        this.f13368g.setTag(null);
        this.f13369h.setTag(null);
        this.f13370i.setTag(null);
        this.f13371j.setTag(null);
        this.o.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.K = constraintLayout;
        constraintLayout.setTag(null);
        AppBarLayout appBarLayout = (AppBarLayout) objArr[1];
        this.L = appBarLayout;
        appBarLayout.setTag(null);
        ScoreNumView scoreNumView = (ScoreNumView) objArr[19];
        this.M = scoreNumView;
        scoreNumView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[23];
        this.N = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[24];
        this.O = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[25];
        this.P = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[26];
        this.Q = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[27];
        this.R = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[28];
        this.S = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[29];
        this.T = textView6;
        textView6.setTag(null);
        CopyTextView copyTextView = (CopyTextView) objArr[3];
        this.U = copyTextView;
        copyTextView.setTag(null);
        TextView textView7 = (TextView) objArr[30];
        this.V = textView7;
        textView7.setTag(null);
        NestedRecyclerView nestedRecyclerView = (NestedRecyclerView) objArr[33];
        this.W = nestedRecyclerView;
        nestedRecyclerView.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[38];
        this.X = constraintLayout2;
        constraintLayout2.setTag(null);
        TextView textView8 = (TextView) objArr[40];
        this.Y = textView8;
        textView8.setTag(null);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) objArr[41];
        this.Z = constraintLayout3;
        constraintLayout3.setTag(null);
        TextView textView9 = (TextView) objArr[43];
        this.a0 = textView9;
        textView9.setTag(null);
        ConstraintLayout constraintLayout4 = (ConstraintLayout) objArr[44];
        this.b0 = constraintLayout4;
        constraintLayout4.setTag(null);
        TextView textView10 = (TextView) objArr[46];
        this.c0 = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[47];
        this.d0 = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[6];
        this.e0 = textView12;
        textView12.setTag(null);
        TextView textView13 = (TextView) objArr[8];
        this.f0 = textView13;
        textView13.setTag(null);
        TextView textView14 = (TextView) objArr[9];
        this.g0 = textView14;
        textView14.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.A.setTag(null);
        this.B.setTag(null);
        this.C.setTag(null);
        this.D.setTag(null);
        this.F.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
