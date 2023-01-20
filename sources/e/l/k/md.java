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
import com.jihuanshe.R;
import com.jihuanshe.adapter.CommentAdapter;
import com.jihuanshe.model.TopCommentInfo;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class md extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f13147c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f13148d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public CommentAdapter f13149e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public TopCommentInfo f13150f;

    public md(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f13147c = textView2;
        this.f13148d = textView3;
    }

    public static md a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static md b(@NonNull View view, @Nullable Object obj) {
        return (md) ViewDataBinding.bind(obj, view, R.layout.item_top_comment);
    }

    @NonNull
    public static md e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static md f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static md g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (md) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_top_comment, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static md h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (md) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_top_comment, null, false, obj);
    }

    @Nullable
    public CommentAdapter c() {
        return this.f13149e;
    }

    @Nullable
    public TopCommentInfo d() {
        return this.f13150f;
    }

    public abstract void i(@Nullable CommentAdapter commentAdapter);

    public abstract void j(@Nullable TopCommentInfo topCommentInfo);
}
