package com.jihuanshe.base.ui.activity;

import androidx.core.view.ViewCompat;
import androidx.databinding.ViewDataBinding;
import e.l.h.l.b;
import e.t.j.h.g;
import e.t.l.b0;
import f.a.a.a;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u000e\u001a\u00020\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/jihuanshe/base/ui/activity/GlobalToastActivity;", "Lcom/jihuanshe/base/ui/activity/TransparentActivity;", "Lcom/jihuanshe/base/viewmodel/BaseViewModel;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "onClick", "Lcom/vector/databinding/onBind/OnClickBinding;", "getOnClick", "()Lcom/vector/databinding/onBind/OnClickBinding;", "createBinding", "Landroidx/databinding/ViewDataBinding;", "flowOfSetup", "", "showEnterAnim", "showLeftAnim", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@Creator
/* loaded from: classes2.dex */
public final class GlobalToastActivity extends TransparentActivity<b> {
    @a
    @e
    private String content;
    @d
    private final g p = e.t.j.h.d.a.a(new GlobalToastActivity$onClick$1(this));

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void H() {
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void I() {
    }

    @e
    public final String M() {
        return this.content;
    }

    @d
    public final g N() {
        return this.p;
    }

    public final void O(@e String str) {
        this.content = str;
    }

    @Override // com.jihuanshe.base.ui.activity.TransparentActivity, com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        super.d();
        b0.k(getWindow(), ViewCompat.MEASURED_STATE_MASK);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        e.l.h.e.a d2 = e.l.h.e.a.d(getLayoutInflater());
        d2.h(this);
        return d2;
    }
}
