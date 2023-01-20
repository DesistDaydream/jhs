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
import com.jihuanshe.ui.page.photo.ChoosePhotoActivity;

/* loaded from: classes2.dex */
public class z extends y {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14018i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f14019j;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f14020e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f14021f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f14022g;

    /* renamed from: h  reason: collision with root package name */
    private long f14023h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14019j = sparseIntArray;
        sparseIntArray.put(R.id.fragmentContainer, 3);
        sparseIntArray.put(R.id.bottom, 4);
    }

    public z(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f14018i, f14019j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        synchronized (this) {
            j2 = this.f14023h;
            this.f14023h = 0L;
        }
        ChoosePhotoActivity choosePhotoActivity = this.f13935c;
        e.t.j.h.g gVar2 = null;
        int i2 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i2 == 0 || choosePhotoActivity == null) {
            gVar = null;
        } else {
            e.t.j.h.g Y = choosePhotoActivity.Y();
            gVar2 = choosePhotoActivity.Z();
            gVar = Y;
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f14021f, gVar2);
            e.t.j.g.e0.F(this.f14022g, gVar);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14023h != 0;
        }
    }

    @Override // e.l.k.y
    public void i(@Nullable ChoosePhotoActivity choosePhotoActivity) {
        this.f13935c = choosePhotoActivity;
        synchronized (this) {
            this.f14023h |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14023h = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.y
    public void j(@Nullable e.l.s.k.a aVar) {
        this.f13936d = aVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((ChoosePhotoActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.k.a) obj);
        }
        return true;
    }

    private z(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[4], (FrameLayout) objArr[3]);
        this.f14023h = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f14020e = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f14021f = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f14022g = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
