package com.qiniu.android.bigdata.pipeline;

import com.qiniu.android.utils.FastDatePrinter;
import com.qiniu.android.utils.Json;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public final class Points {

    /* loaded from: classes3.dex */
    public static class LazyHolder {
        private static final FastDatePrinter INSTANCE = new FastDatePrinter("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Calendar.getInstance().getTimeZone(), Locale.getDefault());

        private LazyHolder() {
        }
    }

    private static String buildString(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Boolean)) {
            if (obj instanceof String) {
                return ((String) obj).replace("\n", "\\n").replace("\t", "\\t");
            }
            if (obj instanceof Collection) {
                return Json.encodeList((Collection) obj);
            }
            if (obj instanceof Map) {
                return Json.encodeMap((Map) obj);
            }
            if (obj instanceof Date) {
                return LazyHolder.INSTANCE.format((Date) obj);
            }
            return obj.toString();
        }
        return obj.toString();
    }

    public static <V> StringBuilder formatPoint(Map<String, V> map, StringBuilder sb) {
        for (Map.Entry<String, V> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(buildString(entry.getValue()));
            sb.append("\t");
        }
        sb.replace(sb.length() - 1, sb.length(), "\n");
        return sb;
    }

    public static <V> StringBuilder formatPoints(Map<String, V>[] mapArr) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, V> map : mapArr) {
            formatPoint((Map) map, sb);
        }
        return sb;
    }

    public static <V> StringBuilder formatPointsObjects(List<V> list) {
        StringBuilder sb = new StringBuilder();
        for (V v : list) {
            formatPoint(v, sb);
        }
        return sb;
    }

    public static StringBuilder formatPoint(Object obj, StringBuilder sb) {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        new Points();
        HashMap hashMap = new HashMap();
        for (Field field : declaredFields) {
            try {
                hashMap.put(field.getName(), field.get(obj));
            } catch (IllegalAccessException unused) {
            }
        }
        return formatPoint((Map) hashMap, sb);
    }

    public static StringBuilder formatPoints(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            formatPoint(obj, sb);
        }
        return sb;
    }

    public static <V> StringBuilder formatPoints(List<Map<String, V>> list) {
        StringBuilder sb = new StringBuilder();
        for (Map<String, V> map : list) {
            formatPoint((Map) map, sb);
        }
        return sb;
    }
}
