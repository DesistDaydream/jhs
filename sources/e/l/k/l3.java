package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.dialog.BackGoodReasonDialog;

/* loaded from: classes2.dex */
public class l3 extends k3 {
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13037h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final SparseIntArray f13038i = null;
    @NonNull
    private final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final TextView f13039c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13040d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13041e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f13042f;

    /* renamed from: g  reason: collision with root package name */
    private long f13043g;

    public l3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13037h, f13038i));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.f13043g;
            this.f13043g = 0L;
        }
        BackGoodReasonDialog backGoodReasonDialog = this.a;
        e.t.j.h.g gVar = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0 && backGoodReasonDialog != null) {
            gVar = backGoodReasonDialog.getOnChoose();
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f13039c, gVar);
            e.t.j.g.e0.F(this.f13040d, gVar);
            e.t.j.g.e0.F(this.f13041e, gVar);
            e.t.j.g.e0.F(this.f13042f, gVar);
        }
    }

    @Override // e.l.k.k3
    public void h(@Nullable BackGoodReasonDialog backGoodReasonDialog) {
        this.a = backGoodReasonDialog;
        synchronized (this) {
            this.f13043g |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13043g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13043g = 2L;
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
            h((BackGoodReasonDialog) obj);
            return true;
        }
        return false;
    }

    private l3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13043g = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.b = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13039c = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f13040d = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[3];
        this.f13041e = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[4];
        this.f13042f = textView4;
        textView4.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
