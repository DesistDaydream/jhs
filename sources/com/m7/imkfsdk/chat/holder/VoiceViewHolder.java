package com.m7.imkfsdk.chat.holder;

import android.content.res.Resources;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.ChatActivity;
import com.m7.imkfsdk.view.PopupWindowList;
import com.m7.imkfsdk.view.VoiceAnimImageView;
import com.moor.imkf.db.dao.MessageDao;
import com.moor.imkf.event.VoiceToTextEvent;
import com.moor.imkf.lib.utils.MoorDensityUtil;
import com.moor.imkf.model.entity.FromToMessage;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.bugly.Bugly;
import java.util.ArrayList;
import k.c.a.c;

/* loaded from: classes2.dex */
public class VoiceViewHolder extends BaseHolder {
    private static PopupWindowList mPopupWindowList;
    public TextView contentTv;
    public LinearLayout ll_text_ok;
    public LinearLayout ll_voiceTotext;
    public ProgressBar pb_voice_text;
    public RelativeLayout rl_pb;
    public TextView tv_vototx;
    public VoiceAnimImageView voiceAnim;
    public TextView voicePlayAnim;
    public TextView voiceSecondView;
    public ProgressBar voiceSending;
    public ImageView voiceUnread;

    public VoiceViewHolder(int i2) {
        super(i2);
    }

    public static int getTimeWidth(int i2) {
        int i3;
        if (i2 <= 2) {
            return 80;
        }
        if (i2 < 10) {
            i3 = i2 - 2;
        } else if (i2 >= 60) {
            return AdEventType.VIDEO_PAUSE;
        } else {
            i3 = (i2 / 10) + 7;
        }
        return (i3 * 9) + 80;
    }

    public static void hideVoice_to_Text_Pb(boolean z, RelativeLayout relativeLayout, LinearLayout linearLayout) {
        if (z) {
            relativeLayout.setVisibility(8);
            linearLayout.setVisibility(0);
            return;
        }
        relativeLayout.setVisibility(0);
        linearLayout.setVisibility(8);
    }

