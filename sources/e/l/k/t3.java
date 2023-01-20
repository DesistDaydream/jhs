package e.l.k;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.ui.dialog.CardCommentsDialog;
import com.jihuanshe.ui.widget.StarRatingBar;

/* loaded from: classes2.dex */
public class t3 extends s3 {
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static final ViewDataBinding.IncludedLayouts f13596k = null;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static final SparseIntArray f13597l;
    @NonNull

    /* renamed from: g  reason: collision with root package name */
    private final ConstraintLayout f13598g;
    @NonNull

    /* renamed from: h  reason: collision with root package name */
    private final ImageView f13599h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final TextView f13600i;

    /* renamed from: j  reason: collision with root package name */
    private long f13601j;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f13597l = sparseIntArray;
        sparseIntArray.put(R.id.tv_title, 4);
        sparseIntArray.put(R.id.ratingBar, 5);
        sparseIntArray.put(R.id.cl, 6);
        sparseIntArray.put(R.id.editText, 7);
    }

    public t3(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        this(dataBindingComponent, view, ViewDataBinding.mapBindings(dataBindingComponent, view, 8, f13596k, f13597l));
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j2;
        e.t.j.h.g gVar;
        String str;
        e.t.j.h.g gVar2;
        Resources resources;
        int i2;
        synchronized (this) {
            j2 = this.f13601j;
            this.f13601j = 0L;
        }
        CardCommentsDialog cardCommentsDialog = this.f13549f;
        boolean z = false;
        e.t.j.h.g gVar3 = null;
        int i3 = ((j2 & 3) > 0L ? 1 : ((j2 & 3) == 0L ? 0 : -1));
        if (i3 != 0) {
            if (cardCommentsDialog != null) {
                gVar3 = cardCommentsDialog.getOnClickSubmit();
                e.t.j.h.g onClickClose = cardCommentsDialog.getOnClickClose();
                z = cardCommentsDialog.H();
                gVar2 = onClickClose;
            } else {
                gVar2 = null;
            }
            if (i3 != 0) {
                j2 |= z ? 8L : 4L;
            }
            if (z) {
                resources = this.f13547d.getResources();
                i2 = R.string.card_comments_score;
            } else {
                resources = this.f13547d.getResources();
                i2 = R.string.pack_comments_score;
            }
            str = resources.getString(i2);
            e.t.j.h.g gVar4 = gVar3;
            gVar3 = gVar2;
            gVar = gVar4;
        } else {
            gVar = null;
            str = null;
        }
        if ((j2 & 3) != 0) {
            e.t.j.g.e0.F(this.f13599h, gVar3);
            e.t.j.g.e0.F(this.f13600i, gVar);
            TextViewBindingAdapter.setText(this.f13547d, str);
        }
    }

    @Override // e.l.k.s3
    public void h(@Nullable CardCommentsDialog cardCommentsDialog) {
        this.f13549f = cardCommentsDialog;
        synchronized (this) {
            this.f13601j |= 1;
        }
        notifyPropertyChanged(10);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f13601j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13601j = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i2, Object obj, int i3) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, @Nullable Object obj) {
        if (10 == i2) {
            h((CardCommentsDialog) obj);
            return true;
        }
        return false;
    }

    private t3(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 0, (ConstraintLayout) objArr[6], (EditText) objArr[7], (StarRatingBar) objArr[5], (TextView) objArr[2], (TextView) objArr[4]);
        this.f13601j = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.f13598g = constraintLayout;
        constraintLayout.setTag(null);
        ImageView imageView = (ImageView) objArr[1];
        this.f13599h = imageView;
        imageView.setTag(null);
        TextView textView = (TextView) objArr[3];
        this.f13600i = textView;
        textView.setTag(null);
        this.f13547d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
