package com.jihuanshe.base.ext;

import android.app.Activity;
import com.jihuanshe.base.R;
import com.qiniu.android.collect.ReportItem;
import com.vector.design.ui.nav.AppBar;
import h.k2.u.a;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u001a.\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¨\u0006\u000b"}, d2 = {"addBackBlackIcon", "", "Lcom/vector/design/ui/nav/AppBar;", "activity", "Landroid/app/Activity;", "back", "", ReportItem.LogTypeBlock, "Lkotlin/Function0;", "", "addBackWhiteIcon", "lib-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class AppBarKt {
    public static final void a(@d AppBar appBar, @d Activity activity, int i2, @e a<Boolean> aVar) {
        appBar.getStart().d(new AppBarKt$addBackBlackIcon$1(i2, aVar, activity));
    }

    public static /* synthetic */ void b(AppBar appBar, Activity activity, int i2, a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = R.drawable.bg_back_icon;
        }
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        a(appBar, activity, i2, aVar);
    }

    public static final void c(@d AppBar appBar, @d Activity activity, int i2, @e a<Boolean> aVar) {
        appBar.getStart().d(new AppBarKt$addBackWhiteIcon$1(i2, aVar, activity));
    }

    public static /* synthetic */ void d(AppBar appBar, Activity activity, int i2, a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = R.drawable.bg_back_icon_white;
        }
        if ((i3 & 4) != 0) {
            aVar = null;
        }
        c(appBar, activity, i2, aVar);
    }
}
