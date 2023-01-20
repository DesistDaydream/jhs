package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardVersionInfo;
import com.jihuanshe.ui.dialog.CardPackListDialog;
import com.vector.databinding.adapter.ListViewBinding;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import java.util.List;

/* loaded from: classes2.dex */
public class z3 extends y3 {
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f14038g = null;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static final SparseIntArray f14039h;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final LinearLayout f14040d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final ImageView f14041e;

    /* renamed from: f  reason: collision with root package name */
    private long f14042f;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f14039h = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 3);
    }

    public z3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 4, f14038g, f14039h));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.l lVar;
        e.t.j.h.g gVar;
        LayoutManagers.a aVar;
        e.l.g.k kVar;
        List<CardVersionInfo> list;
        synchronized (this) {
            j2 = this.f14042f;
            this.f14042f = 0L;
        }
        CardPackListDialog cardPackListDialog = this.f13949c;
        int i2 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i2 == 0 || cardPackListDialog == null) {
            lVar = null;
            gVar = null;
            aVar = null;
            kVar = null;
            list = null;
        } else {
            lVar = cardPackListDialog.getOnItemClick();
            e.l.g.k adapter = cardPackListDialog.getAdapter();
            gVar = cardPackListDialog.getOnClickClose();
            List<CardVersionInfo> data = cardPackListDialog.getData();
            aVar = cardPackListDialog.getLayoutManager();
            kVar = adapter;
            list = data;
        }
        if (i2 != 0) {
            ListViewBinding.a(this.a, kVar, null, list, null, null, null, null);
            ListViewBinding.l(this.a, lVar, null, null);
            ListViewBinding.g(this.a, aVar, false);
            e.t.j.g.e0.F(this.f14041e, gVar);
        }
    }

    @Override // e.l.k.y3
    public void h(@Nullable CardPackListDialog cardPackListDialog) {
        this.f13949c = cardPackListDialog;
        synchronized (this) {
            this.f14042f |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f14042f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f14042f = 2L;
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
            h((CardPackListDialog) obj);
            return true;
        }
        return false;
    }

    private z3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ListView) objArr[2], (TextView) objArr[3]);
        this.f14042f = -1L;
        this.a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f14040d = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f14041e = imageView;
        imageView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
