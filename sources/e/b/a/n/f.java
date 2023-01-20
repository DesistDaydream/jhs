package e.b.a.n;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.n.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* loaded from: classes.dex */
public class f implements a {
    private static final String A = "f";
    private static final int B = 4096;
    private static final int C = -1;
    private static final int D = -1;
    private static final int E = 4;
    private static final int F = 255;
    @ColorInt
    private static final int G = 0;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    private int[] f9430f;
    @ColorInt

    /* renamed from: g  reason: collision with root package name */
    private final int[] f9431g;

    /* renamed from: h  reason: collision with root package name */
    private final a.InterfaceC0304a f9432h;

    /* renamed from: i  reason: collision with root package name */
    private ByteBuffer f9433i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f9434j;

    /* renamed from: k  reason: collision with root package name */
    private d f9435k;

    /* renamed from: l  reason: collision with root package name */
    private short[] f9436l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f9437m;
    private byte[] n;
    private byte[] o;
    @ColorInt
    private int[] p;
    private int q;
    private c r;
    private Bitmap s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private int x;
    @Nullable
    private Boolean y;
    @NonNull
    private Bitmap.Config z;

    public f(@NonNull a.InterfaceC0304a interfaceC0304a, c cVar, ByteBuffer byteBuffer) {
        this(interfaceC0304a, cVar, byteBuffer, 1);
    }

