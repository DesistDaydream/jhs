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
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.CommonReportDialog;
import java.util.List;

/* loaded from: classes2.dex */
public class f4 extends e4 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12622i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f12623j;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ConstraintLayout f12624e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f12625f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f12626g;

    /* renamed from: h  reason: collision with root package name */
    private long f12627h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f12623j = sparseIntArray;
        sparseIntArray.put(R.id.titleTv, 4);
        sparseIntArray.put(R.id.descEt, 5);
    }

    public f4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f12622i, f12623j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        List<String> list;
        LabelsView.c cVar;
        synchronized (this) {
            j2 = this.f12627h;
            this.f12627h = 0L;
        }
        CommonReportDialog commonReportDialog = this.f12554d;
        e.t.j.h.g gVar2 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || commonReportDialog == null) {
            gVar = null;
            list = null;
            cVar = null;
        } else {
            gVar2 = commonReportDialog.getOnClose();
            List<String> reasons = commonReportDialog.getReasons();
            LabelsView.c onClick = commonReportDialog.getOnClick();
            gVar = commonReportDialog.getOnCommit();
            list = reasons;
            cVar = onClick;
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f12625f, gVar2);
            e.t.j.g.e0.F(this.f12626g, gVar);
            e.l.i.o.a(this.b, list, null, cVar, null, null, null, null);
        }
    }

    @Override // e.l.k.e4
    public void h(@Nullable CommonReportDialog commonReportDialog) {
        this.f12554d = commonReportDialog;
        synchronized (this) {
            this.f12627h |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12627h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12627h = 2L;
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
            h((CommonReportDialog) obj);
            return true;
        }
        return false;
    }

    private f4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (EditText) objArr[5], (LabelsView) objArr[2], (TextView) objArr[4]);
        this.f12627h = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12624e = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f12625f = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f12626g = textView;
        textView.setTag(null);
        this.b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
