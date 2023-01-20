package com.jihuanshe.base.ui.widget;

import android.view.LayoutInflater;
import android.widget.TextView;
import android.widget.Toast;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.jihuanshe.base.R;
import com.vector.util.Res;
import e.l.h.e.c;
import e.t.a;
import e.t.o.d;
import h.t2.u;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JI\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010'\u001a\u00020\u00042\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010(J\u0012\u0010#\u001a\u00020\u00012\b\b\u0002\u0010'\u001a\u00020\u0004H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\bR\u0010\u0010#\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/jihuanshe/base/ui/widget/ToastDialog;", "Landroid/widget/Toast;", "()V", "bgColor", "", "getBgColor", "()I", "setBgColor", "(I)V", "binding", "Lcom/jihuanshe/base/databinding/LayoutToastBinding;", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "gravity", "getGravity", "()Ljava/lang/Integer;", "setGravity", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "textColor", "getTextColor", "setTextColor", "textSize", "getTextSize", "setTextSize", "toast", TTLogUtil.TAG_EVENT_SHOW, "", "text", "duration", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;ILjava/lang/Integer;)V", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ToastDialog extends Toast {
    @e

    /* renamed from: f */
    private static Integer f3890f;
    @e

    /* renamed from: g */
    private static Toast f3891g;
    @e

    /* renamed from: h */
    private static c f3892h;
    @d
    public static final ToastDialog a = new ToastDialog();
    private static int b = Res.k(R.color.vector_toast_bg);

    /* renamed from: c */
    private static int f3887c = -1;

    /* renamed from: d */
    private static int f3888d = d.a.c(e.t.o.d.a, null, 1, null).d(12);
    @k.e.a.d

    /* renamed from: e */
    private static String f3889e = "";
    @k.e.a.d

    /* renamed from: i */
    private static final w f3893i = z.c(ToastDialog$layoutInflater$2.INSTANCE);

    private ToastDialog() {
        super(a.b());
    }

    private final LayoutInflater d() {
        return (LayoutInflater) f3893i.getValue();
    }

    public static /* synthetic */ void m(ToastDialog toastDialog, String str, Integer num, Integer num2, Integer num3, int i2, Integer num4, int i3, Object obj) {
        int i4 = (i3 & 16) != 0 ? 0 : i2;
        if ((i3 & 32) != 0) {
            num4 = null;
        }
        toastDialog.l(str, num, num2, num3, i4, num4);
    }

    private final Toast n(int i2) {
        if (f3891g == null) {
            f3891g = new Toast(a.b());
            c d2 = c.d(d());
            f3892h = d2;
            d2.h(this);
            f3891g.setView(f3892h.getRoot());
        }
        c cVar = f3892h;
        TextView textView = cVar == null ? null : cVar.a;
        if (textView != null) {
            textView.setText(f3889e);
        }
        Toast toast = f3891g;
        if (toast != null) {
            toast.setDuration(i2);
        }
        Integer num = f3890f;
        if (num != null) {
            int intValue = num.intValue();
            Toast toast2 = f3891g;
            if (toast2 != null) {
                toast2.setGravity(intValue, 0, e.t.o.d.a.a(a.b()).d(120));
            }
        }
        return f3891g;
    }

    public static /* synthetic */ Toast o(ToastDialog toastDialog, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 0;
        }
        return toastDialog.n(i2);
    }

    public final int a() {
        return b;
    }

    @k.e.a.d
    public final String b() {
        return f3889e;
    }

    @e
    public final Integer c() {
        return f3890f;
    }

    public final int e() {
        return f3887c;
    }

    public final int f() {
        return f3888d;
    }

    public final void g(int i2) {
        b = i2;
    }

    public final void h(@k.e.a.d String str) {
        f3889e = str;
    }

    public final void i(@e Integer num) {
        f3890f = num;
    }

    public final void j(int i2) {
        f3887c = i2;
    }

    public final void k(int i2) {
        f3888d = i2;
    }

    public final void l(@e String str, @e Integer num, @e Integer num2, @e Integer num3, int i2, @e Integer num4) {
        if (str == null || u.U1(str)) {
            return;
        }
        f3889e = str;
        if (num != null) {
            g(num.intValue());
        }
        if (num2 != null) {
            j(num2.intValue());
        }
        if (num3 != null) {
            k(num3.intValue());
        }
        if (num4 != null) {
            i(Integer.valueOf(num4.intValue()));
        }
        n(i2).show();
    }
}
