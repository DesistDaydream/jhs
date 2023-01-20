package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.user.edit.EditUserActivity;

/* loaded from: classes2.dex */
public abstract class m0 extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final LinearLayout b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public EditUserActivity f13097c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public e.l.s.o.c.a f13098d;

    public m0(Object obj, View view, int i2, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i2);
        this.a = linearLayout;
        this.b = linearLayout2;
    }

    public static m0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m0 b(@NonNull View view, @Nullable Object obj) {
        return (m0) ViewDataBinding.bind(obj, view, R.layout.activity_edit_user);
    }

    @NonNull
    public static m0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_edit_user, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_edit_user, null, false, obj);
    }

    @Nullable
    public EditUserActivity c() {
        return this.f13097c;
    }

    @Nullable
    public e.l.s.o.c.a d() {
        return this.f13098d;
    }

    public abstract void i(@Nullable EditUserActivity editUserActivity);

    public abstract void j(@Nullable e.l.s.o.c.a aVar);
}
