package com.m7.imkfsdk.chat;

import android.content.Intent;
import android.os.Bundle;
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
public class OfflineMessageActicity extends KFBaseActivity {
    public TextView back;
    public Button btn_submit;
    public EditText id_et_content;
    private String inviteLeavemsgTip;
    public TextView inviteLeavemsgTipTv;
    private String leavemsgTip;
    public List<LeaveMsgField> lmfList;
    public LoadingFragmentDialog loadingFragmentDialog;
    private LinearLayout offline_ll_custom_field;
    private String peerId;

    @Override // com.m7.imkfsdk.chat.KFBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ykfsdk_kf_dialog_offline);
        StatusBarUtils.setColor(this, getResources().getColor(R.color.ykfsdk_all_white));
        this.loadingFragmentDialog = new LoadingFragmentDialog();
        this.back = (TextView) findViewById(R.id.back);
        this.inviteLeavemsgTipTv = (TextView) findViewById(R.id.inviteLeavemsgTip);
        this.back.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.OfflineMessageActicity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OfflineMessageActicity.this.finish();
            }
        });
        this.id_et_content = (EditText) findViewById(R.id.id_et_content);
        this.btn_submit = (Button) findViewById(R.id.id_btn_submit);
        this.offline_ll_custom_field = (LinearLayout) findViewById(R.id.offline_ll_custom_field);
        Intent intent = getIntent();
        this.peerId = intent.getStringExtra("PeerId");
        this.leavemsgTip = intent.getStringExtra("leavemsgTip");
        this.inviteLeavemsgTip = intent.getStringExtra("inviteLeavemsgTip");
        String str = this.leavemsgTip;
        if (str != null && !"".equals(str)) {
            this.id_et_content.setHint(this.leavemsgTip);
        } else {
            this.id_et_content.setHint(getString(R.string.ykfsdk_ykf_please_leavemessage));
        }
        String str2 = this.inviteLeavemsgTip;
        if (str2 != null && !"".equals(str2)) {
            this.inviteLeavemsgTipTv.setText(this.inviteLeavemsgTip);
        } else {
            this.inviteLeavemsgTipTv.setText(getString(R.string.ykfsdk_ykf_please_leavemessage_replay));
        }
        IMChatManager.getInstance().getLeaveMsgConfig(new OnLeaveMsgConfigListener() { // from class: com.m7.imkfsdk.chat.OfflineMessageActicity.2
            @Override // com.moor.imkf.listener.OnLeaveMsgConfigListener
            public void onFailed() {
            }

            @Override // com.moor.imkf.listener.OnLeaveMsgConfigListener
            public void onSuccess(String str3, List<LeaveMsgField> list) {
                if (list == null || list.size() <= 0) {
                    return;
                }
                OfflineMessageActicity.this.lmfList = list;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    LeaveMsgField leaveMsgField = list.get(i2);
                    if (leaveMsgField.enable.booleanValue()) {
                        RelativeLayout relativeLayout = (RelativeLayout) LayoutInflater.from(OfflineMessageActicity.this).inflate(R.layout.ykfsdk_kf_offline_edittext, (ViewGroup) OfflineMessageActicity.this.offline_ll_custom_field, false);
                        EditText editText = (EditText) relativeLayout.findViewById(R.id.erp_field_data_et_value);
                        editText.setTag(R.id.ykfsdk_offline_id_tag, leaveMsgField._id);
                        editText.setTag(R.id.ykfsdk_offline_required_tag, leaveMsgField.required);
                        editText.setHint(leaveMsgField.name);
                        OfflineMessageActicity.this.offline_ll_custom_field.addView(relativeLayout);
                    }
                }
            }
        });
        this.btn_submit.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.OfflineMessageActicity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                String trim = OfflineMessageActicity.this.id_et_content.getText().toString().trim();
                int childCount = OfflineMessageActicity.this.offline_ll_custom_field.getChildCount();
                HashMap<String, String> hashMap = new HashMap<>();
                for (int i2 = 0; i2 < childCount; i2++) {
                    EditText editText = (EditText) ((RelativeLayout) OfflineMessageActicity.this.offline_ll_custom_field.getChildAt(i2)).getChildAt(0);
                    String str3 = (String) editText.getTag(R.id.ykfsdk_offline_id_tag);
                    String trim2 = editText.getText().toString().trim();
                    String charSequence = editText.getHint().toString();
                    if (((Boolean) editText.getTag(R.id.ykfsdk_offline_required_tag)).booleanValue() && "".equals(trim2)) {
                        OfflineMessageActicity offlineMessageActicity = OfflineMessageActicity.this;
                        Toast.makeText(offlineMessageActicity, charSequence + OfflineMessageActicity.this.getString(R.string.ykfsdk_ykf_please_required), 0).show();
                        return;
                    }
                    hashMap.put(str3, trim2);
                }
                if (!"".equals(trim)) {
                    OfflineMessageActicity offlineMessageActicity2 = OfflineMessageActicity.this;
                    offlineMessageActicity2.loadingFragmentDialog.show(offlineMessageActicity2.getFragmentManager(), "");
                    IMChatManager.getInstance().submitOfflineMessage(OfflineMessageActicity.this.getString(R.string.ykfsdk_ykf_leave_msg), OfflineMessageActicity.this.getString(R.string.ykfsdk_ykf_leave_content), OfflineMessageActicity.this.peerId, trim, hashMap, OfflineMessageActicity.this.lmfList, new OnSubmitOfflineMessageListener() { // from class: com.m7.imkfsdk.chat.OfflineMessageActicity.3.1
                        @Override // com.moor.imkf.listener.OnSubmitOfflineMessageListener
                        public void onFailed() {
                            OfflineMessageActicity.this.loadingFragmentDialog.dismiss();
                            OfflineMessageActicity offlineMessageActicity3 = OfflineMessageActicity.this;
                            Toast.makeText(offlineMessageActicity3, offlineMessageActicity3.getString(R.string.ykfsdk_ykf_up_leavemessage_fail), 0).show();
                            OfflineMessageActicity.this.finish();
                        }

                        @Override // com.moor.imkf.listener.OnSubmitOfflineMessageListener
                        public void onSuccess() {
                            OfflineMessageActicity.this.loadingFragmentDialog.dismiss();
                            OfflineMessageActicity offlineMessageActicity3 = OfflineMessageActicity.this;
                            Toast.makeText(offlineMessageActicity3, offlineMessageActicity3.getString(R.string.ykfsdk_ykf_up_leavemessageok), 0).show();
                            OfflineMessageActicity.this.finish();
                        }
                    });
                    return;
                }
                OfflineMessageActicity offlineMessageActicity3 = OfflineMessageActicity.this;
                Toast.makeText(offlineMessageActicity3, offlineMessageActicity3.getString(R.string.ykfsdk_ykf_put_edit), 0).show();
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
        if (intent.getStringExtra("PeerId") != null) {
            this.peerId = intent.getStringExtra("PeerId");
        }
    }
}
