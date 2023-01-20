package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.adapter.RarityAdapter;
import com.jihuanshe.model.Rarity;

/* loaded from: classes2.dex */
public class lg extends kg {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13090i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13091j = null;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final LinearLayout f13092e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    private final TextView f13093f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final TextView f13094g;

    /* renamed from: h  reason: collision with root package name */
    private long f13095h;

    public lg(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 3, f13090i, f13091j));
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.lg.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13095h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13095h = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.kg
    public void k(@Nullable Rarity rarity) {
        this.a = rarity;
        synchronized (this) {
            this.f13095h |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.kg
    public void l(@Nullable RarityAdapter rarityAdapter) {
        this.b = rarityAdapter;
        synchronized (this) {
            this.f13095h |= 2;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // e.l.k.kg
    public void m(@Nullable Integer num) {
        this.f13029c = num;
        synchronized (this) {
            this.f13095h |= 4;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    @Override // e.l.k.kg
    public void n(@Nullable Boolean bool) {
        this.f13030d = bool;
        synchronized (this) {
            this.f13095h |= 8;
        }
        notifyPropertyChanged(16);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            k((Rarity) obj);
        } else if (10 == i2) {
            l((RarityAdapter) obj);
        } else if (11 == i2) {
            m((Integer) obj);
        } else if (16 != i2) {
            return false;
        } else {
            n((Boolean) obj);
        }
        return true;
    }

    private lg(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0);
        this.f13095h = -1L;
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13092e = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[1];
        this.f13093f = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[2];
        this.f13094g = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
