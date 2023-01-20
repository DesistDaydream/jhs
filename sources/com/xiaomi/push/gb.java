package com.xiaomi.push;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.reward.RewardItem;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.fr;
import com.xiaomi.push.fv;
import com.xiaomi.push.fx;
import com.xiaomi.push.service.aj;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes3.dex */
public class gb {
    private static XmlPullParser a;

    public static fq a(String str, String str2, XmlPullParser xmlPullParser) {
        Object a2 = ga.a().a("all", "xm:chat");
        if (a2 == null || !(a2 instanceof com.xiaomi.push.service.cg)) {
            return null;
        }
        return ((com.xiaomi.push.service.cg) a2).b(xmlPullParser);
    }

    public static fr a(XmlPullParser xmlPullParser, fb fbVar) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", "to");
        String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        fr.a a2 = fr.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        fr frVar = null;
        fx fxVar = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals(com.umeng.analytics.pro.d.O)) {
                    fxVar = d(xmlPullParser);
                } else {
                    frVar = new fr();
                    frVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z = true;
            }
        }
        if (frVar == null) {
            if (fr.a.a == a2 || fr.a.b == a2) {
                gc gcVar = new gc();
                gcVar.k(attributeValue);
                gcVar.m(attributeValue3);
                gcVar.n(attributeValue2);
                gcVar.a(fr.a.f8603d);
                gcVar.l(attributeValue4);
                gcVar.a(new fx(fx.a.f8649e));
                fbVar.a(gcVar);
                com.xiaomi.a.a.a.c.d("iq usage error. send packet in packet parser.");
                return null;
            }
            frVar = new gd();
        }
        frVar.k(attributeValue);
        frVar.m(attributeValue2);
        frVar.l(attributeValue4);
        frVar.n(attributeValue3);
        frVar.a(a2);
        frVar.a(fxVar);
        frVar.a(hashMap);
        return frVar;
    }

    public static ft a(XmlPullParser xmlPullParser) {
        String str;
        boolean z = false;
        String str2 = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", "s"))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", "from");
            String attributeValue4 = xmlPullParser.getAttributeValue("", "to");
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            aj.b b = com.xiaomi.push.service.aj.a().b(attributeValue, attributeValue4);
            if (b == null) {
                b = com.xiaomi.push.service.aj.a().b(attributeValue, attributeValue3);
            }
            if (b != null) {
                ft ftVar = null;
                while (!z) {
                    int next = xmlPullParser.next();
                    if (next == 2) {
                        if (!"s".equals(xmlPullParser.getName())) {
                            throw new fn("error while receiving a encrypted message with wrong format");
                        }
                        if (xmlPullParser.next() != 4) {
                            throw new fn("error while receiving a encrypted message with wrong format");
                        }
                        String text = xmlPullParser.getText();
                        if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                            fs fsVar = new fs();
                            fsVar.l(attributeValue);
                            fsVar.b(true);
                            fsVar.n(attributeValue3);
                            fsVar.m(attributeValue4);
                            fsVar.k(attributeValue2);
                            fsVar.f(attributeValue5);
                            fq fqVar = new fq("s", null, null, null);
                            fqVar.b(text);
                            fsVar.a(fqVar);
                            return fsVar;
                        }
                        a(com.xiaomi.push.service.as.a(com.xiaomi.push.service.as.a(b.f9081i, attributeValue2), text));
                        a.next();
                        ftVar = a(a);
                    } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                        z = true;
                    }
                }
                if (ftVar != null) {
                    return ftVar;
                }
                throw new fn("error while receiving a encrypted message with wrong format");
            }
            throw new fn("the channel id is wrong while receiving a encrypted message");
        }
        fs fsVar2 = new fs();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        fsVar2.k(attributeValue6);
        fsVar2.m(xmlPullParser.getAttributeValue("", "to"));
        fsVar2.n(xmlPullParser.getAttributeValue("", "from"));
        fsVar2.l(xmlPullParser.getAttributeValue("", "chid"));
        fsVar2.a(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                fsVar2.b(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                fsVar2.c(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                fsVar2.d(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                fsVar2.e(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        fsVar2.a(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        fsVar2.f(xmlPullParser.getAttributeValue("", "type"));
        String f2 = f(xmlPullParser);
        if (f2 == null || "".equals(f2.trim())) {
            ft.u();
        } else {
            fsVar2.j(f2);
        }
        while (!z) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    f(xmlPullParser);
                    fsVar2.g(e(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String e2 = e(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue11)) {
                        fsVar2.h(e2);
                    } else {
                        fsVar2.a(e2, attributeValue11);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals(com.umeng.analytics.pro.d.O)) {
                    fsVar2.a(d(xmlPullParser));
                } else {
                    fsVar2.a(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z = true;
            }
        }
        fsVar2.i(str2);
        return fsVar2;
    }

    private static void a(byte[] bArr) {
        if (a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                a = newPullParser;
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
        a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    public static fv b(XmlPullParser xmlPullParser) {
        fv.b bVar = fv.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = fv.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                PrintStream printStream = System.err;
                printStream.println("Found invalid presence type " + attributeValue);
            }
        }
        fv fvVar = new fv(bVar);
        fvVar.m(xmlPullParser.getAttributeValue("", "to"));
        fvVar.n(xmlPullParser.getAttributeValue("", "from"));
        fvVar.l(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        fvVar.k(attributeValue2);
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    fvVar.a(xmlPullParser.nextText());
                } else if (name.equals(RemoteMessageConst.Notification.PRIORITY)) {
                    try {
                        fvVar.a(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        fvVar.a(0);
                    }
                } else if (name.equals(TTLogUtil.TAG_EVENT_SHOW)) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        fvVar.a(fv.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        PrintStream printStream2 = System.err;
                        printStream2.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals(com.umeng.analytics.pro.d.O)) {
                    fvVar.a(d(xmlPullParser));
                } else {
                    fvVar.a(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z = true;
            }
        }
        return fvVar;
    }

    public static fw c(XmlPullParser xmlPullParser) {
        fw fwVar = null;
        boolean z = false;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                fwVar = new fw(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals(com.umeng.analytics.pro.d.O)) {
                z = true;
            }
        }
        return fwVar;
    }

    public static fx d(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        String str = GMNetworkPlatformConst.AD_NETWORK_NO_PRICE;
        String str2 = null;
        String str3 = null;
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            if (xmlPullParser.getAttributeName(i2).equals("code")) {
                str = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i2).equals("type")) {
                str3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i2).equals(RewardItem.KEY_REASON)) {
                str2 = xmlPullParser.getAttributeValue("", RewardItem.KEY_REASON);
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals(com.umeng.analytics.pro.d.O)) {
                    z = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new fx(Integer.parseInt(str), str3 == null ? "cancel" : str3, str2, str4, str5, arrayList);
    }

    private static String e(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    private static String f(XmlPullParser xmlPullParser) {
        for (int i2 = 0; i2 < xmlPullParser.getAttributeCount(); i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i2)))) {
                return xmlPullParser.getAttributeValue(i2);
            }
        }
        return null;
    }
}
