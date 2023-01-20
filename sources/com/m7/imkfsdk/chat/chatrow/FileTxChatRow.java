package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.FileViewHolder;
import com.m7.imkfsdk.utils.FIleResourceUtil;
import com.m7.imkfsdk.utils.MimeTypesTools;
import com.moor.imkf.model.entity.FromToMessage;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.File;

/* loaded from: classes2.dex */
public class FileTxChatRow extends BaseChatRow {
    public FileTxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_file_tx, (ViewGroup) null);
            inflate.setTag(new FileViewHolder(this.mRowType).initBaseHolder(inflate, false));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, final FromToMessage fromToMessage, int i2) {
        FileViewHolder fileViewHolder = (FileViewHolder) baseHolder;
        if (fromToMessage != null) {
            fileViewHolder.getChat_content_tv_name().setText(fromToMessage.fileName);
            fileViewHolder.getChat_content_tv_size().setText(fromToMessage.fileSize);
            fileViewHolder.getChat_content_tv_status().setText(fromToMessage.fileUpLoadStatus);
            fileViewHolder.getChat_content_pb_progress().setProgress(fromToMessage.fileProgress.intValue());
            fileViewHolder.getYkf_chat_file_icon().setImageResource(FIleResourceUtil.getFile_Icon(context, fromToMessage.fileName));
            BaseChatRow.getMsgStateResId(i2, fileViewHolder, fromToMessage, ((ChatActivity) context).getChatAdapter().getOnClickListener());
            if ("true".equals(fromToMessage.sendState)) {
                TextView chat_content_tv_status = fileViewHolder.getChat_content_tv_status();
                chat_content_tv_status.setText(MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getResources().getString(R.string.ykfsdk_sended));
                fileViewHolder.getChat_content_pb_progress().setVisibility(8);
                fileViewHolder.getBaseView().setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.FileTxChatRow.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        try {
                            Intent intent = new Intent();
                            File file = new File(fromToMessage.filePath);
                            if (Build.VERSION.SDK_INT >= 24) {
                                intent.setFlags(1);
                                intent.setAction("android.intent.action.VIEW");
                                Context context2 = context;
                                intent.setDataAndType(FileProvider.getUriForFile(context2, context.getPackageName() + ".fileprovider", file), MimeTypesTools.getMimeType(context, fromToMessage.fileName));
                            } else {
                                intent.setDataAndType(Uri.fromFile(file), MimeTypesTools.getMimeType(context, fromToMessage.fileName));
                                intent.setFlags(268435456);
                            }
                            context.startActivity(intent);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                });
                return;
            }
            fileViewHolder.getChat_content_pb_progress().setVisibility(0);
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.FILE_ROW_TRANSMIT.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
