package e.t.l;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.PowerManager;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.v.f0;
import h.k2.v.n0;
import h.q0;
import h.t1;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import kotlin.Metadata;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\u0007\u001a\u00020\u00032\u0017\u0010\b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\b\fH\u0086\bø\u0001\u0000\u001a\"\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u001a\n\u0010\u0013\u001a\u00020\u0003*\u00020\u0003\u001a\u0012\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0001\u001a\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u0015*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0001¢\u0006\u0002\u0010\u0018\u001a\n\u0010\u0019\u001a\u00020\u000b*\u00020\n\u001a\f\u0010\u001a\u001a\u00020\u000b*\u0004\u0018\u00010\u001b\u001a\"\u0010\u001c\u001a\u00020\u0003*\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0003\u001a\f\u0010!\u001a\u0004\u0018\u00010\u0003*\u00020\u0003\u001a\n\u0010\"\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010#\u001a\u00020$*\u00020\u0003\u001a\n\u0010%\u001a\u00020&*\u00020\u0003\u001a\f\u0010'\u001a\u00020\u0003*\u0004\u0018\u00010\u0003\u001a\f\u0010(\u001a\u0004\u0018\u00010)*\u00020\u0003\u001a\u000e\u0010*\u001a\u00020+*\u0004\u0018\u00010\u001bH\u0007\u001a\u000e\u0010,\u001a\u00020+*\u0004\u0018\u00010\u001bH\u0007\u001a\n\u0010-\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010.\u001a\u00020\u0003*\u00020\u0003\u001a\n\u0010/\u001a\u00020\u0003*\u00020\u0003\u001a\n\u00100\u001a\u00020\u0003*\u00020\u0003\u001a\n\u00101\u001a\u00020\u0003*\u00020\u0003\u001a\n\u00102\u001a\u00020\u0003*\u00020\u0003\u001a\n\u00103\u001a\u000204*\u00020\u0003\u001a\n\u00105\u001a\u00020\u0003*\u00020\u0003\u001a\n\u00106\u001a\u00020\u0003*\u00020\u0003\u001a\n\u00107\u001a\u00020\u0003*\u00020\u0003\u001a\n\u00108\u001a\u00020\u0003*\u00020\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00069"}, d2 = {"BLANK_INDEX", "", "BLANK_UTF8_DEF", "", "CN_RANGE_MAX", "CN_RANGE_MIN", "HEX_CODE", "bufferString", "bufferAction", "Lkotlin/Function1;", "Ljava/lang/StringBuffer;", "", "Lkotlin/ExtensionFunctionType;", "bitmap", "Landroid/graphics/Bitmap;", "options", "Landroid/graphics/BitmapFactory$Options;", "context", "Landroid/content/Context;", "capitalize", "charAt", "", "position", "charAtOrNull", "(Ljava/lang/String;I)Ljava/lang/Character;", "clear", "copyToClipboard", "", "cut", "textSize", "", "pxLength", "symbol", "decodeHex", "decodeUnicode", "exifInterface", "Landroidx/exifinterface/media/ExifInterface;", "file", "Ljava/io/File;", "filterNull", "hexToBytes", "", "isEmpty", "", "isNotEmpty", "lowerCase", "md5", "replaceLineBreak", "toDBC", "toEnSymbol", "toHex", "toInputStream", "Ljava/io/InputStream;", "toSBC", "toUnicode", "toUtf8", "upperCase", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class w {
    @k.e.a.d
    private static final String a = "%20";
    private static final int b = 32;

    /* renamed from: c  reason: collision with root package name */
    private static final int f14597c = 19968;

    /* renamed from: d  reason: collision with root package name */
    private static final int f14598d = 171941;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f14599e = "0123456789ABCDEF";

    @k.e.a.d
    public static final String A(@k.e.a.d String str) {
        byte[] bArr;
        String valueOf;
        Charset charset;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < stringBuffer.length(); i2++) {
            char charAt = stringBuffer.charAt(i2);
            if (!(charAt >= 0 && charAt <= 255)) {
                try {
                    valueOf = String.valueOf(charAt);
                    charset = h.t2.d.a;
                } catch (Exception unused) {
                    bArr = new byte[0];
                }
                if (valueOf == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    break;
                }
                bArr = valueOf.getBytes(charset);
                for (int i3 : bArr) {
                    if (i3 < 0) {
                        i3 += 256;
                    }
                    stringBuffer.append(f0.C("%", Integer.toHexString(i3).toUpperCase(Locale.getDefault())));
                }
            } else if (charAt == ' ') {
                stringBuffer.append(a);
            } else {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    @k.e.a.d
    public static final String B(@k.e.a.d String str) {
        return str.toUpperCase(Locale.getDefault());
    }

    @k.e.a.e
    public static final Bitmap a(@k.e.a.d String str, @k.e.a.e BitmapFactory.Options options, @k.e.a.d Context context) {
        if (z.j(str)) {
            AssetFileDescriptor n = z.n(Uri.parse(str), context, "r");
            return BitmapFactory.decodeFileDescriptor(n == null ? null : n.getFileDescriptor(), null, options);
        }
        return BitmapFactory.decodeFile(str, options);
    }

    public static /* synthetic */ Bitmap b(String str, BitmapFactory.Options options, Context context, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            options = null;
        }
        if ((i2 & 2) != 0) {
            context = e.t.a.b();
        }
        return a(str, options, context);
    }

    @k.e.a.d
    public static final String c(@k.e.a.d h.k2.u.l<? super StringBuffer, t1> lVar) {
        StringBuffer stringBuffer = new StringBuffer();
        lVar.invoke(stringBuffer);
        return stringBuffer.toString();
    }

    @k.e.a.d
    public static final String d(@k.e.a.d String str) {
        char[] charArray = str.toCharArray();
        Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }

    public static final char e(@k.e.a.d String str, int i2) {
        return str.toCharArray()[i2];
    }

    @k.e.a.e
    public static final Character f(@k.e.a.d String str, int i2) {
        if (i2 >= str.length()) {
            return null;
        }
        return Character.valueOf(e(str, i2));
    }

    public static final void g(@k.e.a.d StringBuffer stringBuffer) {
        stringBuffer.delete(0, stringBuffer.length() - 1);
    }

    public static final void h(@k.e.a.e CharSequence charSequence) {
        ClipboardManager clipboardManager;
        Context b2 = e.t.a.b();
        h.p2.d d2 = n0.d(ClipboardManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = b2.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = b2.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = b2.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = b2.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = b2.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = b2.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = b2.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = b2.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = b2.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService9;
        } else if (!f0.g(d2, n0.d(CameraManager.class))) {
            throw new IllegalArgumentException("can not find class");
        } else {
            Object systemService10 = b2.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.content.ClipboardManager");
            clipboardManager = (ClipboardManager) systemService10;
        }
        clipboardManager.setPrimaryClip(ClipData.newPlainText(null, charSequence));
    }

    @k.e.a.d
    public static final String i(@k.e.a.d CharSequence charSequence, float f2, float f3, @k.e.a.d String str) {
        int i2;
        int i3;
        float f4 = f2 / 2;
        int length = charSequence.length();
        if (length > 0) {
            int i4 = 0;
            i2 = 0;
            i3 = 0;
            while (true) {
                int i5 = i4 + 1;
                char charAt = charSequence.charAt(i4);
                i2 += f14597c <= charAt && charAt <= f14598d ? (int) f2 : (int) f4;
                if (i2 > f3) {
                    break;
                }
                i3++;
                if (i5 >= length) {
                    break;
                }
                i4 = i5;
            }
        } else {
            i2 = 0;
            i3 = 0;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(stringBuffer.subSequence(0, i3));
        if (i2 > f3 && q(str)) {
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    @k.e.a.e
    public static final String j(@k.e.a.d String str) {
        byte[] o = o(str);
        if (o == null) {
            return null;
        }
        return f.c(o);
    }

    @k.e.a.d
    public static final String k(@k.e.a.d String str) {
        StringBuffer stringBuffer = new StringBuffer();
        List S4 = StringsKt__StringsKt.S4(str, new String[]{"\\\\u"}, false, 0, 6, null);
        int size = S4.size();
        int i2 = 1;
        if (1 < size) {
            while (true) {
                int i3 = i2 + 1;
                stringBuffer.append((char) Integer.parseInt((String) S4.get(i2), h.t2.b.a(16)));
                if (i3 >= size) {
                    break;
                }
                i2 = i3;
            }
        }
        return stringBuffer.toString();
    }

    @k.e.a.d
    public static final ExifInterface l(@k.e.a.d String str) {
        FileDescriptor fileDescriptor;
        if (Build.VERSION.SDK_INT >= 29) {
            if (z.j(str)) {
                ExifInterface exifInterface = null;
                AssetFileDescriptor o = z.o(Uri.parse(str), null, null, 3, null);
                if (o != null && (fileDescriptor = o.getFileDescriptor()) != null) {
                    exifInterface = new ExifInterface(fileDescriptor);
                }
                return exifInterface == null ? new ExifInterface(str) : exifInterface;
            }
            return new ExifInterface(str);
        }
        return new ExifInterface(str);
    }

    @k.e.a.d
    public static final File m(@k.e.a.d String str) {
        return new File(str);
    }

    @k.e.a.d
    public static final String n(@k.e.a.e String str) {
        return str == null ? "" : str;
    }

    @k.e.a.e
    public static final byte[] o(@k.e.a.d String str) {
        if (p(str) || str.length() % 2 != 0) {
            return null;
        }
        int length = str.length() / 2;
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[length];
        int i2 = 0;
        if (length > 0) {
            while (true) {
                int i3 = i2 + 1;
                int i4 = i2 * 2;
                bArr[i2] = (byte) (charArray[i4 + 1] | (charArray[i4] << 4));
                if (i3 >= length) {
                    break;
                }
                i2 = i3;
            }
        }
        return bArr;
    }

    @h.i(message = "", replaceWith = @q0(expression = "!isNullOrEmpty()", imports = {}))
    public static final boolean p(@k.e.a.e CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    @h.i(message = "", replaceWith = @q0(expression = "isNullOrEmpty()", imports = {}))
    public static final boolean q(@k.e.a.e CharSequence charSequence) {
        return !(charSequence == null || charSequence.length() == 0);
    }

    @k.e.a.d
    public static final String r(@k.e.a.d String str) {
        return str.toLowerCase(Locale.getDefault());
    }

    @k.e.a.d
    public static final String s(@k.e.a.d String str) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes(h.t2.d.a));
            int i2 = 0;
            int length = digest.length;
            while (i2 < length) {
                byte b2 = digest[i2];
                i2++;
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() < 2) {
                    hexString = f0.C("0", hexString);
                }
                stringBuffer.append(hexString);
            }
        } catch (Exception unused) {
            g(stringBuffer);
        }
        return stringBuffer.toString();
    }

    @k.e.a.d
    public static final String t(@k.e.a.d String str) {
        return h.t2.u.k2(str, "\n", "", false, 4, null);
    }

    @k.e.a.d
    public static final String u(@k.e.a.d String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < stringBuffer.length(); i2++) {
            char charAt = stringBuffer.charAt(i2);
            if (charAt == 12288) {
                charAt = ' ';
            } else if (65281 <= charAt && charAt <= 65374) {
                charAt = (char) (charAt - 65248);
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    @k.e.a.d
    public static final String v(@k.e.a.d String str) throws PatternSyntaxException {
        return StringsKt__StringsKt.B5(Pattern.compile("[『』]").matcher(new Regex("！").replace(new Regex("】").replace(new Regex("【").replace(str, "["), "]"), "!")).replaceAll("")).toString();
    }

    @k.e.a.d
    public static final String w(@k.e.a.d String str) {
        return f.b(str.getBytes(h.t2.d.a));
    }

    @k.e.a.d
    public static final InputStream x(@k.e.a.d String str) throws Exception {
        return new ByteArrayInputStream(str.getBytes(Charset.forName("ISO-8859-1")));
    }

    @k.e.a.d
    public static final String y(@k.e.a.d String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < stringBuffer.length(); i2++) {
            char charAt = stringBuffer.charAt(i2);
            if (charAt == ' ') {
                charAt = 12288;
            } else if ('!' <= charAt && charAt <= 127) {
                charAt = (char) (charAt + 65248);
            }
            stringBuffer.append(charAt);
        }
        return stringBuffer.toString();
    }

    @k.e.a.d
    public static final String z(@k.e.a.d String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < str.length(); i2++) {
            stringBuffer.append(f0.C("\\u", Integer.toHexString(str.charAt(i2))));
        }
        return stringBuffer.toString();
    }
}
