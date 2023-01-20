package com.m7.imkfsdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public class MimeTypeParser {
    public static final String ATTR_EXTENSION = "extension";
    public static final String ATTR_ICON = "icon";
    public static final String ATTR_MIMETYPE = "mimetype";
    public static final String TAG_MIMETYPES = "MimeTypes";
    public static final String TAG_TYPE = "type";
    private MimeTypes mMimeTypes;
    private XmlPullParser mXpp;
    private String packagename;
    private Resources resources;

    public MimeTypeParser(Context context, String str) throws PackageManager.NameNotFoundException {
        this.packagename = str;
        this.resources = context.getPackageManager().getResourcesForApplication(str);
    }

    private void addMimeTypeStart() {
        int identifier;
        String attributeValue = this.mXpp.getAttributeValue(null, ATTR_EXTENSION);
        String attributeValue2 = this.mXpp.getAttributeValue(null, "mimetype");
        String attributeValue3 = this.mXpp.getAttributeValue(null, "icon");
        if (attributeValue3 != null && (identifier = this.resources.getIdentifier(attributeValue3.substring(1), null, this.packagename)) > 0) {
            this.mMimeTypes.put(attributeValue, attributeValue2, identifier);
        } else {
            this.mMimeTypes.put(attributeValue, attributeValue2);
        }
    }

    public MimeTypes fromXml(InputStream inputStream) throws XmlPullParserException, IOException {
        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
        this.mXpp = newPullParser;
        newPullParser.setInput(new InputStreamReader(inputStream));
        return parse();
    }

    public MimeTypes fromXmlResource(XmlResourceParser xmlResourceParser) throws XmlPullParserException, IOException {
        this.mXpp = xmlResourceParser;
        return parse();
    }

    public MimeTypes parse() throws XmlPullParserException, IOException {
        this.mMimeTypes = new MimeTypes();
        int eventType = this.mXpp.getEventType();
        while (eventType != 1) {
            String name = this.mXpp.getName();
            if (eventType == 2) {
                if (!name.equals(TAG_MIMETYPES) && name.equals("type")) {
                    addMimeTypeStart();
                }
            } else if (eventType == 3) {
                name.equals(TAG_MIMETYPES);
            }
            eventType = this.mXpp.next();
        }
        return this.mMimeTypes;
    }
}
