package com.huawei.hms.push;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class r {
    public static int a(Context context, String str, String str2) {
        try {
            int identifier = context.getResources().getIdentifier(str2, str, context.getPackageName());
            if (identifier == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append(context.getPackageName());
                sb.append(".R$");
                sb.append(str);
                Field field = Class.forName(sb.toString()).getField(str2);
                identifier = Integer.parseInt(field.get(field.getName()).toString());
                if (identifier == 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Error-resourceType=");
                    sb2.append(str);
                    sb2.append("--resourceName=");
                    sb2.append(str2);
                    sb2.append("--resourceId =");
                    sb2.append(identifier);
                    HMSLog.i("ResourceLoader", sb2.toString());
                }
            }
            return identifier;
        } catch (ClassNotFoundException e2) {
            HMSLog.e("ResourceLoader", "!!!! ResourceLoader: ClassNotFoundException-resourceType=" + str + "--resourceName=" + str2, e2);
            return 0;
        } catch (IllegalAccessException e3) {
            HMSLog.e("ResourceLoader", "!!!! ResourceLoader: IllegalAccessException-resourceType=" + str + "--resourceName=" + str2, e3);
            return 0;
        } catch (NoSuchFieldException e4) {
            HMSLog.e("ResourceLoader", "!!!! ResourceLoader: NoSuchFieldException-resourceType=" + str + "--resourceName=" + str2, e4);
            return 0;
        } catch (NumberFormatException e5) {
            HMSLog.e("ResourceLoader", "!!!! ResourceLoader: NumberFormatException-resourceType=" + str + "--resourceName=" + str2, e5);
            return 0;
        } catch (IllegalArgumentException e6) {
            HMSLog.e("ResourceLoader", "!!!! ResourceLoader: IllegalArgumentException-resourceType=" + str + "--resourceName=" + str2, e6);
            return 0;
        }
    }

    public static int a(Context context, String str) {
        Bundle bundle;
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo == null || (bundle = applicationInfo.metaData) == null) {
                return 0;
            }
            return bundle.getInt(str);
        } catch (PackageManager.NameNotFoundException unused) {
            HMSLog.w("ResourceLoader", "load meta data resource failed.");
            return 0;
        }
    }
}
