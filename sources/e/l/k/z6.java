package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
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
import com.jihuanshe.model.User;
import com.jihuanshe.model.UserNumber;
import com.jihuanshe.ui.page.main.me.MeFragment;
import com.jihuanshe.ui.widget.RankImageView;
import com.jihuanshe.viewmodel.main.me.MeViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class z6 extends y6 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts R = null;
    @Nullable
    private static final SparseIntArray S;
    @NonNull
    private final RankImageView A;
    @NonNull
    private final LinearLayout B;
    @NonNull
    private final LinearLayout C;
    @NonNull
    private final LinearLayout D;
    @NonNull
    private final ImageView E;
    @NonNull
    private final NImageView F;
    @NonNull
    private final TextView G;
    @NonNull
    private final TextView H;
    @NonNull
    private final TextView I;
    @NonNull
    private final TextView J;
    @NonNull
    private final TextView K;
    @NonNull
    private final TextView L;
    @NonNull
    private final TextView M;
    @NonNull
    private final TextView N;
    @NonNull
    private final TextView O;
    @NonNull
    private final TextView P;
    private long Q;
    @NonNull
    private final ConstraintLayout r;
    @NonNull
    private final TextView s;
    @NonNull
    private final TextView t;
    @NonNull
    private final LinearLayout u;
    @NonNull
    private final LinearLayout v;
    @NonNull
    private final LinearLayout w;
    @NonNull
    private final LinearLayout x;
    @NonNull
    private final LinearLayout y;
    @NonNull
    private final LinearLayout z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        S = sparseIntArray;
        sparseIntArray.put(R.id.infoView, 33);
        sparseIntArray.put(R.id.divider, 34);
        sparseIntArray.put(R.id.secondLayout, 35);
        sparseIntArray.put(R.id.nameIcon, 36);
        sparseIntArray.put(R.id.spacer1, 37);
        sparseIntArray.put(R.id.verifyIcon, 38);
        sparseIntArray.put(R.id.spacer, 39);
    }

    public z6(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 40, R, S));
    }

    private boolean k(NLive<UserNumber> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.Q |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<User> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.Q |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:80:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.z6.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.Q != 0;
        }
    }

    @Override // e.l.k.y6
    public void i(@Nullable MeFragment meFragment) {
        this.p = meFragment;
        synchronized (this) {
            this.Q |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.Q = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.y6
    public void j(@Nullable MeViewModel meViewModel) {
        this.q = meViewModel;
        synchronized (this) {
            this.Q |= 8;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                return false;
            }
            return k((NLive) obj, i3);
        }
        return l((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((MeFragment) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((MeViewModel) obj);
        }
        return true;
    }

    private z6(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (TextView) objArr[5], (View) objArr[34], (LinearLayout) objArr[8], (LinearLayout) objArr[6], (TextView) objArr[3], (ConstraintLayout) objArr[33], (TextView) objArr[4], (ImageView) objArr[36], (TextView) objArr[1], (LinearLayout) objArr[35], (LinearLayout) objArr[10], (View) objArr[39], (View) objArr[37], (ImageView) objArr[38], (LinearLayout) objArr[12]);
        this.Q = -1L;
        this.a.setTag(null);
        this.f13959c.setTag(null);
        this.f13960d.setTag(null);
        this.f13961e.setTag(null);
        this.f13963g.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.r = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[11];
        this.s = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[13];
        this.t = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[14];
        this.u = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[15];
        this.v = linearLayout2;
        linearLayout2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[16];
        this.w = linearLayout3;
        linearLayout3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[17];
        this.x = linearLayout4;
        linearLayout4.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[18];
        this.y = linearLayout5;
        linearLayout5.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) objArr[19];
        this.z = linearLayout6;
        linearLayout6.setTag(null);
        RankImageView rankImageView = (RankImageView) objArr[2];
        this.A = rankImageView;
        rankImageView.setTag(null);
        LinearLayout linearLayout7 = (LinearLayout) objArr[20];
        this.B = linearLayout7;
        linearLayout7.setTag(null);
        LinearLayout linearLayout8 = (LinearLayout) objArr[21];
        this.C = linearLayout8;
        linearLayout8.setTag(null);
        LinearLayout linearLayout9 = (LinearLayout) objArr[22];
        this.D = linearLayout9;
        linearLayout9.setTag(null);
        ImageView imageView = (ImageView) objArr[23];
        this.E = imageView;
        imageView.setTag(null);
        NImageView nImageView = (NImageView) objArr[24];
        this.F = nImageView;
        nImageView.setTag(null);
        TextView textView3 = (TextView) objArr[25];
        this.G = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[26];
        this.H = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[27];
        this.I = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[28];
        this.J = textView6;
        textView6.setTag(null);
        TextView textView7 = (TextView) objArr[29];
        this.K = textView7;
        textView7.setTag(null);
        TextView textView8 = (TextView) objArr[30];
        this.L = textView8;
        textView8.setTag(null);
        TextView textView9 = (TextView) objArr[31];
        this.M = textView9;
        textView9.setTag(null);
        TextView textView10 = (TextView) objArr[32];
        this.N = textView10;
        textView10.setTag(null);
        TextView textView11 = (TextView) objArr[7];
        this.O = textView11;
        textView11.setTag(null);
        TextView textView12 = (TextView) objArr[9];
        this.P = textView12;
        textView12.setTag(null);
        this.f13965i.setTag(null);
        this.f13967k.setTag(null);
        this.o.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
