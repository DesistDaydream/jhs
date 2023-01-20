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
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.ui.page.detail.ReviewListActivity;
import com.jihuanshe.ui.widget.ScoreView;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class mc extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final ImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f13136c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f13137d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f13138e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f13139f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final NImageView f13140g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ScoreView f13141h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f13142i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f13143j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final TextView f13144k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f13145l;
    @Bindable

    /* renamed from: m  reason: collision with root package name */
    public e.l.g.r0 f13146m;
    @Bindable
    public ReviewListActivity n;
    @Bindable
    public ReviewListInfo o;
    @Bindable
    public e.t.r.a.h p;

    public mc(Object obj, View view, int i2, NImageView nImageView, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, NImageView nImageView2, ScoreView scoreView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = imageView;
        this.f13136c = linearLayout;
        this.f13137d = linearLayout2;
        this.f13138e = linearLayout3;
        this.f13139f = linearLayout4;
        this.f13140g = nImageView2;
        this.f13141h = scoreView;
        this.f13142i = textView;
        this.f13143j = textView2;
        this.f13144k = textView3;
        this.f13145l = textView4;
    }

    public static mc a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static mc b(@NonNull View view, @Nullable Object obj) {
        return (mc) ViewDataBinding.bind(obj, view, R.layout.item_review_list);
    }

    @NonNull
    public static mc g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static mc h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static mc i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (mc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_review_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static mc j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (mc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_review_list, null, false, obj);
    }

    @Nullable
    public e.l.g.r0 c() {
        return this.f13146m;
    }

    @Nullable
    public ReviewListInfo d() {
        return this.o;
    }

    @Nullable
    public ReviewListActivity e() {
        return this.n;
    }

    @Nullable
    public e.t.r.a.h f() {
        return this.p;
    }

    public abstract void k(@Nullable e.l.g.r0 r0Var);

    public abstract void l(@Nullable ReviewListInfo reviewListInfo);

    public abstract void m(@Nullable ReviewListActivity reviewListActivity);

    public abstract void n(@Nullable e.t.r.a.h hVar);
}
