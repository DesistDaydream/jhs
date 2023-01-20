package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.shop.SearchBankActivity;

/* loaded from: classes2.dex */
public abstract class a2 extends ViewDataBinding {
    @NonNull
    public final EditText a;
    @NonNull
    public final EditText b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12246c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final RecyclerView f12247d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final TextView f12248e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final TextView f12249f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public SearchBankActivity f12250g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public e.l.s.n.b f12251h;

    public a2(Object obj, View view, int i2, EditText editText, EditText editText2, TextView textView, RecyclerView recyclerView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = editText;
        this.b = editText2;
        this.f12246c = textView;
        this.f12247d = recyclerView;
        this.f12248e = textView2;
        this.f12249f = textView3;
    }

    public static a2 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static a2 b(@NonNull View view, @Nullable Object obj) {
        return (a2) ViewDataBinding.bind(obj, view, R.layout.activity_search_bank);
    }

    @NonNull
    public static a2 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static a2 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static a2 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (a2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_search_bank, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static a2 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (a2) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_search_bank, null, false, obj);
    }

    @Nullable
    public SearchBankActivity c() {
        return this.f12250g;
    }

    @Nullable
    public e.l.s.n.b d() {
        return this.f12251h;
    }

    public abstract void i(@Nullable SearchBankActivity searchBankActivity);

    public abstract void j(@Nullable e.l.s.n.b bVar);
}
