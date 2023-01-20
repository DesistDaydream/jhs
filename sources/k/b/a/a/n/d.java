package k.b.a.a.n;

import org.apache.commons.codec.EncoderException;

@Deprecated
/* loaded from: classes4.dex */
public class d implements k.b.a.a.i {
    private final c a = new c();

    public String a(String str) {
        return this.a.f(str);
    }

    public boolean b(String str, String str2) {
        return a(str).equals(a(str2));
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return a((String) obj);
        }
        throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }

    @Override // k.b.a.a.i
    public String f(String str) {
        return a(str);
    }
}
