package k.b.a.a.n.n;

import k.b.a.a.i;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.language.bm.NameType;
import org.apache.commons.codec.language.bm.RuleType;

/* loaded from: classes4.dex */
public class a implements i {
    private d a = new d(NameType.GENERIC, RuleType.APPROX, true);

    public NameType a() {
        return this.a.f();
    }

    public RuleType b() {
        return this.a.g();
    }

    public boolean c() {
        return this.a.h();
    }

    public void d(boolean z) {
        this.a = new d(this.a.f(), this.a.g(), z, this.a.e());
    }

    public void e(int i2) {
        this.a = new d(this.a.f(), this.a.g(), this.a.h(), i2);
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return f((String) obj);
        }
        throw new EncoderException("BeiderMorseEncoder encode parameter is not of type String");
    }

    @Override // k.b.a.a.i
    public String f(String str) throws EncoderException {
        if (str == null) {
            return null;
        }
        return this.a.b(str);
    }

    public void g(NameType nameType) {
        this.a = new d(nameType, this.a.g(), this.a.h(), this.a.e());
    }

    public void h(RuleType ruleType) {
        this.a = new d(this.a.f(), ruleType, this.a.h(), this.a.e());
    }
}
