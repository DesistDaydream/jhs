package com.tencent.qcloud.tuikit.tuichat.ui.view.input;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.ui.view.input.PictureDialog;

/* loaded from: classes3.dex */
public class PictureDialog extends Dialog {
    private PListener mPListener;
    private Boolean mVideo;

    /* loaded from: classes3.dex */
    public interface PListener {
        void onClickPhoto();

        void onClickTakePhoto();

        void onClickTakeVideo();
    }

    public PictureDialog(@NonNull Context context, PListener pListener) {
        this(context, pListener, Boolean.TRUE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void b(View view) {
        dismiss();
        this.mPListener.onClickPhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void d(View view) {
        dismiss();
        this.mPListener.onClickTakePhoto();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public /* synthetic */ void f(View view) {
        dismiss();
        this.mPListener.onClickTakeVideo();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.dialog_picture);
        findViewById(R.id.photoTv).setOnClickListener(new View.OnClickListener() { // from class: e.s.a.b.a.b.b.a.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureDialog.this.b(view);
            }
        });
        findViewById(R.id.takePhotoTv).setOnClickListener(new View.OnClickListener() { // from class: e.s.a.b.a.b.b.a.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureDialog.this.d(view);
            }
        });
        if (!this.mVideo.booleanValue()) {
            findViewById(R.id.takeVideoTv).setVisibility(8);
        }
        findViewById(R.id.takeVideoTv).setOnClickListener(new View.OnClickListener() { // from class: e.s.a.b.a.b.b.a.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PictureDialog.this.f(view);
            }
        });
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        attributes.windowAnimations = R.style.BottomDialog_Animation;
        getWindow().setAttributes(attributes);
    }

    public PictureDialog(@NonNull Context context, PListener pListener, Boolean bool) {
        this(context, R.style.BottomDialog);
        this.mPListener = pListener;
        this.mVideo = bool;
    }

    public PictureDialog(@NonNull Context context, int i2) {
        super(context, i2);
        this.mVideo = Boolean.TRUE;
    }
}
