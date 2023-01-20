package e.l.k;

import android.content.Context;
import android.graphics.drawable.Drawable;
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
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.model.WantBuyList;
import com.jihuanshe.ui.page.user.WantBuyActivity;

/* loaded from: classes2.dex */
public class rd extends qd {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13502k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f13503l;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ConstraintLayout f13504h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f13505i;

    /* renamed from: j  reason: collision with root package name */
    private long f13506j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13503l = sparseIntArray;
        sparseIntArray.put(R.id.countTv, 6);
    }

    public rd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 7, f13502k, f13503l));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        e.t.j.h.g gVar;
        String str2;
        Drawable drawable;
        Drawable drawable2;
        String str3;
        String str4;
        String str5;
        Boolean bool;
        int i2;
        Context context;
        int i3;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.f13506j;
            this.f13506j = 0L;
        }
        WantBuyList wantBuyList = this.f13447f;
        WantBuyActivity wantBuyActivity = this.f13448g;
        int i4 = 0;
        if ((j2 & 7) != 0) {
            int i5 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
            if (i5 != 0) {
                if (wantBuyList != null) {
                    bool = wantBuyList.getDef();
                    i2 = wantBuyList.getQuantityNum();
                    str4 = wantBuyList.getName();
                    str5 = wantBuyList.getDesc();
                } else {
                    bool = null;
                    i2 = 0;
                    str4 = null;
                    str5 = null;
                }
                boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
                str2 = this.f13505i.getResources().getString(R.string.common_number, Integer.valueOf(i2));
                if (i5 != 0) {
                    if (safeUnbox) {
                        j3 = j2 | 16 | 64;
                        j4 = 256;
                    } else {
                        j3 = j2 | 8 | 32;
                        j4 = 128;
                    }
                    j2 = j3 | j4;
                }
                drawable = safeUnbox ? AppCompatResources.getDrawable(this.f13446e.getContext(), R.drawable.svg_icon_public) : null;
                int colorFromResource = ViewDataBinding.getColorFromResource(this.f13445d, safeUnbox ? R.color.common_color_1 : R.color.black_b5b5b7);
                if (safeUnbox) {
                    context = this.f13445d.getContext();
                    i3 = R.drawable.svg_card_list_default;
                } else {
                    context = this.f13445d.getContext();
                    i3 = R.drawable.svg_card_list;
                }
                drawable2 = AppCompatResources.getDrawable(context, i3);
                i4 = colorFromResource;
            } else {
                str2 = null;
                drawable = null;
                drawable2 = null;
                str4 = null;
                str5 = null;
            }
            if (wantBuyActivity != null) {
                gVar = wantBuyActivity.c0(wantBuyList, this.f13444c);
                str = str4;
                str3 = str5;
            } else {
                str = str4;
                str3 = str5;
                gVar = null;
            }
        } else {
            str = null;
            gVar = null;
            str2 = null;
            drawable = null;
            drawable2 = null;
            str3 = null;
        }
        if ((j2 & 5) != 0) {
            TextViewBindingAdapter.setText(this.b, str3);
            e.t.j.g.x.f(this.f13445d, Integer.valueOf(i4));
            ImageViewBindingAdapter.setImageDrawable(this.f13445d, drawable2);
            TextViewBindingAdapter.setText(this.f13505i, str2);
            TextViewBindingAdapter.setDrawableEnd(this.f13446e, drawable);
            TextViewBindingAdapter.setText(this.f13446e, str);
        }
        if ((j2 & 7) != 0) {
            e.t.j.g.e0.F(this.f13444c, gVar);
        }
    }

    @Override // e.l.k.qd
    public void h(@Nullable WantBuyActivity wantBuyActivity) {
        this.f13448g = wantBuyActivity;
        synchronized (this) {
            this.f13506j |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13506j != 0;
        }
    }

    @Override // e.l.k.qd
    public void i(@Nullable WantBuyList wantBuyList) {
        this.f13447f = wantBuyList;
        synchronized (this) {
            this.f13506j |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13506j = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            i((WantBuyList) obj);
            return true;
        } else if (1 == i2) {
            h((WantBuyActivity) obj);
            return true;
        } else {
            return false;
        }
    }

    private rd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (TextView) objArr[6], (TextView) objArr[3], (ImageView) objArr[5], (ImageView) objArr[1], (TextView) objArr[2]);
        this.f13506j = -1L;
        this.b.setTag(null);
        this.f13444c.setTag(null);
        this.f13445d.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13504h = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[4];
        this.f13505i = textView;
        textView.setTag(null);
        this.f13446e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
