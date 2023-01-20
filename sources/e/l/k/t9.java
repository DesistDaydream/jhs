package e.l.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public class t9 extends s9 {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13625f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13626g = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final FrameLayout f13627c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13628d;

    /* renamed from: e  reason: collision with root package name */
    private long f13629e;

    public t9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13625f, f13626g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        Drawable drawable;
        Context context;
        int i2;
        synchronized (this) {
            j2 = this.f13629e;
            this.f13629e = 0L;
        }
        Boolean bool = this.b;
        e.l.g.z zVar = this.a;
        String str = null;
        int i3 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i3 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i3 != 0) {
                j2 |= safeUnbox ? 16L : 8L;
            }
            if (safeUnbox) {
                context = this.f13628d.getContext();
                i2 = R.drawable.ripple_f8f8f8;
            } else {
                context = this.f13628d.getContext();
                i2 = R.drawable.ripple_default;
            }
            drawable = AppCompatResources.getDrawable(context, i2);
        } else {
            drawable = null;
        }
        int i4 = ((6 & j2) > 0L ? 1 : ((6 & j2) == 0L ? 0 : -1));
        if (i4 != 0 && zVar != null) {
            str = zVar.getShowContent();
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.f13628d, str);
        }
        if ((j2 & 5) != 0) {
            ViewBindingAdapter.setBackground(this.f13628d, drawable);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13629e != 0;
        }
    }

    @Override // e.l.k.s9
    public void i(@Nullable e.l.g.z zVar) {
        this.a = zVar;
        synchronized (this) {
            this.f13629e |= 2;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13629e = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.s9
    public void j(@Nullable Boolean bool) {
        this.b = bool;
        synchronized (this) {
            this.f13629e |= 1;
        }
        notifyPropertyChanged(14);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (14 == i2) {
            j((Boolean) obj);
        } else if (8 != i2) {
            return false;
        } else {
            i((e.l.g.z) obj);
        }
        return true;
    }

    private t9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13629e = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.f13627c = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13628d = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
