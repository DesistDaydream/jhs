package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.be;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Envelope {
    private static final String dummyID1 = "1234567890987654321";
    private static final String dummyID2 = "02:00:00:00:00:00";
    private byte[] identity;
    private String mAddress;
    private byte[] mEntity;
    private int mLength;
    private int mTimestamp;
    private final byte[] SEED = {0, 0, 0, 0, 0, 0, 0, 0};
    private final int CODEX_ENCRYPT = 1;
    private final int CODEX_NORMAL = 0;
    private String mVersion = "1.0";
    private byte[] mSignature = null;
    private byte[] mGuid = null;
    private byte[] mChecksum = null;
    private int mSerialNo = 0;
    private boolean encrypt = false;

    private Envelope(byte[] bArr, String str, byte[] bArr2) throws Exception {
        this.mAddress = null;
        this.mTimestamp = 0;
        this.mLength = 0;
        this.mEntity = null;
        this.identity = null;
        if (bArr != null && bArr.length != 0) {
            this.mAddress = str;
            this.mLength = bArr.length;
            this.mEntity = com.umeng.commonsdk.statistics.common.b.a(bArr);
            this.mTimestamp = (int) (System.currentTimeMillis() / 1000);
            this.identity = bArr2;
            return;
        }
        throw new Exception("entity is null or empty");
    }

    private byte[] genCheckSum() {
        return DataHelper.hash((DataHelper.toHexString(this.mSignature) + this.mSerialNo + this.mTimestamp + this.mLength + DataHelper.toHexString(this.mGuid)).getBytes());
    }

    public static Envelope genEncryptEnvelope(Context context, String str, byte[] bArr) {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            String string = sharedPreferences.getString("signature", null);
            int i2 = sharedPreferences.getInt("serial", 1);
            Envelope envelope = new Envelope(bArr, str, "123456789098765432102:00:00:00:00:00".getBytes());
            envelope.setEncrypt(true);
            envelope.setSignature(string);
            envelope.setSerialNumber(i2);
            envelope.seal();
            sharedPreferences.edit().putInt("serial", i2 + 1).putString("signature", envelope.getSignature()).commit();
            envelope.export(context);
            return envelope;
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    public static Envelope genEnvelope(Context context, String str, byte[] bArr) {
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            String string = sharedPreferences.getString("signature", null);
            int i2 = sharedPreferences.getInt("serial", 1);
            Envelope envelope = new Envelope(bArr, str, "123456789098765432102:00:00:00:00:00".getBytes());
            envelope.setSignature(string);
            envelope.setSerialNumber(i2);
            envelope.seal();
            sharedPreferences.edit().putInt("serial", i2 + 1).putString("signature", envelope.getSignature()).commit();
            envelope.export(context);
            return envelope;
        } catch (Exception e2) {
            UMCrashManager.reportCrash(context, e2);
            return null;
        }
    }

    private byte[] genGuid(byte[] bArr, int i2) {
        byte[] hash = DataHelper.hash(this.identity);
        byte[] hash2 = DataHelper.hash(this.mEntity);
        int length = hash.length;
        int i3 = length * 2;
        byte[] bArr2 = new byte[i3];
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i4 * 2;
            bArr2[i5] = hash2[i4];
            bArr2[i5 + 1] = hash[i4];
        }
        for (int i6 = 0; i6 < 2; i6++) {
            bArr2[i6] = bArr[i6];
            bArr2[(i3 - i6) - 1] = bArr[(bArr.length - i6) - 1];
        }
        byte[] bArr3 = {(byte) (i2 & 255), (byte) ((i2 >> 8) & 255), (byte) ((i2 >> 16) & 255), (byte) (i2 >>> 24)};
        for (int i7 = 0; i7 < i3; i7++) {
            bArr2[i7] = (byte) (bArr2[i7] ^ bArr3[i7 % 4]);
        }
        return bArr2;
    }

    private byte[] genSignature() {
        return genGuid(this.SEED, (int) (System.currentTimeMillis() / 1000));
    }

    public static String getSignature(Context context) {
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getString("signature", null);
    }

    public void export(Context context) {
        String str = this.mAddress;
        String imprintProperty = UMEnvelopeBuild.imprintProperty(context, am.f7002g, null);
        String hexString = DataHelper.toHexString(this.mSignature);
        byte[] bArr = new byte[16];
        System.arraycopy(this.mSignature, 2, bArr, 0, 16);
        String hexString2 = DataHelper.toHexString(DataHelper.hash(bArr));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", str);
            if (imprintProperty != null) {
                jSONObject.put(am.f7002g, imprintProperty);
            }
            jSONObject.put("signature", hexString);
            jSONObject.put("checksum", hexString2);
            File file = new File(context.getFilesDir(), ".umeng");
            if (!file.exists()) {
                file.mkdir();
            }
            HelperUtils.writeFile(new File(file, "exchangeIdentity.json"), jSONObject.toString());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("appkey", str);
            jSONObject2.put("channel", UMUtils.getChannel(context));
            if (imprintProperty != null) {
                jSONObject2.put(am.f7002g, HelperUtils.getUmengMD5(imprintProperty));
            }
            HelperUtils.writeFile(new File(context.getFilesDir(), "exid.dat"), jSONObject2.toString());
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void seal() {
        if (this.mSignature == null) {
            this.mSignature = genSignature();
        }
        if (this.encrypt) {
            byte[] bArr = new byte[16];
            try {
                System.arraycopy(this.mSignature, 1, bArr, 0, 16);
                this.mEntity = DataHelper.encrypt(this.mEntity, bArr);
            } catch (Exception unused) {
            }
        }
        this.mGuid = genGuid(this.mSignature, this.mTimestamp);
        this.mChecksum = genCheckSum();
    }

    public void setEncrypt(boolean z) {
        this.encrypt = z;
    }

    public void setSerialNumber(int i2) {
        this.mSerialNo = i2;
    }

    public void setSignature(String str) {
        this.mSignature = DataHelper.reverseHexString(str);
    }

    public byte[] toBinary() {
        an anVar = new an();
        anVar.a(this.mVersion);
        anVar.b(this.mAddress);
        anVar.c(DataHelper.toHexString(this.mSignature));
        anVar.a(this.mSerialNo);
        anVar.b(this.mTimestamp);
        anVar.c(this.mLength);
        anVar.a(this.mEntity);
        anVar.d(this.encrypt ? 1 : 0);
        anVar.d(DataHelper.toHexString(this.mGuid));
        anVar.e(DataHelper.toHexString(this.mChecksum));
        try {
            return new be().a(anVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String toString() {
        return String.format("version : %s\n", this.mVersion) + String.format("address : %s\n", this.mAddress) + String.format("signature : %s\n", DataHelper.toHexString(this.mSignature)) + String.format("serial : %s\n", Integer.valueOf(this.mSerialNo)) + String.format("timestamp : %d\n", Integer.valueOf(this.mTimestamp)) + String.format("length : %d\n", Integer.valueOf(this.mLength)) + String.format("guid : %s\n", DataHelper.toHexString(this.mGuid)) + String.format("checksum : %s ", DataHelper.toHexString(this.mChecksum)) + String.format("codex : %d", Integer.valueOf(this.encrypt ? 1 : 0));
    }

    public String getSignature() {
        return DataHelper.toHexString(this.mSignature);
    }
}
