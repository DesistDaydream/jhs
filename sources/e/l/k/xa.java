package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.adapter.LikeAdapter;
import com.jihuanshe.model.InteractData;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class xa extends wa {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts o = null;
    @Nullable
    private static final SparseIntArray p;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f13914j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final TextView f13915k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f13916l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final NImageView f13917m;
    private long n;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p = sparseIntArray;
        sparseIntArray.put(R.id.oriMedia, 9);
    }

    public xa(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, o, p));
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00bd  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.xa.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.wa
    public void j(@Nullable LikeAdapter likeAdapter) {
        this.f13856g = likeAdapter;
        synchronized (this) {
            this.n |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // e.l.k.wa
    public void k(@Nullable InteractData interactData) {
        this.f13857h = interactData;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.wa
    public void l(@Nullable Integer num) {
        this.f13858i = num;
        synchronized (this) {
            this.n |= 2;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            k((InteractData) obj);
        } else if (11 == i2) {
            l((Integer) obj);
        } else if (2 != i2) {
            return false;
        } else {
            j((LikeAdapter) obj);
        }
        return true;
    }

    private xa(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[2], (TextView) objArr[3], (FrameLayout) objArr[9], (View) objArr[5], (View) objArr[1], (TextView) objArr[4]);
        this.n = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13914j = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.f13915k = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[7];
        this.f13916l = textView2;
        textView2.setTag(null);
        NImageView nImageView = (NImageView) objArr[8];
        this.f13917m = nImageView;
        nImageView.setTag(null);
        this.b.setTag(null);
        this.f13853d.setTag(null);
        this.f13854e.setTag(null);
        this.f13855f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
