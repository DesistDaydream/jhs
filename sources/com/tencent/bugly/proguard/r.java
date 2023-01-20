package com.tencent.bugly.proguard;

import android.util.Pair;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class r {
    public final Pair<Integer, String> a(List<String> list) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("Atta-Type", "batch-report");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("attaid", "0d000062340").put("token", "2273782735").put("type", "batch").put("version", "v1.0.0");
            JSONArray jSONArray = new JSONArray();
            for (String str : list) {
                jSONArray.put(str);
            }
            jSONObject.put("datas", jSONArray);
            return a("https://h.trace.qq.com/kv", jSONObject.toString(), hashMap);
        } catch (Throwable th) {
            y.b(th);
            return new Pair<>(-1, th.getMessage());
        }
    }

    private Pair<Integer, String> a(String str, String str2, Map<String, String> map) {
        InputStream inputStream;
        HttpURLConnection httpURLConnection;
        String message;
        HttpURLConnection httpURLConnection2;
        InputStream inputStream2;
        DataOutputStream dataOutputStream = null;
        int i2 = -1;
        try {
            httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                a(httpURLConnection2, map);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.connect();
                byte[] bytes = str2.getBytes("UTF-8");
                DataOutputStream dataOutputStream2 = new DataOutputStream(httpURLConnection2.getOutputStream());
                try {
                    dataOutputStream2.write(bytes);
                    dataOutputStream2.flush();
                    dataOutputStream2.close();
                    i2 = httpURLConnection2.getResponseCode();
                    if (i2 >= 400) {
                        inputStream2 = httpURLConnection2.getErrorStream();
                    } else {
                        inputStream2 = httpURLConnection2.getInputStream();
                    }
                } catch (Throwable th) {
                    th = th;
                    httpURLConnection = httpURLConnection2;
                    inputStream = null;
                    dataOutputStream = dataOutputStream2;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                inputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            httpURLConnection = null;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"));
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\r\n");
            }
            bufferedReader.close();
            message = sb.toString();
            if (inputStream2 != null) {
                try {
                    inputStream2.close();
                } catch (Exception e2) {
                    y.b(e2);
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
        } catch (Throwable th4) {
            httpURLConnection = httpURLConnection2;
            inputStream = inputStream2;
            th = th4;
            try {
                y.b(th);
                message = th.getMessage();
                return new Pair<>(Integer.valueOf(i2), message);
            } finally {
                if (dataOutputStream != null) {
                    try {
                        dataOutputStream.close();
                    } catch (Exception e3) {
                        y.b(e3);
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                        y.b(e4);
                    }
                }
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
        return new Pair<>(Integer.valueOf(i2), message);
    }

    private static void a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (httpURLConnection == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }
}
