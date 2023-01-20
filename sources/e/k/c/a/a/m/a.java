package e.k.c.a.a.m;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/* loaded from: classes2.dex */
public class a {
    public static DocumentBuilderFactory a() throws ParserConfigurationException, NullPointerException {
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setFeature("http://xml.org/sax/features/namespaces", true);
        newInstance.setFeature("http://xml.org/sax/features/validation", false);
        newInstance.setExpandEntityReferences(false);
        return newInstance;
    }
}
