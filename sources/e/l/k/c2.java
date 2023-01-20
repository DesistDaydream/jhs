package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.search.SearchActivity;

/* loaded from: classes2.dex */
public abstract class c2 extends ViewDataBinding {
    @NonNull
    public final AppBarLayout a;
    @NonNull
    public final EditText b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f12389c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f12390d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12391e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public SearchActivity f12392f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public e.l.s.m.c f12393g;

    public c2(Object obj, View view, int i2, AppBarLayout appBarLayout, EditText editText, FrameLayout frameLayout, FrameLayout frameLayout2, TextView textView) {
        super(obj, view, i2);
        this.a = appBarLayout;
        this.b = editText;
        this.f12389c = frameLayout;
        this.f12390d = frameLayout2;
        this.f12391e = textView;
    }

    public static c2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static c2 b(@NonNull View view, @Nullable Object obj) {
        return (c2) ViewDataBinding.bind(obj, view, R.layout.activity_search);
    }

    @NonNull
    public static c2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static c2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static c2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (c2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_search, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static c2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (c2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_search, null, false, obj);
    }

    @Nullable
    public SearchActivity c() {
        return this.f12392f;
    }

    @Nullable
    public e.l.s.m.c d() {
        return this.f12393g;
    }

    public abstract void i(@Nullable SearchActivity searchActivity);

    public abstract void j(@Nullable e.l.s.m.c cVar);
}
