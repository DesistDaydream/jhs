package h.t2;

import java.nio.charset.Charset;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0010\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lkotlin/text/Charsets;", "", "()V", "ISO_8859_1", "Ljava/nio/charset/Charset;", "US_ASCII", "UTF_16", "UTF_16BE", "UTF_16LE", "UTF_32", "UTF32", "()Ljava/nio/charset/Charset;", "UTF_32BE", "UTF32_BE", "UTF_32LE", "UTF32_LE", "UTF_8", "utf_32", "utf_32be", "utf_32le", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes4.dex */
public final class d {

    /* renamed from: g  reason: collision with root package name */
    private static Charset f15680g;

    /* renamed from: h  reason: collision with root package name */
    private static Charset f15681h;

    /* renamed from: i  reason: collision with root package name */
    private static Charset f15682i;
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    public static final d f15683j = new d();
    @h.k2.d
    @k.e.a.d
    public static final Charset a = Charset.forName("UTF-8");
    @h.k2.d
    @k.e.a.d
    public static final Charset b = Charset.forName(k.b.a.a.c.f16034c);
    @h.k2.d
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f15676c = Charset.forName(k.b.a.a.c.f16035d);
    @h.k2.d
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f15677d = Charset.forName(k.b.a.a.c.f16036e);
    @h.k2.d
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    public static final Charset f15678e = Charset.forName(k.b.a.a.c.b);
    @h.k2.d
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    public static final Charset f15679f = Charset.forName("ISO-8859-1");

    private d() {
    }

    @h.k2.g(name = "UTF32")
    @k.e.a.d
    public final Charset a() {
        Charset charset = f15680g;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32");
        f15680g = forName;
        return forName;
    }

    @h.k2.g(name = "UTF32_BE")
    @k.e.a.d
    public final Charset b() {
        Charset charset = f15682i;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32BE");
        f15682i = forName;
        return forName;
    }

    @h.k2.g(name = "UTF32_LE")
    @k.e.a.d
    public final Charset c() {
        Charset charset = f15681h;
        if (charset != null) {
            return charset;
        }
        Charset forName = Charset.forName("UTF-32LE");
        f15681h = forName;
        return forName;
    }
}
