package e.l.g.c1;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.SearchUser;
import com.jihuanshe.ui.page.search.fragments.global.SearchUserFragment;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class b extends e.t.k.a.c.a<SearchUser> {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final SearchUserFragment f12023d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final e.t.r.a.a f12024e;

    public b(@d SearchUserFragment searchUserFragment) {
        super(null, 1, null);
        this.f12023d = searchUserFragment;
        this.f12024e = new e.t.r.a.a(0, 0, 3, null);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_search_user;
    }

    @d
    public final SearchUserFragment v() {
        return this.f12023d;
    }

    @d
    public final e.t.r.a.a w() {
        return this.f12024e;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: x */
    public void u(@d SearchUser searchUser, @d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(10, this);
        viewDataBinding.setVariable(8, searchUser);
    }
}
