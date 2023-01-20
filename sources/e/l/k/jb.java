package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.OrderInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class jb extends ib {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p = null;
    @Nullable
    private static final SparseIntArray q;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ConstraintLayout f12952m;
    @NonNull
    private final TextView n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.rightIv, 9);
        sparseIntArray.put(R.id.divider, 10);
        sparseIntArray.put(R.id.shippingTv, 11);
    }

    public jb(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 12, p, q));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        CharSequence charSequence;
        String str5;
        String str6;
        e.t.r.a.a aVar;
        String str7;
        String str8;
        synchronized (this) {
            j2 = this.o;
            this.o = 0L;
        }
        OrderInfo orderInfo = this.f12890l;
        e.l.g.k0 k0Var = this.f12889k;
        String str9 = null;
        int i2 = ((7 & j2) > 0L ? 1 : ((7 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 5) == 0 || orderInfo == null) {
                str2 = null;
                str3 = null;
                str7 = null;
                str4 = null;
                charSequence = null;
                str5 = null;
                str8 = null;
            } else {
                str2 = orderInfo.getStatusStr();
                str3 = orderInfo.getOrderTime();
                str7 = orderInfo.getSellerName();
                str4 = orderInfo.getOrderNo();
                charSequence = orderInfo.getOrderPrice();
                str5 = orderInfo.getImage();
                str8 = orderInfo.getName();
            }
            str6 = orderInfo != null ? orderInfo.getSellerAvatar() : null;
            aVar = k0Var != null ? k0Var.v() : null;
            str9 = str7;
            str = str8;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            charSequence = null;
            str5 = null;
            str6 = null;
            aVar = null;
        }
        if (i2 != 0) {
            e.t.j.g.y.a(this.a, str6, null, null, null, null, null, null, null, null, null, aVar, null, null, null, null, null);
        }
        if ((j2 & 5) != 0) {
            NImageView nImageView = this.b;
            e.t.j.g.y.a(nImageView, str5, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setText(this.n, str9);
            TextViewBindingAdapter.setText(this.f12882d, str);
            TextViewBindingAdapter.setText(this.f12883e, str4);
            TextViewBindingAdapter.setText(this.f12884f, charSequence);
            TextViewBindingAdapter.setText(this.f12887i, str2);
            TextViewBindingAdapter.setText(this.f12888j, str3);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // e.l.k.ib
    public void i(@Nullable e.l.g.k0 k0Var) {
        this.f12889k = k0Var;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.ib
    public void j(@Nullable OrderInfo orderInfo) {
        this.f12890l = orderInfo;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            j((OrderInfo) obj);
        } else if (2 != i2) {
            return false;
        } else {
            i((e.l.g.k0) obj);
        }
        return true;
    }

    private jb(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (NImageView) objArr[4], (View) objArr[10], (TextView) objArr[5], (TextView) objArr[6], (TextView) objArr[8], (ImageView) objArr[9], (TextView) objArr[11], (TextView) objArr[3], (TextView) objArr[7]);
        this.o = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12952m = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.n = textView;
        textView.setTag(null);
        this.f12882d.setTag(null);
        this.f12883e.setTag(null);
        this.f12884f.setTag(null);
        this.f12887i.setTag(null);
        this.f12888j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
