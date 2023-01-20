package com.xiaomi.push;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import cn.thinkingdata.android.TDConfig;
import com.huawei.hms.framework.common.ContainerUtils;
import com.moor.imkf.lib.jsoup.helper.HttpConnection;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes3.dex */
public class al {
    public static final Pattern a = Pattern.compile("([^\\s;]+)(.*)");
    public static final Pattern b = Pattern.compile("(.*?charset\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f8260c = Pattern.compile("(\\<\\?xml\\s+.*?encoding\\s*=[^a-zA-Z0-9]*)([-a-zA-Z0-9]+)(.*)", 2);

    /* loaded from: classes3.dex */
    public static final class a extends FilterInputStream {
        private boolean a;

        public a(InputStream inputStream) {
            super(inputStream);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i2, int i3) {
            int read;
            if (this.a || (read = super.read(bArr, i2, i3)) == -1) {
                this.a = true;
                return -1;
            }
            return read;
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public int a;
        public Map<String, String> b;

        public String toString() {
            return String.format("resCode = %1$d, headers = %2$s", Integer.valueOf(this.a), this.b.toString());
        }
    }

    public static int a(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return -1;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return -1;
            }
            return activeNetworkInfo.getType();
        } catch (Exception unused) {
            return -1;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static aj a(Context context, String str, String str2, Map<String, String> map, String str3) {
        boolean z;
        BufferedReader bufferedReader;
        aj ajVar = new aj();
        try {
            try {
                try {
                    HttpURLConnection b2 = b(context, b(str));
                    b2.setConnectTimeout(10000);
                    b2.setReadTimeout(TDConfig.DEFAULT_FLUSH_INTERVAL);
                    String str4 = str2;
                    if (str2 == 0) {
                        str4 = "GET";
                    }
                    b2.setRequestMethod(str4);
                    int i2 = 0;
                    if (map != null) {
                        z = "gzip".equalsIgnoreCase(map.get(HttpConnection.CONTENT_ENCODING));
                        for (String str5 : map.keySet()) {
                            b2.setRequestProperty(str5, map.get(str5));
                        }
                    } else {
                        z = false;
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        b2.setDoOutput(true);
                        byte[] bytes = str3.getBytes();
                        OutputStream gZIPOutputStream = z ? new GZIPOutputStream(b2.getOutputStream()) : b2.getOutputStream();
                        try {
                            gZIPOutputStream.write(bytes, 0, bytes.length);
                            gZIPOutputStream.flush();
                            gZIPOutputStream.close();
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                    ajVar.a = b2.getResponseCode();
                    com.xiaomi.a.a.a.c.a("Http POST Response Code: " + ajVar.a);
                    while (true) {
                        String headerFieldKey = b2.getHeaderFieldKey(i2);
                        String headerField = b2.getHeaderField(i2);
                        if (headerFieldKey == null && headerField == null) {
                            try {
                                break;
                            } catch (IOException unused) {
                                bufferedReader = new BufferedReader(new InputStreamReader(new a(b2.getErrorStream())));
                            }
                        } else {
                            ajVar.b.put(headerFieldKey, headerField);
                            i2 = i2 + 1 + 1;
                        }
                    }
                    bufferedReader = new BufferedReader(new InputStreamReader(new a(b2.getInputStream())));
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        String property = System.getProperty("line.separator");
                        for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                            stringBuffer.append(readLine);
                            stringBuffer.append(property);
                        }
                        ajVar.f8259c = stringBuffer.toString();
                        bufferedReader.close();
                        c.a((Closeable) null);
                        c.a((Closeable) null);
                        return ajVar;
                    } catch (IOException e3) {
                        e = e3;
                        throw new IOException("err while request " + str + Constants.COLON_SEPARATOR + e.getClass().getSimpleName());
                    } catch (Throwable th2) {
                        th = th2;
                        throw new IOException(th.getMessage());
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (Throwable th4) {
            c.a((Closeable) null);
            c.a((Closeable) str2);
            throw th4;
        }
    }

    public static aj a(Context context, String str, Map<String, String> map) {
        return a(context, str, "POST", (Map<String, String>) null, a(map));
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2) {
        return a(context, url, z, str, str2, null, null);
    }

    public static InputStream a(Context context, URL url, boolean z, String str, String str2, Map<String, String> map, b bVar) {
        if (context != null) {
            if (url != null) {
                URL url2 = !z ? new URL(a(url.toString())) : url;
                try {
                    HttpURLConnection.setFollowRedirects(true);
                    HttpURLConnection b2 = b(context, url2);
                    b2.setConnectTimeout(10000);
                    b2.setReadTimeout(TDConfig.DEFAULT_FLUSH_INTERVAL);
                    if (!TextUtils.isEmpty(str)) {
                        b2.setRequestProperty("User-Agent", str);
                    }
                    if (str2 != null) {
                        b2.setRequestProperty("Cookie", str2);
                    }
                    if (map != null) {
                        for (String str3 : map.keySet()) {
                            b2.setRequestProperty(str3, map.get(str3));
                        }
                    }
                    if (bVar != null && (url.getProtocol().equals("http") || url.getProtocol().equals("https"))) {
                        bVar.a = b2.getResponseCode();
                        if (bVar.b == null) {
                            bVar.b = new HashMap();
                        }
                        int i2 = 0;
                        while (true) {
                            String headerFieldKey = b2.getHeaderFieldKey(i2);
                            String headerField = b2.getHeaderField(i2);
                            if (headerFieldKey == null && headerField == null) {
                                break;
                            }
                            if (!TextUtils.isEmpty(headerFieldKey) && !TextUtils.isEmpty(headerField)) {
                                bVar.b.put(headerFieldKey, headerField);
                            }
                            i2++;
                        }
                    }
                    return new a(b2.getInputStream());
                } catch (IOException e2) {
                    throw new IOException("IOException:" + e2.getClass().getSimpleName());
                } catch (Throwable th) {
                    throw new IOException(th.getMessage());
                }
            }
            throw new IllegalArgumentException("url");
        }
        throw new IllegalArgumentException("context");
    }

    public static String a(Context context, URL url) {
        return a(context, url, false, null, "UTF-8", null);
    }

    public static String a(Context context, URL url, boolean z, String str, String str2, String str3) {
        InputStream inputStream;
        try {
            inputStream = a(context, url, z, str, str3);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            StringBuilder sb = new StringBuilder(1024);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str2));
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr);
                if (-1 == read) {
                    c.a(inputStream);
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } catch (Throwable th2) {
            th = th2;
            c.a(inputStream);
            throw th;
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        new String();
        return String.format("%s&key=%s", str, aq.a(String.format("%sbe988a6134bc8254465424e5a70ef037", str)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static String a(String str, Map<String, String> map, File file, String str2) {
        if (!file.exists()) {
            return null;
        }
        String name = file.getName();
        try {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setReadTimeout(TDConfig.DEFAULT_FLUSH_INTERVAL);
                httpURLConnection.setConnectTimeout(10000);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=*****");
                if (map != null) {
                    for (Map.Entry<String, String> entry : map.entrySet()) {
                        httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
                    }
                }
                httpURLConnection.setFixedLengthStreamingMode(name.length() + 77 + ((int) file.length()) + str2.length());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes("--*****\r\n");
                dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"" + str2 + "\";filename=\"" + file.getName() + "\"\r\n");
                dataOutputStream.writeBytes("\r\n");
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        dataOutputStream.write(bArr, 0, read);
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("*****");
                    dataOutputStream.writeBytes("--");
                    dataOutputStream.writeBytes("\r\n");
                    dataOutputStream.flush();
                    StringBuffer stringBuffer = new StringBuffer();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new a(httpURLConnection.getInputStream())));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                String stringBuffer2 = stringBuffer.toString();
                                c.a(fileInputStream);
                                c.a(bufferedReader);
                                return stringBuffer2;
                            }
                            stringBuffer.append(readLine);
                        } catch (IOException e2) {
                            e = e2;
                            throw new IOException("IOException:" + e.getClass().getSimpleName());
                        } catch (Throwable th) {
                            th = th;
                            throw new IOException(th.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (IOException e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            c.a((Closeable) null);
            c.a((Closeable) file);
            throw th4;
        }
    }

    public static String a(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getKey() != null && entry.getValue() != null) {
                try {
                    stringBuffer.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                    stringBuffer.append("=");
                    stringBuffer.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                    stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
                } catch (UnsupportedEncodingException e2) {
                    com.xiaomi.a.a.a.c.a("Failed to convert from params map to string: " + e2);
                    com.xiaomi.a.a.a.c.a("map: " + map.toString());
                    return null;
                }
            }
        }
        if (stringBuffer.length() > 0) {
            stringBuffer = stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    public static HttpURLConnection b(Context context, URL url) {
        return (HttpURLConnection) (("http".equals(url.getProtocol()) && b(context)) ? url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("10.0.0.200", 80))) : url.openConnection());
    }

    private static URL b(String str) {
        return new URL(str);
    }

    public static boolean b(Context context) {
        ConnectivityManager connectivityManager;
        if ("CN".equalsIgnoreCase(((TelephonyManager) context.getSystemService("phone")).getSimCountryIso())) {
            try {
                connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            } catch (Exception unused) {
            }
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return false;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            return !TextUtils.isEmpty(extraInfo) && extraInfo.length() >= 3 && extraInfo.contains("ctwap");
        }
        return false;
    }

    public static boolean c(Context context) {
        return a(context) >= 0;
    }

    public static boolean d(Context context) {
        boolean z;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                    if (networkCapabilities != null) {
                        z = networkCapabilities.hasCapability(16);
                    }
                } catch (Exception unused) {
                }
            } else {
                z = c(context);
            }
            return z && e(context);
        }
        z = false;
        if (z) {
            return false;
        }
    }

    public static boolean e(Context context) {
        NetworkInfo networkInfo;
        try {
            networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception unused) {
            networkInfo = null;
        }
        return networkInfo != null && networkInfo.isConnected();
    }

    public static boolean f(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && 1 == activeNetworkInfo.getType();
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean g(Context context) {
        NetworkInfo k2 = k(context);
        return k2 != null && k2.getType() == 0 && 20 == k2.getSubtype();
    }

    public static boolean h(Context context) {
        NetworkInfo k2 = k(context);
        return k2 != null && k2.getType() == 0 && 13 == k2.getSubtype();
    }

    public static boolean i(Context context) {
        NetworkInfo k2 = k(context);
        if (k2 != null && k2.getType() == 0) {
            String subtypeName = k2.getSubtypeName();
            if (!"TD-SCDMA".equalsIgnoreCase(subtypeName) && !"CDMA2000".equalsIgnoreCase(subtypeName) && !"WCDMA".equalsIgnoreCase(subtypeName)) {
                switch (k2.getSubtype()) {
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        break;
                    case 4:
                    case 7:
                    case 11:
                    case 13:
                    default:
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean j(Context context) {
        NetworkInfo k2 = k(context);
        if (k2 != null && k2.getType() == 0) {
            int subtype = k2.getSubtype();
            return subtype == 1 || subtype == 2 || subtype == 4 || subtype == 7 || subtype == 11;
        }
        return false;
    }

    public static NetworkInfo k(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            return connectivityManager.getActiveNetworkInfo();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String l(Context context) {
        if (f(context)) {
            return "wifi";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return "";
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return "";
            }
            return (activeNetworkInfo.getTypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getSubtypeName() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + activeNetworkInfo.getExtraInfo()).toLowerCase();
        } catch (Exception unused) {
            return "";
        }
    }
}
