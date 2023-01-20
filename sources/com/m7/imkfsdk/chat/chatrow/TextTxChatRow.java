package com.m7.imkfsdk.chat.chatrow;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.TextViewHolder;
import com.m7.imkfsdk.utils.AnimatedGifDrawable;
import com.m7.imkfsdk.utils.AnimatedImageSpan;
import com.m7.imkfsdk.utils.ToastUtils;
import com.m7.imkfsdk.utils.faceutils.FaceConversionUtil;
import com.m7.imkfsdk.view.PopupWindowList;
import com.moor.imkf.model.entity.FromToMessage;
import com.moor.imkf.utils.MoorUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class TextTxChatRow extends BaseChatRow {
    private Context context;
    private PopupWindowList mPopupWindowList;

    /* loaded from: classes2.dex */
    public class HttpClickSpan extends ClickableSpan {
        public String msg;

        public HttpClickSpan(String str) {
            this.msg = str;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            try {
                if (!this.msg.contains("http") && !this.msg.contains("https")) {
                    this.msg = "http://" + this.msg;
                } else {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(this.msg));
                    TextTxChatRow.this.context.startActivity(intent);
                }
            } catch (Exception unused) {
                Toast.makeText(TextTxChatRow.this.context, R.string.ykfsdk_url_failure, 0).show();
            }
        }
    }

    public TextTxChatRow(int i2) {
        super(i2);
    }

    public static void copyTxt(String str) {
        ((ClipboardManager) MoorUtils.getApp().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", str));
    }

    private SpannableStringBuilder handler(final TextView textView, String str) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        Matcher matcher = Pattern.compile("(\\#\\[face/png/f_static_)\\d{3}(.png\\]\\#)").matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            try {
                String substring = group.substring(20, group.length() - 6);
                InputStream open = this.context.getAssets().open("face/gif/f" + substring + ".gif");
                spannableStringBuilder.setSpan(new AnimatedImageSpan(new AnimatedGifDrawable(open, new AnimatedGifDrawable.UpdateListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextTxChatRow.3
                    @Override // com.m7.imkfsdk.utils.AnimatedGifDrawable.UpdateListener
                    public void update() {
                        textView.postInvalidate();
                    }
                })), matcher.start(), matcher.end(), 33);
                open.close();
            } catch (Exception e2) {
                String substring2 = group.substring(2, group.length() - 2);
                try {
                    Context context = this.context;
                    spannableStringBuilder.setSpan(new ImageSpan(context, BitmapFactory.decodeStream(context.getAssets().open(substring2))), matcher.start(), matcher.end(), 33);
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
                e2.printStackTrace();
            }
        }
        return spannableStringBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showPopWindows(View view, final String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.context.getString(R.string.ykfsdk_ykf_copy));
        if (this.mPopupWindowList == null) {
            this.mPopupWindowList = new PopupWindowList(view.getContext());
        }
        this.mPopupWindowList.setAnchorView(view);
        this.mPopupWindowList.setItemData(arrayList);
        this.mPopupWindowList.setModal(true);
        this.mPopupWindowList.show();
        this.mPopupWindowList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextTxChatRow.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
                TextTxChatRow.copyTxt(str);
                ToastUtils.showShort(TextTxChatRow.this.context, TextTxChatRow.this.context.getString(R.string.ykfsdk_ykf_copy_success));
                TextTxChatRow.this.mPopupWindowList.hide();
            }
        });
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_text_tx, (ViewGroup) null);
            inflate.setTag(new TextViewHolder(this.mRowType).initBaseHolder(inflate, false));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, final FromToMessage fromToMessage, int i2) {
        this.context = context;
        TextViewHolder textViewHolder = (TextViewHolder) baseHolder;
        if (fromToMessage != null) {
            SpannableStringBuilder handler = handler(textViewHolder.getDescTextView(), fromToMessage.message);
            FaceConversionUtil instace = FaceConversionUtil.getInstace();
            SpannableStringBuilder expressionString = instace.getExpressionString(context, ((Object) handler) + "", textViewHolder.getDescTextView());
            Matcher matcher = Pattern.compile("((http[s]{0,1}|ftp)://[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)|(www.[a-zA-Z0-9\\.\\-]+\\.([a-zA-Z]{2,4})(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)|(((http[s]{0,1}|ftp)://|)((?:(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(?:25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d))))(:\\d+)?(/[a-zA-Z0-9\\.\\-~!@#$%^&*+?:_/=<>]*)?)", 2).matcher(expressionString);
            while (matcher.find()) {
                String group = matcher.group();
                int start = matcher.start() + group.length();
                expressionString.setSpan(new HttpClickSpan(group), matcher.start(), start, 17);
                expressionString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.ykfsdk_startcolor)), matcher.start(), start, 17);
            }
            textViewHolder.getDescTextView().setText(expressionString);
            textViewHolder.getDescTextView().setMovementMethod(LinkMovementMethod.getInstance());
            View.OnClickListener onClickListener = ((ChatActivity) context).getChatAdapter().getOnClickListener();
            textViewHolder.getDescTextView().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.m7.imkfsdk.chat.chatrow.TextTxChatRow.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    TextTxChatRow.this.showPopWindows(view, fromToMessage.message);
                    return true;
                }
            });
            BaseChatRow.getMsgStateResId(i2, textViewHolder, fromToMessage, onClickListener);
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.TEXT_ROW_TRANSMIT.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
