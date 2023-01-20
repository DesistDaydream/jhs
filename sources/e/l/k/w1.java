package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.detail.ReplyListActivity;
import com.jihuanshe.ui.widget.FilterTextView;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import com.vector.view.scrollable.ListView;

/* loaded from: classes2.dex */
public abstract class w1 extends ViewDataBinding {
    @NonNull
    public final EditText a;
    @NonNull
    public final FilterTextView b;
    @NonNull

    /* renamed from: c  reason: collision with root package name */
    public final View f13797c;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    public final ListView f13798d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f13799e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f13800f;
    @Bindable

    /* renamed from: g  reason: collision with root package name */
    public ReplyListActivity f13801g;
    @Bindable

    /* renamed from: h  reason: collision with root package name */
    public ReplyListViewModel f13802h;
    @Bindable

    /* renamed from: i  reason: collision with root package name */
    public ReviewListViewModel f13803i;

    public w1(Object obj, View view, int i2, EditText editText, FilterTextView filterTextView, View view2, ListView listView, LinearLayout linearLayout, LinearLayout linearLayout2) {
        super(obj, view, i2);
        this.a = editText;
        this.b = filterTextView;
        this.f13797c = view2;
        this.f13798d = listView;
        this.f13799e = linearLayout;
        this.f13800f = linearLayout2;
    }

    public static w1 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static w1 b(@NonNull View view, @Nullable Object obj) {
        return (w1) ViewDataBinding.bind(obj, view, R.layout.activity_reply_list);
    }

    @NonNull
    public static w1 f(@NonNull LayoutInflater layoutInflater) {
        return i(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static w1 g(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return h(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static w1 h(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (w1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_reply_list, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static w1 i(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (w1) ViewDataBinding.inflateInternal(layoutInflater, R.layout.activity_reply_list, null, false, obj);
    }

    @Nullable
    public ReplyListActivity c() {
        return this.f13801g;
    }

    @Nullable
    public ReviewListViewModel d() {
        return this.f13803i;
    }

    @Nullable
    public ReplyListViewModel e() {
        return this.f13802h;
    }

    public abstract void j(@Nullable ReplyListActivity replyListActivity);

    public abstract void k(@Nullable ReviewListViewModel reviewListViewModel);

    public abstract void l(@Nullable ReplyListViewModel replyListViewModel);
}
