package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.CountDownTextView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class t2 extends s2 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13592i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13593j;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final FrameLayout f13594g;

    /* renamed from: h  reason: collision with root package name */
    private long f13595h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13593j = sparseIntArray;
        sparseIntArray.put(R.id.root, 1);
        sparseIntArray.put(R.id.adContainer, 2);
        sparseIntArray.put(R.id.logo, 3);
        sparseIntArray.put(R.id.posterView, 4);
        sparseIntArray.put(R.id.posterIv, 5);
        sparseIntArray.put(R.id.countDownTv, 6);
    }

    public t2(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13592i, f13593j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f13595h = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13595h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13595h = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        return true;
    }

    private t2(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (FrameLayout) objArr[2], (CountDownTextView) objArr[6], (ConstraintLayout) objArr[3], (NImageView) objArr[5], (FrameLayout) objArr[4], (LinearLayout) objArr[1]);
        this.f13595h = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13594g = frameLayout;
        frameLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
