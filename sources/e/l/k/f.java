package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.order.AddAddressActivity;

/* loaded from: classes2.dex */
public class f extends e {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p = null;
    @Nullable
    private static final SparseIntArray q;
    @NonNull
    private final LinearLayout n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.contactTv, 7);
        sparseIntArray.put(R.id.phoneTv, 8);
        sparseIntArray.put(R.id.phoneLayout, 9);
        sparseIntArray.put(R.id.provinceTv, 10);
        sparseIntArray.put(R.id.addressTv, 11);
        sparseIntArray.put(R.id.btnSwitch, 12);
    }

    public f(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 13, p, q));
    }

    private boolean i(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 1;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            r18 = this;
            r1 = r18
            monitor-enter(r18)
            long r2 = r1.o     // Catch: java.lang.Throwable -> Lc2
            r4 = 0
            r1.o = r4     // Catch: java.lang.Throwable -> Lc2
            monitor-exit(r18)     // Catch: java.lang.Throwable -> Lc2
            com.jihuanshe.ui.page.order.AddAddressActivity r0 = r1.f12538m
            r6 = 7
            long r6 = r6 & r2
            r8 = 6
            int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r11 == 0) goto L76
            long r6 = r2 & r8
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 == 0) goto L4c
            if (r0 == 0) goto L32
            e.t.j.h.g r6 = r0.h0()
            com.jihuanshe.model.UserAddress r7 = r0.e0()
            e.t.j.h.a r12 = r0.i0()
            e.t.j.h.g r13 = r0.g0()
            e.t.j.h.g r14 = r0.f0()
            goto L37
        L32:
            r6 = 0
            r7 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L37:
            if (r7 == 0) goto L4a
            java.lang.String r15 = r7.getAddressDetail()
            java.lang.String r16 = r7.getAddress()
            java.lang.String r17 = r7.getPhone()
            java.lang.String r7 = r7.getName()
            goto L56
        L4a:
            r7 = 0
            goto L51
        L4c:
            r6 = 0
            r7 = 0
            r12 = 0
            r13 = 0
            r14 = 0
        L51:
            r15 = 0
            r16 = 0
            r17 = 0
        L56:
            if (r0 == 0) goto L5d
            e.n.p r0 = r0.j0()
            goto L5e
        L5d:
            r0 = 0
        L5e:
            r10 = 0
            r1.updateLiveDataRegistration(r10, r0)
            if (r0 == 0) goto L71
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r10 = r16
            r16 = r0
            r0 = r17
            goto L80
        L71:
            r10 = r16
            r0 = r17
            goto L7e
        L76:
            r0 = 0
            r6 = 0
            r7 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L7e:
            r16 = 0
        L80:
            long r2 = r2 & r8
            int r8 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r8 == 0) goto Lb8
            android.widget.EditText r2 = r1.a
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r10)
            android.widget.EditText r2 = r1.a
            r3 = 0
            com.vector.databinding.adapter.EditTextBinding.g(r2, r3, r3, r12)
            android.widget.TextView r2 = r1.f12529d
            e.t.j.g.e0.F(r2, r14)
            android.widget.EditText r2 = r1.f12530e
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r7)
            android.widget.EditText r2 = r1.f12530e
            com.vector.databinding.adapter.EditTextBinding.g(r2, r3, r3, r12)
            android.widget.EditText r2 = r1.f12532g
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r2, r0)
            android.widget.EditText r0 = r1.f12532g
            com.vector.databinding.adapter.EditTextBinding.g(r0, r3, r3, r12)
            android.widget.TextView r0 = r1.f12535j
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r15)
            android.widget.TextView r0 = r1.f12535j
            e.t.j.g.e0.F(r0, r13)
            android.widget.TextView r0 = r1.f12537l
            e.t.j.g.e0.F(r0, r6)
        Lb8:
            if (r11 == 0) goto Lc1
            android.widget.TextView r0 = r1.f12529d
            r2 = r16
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r2)
        Lc1:
            return
        Lc2:
            r0 = move-exception
            monitor-exit(r18)     // Catch: java.lang.Throwable -> Lc2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.f.executeBindings():void");
    }

    @Override // e.l.k.e
    public void h(@Nullable AddAddressActivity addAddressActivity) {
        this.f12538m = addAddressActivity;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 4L;
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
            h((AddAddressActivity) obj);
            return true;
        }
        return false;
    }

    private f(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (EditText) objArr[5], (TextView) objArr[11], (SwitchMaterial) objArr[12], (TextView) objArr[2], (EditText) objArr[1], (TextView) objArr[7], (EditText) objArr[3], (LinearLayout) objArr[9], (TextView) objArr[8], (TextView) objArr[4], (TextView) objArr[10], (TextView) objArr[6]);
        this.o = -1L;
        this.a.setTag(null);
        this.f12529d.setTag(null);
        this.f12530e.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.n = linearLayout;
        linearLayout.setTag(null);
        this.f12532g.setTag(null);
        this.f12535j.setTag(null);
        this.f12537l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
