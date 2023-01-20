package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bo;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class ay {
    private final bu a;
    private final ch b;

    public ay() {
        this(new bo.a());
    }

    private bp j(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        this.b.a(bArr);
        int length = bcVarArr.length + 1;
        bc[] bcVarArr2 = new bc[length];
        int i2 = 0;
        bcVarArr2[0] = bcVar;
        int i3 = 0;
        while (i3 < bcVarArr.length) {
            int i4 = i3 + 1;
            bcVarArr2[i4] = bcVarArr[i3];
            i3 = i4;
        }
        this.a.j();
        bp bpVar = null;
        while (i2 < length) {
            bpVar = this.a.l();
            if (bpVar.b == 0 || bpVar.f7102c > bcVarArr2[i2].a()) {
                return null;
            }
            if (bpVar.f7102c != bcVarArr2[i2].a()) {
                bx.a(this.a, bpVar.b);
                this.a.m();
            } else {
                i2++;
                if (i2 < length) {
                    this.a.j();
                }
            }
        }
        return bpVar;
    }

    public void a(av avVar, byte[] bArr) throws bb {
        try {
            this.b.a(bArr);
            avVar.read(this.a);
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public Byte b(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Byte) a((byte) 3, bArr, bcVar, bcVarArr);
    }

    public Double c(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Double) a((byte) 4, bArr, bcVar, bcVarArr);
    }

    public Short d(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Short) a((byte) 6, bArr, bcVar, bcVarArr);
    }

    public Integer e(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Integer) a((byte) 8, bArr, bcVar, bcVarArr);
    }

    public Long f(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Long) a((byte) 10, bArr, bcVar, bcVarArr);
    }

    public String g(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (String) a((byte) 11, bArr, bcVar, bcVarArr);
    }

    public ByteBuffer h(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (ByteBuffer) a((byte) 100, bArr, bcVar, bcVarArr);
    }

    public Short i(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        Short sh;
        try {
            try {
                if (j(bArr, bcVar, bcVarArr) != null) {
                    this.a.j();
                    sh = Short.valueOf(this.a.l().f7102c);
                } else {
                    sh = null;
                }
                return sh;
            } catch (Exception e2) {
                throw new bb(e2);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public ay(bw bwVar) {
        ch chVar = new ch();
        this.b = chVar;
        this.a = bwVar.a(chVar);
    }

    public void a(av avVar, String str, String str2) throws bb {
        try {
            try {
                a(avVar, str.getBytes(str2));
            } catch (UnsupportedEncodingException unused) {
                throw new bb("JVM DOES NOT SUPPORT ENCODING: " + str2);
            }
        } finally {
            this.a.B();
        }
    }

    public void a(av avVar, byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        try {
            try {
                if (j(bArr, bcVar, bcVarArr) != null) {
                    avVar.read(this.a);
                }
            } catch (Exception e2) {
                throw new bb(e2);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public Boolean a(byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        return (Boolean) a((byte) 2, bArr, bcVar, bcVarArr);
    }

    private Object a(byte b, byte[] bArr, bc bcVar, bc... bcVarArr) throws bb {
        Object obj;
        try {
            try {
                bp j2 = j(bArr, bcVar, bcVarArr);
                if (j2 != null) {
                    if (b != 2) {
                        if (b != 3) {
                            if (b != 4) {
                                if (b != 6) {
                                    if (b != 8) {
                                        if (b != 100) {
                                            if (b != 10) {
                                                if (b == 11 && j2.b == 11) {
                                                    obj = this.a.z();
                                                }
                                            } else if (j2.b == 10) {
                                                obj = Long.valueOf(this.a.x());
                                            }
                                        } else if (j2.b == 11) {
                                            obj = this.a.A();
                                        }
                                    } else if (j2.b == 8) {
                                        obj = Integer.valueOf(this.a.w());
                                    }
                                } else if (j2.b == 6) {
                                    obj = Short.valueOf(this.a.v());
                                }
                            } else if (j2.b == 4) {
                                obj = Double.valueOf(this.a.y());
                            }
                        } else if (j2.b == 3) {
                            obj = Byte.valueOf(this.a.u());
                        }
                    } else if (j2.b == 2) {
                        obj = Boolean.valueOf(this.a.t());
                    }
                    return obj;
                }
                obj = null;
                return obj;
            } catch (Exception e2) {
                throw new bb(e2);
            }
        } finally {
            this.b.e();
            this.a.B();
        }
    }

    public void a(av avVar, String str) throws bb {
        a(avVar, str.getBytes());
    }
}
