package com.m7.imkfsdk.chat;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.adapter.CommonQuetionAdapter;
import com.m7.imkfsdk.chat.model.CommonQuestionBean;
import com.m7.imkfsdk.utils.statusbar.StatusBarUtils;
import com.moor.imkf.event.QuestionEvent;
import com.moor.imkf.http.HttpManager;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.listener.HttpResponseListener;
import java.util.ArrayList;
import k.c.a.c;
import k.c.a.l;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class CommonQuestionsActivity extends KFBaseActivity {
    private CommonQuetionAdapter adapter;
    private Context mContext;
    private ArrayList<CommonQuestionBean> questionBeans = new ArrayList<>();
    private RecyclerView rv_commonQuetions;
    private int themeType;

    private void getMainQuestions() {
        HttpManager.getTabCommonQuestions(new HttpResponseListener() { // from class: com.m7.imkfsdk.chat.CommonQuestionsActivity.2
            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onFailed() {
            }

            @Override // com.moor.imkf.listener.HttpResponseListener
            public void onSuccess(String str) {
                MoorLogUtils.aTag("常见问题", str);
                try {
                    JSONArray jSONArray = new JSONObject(str).getJSONArray("catalogList");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i2);
                        CommonQuestionBean commonQuestionBean = new CommonQuestionBean();
                        commonQuestionBean.setTabContent(jSONObject.getString("name"));
                        commonQuestionBean.setTabId(jSONObject.getString("_id"));
                        CommonQuestionsActivity.this.questionBeans.add(commonQuestionBean);
                    }
                    CommonQuestionsActivity.this.adapter.notifyDataSetChanged();
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    private void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_question);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.CommonQuestionsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CommonQuestionsActivity.this.finish();
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rl_refresh);
        this.rv_commonQuetions = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CommonQuetionAdapter commonQuetionAdapter = new CommonQuetionAdapter(this, this.questionBeans);
        this.adapter = commonQuetionAdapter;
        this.rv_commonQuetions.setAdapter(commonQuetionAdapter);
    }

    @Override // com.m7.imkfsdk.chat.KFBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mContext = this;
        setContentView(R.layout.ykfsdk_activity_commonproblems);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.ykfsdk_all_white));
        initView();
        if (!c.f().o(this)) {
            c.f().v(this);
        }
        getMainQuestions();
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
