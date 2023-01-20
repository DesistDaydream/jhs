package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;
import com.caverock.androidsvg.SVG;
import com.vector.view.pager.ViewPager;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class n {
    private final JSONObject a;
    private int b;

    private n(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    private int p() {
        return this.a.optInt("url_balance", 2);
    }

    public void a(int i2) {
        this.b = b(i2);
    }

    public boolean b() {
        return p() > 0;
    }

    public boolean c() {
        return p() == 1;
    }

    public int d() {
        return this.a.optInt("buffer_count", 512);
    }

    public int e() {
        return this.a.optInt("buffer_size", 8192);
    }

    public boolean f() {
        return this.a.optInt("segment_mode", 1) == 0;
    }

    public long g() {
        long optInt = this.a.optInt("segment_min_kb", 512) * 1024;
        return optInt < SVG.D ? SVG.D : optInt;
    }

    public long h() {
        long optInt = this.a.optInt("segment_min_init_mb", 10) * SVG.H;
        if (optInt < 5242880) {
            return 5242880L;
        }
        return optInt;
    }

    public long i() {
        long optInt = this.a.optInt("segment_max_kb", 0) * SVG.H;
        if (optInt < g()) {
            return -1L;
        }
        return optInt;
    }

    public long j() {
        long optInt = this.a.optInt("connect_timeout", -1);
        if (optInt >= 2000) {
            return optInt;
        }
        return -1L;
    }

    public long k() {
        long optInt = this.a.optInt("read_timeout", -1);
        if (optInt >= ViewPager.DEFAULT_INTERVAL) {
            return optInt;
        }
        return -1L;
    }

    public int l() {
        return this.a.optInt("ip_strategy", 0);
    }

    public float m() {
        return (float) this.a.optDouble("main_ratio", 0.0d);
    }

    public int n() {
        return this.a.optInt("ratio_segment", 0);
    }

    public float o() {
        return Math.min(Math.max(0.0f, (float) this.a.optDouble("poor_speed_ratio", 0.0d)), 1.0f);
    }

    private int b(int i2) {
        int optInt = this.a.optInt("thread_count", 4);
        if (optInt > 16) {
            optInt = 16;
        }
        if (optInt > 0) {
            return p() == 1 ? Math.min(optInt, i2) : optInt;
        } else if (p() > 0) {
            return i2;
        } else {
            return 1;
        }
    }

    public int a() {
        return this.b;
    }

    @NonNull
    public static n a(@NonNull JSONObject jSONObject) {
        return new n(jSONObject);
    }
}
