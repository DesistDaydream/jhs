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
import com.jihuanshe.adapter.BlackListAdapter;
import com.jihuanshe.model.BanUser;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class e9 extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12568c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final TextView f12569d;
    @Bindable

    /* renamed from: e  reason: collision with root package name */
    public BlackListAdapter f12570e;
    @Bindable

    /* renamed from: f  reason: collision with root package name */
    public BanUser f12571f;

    public e9(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, TextView textView3) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f12568c = textView2;
        this.f12569d = textView3;
    }

    public static e9 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static e9 b(@NonNull View view, @Nullable Object obj) {
        return (e9) ViewDataBinding.bind(obj, view, R.layout.item_black_list);
    }

    @NonNull
    public static e9 e(@NonNull LayoutInflater layoutInflater) {
        return h(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static e9 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return g(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static e9 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (e9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_black_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static e9 h(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (e9) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_black_list, null, false, obj);
    }

    @Nullable
    public BanUser c() {
        return this.f12571f;
    }

    @Nullable
    public BlackListAdapter d() {
        return this.f12570e;
    }

    public abstract void i(@Nullable BanUser banUser);

    public abstract void j(@Nullable BlackListAdapter blackListAdapter);
}
