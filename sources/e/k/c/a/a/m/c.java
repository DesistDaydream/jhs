package e.k.c.a.a.m;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class c {
    public static XmlPullParserFactory a() throws XmlPullParserException {
        XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes", false);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", true);
        newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#validation", false);
        return newInstance;
    }
}
