package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.preview.ImagePreviewActivity;
import com.jihuanshe.ui.widget.imagepreview.wight.BezierBannerView;
import com.jihuanshe.ui.widget.imagepreview.wight.PhotoViewPager;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class d1 extends c1 {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12473k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f12474l;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f12475i;

    /* renamed from: j  reason: collision with root package name */
    private long f12476j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12474l = sparseIntArray;
        sparseIntArray.put(R.id.viewPager, 1);
        sparseIntArray.put(R.id.ltAddDot, 2);
        sparseIntArray.put(R.id.bezierBannerView, 3);
        sparseIntArray.put(R.id.cl, 4);
        sparseIntArray.put(R.id.tvTip, 5);
        sparseIntArray.put(R.id.avatarIv, 6);
        sparseIntArray.put(R.id.tvName, 7);
    }

    public d1(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f12473k, f12474l));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.f12476j = 0L;
        }
    }

    @Override // e.l.k.c1
    public void h(@Nullable ImagePreviewActivity imagePreviewActivity) {
        this.f12388h = imagePreviewActivity;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12476j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12476j = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((ImagePreviewActivity) obj);
            return true;
        }
        return false;
    }

    private d1(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[6], (BezierBannerView) objArr[3], (ConstraintLayout) objArr[4], (TextView) objArr[2], (TextView) objArr[7], (TextView) objArr[5], (PhotoViewPager) objArr[1]);
        this.f12476j = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12475i = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
