package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.User;

/* loaded from: classes2.dex */
public final class w extends e.t.k.a.c.a<User> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final e.t.r.a.a f12058d;

    public w() {
        super(null, 1, null);
        this.f12058d = new e.t.r.a.a(0, 0, 3, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_follow;
    }

    @k.e.a.d
    public final e.t.r.a.a v() {
        return this.f12058d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d User user, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(10, this);
        viewDataBinding.setVariable(8, user);
    }
}
