package com.vector.view;

import android.widget.PopupWindow;
import h.k2.u.a;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Landroid/widget/PopupWindow;"}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SideBar$popupWindow$2 extends Lambda implements a<PopupWindow> {
    public final /* synthetic */ SideBar this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SideBar$popupWindow$2(SideBar sideBar) {
        super(0);
        this.this$0 = sideBar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final PopupWindow invoke() {
        e.t.j.d popupViewBinding;
        popupViewBinding = this.this$0.getPopupViewBinding();
        return new PopupWindow(popupViewBinding.getRoot(), -2, -2);
    }
}
