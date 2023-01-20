package k.b.a.a;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
public class d {
    @Deprecated
    public static final Charset a = StandardCharsets.ISO_8859_1;
    @Deprecated
    public static final Charset b = StandardCharsets.US_ASCII;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f16038c = StandardCharsets.UTF_16;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f16039d = StandardCharsets.UTF_16BE;
    @Deprecated

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f16040e = StandardCharsets.UTF_16LE;
    @Deprecated

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f16041f = StandardCharsets.UTF_8;

    public static Charset a(String str) {
        return str == null ? Charset.defaultCharset() : Charset.forName(str);
    }

    public static Charset b(Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }
}
