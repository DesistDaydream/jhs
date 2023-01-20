package h.t2;

import androidx.core.graphics.drawable.IconCompat;
import h.q0;
import h.s0;
import h.t1;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\f\n\u0002\u0010\u0019\n\u0002\u0010\r\n\u0000\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a6\u0010\u0000\u001a\u00020\u00012\u001b\u0010\u0004\u001a\u0017\u0012\b\u0012\u00060\u0006j\u0002`\u0007\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\b\tH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a\u001f\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0087\b\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\f0\u000e\"\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u000f\u001a/\u0010\n\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0016\u0010\r\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000e\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u0007H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0012H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0013H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\u0006\u0010\r\u001a\u00020\u0014H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0015H\u0087\b\u001a\u001f\u0010\u0011\u001a\u00060\u0006j\u0002`\u0007*\u00060\u0006j\u0002`\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0087\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", IconCompat.EXTRA_OBJ, "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "appendLine", "", "", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes4.dex */
public class r extends q {
    @h.g2.f
    @h.i(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @q0(expression = "append(value = obj)", imports = {}))
    private static final StringBuilder h0(StringBuilder sb, Object obj) {
        sb.append(obj);
        return sb;
    }

    @k.e.a.d
    public static final StringBuilder i0(@k.e.a.d StringBuilder sb, @k.e.a.d Object... objArr) {
        for (Object obj : objArr) {
            sb.append(obj);
        }
        return sb;
    }

    @k.e.a.d
    public static final StringBuilder j0(@k.e.a.d StringBuilder sb, @k.e.a.d String... strArr) {
        for (String str : strArr) {
            sb.append(str);
        }
        return sb;
    }

    @h.g2.f
    @s0(version = "1.4")
    private static final StringBuilder k0(StringBuilder sb) {
        sb.append('\n');
        return sb;
    }

    @h.g2.f
    @s0(version = "1.4")
    private static final StringBuilder l0(StringBuilder sb, char c2) {
        sb.append(c2);
        sb.append('\n');
        return sb;
    }

    @h.g2.f
    @s0(version = "1.4")
    private static final StringBuilder m0(StringBuilder sb, CharSequence charSequence) {
        sb.append(charSequence);
        sb.append('\n');
        return sb;
    }

    @h.g2.f
    @s0(version = "1.4")
    private static final StringBuilder n0(StringBuilder sb, Object obj) {
        sb.append(obj);
        sb.append('\n');
        return sb;
    }

    @h.g2.f
    @s0(version = "1.4")
    private static final StringBuilder o0(StringBuilder sb, String str) {
        sb.append(str);
        sb.append('\n');
        return sb;
    }

    @h.g2.f
    @s0(version = "1.4")
    private static final StringBuilder p0(StringBuilder sb, boolean z) {
        sb.append(z);
        sb.append('\n');
        return sb;
    }

    @h.g2.f
    @s0(version = "1.4")
    private static final StringBuilder q0(StringBuilder sb, char[] cArr) {
        sb.append(cArr);
        sb.append('\n');
        return sb;
    }

    @h.g2.f
    @s0(version = "1.1")
    private static final String r0(int i2, h.k2.u.l<? super StringBuilder, t1> lVar) {
        StringBuilder sb = new StringBuilder(i2);
        lVar.invoke(sb);
        return sb.toString();
    }

    @h.g2.f
    private static final String s0(h.k2.u.l<? super StringBuilder, t1> lVar) {
        StringBuilder sb = new StringBuilder();
        lVar.invoke(sb);
        return sb.toString();
    }
}
