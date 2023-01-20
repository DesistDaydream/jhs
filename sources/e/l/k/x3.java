package e.l.k;

import android.net.Uri;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.BaseUploadInfoDialog;
import com.vector.network.image.NImageView;
import java.util.List;

/* loaded from: classes2.dex */
public class x3 extends w3 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts v = null;
    @Nullable
    private static final SparseIntArray w;
    @NonNull
    private final ConstraintLayout o;
    @NonNull
    private final ImageView p;
    @NonNull
    private final ImageView q;
    @NonNull
    private final TextView r;
    @NonNull
    private final ImageView s;
    @NonNull
    private final ImageView t;
    private long u;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        w = sparseIntArray;
        sparseIntArray.put(R.id.cl, 17);
        sparseIntArray.put(R.id.cl2, 18);
    }

    public x3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 19, v, w));
    }

    private boolean i(e.n.f<Uri> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.u |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean j(e.n.f<List<String>> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.u |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean k(e.n.f<Uri> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.u |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean l(e.n.f<Uri> fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.u |= 4;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016f  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void executeBindings() {
        /*
            Method dump skipped, instructions count: 716
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.k.x3.executeBindings():void");
    }

    @Override // e.l.k.w3
    public void h(@Nullable BaseUploadInfoDialog baseUploadInfoDialog) {
        this.n = baseUploadInfoDialog;
        synchronized (this) {
            this.u |= 16;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.u != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.u = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return false;
                    }
                    return k((e.n.f) obj, i3);
                }
                return l((e.n.f) obj, i3);
            }
            return j((e.n.f) obj, i3);
        }
        return i((e.n.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((BaseUploadInfoDialog) obj);
            return true;
        }
        return false;
    }

    private x3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (ConstraintLayout) objArr[17], (LinearLayout) objArr[18], (EditText) objArr[4], (FrameLayout) objArr[8], (FrameLayout) objArr[5], (FrameLayout) objArr[11], (NImageView) objArr[9], (NImageView) objArr[6], (NImageView) objArr[12], (LabelsView) objArr[3], (TextView) objArr[15], (TextView) objArr[1], (TextView) objArr[14]);
        this.u = -1L;
        this.f13815c.setTag(null);
        this.f13816d.setTag(null);
        this.f13817e.setTag(null);
        this.f13818f.setTag(null);
        this.f13819g.setTag(null);
        this.f13820h.setTag(null);
        this.f13821i.setTag(null);
        this.f13822j.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.o = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[10];
        this.p = imageView;
        imageView.setTag(null);
        ImageView imageView2 = (ImageView) objArr[13];
        this.q = imageView2;
        imageView2.setTag(null);
        TextView textView = (TextView) objArr[16];
        this.r = textView;
        textView.setTag(null);
        ImageView imageView3 = (ImageView) objArr[2];
        this.s = imageView3;
        imageView3.setTag(null);
        ImageView imageView4 = (ImageView) objArr[7];
        this.t = imageView4;
        imageView4.setTag(null);
        this.f13823k.setTag(null);
        this.f13824l.setTag(null);
        this.f13825m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
