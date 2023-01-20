package com.ss.android.socialbase.downloader.d;

import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.exception.g;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.i;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    public static void a(DownloadTask downloadTask, BaseException baseException, int i2) {
        if (downloadTask == null) {
            return;
        }
        try {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo == null) {
                return;
            }
            x monitorDepend = downloadTask.getMonitorDepend();
            boolean isMonitorStatus = DownloadStatus.isMonitorStatus(i2);
            if (!isMonitorStatus && !(isMonitorStatus = a(downloadInfo.getExtraMonitorStatus(), i2)) && monitorDepend != null && (monitorDepend instanceof com.ss.android.socialbase.downloader.depend.c)) {
                isMonitorStatus = a(((com.ss.android.socialbase.downloader.depend.c) monitorDepend).a(), i2);
            }
            if (isMonitorStatus) {
                n depend = downloadTask.getDepend();
                if (depend != null) {
                    depend.a(downloadInfo, baseException, i2);
                }
                a(monitorDepend, downloadInfo, baseException, i2);
                a(com.ss.android.socialbase.downloader.downloader.c.g(), downloadInfo, baseException, i2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean a(int[] iArr, int i2) {
        if (iArr != null && iArr.length > 0) {
            for (int i3 : iArr) {
                if (i2 == i3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(x xVar, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        if (xVar == null) {
            return;
        }
        try {
            String b = xVar.b();
            if (TextUtils.isEmpty(b)) {
                b = "default";
            }
            JSONObject a = a(b, downloadInfo, baseException, i2);
            if (a == null) {
                a = new JSONObject();
            }
            xVar.a(a);
        } catch (Throwable unused) {
        }
    }

    public static void a(b bVar, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        if (bVar == null || !downloadInfo.isNeedSDKMonitor() || TextUtils.isEmpty(downloadInfo.getMonitorScene())) {
            return;
        }
        try {
            JSONObject a = a(downloadInfo.getMonitorScene(), downloadInfo, baseException, i2);
            if (a == null) {
                a = new JSONObject();
            }
            if (i2 == -1) {
                a.put("status", baseException.getErrorCode());
                bVar.a("download_failed", a, null, null);
                return;
            }
            a(i2, a, downloadInfo);
            bVar.a("download_common", a, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(int i2, JSONObject jSONObject, DownloadInfo downloadInfo) throws JSONException {
        String str;
        if (i2 == -5) {
            str = "download_uncomplete";
        } else if (i2 == -4) {
            str = "download_cancel";
        } else if (i2 != -3) {
            str = i2 != -2 ? i2 != 0 ? i2 != 2 ? i2 != 6 ? "" : "download_first_start" : "download_start" : "download_create" : "download_pause";
        } else {
            double downloadSpeed = downloadInfo.getDownloadSpeed();
            if (downloadSpeed >= 0.0d) {
                jSONObject.put("download_speed", downloadSpeed);
            }
            str = "download_success";
        }
        jSONObject.put("status", str);
    }

    public static String a(String str) {
        try {
            return TextUtils.isDigitsOnly(str) ? String.valueOf(Long.valueOf(str).longValue() % 100) : "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private static JSONObject a(String str, DownloadInfo downloadInfo, BaseException baseException, int i2) {
        JSONObject jSONObject;
        String str2;
        String str3;
        String str4;
        int i3;
        String str5;
        String str6;
        String str7;
        JSONObject jSONObject2 = null;
        try {
            jSONObject = new JSONObject();
        } catch (JSONException e2) {
            e = e2;
        }
        try {
            q k2 = com.ss.android.socialbase.downloader.downloader.c.k();
            if (k2 != null) {
                str2 = k2.b();
                str3 = a(str2);
                str4 = k2.a();
                i3 = k2.c();
            } else {
                str2 = "";
                str3 = str2;
                str4 = str3;
                i3 = 0;
            }
            String a = (baseException == null || !(baseException instanceof g)) ? "" : ((g) baseException).a();
            jSONObject.put("event_page", str);
            jSONObject.put("app_id", str4);
            jSONObject.put("device_id", str2);
            jSONObject.put("device_id_postfix", str3);
            jSONObject.put(CommonCode.MapKey.UPDATE_VERSION, i3);
            jSONObject.put("download_status", i2);
            if (downloadInfo != null) {
                jSONObject.put("setting_tag", com.ss.android.socialbase.downloader.g.a.a(downloadInfo.getId()).c("setting_tag"));
                jSONObject.put("download_id", downloadInfo.getId());
                jSONObject.put("name", downloadInfo.getName());
                jSONObject.put("url", downloadInfo.getUrl());
                jSONObject.put("save_path", downloadInfo.getSavePath());
                jSONObject.put("download_time", downloadInfo.getDownloadTime());
                jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
                jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
                jSONObject.put("network_quality", downloadInfo.getNetworkQuality());
                int i4 = 1;
                jSONObject.put("only_wifi", downloadInfo.isOnlyWifi() ? 1 : 0);
                jSONObject.put("need_https_degrade", downloadInfo.isNeedHttpsToHttpRetry() ? 1 : 0);
                jSONObject.put("https_degrade_retry_used", downloadInfo.isHttpsToHttpRetryUsed() ? 1 : 0);
                jSONObject.put("md5", downloadInfo.getMd5() == null ? "" : downloadInfo.getMd5());
                jSONObject.put("chunk_count", downloadInfo.getChunkCount());
                jSONObject.put("is_force", downloadInfo.isForce() ? 1 : 0);
                jSONObject.put("retry_count", downloadInfo.getRetryCount());
                jSONObject.put("cur_retry_time", downloadInfo.getCurRetryTime());
                jSONObject.put("need_retry_delay", downloadInfo.isNeedRetryDelay() ? 1 : 0);
                jSONObject.put("need_reuse_first_connection", downloadInfo.isNeedReuseFirstConnection() ? 1 : 0);
                jSONObject.put("default_http_service_backup", downloadInfo.isNeedDefaultHttpServiceBackUp() ? 1 : 0);
                jSONObject.put("retry_delay_status", downloadInfo.getRetryDelayStatus().ordinal());
                jSONObject.put("backup_url_used", downloadInfo.isBackUpUrlUsed() ? 1 : 0);
                jSONObject.put("download_byte_error_retry_status", downloadInfo.getByteInvalidRetryStatus().ordinal());
                jSONObject.put("forbidden_handler_status", downloadInfo.getAsyncHandleStatus().ordinal());
                jSONObject.put("need_independent_process", downloadInfo.isNeedIndependentProcess() ? 1 : 0);
                jSONObject.put("head_connection_error_msg", downloadInfo.getHeadConnectionException() != null ? downloadInfo.getHeadConnectionException() : "");
                jSONObject.put("extra", downloadInfo.getExtra() != null ? downloadInfo.getExtra() : "");
                if (!downloadInfo.isAddListenerToSameTask()) {
                    i4 = 0;
                }
                jSONObject.put("add_listener_to_same_task", i4);
                jSONObject.put("backup_url_count", downloadInfo.getBackUpUrls() != null ? downloadInfo.getBackUpUrls().size() : 0);
                jSONObject.put("cur_backup_url_index", downloadInfo.getBackUpUrls() != null ? downloadInfo.getCurBackUpUrlIndex() : -1);
                jSONObject.put("forbidden_urls", downloadInfo.getForbiddenBackupUrls() != null ? downloadInfo.getForbiddenBackupUrls().toString() : "");
                jSONObject.put(PushConstants.TASK_ID, TextUtils.isEmpty(downloadInfo.getTaskId()) ? "" : downloadInfo.getTaskId());
                String url = downloadInfo.getUrl();
                if (TextUtils.isEmpty(url)) {
                    str5 = "";
                    str6 = str5;
                    str7 = str6;
                } else {
                    Uri parse = Uri.parse(url);
                    str6 = parse.getHost();
                    str7 = parse.getPath();
                    str5 = parse.getLastPathSegment();
                    if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str5)) {
                        try {
                            str7 = str7.substring(0, str7.length() - str5.length());
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
                jSONObject.put("url_host", str6);
                jSONObject.put("url_path", str7);
                jSONObject.put("url_last_path_segment", str5);
            }
            jSONObject.put("error_code", baseException != null ? baseException.getErrorCode() : 0);
            jSONObject.put("error_msg", baseException != null ? baseException.getErrorMessage() : "");
            jSONObject.put("request_log", a);
            return jSONObject;
        } catch (JSONException e3) {
            e = e3;
            jSONObject2 = jSONObject;
            e.printStackTrace();
            return jSONObject2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:11|(4:68|69|70|(16:72|73|14|(2:49|(1:(2:57|(1:59)(2:60|61)))(1:54))|17|18|(2:22|23)|26|27|28|(1:30)|31|32|(1:44)|35|(2:39|41)(1:38)))|13|14|(0)|49|(1:51)|(0)|17|18|(3:20|22|23)|26|27|28|(0)|31|32|(0)|42|44|35|(0)|39|41) */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0114, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0115, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0058 A[Catch: all -> 0x013a, TRY_LEAVE, TryCatch #3 {all -> 0x013a, blocks: (B:100:0x002f, B:102:0x0033, B:126:0x007f, B:128:0x0095, B:131:0x00a8, B:132:0x00ad, B:134:0x00e9, B:135:0x00fa, B:148:0x012e, B:142:0x0120, B:144:0x0126, B:138:0x0115, B:108:0x0047, B:110:0x004d, B:115:0x0058, B:118:0x0065, B:122:0x006b, B:124:0x0077, B:95:0x0025), top: B:158:0x0025, inners: #0, #2 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00e9 A[Catch: JSONException -> 0x0114, all -> 0x013a, TryCatch #0 {JSONException -> 0x0114, blocks: (B:132:0x00ad, B:134:0x00e9, B:135:0x00fa), top: B:154:0x00ad, outer: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(@androidx.annotation.Nullable com.ss.android.socialbase.downloader.network.g r14, java.lang.String r15, java.lang.String r16, long r17, java.lang.String r19, int r20, java.io.IOException r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22) {
        /*
            Method dump skipped, instructions count: 319
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.a.a(com.ss.android.socialbase.downloader.network.g, java.lang.String, java.lang.String, long, java.lang.String, int, java.io.IOException, com.ss.android.socialbase.downloader.model.DownloadInfo):void");
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, i iVar, boolean z, boolean z2, BaseException baseException, long j2, long j3, boolean z3, long j4, long j5, long j6, JSONObject jSONObject) {
        a("download_io", aVar.b("monitor_download_io"), aVar, downloadInfo, str, null, null, iVar, z, z2, baseException, j2, j3, z3, j4, j5, j6, null);
    }

    public static void a(com.ss.android.socialbase.downloader.g.a aVar, DownloadInfo downloadInfo, String str, String str2, String str3, boolean z, i iVar, BaseException baseException, long j2, long j3) {
        a("segment_io", aVar.b("monitor_segment_io"), aVar, downloadInfo, str, str2, str3, iVar, z, false, baseException, j2, j3, false, -1L, -1L, -1L, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0070 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:87:0x0016, B:89:0x002d, B:106:0x0065, B:108:0x0070, B:112:0x0077, B:114:0x0083, B:115:0x008d, B:119:0x009a, B:121:0x009e, B:122:0x00a4, B:124:0x00a8, B:127:0x00bb, B:129:0x0108, B:130:0x0119, B:132:0x012b, B:134:0x0134, B:135:0x014f, B:147:0x0182, B:140:0x016e, B:142:0x0174, B:100:0x004d, B:104:0x005e, B:103:0x005a), top: B:154:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0108 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:87:0x0016, B:89:0x002d, B:106:0x0065, B:108:0x0070, B:112:0x0077, B:114:0x0083, B:115:0x008d, B:119:0x009a, B:121:0x009e, B:122:0x00a4, B:124:0x00a8, B:127:0x00bb, B:129:0x0108, B:130:0x0119, B:132:0x012b, B:134:0x0134, B:135:0x014f, B:147:0x0182, B:140:0x016e, B:142:0x0174, B:100:0x004d, B:104:0x005e, B:103:0x005a), top: B:154:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x012b A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:87:0x0016, B:89:0x002d, B:106:0x0065, B:108:0x0070, B:112:0x0077, B:114:0x0083, B:115:0x008d, B:119:0x009a, B:121:0x009e, B:122:0x00a4, B:124:0x00a8, B:127:0x00bb, B:129:0x0108, B:130:0x0119, B:132:0x012b, B:134:0x0134, B:135:0x014f, B:147:0x0182, B:140:0x016e, B:142:0x0174, B:100:0x004d, B:104:0x005e, B:103:0x005a), top: B:154:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0134 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:87:0x0016, B:89:0x002d, B:106:0x0065, B:108:0x0070, B:112:0x0077, B:114:0x0083, B:115:0x008d, B:119:0x009a, B:121:0x009e, B:122:0x00a4, B:124:0x00a8, B:127:0x00bb, B:129:0x0108, B:130:0x0119, B:132:0x012b, B:134:0x0134, B:135:0x014f, B:147:0x0182, B:140:0x016e, B:142:0x0174, B:100:0x004d, B:104:0x005e, B:103:0x005a), top: B:154:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0174 A[Catch: all -> 0x018e, TryCatch #1 {all -> 0x018e, blocks: (B:87:0x0016, B:89:0x002d, B:106:0x0065, B:108:0x0070, B:112:0x0077, B:114:0x0083, B:115:0x008d, B:119:0x009a, B:121:0x009e, B:122:0x00a4, B:124:0x00a8, B:127:0x00bb, B:129:0x0108, B:130:0x0119, B:132:0x012b, B:134:0x0134, B:135:0x014f, B:147:0x0182, B:140:0x016e, B:142:0x0174, B:100:0x004d, B:104:0x005e, B:103:0x005a), top: B:154:0x0016 }] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0180 A[ADDED_TO_REGION] */
    /* JADX WARN: Type inference failed for: r17v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(java.lang.String r19, int r20, com.ss.android.socialbase.downloader.g.a r21, com.ss.android.socialbase.downloader.model.DownloadInfo r22, java.lang.String r23, java.lang.String r24, java.lang.String r25, com.ss.android.socialbase.downloader.network.i r26, boolean r27, boolean r28, com.ss.android.socialbase.downloader.exception.BaseException r29, long r30, long r32, boolean r34, long r35, long r37, long r39, org.json.JSONObject r41) {
        /*
            Method dump skipped, instructions count: 403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.d.a.a(java.lang.String, int, com.ss.android.socialbase.downloader.g.a, com.ss.android.socialbase.downloader.model.DownloadInfo, java.lang.String, java.lang.String, java.lang.String, com.ss.android.socialbase.downloader.network.i, boolean, boolean, com.ss.android.socialbase.downloader.exception.BaseException, long, long, boolean, long, long, long, org.json.JSONObject):void");
    }

    public static void a(DownloadInfo downloadInfo, List<com.ss.android.socialbase.downloader.f.i> list) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("segments", com.ss.android.socialbase.downloader.f.i.a(list));
            jSONObject.put("cur_bytes", downloadInfo.getCurBytes());
            jSONObject.put("total_bytes", downloadInfo.getTotalBytes());
            c P = com.ss.android.socialbase.downloader.downloader.c.P();
            if (P != null) {
                P.a(downloadInfo.getId(), "segments_error", jSONObject);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
