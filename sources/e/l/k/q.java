package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartView;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.detail.CardDetailActivity;
import com.jihuanshe.ui.widget.CardImageView;
import com.jihuanshe.ui.widget.ConditionFilterBtn;
import com.jihuanshe.ui.widget.CopyTextView;
import com.jihuanshe.ui.widget.ScoreView;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class q extends ViewDataBinding {
    @NonNull
    public final TextView A;
    @NonNull
    public final ScoreView B;
    @NonNull
    public final TextView C;
    @NonNull
    public final TextView D;
    @NonNull
    public final TextView E;
    @NonNull
    public final TextView F;
    @NonNull
    public final View G;
    @NonNull
    public final View H;
    @Bindable
    public CardDetailActivity I;
    @Bindable
    public CardDetailViewModel J;
    @NonNull
    public final TextView a;
    @NonNull
    public final AAChartView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ConditionFilterBtn f13364c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final CoordinatorLayout f13365d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final CardImageView f13366e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f13367f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f13368g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final ImageView f13369h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final ListView f13370i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f13371j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final LinearLayout f13372k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final LinearLayout f13373l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final LinearLayout f13374m;
    @NonNull
    public final LinearLayout n;
    @NonNull
    public final LinearLayout o;
    @NonNull
    public final TextView p;
    @NonNull
    public final ScoreView q;
    @NonNull
    public final TextView r;
    @NonNull
    public final TextView s;
    @NonNull
    public final TextView t;
    @NonNull
    public final TextView u;
    @NonNull
    public final CopyTextView v;
    @NonNull
    public final CopyTextView w;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    public q(Object obj, View view, int i2, TextView textView, AAChartView aAChartView, ConditionFilterBtn conditionFilterBtn, CoordinatorLayout coordinatorLayout, CardImageView cardImageView, ImageView imageView, ImageView imageView2, ImageView imageView3, ListView listView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, LinearLayout linearLayout4, LinearLayout linearLayout5, LinearLayout linearLayout6, TextView textView2, ScoreView scoreView, TextView textView3, TextView textView4, TextView textView5, TextView textView6, CopyTextView copyTextView, CopyTextView copyTextView2, TextView textView7, TextView textView8, TextView textView9, TextView textView10, ScoreView scoreView2, TextView textView11, TextView textView12, TextView textView13, TextView textView14, View view2, View view3) {
        super(obj, view, i2);
        this.a = textView;
        this.b = aAChartView;
        this.f13364c = conditionFilterBtn;
        this.f13365d = coordinatorLayout;
        this.f13366e = cardImageView;
        this.f13367f = imageView;
        this.f13368g = imageView2;
        this.f13369h = imageView3;
        this.f13370i = listView;
        this.f13371j = linearLayout;
        this.f13372k = linearLayout2;
        this.f13373l = linearLayout3;
        this.f13374m = linearLayout4;
        this.n = linearLayout5;
        this.o = linearLayout6;
        this.p = textView2;
        this.q = scoreView;
        this.r = textView3;
        this.s = textView4;
        this.t = textView5;
        this.u = textView6;
        this.v = copyTextView;
        this.w = copyTextView2;
        this.x = textView7;
        this.y = textView8;
        this.z = textView9;
        this.A = textView10;
        this.B = scoreView2;
        this.C = textView11;
        this.D = textView12;
        this.E = textView13;
        this.F = textView14;
        this.G = view2;
        this.H = view3;
    }

    public static q a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static q b(@NonNull View view, @Nullable Object obj) {
        return (q) ViewDataBinding.bind(obj, view, R.layout.activity_card_detail);
    }

    @NonNull
    public static q e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static q f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static q g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (q) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_card_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static q h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (q) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_card_detail, null, false, obj);
    }

    @Nullable
    public CardDetailActivity c() {
        return this.I;
    }

    @Nullable
    public CardDetailViewModel d() {
        return this.J;
    }

    public abstract void i(@Nullable CardDetailActivity cardDetailActivity);

    public abstract void j(@Nullable CardDetailViewModel cardDetailViewModel);
}
