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
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.ui.page.detail.ReplyListActivity;
import com.jihuanshe.ui.widget.ScoreView;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class zf extends yf {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts t = null;
    @Nullable
    private static final SparseIntArray u;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ConstraintLayout f14082m;
    @NonNull
    private final TextView n;
    @NonNull
    private final ImageView o;
    @NonNull
    private final TextView p;
    @NonNull
    private final TextView q;
    @NonNull
    private final ImageView r;
    private long s;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        u = sparseIntArray;
        sparseIntArray.put(R.id.ll, 15);
    }

    public zf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 16, t, u));
    }

    private boolean k(e.n.f<ReplyDetailInfo> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.s |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.s |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.s |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01f1  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x026d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:135:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00d9  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 759
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.zf.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.s != 0;
        }
    }

    @Override // e.l.k.yf
    public void i(@Nullable ReplyListActivity replyListActivity) {
        this.f14016k = replyListActivity;
        synchronized (this) {
            this.s |= 8;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.s = 32L;
        }
        requestRebind();
    }

    @Override // e.l.k.yf
    public void j(@Nullable ReplyListViewModel replyListViewModel) {
        this.f14017l = replyListViewModel;
        synchronized (this) {
            this.s |= 16;
        }
        notifyPropertyChanged(21);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    return false;
                }
                return k((e.n.f) obj, i3);
            }
            return l((e.n.l) obj, i3);
        }
        return m((e.n.i) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ReplyListActivity) obj);
        } else if (21 != i2) {
            return false;
        } else {
            j((ReplyListViewModel) obj);
        }
        return true;
    }

    private zf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 3, (NImageView) objArr[2], (View) objArr[13], (LinearLayout) objArr[15], (LinearLayout) objArr[10], (LinearLayout) objArr[1], (ScoreView) objArr[6], (TextView) objArr[5], (TextView) objArr[11], (TextView) objArr[12], (TextView) objArr[14]);
        this.s = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f14009d.setTag(null);
        this.f14010e.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14082m = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.n = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[4];
        this.o = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.p = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[8];
        this.q = textView3;
        textView3.setTag(null);
        ImageView imageView2 = (ImageView) objArr[9];
        this.r = imageView2;
        imageView2.setTag(null);
        this.f14011f.setTag(null);
        this.f14012g.setTag(null);
        this.f14013h.setTag(null);
        this.f14014i.setTag(null);
        this.f14015j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
