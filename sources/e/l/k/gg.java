package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.CopyTextView;

/* loaded from: classes2.dex */
public abstract class gg extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f12751c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CopyTextView f12752d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CardImageView f12753e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CopyTextView f12754f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CopyTextView f12755g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12756h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12757i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public CardProductNew f12758j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public String f12759k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public e.l.q.b.b.a.e f12760l;

    public gg(Object obj, View view, int i2, TextView textView, View view2, ImageView imageView, CopyTextView copyTextView, CardImageView cardImageView, CopyTextView copyTextView2, CopyTextView copyTextView3, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = textView;
        this.b = view2;
        this.f12751c = imageView;
        this.f12752d = copyTextView;
        this.f12753e = cardImageView;
        this.f12754f = copyTextView2;
        this.f12755g = copyTextView3;
        this.f12756h = textView2;
        this.f12757i = textView3;
    }

    public static gg a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static gg b(@NonNull View view, @Nullable Object obj) {
        return (gg) ViewDataBinding.bind(obj, view, R.layout.view_product_header);
    }

    @NonNull
    public static gg f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static gg g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static gg h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (gg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_product_header, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static gg i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (gg) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_product_header, null, false, obj);
    }

    @Nullable
    public String c() {
        return this.f12759k;
    }

    @Nullable
    public e.l.q.b.b.a.e d() {
        return this.f12760l;
    }

    @Nullable
    public CardProductNew e() {
        return this.f12758j;
    }

    public abstract void j(@Nullable String str);

    public abstract void k(@Nullable e.l.q.b.b.a.e eVar);

    public abstract void l(@Nullable CardProductNew cardProductNew);
}
