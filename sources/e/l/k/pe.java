package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.OnePopupWindow;

/* loaded from: classes2.dex */
public class pe extends oe {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13351f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13352g;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final RelativeLayout f13353c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13354d;

    /* renamed from: e  reason: collision with root package name */
    private long f13355e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13352g = sparseIntArray;
        sparseIntArray.put(R.id.list, 2);
    }

    public pe(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13351f, f13352g));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        synchronized (this) {
            j2 = this.f13355e;
            this.f13355e = 0L;
        }
        OnePopupWindow onePopupWindow = this.b;
        String str = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || onePopupWindow == null) {
            gVar = null;
        } else {
            str = onePopupWindow.d();
            gVar = onePopupWindow.c();
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f13354d, str);
            e.t.j.g.e0.F(this.f13354d, gVar);
        }
    }

    @Override // e.l.k.oe
    public void h(@Nullable OnePopupWindow onePopupWindow) {
        this.b = onePopupWindow;
        synchronized (this) {
            this.f13355e |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13355e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13355e = 2L;
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
            h((OnePopupWindow) obj);
            return true;
        }
        return false;
    }

    private pe(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[2]);
        this.f13355e = -1L;
        RelativeLayout relativeLayout = (RelativeLayout) objArr[0];
        this.f13353c = relativeLayout;
        relativeLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13354d = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
