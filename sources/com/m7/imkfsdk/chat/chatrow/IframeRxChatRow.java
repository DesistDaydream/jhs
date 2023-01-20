package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.os.Build;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.caverock.androidsvg.SVG;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.IFrameViewHolder;
import com.m7.imkfsdk.view.ChatListView;
import com.moor.imkf.model.entity.FromToMessage;

/* loaded from: classes2.dex */
public class IframeRxChatRow extends BaseChatRow {
    public IframeRxChatRow(int i2) {
        super(i2);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public View buildChatView(LayoutInflater layoutInflater, View view) {
        if (view == null) {
            View inflate = layoutInflater.inflate(R.layout.ykfsdk_kf_chat_row_iframe_rx, (ViewGroup) null);
            inflate.setTag(new IFrameViewHolder(this.mRowType).initBaseHolder(inflate, true));
            return inflate;
        }
        return view;
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        IFrameViewHolder iFrameViewHolder = (IFrameViewHolder) baseHolder;
        final ChatListView chatListView = ((ChatActivity) context).getChatListView();
        if (fromToMessage != null) {
            if (fromToMessage.withDrawStatus) {
                iFrameViewHolder.getWithdrawTextView().setVisibility(0);
                iFrameViewHolder.getContainer().setVisibility(8);
                return;
            }
            iFrameViewHolder.getWithdrawTextView().setVisibility(8);
            iFrameViewHolder.getContainer().setVisibility(0);
            if (Build.VERSION.SDK_INT > 11) {
                iFrameViewHolder.getWebView().setLayerType(1, null);
            }
            iFrameViewHolder.getWebView().getSettings().setDomStorageEnabled(true);
            iFrameViewHolder.getWebView().getSettings().setAppCacheMaxSize(SVG.K);
            iFrameViewHolder.getWebView().getSettings().setAppCachePath(context.getApplicationContext().getCacheDir().getAbsolutePath());
            iFrameViewHolder.getWebView().getSettings().setAppCacheEnabled(true);
            iFrameViewHolder.getWebView().getSettings().setSavePassword(false);
            iFrameViewHolder.getWebView().setWebViewClient(new WebViewClient() { // from class: com.m7.imkfsdk.chat.chatrow.IframeRxChatRow.1
                @Override // android.webkit.WebViewClient
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    webView.loadUrl(str);
                    return true;
                }
            });
            iFrameViewHolder.getWebView().setOnTouchListener(new View.OnTouchListener() { // from class: com.m7.imkfsdk.chat.chatrow.IframeRxChatRow.2
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 1) {
                        ChatListView chatListView2 = chatListView;
                        if (chatListView2 != null) {
                            chatListView2.requestDisallowInterceptTouchEvent(false);
                        }
                    } else {
                        ChatListView chatListView3 = chatListView;
                        if (chatListView3 != null) {
                            chatListView3.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    return false;
                }
            });
            iFrameViewHolder.getWebView().getLayoutParams().width = fromToMessage.iframeWidth.intValue();
            iFrameViewHolder.getWebView().getLayoutParams().height = fromToMessage.iframeHeight.intValue();
            iFrameViewHolder.getWebView().loadUrl(fromToMessage.message);
        }
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public int getChatViewType() {
        return ChatRowType.IFRAME_ROW_RECEIVED.ordinal();
    }

    @Override // com.m7.imkfsdk.chat.chatrow.BaseChatRow
    public boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage) {
        return false;
    }
}
