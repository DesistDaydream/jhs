package com.google.zxing.aztec.decoder;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.google.zxing.FormatException;
import com.google.zxing.common.reedsolomon.ReedSolomonException;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.e;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.j256.ormlite.stmt.query.SimpleComparison;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.umeng.analytics.pro.am;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.f;
import e.j.f.q.b;
import e.j.f.q.d;
import e.j.f.q.m.c;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class Decoder {
    private static final String[] b = {"CTRL_PS", ExpandableTextView.N, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", ExpandableTextView.P, "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f3249c = {"CTRL_PS", ExpandableTextView.N, am.av, "b", "c", f.f10128d, e.a, "f", "g", "h", "i", "j", "k", NotifyType.LIGHTS, "m", "n", "o", am.ax, "q", "r", "s", am.aI, am.aH, "v", IAdInterListener.AdReqParam.WIDTH, "x", "y", am.aD, "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f3250d = {"CTRL_PS", ExpandableTextView.N, "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", TIMMentionEditText.TIM_MENTION_TAG, "\\", "^", "_", "`", HiAnalyticsConstant.REPORT_VAL_SEPARATOR, Constants.WAVE_SEPARATOR, "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    /* renamed from: e  reason: collision with root package name */
    private static final String[] f3251e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", MqttTopic.MULTI_LEVEL_WILDCARD, "$", "%", ContainerUtils.FIELD_DELIMITER, "'", "(", ")", "*", "+", Constants.ACCEPT_TIME_SEPARATOR_SP, Constants.ACCEPT_TIME_SEPARATOR_SERVER, ".", MqttTopic.TOPIC_LEVEL_SEPARATOR, Constants.COLON_SEPARATOR, ";", SimpleComparison.LESS_THAN_OPERATION, "=", SimpleComparison.GREATER_THAN_OPERATION, "?", "[", "]", "{", "}", "CTRL_UL"};

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f3252f = {"CTRL_PS", ExpandableTextView.N, "0", "1", "2", "3", PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION, "5", "6", "7", "8", "9", Constants.ACCEPT_TIME_SEPARATOR_SP, ".", "CTRL_UL", "CTRL_US"};
    private e.j.f.o.a a;

    /* loaded from: classes2.dex */
    public enum Table {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Table.values().length];
            a = iArr;
            try {
                iArr[Table.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Table.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Table.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Table.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Table.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static byte[] a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = i(zArr, i2 << 3);
        }
        return bArr;
    }

    private boolean[] b(boolean[] zArr) throws FormatException {
        e.j.f.q.m.a aVar;
        int i2 = 8;
        if (this.a.d() <= 2) {
            i2 = 6;
            aVar = e.j.f.q.m.a.f11500j;
        } else if (this.a.d() <= 8) {
            aVar = e.j.f.q.m.a.n;
        } else if (this.a.d() <= 22) {
            i2 = 10;
            aVar = e.j.f.q.m.a.f11499i;
        } else {
            i2 = 12;
            aVar = e.j.f.q.m.a.f11498h;
        }
        int c2 = this.a.c();
        int length = zArr.length / i2;
        if (length >= c2) {
            int length2 = zArr.length % i2;
            int[] iArr = new int[length];
            int i3 = 0;
            while (i3 < length) {
                iArr[i3] = j(zArr, length2, i2);
                i3++;
                length2 += i2;
            }
            try {
                new c(aVar).a(iArr, length - c2);
                int i4 = (1 << i2) - 1;
                int i5 = 0;
                for (int i6 = 0; i6 < c2; i6++) {
                    int i7 = iArr[i6];
                    if (i7 == 0 || i7 == i4) {
                        throw FormatException.getFormatInstance();
                    }
                    if (i7 == 1 || i7 == i4 - 1) {
                        i5++;
                    }
                }
                boolean[] zArr2 = new boolean[(c2 * i2) - i5];
                int i8 = 0;
                for (int i9 = 0; i9 < c2; i9++) {
                    int i10 = iArr[i9];
                    if (i10 == 1 || i10 == i4 - 1) {
                        Arrays.fill(zArr2, i8, (i8 + i2) - 1, i10 > 1);
                        i8 += i2 - 1;
                    } else {
                        int i11 = i2 - 1;
                        while (i11 >= 0) {
                            int i12 = i8 + 1;
                            zArr2[i8] = ((1 << i11) & i10) != 0;
                            i11--;
                            i8 = i12;
                        }
                    }
                }
                return zArr2;
            } catch (ReedSolomonException e2) {
                throw FormatException.getFormatInstance(e2);
            }
        }
        throw FormatException.getFormatInstance();
    }

    private boolean[] d(b bVar) {
        boolean e2 = this.a.e();
        int d2 = this.a.d();
        int i2 = (e2 ? 11 : 14) + (d2 << 2);
        int[] iArr = new int[i2];
        boolean[] zArr = new boolean[k(d2, e2)];
        int i3 = 2;
        if (e2) {
            for (int i4 = 0; i4 < i2; i4++) {
                iArr[i4] = i4;
            }
        } else {
            int i5 = i2 / 2;
            int i6 = ((i2 + 1) + (((i5 - 1) / 15) * 2)) / 2;
            for (int i7 = 0; i7 < i5; i7++) {
                int i8 = (i7 / 15) + i7;
                iArr[(i5 - i7) - 1] = (i6 - i8) - 1;
                iArr[i5 + i7] = i8 + i6 + 1;
            }
        }
        int i9 = 0;
        int i10 = 0;
        while (i9 < d2) {
            int i11 = ((d2 - i9) << i3) + (e2 ? 9 : 12);
            int i12 = i9 << 1;
            int i13 = (i2 - 1) - i12;
            int i14 = 0;
            while (i14 < i11) {
                int i15 = i14 << 1;
                int i16 = 0;
                while (i16 < i3) {
                    int i17 = i12 + i16;
                    int i18 = i12 + i14;
                    zArr[i10 + i15 + i16] = bVar.f(iArr[i17], iArr[i18]);
                    int i19 = iArr[i18];
                    int i20 = i13 - i16;
                    boolean z = e2;
                    zArr[(i11 * 2) + i10 + i15 + i16] = bVar.f(i19, iArr[i20]);
                    int i21 = i13 - i14;
                    zArr[(i11 * 4) + i10 + i15 + i16] = bVar.f(iArr[i20], iArr[i21]);
                    zArr[(i11 * 6) + i10 + i15 + i16] = bVar.f(iArr[i21], iArr[i17]);
                    i16++;
                    d2 = d2;
                    e2 = z;
                    i3 = 2;
                }
                i14++;
                i3 = 2;
            }
            i10 += i11 << 3;
            i9++;
            i3 = 2;
        }
        return zArr;
    }

    private static String e(Table table, int i2) {
        int i3 = a.a[table.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 == 5) {
                            return f3252f[i2];
                        }
                        throw new IllegalStateException("Bad table");
                    }
                    return f3251e[i2];
                }
                return f3250d[i2];
            }
            return f3249c[i2];
        }
        return b[i2];
    }

    private static String f(boolean[] zArr) {
        int length = zArr.length;
        Table table = Table.UPPER;
        StringBuilder sb = new StringBuilder(20);
        Table table2 = table;
        int i2 = 0;
        while (i2 < length) {
            if (table != Table.BINARY) {
                int i3 = table == Table.DIGIT ? 4 : 5;
                if (length - i2 < i3) {
                    break;
                }
                int j2 = j(zArr, i2, i3);
                i2 += i3;
                String e2 = e(table, j2);
                if (e2.startsWith("CTRL_")) {
                    table2 = g(e2.charAt(5));
                    if (e2.charAt(6) != 'L') {
                        table2 = table;
                        table = table2;
                    }
                } else {
                    sb.append(e2);
                }
                table = table2;
            } else if (length - i2 < 5) {
                break;
            } else {
                int j3 = j(zArr, i2, 5);
                i2 += 5;
                if (j3 == 0) {
                    if (length - i2 < 11) {
                        break;
                    }
                    j3 = j(zArr, i2, 11) + 31;
                    i2 += 11;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= j3) {
                        break;
                    } else if (length - i2 < 8) {
                        i2 = length;
                        break;
                    } else {
                        sb.append((char) j(zArr, i2, 8));
                        i2 += 8;
                        i4++;
                    }
                }
                table = table2;
            }
        }
        return sb.toString();
    }

    private static Table g(char c2) {
        if (c2 != 'B') {
            if (c2 != 'D') {
                if (c2 != 'P') {
                    if (c2 != 'L') {
                        if (c2 != 'M') {
                            return Table.UPPER;
                        }
                        return Table.MIXED;
                    }
                    return Table.LOWER;
                }
                return Table.PUNCT;
            }
            return Table.DIGIT;
        }
        return Table.BINARY;
    }

    public static String h(boolean[] zArr) {
        return f(zArr);
    }

    private static byte i(boolean[] zArr, int i2) {
        int j2;
        int length = zArr.length - i2;
        if (length >= 8) {
            j2 = j(zArr, i2, 8);
        } else {
            j2 = j(zArr, i2, length) << (8 - length);
        }
        return (byte) j2;
    }

    private static int j(boolean[] zArr, int i2, int i3) {
        int i4 = 0;
        for (int i5 = i2; i5 < i2 + i3; i5++) {
            i4 <<= 1;
            if (zArr[i5]) {
                i4 |= 1;
            }
        }
        return i4;
    }

    private static int k(int i2, boolean z) {
        return ((z ? 88 : 112) + (i2 << 4)) * i2;
    }

    public d c(e.j.f.o.a aVar) throws FormatException {
        this.a = aVar;
        boolean[] b2 = b(d(aVar.a()));
        d dVar = new d(a(b2), f(b2), null, null);
        dVar.n(b2.length);
        return dVar;
    }
}
