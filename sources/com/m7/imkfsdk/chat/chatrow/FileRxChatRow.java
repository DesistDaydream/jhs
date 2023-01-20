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
import com.baidu.mobads.sdk.internal.bp;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.FileViewHolder;
import com.m7.imkfsdk.utils.FIleResourceUtil;
import com.m7.imkfsdk.utils.MimeTypesTools;
import com.m7.imkfsdk.utils.MoorFileUtils;
import com.m7.imkfsdk.utils.permission.PermissionConstants;
import com.m7.imkfsdk.utils.permission.PermissionXUtil;
import com.m7.imkfsdk.utils.permission.callback.OnRequestCallback;
import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.lib.constants.MoorPathConstants;
import com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener;
import com.moor.imkf.lib.http.donwload.MoorDownLoadUtils;
import com.moor.imkf.lib.utils.MoorLogUtils;
import com.moor.imkf.model.entity.FromToMessage;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.io.File;

/* loaded from: classes2.dex */
public class FileRxChatRow extends BaseChatRow {

    /* renamed from: com.m7.imkfsdk.chat.chatrow.FileRxChatRow$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ FileViewHolder val$holder;
        public final /* synthetic */ FromToMessage val$message;

        /* renamed from: com.m7.imkfsdk.chat.chatrow.FileRxChatRow$2$1  reason: invalid class name */
        /* loaded from: classes2.dex */
        public class AnonymousClass1 implements OnRequestCallback {
            public AnonymousClass1() {
            }

