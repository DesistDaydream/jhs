package com.xiaomi.push;

import android.os.Build;
import com.ss.android.download.api.constant.BaseConstants;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.db;
import java.io.BufferedOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.Adler32;

/* loaded from: classes3.dex */
public class et {
    public ByteBuffer a = ByteBuffer.allocate(2048);
    private ByteBuffer b = ByteBuffer.allocate(4);

    /* renamed from: c  reason: collision with root package name */
    private Adler32 f8549c = new Adler32();

    /* renamed from: d  reason: collision with root package name */
    private ex f8550d;

    /* renamed from: e  reason: collision with root package name */
    private OutputStream f8551e;

    /* renamed from: f  reason: collision with root package name */
    private int f8552f;

    /* renamed from: g  reason: collision with root package name */
    private int f8553g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f8554h;

    public et(OutputStream outputStream, ex exVar) {
        this.f8551e = new BufferedOutputStream(outputStream);
        this.f8550d = exVar;
        TimeZone timeZone = TimeZone.getDefault();
        this.f8552f = timeZone.getRawOffset() / BaseConstants.Time.HOUR;
        this.f8553g = timeZone.useDaylightTime() ? 1 : 0;
    }

    public int a(eq eqVar) {
        int l2 = eqVar.l();
        if (l2 > 32768) {
            com.xiaomi.a.a.a.c.a("Blob size=" + l2 + " should be less than 32768 Drop blob chid=" + eqVar.c() + " id=" + eqVar.h());
            return 0;
        }
        this.a.clear();
        int i2 = l2 + 8 + 4;
        if (i2 > this.a.capacity() || this.a.capacity() > 4096) {
            this.a = ByteBuffer.allocate(i2);
        }
        this.a.putShort((short) -15618);
        this.a.putShort((short) 5);
        this.a.putInt(l2);
        int position = this.a.position();
        this.a = eqVar.a(this.a);
        if (!"CONN".equals(eqVar.a())) {
            if (this.f8554h == null) {
                this.f8554h = this.f8550d.a();
            }
            com.xiaomi.push.service.as.a(this.f8554h, this.a.array(), true, position, l2);
        }
        this.f8549c.reset();
        this.f8549c.update(this.a.array(), 0, this.a.position());
        this.b.putInt(0, (int) this.f8549c.getValue());
        this.f8551e.write(this.a.array(), 0, this.a.position());
        this.f8551e.write(this.b.array(), 0, 4);
        this.f8551e.flush();
        int position2 = this.a.position() + 4;
        com.xiaomi.a.a.a.c.c("[Slim] Wrote {cmd=" + eqVar.a() + ";chid=" + eqVar.c() + ";len=" + position2 + "}");
        return position2;
    }

    public void a() {
        db.e eVar = new db.e();
        eVar.a(106);
        String str = Build.MODEL;
        eVar.a(str);
        eVar.b(jl.e());
        eVar.c(com.xiaomi.push.service.ay.e());
        eVar.b(48);
        eVar.d(this.f8550d.f());
        eVar.e(this.f8550d.e());
        eVar.f(Locale.getDefault().toString());
        int i2 = Build.VERSION.SDK_INT;
        eVar.c(i2);
        byte[] c2 = this.f8550d.d().c();
        if (c2 != null) {
            eVar.a(db.b.a(c2));
        }
        eq eqVar = new eq();
        eqVar.a(0);
        eqVar.a("CONN", (String) null);
        eqVar.a(0L, "xiaomi.com", null);
        eqVar.a(eVar.z(), (String) null);
        a(eqVar);
        com.xiaomi.a.a.a.c.a("[slim] open conn: andver=" + i2 + " sdk=48 tz=" + this.f8552f + Constants.COLON_SEPARATOR + this.f8553g + " Model=" + str + " os=" + Build.VERSION.INCREMENTAL);
    }

    public void b() {
        eq eqVar = new eq();
        eqVar.a("CLOSE", (String) null);
        a(eqVar);
        this.f8551e.close();
    }
}
