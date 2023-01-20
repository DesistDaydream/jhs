package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;

/* loaded from: classes.dex */
public final class y0 implements a1 {
    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        return Build.VERSION.SDK_INT > 28;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        Bundle call;
        Uri parse = Uri.parse("content://cn.nubia.identity/identity");
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 > 17) {
                ContentProviderClient acquireContentProviderClient = context.getContentResolver().acquireContentProviderClient(parse);
                if (acquireContentProviderClient == null) {
                    return null;
                }
                call = acquireContentProviderClient.call("getOAID", null, null);
                if (i2 >= 24) {
                    acquireContentProviderClient.close();
                } else {
                    acquireContentProviderClient.release();
                }
            } else {
                call = context.getContentResolver().call(parse, "getOAID", (String) null, (Bundle) null);
            }
            if (call != null) {
                if (call.getInt("code", -1) == 0) {
                    a1.a aVar = new a1.a();
                    aVar.a = call.getString("id");
                    return aVar;
                }
                String string = call.getString("message");
                if (TextUtils.isEmpty(string)) {
                    return null;
                }
                Log.e("Oaid#", string);
                return null;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
