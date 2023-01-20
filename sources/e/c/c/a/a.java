package e.c.c.a;

import android.text.TextUtils;
import com.tencent.android.tpush.XGPushNotificationBuilder;

/* loaded from: classes.dex */
public final class a {
    public static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        if (str.startsWith("gdt")) {
            return 3;
        }
        if (str.startsWith("admob")) {
            return 2;
        }
        if (str.equalsIgnoreCase("pangle")) {
            return 1;
        }
        if (str.equalsIgnoreCase("mintegral")) {
            return 4;
        }
        if (str.equalsIgnoreCase("unity")) {
            return 5;
        }
        if (str.equalsIgnoreCase("baidu")) {
            return 6;
        }
        if (str.equalsIgnoreCase("ks")) {
            return 7;
        }
        if (str.equalsIgnoreCase("sigmob")) {
            return 8;
        }
        return str.equalsIgnoreCase("klevin") ? 9 : -1;
    }

    public static String b(int i2) {
        return i2 == 3 ? "gdt" : i2 == 2 ? "admob" : i2 == 1 ? "pangle" : i2 == 4 ? "mintegral" : i2 == 5 ? "unity" : i2 == 6 ? "baidu" : i2 == 7 ? "ks" : i2 == 8 ? "sigmob" : i2 == 9 ? "klevin" : i2 == -1 ? XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0021 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(int r2, int r3) {
        /*
            java.lang.String r0 = "FullVideo"
            java.lang.String r1 = "Interstitial"
            switch(r2) {
                case 1: goto L1e;
                case 2: goto L1c;
                case 3: goto L19;
                case 4: goto L19;
                case 5: goto L16;
                case 6: goto L7;
                case 7: goto L13;
                case 8: goto L22;
                case 9: goto L10;
                case 10: goto L8;
                default: goto L7;
            }
        L7:
            goto L21
        L8:
            r2 = 1
            if (r3 != r2) goto Lc
            goto L1c
        Lc:
            r2 = 2
            if (r3 != r2) goto L21
            goto L22
        L10:
            java.lang.String r0 = "Draw"
            goto L22
        L13:
            java.lang.String r0 = "RewardVideo"
            goto L22
        L16:
            java.lang.String r0 = "Native"
            goto L22
        L19:
            java.lang.String r0 = "Splash"
            goto L22
        L1c:
            r0 = r1
            goto L22
        L1e:
            java.lang.String r0 = "Banner"
            goto L22
        L21:
            r0 = 0
        L22:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.c.a.a.c(int, int):java.lang.String");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r4 == 2) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(int r4, int r5, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j r6, int r7) {
        /*
            java.lang.String r0 = "Native-模板渲染"
            java.lang.String r1 = "Native-自渲染"
            r2 = 2
            r3 = 1
            switch(r4) {
                case 1: goto L34;
                case 2: goto L31;
                case 3: goto L2e;
                case 4: goto L2e;
                case 5: goto L1d;
                case 6: goto L9;
                case 7: goto L1a;
                case 8: goto L17;
                case 9: goto L14;
                case 10: goto La;
                default: goto L9;
            }
        L9:
            goto L37
        La:
            if (r5 != r3) goto Lf
            java.lang.String r0 = "InterstitialFull—Interstitial"
            goto L38
        Lf:
            if (r5 != r2) goto L37
            java.lang.String r0 = "InterstitialFull—FullVideo"
            goto L38
        L14:
            java.lang.String r0 = "NativeDraw"
            goto L38
        L17:
            java.lang.String r0 = "FullVideo"
            goto L38
        L1a:
            java.lang.String r0 = "RewardVideo"
            goto L38
        L1d:
            if (r6 == 0) goto L29
            int r4 = r6.s()
            if (r4 != r3) goto L26
            goto L38
        L26:
            if (r4 != r2) goto L29
            goto L2c
        L29:
            if (r7 != r3) goto L2c
            goto L38
        L2c:
            r0 = r1
            goto L38
        L2e:
            java.lang.String r0 = "Splash"
            goto L38
        L31:
            java.lang.String r0 = "Interstitial"
            goto L38
        L34:
            java.lang.String r0 = "Banner"
            goto L38
        L37:
            r0 = 0
        L38:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.c.c.a.a.d(int, int, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.j, int):java.lang.String");
    }

    public static String e(String str) {
        return TextUtils.isEmpty(str) ? str : str.equalsIgnoreCase("gdt") ? "gdt" : str.equalsIgnoreCase("admob") ? "admob" : str.equalsIgnoreCase("pangle") ? "pangle" : str.equalsIgnoreCase("mintegral") ? "mintegral" : str.equalsIgnoreCase("unity") ? "unity" : str.equalsIgnoreCase("baidu") ? "baidu" : str.equalsIgnoreCase("ks") ? "ks" : str.equalsIgnoreCase("sigmob") ? "sigmob" : str.equalsIgnoreCase("klevin") ? "klevin" : str;
    }
}
