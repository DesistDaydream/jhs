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
import com.jihuanshe.model.EtiquetteAnswer;

/* loaded from: classes2.dex */
public abstract class s8 extends ViewDataBinding {
    @NonNull
    public final LinearLayout a;
    @NonNull
    public final TextView b;
    @Bindable

    /* renamed from: c  reason: collision with root package name */
    public e.l.q.c.s0.a f13559c;
    @Bindable

    /* renamed from: d  reason: collision with root package name */
    public EtiquetteAnswer f13560d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public String f13561e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public Boolean f13562f;

    public s8(Object obj, View view, int i2, LinearLayout linearLayout, TextView textView) {
        super(obj, view, i2);
        this.a = linearLayout;
        this.b = textView;
    }

    public static s8 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s8 b(@NonNull View view, @Nullable Object obj) {
        return (s8) ViewDataBinding.bind(obj, view, R.layout.item_answer);
    }

    @NonNull
    public static s8 g(@NonNull LayoutInflater layoutInflater) {
        return j(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s8 h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return i(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s8 i(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_answer, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s8 j(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s8) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_answer, null, false, obj);
    }

    @Nullable
    public e.l.q.c.s0.a c() {
        return this.f13559c;
    }

    @Nullable
    public String d() {
        return this.f13561e;
    }

    @Nullable
    public EtiquetteAnswer e() {
        return this.f13560d;
    }

    @Nullable
    public Boolean f() {
        return this.f13562f;
    }

    public abstract void k(@Nullable e.l.q.c.s0.a aVar);

    public abstract void l(@Nullable String str);

    public abstract void m(@Nullable EtiquetteAnswer etiquetteAnswer);

    public abstract void n(@Nullable Boolean bool);
}
