package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.widget.FlexLayout;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes2.dex */
public class ff extends ef {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts r = null;
    @Nullable
    private static final SparseIntArray s = null;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final LinearLayout f12662h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final FrameLayout f12663i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final FlexLayout f12664j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final FrameLayout f12665k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final LinearLayout f12666l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final ImageView f12667m;
    @NonNull
    private final LinearLayout n;
    @NonNull
    private final ImageView o;
    @NonNull
    private final LinearLayout p;
    private long q;

    public ff(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 15, r, s));
    }

    private boolean i(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.f<Pair<String, String>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 16;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<List<Rarity>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.f<List<Pair<String, String>>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.f<String> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 256;
            }
            return true;
        }
        return false;
    }

    private boolean q(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 128;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x026f  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x014c  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 964
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.ff.executeBindings():void");
    }

    @Override // e.l.k.ef
    public void h(@Nullable e.l.s.c cVar) {
        this.f12600g = cVar;
        synchronized (this) {
            this.q |= 512;
        }
        notifyPropertyChanged(6);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.q != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.q = 1024L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return m((e.n.i) obj, i3);
            case 1:
                return l((e.n.f) obj, i3);
            case 2:
                return i((e.n.l) obj, i3);
            case 3:
                return k((e.n.i) obj, i3);
            case 4:
                return j((e.n.f) obj, i3);
            case 5:
                return o((e.n.f) obj, i3);
            case 6:
                return n((e.n.f) obj, i3);
            case 7:
                return q((e.n.i) obj, i3);
            case 8:
                return p((e.n.i) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (6 == i2) {
            h((e.l.s.c) obj);
            return true;
        }
        return false;
    }

    private ff(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 9, (EditText) objArr[10], (TextView) objArr[6], (RecyclerView) objArr[14], (ImageView) objArr[8], (ImageView) objArr[1], (TextView) objArr[3]);
        this.q = -1L;
        this.a.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12662h = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[11];
        this.f12663i = frameLayout;
        frameLayout.setTag(null);
        FlexLayout flexLayout = (FlexLayout) objArr[12];
        this.f12664j = flexLayout;
        flexLayout.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) objArr[13];
        this.f12665k = frameLayout2;
        frameLayout2.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[2];
        this.f12666l = linearLayout2;
        linearLayout2.setTag(null);
        ImageView imageView = (ImageView) objArr[4];
        this.f12667m = imageView;
        imageView.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) objArr[5];
        this.n = linearLayout3;
        linearLayout3.setTag(null);
        ImageView imageView2 = (ImageView) objArr[7];
        this.o = imageView2;
        imageView2.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) objArr[9];
        this.p = linearLayout4;
        linearLayout4.setTag(null);
        this.b.setTag(null);
        this.f12596c.setTag(null);
        this.f12597d.setTag(null);
        this.f12598e.setTag(null);
        this.f12599f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
