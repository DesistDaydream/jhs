package h.u2;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\u001a\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\u001a\u0018\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0000\"\u001c\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "rootNegativeExpFormatSymbols", "Ljava/text/DecimalFormatSymbols;", "rootPositiveExpFormatSymbols", "scientificFormat", "createFormatForDecimals", "decimals", "", "formatScientific", "", "value", "", "formatToExactDecimals", "formatUpToDecimals", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class k {
    private static final DecimalFormatSymbols a;
    private static final DecimalFormatSymbols b;

    /* renamed from: c  reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat>[] f15708c;

    /* renamed from: d  reason: collision with root package name */
    private static final ThreadLocal<DecimalFormat> f15709d;

    static {
        Locale locale = Locale.ROOT;
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(locale);
        decimalFormatSymbols.setExponentSeparator(com.huawei.hms.push.e.a);
        a = decimalFormatSymbols;
        DecimalFormatSymbols decimalFormatSymbols2 = new DecimalFormatSymbols(locale);
        decimalFormatSymbols2.setExponentSeparator("e+");
        b = decimalFormatSymbols2;
        ThreadLocal<DecimalFormat>[] threadLocalArr = new ThreadLocal[4];
        for (int i2 = 0; i2 < 4; i2++) {
            threadLocalArr[i2] = new ThreadLocal<>();
        }
        f15708c = threadLocalArr;
        f15709d = new ThreadLocal<>();
    }

    private static final DecimalFormat a(int i2) {
        DecimalFormat decimalFormat = new DecimalFormat("0", a);
        if (i2 > 0) {
            decimalFormat.setMinimumFractionDigits(i2);
        }
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        return decimalFormat;
    }

    @k.e.a.d
    public static final String b(double d2) {
        ThreadLocal<DecimalFormat> threadLocal = f15709d;
        DecimalFormat decimalFormat = threadLocal.get();
        if (decimalFormat == null) {
            decimalFormat = new DecimalFormat("0E0", a);
            decimalFormat.setMinimumFractionDigits(2);
            threadLocal.set(decimalFormat);
        }
        DecimalFormat decimalFormat2 = decimalFormat;
        decimalFormat2.setDecimalFormatSymbols((d2 >= ((double) 1) || d2 <= ((double) (-1))) ? b : a);
        return decimalFormat2.format(d2);
    }

    @k.e.a.d
    public static final String c(double d2, int i2) {
        DecimalFormat a2;
        ThreadLocal<DecimalFormat>[] threadLocalArr = f15708c;
        if (i2 < threadLocalArr.length) {
            ThreadLocal<DecimalFormat> threadLocal = threadLocalArr[i2];
            DecimalFormat decimalFormat = threadLocal.get();
            if (decimalFormat == null) {
                decimalFormat = a(i2);
                threadLocal.set(decimalFormat);
            }
            a2 = decimalFormat;
        } else {
            a2 = a(i2);
        }
        return a2.format(d2);
    }

    @k.e.a.d
    public static final String d(double d2, int i2) {
        DecimalFormat a2 = a(0);
        a2.setMaximumFractionDigits(i2);
        return a2.format(d2);
    }
}
