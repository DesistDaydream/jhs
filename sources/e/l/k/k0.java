package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.user.edit.EditPhoneNumberActivity;
import com.jihuanshe.ui.widget.VerifyView;
import com.jihuanshe.viewmodel.user.edit.EditPhoneNumberViewModel;

/* loaded from: classes2.dex */
public abstract class k0 extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final ImageView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final EditText f12966c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12967d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12968e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12969f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final ImageView f12970g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    public final TextView f12971h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    public final TextView f12972i;
    @NonNull

    /* renamed from: j  reason: collision with root package name */
    public final TextView f12973j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public final VerifyView f12974k;
    @Bindable

    /* renamed from: l  reason: collision with root package name */
    public EditPhoneNumberActivity f12975l;
    @Bindable

    /* renamed from: m  reason: collision with root package name */
    public EditPhoneNumberViewModel f12976m;

    public k0(Object obj, View view, int i2, LinearLayout linearLayout, ImageView imageView, EditText editText, TextView textView, TextView textView2, TextView textView3, ImageView imageView2, TextView textView4, TextView textView5, TextView textView6, VerifyView verifyView) {
        super(obj, view, i2);
        this.a = linearLayout;
        this.b = imageView;
        this.f12966c = editText;
        this.f12967d = textView;
        this.f12968e = textView2;
        this.f12969f = textView3;
        this.f12970g = imageView2;
        this.f12971h = textView4;
        this.f12972i = textView5;
        this.f12973j = textView6;
        this.f12974k = verifyView;
    }

    public static k0 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static k0 b(@NonNull View view, @Nullable Object obj) {
        return (k0) ViewDataBinding.bind(obj, view, R.layout.activity_edit_phone_number);
    }

    @NonNull
    public static k0 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static k0 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static k0 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (k0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_edit_phone_number, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static k0 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (k0) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_edit_phone_number, null, false, obj);
    }

    @Nullable
    public EditPhoneNumberActivity c() {
        return this.f12975l;
    }

    @Nullable
    public EditPhoneNumberViewModel d() {
        return this.f12976m;
    }

    public abstract void i(@Nullable EditPhoneNumberActivity editPhoneNumberActivity);

    public abstract void j(@Nullable EditPhoneNumberViewModel editPhoneNumberViewModel);
}
