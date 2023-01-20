package com.umeng.analytics.pro;

import com.umeng.analytics.pro.bo;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public class be {
    private final ByteArrayOutputStream a;
    private final cg b;

    /* renamed from: c */
    private bu f7064c;

    public be() {
        this(new bo.a());
    }

    public byte[] a(av avVar) throws bb {
        this.a.reset();
        avVar.write(this.f7064c);
        return this.a.toByteArray();
    }

    public String b(av avVar) throws bb {
        return new String(a(avVar));
    }

    public be(bw bwVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a = byteArrayOutputStream;
        cg cgVar = new cg(byteArrayOutputStream);
        this.b = cgVar;
        this.f7064c = bwVar.a(cgVar);
    }

    public String a(av avVar, String str) throws bb {
        try {
            return new String(a(avVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new bb("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }
}
