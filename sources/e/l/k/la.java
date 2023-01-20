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
import com.jihuanshe.R;
import com.jihuanshe.adapter.FansAdapter;
import com.jihuanshe.model.User;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class la extends ka {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13069i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13070j = null;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f13071g;

    /* renamed from: h  reason: collision with root package name */
    private long f13072h;

    public la(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13069i, f13070j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        e.t.r.a.a aVar;
        e.t.j.h.g gVar;
        e.t.r.a.a aVar2;
        String str5;
        String str6;
        synchronized (this) {
            j2 = this.f13072h;
            this.f13072h = 0L;
        }
        boolean z = false;
        User user = this.f13017f;
        FansAdapter fansAdapter = this.f13016e;
        e.t.j.h.g gVar2 = null;
        Boolean bool = null;
        if ((j2 & 7) != 0) {
            String avatar = user != null ? user.getAvatar() : null;
            if (fansAdapter != null) {
                aVar2 = fansAdapter.w();
                gVar = fansAdapter.v(user);
            } else {
                gVar = null;
                aVar2 = null;
            }
            int i2 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
            if (i2 != 0) {
                if (user != null) {
                    String intro = user.getIntro();
                    Boolean followed = user.getFollowed();
                    str6 = user.getName();
                    bool = followed;
                    str5 = intro;
                } else {
                    str5 = null;
                    str6 = null;
                }
                boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
                if (i2 != 0) {
                    j2 |= safeUnbox ? 16L : 8L;
                }
                str3 = safeUnbox ? this.f13014c.getResources().getString(R.string.common_follow_each_other) : this.f13014c.getResources().getString(R.string.common_follow);
                gVar2 = gVar;
                str4 = avatar;
                aVar = aVar2;
                str2 = str6;
                str = str5;
                z = ViewDataBinding.safeUnbox(Boolean.valueOf(!safeUnbox));
            } else {
                str4 = avatar;
                aVar = aVar2;
                str = null;
                str3 = null;
                gVar2 = gVar;
                str2 = null;
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            aVar = null;
        }
        if ((7 & j2) != 0) {
            e.t.j.g.y.a(this.a, str4, null, null, null, null, null, null, null, null, null, aVar, null, null, null, null, null);
            e.t.j.g.e0.F(this.f13014c, gVar2);
        }
        if ((j2 & 5) != 0) {
            TextViewBindingAdapter.setText(this.b, str);
            e.t.j.g.e0.p(this.f13014c, z);
            TextViewBindingAdapter.setText(this.f13014c, str3);
            TextViewBindingAdapter.setText(this.f13015d, str2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13072h != 0;
        }
    }

    @Override // e.l.k.ka
    public void i(@Nullable User user) {
        this.f13017f = user;
        synchronized (this) {
            this.f13072h |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13072h = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.ka
    public void j(@Nullable FansAdapter fansAdapter) {
        this.f13016e = fansAdapter;
        synchronized (this) {
            this.f13072h |= 2;
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
            i((User) obj);
        } else if (10 != i2) {
            return false;
        } else {
            j((FansAdapter) obj);
        }
        return true;
    }

    private la(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[4], (TextView) objArr[2]);
        this.f13072h = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13014c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13071g = constraintLayout;
        constraintLayout.setTag(null);
        this.f13015d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
