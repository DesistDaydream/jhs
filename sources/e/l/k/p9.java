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
import com.jihuanshe.ui.widget.ScoreView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class p9 extends o9 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p = null;
    @Nullable
    private static final SparseIntArray q;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final LinearLayout f13332k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f13333l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f13334m;
    @NonNull
    private final ImageView n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.llName, 9);
    }

    public p9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 10, p, q));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.p9.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 16L;
        }
        requestRebind();
    }

    @Override // e.l.k.o9
    public void k(@Nullable e.l.g.k kVar) {
        this.f13258h = kVar;
        synchronized (this) {
            this.o |= 8;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // e.l.k.o9
    public void l(@Nullable CardPackListDialog cardPackListDialog) {
        this.f13257g = cardPackListDialog;
        synchronized (this) {
            this.o |= 4;
        }
        notifyPropertyChanged(4);
        super.requestRebind();
    }

    @Override // e.l.k.o9
    public void m(@Nullable CardVersionInfo cardVersionInfo) {
        this.f13259i = cardVersionInfo;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.o9
    public void n(@Nullable e.t.r.a.h hVar) {
        this.f13260j = hVar;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            m((CardVersionInfo) obj);
        } else if (17 == i2) {
            n((e.t.r.a.h) obj);
        } else if (4 == i2) {
            l((CardPackListDialog) obj);
        } else if (2 != i2) {
            return false;
        } else {
            k((e.l.g.k) obj);
        }
        return true;
    }

    private p9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (LinearLayout) objArr[9], (ScoreView) objArr[8], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[5]);
        this.o = -1L;
        this.a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f13332k = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f13333l = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[3];
        this.f13334m = textView2;
        textView2.setTag(null);
        ImageView imageView = (ImageView) objArr[4];
        this.n = imageView;
        imageView.setTag(null);
        this.f13253c.setTag(null);
        this.f13254d.setTag(null);
        this.f13255e.setTag(null);
        this.f13256f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
