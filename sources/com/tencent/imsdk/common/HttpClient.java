package com.tencent.imsdk.common;

import android.text.TextUtils;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class HttpClient {
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    public static final int HTTP_ACTION_REQUEST = 0;
    public static final int HTTP_ACTION_RESPONSE = 1;
    private static final long KEEP_ALIVE = 5;
    private static final int MAX_POOL_SIZE;
    private static final int PROXY_TYPE_HTTP = 1;
    private static final int PROXY_TYPE_SOCKS5 = 2;
    private static final String TAG = "HttpClient";
    private static boolean mNeedRollbackHttps2Http;
    private static String mRollbackHttps2Http;
    private static final Executor mThreadPoolExecutor;

    /* loaded from: classes3.dex */
    public static class BasicAuthenticator extends Authenticator {
        private String password;
        private String userName;

        public BasicAuthenticator(String str, String str2) {
            this.userName = "";
            this.password = "";
            this.userName = str;
            this.password = str2;
        }

        @Override // java.net.Authenticator
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(this.userName, this.password.toCharArray());
        }
    }

    /* loaded from: classes3.dex */
    public interface HttpRequestListener {
        void onCompleted(int i2, Map<String, String> map, byte[] bArr);

        void onProgress(int i2, int i3, int i4);
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        int i2 = availableProcessors + 1;
        CORE_POOL_SIZE = i2;
        int i3 = (availableProcessors * 2) + 1;
        MAX_POOL_SIZE = i3;
        mRollbackHttps2Http = "";
        mNeedRollbackHttps2Http = false;
        mThreadPoolExecutor = new ThreadPoolExecutor(i2, i3, KEEP_ALIVE, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }

    private static void httpRequest(final String str, final String str2, final Map<String, String> map, final byte[] bArr, final String str3, final String str4, final HttpRequestListener httpRequestListener, final int i2, final String str5, final int i3, final String str6, final String str7, final int i4, final int i5, final String str8) {
        mThreadPoolExecutor.execute(new Runnable() { // from class: com.tencent.imsdk.common.HttpClient.1
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:115:0x0203  */
            /* JADX WARN: Removed duplicated region for block: B:122:0x0210  */
            /* JADX WARN: Removed duplicated region for block: B:125:0x0217  */
            /* JADX WARN: Removed duplicated region for block: B:161:0x027c  */
            /* JADX WARN: Removed duplicated region for block: B:164:0x0283  */
            /* JADX WARN: Removed duplicated region for block: B:178:0x02b5  */
            /* JADX WARN: Removed duplicated region for block: B:181:0x02bc  */
            /* JADX WARN: Removed duplicated region for block: B:191:0x02ce  */
            /* JADX WARN: Removed duplicated region for block: B:194:0x02d5  */
            /* JADX WARN: Removed duplicated region for block: B:199:0x0272 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:203:0x02ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:205:0x0206 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:207:0x02c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:219:0x0164 A[EDGE_INSN: B:219:0x0164->B:72:0x0164 ?: BREAK  , SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:229:? A[RETURN, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:67:0x0145 A[Catch: all -> 0x0238, Exception -> 0x023b, UnknownHostException -> 0x023e, TryCatch #13 {UnknownHostException -> 0x023e, Exception -> 0x023b, all -> 0x0238, blocks: (B:18:0x0064, B:20:0x006c, B:22:0x0074, B:39:0x00d5, B:41:0x00ef, B:42:0x00f7, B:44:0x00fd, B:45:0x0113, B:47:0x0117, B:51:0x011d, B:53:0x0121, B:62:0x0132, B:65:0x0140, B:67:0x0145, B:69:0x0154, B:70:0x015e, B:72:0x0164, B:73:0x0168, B:75:0x0174, B:68:0x014d, B:76:0x0178, B:32:0x00ad, B:34:0x00b5, B:36:0x00bd), top: B:213:0x003b }] */
            /* JADX WARN: Removed duplicated region for block: B:68:0x014d A[Catch: all -> 0x0238, Exception -> 0x023b, UnknownHostException -> 0x023e, TryCatch #13 {UnknownHostException -> 0x023e, Exception -> 0x023b, all -> 0x0238, blocks: (B:18:0x0064, B:20:0x006c, B:22:0x0074, B:39:0x00d5, B:41:0x00ef, B:42:0x00f7, B:44:0x00fd, B:45:0x0113, B:47:0x0117, B:51:0x011d, B:53:0x0121, B:62:0x0132, B:65:0x0140, B:67:0x0145, B:69:0x0154, B:70:0x015e, B:72:0x0164, B:73:0x0168, B:75:0x0174, B:68:0x014d, B:76:0x0178, B:32:0x00ad, B:34:0x00b5, B:36:0x00bd), top: B:213:0x003b }] */
            /* JADX WARN: Removed duplicated region for block: B:73:0x0168 A[Catch: all -> 0x0238, Exception -> 0x023b, UnknownHostException -> 0x023e, TryCatch #13 {UnknownHostException -> 0x023e, Exception -> 0x023b, all -> 0x0238, blocks: (B:18:0x0064, B:20:0x006c, B:22:0x0074, B:39:0x00d5, B:41:0x00ef, B:42:0x00f7, B:44:0x00fd, B:45:0x0113, B:47:0x0117, B:51:0x011d, B:53:0x0121, B:62:0x0132, B:65:0x0140, B:67:0x0145, B:69:0x0154, B:70:0x015e, B:72:0x0164, B:73:0x0168, B:75:0x0174, B:68:0x014d, B:76:0x0178, B:32:0x00ad, B:34:0x00b5, B:36:0x00bd), top: B:213:0x003b }] */
            /* JADX WARN: Removed duplicated region for block: B:79:0x0186 A[Catch: all -> 0x0227, Exception -> 0x022d, UnknownHostException -> 0x0232, TRY_LEAVE, TryCatch #17 {UnknownHostException -> 0x0232, Exception -> 0x022d, all -> 0x0227, blocks: (B:77:0x017c, B:79:0x0186), top: B:209:0x017c }] */
            /* JADX WARN: Removed duplicated region for block: B:83:0x019c  */
            /* JADX WARN: Removed duplicated region for block: B:86:0x01a3  */
            /* JADX WARN: Removed duplicated region for block: B:94:0x01b3 A[Catch: all -> 0x021c, Exception -> 0x021f, UnknownHostException -> 0x0224, TRY_LEAVE, TryCatch #12 {UnknownHostException -> 0x0224, Exception -> 0x021f, all -> 0x021c, blocks: (B:82:0x018e, B:84:0x019d, B:87:0x01a4, B:89:0x01a8, B:94:0x01b3), top: B:215:0x018e }] */
            /* JADX WARN: Type inference failed for: r0v19 */
            /* JADX WARN: Type inference failed for: r0v20, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r0v34 */
            /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.String] */
            /* JADX WARN: Type inference failed for: r1v10, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r1v11, types: [com.tencent.imsdk.common.HttpClient$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r1v12, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r1v14 */
            /* JADX WARN: Type inference failed for: r1v16, types: [com.tencent.imsdk.common.HttpClient$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r1v17 */
            /* JADX WARN: Type inference failed for: r1v18 */
            /* JADX WARN: Type inference failed for: r1v19 */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v24, types: [java.net.HttpURLConnection] */
            /* JADX WARN: Type inference failed for: r1v25, types: [com.tencent.imsdk.common.HttpClient$HttpRequestListener] */
            /* JADX WARN: Type inference failed for: r1v30 */
            /* JADX WARN: Type inference failed for: r1v31 */
            /* JADX WARN: Type inference failed for: r1v32 */
            /* JADX WARN: Type inference failed for: r1v33 */
            /* JADX WARN: Type inference failed for: r1v34 */
            /* JADX WARN: Type inference failed for: r1v35 */
            /* JADX WARN: Type inference failed for: r1v36 */
            /* JADX WARN: Type inference failed for: r1v37 */
            /* JADX WARN: Type inference failed for: r1v38 */
            /* JADX WARN: Type inference failed for: r1v39 */
            /* JADX WARN: Type inference failed for: r1v42 */
            /* JADX WARN: Type inference failed for: r1v43 */
            /* JADX WARN: Type inference failed for: r1v44 */
            /* JADX WARN: Type inference failed for: r1v45 */
            /* JADX WARN: Type inference failed for: r1v46 */
            /* JADX WARN: Type inference failed for: r1v47 */
            /* JADX WARN: Type inference failed for: r1v48 */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v53 */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r3v6, types: [java.io.IOException] */
            /* JADX WARN: Type inference failed for: r4v15 */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v10 */
            /* JADX WARN: Type inference failed for: r5v11, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r5v13 */
            /* JADX WARN: Type inference failed for: r5v31 */
            /* JADX WARN: Type inference failed for: r5v34 */
            /* JADX WARN: Type inference failed for: r5v36 */
            /* JADX WARN: Type inference failed for: r5v38 */
            /* JADX WARN: Type inference failed for: r5v4 */
            /* JADX WARN: Type inference failed for: r5v42 */
            /* JADX WARN: Type inference failed for: r5v44 */
            /* JADX WARN: Type inference failed for: r5v55 */
            /* JADX WARN: Type inference failed for: r5v56 */
            /* JADX WARN: Type inference failed for: r5v57 */
            /* JADX WARN: Type inference failed for: r5v58 */
            /* JADX WARN: Type inference failed for: r5v59 */
            /* JADX WARN: Type inference failed for: r5v60 */
            /* JADX WARN: Type inference failed for: r5v8, types: [byte[]] */
            /* JADX WARN: Type inference failed for: r5v9 */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() {
                /*
                    Method dump skipped, instructions count: 729
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.imsdk.common.HttpClient.AnonymousClass1.run():void");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProgressCallback(int i2, int i3, int i4, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeResponseCallback(int i2, String[] strArr, String[] strArr2, byte[] bArr, long j2);

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean needRollbackHttps2Http(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            String str2 = "";
            if (SystemUtil.isBrandOppo()) {
                str2 = "oppo";
            } else if (SystemUtil.isBrandVivo()) {
                str2 = "vivo";
            } else if (SystemUtil.isBrandHuawei()) {
                str2 = "huawei";
            } else if (SystemUtil.isBrandXiaoMi()) {
                str2 = "xiaomi";
            } else if (SystemUtil.isBrandMeizu()) {
                str2 = "meizu";
            }
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i2);
                String string = jSONObject.getString("brand");
                int i3 = jSONObject.getInt("below_version");
                if (str2.equals(string)) {
                    return SystemUtil.getSDKVersion() <= i3;
                }
            }
            return false;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private static void httpRequest(String str, String str2, String[] strArr, String[] strArr2, byte[] bArr, String str3, String str4, final long j2, final long j3, int i2, String str5, int i3, String str6, String str7, int i4, int i5, String str8) {
        HashMap hashMap;
        if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
            hashMap = null;
        } else {
            hashMap = new HashMap();
            for (int i6 = 0; i6 < strArr.length; i6++) {
                hashMap.put(strArr[i6], strArr2[i6]);
            }
        }
        httpRequest(str, str2, hashMap, bArr, str3, str4, new HttpRequestListener() { // from class: com.tencent.imsdk.common.HttpClient.2
            @Override // com.tencent.imsdk.common.HttpClient.HttpRequestListener
            public void onCompleted(int i7, Map<String, String> map, byte[] bArr2) {
                String[] strArr3;
                String[] strArr4;
                if (j3 != 0) {
                    if (map != null) {
                        String[] strArr5 = new String[map.size()];
                        String[] strArr6 = new String[map.size()];
                        int i8 = 0;
                        for (Map.Entry<String, String> entry : map.entrySet()) {
                            strArr5[i8] = entry.getKey();
                            strArr6[i8] = entry.getValue();
                            i8++;
                        }
                        strArr3 = strArr5;
                        strArr4 = strArr6;
                    } else {
                        strArr3 = null;
                        strArr4 = null;
                    }
                    HttpClient.nativeResponseCallback(i7, strArr3, strArr4, bArr2, j3);
                }
            }

            @Override // com.tencent.imsdk.common.HttpClient.HttpRequestListener
            public void onProgress(int i7, int i8, int i9) {
                long j4 = j2;
                if (j4 != 0) {
                    HttpClient.nativeProgressCallback(i7, i8, i9, j4);
                }
            }
        }, i2, str5, i3, str6, str7, i4, i5, str8);
    }
}
