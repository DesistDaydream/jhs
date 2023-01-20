package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.detail.ReplyListActivity;
import com.jihuanshe.ui.widget.ScoreView;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class yf extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final View b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f14008c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f14009d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f14010e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final ScoreView f14011f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f14012g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f14013h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f14014i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f14015j;
    @Bindable

    /* renamed from: k  reason: collision with root package name */
    public ReplyListActivity f14016k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public ReplyListViewModel f14017l;

    public yf(Object obj, View view, int i2, NImageView nImageView, View view2, LinearLayout linearLayout, LinearLayout linearLayout2, LinearLayout linearLayout3, ScoreView scoreView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = view2;
        this.f14008c = linearLayout;
        this.f14009d = linearLayout2;
        this.f14010e = linearLayout3;
        this.f14011f = scoreView;
        this.f14012g = textView;
        this.f14013h = textView2;
        this.f14014i = textView3;
        this.f14015j = textView4;
    }

    public static yf a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static yf b(@NonNull View view, @Nullable Object obj) {
        return (yf) ViewDataBinding.bind(obj, view, R.layout.view_header_reply_list);
    }

    @NonNull
    public static yf e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static yf f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static yf g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (yf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_reply_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static yf h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (yf) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_header_reply_list, null, false, obj);
    }

    @Nullable
    public ReplyListActivity c() {
        return this.f14016k;
    }

    @Nullable
    public ReplyListViewModel d() {
        return this.f14017l;
    }

    public abstract void i(@Nullable ReplyListActivity replyListActivity);

    public abstract void j(@Nullable ReplyListViewModel replyListViewModel);
}
