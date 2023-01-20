package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import com.baidu.mobads.sdk.internal.ca;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.moor.imkf.event.VoiceToTextEvent;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.android.tpush.common.MessageKey;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class d {
    public static final c[] a;
    public static final Map<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f, Integer> b;

    /* loaded from: classes.dex */
    public static final class a {
        private final List<c> a;
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e b;

        /* renamed from: c  reason: collision with root package name */
        private final int f426c;

        /* renamed from: d  reason: collision with root package name */
        private int f427d;

        /* renamed from: e  reason: collision with root package name */
        public c[] f428e;

        /* renamed from: f  reason: collision with root package name */
        public int f429f;

        /* renamed from: g  reason: collision with root package name */
        public int f430g;

        /* renamed from: h  reason: collision with root package name */
        public int f431h;

        public a(int i2, int i3, s sVar) {
            this.a = new ArrayList();
            c[] cVarArr = new c[8];
            this.f428e = cVarArr;
            this.f429f = cVarArr.length - 1;
            this.f430g = 0;
            this.f431h = 0;
            this.f426c = i2;
            this.f427d = i3;
            this.b = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l.a(sVar);
        }

        public a(int i2, s sVar) {
            this(i2, i2, sVar);
        }

        private int a(int i2) {
            return this.f429f + 1 + i2;
        }

        private void a(int i2, c cVar) {
            this.a.add(cVar);
            int i3 = cVar.f425c;
            if (i2 != -1) {
                i3 -= this.f428e[a(i2)].f425c;
            }
            int i4 = this.f427d;
            if (i3 > i4) {
                e();
                return;
            }
            int b = b((this.f431h + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f430g;
                c[] cVarArr = this.f428e;
                if (i5 + 1 > cVarArr.length) {
                    c[] cVarArr2 = new c[cVarArr.length * 2];
                    System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                    this.f429f = this.f428e.length - 1;
                    this.f428e = cVarArr2;
                }
                int i6 = this.f429f;
                this.f429f = i6 - 1;
                this.f428e[i6] = cVar;
                this.f430g++;
            } else {
                this.f428e[b + a(i2) + i2] = cVar;
            }
            this.f431h = i3 + this.f431h;
        }

        private int b(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f428e.length;
                while (true) {
                    length--;
                    i3 = this.f429f;
                    if (length < i3 || i2 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f428e;
                    i2 -= cVarArr[length].f425c;
                    this.f431h -= cVarArr[length].f425c;
                    this.f430g--;
                    i4++;
                }
                c[] cVarArr2 = this.f428e;
                int i5 = i3 + 1;
                System.arraycopy(cVarArr2, i5, cVarArr2, i5 + i4, this.f430g);
                this.f429f += i4;
            }
            return i4;
        }

        private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f c(int i2) {
            return (d(i2) ? d.a[i2] : this.f428e[a(i2 - d.a.length)]).a;
        }

        private void d() {
            int i2 = this.f427d;
            int i3 = this.f431h;
            if (i2 < i3) {
                if (i2 == 0) {
                    e();
                } else {
                    b(i3 - i2);
                }
            }
        }

        private boolean d(int i2) {
            return i2 >= 0 && i2 <= d.a.length - 1;
        }

        private void e() {
            Arrays.fill(this.f428e, (Object) null);
            this.f429f = this.f428e.length - 1;
            this.f430g = 0;
            this.f431h = 0;
        }

        private void e(int i2) throws IOException {
            if (d(i2)) {
                this.a.add(d.a[i2]);
                return;
            }
            int a = a(i2 - d.a.length);
            if (a >= 0) {
                c[] cVarArr = this.f428e;
                if (a <= cVarArr.length - 1) {
                    this.a.add(cVarArr[a]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i2 + 1));
        }

        private int f() throws IOException {
            return this.b.readByte() & 255;
        }

        private void f(int i2) throws IOException {
            a(-1, new c(c(i2), b()));
        }

        private void g() throws IOException {
            a(-1, new c(d.a(b()), b()));
        }

        private void g(int i2) throws IOException {
            this.a.add(new c(c(i2), b()));
        }

        private void h() throws IOException {
            this.a.add(new c(d.a(b()), b()));
        }

        public int a(int i2, int i3) throws IOException {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int f2 = f();
                if ((f2 & 128) == 0) {
                    return (f2 << i5) + i3;
                }
                i3 += (f2 & 127) << i5;
                i5 += 7;
            }
        }

        public List<c> a() {
            ArrayList arrayList = new ArrayList(this.a);
            this.a.clear();
            return arrayList;
        }

        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f b() throws IOException {
            int f2 = f();
            boolean z = (f2 & 128) == 128;
            int a = a(f2, 127);
            return z ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.a(k.b().a(this.b.d(a))) : this.b.b(a);
        }

        public void c() throws IOException {
            while (!this.b.f()) {
                int readByte = this.b.readByte() & 255;
                if (readByte == 128) {
                    throw new IOException("index == 0");
                }
                if ((readByte & 128) == 128) {
                    e(a(readByte, 127) - 1);
                } else if (readByte == 64) {
                    g();
                } else if ((readByte & 64) == 64) {
                    f(a(readByte, 63) - 1);
                } else if ((readByte & 32) == 32) {
                    int a = a(readByte, 31);
                    this.f427d = a;
                    if (a < 0 || a > this.f426c) {
                        throw new IOException("Invalid dynamic table size update " + this.f427d);
                    }
                    d();
                } else if (readByte == 16 || readByte == 0) {
                    h();
                } else {
                    g(a(readByte, 15) - 1);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c a;
        private final boolean b;

        /* renamed from: c  reason: collision with root package name */
        private int f432c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f433d;

        /* renamed from: e  reason: collision with root package name */
        public int f434e;

        /* renamed from: f  reason: collision with root package name */
        public c[] f435f;

        /* renamed from: g  reason: collision with root package name */
        public int f436g;

        /* renamed from: h  reason: collision with root package name */
        public int f437h;

        /* renamed from: i  reason: collision with root package name */
        public int f438i;

        public b(int i2, boolean z, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar) {
            this.f432c = Integer.MAX_VALUE;
            c[] cVarArr = new c[8];
            this.f435f = cVarArr;
            this.f436g = cVarArr.length - 1;
            this.f437h = 0;
            this.f438i = 0;
            this.f434e = i2;
            this.b = z;
            this.a = cVar;
        }

        public b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar) {
            this(4096, true, cVar);
        }

        private void a() {
            int i2 = this.f434e;
            int i3 = this.f438i;
            if (i2 < i3) {
                if (i2 == 0) {
                    b();
                } else {
                    b(i3 - i2);
                }
            }
        }

        private void a(c cVar) {
            int i2 = cVar.f425c;
            int i3 = this.f434e;
            if (i2 > i3) {
                b();
                return;
            }
            b((this.f438i + i2) - i3);
            int i4 = this.f437h;
            c[] cVarArr = this.f435f;
            if (i4 + 1 > cVarArr.length) {
                c[] cVarArr2 = new c[cVarArr.length * 2];
                System.arraycopy(cVarArr, 0, cVarArr2, cVarArr.length, cVarArr.length);
                this.f436g = this.f435f.length - 1;
                this.f435f = cVarArr2;
            }
            int i5 = this.f436g;
            this.f436g = i5 - 1;
            this.f435f[i5] = cVar;
            this.f437h++;
            this.f438i = i2 + this.f438i;
        }

        private int b(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f435f.length;
                while (true) {
                    length--;
                    i3 = this.f436g;
                    if (length < i3 || i2 <= 0) {
                        break;
                    }
                    c[] cVarArr = this.f435f;
                    i2 -= cVarArr[length].f425c;
                    this.f438i -= cVarArr[length].f425c;
                    this.f437h--;
                    i4++;
                }
                c[] cVarArr2 = this.f435f;
                int i5 = i3 + 1;
                System.arraycopy(cVarArr2, i5, cVarArr2, i5 + i4, this.f437h);
                c[] cVarArr3 = this.f435f;
                int i6 = this.f436g + 1;
                Arrays.fill(cVarArr3, i6, i6 + i4, (Object) null);
                this.f436g += i4;
            }
            return i4;
        }

        private void b() {
            Arrays.fill(this.f435f, (Object) null);
            this.f436g = this.f435f.length - 1;
            this.f437h = 0;
            this.f438i = 0;
        }

        public void a(int i2) {
            int min = Math.min(i2, 16384);
            int i3 = this.f434e;
            if (i3 == min) {
                return;
            }
            if (min < i3) {
                this.f432c = Math.min(this.f432c, min);
            }
            this.f433d = true;
            this.f434e = min;
            a();
        }

        public void a(int i2, int i3, int i4) {
            int i5;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar;
            if (i2 < i3) {
                cVar = this.a;
                i5 = i2 | i4;
            } else {
                this.a.writeByte(i4 | i3);
                i5 = i2 - i3;
                while (i5 >= 128) {
                    this.a.writeByte(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                cVar = this.a;
            }
            cVar.writeByte(i5);
        }

        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar) throws IOException {
            int e2;
            int i2;
            if (!this.b || k.b().a(fVar) >= fVar.e()) {
                e2 = fVar.e();
                i2 = 0;
            } else {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
                k.b().a(fVar, cVar);
                fVar = cVar.m();
                e2 = fVar.e();
                i2 = 128;
            }
            a(e2, 127, i2);
            this.a.a(fVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x006b  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x00ab  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(java.util.List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> r13) throws java.io.IOException {
            /*
                Method dump skipped, instructions count: 226
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.d.b.a(java.util.List):void");
        }
    }

    static {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar = c.f421f;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar2 = c.f422g;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar3 = c.f423h;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar4 = c.f420e;
        a = new c[]{new c(c.f424i, ""), new c(fVar, "GET"), new c(fVar, "POST"), new c(fVar2, MqttTopic.TOPIC_LEVEL_SEPARATOR), new c(fVar2, "/index.html"), new c(fVar3, "http"), new c(fVar3, "https"), new c(fVar4, BasicPushStatus.SUCCESS_CODE), new c(fVar4, "204"), new c(fVar4, "206"), new c(fVar4, "304"), new c(fVar4, "400"), new c(fVar4, ca.b), new c(fVar4, VoiceToTextEvent.STATUS_FAIL), new c("accept-charset", ""), new c("accept-encoding", "gzip, deflate"), new c("accept-language", ""), new c("accept-ranges", ""), new c("accept", ""), new c("access-control-allow-origin", ""), new c("age", ""), new c("allow", ""), new c("authorization", ""), new c("cache-control", ""), new c("content-disposition", ""), new c("content-encoding", ""), new c("content-language", ""), new c("content-length", ""), new c("content-location", ""), new c("content-range", ""), new c("content-type", ""), new c("cookie", ""), new c(MessageKey.MSG_DATE, ""), new c("etag", ""), new c("expect", ""), new c("expires", ""), new c("from", ""), new c(ReportItem.RequestKeyHost, ""), new c("if-match", ""), new c("if-modified-since", ""), new c("if-none-match", ""), new c("if-range", ""), new c("if-unmodified-since", ""), new c("last-modified", ""), new c("link", ""), new c("location", ""), new c("max-forwards", ""), new c("proxy-authenticate", ""), new c("proxy-authorization", ""), new c("range", ""), new c("referer", ""), new c("refresh", ""), new c("retry-after", ""), new c("server", ""), new c("set-cookie", ""), new c("strict-transport-security", ""), new c("transfer-encoding", ""), new c("user-agent", ""), new c("vary", ""), new c("via", ""), new c("www-authenticate", "")};
        b = a();
    }

    public static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f fVar) throws IOException {
        int e2 = fVar.e();
        for (int i2 = 0; i2 < e2; i2++) {
            byte a2 = fVar.a(i2);
            if (a2 >= 65 && a2 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + fVar.h());
            }
        }
        return fVar;
    }

    private static Map<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f, Integer> a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(a.length);
        int i2 = 0;
        while (true) {
            c[] cVarArr = a;
            if (i2 >= cVarArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(cVarArr[i2].a)) {
                linkedHashMap.put(cVarArr[i2].a, Integer.valueOf(i2));
            }
            i2++;
        }
    }
}
