package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.donkingliang.labels.LabelsView;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.search.fragments.global.GlobalSearchFragment;

/* loaded from: classes2.dex */
public abstract class og extends ViewDataBinding {
    @NonNull
    public final LabelsView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13277c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13278d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f13279e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public GlobalSearchFragment f13280f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public e.l.q.b.j.b f13281g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public e.l.s.m.b f13282h;

    public og(Object obj, View view, int i2, LabelsView labelsView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = labelsView;
        this.b = textView;
        this.f13277c = textView2;
        this.f13278d = textView3;
        this.f13279e = textView4;
    }

    public static og a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static og b(@NonNull View view, @Nullable Object obj) {
        return (og) ViewDataBinding.bind(obj, view, R.layout.view_search_history);
    }

    @NonNull
    public static og f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static og g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static og h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (og) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_search_history, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static og i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (og) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_search_history, null, false, obj);
    }

    @Nullable
    public GlobalSearchFragment c() {
        return this.f13280f;
    }

    @Nullable
    public e.l.q.b.j.b d() {
        return this.f13281g;
    }

    @Nullable
    public e.l.s.m.b e() {
        return this.f13282h;
    }

    public abstract void j(@Nullable GlobalSearchFragment globalSearchFragment);

    public abstract void k(@Nullable e.l.q.b.j.b bVar);

    public abstract void l(@Nullable e.l.s.m.b bVar);
}
