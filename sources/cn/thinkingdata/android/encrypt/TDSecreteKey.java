package cn.thinkingdata.android.encrypt;

/* loaded from: classes.dex */
public class TDSecreteKey {
    public String asymmetricEncryption;
    public String publicKey;
    public String symmetricEncryption;
    public int version;

    public TDSecreteKey() {
    }

    public TDSecreteKey(String str, int i2, String str2, String str3) {
        this.publicKey = str;
        this.version = i2;
        this.symmetricEncryption = str2;
        this.asymmetricEncryption = str3;
    }
}
