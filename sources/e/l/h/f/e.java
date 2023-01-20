package e.l.h.f;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.u.l;
import h.t1;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010!\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\n\u001a\u001a\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003\u001a;\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u001a?\u0010\f\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e¢\u0006\u0002\u0010\u000f\u001a-\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007\u001a-\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u0002\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\n\u001a-\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0017\u0010\u0004\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\b\u0007H\u0002\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0002\u001a+\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0002¢\u0006\u0002\u0010\u0014\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a/\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u00032\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u001a\u001ad\u0010\u001b\u001a\u00020\u0001*\u00020\u00012\b\b\u0001\u0010\u001c\u001a\u00020\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u00032\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00030#\u001a\"\u0010$\u001a\u00020\u0001*\u00020\u00012\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003¨\u0006%"}, d2 = {"background", "Landroid/text/SpannableStringBuilder;", "color", "", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", MessageKey.MSG_ACCEPT_TIME_START, MessageKey.MSG_ACCEPT_TIME_END, "(Landroid/text/SpannableStringBuilder;IILjava/lang/Integer;)Landroid/text/SpannableStringBuilder;", "bold", "click", "clickAction", "Lkotlin/Function0;", "(Landroid/text/SpannableStringBuilder;ILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)Landroid/text/SpannableStringBuilder;", "inSpans", "span", "", "index", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Object;ILjava/lang/Integer;)Landroid/text/SpannableStringBuilder;", "text", "", "insertDraw", "draw", "blank", "(Landroid/text/SpannableStringBuilder;Ljava/lang/Integer;ILjava/lang/Integer;)Landroid/text/SpannableStringBuilder;", "roundBackground", "bgColor", "textColor", "textSize", "radius", "leftMargin", "rightMargin", "padding", "", "size", "lib-base_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class e {
    @k.e.a.d
    public static final SpannableStringBuilder a(@k.e.a.d SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, int i3, @k.e.a.e Integer num) {
        return l(spannableStringBuilder, new BackgroundColorSpan(i2), i3, num);
    }

    @k.e.a.d
    public static final SpannableStringBuilder b(@k.e.a.d SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @k.e.a.d l<? super SpannableStringBuilder, t1> lVar) {
        return m(spannableStringBuilder, new BackgroundColorSpan(i2), lVar);
    }

    public static /* synthetic */ SpannableStringBuilder c(SpannableStringBuilder spannableStringBuilder, int i2, int i3, Integer num, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            num = null;
        }
        return a(spannableStringBuilder, i2, i3, num);
    }

    @k.e.a.d
    public static final SpannableStringBuilder d(@k.e.a.d SpannableStringBuilder spannableStringBuilder, int i2, int i3) {
        return l(spannableStringBuilder, new StyleSpan(1), i2, Integer.valueOf(i3));
    }

    @k.e.a.d
    public static final SpannableStringBuilder e(@k.e.a.d SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.d h.k2.u.a<t1> aVar) {
        return l(spannableStringBuilder, new b(i2, aVar), num == null ? 0 : num.intValue(), Integer.valueOf(num2 == null ? spannableStringBuilder.length() : num2.intValue()));
    }

    @k.e.a.d
    public static final SpannableStringBuilder f(@k.e.a.d SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @k.e.a.d h.k2.u.a<t1> aVar, @k.e.a.d l<? super SpannableStringBuilder, t1> lVar) {
        return m(spannableStringBuilder, new b(i2, aVar), lVar);
    }

    public static /* synthetic */ SpannableStringBuilder g(SpannableStringBuilder spannableStringBuilder, int i2, Integer num, Integer num2, h.k2.u.a aVar, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            num = null;
        }
        if ((i3 & 4) != 0) {
            num2 = null;
        }
        return e(spannableStringBuilder, i2, num, num2, aVar);
    }

    @k.e.a.d
    public static final SpannableStringBuilder h(@k.e.a.d SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, int i3, @k.e.a.e Integer num) {
        return l(spannableStringBuilder, new ForegroundColorSpan(i2), i3, num);
    }

    @k.e.a.d
    public static final SpannableStringBuilder i(@k.e.a.d SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @k.e.a.d l<? super SpannableStringBuilder, t1> lVar) {
        return m(spannableStringBuilder, new ForegroundColorSpan(i2), lVar);
    }

    public static /* synthetic */ SpannableStringBuilder j(SpannableStringBuilder spannableStringBuilder, int i2, int i3, Integer num, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            num = null;
        }
        return h(spannableStringBuilder, i2, i3, num);
    }

    private static final SpannableStringBuilder k(SpannableStringBuilder spannableStringBuilder, Object obj, int i2) {
        spannableStringBuilder.insert(i2, "x");
        spannableStringBuilder.setSpan(obj, i2, i2 + 1, 17);
        return spannableStringBuilder;
    }

    private static final SpannableStringBuilder l(SpannableStringBuilder spannableStringBuilder, Object obj, int i2, Integer num) {
        int length = num == null ? spannableStringBuilder.length() : num.intValue();
        if (i2 < 0) {
            i2 = 0;
        }
        if (length > spannableStringBuilder.length()) {
            length = spannableStringBuilder.length();
        }
        if (i2 > length) {
            length = i2;
        }
        spannableStringBuilder.setSpan(obj, i2, length, 17);
        return spannableStringBuilder;
    }

    private static final SpannableStringBuilder m(SpannableStringBuilder spannableStringBuilder, Object obj, l<? super SpannableStringBuilder, t1> lVar) {
        int length = spannableStringBuilder.length();
        lVar.invoke(spannableStringBuilder);
        boolean z = false;
        if (length >= 0 && length <= spannableStringBuilder.length()) {
            z = true;
        }
        if (z) {
            spannableStringBuilder.setSpan(obj, length, spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    private static final SpannableStringBuilder n(SpannableStringBuilder spannableStringBuilder, String str, Object obj) {
        spannableStringBuilder.append((CharSequence) str);
        if (spannableStringBuilder.length() - str.length() >= 0) {
            spannableStringBuilder.setSpan(obj, spannableStringBuilder.length() - str.length(), spannableStringBuilder.length(), 17);
        }
        return spannableStringBuilder;
    }

    @k.e.a.d
    public static final SpannableStringBuilder o(@k.e.a.d SpannableStringBuilder spannableStringBuilder, @DrawableRes @k.e.a.e Integer num, int i2, @k.e.a.e Integer num2) {
        if (num == null) {
            return spannableStringBuilder;
        }
        num.intValue();
        SpannableStringBuilder k2 = k(spannableStringBuilder, new c(e.t.a.b(), num.intValue(), num2), i2);
        return k2 == null ? spannableStringBuilder : k2;
    }

    public static /* synthetic */ SpannableStringBuilder p(SpannableStringBuilder spannableStringBuilder, Integer num, int i2, Integer num2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num2 = null;
        }
        return o(spannableStringBuilder, num, i2, num2);
    }

    @k.e.a.d
    public static final SpannableStringBuilder q(@k.e.a.d SpannableStringBuilder spannableStringBuilder, @ColorInt int i2, @ColorInt int i3, int i4, int i5, int i6, int i7, int i8, int i9, @k.e.a.d List<Integer> list) {
        return l(spannableStringBuilder, new d(i2, i3, i4, i7, i8, i9, list), i5, Integer.valueOf(i6));
    }

    @k.e.a.d
    public static final SpannableStringBuilder s(@k.e.a.d SpannableStringBuilder spannableStringBuilder, int i2, int i3, int i4) {
        return l(spannableStringBuilder, new AbsoluteSizeSpan(i2), i3, Integer.valueOf(i4));
    }
}
