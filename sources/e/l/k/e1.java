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
import com.jihuanshe.ui.page.im.InteractMessageActivity;
import com.jihuanshe.viewmodel.im.InteractMessageViewModel;
import com.vector.view.pager.ViewPager;

/* loaded from: classes2.dex */
public abstract class e1 extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12543c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12544d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final ViewPager f12545e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public InteractMessageActivity f12546f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public InteractMessageViewModel f12547g;

    public e1(Object obj, View view, int i2, TextView textView, LinearLayout linearLayout, TextView textView2, TextView textView3, ViewPager viewPager) {
        super(obj, view, i2);
        this.a = textView;
        this.b = linearLayout;
        this.f12543c = textView2;
        this.f12544d = textView3;
        this.f12545e = viewPager;
    }

    public static e1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e1 b(@NonNull View view, @Nullable Object obj) {
        return (e1) ViewDataBinding.bind(obj, view, R.layout.activity_interact_message);
    }

    @NonNull
    public static e1 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e1 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_interact_message, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e1 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_interact_message, null, false, obj);
    }

    @Nullable
    public InteractMessageActivity c() {
        return this.f12546f;
    }

    @Nullable
    public InteractMessageViewModel d() {
        return this.f12547g;
    }

    public abstract void i(@Nullable InteractMessageActivity interactMessageActivity);

    public abstract void j(@Nullable InteractMessageViewModel interactMessageViewModel);
}
