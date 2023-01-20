package e.l.h.j.b;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import com.jihuanshe.base.ui.activity.GlobalToastActivityCreator;
import com.jihuanshe.base.ui.widget.ToastDialog;
import com.vector.util.Res;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001aS\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000e\u001aQ\u0010\u0005\u001a\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000f\u001aQ\u0010\u0005\u001a\u00020\u0001*\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0011\u001aS\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0012\u001aS\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0013¨\u0006\u0014"}, d2 = {"showGlobalDialog", "", "", "text", "", "showToast", "Landroid/content/Context;", "textId", "", "bgColor", "textColor", "textSize", "duration", "gravity", "(Landroid/content/Context;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;)V", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;)V", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;)V", "(Ljava/lang/Object;ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;)V", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;)V", "lib-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class e {
    public static final void a(@k.e.a.d Object obj, @k.e.a.e String str) {
        Intent newIntent = GlobalToastActivityCreator.newIntent(e.t.a.b(), str);
        newIntent.setFlags(268435456);
        e.t.a.b().startActivity(newIntent);
    }

    public static final void b(@k.e.a.d Context context, @StringRes int i2, @k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e Integer num3, int i3, @k.e.a.e Integer num4) {
        ToastDialog.a.l(Res.w(Res.a, i2, null, 2, null), num, num2, num3, i3, num4);
    }

    public static final void c(@k.e.a.d Context context, @k.e.a.d String str, @k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e Integer num3, int i2, @k.e.a.e Integer num4) {
        ToastDialog.a.l(str, num, num2, num3, i2, num4);
    }

    public static final void d(@k.e.a.d Fragment fragment, @k.e.a.d String str, @k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e Integer num3, int i2, @k.e.a.e Integer num4) {
        h(e.t.a.b(), str, num, num2, num3, i2, null, 32, null);
    }

    public static final void e(@k.e.a.d Object obj, @StringRes int i2, @k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e Integer num3, int i3, @k.e.a.e Integer num4) {
        ToastDialog.a.l(Res.w(Res.a, i2, null, 2, null), num, num2, num3, i3, num4);
    }

    public static final void f(@k.e.a.d Object obj, @k.e.a.e String str, @k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e Integer num3, int i2, @k.e.a.e Integer num4) {
        ToastDialog.a.l(str, num, num2, num3, i2, num4);
    }

    public static /* synthetic */ void h(Context context, String str, Integer num, Integer num2, Integer num3, int i2, Integer num4, int i3, Object obj) {
        c(context, str, (i3 & 2) != 0 ? null : num, (i3 & 4) != 0 ? null : num2, (i3 & 8) == 0 ? num3 : null, (i3 & 16) != 0 ? 1 : i2, (i3 & 32) != 0 ? 80 : num4);
    }

    public static /* synthetic */ void j(Object obj, int i2, Integer num, Integer num2, Integer num3, int i3, Integer num4, int i4, Object obj2) {
        e(obj, i2, (i4 & 2) != 0 ? null : num, (i4 & 4) != 0 ? null : num2, (i4 & 8) == 0 ? num3 : null, (i4 & 16) != 0 ? 1 : i3, (i4 & 32) != 0 ? 80 : num4);
    }
}
