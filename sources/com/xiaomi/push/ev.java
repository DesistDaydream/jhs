package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes3.dex */
public class ev {
    private XmlPullParser a;

    public ev() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public ft a(byte[] bArr, fb fbVar) {
        this.a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.a.next();
        int eventType = this.a.getEventType();
        String name = this.a.getName();
        if (eventType == 2) {
            if (name.equals("message")) {
                return gb.a(this.a);
            }
            if (name.equals("iq")) {
                return gb.a(this.a, fbVar);
            }
            if (name.equals("presence")) {
                return gb.b(this.a);
            }
            if (this.a.getName().equals("stream")) {
                return null;
            }
            if (this.a.getName().equals(com.umeng.analytics.pro.d.O)) {
                throw new fn(gb.c(this.a));
            }
            if (!this.a.getName().equals("warning")) {
                this.a.getName().equals("bind");
                return null;
            }
            this.a.next();
            this.a.getName().equals("multi-login");
            return null;
        }
        return null;
    }
}
