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
import com.jihuanshe.R;
import com.jihuanshe.base.wheelview.WheelDatePicker;
import com.jihuanshe.ui.dialog.DateOfBirthDialog;

/* loaded from: classes2.dex */
public class n4 extends m4 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13175h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f13176i;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f13177d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13178e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f13179f;

    /* renamed from: g  reason: collision with root package name */
    private long f13180g;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13176i = sparseIntArray;
        sparseIntArray.put(R.id.date_of_birth_wheel_picker, 4);
    }

    public n4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13175h, f13176i));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        String str;
        synchronized (this) {
            j2 = this.f13180g;
            this.f13180g = 0L;
        }
        DateOfBirthDialog dateOfBirthDialog = this.f13113c;
        e.t.j.h.g gVar2 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || dateOfBirthDialog == null) {
            gVar = null;
            str = null;
        } else {
            gVar2 = dateOfBirthDialog.getClickClose();
            gVar = dateOfBirthDialog.getClickDone();
            str = dateOfBirthDialog.getTitle();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f13178e, gVar2);
            e.t.j.g.e0.F(this.f13179f, gVar);
            TextViewBindingAdapter.setText(this.b, str);
        }
    }

    @Override // e.l.k.m4
    public void h(@Nullable DateOfBirthDialog dateOfBirthDialog) {
        this.f13113c = dateOfBirthDialog;
        synchronized (this) {
            this.f13180g |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13180g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13180g = 2L;
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
            h((DateOfBirthDialog) obj);
            return true;
        }
        return false;
    }

    private n4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (WheelDatePicker) objArr[4], (TextView) objArr[2]);
        this.f13180g = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13177d = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13178e = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.f13179f = textView2;
        textView2.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
