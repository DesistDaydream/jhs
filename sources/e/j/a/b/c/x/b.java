package e.j.a.b.c.x;

import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@e.j.a.b.c.m.a
@d0
/* loaded from: classes2.dex */
public final class b {
    private b() {
    }

    @e.j.a.b.c.m.a
    public static <T> T[] a(T[] tArr, T t) {
        T[] tArr2;
        if (tArr == null && t == null) {
            throw new IllegalArgumentException("Cannot generate array of generic type w/o class info");
        }
        if (tArr == null) {
            tArr2 = (T[]) ((Object[]) Array.newInstance(t.getClass(), 1));
        } else {
            tArr2 = (T[]) Arrays.copyOf(tArr, tArr.length + 1);
        }
        tArr2[tArr2.length - 1] = t;
        return tArr2;
    }

    @e.j.a.b.c.m.a
    public static <T> T[] b(T[]... tArr) {
        if (tArr.length == 0) {
            return (T[]) ((Object[]) Array.newInstance(tArr.getClass(), 0));
        }
        int i2 = 0;
        for (T[] tArr2 : tArr) {
            i2 += tArr2.length;
        }
        T[] tArr3 = (T[]) Arrays.copyOf(tArr[0], i2);
        int length = tArr[0].length;
        for (int i3 = 1; i3 < tArr.length; i3++) {
            T[] tArr4 = tArr[i3];
            System.arraycopy(tArr4, 0, tArr3, length, tArr4.length);
            length += tArr4.length;
        }
        return tArr3;
    }

    @e.j.a.b.c.m.a
    public static byte[] c(byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i2 = 0;
        for (byte[] bArr2 : bArr) {
            i2 += bArr2.length;
        }
        byte[] copyOf = Arrays.copyOf(bArr[0], i2);
        int length = bArr[0].length;
        for (int i3 = 1; i3 < bArr.length; i3++) {
            byte[] bArr3 = bArr[i3];
            System.arraycopy(bArr3, 0, copyOf, length, bArr3.length);
            length += bArr3.length;
        }
        return copyOf;
    }

    @e.j.a.b.c.m.a
    public static boolean d(int[] iArr, int i2) {
        if (iArr == null) {
            return false;
        }
        for (int i3 : iArr) {
            if (i3 == i2) {
                return true;
            }
        }
        return false;
    }

    @e.j.a.b.c.m.a
    public static <T> boolean e(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = -1;
                break;
            } else if (e.j.a.b.c.r.y.a(tArr[i2], t)) {
                break;
            } else {
                i2++;
            }
        }
        return i2 >= 0;
    }

    @e.j.a.b.c.m.a
    public static <T> ArrayList<T> f() {
        return new ArrayList<>();
    }

    @e.j.a.b.c.m.a
    public static <T> T[] g(T[] tArr, T... tArr2) {
        int i2;
        if (tArr == null) {
            return null;
        }
        if (tArr2 != null && tArr2.length != 0) {
            T[] tArr3 = (T[]) ((Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length));
            if (tArr2.length == 1) {
                i2 = 0;
                for (T t : tArr) {
                    if (!e.j.a.b.c.r.y.a(tArr2[0], t)) {
                        tArr3[i2] = t;
                        i2++;
                    }
                }
            } else {
                int i3 = 0;
                for (T t2 : tArr) {
                    if (!e(tArr2, t2)) {
                        tArr3[i3] = t2;
                        i3++;
                    }
                }
                i2 = i3;
            }
            if (tArr3 == null) {
                return null;
            }
            return i2 != tArr3.length ? (T[]) Arrays.copyOf(tArr3, i2) : tArr3;
        }
        return (T[]) Arrays.copyOf(tArr, tArr.length);
    }

    @e.j.a.b.c.m.a
    public static <T> ArrayList<T> h(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(tArr.length);
        for (T t : tArr) {
            arrayList.add(t);
        }
        return arrayList;
    }

    @e.j.a.b.c.m.a
    public static int[] i(Collection<Integer> collection) {
        int i2 = 0;
        if (collection == null || collection.size() == 0) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        for (Integer num : collection) {
            iArr[i2] = num.intValue();
            i2++;
        }
        return iArr;
    }

    @e.j.a.b.c.m.a
    public static Integer[] j(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i2 = 0; i2 < length; i2++) {
            numArr[i2] = Integer.valueOf(iArr[i2]);
        }
        return numArr;
    }

    @e.j.a.b.c.m.a
    public static void k(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(Double.toString(dArr[i2]));
        }
    }

    @e.j.a.b.c.m.a
    public static void l(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(Float.toString(fArr[i2]));
        }
    }

    @e.j.a.b.c.m.a
    public static void m(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(Integer.toString(iArr[i2]));
        }
    }

    @e.j.a.b.c.m.a
    public static void n(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(Long.toString(jArr[i2]));
        }
    }

    @e.j.a.b.c.m.a
    public static <T> void o(StringBuilder sb, T[] tArr) {
        int length = tArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(tArr[i2].toString());
        }
    }

    @e.j.a.b.c.m.a
    public static void p(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append(Boolean.toString(zArr[i2]));
        }
    }

    @e.j.a.b.c.m.a
    public static void q(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 != 0) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb.append("\"");
            sb.append(strArr[i2]);
            sb.append("\"");
        }
    }
}
