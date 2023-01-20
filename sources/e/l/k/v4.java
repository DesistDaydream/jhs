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
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderReturnDetail;
import com.jihuanshe.ui.dialog.ExpressDialog;
import com.jihuanshe.ui.widget.NoScrollListView;
import java.util.List;

/* loaded from: classes2.dex */
public class v4 extends u4 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13738i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13739j;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f13740f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f13741g;

    /* renamed from: h  reason: collision with root package name */
    private long f13742h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13739j = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 5);
    }

    public v4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13738i, f13739j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        CardConsignmentInfo cardConsignmentInfo;
        e.t.j.h.g gVar;
        e.l.g.t tVar;
        List<ExpressData> list;
        String str;
        String str2;
        String str3;
        e.l.g.t tVar2;
        List<ExpressData> list2;
        synchronized (this) {
            j2 = this.f13742h;
            this.f13742h = 0L;
        }
        ExpressDialog expressDialog = this.f13693e;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (expressDialog != null) {
                cardConsignmentInfo = expressDialog.getDataInfo();
                gVar = expressDialog.getOnClickClose();
                tVar2 = expressDialog.getAdapterExpress();
                list2 = expressDialog.getExpressList();
            } else {
                cardConsignmentInfo = null;
                gVar = null;
                tVar2 = null;
                list2 = null;
            }
            r18 = cardConsignmentInfo != null;
            if (i2 != 0) {
                j2 = r18 ? j2 | 8 | 32 : j2 | 4 | 16;
            }
            tVar = tVar2;
            list = list2;
        } else {
            cardConsignmentInfo = null;
            gVar = null;
            tVar = null;
            list = null;
        }
        String orderExpressName = ((j2 & 8) == 0 || cardConsignmentInfo == null) ? null : cardConsignmentInfo.getOrderExpressName();
        String expressNumber = ((32 & j2) == 0 || cardConsignmentInfo == null) ? null : cardConsignmentInfo.getExpressNumber();
        if ((20 & j2) != 0) {
            OrderReturnDetail dataReturnInfo = expressDialog != null ? expressDialog.getDataReturnInfo() : null;
            str2 = ((16 & j2) == 0 || dataReturnInfo == null) ? null : dataReturnInfo.getExpressNumber();
            str = ((4 & j2) == 0 || dataReturnInfo == null) ? null : dataReturnInfo.getOrderExpressName();
        } else {
            str = null;
            str2 = null;
        }
        int i3 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i3 != 0) {
            String str4 = r18 ? orderExpressName : str;
            if (!r18) {
                expressNumber = str2;
            }
            str3 = str4;
        } else {
            str3 = null;
            expressNumber = null;
        }
        if (i3 != 0) {
            e.t.j.g.e0.F(this.f13741g, gVar);
            e.l.i.q.a(this.a, tVar, list);
            TextViewBindingAdapter.setText(this.b, str3);
            TextViewBindingAdapter.setText(this.f13692d, expressNumber);
        }
    }

    @Override // e.l.k.u4
    public void h(@Nullable ExpressDialog expressDialog) {
        this.f13693e = expressDialog;
        synchronized (this) {
            this.f13742h |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13742h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13742h = 2L;
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
            h((ExpressDialog) obj);
            return true;
        }
        return false;
    }

    private v4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NoScrollListView) objArr[4], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[3]);
        this.f13742h = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13740f = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f13741g = imageView;
        imageView.setTag(null);
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13692d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
