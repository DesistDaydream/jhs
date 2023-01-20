package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.shop.ChooseCardActivity;
import com.jihuanshe.viewmodel.shop.ChooseCardViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class w extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final ListView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final EditText f13790c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f13791d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public ChooseCardActivity f13792e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public ChooseCardViewModel f13793f;

    public w(Object obj, View view, int i2, ConstraintLayout constraintLayout, ListView listView, EditText editText, LinearLayout linearLayout) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = listView;
        this.f13790c = editText;
        this.f13791d = linearLayout;
    }

    public static w a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w b(@NonNull View view, @Nullable Object obj) {
        return (w) ViewDataBinding.bind(obj, view, R.layout.activity_choose_card);
    }

    @NonNull
    public static w e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_choose_card, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_choose_card, null, false, obj);
    }

    @Nullable
    public ChooseCardActivity c() {
        return this.f13792e;
    }

    @Nullable
    public ChooseCardViewModel d() {
        return this.f13793f;
    }

    public abstract void i(@Nullable ChooseCardActivity chooseCardActivity);

    public abstract void j(@Nullable ChooseCardViewModel chooseCardViewModel);
}
