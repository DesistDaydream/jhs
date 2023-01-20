package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;

/* loaded from: classes2.dex */
public class nf extends mf {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13222d = null;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static final SparseIntArray f13223e = null;
    @NonNull
    private final ConstraintLayout b;

    /* renamed from: c  reason: collision with root package name */
    private long f13224c;

    public nf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 2, f13222d, f13223e));
    }

    private boolean g(e.n.f<Game> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13224c |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13224c;
            this.f13224c = 0L;
        }
        String str = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            e.n.f<Game> curGame = GameBar.getCurGame();
            updateLiveDataRegistration(0, curGame);
            Game value = curGame != null ? curGame.getValue() : null;
            if (value != null) {
                str = value.getShortName();
            }
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.a, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13224c != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13224c = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return g((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        return true;
    }

    private nf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (TextView) objArr[1]);
        this.f13224c = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.b = constraintLayout;
        constraintLayout.setTag(null);
        this.a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
