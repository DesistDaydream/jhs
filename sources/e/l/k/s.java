package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.detail.CardPackDetailActivity;
import com.jihuanshe.ui.widget.CopyTextView;
import com.jihuanshe.ui.widget.NestedRecyclerView;
import com.jihuanshe.ui.widget.ScoreView;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import com.vector.network.image.NImageView;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class s extends ViewDataBinding {
    @NonNull
    public final View A;
    @Bindable
    public CardPackDetailActivity B;
    @Bindable
    public CardPackDetailViewModel C;
    @NonNull
    public final TextView a;
    @NonNull
    public final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final NImageView f13521c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f13522d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f13523e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f13524f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ListView f13525g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f13526h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f13527i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final LinearLayout f13528j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final NestedRecyclerView f13529k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f13530l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final ScoreView f13531m;
    @NonNull
    public final TextView n;
    @NonNull
    public final TextView o;
    @NonNull
    public final TextView p;
    @NonNull
    public final CopyTextView q;
    @NonNull
    public final CopyTextView r;
    @NonNull
    public final CopyTextView s;
    @NonNull
    public final TextView t;
    @NonNull
    public final TextView u;
    @NonNull
    public final TextView v;
    @NonNull
    public final ScoreView w;
    @NonNull
    public final TextView x;
    @NonNull
    public final TextView y;
    @NonNull
    public final TextView z;

    public s(Object obj, View view, int i2, TextView textView, ConstraintLayout constraintLayout, NImageView nImageView, ImageView imageView, ImageView imageView2, ImageView imageView3, ListView listView, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, NestedRecyclerView nestedRecyclerView, TextView textView2, ScoreView scoreView, TextView textView3, TextView textView4, TextView textView5, CopyTextView copyTextView, CopyTextView copyTextView2, CopyTextView copyTextView3, TextView textView6, TextView textView7, TextView textView8, ScoreView scoreView2, TextView textView9, TextView textView10, TextView textView11, View view2) {
        super(obj, view, i2);
        this.a = textView;
        this.b = constraintLayout;
        this.f13521c = nImageView;
        this.f13522d = imageView;
        this.f13523e = imageView2;
        this.f13524f = imageView3;
        this.f13525g = listView;
        this.f13526h = linearLayout;
        this.f13527i = linearLayout2;
        this.f13528j = linearLayout3;
        this.f13529k = nestedRecyclerView;
        this.f13530l = textView2;
        this.f13531m = scoreView;
        this.n = textView3;
        this.o = textView4;
        this.p = textView5;
        this.q = copyTextView;
        this.r = copyTextView2;
        this.s = copyTextView3;
        this.t = textView6;
        this.u = textView7;
        this.v = textView8;
        this.w = scoreView2;
        this.x = textView9;
        this.y = textView10;
        this.z = textView11;
        this.A = view2;
    }

    public static s a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s b(@NonNull View view, @Nullable Object obj) {
        return (s) ViewDataBinding.bind(obj, view, R.layout.activity_card_pack_detail);
    }

    @NonNull
    public static s e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_card_pack_detail, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_card_pack_detail, null, false, obj);
    }

    @Nullable
    public CardPackDetailActivity c() {
        return this.B;
    }

    @Nullable
    public CardPackDetailViewModel d() {
        return this.C;
    }

    public abstract void i(@Nullable CardPackDetailActivity cardPackDetailActivity);

    public abstract void j(@Nullable CardPackDetailViewModel cardPackDetailViewModel);
}
