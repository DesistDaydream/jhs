package com.google.zxing.datamatrix.decoder;

import com.google.zxing.FormatException;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import e.j.f.q.c;
import e.j.f.q.d;
import h.t2.y;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import k.b.a.a.n.l;
import k.b.a.a.o.e;

/* loaded from: classes2.dex */
public final class DecodedBitStreamParser {
    private static final char[] a = {'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private static final char[] b;

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f3253c;

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f3254d;

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f3255e;

    /* loaded from: classes2.dex */
    public enum Mode {
        PAD_ENCODE,
        ASCII_ENCODE,
        C40_ENCODE,
        TEXT_ENCODE,
        ANSIX12_ENCODE,
        EDIFACT_ENCODE,
        BASE256_ENCODE
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            try {
                iArr[Mode.C40_ENCODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.TEXT_ENCODE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.ANSIX12_ENCODE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.EDIFACT_ENCODE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Mode.BASE256_ENCODE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    static {
        char[] cArr = {'!', y.a, '#', '$', '%', y.f15690c, '\'', '(', ')', '*', '+', ',', l.f16189d, '.', Attributes.InternalPrefix, ':', ';', y.f15691d, '=', y.f15692e, e.a, '@', '[', '\\', ']', '^', '_'};
        b = cArr;
        f3253c = new char[]{'*', '*', '*', ' ', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        f3254d = cArr;
        f3255e = new char[]{'`', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '{', '|', '}', '~', 127};
    }

    private DecodedBitStreamParser() {
    }

    public static d a(byte[] bArr) throws FormatException {
        c cVar = new c(bArr);
        StringBuilder sb = new StringBuilder(100);
        StringBuilder sb2 = new StringBuilder(0);
        ArrayList arrayList = new ArrayList(1);
        Mode mode = Mode.ASCII_ENCODE;
        do {
            Mode mode2 = Mode.ASCII_ENCODE;
            if (mode == mode2) {
                mode = c(cVar, sb, sb2);
            } else {
                int i2 = a.a[mode.ordinal()];
                if (i2 == 1) {
                    e(cVar, sb);
                } else if (i2 == 2) {
                    g(cVar, sb);
                } else if (i2 == 3) {
                    b(cVar, sb);
                } else if (i2 == 4) {
                    f(cVar, sb);
                } else if (i2 == 5) {
                    d(cVar, sb, arrayList);
                } else {
                    throw FormatException.getFormatInstance();
                }
                mode = mode2;
            }
            if (mode == Mode.PAD_ENCODE) {
                break;
            }
        } while (cVar.a() > 0);
        if (sb2.length() > 0) {
            sb.append((CharSequence) sb2);
        }
        String sb3 = sb.toString();
        if (arrayList.isEmpty()) {
            arrayList = null;
        }
        return new d(bArr, sb3, arrayList, null);
    }

    private static void b(c cVar, StringBuilder sb) throws FormatException {
        int d2;
        int[] iArr = new int[3];
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            h(d2, cVar.d(8), iArr);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = iArr[i2];
                if (i3 == 0) {
                    sb.append('\r');
                } else if (i3 == 1) {
                    sb.append('*');
                } else if (i3 == 2) {
                    sb.append(y.f15692e);
                } else if (i3 == 3) {
                    sb.append(' ');
                } else if (i3 < 14) {
                    sb.append((char) (i3 + 44));
                } else if (i3 < 40) {
                    sb.append((char) (i3 + 51));
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static Mode c(c cVar, StringBuilder sb, StringBuilder sb2) throws FormatException {
        boolean z = false;
        do {
            int d2 = cVar.d(8);
            if (d2 == 0) {
                throw FormatException.getFormatInstance();
            }
            if (d2 > 128) {
                if (d2 != 129) {
                    if (d2 <= 229) {
                        int i2 = d2 - 130;
                        if (i2 < 10) {
                            sb.append('0');
                        }
                        sb.append(i2);
                    } else {
                        switch (d2) {
                            case 230:
                                return Mode.C40_ENCODE;
                            case 231:
                                return Mode.BASE256_ENCODE;
                            case 232:
                                sb.append((char) 29);
                                break;
                            case 233:
                            case 234:
                            case 241:
                                break;
                            case 235:
                                z = true;
                                break;
                            case 236:
                                sb.append("[)>\u001e05\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 237:
                                sb.append("[)>\u001e06\u001d");
                                sb2.insert(0, "\u001e\u0004");
                                break;
                            case 238:
                                return Mode.ANSIX12_ENCODE;
                            case 239:
                                return Mode.TEXT_ENCODE;
                            case 240:
                                return Mode.EDIFACT_ENCODE;
                            default:
                                if (d2 != 254 || cVar.a() != 0) {
                                    throw FormatException.getFormatInstance();
                                }
                                break;
                        }
                    }
                } else {
                    return Mode.PAD_ENCODE;
                }
            } else {
                if (z) {
                    d2 += 128;
                }
                sb.append((char) (d2 - 1));
                return Mode.ASCII_ENCODE;
            }
        } while (cVar.a() > 0);
        return Mode.ASCII_ENCODE;
    }

    private static void d(c cVar, StringBuilder sb, Collection<byte[]> collection) throws FormatException {
        int c2 = cVar.c() + 1;
        int i2 = c2 + 1;
        int i3 = i(cVar.d(8), c2);
        if (i3 == 0) {
            i3 = cVar.a() / 8;
        } else if (i3 >= 250) {
            i3 = ((i3 - 249) * 250) + i(cVar.d(8), i2);
            i2++;
        }
        if (i3 >= 0) {
            byte[] bArr = new byte[i3];
            int i4 = 0;
            while (i4 < i3) {
                if (cVar.a() >= 8) {
                    bArr[i4] = (byte) i(cVar.d(8), i2);
                    i4++;
                    i2++;
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            collection.add(bArr);
            try {
                sb.append(new String(bArr, "ISO8859_1"));
                return;
            } catch (UnsupportedEncodingException e2) {
                throw new IllegalStateException("Platform does not support required encoding: ".concat(String.valueOf(e2)));
            }
        }
        throw FormatException.getFormatInstance();
    }

    private static void e(c cVar, StringBuilder sb) throws FormatException {
        int d2;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            h(d2, cVar.d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = b;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else if (i4 != 30) {
                                throw FormatException.getFormatInstance();
                            } else {
                                z = true;
                            }
                            i2 = 0;
                        } else if (i2 != 3) {
                            throw FormatException.getFormatInstance();
                        } else {
                            if (z) {
                                sb.append((char) (i4 + 224));
                                z = false;
                                i2 = 0;
                            } else {
                                sb.append((char) (i4 + 96));
                                i2 = 0;
                            }
                        }
                    } else if (z) {
                        sb.append((char) (i4 + 128));
                        z = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr2 = a;
                    if (i4 < cArr2.length) {
                        char c3 = cArr2[i4];
                        if (z) {
                            sb.append((char) (c3 + 128));
                            z = false;
                        } else {
                            sb.append(c3);
                        }
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void f(c cVar, StringBuilder sb) {
        while (cVar.a() > 16) {
            for (int i2 = 0; i2 < 4; i2++) {
                int d2 = cVar.d(6);
                if (d2 == 31) {
                    int b2 = 8 - cVar.b();
                    if (b2 != 8) {
                        cVar.d(b2);
                        return;
                    }
                    return;
                }
                if ((d2 & 32) == 0) {
                    d2 |= 64;
                }
                sb.append((char) d2);
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void g(c cVar, StringBuilder sb) throws FormatException {
        int d2;
        int[] iArr = new int[3];
        boolean z = false;
        int i2 = 0;
        while (cVar.a() != 8 && (d2 = cVar.d(8)) != 254) {
            h(d2, cVar.d(8), iArr);
            for (int i3 = 0; i3 < 3; i3++) {
                int i4 = iArr[i3];
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            char[] cArr = f3254d;
                            if (i4 < cArr.length) {
                                char c2 = cArr[i4];
                                if (z) {
                                    sb.append((char) (c2 + 128));
                                    z = false;
                                } else {
                                    sb.append(c2);
                                }
                            } else if (i4 == 27) {
                                sb.append((char) 29);
                            } else if (i4 != 30) {
                                throw FormatException.getFormatInstance();
                            } else {
                                z = true;
                            }
                            i2 = 0;
                        } else if (i2 == 3) {
                            char[] cArr2 = f3255e;
                            if (i4 < cArr2.length) {
                                char c3 = cArr2[i4];
                                if (z) {
                                    sb.append((char) (c3 + 128));
                                    z = false;
                                    i2 = 0;
                                } else {
                                    sb.append(c3);
                                    i2 = 0;
                                }
                            } else {
                                throw FormatException.getFormatInstance();
                            }
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    } else if (z) {
                        sb.append((char) (i4 + 128));
                        z = false;
                        i2 = 0;
                    } else {
                        sb.append((char) i4);
                        i2 = 0;
                    }
                } else if (i4 < 3) {
                    i2 = i4 + 1;
                } else {
                    char[] cArr3 = f3253c;
                    if (i4 < cArr3.length) {
                        char c4 = cArr3[i4];
                        if (z) {
                            sb.append((char) (c4 + 128));
                            z = false;
                        } else {
                            sb.append(c4);
                        }
                    } else {
                        throw FormatException.getFormatInstance();
                    }
                }
            }
            if (cVar.a() <= 0) {
                return;
            }
        }
    }

    private static void h(int i2, int i3, int[] iArr) {
        int i4 = ((i2 << 8) + i3) - 1;
        int i5 = i4 / 1600;
        iArr[0] = i5;
        int i6 = i4 - (i5 * 1600);
        int i7 = i6 / 40;
        iArr[1] = i7;
        iArr[2] = i6 - (i7 * 40);
    }

    private static int i(int i2, int i3) {
        int i4 = i2 - (((i3 * 149) % 255) + 1);
        return i4 >= 0 ? i4 : i4 + 256;
    }
}
