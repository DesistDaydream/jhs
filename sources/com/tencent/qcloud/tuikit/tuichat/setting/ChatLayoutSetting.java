package com.tencent.qcloud.tuikit.tuichat.setting;

import android.content.Context;
import com.google.gson.Gson;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.CustomHelloMessage;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.ui.view.ChatView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.ui.view.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import java.util.Objects;

/* loaded from: classes3.dex */
public class ChatLayoutSetting {
    private static final String TAG = "ChatLayoutSetting";
    private String groupId;
    private Context mContext;

    public ChatLayoutSetting(Context context) {
        this.mContext = context;
    }

    public void customizeChatLayout(ChatView chatView) {
        MessageRecyclerView messageLayout = chatView.getMessageLayout();
        messageLayout.setAvatarRadius(23);
        messageLayout.setAvatarSize(new int[]{46, 46});
        InputView inputLayout = chatView.getInputLayout();
        inputLayout.disableAudioInput(true);
        inputLayout.disableSendFileAction(true);
        InputMoreActionUnit inputMoreActionUnit = new InputMoreActionUnit() { // from class: com.tencent.qcloud.tuikit.tuichat.setting.ChatLayoutSetting.1
        };
        inputMoreActionUnit.setIconResId(R.drawable.custom);
        inputMoreActionUnit.setTitleId(R.string.test_custom_action);
        inputMoreActionUnit.setActionId(3);
        inputMoreActionUnit.setPriority(10);
        inputMoreActionUnit.setOnClickListener(new InputMoreActionUnit.OnActionClickListener(inputMoreActionUnit, chatView) { // from class: com.tencent.qcloud.tuikit.tuichat.setting.ChatLayoutSetting.2
            public final /* synthetic */ ChatView val$layout;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
                this.val$layout = chatView;
                Objects.requireNonNull(inputMoreActionUnit);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit.OnActionClickListener
            public void onClick() {
                Gson gson = new Gson();
                CustomHelloMessage customHelloMessage = new CustomHelloMessage();
                customHelloMessage.version = TUIChatConstants.version;
                String z = gson.z(customHelloMessage);
                String str = customHelloMessage.text;
                this.val$layout.sendMessage(ChatMessageBuilder.buildCustomMessage(z, str, str.getBytes()), false);
            }
        });
        inputLayout.addAction(inputMoreActionUnit);
    }

    public void customizeMessageLayout(MessageRecyclerView messageRecyclerView) {
        if (messageRecyclerView == null) {
        }
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
