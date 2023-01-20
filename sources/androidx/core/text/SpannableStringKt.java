package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Spannable;
import android.text.SpannableString;
import com.tencent.android.tpush.common.MessageKey;
import h.o2.k;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a%\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\u001d\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0086\n\u001a\r\u0010\u000b\u001a\u00020\u0002*\u00020\fH\u0086\b¨\u0006\r"}, d2 = {"clearSpans", "", "Landroid/text/Spannable;", "set", MessageKey.MSG_ACCEPT_TIME_START, "", MessageKey.MSG_ACCEPT_TIME_END, "span", "", "range", "Lkotlin/ranges/IntRange;", "toSpannable", "", "core-ktx_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class SpannableStringKt {
    @SuppressLint({"SyntheticAccessor"})
    public static final void clearSpans(@d Spannable spannable) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(@d Spannable spannable, int i2, int i3, @d Object obj) {
        spannable.setSpan(obj, i2, i3, 17);
    }

    @d
    public static final Spannable toSpannable(@d CharSequence charSequence) {
        return SpannableString.valueOf(charSequence);
    }

    public static final void set(@d Spannable spannable, @d k kVar, @d Object obj) {
        spannable.setSpan(obj, kVar.getStart().intValue(), kVar.getEndInclusive().intValue(), 17);
    }
}