            @Override // com.m7.imkfsdk.utils.permission.callback.OnRequestCallback
            public void requestSuccess() {
                AnonymousClass2.this.val$holder.getChat_content_pb_progress().setVisibility(0);
                AnonymousClass2.this.val$holder.getChat_content_tv_status().setVisibility(0);
                AnonymousClass2.this.val$holder.getChat_content_tv_status().setText(R.string.ykfsdk_downloading);
                AnonymousClass2.this.val$holder.getChat_content_iv_download().setVisibility(8);
                FromToMessage fromToMessage = AnonymousClass2.this.val$message;
                fromToMessage.message = fromToMessage.message.replaceAll("https://", "http://");
                FromToMessage fromToMessage2 = AnonymousClass2.this.val$message;
                MoorDownLoadUtils.loadFile(fromToMessage2.message, fromToMessage2.fileName, new IMoorOnDownloadListener() { // from class: com.m7.imkfsdk.chat.chatrow.FileRxChatRow.2.1.1
                    @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
                    public void onDownloadFailed() {
                        ((ChatActivity) AnonymousClass2.this.val$context).runOnUiThread(new Runnable() { // from class: com.m7.imkfsdk.chat.chatrow.FileRxChatRow.2.1.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2.this.val$message.fileProgress = 0;
                                AnonymousClass2.this.val$message.fileDownLoadStatus = "failed";
                                MessageDao.getInstance().updateMsgToDao(AnonymousClass2.this.val$message);
                                ((ChatActivity) AnonymousClass2.this.val$context).getChatAdapter().notifyDataSetChanged();
                            }
                        });
                    }

                    @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
                    public void onDownloadStart() {
                    }

                    @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
                    public void onDownloadSuccess(final String str) {
                        if (MoorFileUtils.saveFile(AnonymousClass2.this.val$context, new File(str), AnonymousClass2.this.val$message.fileName)) {
                            ((ChatActivity) AnonymousClass2.this.val$context).runOnUiThread(new Runnable() { // from class: com.m7.imkfsdk.chat.chatrow.FileRxChatRow.2.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    MoorLogUtils.aTag("loading", str);
                                    FromToMessage fromToMessage3 = AnonymousClass2.this.val$message;
                                    fromToMessage3.filePath = MoorPathConstants.getStoragePath(MoorPathConstants.PATH_NAME_MOOR_DOWNLOAD_FILE) + AnonymousClass2.this.val$message.fileName;
                                    FromToMessage fromToMessage4 = AnonymousClass2.this.val$message;
                                    fromToMessage4.fileDownLoadStatus = bp.o;
                                    fromToMessage4.fileProgress = 100;
                                    MessageDao.getInstance().updateMsgToDao(AnonymousClass2.this.val$message);
                                    ((ChatActivity) AnonymousClass2.this.val$context).getChatAdapter().notifyDataSetChanged();
                                }
                            });
                        }
                    }

                    @Override // com.moor.imkf.lib.http.donwload.IMoorOnDownloadListener
                    public void onDownloading(final int i2) {
                        ((ChatActivity) AnonymousClass2.this.val$context).runOnUiThread(new Runnable() { // from class: com.m7.imkfsdk.chat.chatrow.FileRxChatRow.2.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2.this.val$message.fileProgress = Integer.valueOf(i2);
                                AnonymousClass2.this.val$message.fileDownLoadStatus = "downloading";
                                MessageDao.getInstance().updateMsgToDao(AnonymousClass2.this.val$message);
                                ((ChatActivity) AnonymousClass2.this.val$context).getChatAdapter().notifyDataSetChanged();
                            }
                        });
                    }
                });
            }
        }

        public AnonymousClass2(Context context, FileViewHolder fileViewHolder, FromToMessage fromToMessage) {
            this.val$context = context;
            this.val$holder = fileViewHolder;
            this.val$message = fromToMessage;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PermissionXUtil.checkPermission((ChatActivity) this.val$context, new AnonymousClass1(), PermissionConstants.STORE);
        }
    }

    public FileRxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_file_rx, (ViewGroup) null);
            inflate.setTag(new FileViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(final Context context, BaseHolder baseHolder, final FromToMessage fromToMessage, int i2) {
        FileViewHolder fileViewHolder = (FileViewHolder) baseHolder;
        if (fromToMessage != null) {
            if (fromToMessage.withDrawStatus) {
                fileViewHolder.getWithdrawTextView().setVisibility(0);
                fileViewHolder.getContainer().setVisibility(8);
                return;
            }
            fileViewHolder.getWithdrawTextView().setVisibility(8);
            fileViewHolder.getContainer().setVisibility(0);
            fileViewHolder.getChat_content_tv_name().setText(fromToMessage.fileName);
            fileViewHolder.getChat_content_tv_size().setText(fromToMessage.fileSize);
            fileViewHolder.getChat_content_tv_status().setText(fromToMessage.fileDownLoadStatus);
            fileViewHolder.getChat_content_pb_progress().setProgress(fromToMessage.fileProgress.intValue());
            fileViewHolder.getYkf_chat_file_icon().setImageResource(FIleResourceUtil.getFile_Icon(context, fromToMessage.fileName));
            if (bp.o.equals(fromToMessage.fileDownLoadStatus)) {
                fileViewHolder.getChat_content_pb_progress().setVisibility(8);
                fileViewHolder.getChat_content_tv_status().setVisibility(0);
                TextView chat_content_tv_status = fileViewHolder.getChat_content_tv_status();
                chat_content_tv_status.setText(MqttTopic.TOPIC_LEVEL_SEPARATOR + context.getResources().getString(R.string.ykfsdk_haddownload));
                fileViewHolder.getChat_content_iv_download().setVisibility(8);
                fileViewHolder.getBaseView().setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.FileRxChatRow.1
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
                            context.startActivity(Intent.createChooser(intent, null));
                        } catch (Exception unused) {
                        }
                    }
                });
            } else if ("failed".equals(fromToMessage.fileDownLoadStatus)) {
                fileViewHolder.getChat_content_pb_progress().setVisibility(8);
                fileViewHolder.getChat_content_tv_status().setVisibility(8);
                fileViewHolder.getChat_content_iv_download().setVisibility(0);
            } else if ("downloading".equals(fromToMessage.fileDownLoadStatus)) {
                fileViewHolder.getChat_content_pb_progress().setVisibility(0);
                fileViewHolder.getChat_content_tv_status().setVisibility(0);
                fileViewHolder.getChat_content_tv_status().setText(R.string.ykfsdk_downloading);
                fileViewHolder.getChat_content_iv_download().setVisibility(8);
            }
            fileViewHolder.getChat_content_iv_download().setOnClickListener(new AnonymousClass2(context, fileViewHolder, fromToMessage));
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.FILE_ROW_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
