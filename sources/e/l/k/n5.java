package e.l.k;

import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.PrivateDialog;
import com.vector.databinding.adapter.TextViewBinding;

/* loaded from: classes2.dex */
public class n5 extends m5 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13181i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13182j;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f13183f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13184g;

    /* renamed from: h  reason: collision with root package name */
    private long f13185h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13182j = sparseIntArray;
        sparseIntArray.put(R.id.title, 4);
        sparseIntArray.put(R.id.contentTv, 5);
    }

    public n5(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13181i, f13182j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        LinkMovementMethod linkMovementMethod;
        e.t.j.h.g gVar;
        SpannableStringBuilder spannableStringBuilder;
        synchronized (this) {
            j2 = this.f13185h;
            this.f13185h = 0L;
        }
        PrivateDialog privateDialog = this.f13116e;
        e.t.j.h.g gVar2 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || privateDialog == null) {
            linkMovementMethod = null;
            gVar = null;
            spannableStringBuilder = null;
        } else {
            LinkMovementMethod movementMethod = privateDialog.getMovementMethod();
            e.t.j.h.g onRejectClick = privateDialog.getOnRejectClick();
            gVar = privateDialog.getOnOKClick();
            spannableStringBuilder = privateDialog.getPrivateTips();
            gVar2 = onRejectClick;
            linkMovementMethod = movementMethod;
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.a, gVar2);
            TextViewBindingAdapter.setText(this.f13184g, spannableStringBuilder);
            TextViewBinding.h(this.f13184g, linkMovementMethod);
            e.t.j.g.e0.F(this.f13114c, gVar);
        }
    }

    @Override // e.l.k.m5
    public void h(@Nullable PrivateDialog privateDialog) {
        this.f13116e = privateDialog;
        synchronized (this) {
            this.f13185h |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13185h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13185h = 2L;
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
            h((PrivateDialog) obj);
            return true;
        }
        return false;
    }

    private n5(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[2], (ScrollView) objArr[5], (TextView) objArr[3], (TextView) objArr[4]);
        this.f13185h = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13183f = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13184g = textView;
        textView.setTag(null);
        this.f13114c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
