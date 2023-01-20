package com.vector.design.ui.decor;

import android.content.Context;
import android.util.AttributeSet;
import com.vector.R;
import com.vector.util.Res;
import e.t.i.a;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/vector/design/ui/decor/ErrorViewImpl;", "Lcom/vector/design/ui/decor/ErrorViewEx;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "layoutId", "getLayoutId", "()I", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ErrorViewImpl extends ErrorViewEx {
    @h
    public ErrorViewImpl(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public ErrorViewImpl(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ErrorViewImpl(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // com.vector.design.ui.decor.ErrorViewEx
    public int getLayoutId() {
        return R.layout.layout_net_error;
    }

    @h
    public ErrorViewImpl(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a a = e.t.a.a();
        if (a.c() != 0) {
            setBackgroundResource(a.c());
        } else if (a.b() != 0) {
            setBackgroundColor(Res.k(a.b()));
        }
        b(this);
    }
}
