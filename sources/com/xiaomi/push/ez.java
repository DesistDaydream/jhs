package com.xiaomi.push;

import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.db;
import com.xiaomi.push.fb;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/* loaded from: classes3.dex */
public class ez implements fo {
    public static boolean a = false;

    /* renamed from: c */
    private fb f8558c;
    private SimpleDateFormat b = new SimpleDateFormat("hh:mm:ss aaa");

    /* renamed from: d */
    private a f8559d = null;

    /* renamed from: e */
    private a f8560e = null;

    /* renamed from: f */
    private fe f8561f = null;

    /* renamed from: g */
    private final String f8562g = "[Slim] ";

    /* loaded from: classes3.dex */
    public class a implements fh, fp {
        public String a;

        /* renamed from: c */
        private boolean f8563c;

        public a(boolean z) {
            ez.this = r1;
            this.f8563c = true;
            this.f8563c = z;
            this.a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fh
        public void a(eq eqVar) {
            StringBuilder sb;
            String str;
            if (ez.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ez.this.b.format(new Date()));
                sb.append(this.a);
                str = eqVar.toString();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ez.this.b.format(new Date()));
                sb.append(this.a);
                sb.append(" Blob [");
                sb.append(eqVar.a());
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(eqVar.c());
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(com.xiaomi.push.service.ag.a(eqVar.h()));
                str = "]";
            }
            sb.append(str);
            com.xiaomi.a.a.a.c.c(sb.toString());
            if (eqVar == null || eqVar.c() != 99999) {
                return;
            }
            String a = eqVar.a();
            eq eqVar2 = null;
            if (!this.f8563c) {
                if ("BIND".equals(a)) {
                    com.xiaomi.a.a.a.c.a("build binded result for loopback.");
                    db.d dVar = new db.d();
                    dVar.a(true);
                    dVar.c("login success.");
                    dVar.b(com.baidu.mobads.sdk.internal.bp.o);
                    dVar.a(com.baidu.mobads.sdk.internal.bp.o);
                    eq eqVar3 = new eq();
                    eqVar3.a(dVar.z(), (String) null);
                    eqVar3.a((short) 2);
                    eqVar3.a(99999);
                    eqVar3.a("BIND", (String) null);
                    eqVar3.a(eqVar.h());
                    eqVar3.b((String) null);
                    eqVar3.c(eqVar.j());
                    eqVar2 = eqVar3;
                } else if (!"UBND".equals(a) && "SECMSG".equals(a)) {
                    eq eqVar4 = new eq();
                    eqVar4.a(99999);
                    eqVar4.a("SECMSG", (String) null);
                    eqVar4.c(eqVar.j());
                    eqVar4.a(eqVar.h());
                    eqVar4.a(eqVar.m());
                    eqVar4.b(eqVar.i());
                    eqVar4.a(eqVar.d(com.xiaomi.push.service.aj.a().b(String.valueOf(99999), eqVar.j()).f9081i), (String) null);
                    eqVar2 = eqVar4;
                }
            }
            if (eqVar2 != null) {
                for (Map.Entry<fh, fb.a> entry : ez.this.f8558c.h().entrySet()) {
                    if (ez.this.f8559d != entry.getKey()) {
                        entry.getValue().a(eqVar2);
                    }
                }
            }
        }

        @Override // com.xiaomi.push.fp
        public boolean a(ft ftVar) {
            return true;
        }

        @Override // com.xiaomi.push.fh
        public void b(ft ftVar) {
            StringBuilder sb;
            String str;
            if (ez.a) {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ez.this.b.format(new Date()));
                sb.append(this.a);
                sb.append(" PKT ");
                str = ftVar.c();
            } else {
                sb = new StringBuilder();
                sb.append("[Slim] ");
                sb.append(ez.this.b.format(new Date()));
                sb.append(this.a);
                sb.append(" PKT [");
                sb.append(ftVar.l());
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                sb.append(ftVar.k());
                str = "]";
            }
            sb.append(str);
            com.xiaomi.a.a.a.c.c(sb.toString());
        }
    }

    public ez(fb fbVar) {
        this.f8558c = null;
        this.f8558c = fbVar;
        a();
    }

    private void a() {
        this.f8559d = new a(true);
        this.f8560e = new a(false);
        fb fbVar = this.f8558c;
        a aVar = this.f8559d;
        fbVar.a(aVar, aVar);
        fb fbVar2 = this.f8558c;
        a aVar2 = this.f8560e;
        fbVar2.b(aVar2, aVar2);
        this.f8561f = new fa(this);
    }
}
