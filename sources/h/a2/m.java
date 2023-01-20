package h.a2;

import androidx.exifinterface.media.ExifInterface;
import h.q1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.unsigned.UArraysKt___UArraysKt;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a5\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0004\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a#\u0010\u0007\u001a\u00020\b\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\t\u0010\n\u001a?\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\r\u001a\u00060\u000ej\u0002`\u000f2\u0010\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0015\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003¢\u0006\u0002\u0010\u0016\u001a;\u0010\u0017\u001a\u0002H\u0018\"\u0010\b\u0000\u0010\u0019*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0018\"\u0004\b\u0001\u0010\u0018*\u0002H\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a)\u0010\u001d\u001a\u00020\u0001*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u001e\u001aG\u0010\u001f\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\u00150 \"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0018*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00180 0\u0003¢\u0006\u0002\u0010!\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"contentDeepEqualsImpl", "", ExifInterface.GPS_DIRECTION_TRUE, "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 5, 1}, xi = 1, xs = "kotlin/collections/ArraysKt")
/* loaded from: classes3.dex */
public class m extends l {
    @h.p0
    @h.k2.g(name = "contentDeepEquals")
    @h.s0(version = "1.3")
    public static final <T> boolean g(@k.e.a.e T[] tArr, @k.e.a.e T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == null || tArr2 == null || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            T t = tArr[i2];
            T t2 = tArr2[i2];
            if (t != t2) {
                if (t == null || t2 == null) {
                    return false;
                }
                if ((t instanceof Object[]) && (t2 instanceof Object[])) {
                    if (!g((Object[]) t, (Object[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof byte[]) && (t2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) t, (byte[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof short[]) && (t2 instanceof short[])) {
                    if (!Arrays.equals((short[]) t, (short[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof int[]) && (t2 instanceof int[])) {
                    if (!Arrays.equals((int[]) t, (int[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof long[]) && (t2 instanceof long[])) {
                    if (!Arrays.equals((long[]) t, (long[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof float[]) && (t2 instanceof float[])) {
                    if (!Arrays.equals((float[]) t, (float[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof double[]) && (t2 instanceof double[])) {
                    if (!Arrays.equals((double[]) t, (double[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof char[]) && (t2 instanceof char[])) {
                    if (!Arrays.equals((char[]) t, (char[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof boolean[]) && (t2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) t, (boolean[]) t2)) {
                        return false;
                    }
                } else if ((t instanceof h.c1) && (t2 instanceof h.c1)) {
                    if (!UArraysKt___UArraysKt.x0(((h.c1) t).A(), ((h.c1) t2).A())) {
                        return false;
                    }
                } else if ((t instanceof q1) && (t2 instanceof q1)) {
                    if (!UArraysKt___UArraysKt.u0(((q1) t).A(), ((q1) t2).A())) {
                        return false;
                    }
                } else if ((t instanceof h.g1) && (t2 instanceof h.g1)) {
                    if (!UArraysKt___UArraysKt.v0(((h.g1) t).A(), ((h.g1) t2).A())) {
                        return false;
                    }
                } else if ((t instanceof h.k1) && (t2 instanceof h.k1)) {
                    if (!UArraysKt___UArraysKt.z0(((h.k1) t).A(), ((h.k1) t2).A())) {
                        return false;
                    }
                } else if (!h.k2.v.f0.g(t, t2)) {
                    return false;
                }
            }
        }
        return true;
    }

    @h.p0
    @h.k2.g(name = "contentDeepToString")
    @h.s0(version = "1.3")
    @k.e.a.d
    public static final <T> String h(@k.e.a.e T[] tArr) {
        if (tArr == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder((h.o2.q.u(tArr.length, 429496729) * 5) + 2);
        i(tArr, sb, new ArrayList());
        return sb.toString();
    }

    private static final <T> void i(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append('[');
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(", ");
            }
            T t = tArr[i2];
            if (t == null) {
                sb.append("null");
            } else if (t instanceof Object[]) {
                i((Object[]) t, sb, list);
            } else if (t instanceof byte[]) {
                sb.append(Arrays.toString((byte[]) t));
            } else if (t instanceof short[]) {
                sb.append(Arrays.toString((short[]) t));
            } else if (t instanceof int[]) {
                sb.append(Arrays.toString((int[]) t));
            } else if (t instanceof long[]) {
                sb.append(Arrays.toString((long[]) t));
            } else if (t instanceof float[]) {
                sb.append(Arrays.toString((float[]) t));
            } else if (t instanceof double[]) {
                sb.append(Arrays.toString((double[]) t));
            } else if (t instanceof char[]) {
                sb.append(Arrays.toString((char[]) t));
            } else if (t instanceof boolean[]) {
                sb.append(Arrays.toString((boolean[]) t));
            } else if (t instanceof h.c1) {
                h.c1 c1Var = (h.c1) t;
                sb.append(UArraysKt___UArraysKt.L0(c1Var != null ? c1Var.A() : null));
            } else if (t instanceof q1) {
                q1 q1Var = (q1) t;
                sb.append(UArraysKt___UArraysKt.P0(q1Var != null ? q1Var.A() : null));
            } else if (t instanceof h.g1) {
                h.g1 g1Var = (h.g1) t;
                sb.append(UArraysKt___UArraysKt.O0(g1Var != null ? g1Var.A() : null));
            } else if (t instanceof h.k1) {
                h.k1 k1Var = (h.k1) t;
                sb.append(UArraysKt___UArraysKt.R0(k1Var != null ? k1Var.A() : null));
            } else {
                sb.append(t.toString());
            }
        }
        sb.append(']');
        list.remove(CollectionsKt__CollectionsKt.G(list));
    }

    @k.e.a.d
    public static final <T> List<T> j(@k.e.a.d T[][] tArr) {
        int i2 = 0;
        for (T[] tArr2 : tArr) {
            i2 += tArr2.length;
        }
        ArrayList arrayList = new ArrayList(i2);
        for (T[] tArr3 : tArr) {
            y.s0(arrayList, tArr3);
        }
        return arrayList;
    }

    @h.g2.f
    @h.s0(version = "1.3")
    private static final Object k(Object[] objArr, h.k2.u.a aVar) {
        return objArr.length == 0 ? aVar.invoke() : objArr;
    }

    @h.g2.f
    @h.s0(version = "1.3")
    private static final boolean l(Object[] objArr) {
        if (objArr != null) {
            if (!(objArr.length == 0)) {
                return false;
            }
        }
        return true;
    }

    @k.e.a.d
    public static final <T, R> Pair<List<T>, List<R>> m(@k.e.a.d Pair<? extends T, ? extends R>[] pairArr) {
        ArrayList arrayList = new ArrayList(pairArr.length);
        ArrayList arrayList2 = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            arrayList.add(pair.getFirst());
            arrayList2.add(pair.getSecond());
        }
        return h.z0.a(arrayList, arrayList2);
    }
}
