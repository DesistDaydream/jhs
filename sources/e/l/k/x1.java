package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.ui.page.detail.ReplyListActivity;
import com.jihuanshe.ui.widget.FilterTextView;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes2.dex */
public class x1 extends w1 {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13891m = null;
    @Nullable
    private static final SparseIntArray n;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f13892j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final LinearLayout f13893k;

    /* renamed from: l  reason: collision with root package name */
    private long f13894l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.llBar, 5);
        sparseIntArray.put(R.id.llEditBot, 6);
        sparseIntArray.put(R.id.lineView, 7);
    }

    public x1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13891m, n));
    }

    private boolean m(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13894l |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.f<List<Pair<String, String>>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13894l |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.f<List<ReplyDetailInfo>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13894l |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13894l |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0146  */
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
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.x1.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13894l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13894l = 128L;
        }
        requestRebind();
    }

    @Override // e.l.k.w1
    public void j(@Nullable ReplyListActivity replyListActivity) {
        this.f13801g = replyListActivity;
        synchronized (this) {
            this.f13894l |= 16;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // e.l.k.w1
    public void k(@Nullable ReviewListViewModel reviewListViewModel) {
        this.f13803i = reviewListViewModel;
        synchronized (this) {
            this.f13894l |= 32;
        }
        notifyPropertyChanged(13);
        super.requestRebind();
    }

    @Override // e.l.k.w1
    public void l(@Nullable ReplyListViewModel replyListViewModel) {
        this.f13802h = replyListViewModel;
        synchronized (this) {
            this.f13894l |= 64;
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
                    return p((e.n.i) obj, i3);
                }
                return m((e.n.i) obj, i3);
            }
            return o((e.n.f) obj, i3);
        }
        return n((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            j((ReplyListActivity) obj);
        } else if (13 == i2) {
            k((ReviewListViewModel) obj);
        } else if (21 != i2) {
            return false;
        } else {
            l((ReplyListViewModel) obj);
        }
        return true;
    }

    private x1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (EditText) objArr[3], (FilterTextView) objArr[1], (View) objArr[7], (ListView) objArr[2], (LinearLayout) objArr[5], (LinearLayout) objArr[6]);
        this.f13894l = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13798d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13892j = constraintLayout;
        constraintLayout.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[4];
        this.f13893k = linearLayout;
        linearLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
