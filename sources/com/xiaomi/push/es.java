package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.db;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.zip.Adler32;

/* loaded from: classes3.dex */
public class es {
    private ByteBuffer a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: c  reason: collision with root package name */
    private Adler32 f8542c = new Adler32();

    /* renamed from: d  reason: collision with root package name */
    private ev f8543d = new ev();

    /* renamed from: e  reason: collision with root package name */
    private InputStream f8544e;

    /* renamed from: f  reason: collision with root package name */
    private ex f8545f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f8546g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f8547h;

    /* renamed from: i  reason: collision with root package name */
    private Context f8548i;

    public es(InputStream inputStream, ex exVar, Context context) {
        this.f8544e = new BufferedInputStream(inputStream);
        this.f8545f = exVar;
        this.f8548i = context;
    }

    private void a(ByteBuffer byteBuffer, int i2) {
        int position = byteBuffer.position();
        do {
            int read = this.f8544e.read(byteBuffer.array(), position, i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 -= read;
            position += read;
        } while (i2 > 0);
        byteBuffer.position(position);
    }

    private void d() {
        String str;
        StringBuilder sb;
        boolean z = false;
        this.f8546g = false;
        eq c2 = c();
        if ("CONN".equals(c2.a())) {
            db.f a = db.f.a(c2.k());
            if (a.b()) {
                this.f8545f.a(a.a());
                z = true;
            }
            if (a.e()) {
                db.b f2 = a.f();
                eq eqVar = new eq();
                eqVar.a("SYNC", "CONF");
                eqVar.a(f2.z(), (String) null);
                this.f8545f.a(eqVar);
            }
            com.xiaomi.a.a.a.c.a("[Slim] CONN: host = " + a.c());
        }
        if (!z) {
            com.xiaomi.a.a.a.c.a("[Slim] Invalid CONN");
            throw new IOException("Invalid Connection");
        }
        this.f8547h = this.f8545f.a();
        while (!this.f8546g) {
            eq c3 = c();
            this.f8545f.n();
            short m2 = c3.m();
            if (m2 != 1) {
                if (m2 != 2) {
                    if (m2 != 3) {
                        str = "[Slim] unknow blob type " + ((int) c3.m());
                        com.xiaomi.a.a.a.c.a(str);
                    } else {
                        try {
                            this.f8545f.b(this.f8543d.a(c3.k(), this.f8545f));
                        } catch (Exception e2) {
                            e = e2;
                            sb = new StringBuilder();
                            sb.append("[Slim] Parse packet from Blob chid=");
                            sb.append(c3.c());
                            sb.append("; Id=");
                            sb.append(c3.h());
                            sb.append(" failure:");
                            sb.append(e.getMessage());
                            str = sb.toString();
                            com.xiaomi.a.a.a.c.a(str);
                        }
                    }
                } else if ("SECMSG".equals(c3.a()) && ((c3.c() == 2 || c3.c() == 3) && TextUtils.isEmpty(c3.b()))) {
                    try {
                        this.f8545f.b(this.f8543d.a(c3.d(com.xiaomi.push.service.aj.a().b(Integer.valueOf(c3.c()).toString(), c3.j()).f9081i), this.f8545f));
                    } catch (Exception e3) {
                        e = e3;
                        sb = new StringBuilder();
                        sb.append("[Slim] Parse packet from Blob chid=");
                        sb.append(c3.c());
                        sb.append("; Id=");
                        sb.append(c3.h());
                        sb.append(" failure:");
                        sb.append(e.getMessage());
                        str = sb.toString();
                        com.xiaomi.a.a.a.c.a(str);
                    }
                } else if (c3.c() == 10) {
                    c3.b(10);
                    c3.f8538c.f9187c = jm.a(this.f8548i);
                    c3.f8538c.f9188d = al.f(this.f8548i);
                    c3.f8538c.f9189e = System.currentTimeMillis();
                    com.xiaomi.a.a.a.c.c("rcv blob from chid 10");
                }
            }
            this.f8545f.a(c3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.nio.ByteBuffer e() {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.es.e():java.nio.ByteBuffer");
    }

    public void a() {
        try {
            d();
        } catch (IOException e2) {
            if (!this.f8546g) {
                throw e2;
            }
        }
    }

    public void b() {
        this.f8546g = true;
    }

    public eq c() {
        int i2;
        try {
            ByteBuffer e2 = e();
            i2 = e2.position();
            try {
                e2.flip();
                e2.position(8);
                eq ewVar = i2 == 8 ? new ew() : eq.b(e2.slice());
                com.xiaomi.a.a.a.c.c("[Slim] Read {cmd=" + ewVar.a() + ";chid=" + ewVar.c() + ";len=" + i2 + "}");
                return ewVar;
            } catch (IOException e3) {
                e = e3;
                if (i2 == 0) {
                    i2 = this.a.position();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("[Slim] read Blob [");
                byte[] array = this.a.array();
                if (i2 > 128) {
                    i2 = 128;
                }
                sb.append(j.a(array, 0, i2));
                sb.append("] Err:");
                sb.append(e.getMessage());
                com.xiaomi.a.a.a.c.a(sb.toString());
                throw e;
            }
        } catch (IOException e4) {
            e = e4;
            i2 = 0;
        }
    }
}
