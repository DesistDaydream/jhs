package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.model.EtiquetteAnswer;

/* loaded from: classes2.dex */
public class t8 extends s8 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13621i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13622j = null;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13623g;

    /* renamed from: h  reason: collision with root package name */
    private long f13624h;

    public t8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13621i, f13622j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13624h;
            this.f13624h = 0L;
        }
        String str = null;
        EtiquetteAnswer etiquetteAnswer = this.f13560d;
        Boolean bool = this.f13562f;
        String str2 = this.f13561e;
        int i2 = ((17 & j2) > 0L ? 1 : ((17 & j2) == 0L ? 0 : -1));
        if (i2 != 0 && etiquetteAnswer != null) {
            str = etiquetteAnswer.getAnswerContent();
        }
        int i3 = ((18 & j2) > 0L ? 1 : ((18 & j2) == 0L ? 0 : -1));
        boolean safeUnbox = i3 != 0 ? ViewDataBinding.safeUnbox(bool) : false;
        int i4 = ((j2 & 24) > 0L ? 1 : ((j2 & 24) == 0L ? 0 : -1));
        if (i3 != 0) {
            e.t.j.g.e0.K(this.a, safeUnbox);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.b, str);
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.f13623g, str2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13624h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13624h = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.s8
    public void k(@Nullable e.l.q.c.s0.a aVar) {
        this.f13559c = aVar;
    }

    @Override // e.l.k.s8
    public void l(@Nullable String str) {
        this.f13561e = str;
        synchronized (this) {
            this.f13624h |= 8;
        }
        notifyPropertyChanged(7);
        super.requestRebind();
    }

    @Override // e.l.k.s8
    public void m(@Nullable EtiquetteAnswer etiquetteAnswer) {
        this.f13560d = etiquetteAnswer;
        synchronized (this) {
            this.f13624h |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.s8
    public void n(@Nullable Boolean bool) {
        this.f13562f = bool;
        synchronized (this) {
            this.f13624h |= 2;
        }
        notifyPropertyChanged(15);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            m((EtiquetteAnswer) obj);
        } else if (15 == i2) {
            n((Boolean) obj);
        } else if (2 == i2) {
            k((e.l.q.c.s0.a) obj);
        } else if (7 != i2) {
            return false;
        } else {
            l((String) obj);
        }
        return true;
    }

    private t8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (LinearLayout) objArr[0], (TextView) objArr[2]);
        this.f13624h = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13623g = textView;
        textView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
