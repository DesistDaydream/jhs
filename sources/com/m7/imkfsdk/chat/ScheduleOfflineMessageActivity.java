package com.m7.imkfsdk.chat;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.dialog.LoadingFragmentDialog;
import com.m7.imkfsdk.utils.statusbar.StatusBarUtils;
import com.moor.imkf.IMChatManager;
import com.moor.imkf.listener.OnLeaveMsgConfigListener;
import com.moor.imkf.listener.OnSubmitOfflineMessageListener;
import com.moor.imkf.model.entity.LeaveMsgField;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public class ScheduleOfflineMessageActivity extends KFBaseActivity {
    private String LeavemsgNodeId;
    private String ToPeer;
    public TextView back;
    public Button btn_submit;
    public EditText id_et_content;
    private String inviteLeavemsgTip;
    public TextView inviteLeavemsgTipTv;
    public List<LeaveMsgField> lmfList;
    public LoadingFragmentDialog loadingFragmentDialog;
    private LinearLayout offline_ll_custom_field;

    @Override // com.m7.imkfsdk.chat.KFBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ykfsdk_kf_dialog_offline);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.ykfsdk_all_white));
        this.loadingFragmentDialog = new LoadingFragmentDialog();
        TextView textView = (TextView) findViewById(R.id.back);
        this.back = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.ScheduleOfflineMessageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ScheduleOfflineMessageActivity.this.finish();
            }
        });
        this.id_et_content = (EditText) findViewById(R.id.id_et_content);
        this.inviteLeavemsgTipTv = (TextView) findViewById(R.id.inviteLeavemsgTip);
        this.btn_submit = (Button) findViewById(R.id.id_btn_submit);
        this.offline_ll_custom_field = (LinearLayout) findViewById(R.id.offline_ll_custom_field);
        Intent intent = getIntent();
        this.ToPeer = intent.getStringExtra("ToPeer");
        this.LeavemsgNodeId = intent.getStringExtra("LeavemsgNodeId");
        String stringExtra = intent.getStringExtra("inviteLeavemsgTip");
        this.inviteLeavemsgTip = stringExtra;
        if (stringExtra != null && !"".equals(stringExtra)) {
            this.inviteLeavemsgTipTv.setText(this.inviteLeavemsgTip);
        } else {
            this.inviteLeavemsgTipTv.setText(getString(R.string.ykfsdk_ykf_please_leavemessage_replay));
        }
        IMChatManager.getInstance().getScheduleLeaveMsgConfig(this.id_et_content, this.LeavemsgNodeId, new OnLeaveMsgConfigListener() { // from class: com.m7.imkfsdk.chat.ScheduleOfflineMessageActivity.2
            @Override // com.moor.imkf.listener.OnLeaveMsgConfigListener
            public void onFailed() {
            }

            @Override // com.moor.imkf.listener.OnLeaveMsgConfigListener
            public void onSuccess(String str, List<LeaveMsgField> list) {
                if (!TextUtils.isEmpty(str)) {
                    ScheduleOfflineMessageActivity.this.inviteLeavemsgTipTv.setText(str);
                } else {
                    ScheduleOfflineMessageActivity.this.inviteLeavemsgTipTv.setText("请留言，我们将尽快联系您");
                }
                if (list == null || list.size() <= 0) {
                    return;
                }
                ScheduleOfflineMessageActivity.this.lmfList = list;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    LeaveMsgField leaveMsgField = list.get(i2);
                    if (leaveMsgField.enable.booleanValue()) {
                        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(ScheduleOfflineMessageActivity.this).inflate(R.layout.ykfsdk_kf_offline_edittext, (ViewGroup) ScheduleOfflineMessageActivity.this.offline_ll_custom_field, false);
                        EditText editText = (EditText) relativeLayout.findViewById(R.id.erp_field_data_et_value);
                        editText.setTag(R.id.ykfsdk_offline_id_tag, leaveMsgField._id);
                        editText.setTag(R.id.ykfsdk_offline_required_tag, leaveMsgField.required);
                        editText.setHint(leaveMsgField.name);
                        ScheduleOfflineMessageActivity.this.offline_ll_custom_field.addView(relativeLayout);
                    }
                }
            }
        });
        this.btn_submit.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.ScheduleOfflineMessageActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String trim = ScheduleOfflineMessageActivity.this.id_et_content.getText().toString().trim();
                int childCount = ScheduleOfflineMessageActivity.this.offline_ll_custom_field.getChildCount();
                HashMap<String, String> hashMap = new HashMap<>();
                for (int i2 = 0; i2 < childCount; i2++) {
                    EditText editText = (EditText) ((RelativeLayout) ScheduleOfflineMessageActivity.this.offline_ll_custom_field.getChildAt(i2)).getChildAt(0);
                    String str = (String) editText.getTag(R.id.ykfsdk_offline_id_tag);
                    String trim2 = editText.getText().toString().trim();
                    String charSequence = editText.getHint().toString();
                    if (((Boolean) editText.getTag(R.id.ykfsdk_offline_required_tag)).booleanValue() && "".equals(trim2)) {
                        ScheduleOfflineMessageActivity scheduleOfflineMessageActivity = ScheduleOfflineMessageActivity.this;
                        Toast.makeText(scheduleOfflineMessageActivity, charSequence + ScheduleOfflineMessageActivity.this.getString(R.string.ykfsdk_ykf_please_required), 0).show();
                        return;
                    }
                    hashMap.put(str, trim2);
                }
                if (!"".equals(trim)) {
                    ScheduleOfflineMessageActivity scheduleOfflineMessageActivity2 = ScheduleOfflineMessageActivity.this;
                    scheduleOfflineMessageActivity2.loadingFragmentDialog.show(scheduleOfflineMessageActivity2.getFragmentManager(), "");
                    IMChatManager.getInstance().submitOfflineMessage(ScheduleOfflineMessageActivity.this.getString(R.string.ykfsdk_ykf_leave_msg), ScheduleOfflineMessageActivity.this.getString(R.string.ykfsdk_ykf_leave_content), ScheduleOfflineMessageActivity.this.ToPeer, trim, hashMap, ScheduleOfflineMessageActivity.this.lmfList, new OnSubmitOfflineMessageListener() { // from class: com.m7.imkfsdk.chat.ScheduleOfflineMessageActivity.3.1
                        @Override // com.moor.imkf.listener.OnSubmitOfflineMessageListener
                        public void onFailed() {
                            ScheduleOfflineMessageActivity.this.loadingFragmentDialog.dismiss();
                            ScheduleOfflineMessageActivity scheduleOfflineMessageActivity3 = ScheduleOfflineMessageActivity.this;
                            Toast.makeText(scheduleOfflineMessageActivity3, scheduleOfflineMessageActivity3.getString(R.string.ykfsdk_ykf_up_leavemessage_fail), 0).show();
                            ScheduleOfflineMessageActivity.this.finish();
                        }

                        @Override // com.moor.imkf.listener.OnSubmitOfflineMessageListener
                        public void onSuccess() {
                            ScheduleOfflineMessageActivity.this.loadingFragmentDialog.dismiss();
                            ScheduleOfflineMessageActivity scheduleOfflineMessageActivity3 = ScheduleOfflineMessageActivity.this;
                            Toast.makeText(scheduleOfflineMessageActivity3, scheduleOfflineMessageActivity3.getString(R.string.ykfsdk_ykf_up_leavemessageok), 0).show();
                            ScheduleOfflineMessageActivity.this.finish();
                        }
                    });
                    return;
                }
                ScheduleOfflineMessageActivity scheduleOfflineMessageActivity3 = ScheduleOfflineMessageActivity.this;
                Toast.makeText(scheduleOfflineMessageActivity3, scheduleOfflineMessageActivity3.getString(R.string.ykfsdk_ykf_put_edit), 0).show();
            }
        });
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IMChatManager.getInstance().quitSDk();
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent.getStringExtra("ToPeer") != null) {
            this.ToPeer = intent.getStringExtra("ToPeer");
        }
    }
}
