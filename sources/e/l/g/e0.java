package e.l.g;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.MatchResult;

/* loaded from: classes2.dex */
public final class e0 extends e.t.k.a.c.a<MatchResult> {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final e.t.r.a.a f12026d;

    public e0() {
        super(null, 1, null);
        this.f12026d = new e.t.r.a.a(0, 0, 3, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_match;
    }

    @k.e.a.d
    public final e.t.r.a.a v() {
        return this.f12026d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: w */
    public void u(@k.e.a.d MatchResult matchResult, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, matchResult);
    }
}
