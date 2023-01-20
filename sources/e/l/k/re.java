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
import com.jihuanshe.ui.widget.PhonePopupWindow;
import java.util.List;

/* loaded from: classes2.dex */
public class re extends qe {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13507g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f13508h = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f13509c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13510d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13511e;

    /* renamed from: f  reason: collision with root package name */
    private long f13512f;

    public re(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f13507g, f13508h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        e.t.j.h.g gVar3;
        List<String> list;
        synchronized (this) {
            j2 = this.f13512f;
            this.f13512f = 0L;
        }
        PhonePopupWindow phonePopupWindow = this.a;
        String str3 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (phonePopupWindow != null) {
                gVar = phonePopupWindow.f(2);
                list = phonePopupWindow.a();
                gVar3 = phonePopupWindow.f(1);
                gVar2 = phonePopupWindow.f(0);
            } else {
                gVar = null;
                gVar2 = null;
                list = null;
                gVar3 = null;
            }
            if (list != null) {
                String str4 = list.get(1);
                str2 = list.get(2);
                str3 = list.get(0);
                str = str4;
            } else {
                str = null;
                str2 = null;
            }
        } else {
            str = null;
            str2 = null;
            gVar = null;
            gVar2 = null;
            gVar3 = null;
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.f13509c, str3);
            e.t.j.g.e0.F(this.f13509c, gVar2);
            TextViewBindingAdapter.setText(this.f13510d, str);
            e.t.j.g.e0.F(this.f13510d, gVar3);
            TextViewBindingAdapter.setText(this.f13511e, str2);
            e.t.j.g.e0.F(this.f13511e, gVar);
        }
    }

    @Override // e.l.k.qe
    public void h(@Nullable PhonePopupWindow phonePopupWindow) {
        this.a = phonePopupWindow;
        synchronized (this) {
            this.f13512f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13512f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13512f = 2L;
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
            h((PhonePopupWindow) obj);
            return true;
        }
        return false;
    }

    private re(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13512f = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13509c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f13510d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f13511e = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
