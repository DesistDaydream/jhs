package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.user.FollowActivity;
import com.jihuanshe.viewmodel.user.FollowViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class w0 extends ViewDataBinding {
    @NonNull
    public final ListView a;
    @NonNull
    public final EditText b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f13794c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public FollowActivity f13795d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public FollowViewModel f13796e;

    public w0(Object obj, View view, int i2, ListView listView, EditText editText, LinearLayout linearLayout) {
        super(obj, view, i2);
        this.a = listView;
        this.b = editText;
        this.f13794c = linearLayout;
    }

    public static w0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w0 b(@NonNull View view, @Nullable Object obj) {
        return (w0) ViewDataBinding.bind(obj, view, R.layout.activity_follow);
    }

    @NonNull
    public static w0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_follow, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_follow, null, false, obj);
    }

    @Nullable
    public FollowActivity c() {
        return this.f13795d;
    }

    @Nullable
    public FollowViewModel d() {
        return this.f13796e;
    }

    public abstract void i(@Nullable FollowActivity followActivity);

    public abstract void j(@Nullable FollowViewModel followViewModel);
}
