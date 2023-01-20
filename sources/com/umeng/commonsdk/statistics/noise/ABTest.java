package com.umeng.commonsdk.statistics.noise;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.Envelope;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.d;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public class ABTest implements d {
    private static ABTest instance;
    private Context context;
    private boolean isInTest = false;
    private int mPolicy = -1;
    private int mInterval = -1;
    private int mGroup = -1;
    private float mProb13 = 0.0f;
    private float mProb07 = 0.0f;
    private String mPoli = null;

    private ABTest(Context context, String str, int i2) {
        this.context = null;
        this.context = context;
        onExperimentChanged(str, i2);
    }

    public static synchronized ABTest getService(Context context) {
        ABTest aBTest;
        synchronized (ABTest.class) {
            if (instance == null) {
                instance = new ABTest(context, UMEnvelopeBuild.imprintProperty(context, "client_test", null), Integer.valueOf(UMEnvelopeBuild.imprintProperty(context, "test_report_interval", "0")).intValue());
            }
            aBTest = instance;
        }
        return aBTest;
    }

    private void parseFIXED(String str) {
        if (str == null) {
            return;
        }
        String[] split = str.split("\\|");
        if (this.mProb13 > (split[2].equals("SIG13") ? Float.valueOf(split[3]).floatValue() : 0.0f)) {
            this.isInTest = false;
            return;
        }
        int intValue = split[0].equals("FIXED") ? Integer.valueOf(split[1]).intValue() : -1;
        int[] iArr = null;
        if (split[4].equals("RPT")) {
            this.mPoli = "RPT";
            String[] split2 = split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            iArr = new int[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                iArr[i2] = Integer.valueOf(split2[i2]).intValue();
            }
        } else if (split[4].equals("DOM")) {
            this.mPoli = "DOM";
            this.isInTest = true;
            try {
                String[] split3 = split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                iArr = new int[split3.length];
                for (int i3 = 0; i3 < split3.length; i3++) {
                    iArr[i3] = Integer.valueOf(split3[i3]).intValue();
                }
            } catch (Exception unused) {
            }
        }
        if (intValue != -1) {
            this.isInTest = true;
            this.mGroup = intValue;
            if (iArr != null) {
                this.mPolicy = iArr[intValue - 1];
                return;
            }
            return;
        }
        this.isInTest = false;
    }

    private void parseSig7(String str) {
        float[] fArr;
        if (str == null) {
            return;
        }
        String[] split = str.split("\\|");
        float f2 = 0.0f;
        if (this.mProb13 > (split[2].equals("SIG13") ? Float.valueOf(split[3]).floatValue() : 0.0f)) {
            this.isInTest = false;
            return;
        }
        int[] iArr = null;
        if (split[0].equals("SIG7")) {
            String[] split2 = split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            fArr = new float[split2.length];
            for (int i2 = 0; i2 < split2.length; i2++) {
                fArr[i2] = Float.valueOf(split2[i2]).floatValue();
            }
        } else {
            fArr = null;
        }
        if (split[4].equals("RPT")) {
            this.mPoli = "RPT";
            String[] split3 = split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            iArr = new int[split3.length];
            for (int i3 = 0; i3 < split3.length; i3++) {
                iArr[i3] = Integer.valueOf(split3[i3]).intValue();
            }
        } else if (split[4].equals("DOM")) {
            this.isInTest = true;
            this.mPoli = "DOM";
            try {
                String[] split4 = split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                iArr = new int[split4.length];
                for (int i4 = 0; i4 < split4.length; i4++) {
                    iArr[i4] = Integer.valueOf(split4[i4]).intValue();
                }
            } catch (Exception unused) {
            }
        }
        int i5 = 0;
        while (true) {
            if (i5 >= fArr.length) {
                i5 = -1;
                break;
            }
            f2 += fArr[i5];
            if (this.mProb07 < f2) {
                break;
            }
            i5++;
        }
        if (i5 != -1) {
            this.isInTest = true;
            this.mGroup = i5 + 1;
            if (iArr != null) {
                this.mPolicy = iArr[i5];
                return;
            }
            return;
        }
        this.isInTest = false;
    }

    private float prob(String str, int i2) {
        int i3 = i2 * 2;
        if (str == null) {
            return 0.0f;
        }
        return Integer.valueOf(str.substring(i3, i3 + 5), 16).intValue() / 1048576.0f;
    }

    public static boolean validate(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] split = str.split("\\|");
        if (split.length != 6) {
            return false;
        }
        if (split[0].startsWith("SIG7") && split[1].split(Constants.ACCEPT_TIME_SEPARATOR_SP).length == split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP).length) {
            return true;
        }
        if (split[0].startsWith("FIXED")) {
            int length = split[5].split(Constants.ACCEPT_TIME_SEPARATOR_SP).length;
            int parseInt = Integer.parseInt(split[1]);
            if (length >= parseInt && parseInt >= 1) {
                return true;
            }
        }
        return false;
    }

    public int getGroup() {
        return this.mGroup;
    }

    public String getGroupInfo() {
        return !this.isInTest ? com.umeng.analytics.pro.d.O : String.valueOf(this.mGroup);
    }

    public int getTestInterval() {
        return this.mInterval;
    }

    public String getTestName() {
        return this.mPoli;
    }

    public int getTestPolicy() {
        return this.mPolicy;
    }

    public boolean isInTest() {
        return this.isInTest;
    }

    public void onExperimentChanged(String str, int i2) {
        this.mInterval = i2;
        String signature = Envelope.getSignature(this.context);
        if (!TextUtils.isEmpty(signature) && !TextUtils.isEmpty(str)) {
            try {
                this.mProb13 = prob(signature, 12);
                this.mProb07 = prob(signature, 6);
                if (str.startsWith("SIG7")) {
                    parseSig7(str);
                } else if (str.startsWith("FIXED")) {
                    parseFIXED(str);
                }
                return;
            } catch (Exception e2) {
                this.isInTest = false;
                MLog.e("v:" + str, e2);
                return;
            }
        }
        this.isInTest = false;
    }

    @Override // com.umeng.commonsdk.statistics.internal.d
    public void onImprintChanged(ImprintHandler.a aVar) {
        onExperimentChanged(aVar.a("client_test", null), Integer.valueOf(aVar.a("test_report_interval", "0")).intValue());
    }

    public String toString() {
        return " p13:" + this.mProb13 + " p07:" + this.mProb07 + " policy:" + this.mPolicy + " interval:" + this.mInterval;
    }
}
