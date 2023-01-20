package com.jihuanshe.ui.page.shop;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.model.Category;
import com.jihuanshe.viewmodel.shop.AddCardViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import java.util.Objects;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardActivity$onKindItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ AddCardActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCardActivity$onKindItemClick$1(AddCardActivity addCardActivity) {
        super(2);
        this.this$0 = addCardActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        int intValue;
        List<Category> value = ((AddCardViewModel) this.this$0.L()).r0().getValue();
        Category category = value == null ? null : (Category) CollectionsKt___CollectionsKt.J2(value, i2);
        if (category == null) {
            return;
        }
        List<Object> value2 = ((AddCardViewModel) this.this$0.L()).s0().getValue();
        Integer valueOf = value2 != null ? Integer.valueOf(value2.indexOf(category)) : null;
        if (valueOf == null || (intValue = valueOf.intValue()) == -1) {
            return;
        }
        this.this$0.Z().scrollToPosition(intValue);
        RecyclerView.LayoutManager layoutManager = this.this$0.Z().getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        ((LinearLayoutManager) layoutManager).scrollToPositionWithOffset(intValue, 0);
        this.this$0.X().x(i2);
    }
}
