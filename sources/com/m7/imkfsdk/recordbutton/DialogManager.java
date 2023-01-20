package com.m7.imkfsdk.recordbutton;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.m7.imkfsdk.R;

/* loaded from: classes2.dex */
public class DialogManager {
    private Context context;
    private boolean isExceed = false;
    private Dialog mDialog;
    private ImageView mIcon;
    private TextView mTimeTextView;
    private ImageView mVoice;
    private TextView textView;

    public DialogManager(Context context) {
        this.context = context;
    }

    public void dismissDialog() {
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
        this.mDialog = null;
    }

    public void exceedTime() {
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.mTimeTextView.setText("");
        this.mTimeTextView.setVisibility(0);
        this.mTimeTextView.setBackgroundResource(R.drawable.ykfsdk_kf_voice_to_short);
        this.textView.setText(R.string.ykfsdk_ykf_talking_too_long);
        this.mIcon.setVisibility(8);
        this.mVoice.setVisibility(8);
    }

    public void recording() {
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        if (this.isExceed) {
            this.mTimeTextView.setVisibility(0);
            this.mIcon.setVisibility(4);
            this.mVoice.setVisibility(4);
        } else {
            this.mIcon.setVisibility(0);
            this.mVoice.setVisibility(0);
        }
        this.textView.setVisibility(0);
        this.mIcon.setImageResource(R.drawable.ykfsdk_recorder);
        this.textView.setText(R.string.ykfsdk_cancelsend);
        this.mTimeTextView.setVisibility(0);
    }

    public void secondLeft(int i2) {
        this.isExceed = true;
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        if (i2 == 10) {
            this.mIcon.setVisibility(4);
            this.mVoice.setVisibility(4);
            this.mTimeTextView.setVisibility(0);
        }
        TextView textView = this.mTimeTextView;
        textView.setText(i2 + "");
    }

    public void showDialog() {
        this.mDialog = new Dialog(this.context, R.style.ykfsdk_Theme_AudioDialog);
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.ykfsdk_kf_dialog_recorder, (ViewGroup) null);
        this.mDialog.setContentView(inflate);
        this.mIcon = (ImageView) inflate.findViewById(R.id.dialog_recorder_iv_rd);
        this.mVoice = (ImageView) inflate.findViewById(R.id.dialog_recorder_iv_voice);
        this.textView = (TextView) inflate.findViewById(R.id.dialog_recorder_tv);
        this.mTimeTextView = (TextView) inflate.findViewById(R.id.dialog_recorder_tv_time);
        this.mDialog.show();
        this.isExceed = false;
    }

    public void tooShort() {
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.mIcon.setVisibility(0);
        this.mVoice.setVisibility(8);
        this.textView.setVisibility(0);
        this.mIcon.setImageResource(R.drawable.ykfsdk_kf_voice_to_short);
        this.textView.setText(R.string.ykfsdk_ykf_recordingtime_istooshort);
    }

    public void updateVoiceLevel(int i2) {
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        try {
            Resources resources = this.context.getResources();
            this.mVoice.setImageResource(resources.getIdentifier("ykfsdk_kf_v" + i2, "drawable", this.context.getPackageName()));
        } catch (Exception unused) {
            this.mVoice.setImageResource(this.context.getResources().getIdentifier("ykfsdk_kf_v1", "drawable", this.context.getPackageName()));
        }
    }

    public void wantToCancel() {
        Dialog dialog = this.mDialog;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        if (this.isExceed) {
            this.mTimeTextView.setVisibility(8);
        }
        this.mIcon.setVisibility(0);
        this.mVoice.setVisibility(8);
        this.textView.setVisibility(0);
        this.mIcon.setImageResource(R.drawable.ykfsdk_kf_cancel);
        this.textView.setText(R.string.ykfsdk_recorder_want_cancel);
    }
}
