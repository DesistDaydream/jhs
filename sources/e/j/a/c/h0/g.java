package e.j.a.c.h0;

import android.graphics.RectF;

/* loaded from: classes2.dex */
public class g {
    private static final f a = new a();
    private static final f b = new b();

    /* loaded from: classes2.dex */
    public static class a implements f {
        @Override // e.j.a.c.h0.f
        public h a(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            float p = u.p(f5, f7, f3, f4, f2, true);
            float f9 = p / f5;
            float f10 = p / f7;
            return new h(f9, f10, p, f6 * f9, p, f8 * f10);
        }

        @Override // e.j.a.c.h0.f
        public boolean b(h hVar) {
            return hVar.f10697d > hVar.f10699f;
        }

        @Override // e.j.a.c.h0.f
        public void c(RectF rectF, float f2, h hVar) {
            rectF.bottom -= Math.abs(hVar.f10699f - hVar.f10697d) * f2;
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements f {
        @Override // e.j.a.c.h0.f
        public h a(float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
            float p = u.p(f6, f8, f3, f4, f2, true);
            float f9 = p / f6;
            float f10 = p / f8;
            return new h(f9, f10, f5 * f9, p, f7 * f10, p);
        }

        @Override // e.j.a.c.h0.f
        public boolean b(h hVar) {
            return hVar.f10696c > hVar.f10698e;
        }

        @Override // e.j.a.c.h0.f
        public void c(RectF rectF, float f2, h hVar) {
            float abs = (Math.abs(hVar.f10698e - hVar.f10696c) / 2.0f) * f2;
            rectF.left += abs;
            rectF.right -= abs;
        }
    }

    private g() {
    }

    public static f a(int i2, boolean z, RectF rectF, RectF rectF2) {
        if (i2 == 0) {
            return b(z, rectF, rectF2) ? a : b;
        } else if (i2 != 1) {
            if (i2 == 2) {
                return b;
            }
            throw new IllegalArgumentException("Invalid fit mode: " + i2);
        } else {
            return a;
        }
    }

    private static boolean b(boolean z, RectF rectF, RectF rectF2) {
        float width = rectF.width();
        float height = rectF.height();
        float width2 = rectF2.width();
        float height2 = rectF2.height();
        float f2 = (height2 * width) / width2;
        float f3 = (width2 * height) / width;
        if (z) {
            if (f2 >= height) {
                return true;
            }
        } else if (f3 >= height2) {
            return true;
        }
        return false;
    }
}
