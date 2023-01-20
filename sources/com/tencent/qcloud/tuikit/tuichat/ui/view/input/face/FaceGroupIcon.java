package com.tencent.qcloud.tuikit.tuichat.ui.view.input.face;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qcloud.tuikit.tuichat.R;

/* loaded from: classes3.dex */
public class FaceGroupIcon extends RelativeLayout {
    private ImageView faceTabIcon;

    public FaceGroupIcon(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.face_group_icon, this);
        this.faceTabIcon = (ImageView) findViewById(R.id.face_group_tab_icon);
    }

    public void setFaceTabIcon(Bitmap bitmap) {
        this.faceTabIcon.setImageBitmap(bitmap);
    }

    public FaceGroupIcon(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FaceGroupIcon(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
