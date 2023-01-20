package com.tencent.android.tpush;

import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.logging.TLogger;
import e.t.u.b0;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class XGLocalMessage {
    private long v;
    public long pushTime = 0;
    public int pushChannel = 99;
    public String nGroupId = "";
    public long targetType = 0;
    public long source = 0;
    public String templateId = "";
    public String traceId = "";
    private int a = 1;
    private String b = "";

    /* renamed from: c  reason: collision with root package name */
    private String f5921c = "";

    /* renamed from: d  reason: collision with root package name */
    private String f5922d = "";

    /* renamed from: e  reason: collision with root package name */
    private String f5923e = "00";

    /* renamed from: f  reason: collision with root package name */
    private String f5924f = "00";

    /* renamed from: g  reason: collision with root package name */
    private int f5925g = 1;

    /* renamed from: h  reason: collision with root package name */
    private int f5926h = 1;

    /* renamed from: i  reason: collision with root package name */
    private int f5927i = 1;

    /* renamed from: j  reason: collision with root package name */
    private int f5928j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f5929k = 1;

    /* renamed from: l  reason: collision with root package name */
    private String f5930l = "";

    /* renamed from: m  reason: collision with root package name */
    private String f5931m = "";
    private String n = "";
    private int o = 1;
    private String p = "";
    private String q = "";
    private String r = "";
    private String s = "";
    private String t = "";
    private String u = "{}";
    private int w = 0;
    private long x = System.currentTimeMillis() * (-1);
    private long y = 0;
    private int z = 2592000;
    private long A = System.currentTimeMillis() + (this.z * 1000);
    private int B = 0;
    private String C = "";
    private int D = 2;
    private String E = "";
    private String F = "";
    private String G = "";
    private int H = -1;

    public int getAction_type() {
        return this.o;
    }

    public String getActivity() {
        return this.p;
    }

    public int getBadgeType() {
        return this.H;
    }

    public long getBuilderId() {
        return this.v;
    }

    public long getBusiMsgId() {
        return this.y;
    }

    public String getChannelId() {
        return this.C;
    }

    public int getColor() {
        return this.B;
    }

    public String getContent() {
        return this.f5921c;
    }

    public String getCustom_content() {
        return this.u;
    }

    public String getDate() {
        if (!i.b(this.f5922d)) {
            try {
                String substring = this.f5922d.substring(0, 8);
                this.f5922d = substring;
                Long.parseLong(substring);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.t);
                simpleDateFormat.setLenient(false);
                simpleDateFormat.parse(this.f5922d);
            } catch (ParseException e2) {
                TLogger.e("XGLocalMessage", "XGLocalMessage.getDate()", e2);
                return new SimpleDateFormat(b0.a.t).format(new Date());
            } catch (Throwable th) {
                TLogger.e("XGLocalMessage", "XGLocalMessage.getDate()", th);
                return new SimpleDateFormat(b0.a.t).format(new Date());
            }
        }
        return this.f5922d;
    }

    public long getExpirationTimeMs() {
        return this.A;
    }

    public String getHour() {
        if (this.f5923e.length() < 1) {
            return "00";
        }
        if (this.f5923e.length() > 0 && this.f5923e.length() < 2) {
            return "0" + this.f5923e;
        }
        return this.f5923e;
    }

    public String getIcon_res() {
        return this.f5931m;
    }

    public int getIcon_type() {
        return this.f5928j;
    }

    public String getIntent() {
        return this.r;
    }

    public int getLights() {
        return this.f5927i;
    }

    public String getMin() {
        if (this.f5924f.length() < 1) {
            return "00";
        }
        if (this.f5924f.length() > 0 && this.f5924f.length() < 2) {
            return "0" + this.f5924f;
        }
        return this.f5924f;
    }

    public long getMsgId() {
        return this.x;
    }

    public int getNotificationId() {
        return this.w;
    }

    public int getNsModel() {
        return this.D;
    }

    public String getPackageDownloadUrl() {
        return this.s;
    }

    public String getPackageName() {
        return this.t;
    }

    public int getRing() {
        return this.f5925g;
    }

    public String getRing_raw() {
        return this.f5930l;
    }

    public String getSmall_icon() {
        return this.n;
    }

    public int getStyle_id() {
        return this.f5929k;
    }

    public String getThreadId() {
        return this.F;
    }

    public String getThreadSumText() {
        return this.G;
    }

    public String getTitle() {
        return this.b;
    }

    public String getTpns_media_resources() {
        return this.E;
    }

    public int getTtl() {
        return this.z;
    }

    public int getType() {
        return this.a;
    }

    public String getUrl() {
        return this.q;
    }

    public int getVibrate() {
        return this.f5926h;
    }

    public void setAction_type(int i2) {
        this.o = i2;
    }

    public void setActivity(String str) {
        this.p = str;
    }

    public void setBadgeType(int i2) {
        this.H = i2;
    }

    public void setBuilderId(long j2) {
        this.v = j2;
    }

    public void setBusiMsgId(long j2) {
        this.y = j2;
    }

    public void setChannelId(String str) {
        this.C = str;
    }

    public void setColor(int i2) {
        this.B = i2;
    }

    public void setContent(String str) {
        this.f5921c = str;
    }

    public void setCustomContent(HashMap<String, Object> hashMap) {
        this.u = new JSONObject(hashMap).toString();
    }

    public void setDate(String str) {
        this.f5922d = str;
    }

    public void setExpirationTimeMs(long j2) {
        if (j2 > System.currentTimeMillis()) {
            int currentTimeMillis = (int) ((j2 - System.currentTimeMillis()) / 1000);
            this.z = currentTimeMillis;
            if (currentTimeMillis < 0) {
                this.z = Integer.MAX_VALUE;
            }
            this.A = j2;
        }
    }

    public void setHour(String str) {
        this.f5923e = str;
    }

    public void setIcon_res(String str) {
        this.f5931m = str;
    }

    public void setIcon_type(int i2) {
        this.f5928j = i2;
    }

    public void setIntent(String str) {
        String str2;
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            str2 = "";
        }
        this.r = str2;
    }

    public void setLights(int i2) {
        this.f5927i = i2;
    }

    public void setMin(String str) {
        this.f5924f = str;
    }

    public void setMsgId(long j2) {
        this.x = j2;
    }

    public void setNotificationId(int i2) {
        this.w = i2;
    }

    public void setNsModel(int i2) {
        this.D = i2;
    }

    public void setPackageDownloadUrl(String str) {
        this.s = str;
    }

    public void setPackageName(String str) {
        this.t = str;
    }

    public void setRing(int i2) {
        this.f5925g = i2;
    }

    public void setRing_raw(String str) {
        this.f5930l = str;
    }

    public void setSmall_icon(String str) {
        this.n = str;
    }

    public void setStyle_id(int i2) {
        this.f5929k = i2;
    }

    public void setThreadId(String str) {
        this.F = str;
    }

    public void setThreadSumText(String str) {
        this.G = str;
    }

    public void setTitle(String str) {
        this.b = str;
    }

    public void setTpns_media_resources(String str) {
        this.E = str;
    }

    public void setType(int i2) {
        this.a = i2;
    }

    public void setUrl(String str) {
        this.q = str;
    }

    public void setVibrate(int i2) {
        this.f5926h = i2;
    }

    public String toString() {
        return "XGLocalMessage [type=" + this.a + ", title=" + this.b + ", content=" + this.f5921c + ", date=" + this.f5922d + ", hour=" + this.f5923e + ", min=" + this.f5924f + ", builderId=" + this.v + ", msgid=" + this.x + ", templateId=" + this.templateId + ", traceId=" + this.traceId + ", busiMsgId=" + this.y + "]";
    }
}
