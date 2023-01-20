package com.m7.imkfsdk.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.m7.imkfsdk.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public class MimeTypesTools {
    private static boolean hasLoadMimeType = false;

    public static String getMimeType(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return getMimeTypes(context).getMimeType(FileUtils.getExtension(str.toLowerCase()));
    }

    private static MimeTypes getMimeTypes(Context context) {
        return loadMimeTypes(context);
    }

    private static MimeTypes loadMimeTypes(Context context) {
        if (hasLoadMimeType) {
            return null;
        }
        try {
            return new MimeTypeParser(context, context.getPackageName()).fromXmlResource(context.getResources().getXml(R.xml.ykfsdk_mimetypes));
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            hasLoadMimeType = true;
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            hasLoadMimeType = true;
            return null;
        } catch (XmlPullParserException e4) {
            e4.printStackTrace();
            hasLoadMimeType = true;
            return null;
        }
    }
}
