package com.m7.imkfsdk.chat.chatrow;

import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.View;
import com.m7.imkfsdk.KfStartHelper;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.chat.holder.BaseHolder;
import com.m7.imkfsdk.chat.holder.ViewHolderTag;
import com.m7.imkfsdk.utils.GlideUtil;
import com.moor.imkf.YKFConstants;
import com.moor.imkf.model.entity.FromToMessage;
import com.qiniu.android.http.dns.DnsSource;
import com.tencent.bugly.Bugly;

/* loaded from: classes2.dex */
public abstract class BaseChatRow implements IChatRow {
    public int mRowType;

    public BaseChatRow(int i2) {
        this.mRowType = i2;
    }

    public static void getMsgStateResId(int i2, BaseHolder baseHolder, FromToMessage fromToMessage, View.OnClickListener onClickListener) {
        if (fromToMessage == null || !fromToMessage.userType.equals("0")) {
            return;
        }
        String str = fromToMessage.sendState;
        if (str.equals(Bugly.SDK_IS_DEV)) {
            baseHolder.getUploadState().setImageResource(R.drawable.ykfsdk_kf_chat_failure_msgs);
            baseHolder.getUploadState().setVisibility(0);
            baseHolder.getTv_un_read().setVisibility(8);
            if (baseHolder.getUploadProgressBar() != null) {
                baseHolder.getUploadProgressBar().setVisibility(8);
            }
        } else if (str.equals("true")) {
            baseHolder.getUploadState().setImageResource(0);
            baseHolder.getUploadState().setVisibility(8);
            baseHolder.getTv_un_read().setVisibility(8);
            if (baseHolder.getUploadProgressBar() != null) {
                baseHolder.getUploadProgressBar().setVisibility(8);
            }
        } else if (str.equals("sending")) {
            baseHolder.getUploadState().setImageResource(0);
            baseHolder.getUploadState().setVisibility(8);
            baseHolder.getTv_un_read().setVisibility(8);
            if (baseHolder.getUploadProgressBar() != null) {
                baseHolder.getUploadProgressBar().setVisibility(0);
            }
        } else {
            baseHolder.getTv_un_read().setVisibility(8);
            if (baseHolder.getUploadProgressBar() != null) {
                baseHolder.getUploadProgressBar().setVisibility(8);
            }
        }
        baseHolder.getUploadState().setTag(ViewHolderTag.createTag(fromToMessage, 4, i2));
        baseHolder.getUploadState().setOnClickListener(onClickListener);
    }

    @Override // com.m7.imkfsdk.chat.chatrow.IChatRow
    public void buildChattingBaseData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2) {
        buildChattingData(context, baseHolder, fromToMessage, i2);
        if (baseHolder.getTv_un_read() != null && "0".equals(fromToMessage.userType)) {
            if (ChatActivity.isCustomerRead) {
                if (TextUtils.isEmpty(fromToMessage.dealUserMsg)) {
                    baseHolder.getTv_un_read().setVisibility(8);
                } else {
                    baseHolder.getTv_un_read().setVisibility(0);
                    if ("true".equals(fromToMessage.dealUserMsg)) {
                        baseHolder.getTv_un_read().setText(context.getString(R.string.ykfsdk_ykf_read));
                        baseHolder.getTv_un_read().setTextColor(context.getResources().getColor(R.color.ykfsdk_color_999999));
                    }
                    if (Bugly.SDK_IS_DEV.equals(fromToMessage.dealUserMsg)) {
                        baseHolder.getTv_un_read().setText(context.getString(R.string.ykfsdk_ykf_unread));
                        baseHolder.getTv_un_read().setTextColor(context.getResources().getColor(R.color.ykfsdk_unread));
                    }
                }
            } else {
                baseHolder.getTv_un_read().setVisibility(8);
            }
        }
        String str = fromToMessage.im_icon;
        if (baseHolder.getChattingAvatar() != null) {
            if ("1".equals(fromToMessage.userType)) {
                Boolean bool = fromToMessage.showHtml;
                if (bool != null && bool.booleanValue()) {
                    String string = context.getSharedPreferences(YKFConstants.MOOR_SP, 0).getString(YKFConstants.XIAOMO_ROBOT_AVATOR, "");
                    if (!"".equals(string)) {
                        int i3 = R.drawable.ykfsdk_kf_head_default_robot;
                        GlideUtil.loadHeader(context, string + "?imageView2/0/w/200/h/200/q/90", i3, i3, baseHolder.getChattingAvatar());
                        return;
                    }
                    baseHolder.getChattingAvatar().setImageResource(R.drawable.ykfsdk_kf_head_default_robot);
                    return;
                } else if (str != null && !"".equals(str) && !"null".equals(str)) {
                    String str2 = str + "?imageView2/0/w/100/h/100";
                    int i4 = R.drawable.ykfsdk_kf_head_default_local;
                    GlideUtil.loadHeader(context, str2, i4, i4, baseHolder.getChattingAvatar());
                    return;
                } else if (!TextUtils.isEmpty(fromToMessage.user) && DnsSource.System.equals(fromToMessage.user)) {
                    String string2 = context.getSharedPreferences(YKFConstants.MOOR_SP, 0).getString(YKFConstants.SYSTEMMSGLOGO, "");
                    if (!TextUtils.isEmpty(string2)) {
                        int i5 = R.drawable.ykfsdk_kf_head_default_local;
                        GlideUtil.loadHeader(context, string2 + "?imageView2/0/w/100/h/100", i5, i5, baseHolder.getChattingAvatar());
                        return;
                    }
                    baseHolder.getChattingAvatar().setImageResource(R.drawable.ykfsdk_kf_head_default_local);
                    return;
                } else {
                    baseHolder.getChattingAvatar().setImageResource(R.drawable.ykfsdk_kf_head_default_local);
                    return;
                }
            }
            String str3 = KfStartHelper.avatarUrl;
            if (str3 != null && !str3.isEmpty()) {
                String str4 = KfStartHelper.avatarUrl;
                int i6 = R.drawable.ykfsdk_kf_head_default_right;
                GlideUtil.loadHeader(context, str4, i6, i6, baseHolder.getChattingAvatar());
                return;
            }
            baseHolder.getChattingAvatar().setImageResource(R.drawable.ykfsdk_kf_head_default_right);
        }
    }

    public abstract void buildChattingData(Context context, BaseHolder baseHolder, FromToMessage fromToMessage, int i2);

    public abstract boolean onCreateRowContextMenu(ContextMenu contextMenu, View view, FromToMessage fromToMessage);
}
