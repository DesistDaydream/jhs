package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.ui.dialog.EditUserDialog;
import com.vector.databinding.adapter.EditTextBinding;
import com.vector.databinding.adapter.TextViewBinding;

/* loaded from: classes2.dex */
public class t4 extends s4 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13602h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f13603i = null;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ConstraintLayout f13604d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f13605e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f13606f;

    /* renamed from: g  reason: collision with root package name */
    private long f13607g;

    public t4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13602h, f13603i));
    }

    private boolean i(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.f13607g |= 1;
            }
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        e.t.j.h.a aVar;
        e.t.j.h.g gVar;
        String str2;
        String str3;
        e.t.j.h.g gVar2;
        int i2;
        String str4;
        e.t.j.h.a aVar2;
        e.t.j.h.g gVar3;
        int i3;
        boolean z;
        synchronized (this) {
            j2 = this.f13607g;
            this.f13607g = 0L;
        }
        EditUserDialog editUserDialog = this.f13550c;
        int i4 = 0;
        if ((j2 & 7) != 0) {
            int i5 = ((j2 & 6) > 0L ? 1 : ((j2 & 6) == 0L ? 0 : -1));
            if (i5 != 0) {
                if (editUserDialog != null) {
                    str2 = editUserDialog.getOldText();
                    z = editUserDialog.C();
                    gVar2 = editUserDialog.getOnConfirm();
                    str4 = editUserDialog.getTips();
                    i3 = editUserDialog.getMax();
                    aVar2 = editUserDialog.getAfterTC();
                    gVar3 = editUserDialog.getOnClose();
                } else {
                    str2 = null;
                    gVar2 = null;
                    str4 = null;
                    aVar2 = null;
                    gVar3 = null;
                    z = false;
                    i3 = 0;
                }
                if (i5 != 0) {
                    j2 |= z ? 16L : 8L;
                }
                i2 = z ? 8194 : 1;
            } else {
                str2 = null;
                gVar2 = null;
                str4 = null;
                aVar2 = null;
                gVar3 = null;
                i2 = 0;
                i3 = 0;
            }
            e.n.p hintStr = editUserDialog != null ? editUserDialog.getHintStr() : null;
            updateLiveDataRegistration(0, hintStr);
            str = hintStr != null ? hintStr.getValue() : null;
            str3 = str4;
            i4 = i3;
            aVar = aVar2;
            gVar = gVar3;
        } else {
            str = null;
            aVar = null;
            gVar = null;
            str2 = null;
            str3 = null;
            gVar2 = null;
            i2 = 0;
        }
        if ((6 & j2) != 0) {
            TextViewBindingAdapter.setText(this.a, str2);
            EditTextBinding.f(this.a, Integer.valueOf(i4));
            TextViewBinding.f(this.a, i2);
            EditTextBinding.g(this.a, null, null, aVar);
            e.t.j.g.e0.F(this.f13605e, gVar);
            e.t.j.g.e0.F(this.f13606f, gVar2);
            TextViewBindingAdapter.setText(this.b, str3);
        }
        if ((j2 & 7) != 0) {
            this.a.setHint(str);
        }
    }

    @Override // e.l.k.s4
    public void h(@Nullable EditUserDialog editUserDialog) {
        this.f13550c = editUserDialog;
        synchronized (this) {
            this.f13607g |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13607g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13607g = 4L;
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
            h((EditUserDialog) obj);
            return true;
        }
        return false;
    }

    private t4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (EditText) objArr[3], (TextView) objArr[2]);
        this.f13607g = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13604d = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f13605e = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f13606f = textView;
        textView.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
