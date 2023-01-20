package com.huawei.agconnect.config.impl;

import android.util.Log;
import com.huawei.agconnect.AGCRoutePolicy;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Utils {
    private static final int BUFF_SIZE = 4096;
    public static final String DEFAULT_NAME = "DEFAULT_INSTANCE";
    private static final String TAG = "Utils";

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
                Log.e(TAG, "Exception when closing the 'Closeable'.");
            }
        }
    }

    public static void copy(Reader reader, Writer writer) throws IOException {
        copy(reader, writer, new char[4096]);
    }

    public static void copy(Reader reader, Writer writer, char[] cArr) throws IOException {
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            }
            writer.write(cArr, 0, read);
        }
    }

    public static Map<String, String> fixKeyPathMap(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashMap.put(fixPath(entry.getKey()), entry.getValue());
        }
        return hashMap;
    }

    public static String fixPath(String str) {
        int i2 = 0;
        if (str.length() > 0) {
            while (str.charAt(i2) == '/') {
                i2++;
            }
        }
        return MqttTopic.TOPIC_LEVEL_SEPARATOR + str.substring(i2);
    }

    public static AGCRoutePolicy getRoutePolicyFromJson(String str, String str2) {
        if (str != null) {
            str.hashCode();
            char c2 = 65535;
            switch (str.hashCode()) {
                case 2155:
                    if (str.equals("CN")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 2177:
                    if (str.equals("DE")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 2627:
                    if (str.equals("RU")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 2644:
                    if (str.equals("SG")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            switch (c2) {
                case 0:
                    return AGCRoutePolicy.CHINA;
                case 1:
                    return AGCRoutePolicy.GERMANY;
                case 2:
                    return AGCRoutePolicy.RUSSIA;
                case 3:
                    return AGCRoutePolicy.SINGAPORE;
            }
        }
        if (str2 != null) {
            if (str2.contains("connect-drcn")) {
                return AGCRoutePolicy.CHINA;
            }
            if (str2.contains("connect-dre")) {
                return AGCRoutePolicy.GERMANY;
            }
            if (str2.contains("connect-drru")) {
                return AGCRoutePolicy.RUSSIA;
            }
            if (str2.contains("connect-dra")) {
                return AGCRoutePolicy.SINGAPORE;
            }
        }
        return AGCRoutePolicy.UNKNOWN;
    }

    public static String toString(InputStream inputStream, String str) throws UnsupportedEncodingException, IOException {
        StringWriter stringWriter = new StringWriter();
        copy(new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }
}
