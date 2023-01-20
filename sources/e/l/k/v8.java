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
import com.jihuanshe.model.ApplyForItem;
import com.jihuanshe.ui.page.entrepot.ApplyForActivity;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class v8 extends u8 {
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13756l = null;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final SparseIntArray f13757m;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final ConstraintLayout f13758j;

    /* renamed from: k  reason: collision with root package name */
    private long f13759k;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13757m = sparseIntArray;
        sparseIntArray.put(R.id.tv_desc, 7);
    }

    public v8(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13756l, f13757m));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        synchronized (this) {
            j2 = this.f13759k;
            this.f13759k = 0L;
        }
        ApplyForItem applyForItem = this.f13711i;
        CharSequence charSequence = null;
        int i2 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
        if (i2 == 0 || applyForItem == null) {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
        } else {
            String cardVersionNumber = applyForItem.getCardVersionNumber();
            String cardVersionImageUrl = applyForItem.getCardVersionImageUrl();
            str3 = applyForItem.getQuantityContent();
            CharSequence cardPrice = applyForItem.getCardPrice();
            str4 = applyForItem.getCardName();
            str5 = cardVersionImageUrl;
            str2 = applyForItem.getCardVersionRarity();
            str = cardVersionNumber;
            charSequence = cardPrice;
        }
        if (i2 != 0) {
            NImageView nImageView = this.a;
            e.t.j.g.y.a(nImageView, str5, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setText(this.f13705c, charSequence);
            TextViewBindingAdapter.setText(this.f13706d, str3);
            TextViewBindingAdapter.setText(this.f13707e, str);
            TextViewBindingAdapter.setText(this.f13708f, str2);
            TextViewBindingAdapter.setText(this.f13709g, str4);
        }
    }

    @Override // e.l.k.u8
    public void h(@Nullable ApplyForActivity applyForActivity) {
        this.f13710h = applyForActivity;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13759k != 0;
        }
    }

    @Override // e.l.k.u8
    public void i(@Nullable ApplyForItem applyForItem) {
        this.f13711i = applyForItem;
        synchronized (this) {
            this.f13759k |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13759k = 4L;
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
            i((ApplyForItem) obj);
            return true;
        } else if (1 == i2) {
            h((ApplyForActivity) obj);
            return true;
        } else {
            return false;
        }
    }

    private v8(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[7], (TextView) objArr[3], (TextView) objArr[6], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[2]);
        this.f13759k = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13758j = constraintLayout;
        constraintLayout.setTag(null);
        this.a.setTag(null);
        this.f13705c.setTag(null);
        this.f13706d.setTag(null);
        this.f13707e.setTag(null);
        this.f13708f.setTag(null);
        this.f13709g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
