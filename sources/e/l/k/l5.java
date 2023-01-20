package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.PosterDialog;
import com.vector.network.image.NImageView;
import com.vector.network.image.ScaleType;

/* loaded from: classes2.dex */
public class l5 extends k5 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13050h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f13051i;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final FrameLayout f13052e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f13053f;

    /* renamed from: g  reason: collision with root package name */
    private long f13054g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13051i = sparseIntArray;
        sparseIntArray.put(R.id.placeholder, 4);
    }

    public l5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13050h, f13051i));
    }

    private boolean i(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13054g |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        String str;
        synchronized (this) {
            j2 = this.f13054g;
            this.f13054g = 0L;
        }
        PosterDialog posterDialog = this.f13002d;
        e.t.j.h.g gVar2 = null;
        int i2 = ((7 & j2) > 0L ? 1 : ((7 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            e.n.p F = posterDialog != null ? posterDialog.F() : null;
            updateLiveDataRegistration(0, F);
            String value = F != null ? F.getValue() : null;
            if ((j2 & 6) == 0 || posterDialog == null) {
                str = value;
                gVar = null;
            } else {
                gVar2 = posterDialog.C();
                gVar = posterDialog.D();
                str = value;
            }
        } else {
            gVar = null;
            str = null;
        }
        if ((j2 & 6) != 0) {
            e.t.j.g.e0.F(this.a, gVar2);
            e.t.j.g.e0.F(this.f13053f, gVar);
        }
        if (i2 != 0) {
            e.t.j.g.y.a(this.f13001c, str, null, null, null, null, null, null, null, ScaleType.FIT_CENTER, null, null, null, null, Boolean.TRUE, null, null);
        }
    }

    @Override // e.l.k.k5
    public void h(@Nullable PosterDialog posterDialog) {
        this.f13002d = posterDialog;
        synchronized (this) {
            this.f13054g |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13054g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13054g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return i((e.n.p) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((PosterDialog) obj);
            return true;
        }
        return false;
    }

    private l5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[1], (View) objArr[4], (NImageView) objArr[2]);
        this.f13054g = -1L;
        this.a.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13052e = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f13053f = textView;
        textView.setTag(null);
        this.f13001c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
