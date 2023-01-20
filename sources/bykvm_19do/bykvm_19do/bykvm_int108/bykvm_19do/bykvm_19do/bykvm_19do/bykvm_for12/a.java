package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.d;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import com.baidu.mobads.sdk.internal.bp;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.qiniu.android.collect.ReportItem;
import com.ss.android.download.api.constant.BaseConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a {
    private static final LinkedList<String> a;
    private static final LinkedList<String> b;

    /* renamed from: c */
    private static final LinkedList<String> f1085c;

    /* renamed from: d */
    private static HashMap<String, Integer> f1086d;

    static {
        new LinkedList();
        a = new LinkedList<>();
        b = new LinkedList<>();
        f1085c = new LinkedList<>();
        new HashMap();
        f1086d = null;
    }

    private static String a() {
        String sb;
        synchronized (a.class) {
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = f1085c.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static String a(int i2) {
        switch (i2) {
            case 1:
                return "flush once";
            case 2:
                return "flush memory db";
            case 3:
                return "flush memory";
            case 4:
                return "new event";
            case 5:
                return "server busy";
            case 6:
                return "empty message";
            case 7:
                return "net error";
            default:
                return "default";
        }
    }

    public static void a(int i2, List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, long j2) {
        if (j.l().b().e()) {
            long currentTimeMillis = System.currentTimeMillis() - j2;
            c.a("uploadCost:" + currentTimeMillis);
            if (i2 == 200) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a aVar = d.f1116h;
                aVar.b0().getAndAdd(currentTimeMillis);
                aVar.M().incrementAndGet();
                aVar.T().getAndAdd(list.size());
                aVar.Q().getAndAdd(list.size());
                return;
            }
            c.b("-------AdThread code is " + i2 + " error  ------------");
            (i2 == -1 ? d.f1116h.S() : d.f1116h.R()).getAndAdd(list.size());
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a aVar2 = d.f1116h;
            aVar2.x().getAndAdd(currentTimeMillis);
            aVar2.L().incrementAndGet();
        }
    }

    public static void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        String jSONObject;
        try {
            if (aVar.b() == 0 && j.l().b() != null && j.l().b().f()) {
                JSONObject d2 = aVar.d();
                String c2 = c(aVar);
                if (a(c2)) {
                    return;
                }
                e(aVar);
                String optString = d2.optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                if (TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("will_send_labels", d(c2 + "_" + g(aVar)));
                    jSONObject2.put("send_success_valid_labels", a());
                    jSONObject = jSONObject2.toString();
                } else {
                    JSONObject jSONObject3 = new JSONObject(optString);
                    if (TextUtils.isEmpty(jSONObject3.optString("will_send_labels"))) {
                        jSONObject3.put("will_send_labels", d(c2 + "_" + g(aVar)));
                        jSONObject3.put("send_success_valid_labels", a());
                    }
                    jSONObject = jSONObject3.toString();
                }
                d2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
            }
        } catch (Exception e2) {
            c.b(e2.getMessage());
        }
    }

    private static void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, String str, g gVar) {
        String c2 = c(aVar);
        if (a(c2)) {
            return;
        }
        String e2 = e(aVar);
        if (aVar.b() == 0 && gVar.f()) {
            b(c2 + "_" + g(aVar) + "_" + e2 + "_" + str);
        }
    }

    public static void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, int i2) {
        try {
            if (j.l().b().e()) {
                for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
                    if (aVar != null && aVar.h() != 0) {
                        long currentTimeMillis = System.currentTimeMillis();
                        long h2 = aVar.h();
                        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a aVar2 = d.f1116h;
                        aVar2.g0().incrementAndGet();
                        aVar2.P().getAndAdd(currentTimeMillis - h2);
                        aVar.a(System.currentTimeMillis());
                    }
                    if (aVar != null) {
                        a(aVar);
                    }
                }
                d.f1116h.t().getAndAdd(list.size());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, int i2, String str) {
        StringBuilder sb;
        String str2;
        g b2 = j.l().b();
        if (b2 == null || !b2.c() || list == null || d()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z = false;
        for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
            if (aVar.b() == 0) {
                JSONObject d2 = aVar.d();
                String c2 = c(aVar);
                if (aVar.c() == 3) {
                    if (d2 != null) {
                        c2 = d2.optString("event");
                    }
                    sb2.append(" [v3:");
                    sb2.append(c2);
                } else {
                    long f2 = f(aVar);
                    long g2 = g(aVar);
                    int d3 = d(aVar);
                    sb2.append(" [");
                    sb2.append(f2);
                    sb2.append("_");
                    sb2.append(c2);
                    if (g2 != 0) {
                        sb2.append("_");
                        sb2.append(g2);
                    }
                    if (d3 != 0) {
                        sb2.append("_");
                        sb2.append(d3);
                    }
                }
                sb2.append("] ");
                z = true;
            } else if (aVar.b() == 1) {
                String j2 = j(aVar);
                int i3 = i(aVar);
                sb2.append(" [");
                sb2.append(i3);
                sb2.append("_");
                sb2.append(j2);
                sb2.append("] ");
            }
        }
        if (z) {
            sb = new StringBuilder();
            str2 = "ads:";
        } else {
            sb = new StringBuilder();
            str2 = "stats:";
        }
        sb.append(str2);
        sb.append((Object) sb2);
        sb.append(a(i2));
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        sb.append(str);
        sb.append(",total:");
        sb.append(list.size());
        c.c("_upload", sb.toString());
    }

    public static void a(List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> list, String str) {
        try {
            g b2 = j.l().b();
            if (b2 == null || !b2.e() || list == null) {
                return;
            }
            for (bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar : list) {
                if (aVar != null) {
                    a(aVar, str, b2);
                }
            }
        } catch (Exception e2) {
            c.b(e2.getMessage());
        }
    }

    public static void a(JSONObject jSONObject, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.a aVar) {
        g b2 = j.l().b();
        if (b2 != null && b2.c() && c()) {
            c.a("log_show_query :" + jSONObject.optString(TTDownloadField.TT_LABEL) + ExpandableTextView.N + ((int) aVar.e()));
        }
    }

    public static void a(boolean z, int i2, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        g b2 = j.l().b();
        if (d() || b2 == null || !b2.c()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("needUpload:");
        sb.append(z);
        sb.append(",message:");
        sb.append(a(i2));
        String j2 = j(aVar);
        if (!TextUtils.isEmpty(j2)) {
            sb.append(",type:");
            sb.append(j2);
        }
        String c2 = c(aVar);
        if (!TextUtils.isEmpty(c2)) {
            sb.append(",label:");
            sb.append(c2);
        }
        c.c("_save", sb.toString());
    }

    public static boolean a(String str) {
        HashMap<String, Integer> hashMap = f1086d;
        if (hashMap == null || str == null) {
            return false;
        }
        return hashMap.containsKey(str);
    }

    public static void b(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        String c2;
        String sb;
        try {
            if (b()) {
                g b2 = j.l().b();
                if (!TextUtils.isEmpty(aVar.i())) {
                    b.a(d.f1116h.a0(), 1);
                }
                if (b2 == null || !b2.c()) {
                    return;
                }
                if (aVar.b() == 1) {
                    sb = "stats,[type:" + j(aVar) + ",index:" + i(aVar) + ",localId:" + aVar.i() + ",sessionId:" + h(aVar) + "]";
                } else if (aVar.b() != 0) {
                    return;
                } else {
                    if (aVar.c() != 3) {
                        StringBuilder sb2 = new StringBuilder();
                        long g2 = g(aVar);
                        int i2 = (g2 > 0L ? 1 : (g2 == 0L ? 0 : -1));
                        if (i2 != 0) {
                            sb2.append("v1_core [");
                            sb2.append("label:");
                            c2 = c(aVar);
                        } else {
                            sb2.append("v1_debug [");
                            sb2.append("label:");
                            c2 = c(aVar);
                        }
                        sb2.append(c2);
                        long f2 = f(aVar);
                        if (f2 != 0) {
                            sb2.append(", index:");
                            sb2.append(f2);
                        }
                        if (i2 != 0) {
                            sb2.append(", validIndex:");
                            sb2.append(g2);
                        }
                        sb2.append(", localId:");
                        sb2.append(aVar.i());
                        sb2.append(", sessionId:");
                        sb2.append(h(aVar));
                        sb2.append("]");
                        sb = sb2.toString();
                    } else if (aVar.d() != null) {
                        String optString = aVar.d().optString("event");
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("v3,[");
                        sb3.append("label:");
                        sb3.append(optString);
                        long f3 = f(aVar);
                        if (f3 != 0) {
                            sb3.append(", index:");
                            sb3.append(f3);
                        }
                        long g3 = g(aVar);
                        if (g3 != 0) {
                            sb3.append(", validIndex:");
                            sb3.append(g3);
                        }
                        sb3.append(", localId:");
                        sb3.append(aVar.i());
                        sb3.append(", sessionId:");
                        sb3.append(h(aVar));
                        sb3.append("]");
                        sb = sb3.toString();
                    } else {
                        sb = "v3_error";
                    }
                }
                c.c("_delete", sb);
            }
        } catch (Exception e2) {
            c.b(e2.getMessage());
        }
    }

    private static void b(String str) {
        synchronized (a.class) {
            LinkedList<String> linkedList = f1085c;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
            }
            linkedList.add(str);
        }
    }

    private static boolean b() {
        g b2 = j.l().b();
        return b2 != null && b2.d() == 0;
    }

    public static String c(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar == null || aVar.d() == null || d()) {
            return null;
        }
        return aVar.d().optString(aVar.c() == 3 ? "event" : TTDownloadField.TT_LABEL);
    }

    private static String c(String str) {
        String sb;
        synchronized (a.class) {
            LinkedList<String> linkedList = a;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
            }
            linkedList.add(str);
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static boolean c() {
        return b() || e();
    }

    public static int d(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        int optInt;
        synchronized (a.class) {
            if (aVar != null) {
                if (aVar.d() != null && b()) {
                    try {
                        optInt = new JSONObject(aVar.d().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optInt("sdk_event_self_count");
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            }
            optInt = 0;
        }
        return optInt;
    }

    private static String d(String str) {
        String sb;
        synchronized (a.class) {
            LinkedList<String> linkedList = b;
            if (linkedList.size() >= 10) {
                linkedList.removeFirst();
            }
            linkedList.add(str);
            StringBuilder sb2 = new StringBuilder();
            Iterator<String> it = linkedList.iterator();
            while (it.hasNext()) {
                sb2.append(it.next());
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public static boolean d() {
        g b2 = j.l().b();
        return b2 != null && b2.d() == 2;
    }

    public static String e(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar != null && aVar.d() != null && !d()) {
            String optString = aVar.d().optString("log_extra");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    return new JSONObject(optString).optString(ReportItem.RequestKeyRequestId);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return null;
    }

    private static boolean e() {
        g b2 = j.l().b();
        return b2 != null && b2.d() == 1;
    }

    public static long f(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar != null && aVar.d() != null && b()) {
            try {
                return new JSONObject(aVar.d().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optLong("sdk_event_index");
            } catch (Exception e2) {
                c.b(e2.getMessage());
            }
        }
        return 0L;
    }

    public static void f() {
        if (f1086d != null) {
            return;
        }
        String[] strArr = {"first_view", "open_splash", "ad_landing_webview_init", "show_failed_topview", "adstyle_template_show", "splash_init_monitor_first", "download_video_succeed", "shake_skip", "receive", "video_over_auto", "render_time", "splash_ad", "preload_start", "mute", "covered", "download_image_failed", "splash_init_monitor_all", "preload_success_time", "download_video_start_sdk", "download_video_count", "not_showing_reason", "download_image_succeed", "load_video_success", "launch_covered", "download_video_prepare", "download_video_start", "boarding", "ad_wap_stat", "splash_pick", "preload_fail", "should_show", "adstyle_template_fill", "unmute", "preload_success", "show_failed", "stop_showing_monitor", "download_video_no_download", "track_url", "download_creative_duration", "adstyle_template_render", "download_video_count_splash_sdk", "landing_preload_finish", "adstyle_template_load", "load_ad_duration", "client_false_show", "client_false", "download_video_failed", "data_invalid", "topview_boarding", "topview_start_download", "topview_show_confirmed", "splash_start_download", "topview_show_rejected", "splash_no_download", "redownload_video_count", "topview_other_show", "topview_no_download", "ad_selected", "invalid_model", "topview_deliver", "ad_no_selected", "topview_ad_download_retry_label", "request", "response", "parse_finished", "front_performance", "ad_resp", "ad_resp_nodata", "preload_finish", "transit_show", "splash_switch", "block_splash_F2", "render_picture_time", "network_type", "play_start_error", "load_video_error", "render_picture_timeout", "py_loading_success", "download_status", "first_screen_load_finish", "landing_preload_failed", "data_received", "preload_result", "show_result", "reponse", "valid_time", "brand_satefy_context", "topview_ad_link_fail_label", "end_feed_request", "start_feed_request", "set_feed_data", "delayinstall_conflict_with_back_dialog", "clean_fetch_apk_head_failed", "cleanspace_download_after_quite_clean", "fps_too_low", "open_policy", "landing_perf_stats", "preload_topview", "show_effect_start", "dislike_monitor", "hour_show", "hour_skip", "triggered", "click_sound_switch", "enter_loft", "download_resume", "install_view_result", "contiguous_ad_event", "contiguous_ad_remove_event", "report_monitor", "open_landing_blank", "dynamic_ad", "report_load_failed", "ad_download_failed", "download_video_start_first_sdk", "splash_receive", "video_play", "clean_fetch_apk_head_switch_close", "label_external_permission", "pause_reserve_wifi_switch_status", "landing_download_dialog_show", "download_connect", "download_uncompleted", "pause_reserve_wifi_dialog_show", "download_io", "pause_reserve_wifi_confirm", "skvc_load_time", "segment_io", "click_no", "pause_reserve_wifi_cancel_on_wifi", "udp_stop", "mma_url", "error_save_sp", "download_notification_try_show", "ttd_pref_monitor", "item_above_the_fold_stay_time", "ttdownloader_unity", "bdad_query_log", "bdad_load_finish", "bdad_load", "bdad_load_fail", "undefined", "valid_stock", "show_filter", "splash_pk_result", "endcard_page_info", "page_on_create", "statistics_feed_docker", "show_search_card_word", "ad_new_video_render_start_label", "ad_new_video_play_start_label", "ad_new_video_ad_patch_data_set_null_label", "ad_new_video_ad_patch_play_label", "ad_new_video_ad_patch_render_label", "debug_touch_start", "try_second_request", "egg_unzip_success", "tap_2", "anti_0_result", "anti_2_result", "egg_unzip_no_start", "preload_no_start", "bind_impression_212202", "guide_auth_dialog_cancel", "show_im_entry", "sub_reco_impression_v2", "sync_request_log_mask", "no_send_sync_request", "load_timeout", "send_sync_request", "sync_request_not_show", "show_subv_tt_video_food", "track", "custom_event", "rd_landing_page_stat", "update_local_data", "showlimit", "upload_result", "debug_othershow", "debug_otherclick", "ad_show_time", "push_launch", "union_send_duplicate", "mnpl_js_finish_load", "mnpl_resource_finish_load", "mnpl_material_render_timeout", "mnpl_render_timing", "mnpl_vedio_interactive_timegap", "click_non_rectify_area", "start_impression", "end_impression", "picture_render_time", "splash_stop_show", "skip_post", "skan_show_start", "skan_show_end", "load_video_start", "rifle_ad_monitor", "download_video_redownload", "splash_video_quality", "splash_video_end", "splash_video_pause", "splash_video_failed", "adtrace_start_clear", "adtrace_clear_past_data", "adtrace_end_clear", "adtrace_write_success", "adtrace_write_failed", "adtrace_read_result", "adtrace_read_success", "adtrace_read_failed", "pick_model", "cache_model", "adtrace_reparse_file", "deeplink_failed_all", "ad_live_degenerate", "ad_live_miss", "live_play_fail", "sko_show_success", "sko_show_fail", "commerce_apps_open", "commerce_apps_jump", "pic_card_show", "live_ad_card_render_finish", "adtrace_select", "received_card_status", "live_ad_page_load_success", "mp_download_result", "download_video_cancel", "jump_count", "adtrace_try_show", "show_cart_entrance", "live_ad_page_load_fail", "click_interacted", "pop_up", "pop_up_cancel", "stream_loadtime", "mnpl_guide_comp_render", "thirdquartile", "customer_feed_pause", "customer_play_start", "customer_feed_break", "click_area_log", "customer_feed_continue", "customer_feed_play", "mnpl_resource_start_preload", "mnpl_resource_finish_preload", "customer_feed_over", "get_preload_ad", "web_inspect_status", "web_report_status", "preload_begin", "preload_end", "open_begin", "open_end", "pangle_live_sdk_monitor", bp.o, "rifle_load_state", "rifle_uri_load_state", "component_init", "component_release", "ad_lynx_download_sendAdLog", "dynamic2_render", "lynx_card_show", "pop_up_download", "live_shelf_commodity_show", "unity_fe_click", "enter_ads_explain", "adx_ads_switch", "personal_ads_switch", "qc_product_picture_cancel", "qc_product_picture_save", "qc_product_picture_press", "qc_product_detail_show", "qc_price_instruction_click", "qc_edit_sku_num_click", "service_description_page_duration", "enter_business_qualification_page ", "service_description_page_show", "order_words_fe", "qc_payment_mode_show", "qc_click_ali_pay", "qc_district_addr_click", "qc_auto_information_add", "qc_dial_consult_cancel_btn_click", "qc_dial_consult_show", "qc_maomadeng_click", "qc_maomadeng_show", "slide_product_big_picture", "qc_service_description_close", "appstore_manager_request", "preload_video_result", "preload_video_start", "adtrace_bind", "topview_ad_link_match_event", "skip_leisure_interact_render", "click_start_download", "ad_lynx_landing_page_exception", "lynx_page_res_download_monitor_event", "live_fail", "live_over", "render_live_picture_success", "render_live_picture_fail", "live_play_success", "live_play_close", "item_play_pver", "ad_gap_info", "item_play_over", "has_period_first_chance", "enter_live_auto", "mnpl_material_video_scene_show", "ad_rerank", "in_web_click", "post_request_failed", "destroy", "bidding_load", "bidding_receive", "in_web_scroll", "tobsdk_livesdk_live_show", "xigua_ad_rerank", "applink_unity", "top_ad_show", "top_button_show", "skip_button_show", "skip_click", "shake_show", "skip_result", "show_personal_compliance_button_click", "personal_compliance_click", "ad_click_result", "ad_preload_video", "popup_show", "topview_feed_down", "qr_scan", "qr_show", "topview_popup_show", "topview_feed_over", "topview_feed_show", "feed_down", "engine_ad_send", "permission_click", "policy_click", "download_start_click", "mini_playable_style_report", "load_detect", "aweme_show_info", "click_convert_anchor_detail_page", "click_anchor_gift_button", "show_anchor_gift_page", "click_anchor_gift_card", "show_anchor_gift_card", "anchor_convert_button", "show_anchor_page", "search_result_click", "sdk_session_launch", "not_use_app_link_sdk", "click_ios_check", "auto_open", "bind_click_area", "page_load", "show_finish", "next_fresh", "play_ready", "splash_pk_time", "unshow", "feed_show_failed", "othershow_cancel", "lu_cache", "realtime_splash_result", "channel_override_result", "internal_jump_live_status", "mnpl_video_play_backward", "splash_enter_foreground", "splash_enter_background", "button_light", "long_press", "webview_material_missing_key_error", "live_life_project_click_card", "mnpl_click_event", "show_anchor_convert_button", "bdar_log_info", "bdar_ad_request", "bdar_lynx_template_load_time", "bdar_lynx_fallback", "bdar_fetch_template_data", "bdar_lynx_render_time", "bdar_video_play_effective", "bdar_video_first_frame", "bdar_lynx_jsb_error", "invalidate_back_url_monitor_event", "lynx_page_plugin_exception_event", "live_custom_interaction", "pinch", "if_splash_card", "splash_card_show", "card_show_fail", "splash_card_click", "splash_card_close", "wind_icon_click", "excluded", "show_error", "toutiao_ad_receive", "show_ad", "toutiao_ad_excluded", "close_card", "lynx_status", "qpon_join", "apk_download_user", "comment_key_word_show", "v3_show_ad", "show_wish_button", "enterSection", "single_comment_show", "enter_product_detail", "xigua_ad_request", "qpon_apply", "splash_total_duration", "splash_render_duration", "download_template_duration", "homepage_hot", "homepage_follow", "homepage_fresh", "video_play_success", "general_search", "video_render_cost", "single_ad_render_cost", "unexpected_accurate_pause", "mnpl_interact_skip", "web_report_request_url", "web_report_init_status", "first_request", "video_ended", "mnpl_script_error", "open_wechat_failed_shake", "open_wechat_shacke", "open_wechat_success_shake", "options_popup", "close_pers_ads_type", "check_closed_type", "ad_guide_panel", "learn_ads", "learn_adx_ads", "learn_pers_ads", "resume_closed_type", "twist", "open_wechat_shake"};
        f1086d = new HashMap<>(446);
        for (int i2 = 0; i2 < 446; i2++) {
            f1086d.put(strArr[i2], 1);
        }
    }

    public static long g(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar != null && aVar.d() != null && b()) {
            try {
                return new JSONObject(aVar.d().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optLong("sdk_event_valid_index");
            } catch (Exception e2) {
                c.b(e2.getMessage());
            }
        }
        return 0L;
    }

    private static String h(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar != null && aVar.d() != null && b()) {
            try {
                return new JSONObject(aVar.d().optString(aVar.b() == 1 ? "event_extra" : BaseConstants.EVENT_LABEL_AD_EXTRA_DATA)).optString("sdk_session_id");
            } catch (JSONException e2) {
                c.b(e2.getMessage());
            }
        }
        return null;
    }

    public static int i(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar != null && aVar.d() != null && b()) {
            try {
                return new JSONObject(aVar.d().optString("event_extra")).optInt("stats_index");
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return -1;
    }

    public static String j(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (aVar == null || aVar.d() == null || d()) {
            return null;
        }
        return aVar.d().optString("type");
    }

    public static void k(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        String jSONObject;
        try {
            if (j.l().b().e()) {
                d.f1116h.b(System.currentTimeMillis() - aVar.a());
                aVar.b(System.currentTimeMillis());
                if (aVar.b() == 0 && j.l().b() != null && j.l().b().f()) {
                    String c2 = c(aVar);
                    if (a(c2)) {
                        return;
                    }
                    JSONObject d2 = aVar.d();
                    String optString = aVar.d().optString(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA);
                    if (TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("save_success_labels", c(c2 + "_" + g(aVar)));
                        jSONObject = jSONObject2.toString();
                    } else {
                        JSONObject jSONObject3 = new JSONObject(optString);
                        if (TextUtils.isEmpty(jSONObject3.optString("save_success_labels"))) {
                            jSONObject3.put("save_success_labels", c(c2 + "_" + g(aVar)));
                        }
                        jSONObject = jSONObject3.toString();
                    }
                    d2.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject);
                }
            }
        } catch (Exception unused) {
        }
    }
}
