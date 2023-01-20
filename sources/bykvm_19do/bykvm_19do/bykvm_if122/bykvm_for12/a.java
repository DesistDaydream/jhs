package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements k, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.b {

    /* renamed from: c  reason: collision with root package name */
    public static final String f928c = UUID.randomUUID().toString();
    public final String a;
    public final JSONObject b;

    public a(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
    }

    public static a a(Context context, d dVar, JSONObject jSONObject) {
        return new a(UUID.randomUUID().toString(), b(context, dVar, jSONObject));
    }

    public static a a(String str, String str2, int i2) {
        if (!TextUtils.isEmpty(str2)) {
            if (i2 != 0) {
                try {
                    str2 = m.c(str2);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            JSONObject jSONObject = new JSONObject(str2);
            if (!TextUtils.isEmpty(str) && str2 != null) {
                return (!jSONObject.has("params") || jSONObject.has(RemoteMessageConst.Notification.TAG)) ? new a(str, jSONObject) : new i(str, jSONObject);
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0234 A[Catch: Exception -> 0x02f8, TRY_ENTER, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x023d A[Catch: Exception -> 0x02f8, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0249 A[Catch: Exception -> 0x02f8, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x025b A[Catch: Exception -> 0x02f8, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0274 A[Catch: Exception -> 0x02f8, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0294 A[Catch: Exception -> 0x02f8, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0299 A[Catch: Exception -> 0x02f8, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02ae A[Catch: Exception -> 0x02f8, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02bf A[Catch: Exception -> 0x02f8, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02ca A[Catch: Exception -> 0x02f8, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02e0 A[Catch: Exception -> 0x02f8, TryCatch #0 {Exception -> 0x02f8, blocks: (B:12:0x0029, B:14:0x008f, B:15:0x009c, B:17:0x00a1, B:18:0x00aa, B:20:0x00ae, B:21:0x00b7, B:23:0x00bb, B:24:0x00c0, B:26:0x00c4, B:27:0x00c9, B:29:0x00cd, B:30:0x00d2, B:33:0x00ed, B:35:0x00f5, B:37:0x00fd, B:39:0x0105, B:41:0x010d, B:43:0x0115, B:45:0x011f, B:47:0x0127, B:49:0x012f, B:51:0x0139, B:56:0x0154, B:59:0x0160, B:61:0x0168, B:63:0x0170, B:65:0x017a, B:67:0x0182, B:69:0x018a, B:71:0x0194, B:73:0x019e, B:75:0x01a8, B:77:0x01b2, B:79:0x01bc, B:81:0x01c6, B:83:0x01d0, B:85:0x01da, B:87:0x01e2, B:89:0x01ec, B:91:0x01f6, B:93:0x01fe, B:95:0x0208, B:97:0x0210, B:99:0x0218, B:109:0x0241, B:111:0x0249, B:113:0x0253, B:115:0x025b, B:117:0x0276, B:116:0x0274, B:118:0x027b, B:120:0x0294, B:122:0x02a1, B:124:0x02ae, B:125:0x02b7, B:127:0x02bf, B:128:0x02c6, B:130:0x02ca, B:132:0x02d0, B:133:0x02da, B:135:0x02e0, B:138:0x02f4, B:143:0x02fe, B:144:0x0302, B:146:0x031d, B:148:0x0325, B:150:0x032d, B:152:0x0337, B:155:0x0348, B:153:0x0340, B:121:0x0299, B:103:0x0223, B:106:0x0234, B:108:0x023d, B:55:0x0147), top: B:168:0x0029 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject a(android.content.Context r17, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d r18, org.json.JSONObject r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 992
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a.a(android.content.Context, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.d, org.json.JSONObject, java.lang.String):org.json.JSONObject");
    }

    public static JSONObject b(Context context, d dVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2 = a(context, dVar, jSONObject, "v1");
            jSONObject2.putOpt("device_info", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.m.b(context));
            return jSONObject2;
        } catch (Exception e2) {
            try {
                String optString = jSONObject2.optString("event_extra");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject3 = new JSONObject(optString);
                    jSONObject3.putOpt("v1_err_msg", e2.toString());
                    jSONObject2.putOpt("event_extra", jSONObject3.toString());
                }
                if (dVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.putOpt("v1_eventId", dVar.v.get("event_id"));
                    jSONObject4.putOpt("v1_err_msg", e2.toString());
                    c0.a(jSONObject4);
                    return jSONObject2;
                }
                return jSONObject2;
            } catch (Throwable unused) {
                return jSONObject2;
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.k
    public String a() {
        return this.a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.b
    public JSONObject a(String str) {
        return this.b;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.b
    public long b() {
        for (char c2 = 'I'; c2 != 'H' && c2 != 'J'; c2 = 'H') {
        }
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.has("params") ? this.b.optJSONObject("params") : this.b;
            if (optJSONObject != null) {
                String optString = optJSONObject.optString("event_extra");
                if (TextUtils.isEmpty(optString)) {
                    return 0L;
                }
                try {
                    return new JSONObject(optString).optLong("eventIndex");
                } catch (JSONException unused) {
                    return 0L;
                }
            }
            return 0L;
        }
        return 0L;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.b
    public long c() {
        JSONObject jSONObject = this.b;
        if (jSONObject != null) {
            JSONObject optJSONObject = jSONObject.has("params") ? this.b.optJSONObject("params") : this.b;
            if (optJSONObject != null) {
                return optJSONObject.optLong("timestamp");
            }
        }
        return 0L;
    }

    public String d() {
        if (TextUtils.isEmpty(this.a) || this.b == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("localId", this.a);
            jSONObject.putOpt("event", this.b);
        } catch (Throwable unused) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "AdEvent{localId='" + this.a + "', event=" + this.b + '}';
    }
}
