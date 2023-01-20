package e.t.l;

import java.util.regex.Pattern;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\r\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u0018\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\f\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\r\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0010\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0005¨\u0006\u0012"}, d2 = {"find", "", "regex", "", "text", "", "match", "hasSpecialSymbol", "isChinese", "isChinesePunctuation", "isDecimal", "isEmail", "isEnglishPunctuation", "isInteger", "isMobileCN", "isNumAndLetter", "isNumOrEnglish", "isNumOrLetter", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class t {
    private static final boolean a(String str, CharSequence charSequence) {
        return Pattern.compile(str, 2).matcher(charSequence).find();
    }

    public static final boolean b(@k.e.a.d CharSequence charSequence) {
        return a(v.f14589e, charSequence);
    }

    public static final boolean c(@k.e.a.d CharSequence charSequence) {
        return m(v.f14591g, charSequence);
    }

    public static final boolean d(@k.e.a.d CharSequence charSequence) {
        return m(v.f14594j, charSequence);
    }

    public static final boolean e(@k.e.a.d CharSequence charSequence) {
        return m(v.f14588d, charSequence);
    }

    public static final boolean f(@k.e.a.d CharSequence charSequence) {
        return m(v.b, charSequence);
    }

    public static final boolean g(@k.e.a.d CharSequence charSequence) {
        return m(v.f14595k, charSequence);
    }

    public static final boolean h(@k.e.a.d CharSequence charSequence) {
        return m(v.f14587c, charSequence);
    }

    public static final boolean i(@k.e.a.d CharSequence charSequence) {
        return m(v.f14590f, charSequence);
    }

    public static final boolean j(@k.e.a.d CharSequence charSequence) {
        return m(v.f14592h, charSequence);
    }

    public static final boolean k(@k.e.a.d CharSequence charSequence) {
        return m(v.f14593i, charSequence);
    }

    public static final boolean l(@k.e.a.d CharSequence charSequence) {
        return m(v.f14596l, charSequence);
    }

    private static final boolean m(String str, CharSequence charSequence) {
        return Pattern.compile(str).matcher(charSequence).matches();
    }
}
