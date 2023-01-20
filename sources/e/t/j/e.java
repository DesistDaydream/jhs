package e.t.j;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.vector.view.SideBar;

/* loaded from: classes3.dex */
public class e extends d {
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14475e = null;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final SparseIntArray f14476f = null;
    @NonNull
    private final FrameLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f14477c;

    /* renamed from: d  reason: collision with root package name */
    private long f14478d;

    public e(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f14475e, f14476f));
    }

    private boolean i(ObservableField<String> observableField, int i2) {
        if (i2 == e.t.b.a) {
            synchronized (this) {
                this.f14478d |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f14478d;
            this.f14478d = 0L;
        }
        SideBar sideBar = this.a;
        String str = null;
        int i2 = ((j2 & 7) > 0L ? 1 : ((j2 & 7) == 0L ? 0 : -1));
        if (i2 != 0) {
            ObservableField<String> showWord = sideBar != null ? sideBar.getShowWord() : null;
            updateRegistration(0, showWord);
            if (showWord != null) {
                str = showWord.get();
            }
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f14477c, str);
        }
    }

    @Override // e.t.j.d
    public void h(@Nullable SideBar sideBar) {
        this.a = sideBar;
        synchronized (this) {
            this.f14478d |= 2;
        }
        notifyPropertyChanged(e.t.b.f14443k);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14478d != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14478d = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return i((ObservableField) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (e.t.b.f14443k == i2) {
            h((SideBar) obj);
            return true;
        }
        return false;
    }

    private e(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1);
        this.f14478d = -1L;
        FrameLayout frameLayout = (FrameLayout) objArr[0];
        this.b = frameLayout;
        frameLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f14477c = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
