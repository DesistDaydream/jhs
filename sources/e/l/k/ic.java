package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.adapter.ReplyMeAdapter;
import com.jihuanshe.model.InteractData;
import com.vector.network.image.NImageView;

/* loaded from: classes2.dex */
public abstract class ic extends ViewDataBinding {
    @NonNull
    public final NImageView a;
    @NonNull
    public final TextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final TextView f12891c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final FrameLayout f12892d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final View f12893e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final View f12894f;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    public final TextView f12895g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public ReplyMeAdapter f12896h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public InteractData f12897i;
    @Bindable

    /* renamed from: j  reason: collision with root package name */
    public Integer f12898j;

    public ic(Object obj, View view, int i2, NImageView nImageView, TextView textView, TextView textView2, FrameLayout frameLayout, View view2, View view3, TextView textView3) {
        super(obj, view, i2);
        this.a = nImageView;
        this.b = textView;
        this.f12891c = textView2;
        this.f12892d = frameLayout;
        this.f12893e = view2;
        this.f12894f = view3;
        this.f12895g = textView3;
    }

    public static ic a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ic b(@NonNull View view, @Nullable Object obj) {
        return (ic) ViewDataBinding.bind(obj, view, R.layout.item_reply_me);
    }

    @NonNull
    public static ic f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ic g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ic h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (ic) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_reply_me, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static ic i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (ic) ViewDataBinding.inflateInternal(layoutInflater, R.layout.item_reply_me, null, false, obj);
    }

    @Nullable
    public ReplyMeAdapter c() {
        return this.f12896h;
    }

    @Nullable
    public InteractData d() {
        return this.f12897i;
    }

    @Nullable
    public Integer e() {
        return this.f12898j;
    }

    public abstract void j(@Nullable ReplyMeAdapter replyMeAdapter);

    public abstract void k(@Nullable InteractData interactData);

    public abstract void l(@Nullable Integer num);
}
