package k.b.a.a.o;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import k.b.a.a.h;
import k.b.a.a.i;
import k.b.a.a.k.j;
import org.apache.commons.codec.CodecPolicy;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class a extends e implements i, h {

    /* renamed from: f  reason: collision with root package name */
    private static final CodecPolicy f16225f = CodecPolicy.LENIENT;

    /* renamed from: d  reason: collision with root package name */
    private final Charset f16226d;

    /* renamed from: e  reason: collision with root package name */
    private final CodecPolicy f16227e;

    public a() {
        this(StandardCharsets.UTF_8);
    }

    @Override // k.b.a.a.o.e
    public byte[] b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return new k.b.a.a.k.g(0, j.n(), false, this.f16227e).decode(bArr);
    }

    @Override // k.b.a.a.o.e
    public byte[] c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return k.b.a.a.k.g.C(bArr);
    }

    @Override // k.b.a.a.e
    public Object decode(Object obj) throws DecoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return e((String) obj);
        }
        throw new DecoderException("Objects of type " + obj.getClass().getName() + " cannot be decoded using BCodec");
    }

    @Override // k.b.a.a.h
    public String e(String str) throws DecoderException {
        if (str == null) {
            return null;
        }
        try {
            return a(str);
        } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
            throw new DecoderException(e2.getMessage(), e2);
        }
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return f((String) obj);
        }
        throw new EncoderException("Objects of type " + obj.getClass().getName() + " cannot be encoded using BCodec");
    }

    @Override // k.b.a.a.i
    public String f(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        return j(str, k());
    }

    @Override // k.b.a.a.o.e
    public String h() {
        return "B";
    }

    public String i(String str, String str2) throws EncoderException {
        if (str == null) {
            return null;
        }
        try {
            return d(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new EncoderException(e2.getMessage(), e2);
        }
    }

    public String j(String str, Charset charset) throws EncoderException {
        if (str == null) {
            return null;
        }
        return g(str, charset);
    }

    public Charset k() {
        return this.f16226d;
    }

    public String l() {
        return this.f16226d.name();
    }

    public boolean m() {
        return this.f16227e == CodecPolicy.STRICT;
    }

    public a(Charset charset) {
        this(charset, f16225f);
    }

    public a(Charset charset, CodecPolicy codecPolicy) {
        this.f16226d = charset;
        this.f16227e = codecPolicy;
    }

    public a(String str) {
        this(Charset.forName(str));
    }
}
