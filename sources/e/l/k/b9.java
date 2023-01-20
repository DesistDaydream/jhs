package e.l.k;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.caverock.androidsvg.SVG;
import com.jihuanshe.R;
import com.jihuanshe.adapter.AtMeAdapter;
import com.jihuanshe.model.InteractData;
import com.vector.databinding.adapter.TextViewBinding;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class b9 extends a9 {
    @Nullable
    private static final ViewDataBinding.IncludedLayouts p = null;
    @Nullable
    private static final SparseIntArray q;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ConstraintLayout f12351k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    private final TextView f12352l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    private final TextView f12353m;
    @NonNull
    private final NImageView n;
    private long o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        q = sparseIntArray;
        sparseIntArray.put(R.id.oriMedia, 10);
    }

    public b9(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 11, p, q));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        Drawable drawable;
        String str;
        String str2;
        String str3;
        e.t.r.a.a aVar;
        CharSequence charSequence;
        String str4;
        int i2;
        int i3;
        int i4;
        boolean z;
        boolean z2;
        int i5;
        int i6;
        CharSequence charSequence2;
        String str5;
        String str6;
        String str7;
        CharSequence charSequence3;
        String str8;
        int i7;
        int i8;
        int i9;
        Boolean bool;
        boolean z3;
        synchronized (this) {
            j2 = this.o;
            this.o = 0L;
        }
        InteractData interactData = this.f12281i;
        Integer num = this.f12282j;
        AtMeAdapter atMeAdapter = this.f12280h;
        if ((j2 & 13) != 0) {
            int i10 = ((j2 & 9) > 0L ? 1 : ((j2 & 9) == 0L ? 0 : -1));
            if (i10 != 0) {
                if (interactData != null) {
                    bool = interactData.getDelete();
                    z3 = interactData.isRead();
                    str6 = interactData.getCreateTime();
                    i8 = interactData.textColor();
                    z = interactData.isText();
                    str7 = interactData.getAction();
                    z2 = interactData.isImage();
                    charSequence3 = interactData.getHandleContent();
                    str8 = interactData.getFromUName();
                } else {
                    bool = null;
                    str6 = null;
                    str7 = null;
                    charSequence3 = null;
                    str8 = null;
                    z3 = false;
                    i8 = 0;
                    z = false;
                    z2 = false;
                }
                if (i10 != 0) {
                    j2 |= z3 ? SVG.E : SVG.D;
                }
                if ((j2 & 9) != 0) {
                    j2 = z ? j2 | 512 | 2048 : j2 | 256 | 1024;
                }
                if ((j2 & 9) != 0) {
                    j2 = z2 ? j2 | 32 | SVG.A : j2 | 16 | 4096;
                }
                boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
                i3 = z3 ? 8 : 0;
                i7 = z ? 0 : 8;
                i9 = z2 ? 0 : 8;
                if ((j2 & 9) != 0) {
                    j2 |= safeUnbox ? SVG.C : 16384L;
                }
                drawable = safeUnbox ? AppCompatResources.getDrawable(this.b.getContext(), R.drawable.bg_comment_delete) : null;
            } else {
                drawable = null;
                str6 = null;
                str7 = null;
                charSequence3 = null;
                str8 = null;
                i3 = 0;
                i7 = 0;
                i8 = 0;
                z = false;
                z2 = false;
                i9 = 0;
            }
            String fromUAvatar = interactData != null ? interactData.getFromUAvatar() : null;
            e.t.r.a.a w = atMeAdapter != null ? atMeAdapter.w() : null;
            if ((j2 & 12) == 0 || atMeAdapter == null) {
                str3 = fromUAvatar;
                aVar = w;
                gVar = null;
            } else {
                gVar = atMeAdapter.v();
                str3 = fromUAvatar;
                aVar = w;
            }
            i2 = i7;
            str = str6;
            i4 = i8;
            str2 = str7;
            charSequence = charSequence3;
            str4 = str8;
            i5 = i9;
        } else {
            gVar = null;
            drawable = null;
            str = null;
            str2 = null;
            str3 = null;
            aVar = null;
            charSequence = null;
            str4 = null;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            z = false;
            z2 = false;
            i5 = 0;
        }
        int i11 = ((j2 & 10) > 0L ? 1 : ((j2 & 10) == 0L ? 0 : -1));
        if (i11 != 0) {
            boolean z4 = ViewDataBinding.safeUnbox(num) == 0;
            if (i11 != 0) {
                j2 |= z4 ? 128L : 64L;
            }
            i6 = z4 ? 0 : 8;
        } else {
            i6 = 0;
        }
        CharSequence handleSourceContent = ((j2 & 2048) == 0 || interactData == null) ? null : interactData.getHandleSourceContent();
        String sourceContent = ((SVG.A & j2) == 0 || interactData == null) ? null : interactData.getSourceContent();
        int i12 = ((j2 & 9) > 0L ? 1 : ((j2 & 9) == 0L ? 0 : -1));
        if (i12 != 0) {
            if (!z) {
                handleSourceContent = null;
            }
            String str9 = z2 ? sourceContent : null;
            charSequence2 = handleSourceContent;
            str5 = str9;
        } else {
            charSequence2 = null;
            str5 = null;
        }
        if (i12 != 0) {
            e.l.i.f0.k(this.a, interactData);
            TextViewBindingAdapter.setText(this.b, charSequence);
            TextViewBinding.j(this.b, i4);
            ViewBindingAdapter.setBackground(this.b, drawable);
            TextViewBindingAdapter.setText(this.f12352l, str);
            this.f12353m.setVisibility(i2);
            TextViewBindingAdapter.setText(this.f12353m, charSequence2);
            this.n.setVisibility(i5);
            NImageView nImageView = this.n;
            e.t.j.g.y.a(nImageView, str5, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, null, null, null, null, null, null);
            TextViewBindingAdapter.setText(this.f12275c, str4);
            e.l.i.f0.k(this.f12275c, interactData);
            this.f12277e.setVisibility(i3);
            TextViewBindingAdapter.setText(this.f12279g, str2);
        }
        if ((12 & j2) != 0) {
            e.t.j.g.e0.F(this.a, gVar);
            e.t.j.g.e0.F(this.f12275c, gVar);
        }
        if ((13 & j2) != 0) {
            NImageView nImageView2 = this.a;
            e.t.j.g.y.a(nImageView2, str3, null, null, null, null, AppCompatResources.getDrawable(nImageView2.getContext(), R.drawable.ic_default_grey_15), null, null, null, null, aVar, null, null, null, null, null);
        }
        if ((j2 & 10) != 0) {
            this.f12278f.setVisibility(i6);
        }
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
            this.o = 8L;
        }
        requestRebind();
    }

    @Override // e.l.k.a9
    public void j(@Nullable AtMeAdapter atMeAdapter) {
        this.f12280h = atMeAdapter;
        synchronized (this) {
            this.o |= 4;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // e.l.k.a9
    public void k(@Nullable InteractData interactData) {
        this.f12281i = interactData;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // e.l.k.a9
    public void l(@Nullable Integer num) {
        this.f12282j = num;
        synchronized (this) {
            this.o |= 2;
        }
        notifyPropertyChanged(11);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            k((InteractData) obj);
        } else if (11 == i2) {
            l((Integer) obj);
        } else if (2 != i2) {
            return false;
        } else {
            j((AtMeAdapter) obj);
        }
        return true;
    }

    private b9(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[2], (TextView) objArr[6], (TextView) objArr[3], (FrameLayout) objArr[10], (View) objArr[5], (View) objArr[1], (TextView) objArr[4]);
        this.o = -1L;
        this.a.setTag(null);
        this.b.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12351k = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[7];
        this.f12352l = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) objArr[8];
        this.f12353m = textView2;
        textView2.setTag(null);
        NImageView nImageView = (NImageView) objArr[9];
        this.n = nImageView;
        nImageView.setTag(null);
        this.f12275c.setTag(null);
        this.f12277e.setTag(null);
        this.f12278f.setTag(null);
        this.f12279g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
