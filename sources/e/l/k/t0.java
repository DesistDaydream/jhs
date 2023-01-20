package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.EtiquetteQuestion;
import com.jihuanshe.ui.page.exam.EtiquetteExamActivity;
import com.jihuanshe.ui.widget.exam.ExamIndicatorView;
import com.jihuanshe.ui.widget.exam.ExamQuizView;
import com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel;
import java.util.List;

/* loaded from: classes2.dex */
public class t0 extends s0 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts q = null;
    @Nullable
    private static final SparseIntArray r;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final FrameLayout f13585k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f13586l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final LinearLayout f13587m;
    @NonNull
    private final LinearLayout n;
    @NonNull
    private final TextView o;
    private long p;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r = sparseIntArray;
        sparseIntArray.put(R.id.titleTv, 10);
        sparseIntArray.put(R.id.currentIndexTv, 11);
        sparseIntArray.put(R.id.totalCountTv, 12);
    }

    public t0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, q, r));
    }

    private boolean k(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.p |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<EtiquetteQuestion> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.p |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.f<List<Integer>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.p |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.f<CharSequence> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.p |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.p |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.p |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean q(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.p |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean r(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.p |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c8  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 674
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.t0.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.p != 0;
        }
    }

    @Override // e.l.k.s0
    public void i(@Nullable EtiquetteExamActivity etiquetteExamActivity) {
        this.f13538i = etiquetteExamActivity;
        synchronized (this) {
            this.p |= 256;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.p = 1024L;
        }
        requestRebind();
    }

    @Override // e.l.k.s0
    public void j(@Nullable EtiquetteExamViewModel etiquetteExamViewModel) {
        this.f13539j = etiquetteExamViewModel;
        synchronized (this) {
            this.p |= 512;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return o((e.n.i) obj, i3);
            case 1:
                return r((e.n.l) obj, i3);
            case 2:
                return n((e.n.f) obj, i3);
            case 3:
                return l((e.n.f) obj, i3);
            case 4:
                return k((e.n.l) obj, i3);
            case 5:
                return m((e.n.f) obj, i3);
            case 6:
                return q((e.n.l) obj, i3);
            case 7:
                return p((e.n.p) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((EtiquetteExamActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((EtiquetteExamViewModel) obj);
        }
        return true;
    }

    private t0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (TextView) objArr[11], (ConstraintLayout) objArr[3], (ExamIndicatorView) objArr[4], (TextView) objArr[9], (ExamQuizView) objArr[5], (LinearLayout) objArr[1], (TextView) objArr[10], (TextView) objArr[12]);
        this.p = -1L;
        this.b.setTag(null);
        this.f13532c.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13585k = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13586l = textView;
        textView.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[6];
        this.f13587m = linearLayout;
        linearLayout.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[7];
        this.n = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView2 = (TextView) objArr[8];
        this.o = textView2;
        textView2.setTag(null);
        this.f13533d.setTag(null);
        this.f13534e.setTag(null);
        this.f13535f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