    @ColorInt
    private int q(int i2, int i3, int i4) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = i2; i10 < this.v + i2; i10++) {
            byte[] bArr = this.o;
            if (i10 >= bArr.length || i10 >= i3) {
                break;
            }
            int i11 = this.f9430f[bArr[i10] & 255];
            if (i11 != 0) {
                i5 += (i11 >> 24) & 255;
                i6 += (i11 >> 16) & 255;
                i7 += (i11 >> 8) & 255;
                i8 += i11 & 255;
                i9++;
            }
        }
        int i12 = i2 + i4;
        for (int i13 = i12; i13 < this.v + i12; i13++) {
            byte[] bArr2 = this.o;
            if (i13 >= bArr2.length || i13 >= i3) {
                break;
            }
            int i14 = this.f9430f[bArr2[i13] & 255];
            if (i14 != 0) {
                i5 += (i14 >> 24) & 255;
                i6 += (i14 >> 16) & 255;
                i7 += (i14 >> 8) & 255;
                i8 += i14 & 255;
                i9++;
            }
        }
        if (i9 == 0) {
            return 0;
        }
        return ((i5 / i9) << 24) | ((i6 / i9) << 16) | ((i7 / i9) << 8) | (i8 / i9);
    }

    private void r(b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        Boolean bool = Boolean.TRUE;
        int[] iArr = this.p;
        int i6 = bVar.f9400d;
        int i7 = this.v;
        int i8 = i6 / i7;
        int i9 = bVar.b / i7;
        int i10 = bVar.f9399c / i7;
        int i11 = bVar.a / i7;
        boolean z = this.q == 0;
        int i12 = this.x;
        int i13 = this.w;
        byte[] bArr = this.o;
        int[] iArr2 = this.f9430f;
        Boolean bool2 = this.y;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i16 < i8) {
            Boolean bool3 = bool2;
            if (bVar.f9401e) {
                if (i15 >= i8) {
                    int i18 = i15;
                    int i19 = i17 + 1;
                    if (i19 == 2) {
                        i17 = i19;
                        i15 = 4;
                    } else if (i19 == 3) {
                        i17 = i19;
                        i15 = 2;
                        i14 = 4;
                    } else if (i19 != 4) {
                        i17 = i19;
                        i15 = i18;
                    } else {
                        i17 = i19;
                        i15 = 1;
                        i14 = 2;
                    }
                }
                i2 = i15 + i14;
            } else {
                i2 = i15;
                i15 = i16;
            }
            int i20 = i15 + i9;
            boolean z2 = i7 == 1;
            if (i20 < i13) {
                int i21 = i20 * i12;
                int i22 = i21 + i11;
                int i23 = i22 + i10;
                int i24 = i21 + i12;
                if (i24 < i23) {
                    i23 = i24;
                }
                i3 = i8;
                int i25 = i16 * i7 * bVar.f9399c;
                if (z2) {
                    int i26 = i22;
                    while (i26 < i23) {
                        int i27 = i9;
                        int i28 = iArr2[bArr[i25] & 255];
                        if (i28 != 0) {
                            iArr[i26] = i28;
                        } else if (z && bool3 == null) {
                            bool3 = bool;
                        }
                        i25 += i7;
                        i26++;
                        i9 = i27;
                    }
                } else {
                    i5 = i9;
                    int i29 = ((i23 - i22) * i7) + i25;
                    int i30 = i22;
                    while (true) {
                        i4 = i10;
                        if (i30 < i23) {
                            int q = q(i25, i29, bVar.f9399c);
                            if (q != 0) {
                                iArr[i30] = q;
                            } else if (z && bool3 == null) {
                                bool3 = bool;
                            }
                            i25 += i7;
                            i30++;
                            i10 = i4;
                        }
                    }
                    bool2 = bool3;
                    i16++;
                    i9 = i5;
                    i10 = i4;
                    i15 = i2;
                    i8 = i3;
                }
            } else {
                i3 = i8;
            }
            i5 = i9;
            i4 = i10;
            bool2 = bool3;
            i16++;
            i9 = i5;
            i10 = i4;
            i15 = i2;
            i8 = i3;
        }
        Boolean bool4 = bool2;
        if (this.y == null) {
            this.y = Boolean.valueOf(bool4 == null ? false : bool4.booleanValue());
        }
    }

    private void s(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.p;
        int i2 = bVar2.f9400d;
        int i3 = bVar2.b;
        int i4 = bVar2.f9399c;
        int i5 = bVar2.a;
        boolean z = this.q == 0;
        int i6 = this.x;
        byte[] bArr = this.o;
        int[] iArr2 = this.f9430f;
        int i7 = 0;
        byte b = -1;
        while (i7 < i2) {
            int i8 = (i7 + i3) * i6;
            int i9 = i8 + i5;
            int i10 = i9 + i4;
            int i11 = i8 + i6;
            if (i11 < i10) {
                i10 = i11;
            }
            int i12 = bVar2.f9399c * i7;
            int i13 = i9;
            while (i13 < i10) {
                byte b2 = bArr[i12];
                int i14 = i2;
                int i15 = b2 & 255;
                if (i15 != b) {
                    int i16 = iArr2[i15];
                    if (i16 != 0) {
                        iArr[i13] = i16;
                    } else {
                        b = b2;
                    }
                }
                i12++;
                i13++;
                i2 = i14;
            }
            i7++;
            bVar2 = bVar;
        }
        Boolean bool = this.y;
        this.y = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.y == null && z && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void t(b bVar) {
        int i2;
        int i3;
        short s;
        f fVar = this;
        if (bVar != null) {
            fVar.f9433i.position(bVar.f9406j);
        }
        if (bVar == null) {
            c cVar = fVar.r;
            i2 = cVar.f9411f;
            i3 = cVar.f9412g;
        } else {
            i2 = bVar.f9399c;
            i3 = bVar.f9400d;
        }
        int i4 = i2 * i3;
        byte[] bArr = fVar.o;
        if (bArr == null || bArr.length < i4) {
            fVar.o = fVar.f9432h.b(i4);
        }
        byte[] bArr2 = fVar.o;
        if (fVar.f9436l == null) {
            fVar.f9436l = new short[4096];
        }
        short[] sArr = fVar.f9436l;
        if (fVar.f9437m == null) {
            fVar.f9437m = new byte[4096];
        }
        byte[] bArr3 = fVar.f9437m;
        if (fVar.n == null) {
            fVar.n = new byte[4097];
        }
        byte[] bArr4 = fVar.n;
        int x = x();
        int i5 = 1 << x;
        int i6 = i5 + 1;
        int i7 = i5 + 2;
        int i8 = x + 1;
        int i9 = (1 << i8) - 1;
        int i10 = 0;
        for (int i11 = 0; i11 < i5; i11++) {
            sArr[i11] = 0;
            bArr3[i11] = (byte) i11;
        }
        byte[] bArr5 = fVar.f9434j;
        int i12 = i8;
        int i13 = i7;
        int i14 = i9;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        int i21 = 0;
        int i22 = 0;
        while (true) {
            if (i10 >= i4) {
                break;
            }
            if (i15 == 0) {
                i15 = w();
                if (i15 <= 0) {
                    fVar.u = 3;
                    break;
                }
                i16 = 0;
            }
            i18 += (bArr5[i16] & 255) << i17;
            i16++;
            i15--;
            int i23 = i17 + 8;
            int i24 = i13;
            int i25 = i12;
            int i26 = i20;
            int i27 = i8;
            int i28 = i21;
            while (true) {
                if (i23 < i25) {
                    i20 = i26;
                    i13 = i24;
                    i17 = i23;
                    fVar = this;
                    i21 = i28;
                    i8 = i27;
                    i12 = i25;
                    break;
                }
                int i29 = i7;
                int i30 = i18 & i14;
                i18 >>= i25;
                i23 -= i25;
                if (i30 == i5) {
                    i14 = i9;
                    i25 = i27;
                    i24 = i29;
                    i7 = i24;
                    i26 = -1;
                } else if (i30 == i6) {
                    i17 = i23;
                    i21 = i28;
                    i13 = i24;
                    i8 = i27;
                    i7 = i29;
                    i20 = i26;
                    i12 = i25;
                    fVar = this;
                    break;
                } else if (i26 == -1) {
                    bArr2[i19] = bArr3[i30];
                    i19++;
                    i10++;
                    i26 = i30;
                    i28 = i26;
                    i7 = i29;
                    i23 = i23;
                } else {
                    if (i30 >= i24) {
                        bArr4[i22] = (byte) i28;
                        i22++;
                        s = i26;
                    } else {
                        s = i30;
                    }
                    while (s >= i5) {
                        bArr4[i22] = bArr3[s];
                        i22++;
                        s = sArr[s];
                    }
                    i28 = bArr3[s] & 255;
                    byte b = (byte) i28;
                    bArr2[i19] = b;
                    while (true) {
                        i19++;
                        i10++;
                        if (i22 <= 0) {
                            break;
                        }
                        i22--;
                        bArr2[i19] = bArr4[i22];
                    }
                    byte[] bArr6 = bArr4;
                    if (i24 < 4096) {
                        sArr[i24] = (short) i26;
                        bArr3[i24] = b;
                        i24++;
                        if ((i24 & i14) == 0 && i24 < 4096) {
                            i25++;
                            i14 += i24;
                        }
                    }
                    i26 = i30;
                    i7 = i29;
                    i23 = i23;
                    bArr4 = bArr6;
                }
            }
        }
        Arrays.fill(bArr2, i19, i4, (byte) 0);
    }

    @NonNull
    private d u() {
        if (this.f9435k == null) {
            this.f9435k = new d();
        }
        return this.f9435k;
    }

    private Bitmap v() {
        Boolean bool = this.y;
        Bitmap c2 = this.f9432h.c(this.x, this.w, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.z);
        c2.setHasAlpha(true);
        return c2;
    }

    private int w() {
        int x = x();
        if (x <= 0) {
            return x;
        }
        ByteBuffer byteBuffer = this.f9433i;
        byteBuffer.get(this.f9434j, 0, Math.min(x, byteBuffer.remaining()));
        return x;
    }

    private int x() {
        return this.f9433i.get() & 255;
    }

    private Bitmap y(b bVar, b bVar2) {
        int i2;
        int i3;
        Bitmap bitmap;
        int[] iArr = this.p;
        int i4 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.s;
            if (bitmap2 != null) {
                this.f9432h.a(bitmap2);
            }
            this.s = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f9403g == 3 && this.s == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i3 = bVar2.f9403g) > 0) {
            if (i3 == 2) {
                if (!bVar.f9402f) {
                    c cVar = this.r;
                    int i5 = cVar.f9417l;
                    if (bVar.f9407k == null || cVar.f9415j != bVar.f9404h) {
                        i4 = i5;
                    }
                }
                int i6 = bVar2.f9400d;
                int i7 = this.v;
                int i8 = i6 / i7;
                int i9 = bVar2.b / i7;
                int i10 = bVar2.f9399c / i7;
                int i11 = bVar2.a / i7;
                int i12 = this.x;
                int i13 = (i9 * i12) + i11;
                int i14 = (i8 * i12) + i13;
                while (i13 < i14) {
                    int i15 = i13 + i10;
                    for (int i16 = i13; i16 < i15; i16++) {
                        iArr[i16] = i4;
                    }
                    i13 += this.x;
                }
            } else if (i3 == 3 && (bitmap = this.s) != null) {
                int i17 = this.x;
                bitmap.getPixels(iArr, 0, i17, 0, 0, i17, this.w);
            }
        }
        t(bVar);
        if (!bVar.f9401e && this.v == 1) {
            s(bVar);
        } else {
            r(bVar);
        }
        if (this.t && ((i2 = bVar.f9403g) == 0 || i2 == 1)) {
            if (this.s == null) {
                this.s = v();
            }
            Bitmap bitmap3 = this.s;
            int i18 = this.x;
            bitmap3.setPixels(iArr, 0, i18, 0, 0, i18, this.w);
        }
        Bitmap v = v();
        int i19 = this.x;
        v.setPixels(iArr, 0, i19, 0, 0, i19, this.w);
        return v;
    }

    @Override // e.b.a.n.a
    @Nullable
    public synchronized Bitmap a() {
        if (this.r.f9408c <= 0 || this.q < 0) {
            String str = A;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.r.f9408c + ", framePointer=" + this.q);
            }
            this.u = 1;
        }
        int i2 = this.u;
        if (i2 != 1 && i2 != 2) {
            this.u = 0;
            if (this.f9434j == null) {
                this.f9434j = this.f9432h.b(255);
            }
            b bVar = this.r.f9410e.get(this.q);
            int i3 = this.q - 1;
            b bVar2 = i3 >= 0 ? this.r.f9410e.get(i3) : null;
            int[] iArr = bVar.f9407k;
            if (iArr == null) {
                iArr = this.r.a;
            }
            this.f9430f = iArr;
            if (iArr == null) {
                String str2 = A;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.q);
                }
                this.u = 1;
                return null;
            }
            if (bVar.f9402f) {
                System.arraycopy(iArr, 0, this.f9431g, 0, iArr.length);
                int[] iArr2 = this.f9431g;
                this.f9430f = iArr2;
                iArr2[bVar.f9404h] = 0;
                if (bVar.f9403g == 2 && this.q == 0) {
                    this.y = Boolean.TRUE;
                }
            }
            return y(bVar, bVar2);
        }
        String str3 = A;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.u);
        }
        return null;
    }

    @Override // e.b.a.n.a
    public void b() {
        this.q = (this.q + 1) % this.r.f9408c;
    }

    @Override // e.b.a.n.a
    public int c() {
        return this.r.f9408c;
    }

    @Override // e.b.a.n.a
    public void clear() {
        this.r = null;
        byte[] bArr = this.o;
        if (bArr != null) {
            this.f9432h.e(bArr);
        }
        int[] iArr = this.p;
        if (iArr != null) {
            this.f9432h.f(iArr);
        }
        Bitmap bitmap = this.s;
        if (bitmap != null) {
            this.f9432h.a(bitmap);
        }
        this.s = null;
        this.f9433i = null;
        this.y = null;
        byte[] bArr2 = this.f9434j;
        if (bArr2 != null) {
            this.f9432h.e(bArr2);
        }
    }

    @Override // e.b.a.n.a
    public void d(@NonNull Bitmap.Config config) {
        if (config != Bitmap.Config.ARGB_8888 && config != Bitmap.Config.RGB_565) {
            throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
        }
        this.z = config;
    }

    @Override // e.b.a.n.a
    public int e(int i2) {
        if (i2 >= 0) {
            c cVar = this.r;
            if (i2 < cVar.f9408c) {
                return cVar.f9410e.get(i2).f9405i;
            }
        }
        return -1;
    }

    @Override // e.b.a.n.a
    public int f() {
        int i2 = this.r.f9418m;
        if (i2 == -1) {
            return 1;
        }
        if (i2 == 0) {
            return 0;
        }
        return i2 + 1;
    }

    @Override // e.b.a.n.a
    @Deprecated
    public int g() {
        int i2 = this.r.f9418m;
        if (i2 == -1) {
            return 1;
        }
        return i2;
    }

    @Override // e.b.a.n.a
    @NonNull
    public ByteBuffer getData() {
        return this.f9433i;
    }

    @Override // e.b.a.n.a
    public int getHeight() {
        return this.r.f9412g;
    }

    @Override // e.b.a.n.a
    public int getStatus() {
        return this.u;
    }

    @Override // e.b.a.n.a
    public int getWidth() {
        return this.r.f9411f;
    }

    @Override // e.b.a.n.a
    public synchronized void h(@NonNull c cVar, @NonNull byte[] bArr) {
        k(cVar, ByteBuffer.wrap(bArr));
    }

    @Override // e.b.a.n.a
    public int i() {
        int i2;
        if (this.r.f9408c <= 0 || (i2 = this.q) < 0) {
            return 0;
        }
        return e(i2);
    }

    @Override // e.b.a.n.a
    public void j() {
        this.q = -1;
    }

    @Override // e.b.a.n.a
    public synchronized void k(@NonNull c cVar, @NonNull ByteBuffer byteBuffer) {
        m(cVar, byteBuffer, 1);
    }

    @Override // e.b.a.n.a
    public int l() {
        return this.q;
    }

    @Override // e.b.a.n.a
    public synchronized void m(@NonNull c cVar, @NonNull ByteBuffer byteBuffer, int i2) {
        if (i2 > 0) {
            int highestOneBit = Integer.highestOneBit(i2);
            this.u = 0;
            this.r = cVar;
            this.q = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f9433i = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f9433i.order(ByteOrder.LITTLE_ENDIAN);
            this.t = false;
            Iterator<b> it = cVar.f9410e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f9403g == 3) {
                    this.t = true;
                    break;
                }
            }
            this.v = highestOneBit;
            int i3 = cVar.f9411f;
            this.x = i3 / highestOneBit;
            int i4 = cVar.f9412g;
            this.w = i4 / highestOneBit;
            this.o = this.f9432h.b(i3 * i4);
            this.p = this.f9432h.d(this.x * this.w);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i2);
        }
    }

    @Override // e.b.a.n.a
    public int n() {
        return this.r.f9418m;
    }

    @Override // e.b.a.n.a
    public int o(@Nullable InputStream inputStream, int i2) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i2 > 0 ? i2 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException e2) {
                Log.w(A, "Error reading data from stream", e2);
            }
        } else {
            this.u = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                Log.w(A, "Error closing stream", e3);
            }
        }
        return this.u;
    }

    @Override // e.b.a.n.a
    public int p() {
        return this.f9433i.limit() + this.o.length + (this.p.length * 4);
    }

    @Override // e.b.a.n.a
    public synchronized int read(@Nullable byte[] bArr) {
        c d2 = u().r(bArr).d();
        this.r = d2;
        if (bArr != null) {
            h(d2, bArr);
        }
        return this.u;
    }

    public f(@NonNull a.InterfaceC0304a interfaceC0304a, c cVar, ByteBuffer byteBuffer, int i2) {
        this(interfaceC0304a);
        m(cVar, byteBuffer, i2);
    }

    public f(@NonNull a.InterfaceC0304a interfaceC0304a) {
        this.f9431g = new int[256];
        this.z = Bitmap.Config.ARGB_8888;
        this.f9432h = interfaceC0304a;
        this.r = new c();
    }
}
