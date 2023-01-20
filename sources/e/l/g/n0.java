package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.RecentPhoto;

/* loaded from: classes2.dex */
public final class n0 extends e.t.k.a.c.a<RecentPhoto> {
    public n0() {
        super(null, 1, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_view_photo;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: v */
    public void u(@k.e.a.d RecentPhoto recentPhoto, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(8, recentPhoto);
    }
}
