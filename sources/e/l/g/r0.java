package e.l.g;

import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.ui.page.detail.ReviewListActivity;

/* loaded from: classes2.dex */
public final class r0 extends e.t.k.a.c.a<ReviewListInfo> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final ReviewListActivity f12047d;

    /* renamed from: e  reason: collision with root package name */
    private final MovementMethod f12048e;
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private final e.t.r.a.a f12049f;

    public r0(@k.e.a.d ReviewListActivity reviewListActivity) {
        super(null, 1, null);
        this.f12047d = reviewListActivity;
        this.f12048e = LinkMovementMethod.getInstance();
        this.f12049f = new e.t.r.a.a(0, 0, 3, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_review_list;
    }

    @k.e.a.d
    public final ReviewListActivity v() {
        return this.f12047d;
    }

    public final MovementMethod w() {
        return this.f12048e;
    }

    @k.e.a.d
    public final e.t.r.a.a x() {
        return this.f12049f;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: y */
    public void u(@k.e.a.d ReviewListInfo reviewListInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(10, this.f12047d);
        viewDataBinding.setVariable(17, this.f12049f);
        viewDataBinding.setVariable(8, reviewListInfo);
    }
}
