package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.web.CommonWebViewActivity;
import com.vector.view.WebViewEx;

/* loaded from: classes2.dex */
public abstract class e0 extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final ImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final ProgressBar f12539c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final WebViewEx f12540d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public CommonWebViewActivity f12541e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public e.l.s.p.a f12542f;

    public e0(Object obj, View view, int i2, LinearLayout linearLayout, ImageView imageView, ProgressBar progressBar, WebViewEx webViewEx) {
        super(obj, view, i2);
        this.a = linearLayout;
        this.b = imageView;
        this.f12539c = progressBar;
        this.f12540d = webViewEx;
    }

    public static e0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e0 b(@NonNull View view, @Nullable Object obj) {
        return (e0) ViewDataBinding.bind(obj, view, R.layout.activity_common_webview);
    }

    @NonNull
    public static e0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_common_webview, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_common_webview, null, false, obj);
    }

    @Nullable
    public CommonWebViewActivity c() {
        return this.f12541e;
    }

    @Nullable
    public e.l.s.p.a d() {
        return this.f12542f;
    }

    public abstract void i(@Nullable CommonWebViewActivity commonWebViewActivity);

    public abstract void j(@Nullable e.l.s.p.a aVar);
}
