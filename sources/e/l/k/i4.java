package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.ContactDialog;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.CopyTextView;

/* loaded from: classes2.dex */
public abstract class i4 extends ViewDataBinding {
    @NonNull
    public final ImageView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f12846c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final View f12847d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f12848e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final CardImageView f12849f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final CopyTextView f12850g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final CopyTextView f12851h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12852i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12853j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f12854k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f12855l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final ImageView f12856m;
    @NonNull
    public final CopyTextView n;
    @Bindable
    public ContactDialog o;

    public i4(Object obj, View view, int i2, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, View view2, View view3, CardImageView cardImageView, CopyTextView copyTextView, CopyTextView copyTextView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, ImageView imageView2, CopyTextView copyTextView3) {
        super(obj, view, i2);
        this.a = imageView;
        this.b = linearLayout;
        this.f12846c = linearLayout2;
        this.f12847d = view2;
        this.f12848e = view3;
        this.f12849f = cardImageView;
        this.f12850g = copyTextView;
        this.f12851h = copyTextView2;
        this.f12852i = textView;
        this.f12853j = textView2;
        this.f12854k = textView3;
        this.f12855l = textView4;
        this.f12856m = imageView2;
        this.n = copyTextView3;
    }

    public static i4 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static i4 b(@NonNull View view, @Nullable Object obj) {
        return (i4) ViewDataBinding.bind(obj, view, R.layout.dialog_contact);
    }

    @NonNull
    public static i4 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static i4 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static i4 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (i4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_contact, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static i4 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (i4) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_contact, null, false, obj);
    }

    @Nullable
    public ContactDialog c() {
        return this.o;
    }

    public abstract void h(@Nullable ContactDialog contactDialog);
}
