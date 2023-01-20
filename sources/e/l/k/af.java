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
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.widget.ConditionView;

/* loaded from: classes2.dex */
public abstract class af extends ViewDataBinding {
    @NonNull
    public final TextView a;
    @NonNull
    public final ConditionView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12301c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public e.l.q.b.b.a.c f12302d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public GameCard f12303e;

    public af(Object obj, View view, int i2, TextView textView, ConditionView conditionView, TextView textView2) {
        super(obj, view, i2);
        this.a = textView;
        this.b = conditionView;
        this.f12301c = textView2;
    }

    public static af a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static af b(@NonNull View view, @Nullable Object obj) {
        return (af) ViewDataBinding.bind(obj, view, R.layout.view_condition_change);
    }

    @NonNull
    public static af e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static af f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static af g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (af) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_condition_change, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static af h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (af) ViewDataBinding.inflateInternal(layoutInflater, R.layout.view_condition_change, null, false, obj);
    }

    @Nullable
    public GameCard c() {
        return this.f12303e;
    }

    @Nullable
    public e.l.q.b.b.a.c d() {
        return this.f12302d;
    }

    public abstract void i(@Nullable GameCard gameCard);

    public abstract void j(@Nullable e.l.q.b.b.a.c cVar);
}
