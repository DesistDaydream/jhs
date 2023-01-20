package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.detail.ReviewListActivity;
import com.jihuanshe.ui.widget.FilterTextView;
import com.jihuanshe.ui.widget.StarRatingBar;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class y1 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final ConstraintLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final CoordinatorLayout f13937c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final EditText f13938d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final FilterTextView f13939e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f13940f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ListView f13941g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f13942h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f13943i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final ConstraintLayout f13944j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final StarRatingBar f13945k;
    @NonNull

    /* renamed from: l  reason: collision with root package name */
    public final TextView f13946l;
    @NonNull

    /* renamed from: m  reason: collision with root package name */
    public final TextView f13947m;
    @NonNull
    public final TextView n;
    @Bindable
    public ReviewListActivity o;
    @Bindable
    public ReviewListViewModel p;

    public y1(Object obj, View view, int i2, TextView textView, ConstraintLayout constraintLayout, CoordinatorLayout coordinatorLayout, EditText editText, FilterTextView filterTextView, View view2, ListView listView, LinearLayout linearLayout, LinearLayout linearLayout2, ConstraintLayout constraintLayout2, StarRatingBar starRatingBar, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = textView;
        this.b = constraintLayout;
        this.f13937c = coordinatorLayout;
        this.f13938d = editText;
        this.f13939e = filterTextView;
        this.f13940f = view2;
        this.f13941g = listView;
        this.f13942h = linearLayout;
        this.f13943i = linearLayout2;
        this.f13944j = constraintLayout2;
        this.f13945k = starRatingBar;
        this.f13946l = textView2;
        this.f13947m = textView3;
        this.n = textView4;
    }

    public static y1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static y1 b(@NonNull View view, @Nullable Object obj) {
        return (y1) ViewDataBinding.bind(obj, view, R.layout.activity_review_list);
    }

    @NonNull
    public static y1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static y1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static y1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (y1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_review_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static y1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (y1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_review_list, null, false, obj);
    }

    @Nullable
    public ReviewListActivity c() {
        return this.o;
    }

    @Nullable
    public ReviewListViewModel d() {
        return this.p;
    }

    public abstract void i(@Nullable ReviewListActivity reviewListActivity);

    public abstract void j(@Nullable ReviewListViewModel reviewListViewModel);
}
