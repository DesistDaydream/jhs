package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.ui.widget.GameBarSmall;

/* loaded from: classes2.dex */
public class rf extends qf {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13513f = null;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final SparseIntArray f13514g;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f13515d;

    /* renamed from: e  reason: collision with root package name */
    private long f13516e;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13514g = sparseIntArray;
        sparseIntArray.put(R.id.backIv, 2);
    }

    public rf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13513f, f13514g));
    }

    private boolean i(e.n.f<Game> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13516e |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13516e;
            this.f13516e = 0L;
        }
        String str = null;
        int i2 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i2 != 0) {
            e.n.f<Game> curGame = GameBar.getCurGame();
            updateLiveDataRegistration(0, curGame);
            Game value = curGame != null ? curGame.getValue() : null;
            if (value != null) {
                str = value.getShortName();
            }
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // e.l.k.qf
    public void h(@Nullable GameBarSmall gameBarSmall) {
        this.f13449c = gameBarSmall;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13516e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13516e = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            return false;
        }
        return i((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((GameBarSmall) obj);
            return true;
        }
        return false;
    }

    private rf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (ImageView) objArr[2], (TextView) objArr[1]);
        this.f13516e = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13515d = constraintLayout;
        constraintLayout.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
