package e.l.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProduct;

/* loaded from: classes2.dex */
public class r9 extends q9 {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13480i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13481j = null;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    private final LinearLayout f13482c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f13483d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final TextView f13484e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f13485f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13486g;

    /* renamed from: h  reason: collision with root package name */
    private long f13487h;

    public r9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13480i, f13481j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        CharSequence charSequence;
        String str;
        String str2;
        Context context;
        int i2;
        synchronized (this) {
            j2 = this.f13487h;
            this.f13487h = 0L;
        }
        CardProduct cardProduct = this.a;
        e.l.g.m mVar = this.b;
        Drawable drawable = null;
        int i3 = ((j2 & 7) > 0L ? 1 : ((j2 & 7) == 0L ? 0 : -1));
        if (i3 != 0) {
            if ((j2 & 5) == 0 || cardProduct == null) {
                charSequence = null;
                str = null;
                str2 = null;
            } else {
                charSequence = cardProduct.getPrice2();
                str = cardProduct.getConditionStr();
                str2 = cardProduct.getRemarkStr();
            }
            boolean z = (mVar != null ? mVar.v() : null) == cardProduct;
            if (i3 != 0) {
                j2 |= z ? 16L : 8L;
            }
            if (z) {
                context = this.f13483d.getContext();
                i2 = R.drawable.svg_radio_button_;
            } else {
                context = this.f13483d.getContext();
                i2 = R.drawable.svg_radio_button;
            }
            drawable = AppCompatResources.getDrawable(context, i2);
        } else {
            charSequence = null;
            str = null;
            str2 = null;
        }
        if ((j2 & 7) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.f13483d, drawable);
        }
        if ((j2 & 5) != 0) {
            TextViewBindingAdapter.setText(this.f13484e, str);
            TextViewBindingAdapter.setText(this.f13485f, str2);
            TextViewBindingAdapter.setText(this.f13486g, charSequence);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13487h != 0;
        }
    }

    @Override // e.l.k.q9
    public void i(@Nullable CardProduct cardProduct) {
        this.a = cardProduct;
        synchronized (this) {
            this.f13487h |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13487h = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.q9
    public void j(@Nullable e.l.g.m mVar) {
        this.b = mVar;
        synchronized (this) {
            this.f13487h |= 2;
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
            i((CardProduct) obj);
        } else if (10 != i2) {
            return false;
        } else {
            j((e.l.g.m) obj);
        }
        return true;
    }

    private r9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13487h = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13482c = linearLayout;
        linearLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f13483d = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13484e = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.f13485f = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[4];
        this.f13486g = textView3;
        textView3.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
