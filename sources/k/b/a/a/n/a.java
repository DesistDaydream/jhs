package k.b.a.a.n;

import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public abstract class a implements k.b.a.a.i {
    public boolean a(String str, String str2) throws EncoderException {
        return f(str).equals(f(str2));
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return f((String) obj);
        }
        throw new EncoderException("Parameter supplied to Caverphone encode is not of type java.lang.String");
    }
}
