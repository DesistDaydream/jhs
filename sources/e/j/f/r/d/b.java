package e.j.f.r.d;

import androidx.core.view.InputDeviceCompat;

/* loaded from: classes2.dex */
public final class b implements g {
    private static char c(char c2, int i2) {
        int i3 = c2 + ((i2 * 149) % 255) + 1;
        return i3 <= 255 ? (char) i3 : (char) (i3 + InputDeviceCompat.SOURCE_ANY);
    }

    @Override // e.j.f.r.d.g
    public void a(h hVar) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) 0);
        while (true) {
            if (!hVar.j()) {
                break;
            }
            sb.append(hVar.d());
            hVar.f11521f++;
            if (j.o(hVar.e(), hVar.f11521f, b()) != b()) {
                hVar.p(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int a = hVar.a() + length + 1;
        hVar.r(a);
        boolean z = hVar.h().b() - a > 0;
        if (hVar.j() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = sb.length();
        for (int i2 = 0; i2 < length2; i2++) {
            hVar.s(c(sb.charAt(i2), hVar.a() + 1));
        }
    }

    @Override // e.j.f.r.d.g
    public int b() {
        return 5;
    }
}
