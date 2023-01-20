package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardPackage;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class xe extends we {
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13925j = null;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final SparseIntArray f13926k;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final RelativeLayout f13927f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13928g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final TextView f13929h;

    /* renamed from: i  reason: collision with root package name */
    private long f13930i;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13926k = sparseIntArray;
        sparseIntArray.put(R.id.top, 5);
    }

    public xe(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13925j, f13926k));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 179
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.xe.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13930i != 0;
        }
    }

    @Override // e.l.k.we
    public void i(@Nullable CardPackage cardPackage) {
        this.f13878d = cardPackage;
        synchronized (this) {
            this.f13930i |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13930i = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.we
    public void j(@Nullable e.t.r.a.h hVar) {
        this.f13879e = hVar;
        synchronized (this) {
            this.f13930i |= 2;
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
            i((CardPackage) obj);
        } else if (17 != i2) {
            return false;
        } else {
            j((e.t.r.a.h) obj);
        }
        return true;
    }

    private xe(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[2], (FrameLayout) objArr[5], (TextView) objArr[3]);
        this.f13930i = -1L;
        this.a.setTag(null);
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f13927f = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13928g = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[4];
        this.f13929h = textView2;
        textView2.setTag(null);
        this.f13877c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
