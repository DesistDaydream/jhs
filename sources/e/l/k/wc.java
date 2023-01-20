package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.widget.ScoreView;

/* loaded from: classes2.dex */
public abstract class wc extends ViewDataBinding {
    @NonNull
    public final FrameLayout a;
    @NonNull
    public final FrameLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final FrameLayout f13859c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f13860d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f13861e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final FrameLayout f13862f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ScoreView f13863g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final FrameLayout f13864h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final View f13865i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final View f13866j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f13867k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public Product f13868l;
    @Bindable

    /* renamed from: m  reason: collision with root package name */
    public e.l.g.t0 f13869m;

    public wc(Object obj, View view, int i2, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, FrameLayout frameLayout4, FrameLayout frameLayout5, FrameLayout frameLayout6, ScoreView scoreView, FrameLayout frameLayout7, View view2, View view3, TextView textView) {
        super(obj, view, i2);
        this.a = frameLayout;
        this.b = frameLayout2;
        this.f13859c = frameLayout3;
        this.f13860d = frameLayout4;
        this.f13861e = frameLayout5;
        this.f13862f = frameLayout6;
        this.f13863g = scoreView;
        this.f13864h = frameLayout7;
        this.f13865i = view2;
        this.f13866j = view3;
        this.f13867k = textView;
    }

    public static wc a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static wc b(@NonNull View view, @Nullable Object obj) {
        return (wc) ViewDataBinding.bind(obj, view, R.layout.item_sell_calendar);
    }

    @NonNull
    public static wc e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static wc f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static wc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (wc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sell_calendar, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static wc h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (wc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_sell_calendar, null, false, obj);
    }

    @Nullable
    public Product c() {
        return this.f13868l;
    }

    @Nullable
    public e.l.g.t0 d() {
        return this.f13869m;
    }

    public abstract void i(@Nullable Product product);

    public abstract void j(@Nullable e.l.g.t0 t0Var);
}
