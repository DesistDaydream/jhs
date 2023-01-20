package k.b.a.a.n;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qq.e.comm.managers.setting.GlobalSetting;
import java.util.Locale;
import k.b.a.a.k.p;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class g implements k.b.a.a.i {
    private static final String b = "AEIOUY";

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f16157c = {"GN", "KN", "PN", "WR", "PS"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f16158d = {"L", "R", "N", "M", "B", "H", "F", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, ExpandableTextView.N};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f16159e = {"ES", "EP", "EB", "EL", "EY", "IB", "IL", "IN", "IE", "EI", "ER"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f16160f = {"L", ExifInterface.GPS_DIRECTION_TRUE, "K", ExifInterface.LATITUDE_SOUTH, "N", "M", "B", "Z"};
    private int a = 4;

    /* loaded from: classes4.dex */
    public class a {
        private final StringBuilder a;
        private final StringBuilder b;

        /* renamed from: c  reason: collision with root package name */
        private final int f16161c;

        public a(int i2) {
            this.a = new StringBuilder(g.this.l());
            this.b = new StringBuilder(g.this.l());
            this.f16161c = i2;
        }

        public void a(char c2) {
            g(c2);
            e(c2);
        }

        public void b(char c2, char c3) {
            g(c2);
            e(c3);
        }

        public void c(String str) {
            h(str);
            f(str);
        }

        public void d(String str, String str2) {
            h(str);
            f(str2);
        }

        public void e(char c2) {
            if (this.b.length() < this.f16161c) {
                this.b.append(c2);
            }
        }

        public void f(String str) {
            int length = this.f16161c - this.b.length();
            if (str.length() <= length) {
                this.b.append(str);
            } else {
                this.b.append(str.substring(0, length));
            }
        }

        public void g(char c2) {
            if (this.a.length() < this.f16161c) {
                this.a.append(c2);
            }
        }

        public void h(String str) {
            int length = this.f16161c - this.a.length();
            if (str.length() <= length) {
                this.a.append(str);
            } else {
                this.a.append(str.substring(0, length));
            }
        }

        public String i() {
            return this.b.toString();
        }

        public String j() {
            return this.a.toString();
        }

        public boolean k() {
            return this.a.length() >= this.f16161c && this.b.length() >= this.f16161c;
        }
    }

    private int A(String str, a aVar, int i2) {
        if (i(str, i2, 4, "TION")) {
            aVar.a('X');
        } else if (i(str, i2, 3, "TIA", "TCH")) {
            aVar.a('X');
        } else if (!i(str, i2, 2, "TH") && !i(str, i2, 3, "TTH")) {
            aVar.a('T');
            int i3 = i2 + 1;
            return i(str, i3, 1, ExifInterface.GPS_DIRECTION_TRUE, "D") ? i2 + 2 : i3;
        } else {
            int i4 = i2 + 2;
            if (!i(str, i4, 2, "OM", "AM") && !i(str, 0, 4, "VAN ", "VON ") && !i(str, 0, 3, "SCH")) {
                aVar.b('0', 'T');
                return i4;
            }
            aVar.a('T');
            return i4;
        }
        return i2 + 3;
    }

    private int B(String str, a aVar, int i2) {
        int i3 = 2;
        if (i(str, i2, 2, "WR")) {
            aVar.a('R');
        } else {
            if (i2 == 0) {
                int i4 = i2 + 1;
                if (I(a(str, i4)) || i(str, i2, 2, "WH")) {
                    if (I(a(str, i4))) {
                        aVar.b('A', 'F');
                    } else {
                        aVar.a('A');
                    }
                    return i4;
                }
            }
            if ((i2 != str.length() - 1 || !I(a(str, i2 - 1))) && !i(str, i2 - 1, 5, "EWSKI", "EWSKY", "OWSKI", "OWSKY") && !i(str, 0, 3, "SCH")) {
                i3 = 4;
                if (i(str, i2, 4, "WICZ", "WITZ")) {
                    aVar.d("TS", "FX");
                }
            } else {
                aVar.e('F');
            }
            return i2 + 1;
        }
        return i2 + i3;
    }

    private int C(String str, a aVar, int i2) {
        if (i2 == 0) {
            aVar.a('S');
            return i2 + 1;
        }
        if (i2 != str.length() - 1 || (!i(str, i2 - 3, 3, "IAU", "EAU") && !i(str, i2 - 2, 2, "AU", "OU"))) {
            aVar.c(GlobalSetting.KS_SDK_WRAPPER);
        }
        int i3 = i2 + 1;
        return i(str, i3, 1, "C", "X") ? i2 + 2 : i3;
    }

    private int D(String str, a aVar, int i2, boolean z) {
        int i3 = i2 + 1;
        if (a(str, i3) == 'H') {
            aVar.a('J');
            return i2 + 2;
        }
        if (!i(str, i3, 2, "ZO", "ZI", "ZA") && (!z || i2 <= 0 || a(str, i2 - 1) == 'T')) {
            aVar.a('S');
        } else {
            aVar.d(ExifInterface.LATITUDE_SOUTH, "TS");
        }
        if (a(str, i3) == 'Z') {
            i3 = i2 + 2;
        }
        return i3;
    }

    private boolean G(String str) {
        for (String str2 : f16157c) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }

    private boolean H(String str) {
        return str.indexOf(87) > -1 || str.indexOf(75) > -1 || str.indexOf("CZ") > -1 || str.indexOf("WITZ") > -1;
    }

    private boolean I(char c2) {
        return b.indexOf(c2) != -1;
    }

    private String b(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0) {
            return null;
        }
        return trim.toUpperCase(Locale.ENGLISH);
    }

    private boolean c(String str, int i2) {
        if (i(str, i2, 4, "CHIA")) {
            return true;
        }
        if (i2 <= 1) {
            return false;
        }
        int i3 = i2 - 2;
        if (!I(a(str, i3)) && i(str, i2 - 1, 3, "ACH")) {
            char a2 = a(str, i2 + 2);
            return !(a2 == 'I' || a2 == 'E') || i(str, i3, 6, "BACHER", "MACHER");
        }
        return false;
    }

    private boolean d(String str, int i2) {
        if (i2 != 0) {
            return false;
        }
        int i3 = i2 + 1;
        return (i(str, i3, 5, "HARAC", "HARIS") || i(str, i3, 3, "HOR", "HYM", "HIA", "HEM")) && !i(str, 0, 5, "CHORE");
    }

    private boolean e(String str, int i2) {
        if (!i(str, 0, 4, "VAN ", "VON ") && !i(str, 0, 3, "SCH") && !i(str, i2 - 2, 6, "ORCHES", "ARCHIT", "ORCHID")) {
            int i3 = i2 + 2;
            if (!i(str, i3, 1, ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.LATITUDE_SOUTH)) {
                if (!i(str, i2 - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O", "U", ExifInterface.LONGITUDE_EAST) && i2 != 0) {
                    return false;
                }
                if (!i(str, i3, 1, f16158d) && i2 + 1 != str.length() - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean g(String str, int i2) {
        if (i2 == str.length() - 3 && i(str, i2 - 1, 4, "ILLO", "ILLA", "ALLE")) {
            return true;
        }
        return (i(str, str.length() - 2, 2, "AS", "OS") || i(str, str.length() - 1, 1, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "O")) && i(str, i2 - 1, 4, "ALLE");
    }

    private boolean h(String str, int i2) {
        int i3 = i2 + 1;
        if (a(str, i3) == 'M') {
            return true;
        }
        return i(str, i2 + (-1), 3, "UMB") && (i3 == str.length() - 1 || i(str, i2 + 2, 2, "ER"));
    }

    public static boolean i(String str, int i2, int i3, String... strArr) {
        int i4;
        if (i2 < 0 || (i4 = i3 + i2) > str.length()) {
            return false;
        }
        String substring = str.substring(i2, i4);
        for (String str2 : strArr) {
            if (substring.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    private int m(a aVar, int i2) {
        if (i2 == 0) {
            aVar.a('A');
        }
        return i2 + 1;
    }

    private int n(String str, a aVar, int i2) {
        if (c(str, i2)) {
            aVar.a('K');
        } else if (i2 == 0 && i(str, i2, 6, "CAESAR")) {
            aVar.a('S');
        } else if (i(str, i2, 2, "CH")) {
            return p(str, aVar, i2);
        } else {
            if (i(str, i2, 2, "CZ") && !i(str, i2 - 2, 4, "WICZ")) {
                aVar.b('S', 'X');
            } else {
                int i3 = i2 + 1;
                if (i(str, i3, 3, "CIA")) {
                    aVar.a('X');
                } else if (i(str, i2, 2, "CC") && (i2 != 1 || a(str, 0) != 'M')) {
                    return o(str, aVar, i2);
                } else {
                    if (i(str, i2, 2, "CK", "CG", "CQ")) {
                        aVar.a('K');
                    } else if (i(str, i2, 2, "CI", "CE", "CY")) {
                        if (i(str, i2, 3, "CIO", "CIE", "CIA")) {
                            aVar.b('S', 'X');
                        } else {
                            aVar.a('S');
                        }
                    } else {
                        aVar.a('K');
                        if (!i(str, i3, 2, " C", " Q", " G")) {
                            if (!i(str, i3, 1, "C", "K", "Q") || i(str, i3, 2, "CE", "CI")) {
                                return i3;
                            }
                        }
                    }
                }
                return i2 + 3;
            }
        }
        return i2 + 2;
    }

    private int o(String str, a aVar, int i2) {
        int i3 = i2 + 2;
        if (i(str, i3, 1, ExpandableTextView.P, ExifInterface.LONGITUDE_EAST, "H") && !i(str, i3, 2, "HU")) {
            if ((i2 == 1 && a(str, i2 - 1) == 'A') || i(str, i2 - 1, 5, "UCCEE", "UCCES")) {
                aVar.c(GlobalSetting.KS_SDK_WRAPPER);
            } else {
                aVar.a('X');
            }
            return i2 + 3;
        }
        aVar.a('K');
        return i3;
    }

    private int p(String str, a aVar, int i2) {
        if (i2 > 0 && i(str, i2, 4, "CHAE")) {
            aVar.b('K', 'X');
        } else if (d(str, i2)) {
            aVar.a('K');
        } else if (!e(str, i2)) {
            if (i2 > 0) {
                if (i(str, 0, 2, "MC")) {
                    aVar.a('K');
                } else {
                    aVar.b('X', 'K');
                }
            } else {
                aVar.a('X');
            }
            return i2 + 2;
        } else {
            aVar.a('K');
        }
        return i2 + 2;
    }

    private int q(String str, a aVar, int i2) {
        if (i(str, i2, 2, "DG")) {
            int i3 = i2 + 2;
            if (i(str, i3, 1, ExpandableTextView.P, ExifInterface.LONGITUDE_EAST, "Y")) {
                aVar.a('J');
                return i2 + 3;
            }
            aVar.c("TK");
            return i3;
        } else if (i(str, i2, 2, "DT", "DD")) {
            aVar.a('T');
            return i2 + 2;
        } else {
            aVar.a('T');
            return i2 + 1;
        }
    }

    private int r(String str, a aVar, int i2, boolean z) {
        int i3 = i2 + 1;
        if (a(str, i3) == 'H') {
            return s(str, aVar, i2);
        }
        if (a(str, i3) == 'N') {
            if (i2 == 1 && I(a(str, 0)) && !z) {
                aVar.d("KN", "N");
            } else if (!i(str, i2 + 2, 2, "EY") && a(str, i3) != 'Y' && !z) {
                aVar.d("N", "KN");
            } else {
                aVar.c("KN");
            }
        } else if (i(str, i3, 2, "LI") && !z) {
            aVar.d("KL", "L");
        } else if (i2 == 0 && (a(str, i3) == 'Y' || i(str, i3, 2, f16159e))) {
            aVar.b('K', 'J');
        } else {
            if ((i(str, i3, 2, "ER") || a(str, i3) == 'Y') && !i(str, 0, 6, "DANGER", "RANGER", "MANGER")) {
                int i4 = i2 - 1;
                if (!i(str, i4, 1, ExifInterface.LONGITUDE_EAST, ExpandableTextView.P) && !i(str, i4, 3, "RGY", "OGY")) {
                    aVar.b('K', 'J');
                    return i2 + 2;
                }
            }
            if (!i(str, i3, 1, ExifInterface.LONGITUDE_EAST, ExpandableTextView.P, "Y") && !i(str, i2 - 1, 4, "AGGI", "OGGI")) {
                if (a(str, i3) == 'G') {
                    int i5 = i2 + 2;
                    aVar.a('K');
                    return i5;
                }
                aVar.a('K');
                return i3;
            }
            if (!i(str, 0, 4, "VAN ", "VON ") && !i(str, 0, 3, "SCH") && !i(str, i3, 2, "ET")) {
                if (i(str, i3, 3, "IER")) {
                    aVar.a('J');
                } else {
                    aVar.b('J', 'K');
                }
            } else {
                aVar.a('K');
            }
            return i2 + 2;
        }
        return i2 + 2;
    }

    private int s(String str, a aVar, int i2) {
        if (i2 > 0 && !I(a(str, i2 - 1))) {
            aVar.a('K');
        } else if (i2 == 0) {
            int i3 = i2 + 2;
            if (a(str, i3) == 'I') {
                aVar.a('J');
                return i3;
            }
            aVar.a('K');
            return i3;
        } else if ((i2 <= 1 || !i(str, i2 - 2, 1, "B", "H", "D")) && ((i2 <= 2 || !i(str, i2 - 3, 1, "B", "H", "D")) && (i2 <= 3 || !i(str, i2 - 4, 1, "B", "H")))) {
            if (i2 > 2 && a(str, i2 - 1) == 'U' && i(str, i2 - 3, 1, "C", "G", "L", "R", ExifInterface.GPS_DIRECTION_TRUE)) {
                aVar.a('F');
            } else if (i2 > 0 && a(str, i2 - 1) != 'I') {
                aVar.a('K');
            }
        }
        return i2 + 2;
    }

    private int t(String str, a aVar, int i2) {
        if ((i2 == 0 || I(a(str, i2 - 1))) && I(a(str, i2 + 1))) {
            aVar.a('H');
            return i2 + 2;
        }
        return i2 + 1;
    }

    private int u(String str, a aVar, int i2, boolean z) {
        if (!i(str, i2, 4, "JOSE") && !i(str, 0, 4, "SAN ")) {
            if (i2 == 0 && !i(str, i2, 4, "JOSE")) {
                aVar.b('J', 'A');
            } else {
                int i3 = i2 - 1;
                if (I(a(str, i3)) && !z) {
                    int i4 = i2 + 1;
                    if (a(str, i4) == 'A' || a(str, i4) == 'O') {
                        aVar.b('J', 'H');
                    }
                }
                if (i2 == str.length() - 1) {
                    aVar.b('J', ' ');
                } else if (!i(str, i2 + 1, 1, f16160f) && !i(str, i3, 1, ExifInterface.LATITUDE_SOUTH, "K", "L")) {
                    aVar.a('J');
                }
            }
            int i5 = i2 + 1;
            return a(str, i5) == 'J' ? i2 + 2 : i5;
        }
        if ((i2 != 0 || a(str, i2 + 4) != ' ') && str.length() != 4 && !i(str, 0, 4, "SAN ")) {
            aVar.b('J', 'H');
        } else {
            aVar.a('H');
        }
        return i2 + 1;
    }

    private int v(String str, a aVar, int i2) {
        int i3 = i2 + 1;
        if (a(str, i3) == 'L') {
            if (g(str, i2)) {
                aVar.g('L');
            } else {
                aVar.a('L');
            }
            return i2 + 2;
        }
        aVar.a('L');
        return i3;
    }

    private int w(String str, a aVar, int i2) {
        int i3 = i2 + 1;
        if (a(str, i3) == 'H') {
            aVar.a('F');
            return i2 + 2;
        }
        aVar.a('P');
        if (i(str, i3, 1, "P", "B")) {
            i3 = i2 + 2;
        }
        return i3;
    }

    private int x(String str, a aVar, int i2, boolean z) {
        if (i2 == str.length() - 1 && !z && i(str, i2 - 2, 2, "IE") && !i(str, i2 - 4, 2, "ME", "MA")) {
            aVar.e('R');
        } else {
            aVar.a('R');
        }
        int i3 = i2 + 1;
        return a(str, i3) == 'R' ? i2 + 2 : i3;
    }

    private int y(String str, a aVar, int i2, boolean z) {
        if (!i(str, i2 - 1, 3, "ISL", "YSL")) {
            if (i2 == 0 && i(str, i2, 5, "SUGAR")) {
                aVar.b('X', 'S');
            } else {
                if (i(str, i2, 2, "SH")) {
                    if (i(str, i2 + 1, 4, "HEIM", "HOEK", "HOLM", "HOLZ")) {
                        aVar.a('S');
                    } else {
                        aVar.a('X');
                    }
                } else if (i(str, i2, 3, "SIO", "SIA") || i(str, i2, 4, "SIAN")) {
                    if (z) {
                        aVar.a('S');
                    } else {
                        aVar.b('S', 'X');
                    }
                    return i2 + 3;
                } else {
                    if (i2 != 0 || !i(str, i2 + 1, 1, "M", "N", "L", ExifInterface.LONGITUDE_WEST)) {
                        int i3 = i2 + 1;
                        if (!i(str, i3, 1, "Z")) {
                            if (i(str, i2, 2, "SC")) {
                                return z(str, aVar, i2);
                            }
                            if (i2 == str.length() - 1 && i(str, i2 - 2, 2, "AI", "OI")) {
                                aVar.e('S');
                            } else {
                                aVar.a('S');
                            }
                            if (!i(str, i3, 1, ExifInterface.LATITUDE_SOUTH, "Z")) {
                                return i3;
                            }
                        }
                    }
                    aVar.b('S', 'X');
                    int i4 = i2 + 1;
                    if (!i(str, i4, 1, "Z")) {
                        return i4;
                    }
                }
                return i2 + 2;
            }
        }
        return i2 + 1;
    }

    private int z(String str, a aVar, int i2) {
        int i3 = i2 + 2;
        if (a(str, i3) == 'H') {
            int i4 = i2 + 3;
            if (i(str, i4, 2, "OO", "ER", "EN", "UY", "ED", "EM")) {
                if (i(str, i4, 2, "ER", "EN")) {
                    aVar.d("X", "SK");
                } else {
                    aVar.c("SK");
                }
            } else if (i2 == 0 && !I(a(str, 3)) && a(str, 3) != 'W') {
                aVar.b('X', 'S');
            } else {
                aVar.a('X');
            }
        } else if (i(str, i3, 1, ExpandableTextView.P, ExifInterface.LONGITUDE_EAST, "Y")) {
            aVar.a('S');
        } else {
            aVar.c("SK");
        }
        return i2 + 3;
    }

    public boolean E(String str, String str2) {
        return F(str, str2, false);
    }

    public boolean F(String str, String str2, boolean z) {
        return p.a(k(str, z), k(str2, z));
    }

    public void J(int i2) {
        this.a = i2;
    }

    public char a(String str, int i2) {
        if (i2 < 0 || i2 >= str.length()) {
            return (char) 0;
        }
        return str.charAt(i2);
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return j((String) obj);
        }
        throw new EncoderException("DoubleMetaphone encode parameter is not of type String");
    }

    @Override // k.b.a.a.i
    public String f(String str) {
        return j(str);
    }

    public String j(String str) {
        return k(str, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11, types: [int] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int] */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    /* JADX WARN: Type inference failed for: r7v0, types: [k.b.a.a.n.g] */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    public String k(String str, boolean z) {
        int i2;
        ?? b2 = b(str);
        if (b2 == 0) {
            return null;
        }
        boolean H = H(b2);
        ?? G = G(b2);
        a aVar = new a(l());
        while (!aVar.k() && G <= b2.length() - 1) {
            char charAt = b2.charAt(G);
            if (charAt == 199) {
                aVar.a('S');
            } else if (charAt != 209) {
                switch (charAt) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U':
                    case 'Y':
                        G = m(aVar, G);
                        break;
                    case 'B':
                        aVar.a('P');
                        i2 = G + 1;
                        if (a(b2, i2) != 'B') {
                            G = i2;
                            break;
                        } else {
                            G += 2;
                            break;
                        }
                    case 'C':
                        G = n(b2, aVar, G);
                        break;
                    case 'D':
                        G = q(b2, aVar, G);
                        break;
                    case 'F':
                        aVar.a('F');
                        i2 = G + 1;
                        if (a(b2, i2) != 'F') {
                            G = i2;
                            break;
                        } else {
                            G += 2;
                            break;
                        }
                    case 'G':
                        G = r(b2, aVar, G, H);
                        break;
                    case 'H':
                        G = t(b2, aVar, G);
                        break;
                    case 'J':
                        G = u(b2, aVar, G, H);
                        break;
                    case 'K':
                        aVar.a('K');
                        i2 = G + 1;
                        if (a(b2, i2) != 'K') {
                            G = i2;
                            break;
                        } else {
                            G += 2;
                            break;
                        }
                    case 'L':
                        G = v(b2, aVar, G);
                        break;
                    case 'M':
                        aVar.a('M');
                        if (!h(b2, G)) {
                            break;
                        } else {
                            G += 2;
                            break;
                        }
                    case 'N':
                        aVar.a('N');
                        i2 = G + 1;
                        if (a(b2, i2) != 'N') {
                            G = i2;
                            break;
                        } else {
                            G += 2;
                            break;
                        }
                    case 'P':
                        G = w(b2, aVar, G);
                        break;
                    case 'Q':
                        aVar.a('K');
                        i2 = G + 1;
                        if (a(b2, i2) != 'Q') {
                            G = i2;
                            break;
                        } else {
                            G += 2;
                            break;
                        }
                    case 'R':
                        G = x(b2, aVar, G, H);
                        break;
                    case 'S':
                        G = y(b2, aVar, G, H);
                        break;
                    case 'T':
                        G = A(b2, aVar, G);
                        break;
                    case 'V':
                        aVar.a('F');
                        i2 = G + 1;
                        if (a(b2, i2) != 'V') {
                            G = i2;
                            break;
                        } else {
                            G += 2;
                            break;
                        }
                    case 'W':
                        G = B(b2, aVar, G);
                        break;
                    case 'X':
                        G = C(b2, aVar, G);
                        break;
                    case 'Z':
                        G = D(b2, aVar, G, H);
                        break;
                }
            } else {
                aVar.a('N');
            }
            G++;
        }
        return z ? aVar.i() : aVar.j();
    }

    public int l() {
        return this.a;
    }
}
