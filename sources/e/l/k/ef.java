package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public abstract class ef extends ViewDataBinding {
    @NonNull
    public final EditText a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f12596c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f12597d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f12598e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12599f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public e.l.s.c f12600g;

    public ef(Object obj, View view, int i2, EditText editText, TextView textView, RecyclerView recyclerView, ImageView imageView, ImageView imageView2, TextView textView2) {
        super(obj, view, i2);
        this.a = editText;
        this.b = textView;
        this.f12596c = recyclerView;
        this.f12597d = imageView;
        this.f12598e = imageView2;
        this.f12599f = textView2;
    }

    public static ef a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ef b(@NonNull View view, @Nullable Object obj) {
        return (ef) ViewDataBinding.bind(obj, view, R.layout.view_filter_bar_selling);
    }

    @NonNull
    public static ef d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ef e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ef f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ef) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_filter_bar_selling, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ef g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ef) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_filter_bar_selling, null, false, obj);
    }

    @Nullable
    public e.l.s.c c() {
        return this.f12600g;
    }

    public abstract void h(@Nullable e.l.s.c cVar);
}