    public static void initVoiceRow(final VoiceViewHolder voiceViewHolder, final FromToMessage fromToMessage, int i2, final ChatActivity chatActivity, final boolean z) {
        if (voiceViewHolder == null) {
            return;
        }
        String str = fromToMessage.voiceSecond;
        if (str != null && !str.equals("")) {
            TextView textView = voiceViewHolder.voiceSecondView;
            textView.setText(fromToMessage.voiceSecond + "''");
        } else {
            try {
                MediaPlayer mediaPlayer = new MediaPlayer();
                mediaPlayer.setDataSource(fromToMessage.filePath);
                mediaPlayer.prepare();
                int duration = mediaPlayer.getDuration() / 1000;
                mediaPlayer.release();
                TextView textView2 = voiceViewHolder.voiceSecondView;
                textView2.setText(duration + "''");
                fromToMessage.voiceSecond = duration + "";
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (!z) {
            voiceViewHolder.voiceAnim.setVisibility(8);
            voiceViewHolder.voicePlayAnim.setTag(ViewHolderTag.createTag(fromToMessage, 2, i2, voiceViewHolder.type, z, voiceViewHolder));
            voiceViewHolder.voicePlayAnim.setOnClickListener(chatActivity.getChatAdapter().getOnClickListener());
            if (chatActivity.getChatAdapter().mVoicePosition == i2) {
                uploadVoiceStatus(voiceViewHolder, 8, 0, z);
                voiceViewHolder.voiceAnim.setVisibility(0);
                voiceViewHolder.voiceAnim.startVoiceAnimation();
                voiceViewHolder.voiceAnim.setBackgroundResource(R.drawable.ykfsdk_ykf_send_msg_bg);
                voiceViewHolder.voiceAnim.setWidth(MoorDensityUtil.dp2px(getTimeWidth(1)));
                voiceViewHolder.contentTv.setTextColor(chatActivity.getResources().getColor(R.color.ykfsdk_voice_tv));
                voiceViewHolder.contentTv.setShadowLayer(2.0f, 1.2f, 1.2f, Color.parseColor("#ffffffff"));
                voiceViewHolder.contentTv.setVisibility(0);
                voiceViewHolder.voicePlayAnim.setWidth(MoorDensityUtil.dp2px(getTimeWidth(1)));
                return;
            }
            voiceViewHolder.voiceAnim.stopVoiceAnimation();
            voiceViewHolder.voiceAnim.setVisibility(8);
            if (fromToMessage.sendState.equals("true")) {
                voiceViewHolder.contentTv.setTextColor(chatActivity.getResources().getColor(R.color.ykfsdk_voice_tv));
                voiceViewHolder.contentTv.setShadowLayer(2.0f, 1.2f, 1.2f, Color.parseColor("#ffffffff"));
                voiceViewHolder.contentTv.setVisibility(0);
                voiceViewHolder.voiceAnim.setWidth(MoorDensityUtil.dp2px(getTimeWidth(1)));
                voiceViewHolder.voicePlayAnim.setWidth(MoorDensityUtil.dp2px(getTimeWidth(1)));
                uploadVoiceStatus(voiceViewHolder, 8, 0, z);
            } else {
                voiceViewHolder.contentTv.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                if (fromToMessage.sendState.equals(Bugly.SDK_IS_DEV)) {
                    uploadVoiceStatus(voiceViewHolder, 8, 0, z);
                    voiceViewHolder.contentTv.setVisibility(8);
                } else {
                    uploadVoiceStatus(voiceViewHolder, 0, 8, z);
                }
                voiceViewHolder.voiceAnim.setWidth(80);
                voiceViewHolder.voicePlayAnim.setWidth(80);
            }
            VoiceAnimImageView voiceAnimImageView = voiceViewHolder.voiceAnim;
            int i3 = R.drawable.ykfsdk_ykf_send_msg_bg;
            voiceAnimImageView.setBackgroundResource(i3);
            voiceViewHolder.voicePlayAnim.setBackgroundResource(i3);
            voiceViewHolder.contentTv.setBackgroundColor(0);
        } else {
            voiceViewHolder.voiceAnim.setVisibility(8);
            voiceViewHolder.voicePlayAnim.setTag(ViewHolderTag.createTag(fromToMessage, 2, i2, voiceViewHolder.type, z, voiceViewHolder));
            voiceViewHolder.voicePlayAnim.setOnClickListener(chatActivity.getChatAdapter().getOnClickListener());
            TextView textView3 = voiceViewHolder.contentTv;
            Resources resources = chatActivity.getResources();
            int i4 = R.color.ykfsdk_voice_tv;
            textView3.setTextColor(resources.getColor(i4));
            voiceViewHolder.contentTv.setShadowLayer(2.0f, 1.2f, 1.2f, Color.parseColor("#ffffffff"));
            voiceViewHolder.contentTv.setVisibility(0);
            voiceViewHolder.voicePlayAnim.setWidth(MoorDensityUtil.dp2px(getTimeWidth(1)));
            if (chatActivity.getChatAdapter().mVoicePosition == i2) {
                voiceViewHolder.voiceAnim.setVisibility(0);
                voiceViewHolder.voiceAnim.startVoiceAnimation();
                voiceViewHolder.voiceAnim.setBackgroundResource(R.drawable.ykfsdk_ykf_receive_msg_bg);
                voiceViewHolder.voiceAnim.setWidth(MoorDensityUtil.dp2px(getTimeWidth(1)));
                voiceViewHolder.contentTv.setTextColor(chatActivity.getResources().getColor(i4));
                voiceViewHolder.contentTv.setShadowLayer(2.0f, 1.2f, 1.2f, Color.parseColor("#ffffffff"));
                voiceViewHolder.contentTv.setVisibility(0);
                voiceViewHolder.voicePlayAnim.setWidth(MoorDensityUtil.dp2px(getTimeWidth(1)));
                return;
            }
            voiceViewHolder.voiceAnim.stopVoiceAnimation();
            voiceViewHolder.voiceAnim.setVisibility(8);
            VoiceAnimImageView voiceAnimImageView2 = voiceViewHolder.voiceAnim;
            int i5 = R.drawable.ykfsdk_ykf_receive_msg_bg;
            voiceAnimImageView2.setBackgroundResource(i5);
            voiceViewHolder.voicePlayAnim.setBackgroundResource(i5);
            voiceViewHolder.contentTv.setBackgroundColor(0);
        }
        if (fromToMessage.withDrawStatus) {
            return;
        }
        if (fromToMessage.isShowVtoT && !TextUtils.isEmpty(fromToMessage.voiceToText)) {
            voiceViewHolder.ll_voiceTotext.setVisibility(0);
            voiceViewHolder.tv_vototx.setText(fromToMessage.voiceToText);
            hideVoice_to_Text_Pb(true, voiceViewHolder.rl_pb, voiceViewHolder.ll_text_ok);
            voiceViewHolder.voicePlayAnim.setOnLongClickListener(null);
        } else {
            voiceViewHolder.ll_voiceTotext.setVisibility(8);
            voiceViewHolder.voicePlayAnim.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.m7.imkfsdk.chat.holder.VoiceViewHolder.1
                @Override // android.view.View.OnLongClickListener
                public boolean onLongClick(View view) {
                    if (z) {
                        VoiceViewHolder.showPopWindows(view, voiceViewHolder, fromToMessage, chatActivity);
                        return false;
                    } else if (fromToMessage.sendState.equals("true")) {
                        VoiceViewHolder.showPopWindows(view, voiceViewHolder, fromToMessage, chatActivity);
                        return false;
                    } else {
                        return false;
                    }
                }
            });
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) voiceViewHolder.rl_pb.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        voiceViewHolder.voiceSecondView.measure(makeMeasureSpec, makeMeasureSpec);
        layoutParams.width = (MoorDensityUtil.dp2px(getTimeWidth(1)) - MoorDensityUtil.dp2px(4.0f)) - voiceViewHolder.voiceSecondView.getMeasuredWidth();
        voiceViewHolder.rl_pb.setLayoutParams(layoutParams);
        if (fromToMessage.isCacheShowVtoT) {
            voiceViewHolder.ll_voiceTotext.setVisibility(0);
            hideVoice_to_Text_Pb(false, voiceViewHolder.rl_pb, voiceViewHolder.ll_text_ok);
            voiceViewHolder.voicePlayAnim.setOnLongClickListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showPopWindows(View view, final VoiceViewHolder voiceViewHolder, final FromToMessage fromToMessage, final ChatActivity chatActivity) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(chatActivity.getResources().getString(R.string.ykfsdk_voice_to_text_btn));
        if (mPopupWindowList == null) {
            mPopupWindowList = new PopupWindowList(view.getContext());
        }
        mPopupWindowList.setAnchorView(view);
        mPopupWindowList.setItemData(arrayList);
        mPopupWindowList.setModal(true);
        mPopupWindowList.show();
        mPopupWindowList.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.m7.imkfsdk.chat.holder.VoiceViewHolder.2
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view2, int i2, long j2) {
                FromToMessage fromToMessage2 = FromToMessage.this;
                if (fromToMessage2 != null) {
                    String str = fromToMessage2.unread2;
                    if (str != null && str.equals("1")) {
                        FromToMessage.this.unread2 = "0";
                    }
                    MessageDao.getInstance().updateMsgToDao(FromToMessage.this);
                    if (!TextUtils.isEmpty(FromToMessage.this.voiceSecond) && Integer.parseInt(FromToMessage.this.voiceSecond) > 60) {
                        VoiceToTextEvent voiceToTextEvent = new VoiceToTextEvent();
                        voiceToTextEvent.id = FromToMessage.this._id;
                        voiceToTextEvent.status_code = VoiceToTextEvent.STATUS_TOLONG;
                        c.f().q(voiceToTextEvent);
                        return;
                    }
                    voiceViewHolder.ll_voiceTotext.setVisibility(0);
                    VoiceViewHolder voiceViewHolder2 = voiceViewHolder;
                    VoiceViewHolder.hideVoice_to_Text_Pb(false, voiceViewHolder2.rl_pb, voiceViewHolder2.ll_text_ok);
                    chatActivity.getChatAdapter().notifyDataSetChanged();
                    if (!TextUtils.isEmpty(FromToMessage.this.voiceToText)) {
                        VoiceToTextEvent voiceToTextEvent2 = new VoiceToTextEvent();
                        FromToMessage fromToMessage3 = FromToMessage.this;
                        voiceToTextEvent2.id = fromToMessage3._id;
                        voiceToTextEvent2.toText = fromToMessage3.voiceToText;
                        voiceToTextEvent2.status_code = VoiceToTextEvent.STATUS_OK;
                        c.f().q(voiceToTextEvent2);
                    } else {
                        FromToMessage.this.isCacheShowVtoT = true;
                        MessageDao.getInstance().updateMsgToDao(FromToMessage.this);
                        chatActivity.getVoiceToText(FromToMessage.this);
                    }
                }
                VoiceViewHolder.mPopupWindowList.hide();
            }
        });
    }

    private static void uploadVoiceStatus(VoiceViewHolder voiceViewHolder, int i2, int i3, boolean z) {
        voiceViewHolder.uploadState.setVisibility(8);
        voiceViewHolder.contentTv.setVisibility(i3);
        if (z) {
        }
    }

    public BaseHolder initBaseHolder(View view, boolean z) {
        super.initBaseHolder(view);
        this.chattingTime = (TextView) view.findViewById(R.id.chatting_time_tv);
        this.voicePlayAnim = (TextView) view.findViewById(R.id.chatting_voice_play_anim_tv);
        this.uploadState = (ImageView) view.findViewById(R.id.chatting_state_iv);
        this.contentTv = (TextView) view.findViewById(R.id.chatting_content_itv);
        VoiceAnimImageView voiceAnimImageView = (VoiceAnimImageView) view.findViewById(R.id.chatting_voice_anim);
        this.voiceAnim = voiceAnimImageView;
        voiceAnimImageView.restBackground();
        this.voiceUnread = (ImageView) view.findViewById(R.id.chatting_unread_flag);
        this.voiceSecondView = (TextView) view.findViewById(R.id.chatting_voice_second_tv);
        this.ll_voiceTotext = (LinearLayout) view.findViewById(R.id.ll_voiceTotext);
        this.ll_text_ok = (LinearLayout) view.findViewById(R.id.ll_text_ok);
        this.tv_vototx = (TextView) view.findViewById(R.id.tv_vototx);
        this.rl_pb = (RelativeLayout) view.findViewById(R.id.rl_pb);
        this.pb_voice_text = (ProgressBar) view.findViewById(R.id.pb_voice_text);
        if (z) {
            this.type = 5;
            this.voiceAnim.setVoiceFrom(true);
            return this;
        }
        this.progressBar = (ProgressBar) view.findViewById(R.id.uploading_pb);
        this.voiceAnim.setVoiceFrom(false);
        this.type = 6;
        return this;
    }
}
