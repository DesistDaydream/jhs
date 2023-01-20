package e.l.k;

import android.graphics.drawable.Drawable;
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
import com.jihuanshe.adapter.CommentAdapter;
import com.jihuanshe.model.TopCommentInfo;
import com.vector.databinding.adapter.TextViewBinding;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class nd extends md {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13213i = null;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static final SparseIntArray f13214j = null;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f13215g;

    /* renamed from: h  reason: collision with root package name */
    private long f13216h;

    public nd(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 5, f13213i, f13214j));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        CharSequence charSequence;
        String str;
        String str2;
        e.t.j.h.g gVar;
        Drawable drawable;
        String str3;
        e.t.r.a.b bVar;
        String str4;
        CharSequence charSequence2;
        String str5;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.f13216h;
            this.f13216h = 0L;
        }
        TopCommentInfo topCommentInfo = this.f13150f;
        CommentAdapter commentAdapter = this.f13149e;
        int i2 = 0;
        boolean z = false;
        i2 = 0;
        e.t.j.h.g gVar2 = null;
        if ((j2 & 7) != 0) {
            String avatar = topCommentInfo != null ? topCommentInfo.getAvatar() : null;
            e.t.r.a.b x = commentAdapter != null ? commentAdapter.x() : null;
            int i3 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
            if (i3 != 0) {
                if (topCommentInfo != null) {
                    z = topCommentInfo.isLike();
                    str4 = topCommentInfo.getLikeCountStr();
                    charSequence2 = topCommentInfo.getHandleContent();
                    str5 = topCommentInfo.getNameStr();
                } else {
                    str4 = null;
                    charSequence2 = null;
                    str5 = null;
                }
                if (i3 != 0) {
                    if (z) {
                        j3 = j2 | 16;
                        j4 = 64;
                    } else {
                        j3 = j2 | 8;
                        j4 = 32;
                    }
                    j2 = j3 | j4;
                }
                int colorFromResource = ViewDataBinding.getColorFromResource(this.f13147c, z ? R.color.common_color : R.color.black_b5b5b7);
                drawable = AppCompatResources.getDrawable(this.f13147c.getContext(), z ? R.drawable.svg_like_small : R.drawable.svg_like_hollow_small);
                i2 = colorFromResource;
            } else {
                drawable = null;
                str4 = null;
                charSequence2 = null;
                str5 = null;
            }
            if ((j2 & 6) != 0 && commentAdapter != null) {
                gVar2 = commentAdapter.w();
            }
            str3 = avatar;
            bVar = x;
            gVar = gVar2;
            str = str4;
            charSequence = charSequence2;
            str2 = str5;
        } else {
            charSequence = null;
            str = null;
            str2 = null;
            gVar = null;
            drawable = null;
            str3 = null;
            bVar = null;
        }
        if ((7 & j2) != 0) {
            NImageView nImageView = this.a;
            e.t.j.g.y.a(nImageView, str3, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.bg_err_image), null, null, null, null, bVar, null, null, null, null, null);
        }
        if ((5 & j2) != 0) {
            TextViewBindingAdapter.setText(this.b, charSequence);
            TextViewBinding.m(this.f13147c, Integer.valueOf(i2));
            TextViewBindingAdapter.setDrawableStart(this.f13147c, drawable);
            e.l.i.f0.k(this.f13147c, topCommentInfo);
            TextViewBindingAdapter.setText(this.f13147c, str);
            TextViewBindingAdapter.setText(this.f13148d, str2);
        }
        if ((j2 & 6) != 0) {
            e.t.j.g.e0.F(this.f13147c, gVar);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13216h != 0;
        }
    }

    @Override // e.l.k.md
    public void i(@Nullable CommentAdapter commentAdapter) {
        this.f13149e = commentAdapter;
        synchronized (this) {
            this.f13216h |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13216h = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.md
    public void j(@Nullable TopCommentInfo topCommentInfo) {
        this.f13150f = topCommentInfo;
        synchronized (this) {
            this.f13216h |= 1;
        }
        notifyPropertyChanged(8);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (8 == i2) {
            j((TopCommentInfo) obj);
        } else if (2 != i2) {
            return false;
        } else {
            i((CommentAdapter) obj);
        }
        return true;
    }

    private nd(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (TextView) objArr[4], (TextView) objArr[3], (TextView) objArr[2]);
        this.f13216h = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13215g = constraintLayout;
        constraintLayout.setTag(null);
        this.b.setTag(null);
        this.f13147c.setTag(null);
        this.f13148d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
