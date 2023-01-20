package com.meizu.cloud.pushsdk.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a {
    private static a a;
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private byte[] f4609c;

    /* renamed from: d  reason: collision with root package name */
    private byte[] f4610d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f4611e;

    /* renamed from: f  reason: collision with root package name */
    private byte[] f4612f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f4613g;

    /* renamed from: h  reason: collision with root package name */
    private PublicKey f4614h;

    /* renamed from: i  reason: collision with root package name */
    private final SharedPreferences f4615i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedPreferences f4616j;

    /* renamed from: k  reason: collision with root package name */
    private long f4617k = 0;

    private a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.x.y.1", 0);
        this.f4615i = sharedPreferences;
        this.f4616j = context.getSharedPreferences("com.x.y.2", 0);
        Integer.parseInt(sharedPreferences.getString("keyTimeout", "0"));
        sharedPreferences.getLong("createDate", 0L);
        e();
        byte[] bArr = this.f4609c;
        if (bArr != null && bArr.length != 0) {
            byte[] bArr2 = this.f4610d;
            if (bArr2 == null || bArr2.length == 0) {
                PublicKey b2 = b(context);
                this.f4614h = b2;
                if (b2 != null) {
                    h();
                    return;
                }
                return;
            }
            return;
        }
        PublicKey b3 = b(context);
        this.f4614h = b3;
        if (b3 != null) {
            f();
            return;
        }
        sharedPreferences.edit().clear().apply();
        try {
            d();
            PublicKey b4 = b(context);
            this.f4614h = b4;
            if (b4 != null) {
                f();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static a a() {
        a aVar = a;
        if (aVar != null) {
            return aVar;
        }
        throw new IllegalStateException("KeyMgr is not initialised - invoke at least once with parameterised init/get");
    }

    private String a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                try {
                    int read = inputStream.read();
                    if (read == -1) {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                        try {
                            byteArrayOutputStream.close();
                            return byteArrayOutputStream2;
                        } catch (IOException unused) {
                            return byteArrayOutputStream2;
                        }
                    }
                    byteArrayOutputStream.write(read);
                } catch (IOException unused2) {
                    byteArrayOutputStream.close();
                    return null;
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException unused3) {
                    }
                    throw th;
                }
            } catch (IOException unused4) {
                return null;
            }
        }
    }

    public static void a(Context context) {
        if (a == null) {
            synchronized (b) {
                if (a == null) {
                    a = new a(context);
                }
            }
        }
    }

    private PublicKey b(Context context) {
        b("load publicKey from preference");
        String string = this.f4616j.getString("publicKey", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(string, 2)));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvalidKeySpecException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private void b(String str) {
        e.p.a.a.a.e("HttpKeyMgr", str);
    }

    private void c(String str) {
        e.p.a.a.a.f("HttpKeyMgr", str);
    }

    private void d() {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(PushConstants.URL_DOWNLOAD_PUBLIC_KEY).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setUseCaches(false);
            try {
                httpURLConnection.setRequestMethod("GET");
            } catch (ProtocolException e2) {
                e2.printStackTrace();
            }
            httpURLConnection.setRequestProperty("Charset", "UTF-8");
            InputStream inputStream = null;
            try {
                int responseCode = httpURLConnection.getResponseCode();
                b("code = " + responseCode);
                inputStream = httpURLConnection.getInputStream();
                if (inputStream != null) {
                    String a2 = a(inputStream);
                    b("body = " + a2);
                    if (!TextUtils.isEmpty(a2)) {
                        try {
                            JSONObject jSONObject = new JSONObject(a2);
                            if (jSONObject.getInt("code") == 200) {
                                String string = jSONObject.getString("value");
                                SharedPreferences.Editor edit = this.f4616j.edit();
                                edit.putString("publicKey", string);
                                edit.apply();
                            }
                        } catch (Exception e3) {
                            c("downloadPublicKey message error " + e3.getMessage());
                        }
                    }
                }
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                httpURLConnection.disconnect();
            }
        } catch (MalformedURLException unused2) {
        }
    }

    private void e() {
        b("loadKeys");
        String string = this.f4615i.getString("sKey64", "");
        b("saved sKey64: " + string);
        if (!TextUtils.isEmpty(string)) {
            this.f4613g = string.getBytes();
        }
        String string2 = this.f4615i.getString("aKey64", "");
        b("saved aKey64: " + string2);
        if (!TextUtils.isEmpty(string2)) {
            byte[] bytes = string2.getBytes();
            this.f4612f = bytes;
            this.f4610d = Base64.decode(bytes, 2);
        }
        String string3 = this.f4615i.getString("rKey64", "");
        b("saved rKey64: " + string3);
        if (TextUtils.isEmpty(string3)) {
            return;
        }
        byte[] bytes2 = string3.getBytes();
        this.f4611e = bytes2;
        this.f4609c = Base64.decode(bytes2, 2);
        b("saved rKey: " + new String(this.f4609c));
    }

    private void f() {
        g();
        h();
    }

    private void g() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            byte[] encoded = keyGenerator.generateKey().getEncoded();
            this.f4609c = encoded;
            this.f4611e = Base64.encode(encoded, 2);
            b("***** rKey64: " + new String(this.f4611e));
            SharedPreferences.Editor edit = this.f4615i.edit();
            edit.putString("rKey64", new String(this.f4611e));
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private void h() {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, this.f4614h);
            byte[] doFinal = cipher.doFinal(this.f4609c);
            this.f4610d = doFinal;
            this.f4612f = Base64.encode(doFinal, 2);
            b("***** aKey64: " + new String(this.f4612f));
            SharedPreferences.Editor edit = this.f4615i.edit();
            edit.putString("aKey64", new String(this.f4612f));
            edit.apply();
        } catch (InvalidKeyException e2) {
            e2.printStackTrace();
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
        } catch (BadPaddingException e4) {
            e4.printStackTrace();
        } catch (IllegalBlockSizeException e5) {
            e5.printStackTrace();
        } catch (NoSuchPaddingException e6) {
            e6.printStackTrace();
        }
    }

    public void a(String str) {
        this.f4613g = str.getBytes();
        SharedPreferences.Editor edit = this.f4615i.edit();
        edit.putString("sKey64", new String(this.f4613g));
        edit.apply();
    }

    public byte[] a(byte[] bArr) {
        String str;
        byte[] bArr2 = this.f4609c;
        if (bArr2 == null || bArr2.length == 0) {
            str = "rKey null!";
        } else if (bArr != null && bArr.length != 0) {
            b(">>>>>>>>>> encrypt input >>>>>>>>>>\n" + new String(Base64.encode(bArr, 2)));
            b("<<<<<<<<<< encrypt input <<<<<<<<<<");
            try {
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(1, new SecretKeySpec(this.f4609c, "AES"), new IvParameterSpec(this.f4609c));
                byte[] doFinal = cipher.doFinal(bArr);
                b(">>>>>>>>>> encrypt output >>>>>>>>>>\n" + new String(Base64.encode(doFinal, 2)));
                b("<<<<<<<<<< encrypt output <<<<<<<<<<");
                return doFinal;
            } catch (InvalidAlgorithmParameterException e2) {
                e2.printStackTrace();
                return null;
            } catch (InvalidKeyException e3) {
                e3.printStackTrace();
                return null;
            } catch (NoSuchAlgorithmException e4) {
                e4.printStackTrace();
                return null;
            } catch (BadPaddingException e5) {
                e5.printStackTrace();
                return null;
            } catch (IllegalBlockSizeException e6) {
                e6.printStackTrace();
                return null;
            } catch (NoSuchPaddingException e7) {
                e7.printStackTrace();
                return null;
            }
        } else {
            str = "input null!";
        }
        c(str);
        return null;
    }

    public byte[] b() {
        return this.f4612f;
    }

    public byte[] c() {
        return this.f4613g;
    }
}
