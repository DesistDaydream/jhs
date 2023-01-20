package e.l.k;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.page.web.CommonWebViewActivity;
import com.vector.network.image.NImageView;
import com.vector.view.WebViewEx;

/* loaded from: classes2.dex */
public class f0 extends e0 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts r = null;
    @Nullable
    private static final SparseIntArray s = null;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f12601g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final FrameLayout f12602h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ImageView f12603i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TextView f12604j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final NImageView f12605k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final LinearLayout f12606l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f12607m;
    @NonNull
    private final TextView n;
    @NonNull
    private final TextView o;
    @NonNull
    private final FrameLayout p;
    private long q;

    public f0(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 14, r, s));
    }

    private boolean k(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 128;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 32;
            }
            return true;
        }
        return false;
    }

    private boolean m(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean n(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 64;
            }
            return true;
        }
        return false;
    }

    private boolean o(e.n.i iVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean p(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean q(e.n.p pVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean r(e.n.l lVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.q |= 16;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x0425  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:223:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x019d  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 1085
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.f0.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.q != 0;
        }
    }

    @Override // e.l.k.e0
    public void i(@Nullable CommonWebViewActivity commonWebViewActivity) {
        this.f12541e = commonWebViewActivity;
        synchronized (this) {
            this.q |= 256;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.q = 1024L;
        }
        requestRebind();
    }

    @Override // e.l.k.e0
    public void j(@Nullable e.l.s.p.a aVar) {
        this.f12542f = aVar;
        synchronized (this) {
            this.q |= 512;
        }
        notifyPropertyChanged(20);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        switch (i2) {
            case 0:
                return o((e.n.i) obj, i3);
            case 1:
                return p((e.n.p) obj, i3);
            case 2:
                return q((e.n.p) obj, i3);
            case 3:
                return m((e.n.l) obj, i3);
            case 4:
                return r((e.n.l) obj, i3);
            case 5:
                return l((e.n.i) obj, i3);
            case 6:
                return n((e.n.i) obj, i3);
            case 7:
                return k((e.n.l) obj, i3);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            i((CommonWebViewActivity) obj);
        } else if (20 != i2) {
            return false;
        } else {
            j((e.l.s.p.a) obj);
        }
        return true;
    }

    private f0(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 8, (LinearLayout) objArr[1], (ImageView) objArr[2], (ProgressBar) objArr[13], (WebViewEx) objArr[10]);
        this.q = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        this.f12539c.setTag(null);
        LinearLayout linearLayout = (LinearLayout) objArr[0];
        this.f12601g = linearLayout;
        linearLayout.setTag(null);
        FrameLayout frameLayout = (FrameLayout) objArr[11];
        this.f12602h = frameLayout;
        frameLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[12];
        this.f12603i = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f12604j = textView;
        textView.setTag(null);
        NImageView nImageView = (NImageView) objArr[4];
        this.f12605k = nImageView;
        nImageView.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) objArr[5];
        this.f12606l = linearLayout2;
        linearLayout2.setTag(null);
        TextView textView2 = (TextView) objArr[6];
        this.f12607m = textView2;
        textView2.setTag(null);
        TextView textView3 = (TextView) objArr[7];
        this.n = textView3;
        textView3.setTag(null);
        TextView textView4 = (TextView) objArr[8];
        this.o = textView4;
        textView4.setTag(null);
        FrameLayout frameLayout2 = (FrameLayout) objArr[9];
        this.p = frameLayout2;
        frameLayout2.setTag(null);
        this.f12540d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
