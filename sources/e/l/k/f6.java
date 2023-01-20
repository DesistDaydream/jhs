package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.CardPack;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.CardVersion;
import com.jihuanshe.ui.dialog.AddCardDialog;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.FlexLayout;
import com.jihuanshe.ui.widget.NumberView;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public class f6 extends e6 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts X = null;
    @Nullable
    private static final SparseIntArray Y;
    @NonNull
    private final ConstraintLayout B;
    @NonNull
    private final TextView C;
    @NonNull
    private final TextView D;
    @NonNull
    private final TextView E;
    @NonNull
    private final TextView F;
    @NonNull
    private final TextView G;
    @NonNull
    private final LinearLayout H;
    @NonNull
    private final TextView I;
    @NonNull
    private final TextView J;
    @NonNull
    private final TextView K;
    @NonNull
    private final TextView L;
    @NonNull
    private final ImageView M;
    @NonNull
    private final TextView N;
    @NonNull
    private final TextView O;
    @NonNull
    private final TextView P;
    @NonNull
    private final ScrollView Q;
    @NonNull
    private final TextView R;
    @NonNull
    private final ImageView S;
    @NonNull
    private final LinearLayout T;
    @NonNull
    private final TextView U;
    @NonNull
    private final FlexLayout V;
    private long W;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        Y = sparseIntArray;
        sparseIntArray.put(R.id.divider, 35);
        sparseIntArray.put(R.id.versionTitle, 36);
        sparseIntArray.put(R.id.divider2, 37);
        sparseIntArray.put(R.id.countTitle, 38);
        sparseIntArray.put(R.id.divider3, 39);
        sparseIntArray.put(R.id.priceTitle, 40);
        sparseIntArray.put(R.id.minPriceTv, 41);
        sparseIntArray.put(R.id.avgPriceTv, 42);
        sparseIntArray.put(R.id.yuanTv, 43);
        sparseIntArray.put(R.id.divider4, 44);
        sparseIntArray.put(R.id.remarkTv, 45);
        sparseIntArray.put(R.id.ll, 46);
    }

    public f6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 47, X, Y));
    }

    private boolean i(NLive<CardProductNew> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.f<CardVersion> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.f<CardPack> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.W |= 64;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:145:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0456  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 1976
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.f6.executeBindings():void");
    }

    @Override // e.l.k.e6
    public void h(@Nullable AddCardDialog addCardDialog) {
        this.A = addCardDialog;
        synchronized (this) {
            this.W |= 128;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.W != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.W = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return m((e.n.l) obj, i3);
            case 1:
                return j((e.n.l) obj, i3);
            case 2:
                return k((e.n.f) obj, i3);
            case 3:
                return i((NLive) obj, i3);
            case 4:
                return l((e.n.l) obj, i3);
            case 5:
                return n((e.n.i) obj, i3);
            case 6:
                return o((e.n.f) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((AddCardDialog) obj);
            return true;
        }
        return false;
    }

    private f6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 7, (NumberView) objArr[27], (TextView) objArr[42], (TextView) objArr[38], (CardImageView) objArr[3], (View) objArr[35], (View) objArr[37], (View) objArr[39], (View) objArr[44], (ListView) objArr[33], (LinearLayout) objArr[46], (TextView) objArr[41], (EditText) objArr[30], (TextView) objArr[40], (TextView) objArr[23], (TextView) objArr[24], (TextView) objArr[25], (TextView) objArr[26], (TextView) objArr[22], (EditText) objArr[31], (TextView) objArr[45], (ImageView) objArr[2], (TextView) objArr[32], (TextView) objArr[21], (LinearLayout) objArr[18], (TextView) objArr[36], (TextView) objArr[43]);
        this.W = -1L;
        this.a.setTag(null);
        this.f12556d.setTag(null);
        this.f12561i.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.B = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.C = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[10];
        this.D = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[11];
        this.E = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[12];
        this.F = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[13];
        this.G = textView5;
        textView5.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[14];
        this.H = linearLayout;
        linearLayout.setTag(null);
        TextView textView6 = (TextView) objArr[15];
        this.I = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[16];
        this.J = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[17];
        this.K = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[19];
        this.L = textView9;
        textView9.setTag(null);
        ImageView imageView = (ImageView) objArr[20];
        this.M = imageView;
        imageView.setTag(null);
        TextView textView10 = (TextView) objArr[28];
        this.N = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[29];
        this.O = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[34];
        this.P = textView12;
        textView12.setTag(null);
        ScrollView scrollView = (ScrollView) objArr[4];
        this.Q = scrollView;
        scrollView.setTag(null);
        TextView textView13 = (TextView) objArr[5];
        this.R = textView13;
        textView13.setTag(null);
        ImageView imageView2 = (ImageView) objArr[6];
        this.S = imageView2;
        imageView2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[7];
        this.T = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView14 = (TextView) objArr[8];
        this.U = textView14;
        textView14.setTag(null);
        FlexLayout flexLayout = (FlexLayout) objArr[9];
        this.V = flexLayout;
        flexLayout.setTag(null);
        this.f12564l.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.u.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
