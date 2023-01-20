package e.l.k;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.CardCommentsDialog;
import com.jihuanshe.ui.widget.StarRatingBar;

/* loaded from: classes2.dex */
public abstract class s3 extends ViewDataBinding {
    @NonNull
    public final ConstraintLayout a;
    @NonNull
    public final EditText b;
    @NonNull

    /* renamed from: c */
    public final StarRatingBar f13546c;
    @NonNull

    /* renamed from: d */
    public final TextView f13547d;
    @NonNull

    /* renamed from: e */
    public final TextView f13548e;
    @Bindable

    /* renamed from: f */
    public CardCommentsDialog f13549f;

    public s3(Object obj, View view, int i2, ConstraintLayout constraintLayout, EditText editText, StarRatingBar starRatingBar, TextView textView, TextView textView2) {
        super(obj, view, i2);
        this.a = constraintLayout;
        this.b = editText;
        this.f13546c = starRatingBar;
        this.f13547d = textView;
        this.f13548e = textView2;
    }

    public static s3 a(@NonNull View view) {
        return b(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static s3 b(@NonNull View view, @Nullable Object obj) {
        return (s3) ViewDataBinding.bind(obj, view, R.layout.dialog_card_comments);
    }

    @NonNull
    public static s3 d(@NonNull LayoutInflater layoutInflater) {
        return g(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static s3 e(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return f(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static s3 f(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (s3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_card_comments, viewGroup, z, obj);
    }

    @NonNull
    @Deprecated
    public static s3 g(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (s3) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_card_comments, null, false, obj);
    }

    @Nullable
    public CardCommentsDialog c() {
        return this.f13549f;
    }

    public abstract void h(@Nullable CardCommentsDialog cardCommentsDialog);
}
