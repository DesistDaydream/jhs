package com.vector.view.scrollable;

import android.content.Context;
import com.vector.view.swipe.footer.BaseFooter;
import com.vector.view.swipe.footer.DefaultFooter;
import h.k2.u.a;
import h.k2.u.l;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/vector/view/swipe/footer/BaseFooter;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupListView$loadMoreFooter$2 extends Lambda implements a<BaseFooter> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupListView$loadMoreFooter$2(Context context) {
        super(0);
        this.$context = context;
    }

    @Override // h.k2.u.a
    @d
    public final BaseFooter invoke() {
        l<Context, BaseFooter> b = e.t.a.c().b();
        BaseFooter invoke = b == null ? null : b.invoke(this.$context);
        return invoke == null ? new DefaultFooter(this.$context) : invoke;
    }
}
