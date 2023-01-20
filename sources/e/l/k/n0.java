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
import com.jihuanshe.R;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.page.user.edit.EditUserActivity;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class n0 extends m0 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts x = null;
    @Nullable
    private static final SparseIntArray y;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f13155e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f13156f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13157g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final LinearLayout f13158h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f13159i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final LinearLayout f13160j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final TextView f13161k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final LinearLayout f13162l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f13163m;
    @NonNull
    private final TextView n;
    @NonNull
    private final NImageView o;
    @NonNull
    private final LinearLayout p;
    @NonNull
    private final TextView q;
    @NonNull
    private final LinearLayout r;
    @NonNull
    private final TextView s;
    @NonNull
    private final LinearLayout t;
    @NonNull
    private final TextView u;
    @NonNull
    private final LinearLayout v;
    private long w;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.infoView, 18);
        sparseIntArray.put(R.id.ll, 19);
    }

    public n0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, x, y));
    }

    private boolean k(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.w |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<User> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.w |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.n0.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.w != 0;
        }
    }

    @Override // e.l.k.m0
    public void i(@Nullable EditUserActivity editUserActivity) {
        this.f13097c = editUserActivity;
        synchronized (this) {
            this.w |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.w = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.m0
    public void j(@Nullable e.l.s.o.c.a aVar) {
        this.f13098d = aVar;
        synchronized (this) {
            this.w |= 8;
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
            return k((e.n.p) obj, i3);
        }
        return l((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((EditUserActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.o.c.a) obj);
        }
        return true;
    }

    private n0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (LinearLayout) objArr[18], (LinearLayout) objArr[19]);
        this.w = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13155e = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[1];
        this.f13156f = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.f13157g = textView;
        textView.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[11];
        this.f13158h = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView2 = (TextView) objArr[12];
        this.f13159i = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[13];
        this.f13160j = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView3 = (TextView) objArr[14];
        this.f13161k = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[15];
        this.f13162l = linearLayout4;
        linearLayout4.setTag(null);
        TextView textView4 = (TextView) objArr[16];
        this.f13163m = textView4;
        textView4.setTag(null);
        TextView textView5 = (TextView) objArr[17];
        this.n = textView5;
        textView5.setTag(null);
        NImageView nImageView = (NImageView) objArr[2];
        this.o = nImageView;
        nImageView.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) objArr[3];
        this.p = linearLayout5;
        linearLayout5.setTag(null);
        TextView textView6 = (TextView) objArr[4];
        this.q = textView6;
        textView6.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) objArr[5];
        this.r = linearLayout6;
        linearLayout6.setTag(null);
        TextView textView7 = (TextView) objArr[6];
        this.s = textView7;
        textView7.setTag(null);
        LinearLayout linearLayout7 = (LinearLayout) objArr[7];
        this.t = linearLayout7;
        linearLayout7.setTag(null);
        TextView textView8 = (TextView) objArr[8];
        this.u = textView8;
        textView8.setTag(null);
        LinearLayout linearLayout8 = (LinearLayout) objArr[9];
        this.v = linearLayout8;
        linearLayout8.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
