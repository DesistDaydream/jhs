package com.m7.imkfsdk.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.adapter.DetailQuestionAdapter;
import com.m7.imkfsdk.chat.model.DetailsQuestionBean;
import com.m7.imkfsdk.utils.statusbar.StatusBarUtils;
import com.m7.imkfsdk.view.EndlessRecyclerOnScrollListener;
import com.m7.imkfsdk.view.LoadMoreWrapper;
import com.moor.imkf.event.QuestionEvent;
import com.moor.imkf.http.HttpManager;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.listener.HttpResponseListener;
import java.util.ArrayList;
import java.util.Objects;
import k.c.a.c;
import k.c.a.l;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CommonDetailQuestionActivity extends KFBaseActivity {
    private DetailQuestionAdapter adapter;
    private LoadMoreWrapper loadMoreWrapper;
    private Context mContext;
    private RecyclerView rv_detailQuetions;
    private SwipeRefreshLayout swipeRefreshLayout;
    private String tabId;
    private int themeType;
    private TextView tv_noData;
    private ArrayList<DetailsQuestionBean> detailsQuestionBeans = new ArrayList<>();
    private int page = 1;
    private int limit = 30;

    /* JADX INFO: Access modifiers changed from: private */
    public void LoadMoreDetailsQuestions() {
        int i2 = this.page + 1;
        this.page = i2;
        HttpManager.getDetailQuestions(this.tabId, i2, this.limit, new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.CommonDetailQuestionActivity.5
            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                MoorLogUtils.aTag("具体问题", str);
                LoadMoreWrapper loadMoreWrapper = CommonDetailQuestionActivity.this.loadMoreWrapper;
                Objects.requireNonNull(CommonDetailQuestionActivity.this.loadMoreWrapper);
                loadMoreWrapper.setLoadState(2);
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("list");
                    if (jSONArray == null || jSONArray.length() <= 0) {
                        LoadMoreWrapper loadMoreWrapper2 = CommonDetailQuestionActivity.this.loadMoreWrapper;
                        Objects.requireNonNull(CommonDetailQuestionActivity.this.loadMoreWrapper);
                        loadMoreWrapper2.setLoadState(3);
                        CommonDetailQuestionActivity commonDetailQuestionActivity = CommonDetailQuestionActivity.this;
                        Toast.makeText(commonDetailQuestionActivity, commonDetailQuestionActivity.getString(R.string.ykfsdk_ykf_no_datamore), 0).show();
                    } else {
                        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i3);
                            DetailsQuestionBean detailsQuestionBean = new DetailsQuestionBean();
                            detailsQuestionBean.setQuestionId(jSONObject.getString("_id"));
                            detailsQuestionBean.setTitle(jSONObject.getString("title"));
                            CommonDetailQuestionActivity.this.detailsQuestionBeans.add(detailsQuestionBean);
                        }
                    }
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                CommonDetailQuestionActivity.this.loadMoreWrapper.notifyDataSetChanged();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getDetailsQuestions() {
        this.page = 1;
        HttpManager.getDetailQuestions(this.tabId, 1, this.limit, new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.CommonDetailQuestionActivity.4
            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                CommonDetailQuestionActivity.this.swipeRefreshLayout.setRefreshing(false);
                CommonDetailQuestionActivity.this.detailsQuestionBeans.clear();
                MoorLogUtils.aTag("getDetailsQuestions", str);
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("list");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        CommonDetailQuestionActivity.this.tv_noData.setVisibility(8);
                        CommonDetailQuestionActivity.this.swipeRefreshLayout.setVisibility(0);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            DetailsQuestionBean detailsQuestionBean = new DetailsQuestionBean();
                            detailsQuestionBean.setQuestionId(jSONObject.getString("_id"));
                            detailsQuestionBean.setTitle(jSONObject.getString("title"));
                            CommonDetailQuestionActivity.this.detailsQuestionBeans.add(detailsQuestionBean);
                        }
                        CommonDetailQuestionActivity.this.loadMoreWrapper.notifyDataSetChanged();
                        return;
                    }
                    CommonDetailQuestionActivity commonDetailQuestionActivity = CommonDetailQuestionActivity.this;
                    Toast.makeText(commonDetailQuestionActivity, commonDetailQuestionActivity.getString(R.string.ykfsdk_ykf_no_data), 0).show();
                    CommonDetailQuestionActivity.this.tv_noData.setVisibility(0);
                    CommonDetailQuestionActivity.this.swipeRefreshLayout.setVisibility(8);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private void initView() {
        this.swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl_refresh);
        this.rv_detailQuetions = (RecyclerView) findViewById(R.id.rl_detailRefresh);
        this.tv_noData = (TextView) findViewById(R.id.tv_noData);
        this.rv_detailQuetions.setLayoutManager(new LinearLayoutManager(this));
        DetailQuestionAdapter detailQuestionAdapter = new DetailQuestionAdapter(this.detailsQuestionBeans);
        this.adapter = detailQuestionAdapter;
        LoadMoreWrapper loadMoreWrapper = new LoadMoreWrapper(detailQuestionAdapter);
        this.loadMoreWrapper = loadMoreWrapper;
        this.rv_detailQuetions.setAdapter(loadMoreWrapper);
        this.swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.m7.imkfsdk.chat.CommonDetailQuestionActivity.2
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                CommonDetailQuestionActivity.this.getDetailsQuestions();
            }
        });
        this.rv_detailQuetions.addOnScrollListener(new EndlessRecyclerOnScrollListener() { // from class: com.m7.imkfsdk.chat.CommonDetailQuestionActivity.3
            @Override // com.m7.imkfsdk.view.EndlessRecyclerOnScrollListener
            public void onLoadMore() {
                LoadMoreWrapper loadMoreWrapper2 = CommonDetailQuestionActivity.this.loadMoreWrapper;
                Objects.requireNonNull(CommonDetailQuestionActivity.this.loadMoreWrapper);
                loadMoreWrapper2.setLoadState(1);
                CommonDetailQuestionActivity.this.LoadMoreDetailsQuestions();
            }
        });
    }

    @Override // com.m7.imkfsdk.chat.KFBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        setContentView(R.layout.ykfsdk_activity_detailproblems);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.ykfsdk_all_white));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_question);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.CommonDetailQuestionActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommonDetailQuestionActivity.this.finish();
            }
        });
        this.tabId = getIntent().getStringExtra("tabId");
        initView();
        if (!c.f().o(this)) {
            c.f().v(this);
        }
        getDetailsQuestions();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (c.f().o(this)) {
            c.f().A(this);
        }
    }

    @l(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(QuestionEvent questionEvent) {
        finish();
    }
}
