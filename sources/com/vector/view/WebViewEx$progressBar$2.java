package com.vector.view;

import android.content.Context;
import android.widget.ProgressBar;
import e.t.u.p;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/widget/ProgressBar;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class WebViewEx$progressBar$2 extends Lambda implements a<ProgressBar> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewEx$progressBar$2(Context context) {
        super(0);
        this.$context = context;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final ProgressBar invoke() {
        ProgressBar progressBar = new ProgressBar(this.$context, null, 16842872);
        progressBar.setLayoutParams(p.p(-1, e.t.o.d.a.a(this.$context).d(2)));
        return progressBar;
    }
}
