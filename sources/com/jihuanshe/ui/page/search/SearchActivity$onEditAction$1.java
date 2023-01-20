package com.jihuanshe.ui.page.search;

import android.widget.EditText;
import android.widget.TextView;
import e.l.s.m.c;
import e.t.u.o;
import h.k2.u.p;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class SearchActivity$onEditAction$1 extends Lambda implements p<TextView, Integer, Boolean> {
    public final /* synthetic */ SearchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchActivity$onEditAction$1(SearchActivity searchActivity) {
        super(2);
        this.this$0 = searchActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num) {
        return Boolean.valueOf(invoke(textView, num.intValue()));
    }

    public final boolean invoke(@d TextView textView, int i2) {
        EditText i0;
        EditText i02;
        if (i2 == 3) {
            i0 = this.this$0.i0();
            String obj = i0.getText().toString();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj2 = StringsKt__StringsKt.B5(obj).toString();
            if (obj2.length() > 0) {
                i02 = this.this$0.i0();
                o.b(i02, true);
                this.this$0.n0(false);
                ((c) this.this$0.L()).p0().setValue(Boolean.FALSE);
                ((c) this.this$0.L()).s0().setValue(obj2);
            }
        }
        return true;
    }
}
