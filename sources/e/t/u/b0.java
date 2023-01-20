package e.t.u;

import androidx.exifinterface.media.ExifInterface;
import com.ss.android.download.api.constant.BaseConstants;
import com.vector.util.SizeofUtil;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0002¨\u0006\u000e"}, d2 = {"Lcom/vector/util/TimeFormatter;", "", "()V", "convert", "", "time", "", "format", "getTimeDiffer", "t1", "t2", "milli", "second", "FormatStyle", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b0 {
    @k.e.a.d
    public static final b0 a = new b0();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/vector/util/TimeFormatter$FormatStyle;", "", "()V", "D", "", "FROM_H12", "FROM_H24", "FROM_H_TO_M12", "FROM_H_TO_M24", "FROM_M", "FROM_M_D", "FROM_M_D_H_M", "IN12", "IN24", "M", "MD", ExifInterface.LATITUDE_SOUTH, "TO_H12", "TO_H24", "TO_M24", "YM", "YMD", "YMD_", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        @k.e.a.d
        public static final a a = new a();
        @k.e.a.d
        public static final String b = "yyyy-MM-dd";
        @k.e.a.d

        /* renamed from: c  reason: collision with root package name */
        public static final String f14652c = "yyyy-MM";
        @k.e.a.d

        /* renamed from: d  reason: collision with root package name */
        public static final String f14653d = "MM-dd";
        @k.e.a.d

        /* renamed from: e  reason: collision with root package name */
        public static final String f14654e = "MM";
        @k.e.a.d

        /* renamed from: f  reason: collision with root package name */
        public static final String f14655f = "dd";
        @k.e.a.d

        /* renamed from: g  reason: collision with root package name */
        public static final String f14656g = "ss";
        @k.e.a.d

        /* renamed from: h  reason: collision with root package name */
        public static final String f14657h = "yyyy-MM-dd hh:mm:ss";
        @k.e.a.d

        /* renamed from: i  reason: collision with root package name */
        public static final String f14658i = "yyyy-MM-dd HH:mm:ss";
        @k.e.a.d

        /* renamed from: j  reason: collision with root package name */
        public static final String f14659j = "yyyy-MM-dd HH:mm";
        @k.e.a.d

        /* renamed from: k  reason: collision with root package name */
        public static final String f14660k = "yyyy-MM-dd hh";
        @k.e.a.d

        /* renamed from: l  reason: collision with root package name */
        public static final String f14661l = "yyyy-MM-dd HH";
        @k.e.a.d

        /* renamed from: m  reason: collision with root package name */
        public static final String f14662m = "hh:mm:ss";
        @k.e.a.d
        public static final String n = "HH:mm:ss";
        @k.e.a.d
        public static final String o = "hh:mm";
        @k.e.a.d
        public static final String p = "HH:mm";
        @k.e.a.d
        public static final String q = "mm:ss";
        @k.e.a.d
        public static final String r = "MM-dd HH:mm:ss";
        @k.e.a.d
        public static final String s = "MM-dd HH:mm";
        @k.e.a.d
        public static final String t = "yyyyMMdd";

        private a() {
        }
    }

    private b0() {
    }

    private final String d(long j2, String str) {
        return new SimpleDateFormat(str, Locale.CHINA).format(Long.valueOf(j2));
    }

    private final String e(long j2, String str) {
        return d(j2 * 1000, str);
    }

    @k.e.a.d
    public final String a(long j2, @k.e.a.d String str) {
        int b = SizeofUtil.a.b(j2);
        if (b != 10) {
            if (b != 13) {
                return String.valueOf(j2);
            }
            return d(j2, str);
        }
        return e(j2, str);
    }

    @k.e.a.d
    public final String b(@k.e.a.d String str, @k.e.a.d String str2) {
        return a(Long.parseLong(str), str2);
    }

    public final long c(long j2, long j3) {
        return (j2 - j3) / ((long) BaseConstants.Time.DAY);
    }
}
