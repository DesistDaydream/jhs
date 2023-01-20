package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.adapter.BlackListAdapter;
import com.jihuanshe.model.BanUser;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class f9 extends e9 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12642i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f12643j = null;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f12644g;

    /* renamed from: h  reason: collision with root package name */
    private long f12645h;

    public f9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f12642i, f12643j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        e.t.r.a.b bVar;
        e.t.r.a.b bVar2;
        e.t.j.h.g gVar;
        synchronized (this) {
            j2 = this.f12645h;
            this.f12645h = 0L;
        }
        BanUser banUser = this.f12571f;
        BlackListAdapter blackListAdapter = this.f12570e;
        e.t.j.h.g gVar2 = null;
        int i2 = ((7 & j2) > 0L ? 1 : ((7 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            String avatar = banUser != null ? banUser.getAvatar() : null;
            if (blackListAdapter != null) {
                gVar = blackListAdapter.x(banUser);
                bVar2 = blackListAdapter.v();
            } else {
                bVar2 = null;
                gVar = null;
            }
            if ((j2 & 5) == 0 || banUser == null) {
                bVar = bVar2;
                str3 = avatar;
                str = null;
                str2 = null;
            } else {
                String name = banUser.getName();
                str = banUser.getBio();
                bVar = bVar2;
                str3 = avatar;
                str2 = name;
            }
            gVar2 = gVar;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            bVar = null;
        }
        if (i2 != 0) {
            e.t.j.g.y.a(this.a, str3, null, null, null, null, null, null, null, null, null, bVar, null, null, null, null, null);
            e.t.j.g.e0.F(this.f12568c, gVar2);
        }
        if ((j2 & 5) != 0) {
            TextViewBindingAdapter.setText(this.b, str);
            TextViewBindingAdapter.setText(this.f12569d, str2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12645h != 0;
        }
    }

    @Override // e.l.k.e9
    public void i(@Nullable BanUser banUser) {
        this.f12571f = banUser;
        synchronized (this) {
            this.f12645h |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12645h = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.e9
    public void j(@Nullable BlackListAdapter blackListAdapter) {
        this.f12570e = blackListAdapter;
        synchronized (this) {
            this.f12645h |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((BanUser) obj);
        } else if (10 != i2) {
            return false;
        } else {
            j((BlackListAdapter) obj);
        }
        return true;
    }

    private f9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[2]);
        this.f12645h = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12568c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12644g = constraintLayout;
        constraintLayout.setTag(null);
        this.f12569d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
