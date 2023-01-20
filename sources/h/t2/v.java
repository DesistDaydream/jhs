package h.t2;

import h.j0;
import h.s0;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a)\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00060\bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\t\u001a)\u0010\u0005\u001a\u00020\n*\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\bH\u0087\bø\u0001\u0000¢\u0006\u0002\b\u000b\u001a\u0010\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\r*\u00020\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e"}, d2 = {"elementAt", "", "", "index", "", "sumOf", "Ljava/math/BigDecimal;", "selector", "Lkotlin/Function1;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "toSortedSet", "Ljava/util/SortedSet;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes4.dex */
public class v extends StringsKt__StringsKt {
    @h.g2.f
    private static final char T5(CharSequence charSequence, int i2) {
        return charSequence.charAt(i2);
    }

    @h.k2.g(name = "sumOfBigDecimal")
    @j0
    @s0(version = "1.4")
    @h.g2.f
    private static final BigDecimal U5(CharSequence charSequence, h.k2.u.l<? super Character, ? extends BigDecimal> lVar) {
        BigDecimal valueOf = BigDecimal.valueOf(0);
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            valueOf = valueOf.add(lVar.invoke(Character.valueOf(charSequence.charAt(i2))));
        }
        return valueOf;
    }

    @h.k2.g(name = "sumOfBigInteger")
    @j0
    @s0(version = "1.4")
    @h.g2.f
    private static final BigInteger V5(CharSequence charSequence, h.k2.u.l<? super Character, ? extends BigInteger> lVar) {
        BigInteger valueOf = BigInteger.valueOf(0);
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            valueOf = valueOf.add(lVar.invoke(Character.valueOf(charSequence.charAt(i2))));
        }
        return valueOf;
    }

    @k.e.a.d
    public static final SortedSet<Character> W5(@k.e.a.d CharSequence charSequence) {
        return (SortedSet) StringsKt___StringsKt.V8(charSequence, new TreeSet());
    }
}
