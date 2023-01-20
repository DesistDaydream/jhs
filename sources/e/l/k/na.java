package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.widget.RankImageView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class na extends ma {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13203k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f13204l = null;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f13205h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f13206i;

    /* renamed from: j  reason: collision with root package name */
    private long f13207j;

    public na(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13203k, f13204l));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        Integer num;
        String str4;
        e.t.r.a.a aVar;
        synchronized (this) {
            j2 = this.f13207j;
            this.f13207j = 0L;
        }
        User user = this.f13130g;
        e.l.g.w wVar = this.f13129f;
        String str5 = null;
        int i2 = ((7 & j2) > 0L ? 1 : ((7 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            String avatar = user != null ? user.getAvatar() : null;
            e.t.r.a.a v = wVar != null ? wVar.v() : null;
            if ((j2 & 5) == 0 || user == null) {
                aVar = v;
                str4 = avatar;
                str = null;
                str2 = null;
                str3 = null;
                num = null;
            } else {
                str5 = user.getIntro();
                str2 = user.getName();
                str3 = user.getFansNumStr2();
                num = user.getCreditRankDrawable();
                str = user.getUid();
                aVar = v;
                str4 = avatar;
            }
        } else {
            str = null;
            str2 = null;
            str3 = null;
            num = null;
            str4 = null;
            aVar = null;
        }
        if (i2 != 0) {
            NImageView nImageView = this.a;
            e.t.j.g.y.a(nImageView, str4, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.svg_default_avatar), null, null, null, null, aVar, null, null, null, null, null);
        }
        if ((j2 & 5) != 0) {
            TextViewBindingAdapter.setText(this.b, str5);
            e.t.j.g.x.e(this.f13126c, num);
            TextViewBindingAdapter.setText(this.f13206i, str3);
            TextViewBindingAdapter.setText(this.f13127d, str2);
            TextViewBindingAdapter.setText(this.f13128e, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13207j != 0;
        }
    }

    @Override // e.l.k.ma
    public void i(@Nullable User user) {
        this.f13130g = user;
        synchronized (this) {
            this.f13207j |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13207j = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.ma
    public void j(@Nullable e.l.g.w wVar) {
        this.f13129f = wVar;
        synchronized (this) {
            this.f13207j |= 2;
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
            j((e.l.g.w) obj);
        }
        return true;
    }

    private na(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[5], (RankImageView) objArr[3], (TextView) objArr[2], (TextView) objArr[4]);
        this.f13207j = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f13126c.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13205h = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[6];
        this.f13206i = textView;
        textView.setTag(null);
        this.f13127d.setTag(null);
        this.f13128e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
