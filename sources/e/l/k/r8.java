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
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.adapter.AddressAdapter;
import com.jihuanshe.model.UserAddress;

/* loaded from: classes2.dex */
public class r8 extends q8 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13472i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13473j = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f13474c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final TextView f13475d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13476e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final ImageView f13477f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13478g;

    /* renamed from: h  reason: collision with root package name */
    private long f13479h;

    public r8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13472i, f13473j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        String str;
        String str2;
        String str3;
        synchronized (this) {
            j2 = this.f13479h;
            this.f13479h = 0L;
        }
        UserAddress userAddress = this.b;
        AddressAdapter addressAdapter = this.a;
        String str4 = null;
        int i2 = ((7 & j2) > 0L ? 1 : ((7 & j2) == 0L ? 0 : -1));
        if (i2 != 0) {
            if ((j2 & 5) == 0 || userAddress == null) {
                str = null;
                str2 = null;
                str3 = null;
            } else {
                str = userAddress.getAddress();
                str2 = userAddress.getInfo();
                str3 = userAddress.getAddressDetail();
            }
            gVar = addressAdapter != null ? addressAdapter.w(userAddress) : null;
            str4 = str3;
        } else {
            gVar = null;
            str = null;
            str2 = null;
        }
        if ((j2 & 5) != 0) {
            TextViewBindingAdapter.setText(this.f13475d, str4);
            TextViewBindingAdapter.setText(this.f13476e, str);
            TextViewBindingAdapter.setText(this.f13478g, str2);
        }
        if (i2 != 0) {
            e.t.j.g.e0.F(this.f13477f, gVar);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13479h != 0;
        }
    }

    @Override // e.l.k.q8
    public void i(@Nullable UserAddress userAddress) {
        this.b = userAddress;
        synchronized (this) {
            this.f13479h |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13479h = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.q8
    public void j(@Nullable AddressAdapter addressAdapter) {
        this.a = addressAdapter;
        synchronized (this) {
            this.f13479h |= 2;
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
            i((UserAddress) obj);
        } else if (10 != i2) {
            return false;
        } else {
            j((AddressAdapter) obj);
        }
        return true;
    }

    private r8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13479h = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13474c = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13475d = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f13476e = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f13477f = imageView;
        imageView.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.f13478g = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
