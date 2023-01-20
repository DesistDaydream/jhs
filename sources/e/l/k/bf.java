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
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.ConditionView;

/* loaded from: classes2.dex */
public class bf extends af {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12373i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f12374j;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f12375f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f12376g;

    /* renamed from: h  reason: collision with root package name */
    private long f12377h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12374j = sparseIntArray;
        sparseIntArray.put(R.id.starTv, 3);
        sparseIntArray.put(R.id.conditionTitleTv, 4);
    }

    public bf(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12373i, f12374j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f12377h;
            this.f12377h = 0L;
        }
        GameCard gameCard = this.f12303e;
        e.l.q.b.b.a.c cVar = this.f12302d;
        e.t.j.h.g gVar = null;
        int i2 = ((5 & j2) > 0L ? 1 : ((5 & j2) == 0L ? 0 : -1));
        Integer condition = (i2 == 0 || gameCard == null) ? null : gameCard.getCondition();
        int i3 = ((j2 & 6) > 0L ? 1 : ((j2 & 6) == 0L ? 0 : -1));
        if (i3 != 0 && cVar != null) {
            gVar = cVar.a();
        }
        if (i2 != 0) {
            e.l.i.g.a(this.b, condition);
        }
        if (i3 != 0) {
            e.t.j.g.e0.F(this.f12376g, gVar);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12377h != 0;
        }
    }

    @Override // e.l.k.af
    public void i(@Nullable GameCard gameCard) {
        this.f12303e = gameCard;
        synchronized (this) {
            this.f12377h |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12377h = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.af
    public void j(@Nullable e.l.q.b.b.a.c cVar) {
        this.f12302d = cVar;
        synchronized (this) {
            this.f12377h |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((GameCard) obj);
        } else if (10 != i2) {
            return false;
        } else {
            j((e.l.q.b.b.a.c) obj);
        }
        return true;
    }

    private bf(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[4], (ConditionView) objArr[1], (TextView) objArr[3]);
        this.f12377h = -1L;
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12375f = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12376g = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
