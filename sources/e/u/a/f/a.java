package e.u.a.f;

import android.content.res.Resources;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import com.huawei.hms.framework.common.EmuiUtil;
import com.xres.address_selector.R;
import h.i;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u0004\u0018\u00010\u0013H\u0086\u0010\u001a\f\u0010\u0014\u001a\u00020\u0001*\u00020\fH\u0007\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\u0001*\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0015\u0010\u000b\u001a\u00020\u0001*\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\"\u0015\u0010\u000f\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0004¨\u0006\u0015"}, d2 = {"accentColor", "", "Landroid/view/View;", "getAccentColor", "(Landroid/view/View;)I", "color", "", "getColor", "(Ljava/lang/String;)I", "colorValue", "getColorValue", "dp", "", "getDp", "(F)I", "primaryColor", EmuiUtil.GET_PRIMARY_COLOR, "activity", "Landroidx/fragment/app/FragmentActivity;", "Landroid/content/Context;", "dpValue", "address-selector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a {
    /* JADX WARN: Removed duplicated region for block: B:5:0x0009  */
    @k.e.a.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final androidx.fragment.app.FragmentActivity a(@k.e.a.e android.content.Context r2) {
        /*
        L0:
            boolean r0 = r2 instanceof androidx.fragment.app.FragmentActivity
            r1 = 0
            if (r0 == 0) goto L9
            r1 = r2
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            goto L1a
        L9:
            boolean r0 = r2 instanceof android.content.ContextWrapper
            if (r0 == 0) goto L10
            android.content.ContextWrapper r2 = (android.content.ContextWrapper) r2
            goto L11
        L10:
            r2 = r1
        L11:
            if (r2 != 0) goto L14
            goto L1a
        L14:
            android.content.Context r2 = r2.getBaseContext()
            if (r2 != 0) goto L0
        L1a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.u.a.f.a.a(android.content.Context):androidx.fragment.app.FragmentActivity");
    }

    @i(message = "推荐用顶级属性")
    public static final int b(float f2) {
        return (int) TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    public static final int c(@k.e.a.d View view) {
        return e.j.a.c.l.a.d(view, R.attr.colorAccent);
    }

    public static final int d(@k.e.a.d String str) {
        return Color.parseColor(str);
    }

    public static final int e(@k.e.a.d String str) {
        return Color.parseColor(str);
    }

    public static final int f(float f2) {
        return (int) TypedValue.applyDimension(1, f2, Resources.getSystem().getDisplayMetrics());
    }

    public static final int g(@k.e.a.d View view) {
        return e.j.a.c.l.a.d(view, R.attr.colorPrimary);
    }
}
