package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.BackProductDialog;

/* loaded from: classes2.dex */
public abstract class m3 extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final LinearLayout b;
    @NonNull

    /* renamed from: c */
    public final TextView f13103c;
    @NonNull

    /* renamed from: d */
    public final RadioButton f13104d;
    @NonNull

    /* renamed from: e */
    public final RadioButton f13105e;
    @NonNull

    /* renamed from: f */
    public final RadioButton f13106f;
    @NonNull

    /* renamed from: g */
    public final TextView f13107g;
    @NonNull

    /* renamed from: h */
    public final RadioButton f13108h;
    @NonNull

    /* renamed from: i */
    public final RadioGroup f13109i;
    @NonNull

    /* renamed from: j */
    public final LinearLayout f13110j;
    @NonNull

    /* renamed from: k */
    public final RadioGroup f13111k;
    @Bindable

    /* renamed from: l */
    public BackProductDialog f13112l;

    public m3(Object obj, View view, int i2, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, RadioButton radioButton, RadioButton radioButton2, RadioButton radioButton3, TextView textView2, RadioButton radioButton4, RadioGroup radioGroup, LinearLayout linearLayout3, RadioGroup radioGroup2) {
        super(obj, view, i2);
        this.a = linearLayout;
        this.b = linearLayout2;
        this.f13103c = textView;
        this.f13104d = radioButton;
        this.f13105e = radioButton2;
        this.f13106f = radioButton3;
        this.f13107g = textView2;
        this.f13108h = radioButton4;
        this.f13109i = radioGroup;
        this.f13110j = linearLayout3;
        this.f13111k = radioGroup2;
    }

    public static m3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static m3 b(@NonNull View view, @Nullable Object obj) {
        return (m3) ViewDataBinding.bind(obj, view, R.layout.dialog_back_goods);
    }

    @NonNull
    public static m3 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static m3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static m3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (m3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_back_goods, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static m3 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (m3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_back_goods, null, false, obj);
    }

    @Nullable
    public BackProductDialog c() {
        return this.f13112l;
    }

    public abstract void h(@Nullable BackProductDialog backProductDialog);
}
