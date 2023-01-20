package com.vector.design.ui.nav;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.vector.R;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lcom/vector/design/ui/nav/MidLayout;", "Lcom/vector/design/ui/nav/BaseLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "params", "Landroid/widget/RelativeLayout$LayoutParams;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class MidLayout extends BaseLayout {
    @h
    public MidLayout(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public MidLayout(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MidLayout(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // com.vector.design.ui.nav.BaseLayout
    @d
    public RelativeLayout.LayoutParams j() {
        RelativeLayout.LayoutParams j2 = super.j();
        j2.width = -1;
        return j2;
    }

    @h
    public MidLayout(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setId(R.id.app_bar_mid);
    }
}
