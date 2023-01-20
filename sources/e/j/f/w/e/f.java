package e.j.f.w.e;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import e.j.f.w.c.g;

/* loaded from: classes2.dex */
public final class f {

    /* renamed from: f  reason: collision with root package name */
    public static final int f11770f = 8;
    private Mode a;
    private ErrorCorrectionLevel b;

    /* renamed from: c  reason: collision with root package name */
    private g f11771c;

    /* renamed from: d  reason: collision with root package name */
    private int f11772d = -1;

    /* renamed from: e  reason: collision with root package name */
    private b f11773e;

    public static boolean f(int i2) {
        return i2 >= 0 && i2 < 8;
    }

    public ErrorCorrectionLevel a() {
        return this.b;
    }

    public int b() {
        return this.f11772d;
    }

    public b c() {
        return this.f11773e;
    }

    public Mode d() {
        return this.a;
    }

    public g e() {
        return this.f11771c;
    }

    public void g(ErrorCorrectionLevel errorCorrectionLevel) {
        this.b = errorCorrectionLevel;
    }

    public void h(int i2) {
        this.f11772d = i2;
    }

    public void i(b bVar) {
        this.f11773e = bVar;
    }

    public void j(Mode mode) {
        this.a = mode;
    }

    public void k(g gVar) {
        this.f11771c = gVar;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(200);
        sb.append("<<\n");
        sb.append(" mode: ");
        sb.append(this.a);
        sb.append("\n ecLevel: ");
        sb.append(this.b);
        sb.append("\n version: ");
        sb.append(this.f11771c);
        sb.append("\n maskPattern: ");
        sb.append(this.f11772d);
        if (this.f11773e == null) {
            sb.append("\n matrix: null\n");
        } else {
            sb.append("\n matrix:\n");
            sb.append(this.f11773e);
        }
        sb.append(">>\n");
        return sb.toString();
    }
}
