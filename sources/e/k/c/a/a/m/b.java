package e.k.c.a.a.m;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* loaded from: classes2.dex */
public class b {
    public static SAXParserFactory a() throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException, NullPointerException {
        SAXParserFactory newInstance = SAXParserFactory.newInstance();
        newInstance.setFeature("http://xml.org/sax/features/namespaces", true);
        newInstance.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
        newInstance.setFeature("http://xml.org/sax/features/validation", false);
        newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
        newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        newInstance.setFeature("http://xml.org/sax/features/string-interning", true);
        return newInstance;
    }
}
