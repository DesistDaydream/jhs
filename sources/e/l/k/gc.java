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
import com.jihuanshe.adapter.ReplyListAdapter;
import com.jihuanshe.model.ReplyDetailInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class gc extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f12737c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12738d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12739e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12740f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public ReplyListAdapter f12741g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public ReplyDetailInfo f12742h;

    public gc(Object obj, View view, int i2, NImageView nImageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = linearLayout;
        this.f12737c = linearLayout2;
        this.f12738d = textView;
        this.f12739e = textView2;
        this.f12740f = textView3;
    }

    public static gc a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static gc b(@NonNull View view, @Nullable Object obj) {
        return (gc) ViewDataBinding.bind(obj, view, R.layout.item_reply_list);
    }

    @NonNull
    public static gc e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static gc f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static gc g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (gc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_reply_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static gc h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (gc) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_reply_list, null, false, obj);
    }

    @Nullable
    public ReplyListAdapter c() {
        return this.f12741g;
    }

    @Nullable
    public ReplyDetailInfo d() {
        return this.f12742h;
    }

    public abstract void i(@Nullable ReplyListAdapter replyListAdapter);

    public abstract void j(@Nullable ReplyDetailInfo replyDetailInfo);
}
