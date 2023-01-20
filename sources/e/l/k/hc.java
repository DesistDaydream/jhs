package e.l.k;

import android.graphics.drawable.Drawable;
import android.text.method.MovementMethod;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.adapter.ReplyListAdapter;
import com.jihuanshe.model.ReplyDetailInfo;
import com.vector.databinding.adapter.TextViewBinding;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public class hc extends gc {
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f12800m = null;
    @Nullable
    private static final SparseIntArray n;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final ConstraintLayout f12801i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    private final TextView f12802j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private final ImageView f12803k;

    /* renamed from: l  reason: collision with root package name */
    private long f12804l;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n = sparseIntArray;
        sparseIntArray.put(R.id.llTop, 7);
        sparseIntArray.put(R.id.llBot, 8);
    }

    public hc(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 9, f12800m, n));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        String str;
        CharSequence charSequence;
        String str2;
        Drawable drawable;
        String str3;
        e.t.j.h.g gVar;
        e.t.j.h.g gVar2;
        MovementMethod movementMethod;
        e.t.j.h.g gVar3;
        e.t.j.h.g gVar4;
        String str4;
        e.t.r.a.a aVar;
        int i2;
        String str5;
        Drawable drawable2;
        CharSequence charSequence2;
        String str6;
        String str7;
        int i3;
        int i4;
        long j3;
        long j4;
        synchronized (this) {
            j2 = this.f12804l;
            this.f12804l = 0L;
        }
        ReplyDetailInfo replyDetailInfo = this.f12742h;
        ReplyListAdapter replyListAdapter = this.f12741g;
        int i5 = 0;
        if ((j2 & 7) != 0) {
            String avatar = replyDetailInfo != null ? replyDetailInfo.getAvatar() : null;
            e.t.r.a.a A = replyListAdapter != null ? replyListAdapter.A() : null;
            int i6 = ((j2 & 5) > 0L ? 1 : ((j2 & 5) == 0L ? 0 : -1));
            if (i6 != 0) {
                if (replyDetailInfo != null) {
                    int userID = replyDetailInfo.getUserID();
                    boolean isLike = replyDetailInfo.isLike();
                    charSequence2 = replyDetailInfo.getHandleContent();
                    str6 = replyDetailInfo.getUsername();
                    str7 = replyDetailInfo.getDiffTime();
                    i4 = replyDetailInfo.getLikeCount();
                    i3 = userID;
                    i5 = isLike;
                } else {
                    charSequence2 = null;
                    str6 = null;
                    str7 = null;
                    i3 = 0;
                    i4 = 0;
                }
                if (i6 != 0) {
                    if (i5 != 0) {
                        j3 = j2 | 16;
                        j4 = 64;
                    } else {
                        j3 = j2 | 8;
                        j4 = 32;
                    }
                    j2 = j3 | j4;
                }
                int colorFromResource = ViewDataBinding.getColorFromResource(this.f12740f, i5 != 0 ? R.color.common_color : R.color.black_b5b5b7);
                drawable2 = AppCompatResources.getDrawable(this.f12740f.getContext(), i5 != 0 ? R.drawable.svg_like : R.drawable.svg_like_hollow);
                i5 = colorFromResource;
                str5 = String.valueOf(i4);
            } else {
                str5 = null;
                drawable2 = null;
                charSequence2 = null;
                str6 = null;
                str7 = null;
                i3 = 0;
            }
            if ((j2 & 6) == 0 || replyListAdapter == null) {
                str3 = str5;
                str4 = avatar;
                aVar = A;
                i2 = i5;
                gVar = null;
                gVar2 = null;
                movementMethod = null;
                gVar3 = null;
                gVar4 = null;
                i5 = i3;
                str = str6;
                str2 = str7;
            } else {
                e.t.j.h.g w = replyListAdapter.w();
                e.t.j.h.g x = replyListAdapter.x();
                e.t.j.h.g y = replyListAdapter.y();
                e.t.j.h.g z = replyListAdapter.z();
                movementMethod = replyListAdapter.v();
                str3 = str5;
                str4 = avatar;
                aVar = A;
                i2 = i5;
                gVar3 = w;
                i5 = i3;
                gVar4 = x;
                str = str6;
                str2 = str7;
                gVar = y;
                gVar2 = z;
            }
            drawable = drawable2;
            charSequence = charSequence2;
        } else {
            str = null;
            charSequence = null;
            str2 = null;
            drawable = null;
            str3 = null;
            gVar = null;
            gVar2 = null;
            movementMethod = null;
            gVar3 = null;
            gVar4 = null;
            str4 = null;
            aVar = null;
            i2 = 0;
        }
        if ((5 & j2) != 0) {
            e.l.i.f0.k(this.a, Integer.valueOf(i5));
            TextViewBindingAdapter.setText(this.f12802j, str);
            e.l.i.f0.k(this.f12802j, Integer.valueOf(i5));
            e.l.i.f0.k(this.f12803k, replyDetailInfo);
            TextViewBindingAdapter.setText(this.f12738d, charSequence);
            e.l.i.f0.k(this.f12738d, replyDetailInfo);
            TextViewBindingAdapter.setText(this.f12739e, str2);
            TextViewBindingAdapter.setDrawableStart(this.f12740f, drawable);
            TextViewBinding.m(this.f12740f, Integer.valueOf(i2));
            TextViewBindingAdapter.setText(this.f12740f, str3);
            e.l.i.f0.k(this.f12740f, replyDetailInfo);
        }
        if ((6 & j2) != 0) {
            e.t.j.g.e0.F(this.a, gVar);
            e.t.j.g.e0.F(this.f12802j, gVar);
            e.t.j.g.e0.F(this.f12803k, gVar2);
            TextViewBinding.h(this.f12738d, movementMethod);
            e.t.j.g.e0.F(this.f12738d, gVar3);
            e.t.j.g.e0.F(this.f12740f, gVar4);
        }
        if ((7 & j2) != 0) {
            NImageView nImageView = this.a;
            e.t.j.g.y.a(nImageView, str4, null, null, null, null, AppCompatResources.getDrawable(nImageView.getContext(), R.drawable.svg_default_avatar), null, null, null, null, aVar, null, null, null, null, null);
        }
        if ((j2 & 4) != 0) {
            com.jihuanshe.binding.TextViewBinding.c(this.f12738d, Boolean.TRUE);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f12804l != 0;
        }
    }

    @Override // e.l.k.gc
    public void i(@Nullable ReplyListAdapter replyListAdapter) {
        this.f12741g = replyListAdapter;
        synchronized (this) {
            this.f12804l |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f12804l = 4L;
        }
        requestRebind();
    }

    @Override // e.l.k.gc
    public void j(@Nullable ReplyDetailInfo replyDetailInfo) {
        this.f12742h = replyDetailInfo;
        synchronized (this) {
            this.f12804l |= 1;
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
            j((ReplyDetailInfo) obj);
        } else if (2 != i2) {
            return false;
        } else {
            i((ReplyListAdapter) obj);
        }
        return true;
    }

    private hc(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (NImageView) objArr[1], (LinearLayout) objArr[8], (LinearLayout) objArr[7], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[6]);
        this.f12804l = -1L;
        this.a.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f12801i = constraintLayout;
        constraintLayout.setTag(null);
        TextView textView = (TextView) objArr[2];
        this.f12802j = textView;
        textView.setTag(null);
        ImageView imageView = (ImageView) objArr[3];
        this.f12803k = imageView;
        imageView.setTag(null);
        this.f12738d.setTag(null);
        this.f12739e.setTag(null);
        this.f12740f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
