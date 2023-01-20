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
import com.jihuanshe.R;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.ui.page.detail.ReviewListActivity;
import com.jihuanshe.ui.widget.ScoreView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class nc extends mc {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts G = null;
    @Nullable
    private static final SparseIntArray H;
    @NonNull
    private final View A;
    @NonNull
    private final ImageView B;
    @NonNull
    private final TextView C;
    @NonNull
    private final TextView D;
    @NonNull
    private final ImageView E;
    private long F;
    @NonNull
    private final ConstraintLayout q;
    @NonNull
    private final LinearLayout r;
    @NonNull
    private final LinearLayout s;
    @NonNull
    private final NImageView t;
    @NonNull
    private final TextView u;
    @NonNull
    private final LinearLayout v;
    @NonNull
    private final TextView w;
    @NonNull
    private final NImageView x;
    @NonNull
    private final TextView y;
    @NonNull
    private final TextView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R.id.llTop, 24);
        sparseIntArray.put(R.id.ll, 25);
        sparseIntArray.put(R.id.llBot, 26);
    }

    public nc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 27, G, H));
    }

    /* JADX WARN: Removed duplicated region for block: B:196:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0434  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x047a  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0511  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x051f  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x053b  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x058c  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0610  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0626  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x06d2  */
    /* JADX WARN: Removed duplicated region for block: B:312:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 1757
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.nc.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.F != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.F = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.mc
    public void k(@Nullable e.l.g.r0 r0Var) {
        this.f13146m = r0Var;
        synchronized (this) {
            this.F |= 8;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // e.l.k.mc
    public void l(@Nullable ReviewListInfo reviewListInfo) {
        this.o = reviewListInfo;
        synchronized (this) {
            this.F |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.mc
    public void m(@Nullable ReviewListActivity reviewListActivity) {
        this.n = reviewListActivity;
        synchronized (this) {
            this.F |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // e.l.k.mc
    public void n(@Nullable e.t.r.a.h hVar) {
        this.p = hVar;
        synchronized (this) {
            this.F |= 2;
        }
        notifyPropertyChanged(17);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            l((ReviewListInfo) obj);
        } else if (17 == i2) {
            n((e.t.r.a.h) obj);
        } else if (10 == i2) {
            m((ReviewListActivity) obj);
        } else if (2 != i2) {
            return false;
        } else {
            k((e.l.g.r0) obj);
        }
        return true;
    }

    private nc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (ImageView) objArr[11], (LinearLayout) objArr[25], (LinearLayout) objArr[26], (LinearLayout) objArr[13], (LinearLayout) objArr[24], (NImageView) objArr[14], (ScoreView) objArr[5], (TextView) objArr[4], (TextView) objArr[9], (TextView) objArr[12], (TextView) objArr[15]);
        this.F = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13138e.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.q = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[10];
        this.r = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[16];
        this.s = linearLayout2;
        linearLayout2.setTag(null);
        NImageView nImageView = (NImageView) objArr[17];
        this.t = nImageView;
        nImageView.setTag(null);
        TextView textView = (TextView) objArr[18];
        this.u = textView;
        textView.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[19];
        this.v = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.w = textView2;
        textView2.setTag(null);
        NImageView nImageView2 = (NImageView) objArr[20];
        this.x = nImageView2;
        nImageView2.setTag(null);
        TextView textView3 = (TextView) objArr[21];
        this.y = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[22];
        this.z = textView4;
        textView4.setTag(null);
        View view2 = (View) objArr[23];
        this.A = view2;
        view2.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.B = imageView;
        imageView.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.C = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) objArr[7];
        this.D = textView6;
        textView6.setTag(null);
        ImageView imageView2 = (ImageView) objArr[8];
        this.E = imageView2;
        imageView2.setTag(null);
        this.f13140g.setTag(null);
        this.f13141h.setTag(null);
        this.f13142i.setTag(null);
        this.f13143j.setTag(null);
        this.f13144k.setTag(null);
        this.f13145l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
