package e.j.f.u;

import com.moor.imkf.lib.jsoup.nodes.Attributes;

/* loaded from: classes2.dex */
public final class b extends r {
    private static final char[] a;
    private static final char[] b = {'T', 'N', '*', 'E'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f11572c = {Attributes.InternalPrefix, ':', '+', '.'};

    /* renamed from: d  reason: collision with root package name */
    private static final char f11573d;

    static {
        char[] cArr = {'A', 'B', 'C', 'D'};
        a = cArr;
        f11573d = cArr[0];
    }

    @Override // e.j.f.u.r
    public boolean[] d(String str) {
        int i2;
        if (str.length() < 2) {
            StringBuilder sb = new StringBuilder();
            char c2 = f11573d;
            sb.append(c2);
            sb.append(str);
            sb.append(c2);
            str = sb.toString();
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            char[] cArr = a;
            boolean h2 = a.h(cArr, upperCase);
            boolean h3 = a.h(cArr, upperCase2);
            char[] cArr2 = b;
            boolean h4 = a.h(cArr2, upperCase);
            boolean h5 = a.h(cArr2, upperCase2);
            if (h2) {
                if (!h3) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                }
            } else if (h4) {
                if (!h5) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                }
            } else if (!h3 && !h5) {
                StringBuilder sb2 = new StringBuilder();
                char c3 = f11573d;
                sb2.append(c3);
                sb2.append(str);
                sb2.append(c3);
                str = sb2.toString();
            } else {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
            }
        }
        int i3 = 20;
        for (int i4 = 1; i4 < str.length() - 1; i4++) {
            if (Character.isDigit(str.charAt(i4)) || str.charAt(i4) == '-' || str.charAt(i4) == '$') {
                i3 += 9;
            } else if (!a.h(f11572c, str.charAt(i4))) {
                throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i4) + '\'');
            } else {
                i3 += 10;
            }
        }
        boolean[] zArr = new boolean[i3 + (str.length() - 1)];
        int i5 = 0;
        for (int i6 = 0; i6 < str.length(); i6++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i6));
            if (i6 == 0 || i6 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i7 = 0;
            while (true) {
                char[] cArr3 = a.f11567g;
                if (i7 >= cArr3.length) {
                    i2 = 0;
                    break;
                } else if (upperCase3 == cArr3[i7]) {
                    i2 = a.f11568h[i7];
                    break;
                } else {
                    i7++;
                }
            }
            int i8 = 0;
            boolean z = true;
            while (true) {
                int i9 = 0;
                while (i8 < 7) {
                    zArr[i5] = z;
                    i5++;
                    if (((i2 >> (6 - i8)) & 1) == 0 || i9 == 1) {
                        z = !z;
                        i8++;
                    } else {
                        i9++;
                    }
                }
                break;
            }
            if (i6 < str.length() - 1) {
                zArr[i5] = false;
                i5++;
            }
        }
        return zArr;
    }
}
