package kotlin.text;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import h.k2.u.l;
import h.t2.b;
import h.t2.n;
import h.t2.u;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000b\u001a!\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0002\b\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0002¢\u0006\u0002\b\u0007\u001a\u0014\u0010\b\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u001aJ\u0010\t\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001H\u0082\b¢\u0006\u0002\b\u000e\u001a\u0014\u0010\u000f\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u0002\u001a\u001e\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\u0014\u0010\u0014\u001a\u00020\u0002*\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002¨\u0006\u0015"}, d2 = {"getIndentFunction", "Lkotlin/Function1;", "", "indent", "getIndentFunction$StringsKt__IndentKt", "indentWidth", "", "indentWidth$StringsKt__IndentKt", "prependIndent", "reindent", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "replaceIndent", "newIndent", "replaceIndentByMargin", "marginPrefix", "trimIndent", "trimMargin", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/text/StringsKt")
/* loaded from: classes4.dex */
public class StringsKt__IndentKt extends n {
    private static final l<String, String> g(String str) {
        return str.length() == 0 ? StringsKt__IndentKt$getIndentFunction$1.INSTANCE : new StringsKt__IndentKt$getIndentFunction$2(str);
    }

    private static final int h(String str) {
        int length = str.length();
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (!b.r(str.charAt(i2))) {
                break;
            } else {
                i2++;
            }
        }
        return i2 == -1 ? str.length() : i2;
    }

    @d
    public static final String i(@d String str, @d String str2) {
        return SequencesKt___SequencesKt.X0(SequencesKt___SequencesKt.d1(StringsKt__StringsKt.K3(str), new StringsKt__IndentKt$prependIndent$1(str2)), "\n", null, null, 0, null, null, 62, null);
    }

    public static /* synthetic */ String j(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    private static final String k(List<String> list, int i2, l<? super String, String> lVar, l<? super String, String> lVar2) {
        Appendable W2;
        String str;
        String invoke;
        int G = CollectionsKt__CollectionsKt.G(list);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                if (!h.g2.l.a(1, 3, 0)) {
                    throw new ArithmeticException("Index overflow has happened.");
                }
                CollectionsKt__CollectionsKt.W();
            }
            String str2 = (String) obj;
            if ((i3 == 0 || i3 == G) && u.U1(str2)) {
                str = null;
            } else {
                String invoke2 = lVar2.invoke(str2);
                if (invoke2 != null && (invoke = lVar.invoke(invoke2)) != null) {
                    str2 = invoke;
                }
                str = str2;
            }
            if (str != null) {
                arrayList.add(str);
            }
            i3 = i4;
        }
        W2 = CollectionsKt___CollectionsKt.W2(arrayList, new StringBuilder(i2), (r14 & 2) != 0 ? ", " : "\n", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        return ((StringBuilder) W2).toString();
    }

    @d
    public static final String l(@d String str, @d String str2) {
        Appendable W2;
        String str3;
        String invoke;
        List<String> L3 = StringsKt__StringsKt.L3(str);
        ArrayList<String> arrayList = new ArrayList();
        for (Object obj : L3) {
            if (!u.U1((String) obj)) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(h.a2.u.Y(arrayList, 10));
        for (String str4 : arrayList) {
            arrayList2.add(Integer.valueOf(h(str4)));
        }
        Integer num = (Integer) CollectionsKt___CollectionsKt.X3(arrayList2);
        int i2 = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length() + (str2.length() * L3.size());
        l<String, String> g2 = g(str2);
        int G = CollectionsKt__CollectionsKt.G(L3);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : L3) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            String str5 = (String) obj2;
            if ((i2 == 0 || i2 == G) && u.U1(str5)) {
                str3 = null;
            } else {
                String r6 = StringsKt___StringsKt.r6(str5, intValue);
                if (r6 != null && (invoke = g2.invoke(r6)) != null) {
                    str5 = invoke;
                }
                str3 = str5;
            }
            if (str3 != null) {
                arrayList3.add(str3);
            }
            i2 = i3;
        }
        W2 = CollectionsKt___CollectionsKt.W2(arrayList3, new StringBuilder(length), (r14 & 2) != 0 ? ", " : "\n", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
        return ((StringBuilder) W2).toString();
    }

    public static /* synthetic */ String m(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "";
        }
        return l(str, str2);
    }

    @d
    public static final String n(@d String str, @d String str2, @d String str3) {
        Appendable W2;
        int i2;
        String invoke;
        if (!u.U1(str3)) {
            List<String> L3 = StringsKt__StringsKt.L3(str);
            int length = str.length() + (str2.length() * L3.size());
            l<String, String> g2 = g(str2);
            int G = CollectionsKt__CollectionsKt.G(L3);
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (Object obj : L3) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                String str4 = (String) obj;
                String str5 = null;
                if ((i3 != 0 && i3 != G) || !u.U1(str4)) {
                    int length2 = str4.length();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length2) {
                            i2 = -1;
                            break;
                        } else if (!b.r(str4.charAt(i5))) {
                            i2 = i5;
                            break;
                        } else {
                            i5++;
                        }
                    }
                    if (i2 != -1 && u.t2(str4, str3, i2, false, 4, null)) {
                        Objects.requireNonNull(str4, "null cannot be cast to non-null type java.lang.String");
                        str5 = str4.substring(i2 + str3.length());
                    }
                    if (str5 != null && (invoke = g2.invoke(str5)) != null) {
                        str4 = invoke;
                    }
                    str5 = str4;
                }
                if (str5 != null) {
                    arrayList.add(str5);
                }
                i3 = i4;
            }
            W2 = CollectionsKt___CollectionsKt.W2(arrayList, new StringBuilder(length), (r14 & 2) != 0 ? ", " : "\n", (r14 & 4) != 0 ? "" : null, (r14 & 8) == 0 ? null : "", (r14 & 16) != 0 ? -1 : 0, (r14 & 32) != 0 ? "..." : null, (r14 & 64) != 0 ? null : null);
            return ((StringBuilder) W2).toString();
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
    }

    public static /* synthetic */ String o(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = "";
        }
        if ((i2 & 2) != 0) {
            str3 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return n(str, str2, str3);
    }

    @d
    public static final String p(@d String str) {
        return l(str, "");
    }

    @d
    public static final String q(@d String str, @d String str2) {
        return n(str, "", str2);
    }

    public static /* synthetic */ String r(String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str2 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return q(str, str2);
    }
}
