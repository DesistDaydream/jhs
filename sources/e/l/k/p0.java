package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.ui.page.entrepot.ApplyForActivity;
import com.jihuanshe.viewmodel.entrepot.ApplyForViewModel;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class p0 extends o0 {
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13287l = null;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final SparseIntArray f13288m;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f13289g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final CheckBox f13290h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f13291i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TextView f13292j;

    /* renamed from: k  reason: collision with root package name */
    private long f13293k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13288m = sparseIntArray;
        sparseIntArray.put(R.id.title, 6);
        sparseIntArray.put(R.id.tips, 7);
    }

    public p0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13287l, f13288m));
    }

    private boolean k(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13293k |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean l(NLive<List<ApplyForItem>> nLive, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13293k |= 2;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 355
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.p0.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13293k != 0;
        }
    }

    @Override // e.l.k.o0
    public void i(@Nullable ApplyForActivity applyForActivity) {
        this.f13233e = applyForActivity;
        synchronized (this) {
            this.f13293k |= 4;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13293k = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.o0
    public void j(@Nullable ApplyForViewModel applyForViewModel) {
        this.f13234f = applyForViewModel;
        synchronized (this) {
            this.f13293k |= 8;
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
            return l((NLive) obj, i3);
        }
        return k((e.n.i) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ApplyForActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((ApplyForViewModel) obj);
        }
        return true;
    }

    private p0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 2, (ListView) objArr[3], (ImageView) objArr[1], (TextView) objArr[7], (TextView) objArr[6]);
        this.f13293k = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13289g = constraintLayout;
        constraintLayout.setTag(null);
        CheckBox checkBox = (CheckBox) objArr[2];
        this.f13290h = checkBox;
        checkBox.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f13291i = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[5];
        this.f13292j = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
