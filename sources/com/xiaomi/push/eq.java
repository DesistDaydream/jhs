package com.xiaomi.push;

import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.db;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public class eq {

    /* renamed from: d  reason: collision with root package name */
    private static String f8535d = ge.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: e  reason: collision with root package name */
    private static long f8536e = 0;

    /* renamed from: h  reason: collision with root package name */
    private static final byte[] f8537h = new byte[0];
    public String a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public com.xiaomi.push.service.q f8538c;

    /* renamed from: f  reason: collision with root package name */
    private db.a f8539f;

    /* renamed from: g  reason: collision with root package name */
    private short f8540g;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f8541i;

    public eq() {
        this.f8540g = (short) 2;
        this.f8541i = f8537h;
        this.a = null;
        this.f8538c = null;
        this.f8539f = new db.a();
        this.b = 1;
    }

    public eq(db.a aVar, short s, byte[] bArr) {
        this.f8540g = (short) 2;
        this.f8541i = f8537h;
        this.a = null;
        this.f8538c = null;
        this.f8539f = aVar;
        this.f8540g = s;
        this.f8541i = bArr;
        this.b = 2;
    }

    @Deprecated
    public static eq a(ft ftVar, String str) {
        int i2;
        eq eqVar = new eq();
        try {
            i2 = Integer.parseInt(ftVar.l());
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("Blob parse chid err " + e2.getMessage());
            i2 = 1;
        }
        eqVar.a(i2);
        eqVar.a(ftVar.k());
        eqVar.c(ftVar.n());
        eqVar.b(ftVar.o());
        eqVar.a("XMLMSG", (String) null);
        try {
            eqVar.a(ftVar.c().getBytes("utf8"), str);
            if (TextUtils.isEmpty(str)) {
                eqVar.a((short) 3);
            } else {
                eqVar.a((short) 2);
                eqVar.a("SECMSG", (String) null);
            }
        } catch (UnsupportedEncodingException e3) {
            com.xiaomi.a.a.a.c.a("Blob setPayload err： " + e3.getMessage());
        }
        return eqVar;
    }

    public static eq b(ByteBuffer byteBuffer) {
        try {
            ByteBuffer slice = byteBuffer.slice();
            short s = slice.getShort(0);
            short s2 = slice.getShort(2);
            int i2 = slice.getInt(4);
            db.a aVar = new db.a();
            aVar.b(slice.array(), slice.arrayOffset() + 8, s2);
            byte[] bArr = new byte[i2];
            slice.position(s2 + 8);
            slice.get(bArr, 0, i2);
            return new eq(aVar, s, bArr);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("read Blob err :" + e2.getMessage());
            throw new IOException("Malformed Input");
        }
    }

    public static synchronized String g() {
        String sb;
        synchronized (eq.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(f8535d);
            long j2 = f8536e;
            f8536e = 1 + j2;
            sb2.append(Long.toString(j2));
            sb = sb2.toString();
        }
        return sb;
    }

    public String a() {
        return this.f8539f.i();
    }

    public ByteBuffer a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            byteBuffer = ByteBuffer.allocate(l());
        }
        byteBuffer.putShort(this.f8540g);
        byteBuffer.putShort((short) this.f8539f.k());
        byteBuffer.putInt(this.f8541i.length);
        int position = byteBuffer.position();
        this.f8539f.a(byteBuffer.array(), byteBuffer.arrayOffset() + position, this.f8539f.k());
        byteBuffer.position(position + this.f8539f.k());
        byteBuffer.put(this.f8541i);
        return byteBuffer;
    }

    public void a(int i2) {
        this.f8539f.a(i2);
    }

    public void a(long j2, String str, String str2) {
        if (j2 != 0) {
            this.f8539f.a(j2);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f8539f.a(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f8539f.b(str2);
    }

    public void a(String str) {
        this.f8539f.e(str);
    }

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("command should not be empty");
        }
        this.f8539f.c(str);
        this.f8539f.o();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f8539f.d(str2);
    }

    public void a(short s) {
        this.f8540g = s;
    }

    public void a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            this.f8539f.c(0);
            this.f8541i = bArr;
            return;
        }
        this.f8539f.c(1);
        this.f8541i = com.xiaomi.push.service.as.a(com.xiaomi.push.service.as.a(str, h()), bArr);
    }

    public String b() {
        return this.f8539f.m();
    }

    public void b(int i2) {
        com.xiaomi.push.service.q qVar = new com.xiaomi.push.service.q();
        this.f8538c = qVar;
        qVar.a = i2;
    }

    public void b(String str) {
        this.a = str;
    }

    public int c() {
        return this.f8539f.a();
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int indexOf = str.indexOf(TIMMentionEditText.TIM_MENTION_TAG);
        try {
            long parseLong = Long.parseLong(str.substring(0, indexOf));
            int indexOf2 = str.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR, indexOf);
            String substring = str.substring(indexOf + 1, indexOf2);
            String substring2 = str.substring(indexOf2 + 1);
            this.f8539f.a(parseLong);
            this.f8539f.a(substring);
            this.f8539f.b(substring2);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("Blob parse user err " + e2.getMessage());
        }
    }

    public boolean d() {
        return this.f8539f.w();
    }

    public byte[] d(String str) {
        if (this.f8539f.t() == 1) {
            return er.a(this, com.xiaomi.push.service.as.a(com.xiaomi.push.service.as.a(str, h()), this.f8541i));
        }
        if (this.f8539f.t() == 0) {
            return er.a(this, this.f8541i);
        }
        com.xiaomi.a.a.a.c.a("unknow cipher = " + this.f8539f.t());
        return er.a(this, this.f8541i);
    }

    public int e() {
        return this.f8539f.v();
    }

    public String f() {
        return this.f8539f.x();
    }

    public String h() {
        String p = this.f8539f.p();
        if ("ID_NOT_AVAILABLE".equals(p)) {
            return null;
        }
        if (this.f8539f.q()) {
            return p;
        }
        String g2 = g();
        this.f8539f.e(g2);
        return g2;
    }

    public String i() {
        return this.a;
    }

    public String j() {
        if (this.f8539f.d()) {
            return Long.toString(this.f8539f.c()) + TIMMentionEditText.TIM_MENTION_TAG + this.f8539f.e() + MqttTopic.TOPIC_LEVEL_SEPARATOR + this.f8539f.g();
        }
        return null;
    }

    public byte[] k() {
        return er.a(this, this.f8541i);
    }

    public int l() {
        return this.f8539f.l() + 8 + this.f8541i.length;
    }

    public short m() {
        return this.f8540g;
    }

    public String toString() {
        return "Blob [chid=" + c() + "; Id=" + com.xiaomi.push.service.ag.a(h()) + "; cmd=" + a() + "; type=" + ((int) m()) + "; from=" + j() + " ]";
    }
}
