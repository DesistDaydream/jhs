package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.sdk.openadsdk.R;
import java.util.List;

/* loaded from: classes3.dex */
public class AppDetailInfoActivity extends Activity {
    private ImageView a;
    private TextView b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f5268c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f5269d;

    /* renamed from: e  reason: collision with root package name */
    private long f5270e;

    /* renamed from: f  reason: collision with root package name */
    private long f5271f;

    /* renamed from: g  reason: collision with root package name */
    private List<Pair<String, String>> f5272g;

    /* loaded from: classes3.dex */
    public class a extends RecyclerView.Adapter<Object> {
        private a() {
        }
    }

    private void b() {
        this.a = (ImageView) findViewById(R.id.iv_detail_back);
        this.b = (TextView) findViewById(R.id.tv_empty);
        this.f5269d = (RecyclerView) findViewById(R.id.permission_list);
        this.f5268c = (LinearLayout) findViewById(R.id.ll_download);
        if (this.f5272g.isEmpty()) {
            this.f5269d.setVisibility(8);
            this.b.setVisibility(0);
        } else {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            linearLayoutManager.setOrientation(1);
            this.f5269d.setLayoutManager(linearLayoutManager);
            this.f5269d.setAdapter(new a());
        }
        this.a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_close", AppDetailInfoActivity.this.f5271f);
                AppDetailInfoActivity.this.finish();
            }
        });
        this.f5268c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.compliance.AppDetailInfoActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                e.a("lp_app_detail_click_download", AppDetailInfoActivity.this.f5271f);
                b.a().b(AppDetailInfoActivity.this.f5271f);
                com.ss.android.socialbase.appdownloader.c.a((Activity) AppDetailInfoActivity.this);
                com.ss.android.socialbase.appdownloader.c.a(b.a().b());
            }
        });
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        e.a("lp_app_detail_click_close", this.f5271f);
        super.onBackPressed();
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ttdownloader_activity_app_detail_info);
        if (a()) {
            b();
        } else {
            com.ss.android.socialbase.appdownloader.c.a((Activity) this);
        }
    }

    public static void a(Activity activity, long j2) {
        Intent intent = new Intent(activity, AppDetailInfoActivity.class);
        intent.putExtra("app_info_id", j2);
        activity.startActivity(intent);
    }

    private boolean a() {
        this.f5270e = getIntent().getLongExtra("app_info_id", 0L);
        com.ss.android.downloadlib.addownload.b.b a2 = c.a().a(this.f5270e);
        if (a2 == null) {
            return false;
        }
        this.f5271f = a2.b;
        this.f5272g = a2.f5242h;
        return true;
    }
}
