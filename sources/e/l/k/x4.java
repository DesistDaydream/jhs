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
import com.jihuanshe.model.ExpressData;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.ui.dialog.ExpressDetailsDialog;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class x4 extends w4 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13895i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13896j;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ConstraintLayout f13897f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ImageView f13898g;

    /* renamed from: h  reason: collision with root package name */
    private long f13899h;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13896j = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 5);
    }

    public x4(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 6, f13895i, f13896j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        LayoutManagers.a aVar;
        e.t.j.h.g gVar;
        String str;
        String str2;
        e.t.j.h.g gVar2;
        e.l.g.s sVar;
        List<ExpressData> list;
        TextView textView;
        e.l.h.j.b.f.b bVar;
        e.t.j.h.g gVar3;
        OrderDetailInfo orderDetailInfo;
        List<ExpressData> list2;
        e.l.g.s sVar2;
        LayoutManagers.a aVar2;
        TextView textView2;
        synchronized (this) {
            j2 = this.f13899h;
            this.f13899h = 0L;
        }
        ExpressDetailsDialog expressDetailsDialog = this.f13828e;
        e.l.h.j.b.f.b bVar2 = null;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 != 0) {
            if (expressDetailsDialog != null) {
                bVar = expressDetailsDialog.getDecoration();
                gVar = expressDetailsDialog.getOnClickClose();
                gVar3 = expressDetailsDialog.getOnClickCopy();
                orderDetailInfo = expressDetailsDialog.getInfo();
                sVar2 = expressDetailsDialog.getAdapterExpress();
                aVar2 = expressDetailsDialog.getLayoutManager();
                textView2 = expressDetailsDialog.getFootEmpty();
                list2 = expressDetailsDialog.getExpressList();
            } else {
                bVar = null;
                gVar = null;
                gVar3 = null;
                orderDetailInfo = null;
                list2 = null;
                sVar2 = null;
                aVar2 = null;
                textView2 = null;
            }
            if (orderDetailInfo != null) {
                String expressNameStr = orderDetailInfo.getExpressNameStr();
                str2 = orderDetailInfo.getExpressNumber();
                list = list2;
                textView = textView2;
                gVar2 = gVar3;
                str = expressNameStr;
            } else {
                list = list2;
                str2 = null;
                textView = textView2;
                gVar2 = gVar3;
                str = null;
            }
            bVar2 = bVar;
            aVar = aVar2;
            sVar = sVar2;
        } else {
            aVar = null;
            gVar = null;
            str = null;
            str2 = null;
            gVar2 = null;
            sVar = null;
            list = null;
            textView = null;
        }
        if (i2 != 0) {
            ListViewBinding.c(this.a, bVar2);
            ListViewBinding.a(this.a, sVar, null, list, null, textView, null, null);
            ListViewBinding.g(this.a, aVar, false);
            e.t.j.g.e0.F(this.f13898g, gVar);
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(this.f13827d, str2);
            e.t.j.g.e0.F(this.f13827d, gVar2);
        }
    }

    @Override // e.l.k.w4
    public void h(@Nullable ExpressDetailsDialog expressDetailsDialog) {
        this.f13828e = expressDetailsDialog;
        synchronized (this) {
            this.f13899h |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13899h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13899h = 2L;
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
            h((ExpressDetailsDialog) obj);
            return true;
        }
        return false;
    }

    private x4(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ListView) objArr[4], (TextView) objArr[2], (TextView) objArr[5], (TextView) objArr[3]);
        this.f13899h = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13897f = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f13898g = imageView;
        imageView.setTag(null);
        this.b.setTag(null);
        this.f13827d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
