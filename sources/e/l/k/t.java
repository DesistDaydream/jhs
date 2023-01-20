package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.model.TopCommentInfo;
import com.jihuanshe.ui.page.detail.CardPackDetailActivity;
import com.jihuanshe.ui.widget.CopyTextView;
import com.jihuanshe.ui.widget.NestedRecyclerView;
import com.jihuanshe.ui.widget.ScoreNumView;
import com.jihuanshe.ui.widget.ScoreView;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import com.vector.network.image.NImageView;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class t extends s {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts Q = null;
    @Nullable
    private static final SparseIntArray R;
    @NonNull
    private final LinearLayout D;
    @NonNull
    private final ScoreNumView E;
    @NonNull
    private final LinearLayout F;
    @NonNull
    private final HorizontalScrollView G;
    @NonNull
    private final ConstraintLayout H;
    @NonNull
    private final TextView I;
    @NonNull
    private final ConstraintLayout J;
    @NonNull
    private final TextView K;
    @NonNull
    private final ConstraintLayout L;
    @NonNull
    private final TextView M;
    @NonNull
    private final TextView N;
    @NonNull
    private final TextView O;
    private long P;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        R = sparseIntArray;
        sparseIntArray.put(R.id.coverIv, 33);
        sparseIntArray.put(R.id.ll_Left, 34);
        sparseIntArray.put(R.id.viewLine, 35);
        sparseIntArray.put(R.id.llCenter, 36);
        sparseIntArray.put(R.id.tvTopComments, 37);
        sparseIntArray.put(R.id.saleTv, 38);
    }

    public t(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 39, Q, R));
    }

    private boolean k(e.n.f<LayoutManagers.a> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.P |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<PackDetailResult> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.P |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean m(NLive<List<TopCommentInfo>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.P |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.P |= 4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0310  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 1652
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.t.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.P != 0;
        }
    }

    @Override // e.l.k.s
    public void i(@Nullable CardPackDetailActivity cardPackDetailActivity) {
        this.B = cardPackDetailActivity;
        synchronized (this) {
            this.P |= 32;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.P = 64L;
        }
        requestRebind();
    }

    @Override // e.l.k.s
    public void j(@Nullable CardPackDetailViewModel cardPackDetailViewModel) {
        this.C = cardPackDetailViewModel;
        synchronized (this) {
            this.P |= 16;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return m((NLive) obj, i3);
                }
                return n((e.n.p) obj, i3);
            }
            return k((e.n.f) obj, i3);
        }
        return l((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (21 == i2) {
            j((CardPackDetailViewModel) obj);
        } else if (10 != i2) {
            return false;
        } else {
            i((CardPackDetailActivity) obj);
        }
        return true;
    }

    private t(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (TextView) objArr[21], (ConstraintLayout) objArr[33], (NImageView) objArr[1], (ImageView) objArr[25], (ImageView) objArr[28], (ImageView) objArr[31], (ListView) objArr[23], (LinearLayout) objArr[36], (LinearLayout) objArr[34], (LinearLayout) objArr[4], (NestedRecyclerView) objArr[19], (TextView) objArr[38], (ScoreView) objArr[14], (TextView) objArr[9], (TextView) objArr[10], (TextView) objArr[18], (CopyTextView) objArr[2], (CopyTextView) objArr[3], (CopyTextView) objArr[7], (TextView) objArr[15], (TextView) objArr[8], (TextView) objArr[12], (ScoreView) objArr[13], (TextView) objArr[11], (TextView) objArr[37], (TextView) objArr[17], (View) objArr[35]);
        this.P = -1L;
        this.a.setTag(null);
        this.f13521c.setTag(null);
        this.f13522d.setTag(null);
        this.f13523e.setTag(null);
        this.f13524f.setTag(null);
        this.f13525g.setTag(null);
        this.f13528j.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.D = linearLayout;
        linearLayout.setTag(null);
        ScoreNumView scoreNumView = (ScoreNumView) objArr[16];
        this.E = scoreNumView;
        scoreNumView.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[20];
        this.F = linearLayout2;
        linearLayout2.setTag(null);
        HorizontalScrollView horizontalScrollView = (HorizontalScrollView) objArr[22];
        this.G = horizontalScrollView;
        horizontalScrollView.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[24];
        this.H = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[26];
        this.I = textView;
        textView.setTag(null);
        ConstraintLayout constraintLayout2 = (ConstraintLayout) objArr[27];
        this.J = constraintLayout2;
        constraintLayout2.setTag(null);
        TextView textView2 = (TextView) objArr[29];
        this.K = textView2;
        textView2.setTag(null);
        ConstraintLayout constraintLayout3 = (ConstraintLayout) objArr[30];
        this.L = constraintLayout3;
        constraintLayout3.setTag(null);
        TextView textView3 = (TextView) objArr[32];
        this.M = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[5];
        this.N = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.O = textView5;
        textView5.setTag(null);
        this.f13529k.setTag(null);
        this.f13531m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        this.z.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
