package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_19do;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.mapplog.util.TTEncryptUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.umeng.analytics.pro.am;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import k.b.a.a.o.e;

/* loaded from: classes.dex */
public class a {
    private static InterfaceC0055a a;
    private static boolean b;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_new1.bykvm_if122.bykvm_19do.bykvm_19do.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0055a {
        boolean a();

        boolean b();

        boolean c();
    }

    private static Uri a(String str, String str2, int i2, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i2 > 0) {
                sb.append(':');
                sb.append(i2);
            }
        }
        if (str3 == null || !str3.startsWith(MqttTopic.TOPIC_LEVEL_SEPARATOR)) {
            sb.append(Attributes.InternalPrefix);
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append(e.a);
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return Uri.parse(sb.toString());
    }

    private static String a(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static String a(String str, List<Pair<String, String>> list) {
        if (TextUtils.isEmpty(str) || a == null || b) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri parse = Uri.parse(str);
            a(parse, linkedHashMap);
            LinkedList linkedList = new LinkedList();
            a(linkedHashMap, linkedList, "device_id");
            a(linkedHashMap, linkedList, am.ai);
            a(linkedHashMap, linkedList, am.F);
            a(linkedHashMap, linkedList, "uuid");
            a(linkedHashMap, linkedList, "openudid");
            String a2 = a((List<Pair<String, List<String>>>) linkedList, false, "UTF-8");
            if (TextUtils.isEmpty(a2)) {
                return str;
            }
            byte[] bytes = a2.getBytes();
            byte[] a3 = TTEncryptUtils.a(bytes, bytes.length);
            if (a3 != null) {
                String encodeToString = Base64.encodeToString(a3, 2);
                LinkedList linkedList2 = new LinkedList();
                if (a.b()) {
                    LinkedList linkedList3 = new LinkedList();
                    linkedList3.add(encodeToString);
                    linkedList2.add(new Pair("ss_queries", linkedList3));
                }
                if (a.c() && list != null) {
                    list.add(new Pair<>("X-SS-QUERIES", a(encodeToString, "UTF-8")));
                }
                if (!linkedHashMap.isEmpty()) {
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        if (entry != null) {
                            linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                        }
                    }
                }
                return a(parse.getScheme(), parse.getHost(), parse.getPort(), parse.getPath(), a((List<Pair<String, List<String>>>) linkedList2, true, "UTF-8"), parse.getFragment()).toString();
            }
            return str;
        } catch (Throwable th) {
            th.printStackTrace();
            return str;
        }
    }

    private static String a(List<Pair<String, List<String>>> list, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, List<String>> pair : list) {
            String str2 = (String) pair.first;
            if (z) {
                str2 = a(str2, str);
            }
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String str3 : list2) {
                    if (z) {
                        str3 = str3 != null ? a(str3, str) : "";
                    }
                    if (sb.length() > 0) {
                        sb.append(ContainerUtils.FIELD_DELIMITER);
                    }
                    sb.append(str2);
                    sb.append("=");
                    sb.append(str3);
                }
            }
        }
        return sb.toString();
    }

    public static void a(Uri uri, Map<String, List<String>> map) throws IOException {
        String[] split;
        if (uri == null) {
            throw new IOException("parseUrl url is null !!!");
        }
        if (map != null) {
            try {
                String query = uri.getQuery();
                if (query != null) {
                    for (String str : query.split(ContainerUtils.FIELD_DELIMITER)) {
                        int indexOf = str.indexOf("=");
                        if (indexOf >= 0) {
                            String decode = URLDecoder.decode(str.substring(0, indexOf), "UTF-8");
                            List<String> list = map.get(decode);
                            if (list == null) {
                                list = new LinkedList<>();
                            }
                            list.add(URLDecoder.decode(str.substring(indexOf + 1), "UTF-8"));
                            map.put(decode, list);
                        } else {
                            String decode2 = URLDecoder.decode(str, "UTF-8");
                            List<String> list2 = map.get(decode2);
                            if (list2 == null) {
                                list2 = new LinkedList<>();
                            }
                            list2.add("");
                            map.put(decode2, list2);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
                throw new IOException("parseUrl url is null !!!");
            }
        }
    }

    private static boolean a(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
            return false;
        }
        list.add(new Pair<>(str, map.get(str)));
        if (!a.a()) {
            map.remove(str);
        }
        return true;
    }
}
