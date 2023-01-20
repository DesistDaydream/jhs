package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_19do.a1;
import bykvm_19do.bykvm_19do.bykvm_19do.j1;
import bykvm_19do.bykvm_19do.bykvm_19do.q1;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class g1 implements a1 {
    private final a1 a;
    private o0<Boolean> b;

    /* loaded from: classes.dex */
    public class a extends o0<Boolean> {
        public a(g1 g1Var) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.o0
        /* renamed from: c */
        public Boolean a(Object... objArr) {
            Boolean bool = Boolean.FALSE;
            try {
                PackageInfo packageInfo = ((Context) objArr[0]).getPackageManager().getPackageInfo("com.heytap.openid", 0);
                if (packageInfo == null) {
                    return bool;
                }
                return Boolean.valueOf((Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : (long) packageInfo.versionCode) >= 1);
            } catch (Throwable th) {
                th.printStackTrace();
                return bool;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements j1.b<q1, String> {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        public String a(q1 q1Var) {
            if (q1Var != null) {
                String c2 = g1.this.c(this.a);
                if (!TextUtils.isEmpty(c2)) {
                    return q1Var.a(this.a.getPackageName(), c2, "OUID");
                }
            }
            return null;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        /* renamed from: b */
        public q1 a(IBinder iBinder) {
            return q1.a.a(iBinder);
        }
    }

    public g1() {
        this(null);
    }

    public g1(a1 a1Var) {
        this.b = new a(this);
        this.a = a1Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String c(Context context) {
        Signature[] signatureArr;
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (packageInfo != null) {
            signatureArr = packageInfo.signatures;
            if (signatureArr == null && signatureArr.length > 0) {
                byte[] byteArray = signatureArr[0].toByteArray();
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
                    if (messageDigest != null) {
                        byte[] digest = messageDigest.digest(byteArray);
                        StringBuilder sb = new StringBuilder();
                        for (byte b2 : digest) {
                            sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
                        }
                        return sb.toString();
                    }
                    return null;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return null;
                }
            }
        }
        signatureArr = null;
        return signatureArr == null ? null : null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public boolean a(Context context) {
        if (context == null) {
            return false;
        }
        Boolean b2 = this.b.b(context);
        return (this.a == null || b2.booleanValue()) ? b2.booleanValue() : this.a.a(context);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.a1
    public a1.a b(Context context) {
        if (this.a == null || this.b.b(new Object[0]).booleanValue()) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.heytap.openid", "com.heytap.openid.IdentifyService"));
            intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
            a1.a aVar = new a1.a();
            aVar.a = (String) new j1(context, intent, new b(context)).a();
            return aVar;
        }
        return this.a.b(context);
    }
}
