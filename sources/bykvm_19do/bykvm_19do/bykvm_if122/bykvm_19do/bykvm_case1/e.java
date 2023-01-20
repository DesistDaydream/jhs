package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f761c;

    /* renamed from: d  reason: collision with root package name */
    private String f762d;

    /* renamed from: e  reason: collision with root package name */
    private double f763e;

    /* renamed from: f  reason: collision with root package name */
    private double f764f;

    public e(String str, String str2, String str3, int i2, String str4, double d2, double d3) {
        this.a = str2;
        this.b = str3;
        this.f761c = i2;
        this.f762d = str4;
        this.f763e = d2;
        this.f764f = d3;
    }

    public static e a(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str) || jSONObject == null) {
            return null;
        }
        return new e(str, jSONObject.optString("label_name"), jSONObject.optString("timestamp"), jSONObject.optInt("label_id"), jSONObject.optString("label_version"), jSONObject.optDouble("upper_bound"), jSONObject.optDouble("lower_bound"));
    }

    public int a() {
        int i2 = this.f761c;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return i2;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.f762d;
    }

    public double d() {
        double d2 = this.f764f;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return d2;
    }

    public String e() {
        return this.b;
    }

    public double f() {
        double d2 = this.f763e;
        while (true) {
            char c2 = ']';
            char c3 = ']';
            while (true) {
                switch (c3) {
                    case '\\':
                        switch (c2) {
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case ']':
                        while (true) {
                            switch (c2) {
                                case '[':
                                case ']':
                                    break;
                                case '\\':
                                    break;
                                default:
                                    c2 = '[';
                            }
                        }
                        c3 = '^';
                        c2 = 'K';
                        break;
                    case '^':
                        if (c2 <= 4) {
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
        return d2;
    }
}
