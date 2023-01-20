package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.widget.ScoreView;
import com.jihuanshe.ui.widget.shimmer.ShimmerFrameLayout;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class xc extends wc {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts x = null;
    @Nullable
    private static final SparseIntArray y;
    @NonNull
    private final ShimmerFrameLayout n;
    @NonNull
    private final FrameLayout o;
    @NonNull
    private final TextView p;
    @NonNull
    private final TextView q;
    @NonNull
    private final TextView r;
    @NonNull
    private final TextView s;
    @NonNull
    private final NImageView t;
    @NonNull
    private final TextView u;
    @NonNull
    private final ScoreView v;
    private long w;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        y = sparseIntArray;
        sparseIntArray.put(R.id.top1, 18);
        sparseIntArray.put(R.id.top2, 19);
    }

    public xc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 20, x, y));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 506
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.xc.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.w != 0;
        }
    }

    @Override // e.l.k.wc
    public void i(@Nullable Product product) {
        this.f13868l = product;
        synchronized (this) {
            this.w |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.w = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.wc
    public void j(@Nullable e.l.g.t0 t0Var) {
        this.f13869m = t0Var;
        synchronized (this) {
            this.w |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
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
            j((e.l.g.t0) obj);
        }
        return true;
    }

    private xc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[12], (FrameLayout) objArr[3], (FrameLayout) objArr[5], (FrameLayout) objArr[14], (FrameLayout) objArr[16], (FrameLayout) objArr[7], (ScoreView) objArr[11], (FrameLayout) objArr[9], (View) objArr[18], (View) objArr[19], (TextView) objArr[17]);
        this.w = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ShimmerFrameLayout shimmerFrameLayout = (ShimmerFrameLayout) objArr[0];
        this.n = shimmerFrameLayout;
        shimmerFrameLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[1];
        this.o = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[10];
        this.p = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[13];
        this.q = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[15];
        this.r = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[2];
        this.s = textView4;
        textView4.setTag(null);
        NImageView nImageView = (NImageView) objArr[4];
        this.t = nImageView;
        nImageView.setTag(null);
        TextView textView5 = (TextView) objArr[6];
        this.u = textView5;
        textView5.setTag(null);
        ScoreView scoreView = (ScoreView) objArr[8];
        this.v = scoreView;
        scoreView.setTag(null);
        this.f13859c.setTag(null);
        this.f13860d.setTag(null);
        this.f13861e.setTag(null);
        this.f13862f.setTag(null);
        this.f13863g.setTag(null);
        this.f13864h.setTag(null);
        this.f13867k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
