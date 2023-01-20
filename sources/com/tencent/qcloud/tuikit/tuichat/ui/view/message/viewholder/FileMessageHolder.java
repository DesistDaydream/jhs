package com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.util.FileUtil;
import com.tencent.qcloud.tuicore.util.ScreenUtil;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatService;
import com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.ProgressPresenter;
import com.tencent.qcloud.tuikit.tuichat.interfaces.NetworkConnectionListener;
import com.tencent.qcloud.tuikit.tuichat.ui.interfaces.OnItemClickListener;

/* loaded from: classes3.dex */
public class FileMessageHolder extends MessageContentHolder {
    private TextView fileNameText;
    private TextView fileSizeText;
    private TextView fileStatusText;
    private String msgId;
    private NetworkConnectionListener networkConnectionListener;
    private Drawable normalBackground;
    private ProgressDrawable progressDrawable;
    private ProgressPresenter.ProgressListener progressListener;

    /* loaded from: classes3.dex */
    public static class ProgressDrawable extends Drawable {
        private Drawable backgroundDrawable;
        private final Paint borderPaint;
        private final float borderWidth;
        private final Paint highLightPaint;
        private boolean isSelf;
        private final Paint paint;
        private int progress;
        private final Path rectPath = new Path();
        private final Path solidPath = new Path();
        private final Path highLightPath = new Path();

        public ProgressDrawable() {
            float dip2px = ScreenUtil.dip2px(0.96f);
            this.borderWidth = dip2px;
            Paint paint = new Paint();
            this.paint = paint;
            Paint paint2 = new Paint();
            this.borderPaint = paint2;
            paint.setStyle(Paint.Style.FILL);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(dip2px);
            paint.setAntiAlias(true);
            paint2.setAntiAlias(true);
            Paint paint3 = new Paint();
            this.highLightPaint = paint3;
            paint3.setAntiAlias(true);
            paint3.setStyle(Paint.Style.FILL);
            paint3.setColor(0);
        }

        public void clearHighLightColor() {
            this.highLightPaint.setColor(0);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(@NonNull Canvas canvas) {
            if (this.progress == 0) {
                return;
            }
            Rect bounds = this.backgroundDrawable.getBounds();
            int i2 = bounds.right;
            int i3 = bounds.bottom;
            int i4 = (this.progress * i2) / 100;
            float dip2px = ScreenUtil.dip2px(10.96f);
            float dip2px2 = ScreenUtil.dip2px(2.19f);
            float[] fArr = this.isSelf ? new float[]{dip2px, dip2px, dip2px2, dip2px2, dip2px, dip2px, dip2px, dip2px} : new float[]{dip2px2, dip2px2, dip2px, dip2px, dip2px, dip2px, dip2px, dip2px};
            this.rectPath.reset();
            this.solidPath.reset();
            this.highLightPath.reset();
            Path path = this.rectPath;
            float f2 = this.borderWidth;
            float f3 = i3;
            path.addRoundRect(new RectF(f2 / 2.0f, f2 / 2.0f, i2 - (f2 / 2.0f), f3 - (f2 / 2.0f)), fArr, Path.Direction.CW);
            this.highLightPath.set(this.rectPath);
            canvas.drawPath(this.rectPath, this.borderPaint);
            Path path2 = this.solidPath;
            float f4 = this.borderWidth;
            path2.addRect(new RectF(f4 / 2.0f, f4 / 2.0f, i4 - (f4 / 2.0f), f3 - (f4 / 2.0f)), Path.Direction.CW);
            this.rectPath.op(this.solidPath, Path.Op.INTERSECT);
            canvas.drawPath(this.rectPath, this.paint);
            canvas.drawPath(this.highLightPath, this.highLightPaint);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i2) {
        }

        public void setBackgroundDrawable(Drawable drawable) {
            this.backgroundDrawable = drawable;
        }

        public void setBorderColor(int i2) {
            this.borderPaint.setColor(i2);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(@Nullable ColorFilter colorFilter) {
        }

        public void setHighLightColor(int i2) {
            this.highLightPaint.setColor(i2);
        }

        public void setPaintColor(int i2) {
            this.paint.setColor(i2);
        }

        public void setProgress(int i2) {
            this.progress = i2;
        }

        public void setSelf(boolean z) {
            this.isSelf = z;
        }
    }

    public FileMessageHolder(View view) {
        super(view);
        this.fileNameText = (TextView) view.findViewById(R.id.file_name_tv);
        this.fileSizeText = (TextView) view.findViewById(R.id.file_size_tv);
        this.fileStatusText = (TextView) view.findViewById(R.id.file_status_tv);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void downloadFile(final FileMessageBean fileMessageBean, final String str, final String str2, boolean z) {
        if (fileMessageBean.getDownloadStatus() == 6) {
            return;
        }
        if (fileMessageBean.getDownloadStatus() == 4 && z) {
            return;
        }
        fileMessageBean.setDownloadStatus(4);
        this.fileStatusText.setText(R.string.downloading);
        fileMessageBean.downloadFile(str, new FileMessageBean.FileDownloadCallback() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.FileMessageHolder.6
            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean.FileDownloadCallback
            public void onError(int i2, String str3) {
                ToastUtil.toastLongMessage("getToFile fail:" + i2 + "=" + str3);
                FileMessageHolder.this.fileStatusText.setText(R.string.un_download);
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean.FileDownloadCallback
            public void onProgress(long j2, long j3) {
                ProgressPresenter.getInstance().updateProgress(fileMessageBean.getId(), (int) ((j2 * 100) / j3));
            }

            @Override // com.tencent.qcloud.tuikit.tuichat.bean.message.FileMessageBean.FileDownloadCallback
            public void onSuccess() {
                fileMessageBean.setDataPath(str);
                if (!fileMessageBean.isSelf()) {
                    FileMessageHolder.this.fileStatusText.setText(R.string.downloaded);
                } else {
                    FileMessageHolder.this.fileStatusText.setText(R.string.sended);
                }
                fileMessageBean.setDownloadStatus(6);
                FileMessageHolder.this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.FileMessageHolder.6.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (fileMessageBean.getDownloadStatus() == 6) {
                            AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                            FileUtil.openFile(str, str2);
                        }
                    }
                });
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateProgress(int i2, TUIMessageBean tUIMessageBean) {
        if (TextUtils.equals(tUIMessageBean.getId(), this.msgId)) {
            if (!tUIMessageBean.isSelf()) {
                this.fileStatusText.setText(R.string.downloading);
            } else {
                this.fileStatusText.setText(R.string.sending);
            }
            tUIMessageBean.setDownloadStatus(4);
            if (i2 != 0 && i2 != 100) {
                Drawable background = this.msgContentFrame.getBackground();
                if (background != null) {
                    ProgressDrawable progressDrawable = this.progressDrawable;
                    if (progressDrawable == null) {
                        ProgressDrawable progressDrawable2 = new ProgressDrawable();
                        this.progressDrawable = progressDrawable2;
                        progressDrawable2.setProgress(i2);
                        Context context = this.itemView.getContext();
                        this.progressDrawable.setPaintColor(context.getResources().getColor(TUIThemeManager.getAttrResId(context, R.attr.core_bubble_bg_color)));
                        this.progressDrawable.setBorderColor(context.getResources().getColor(R.color.chat_message_bubble_bg_stoke_color));
                        this.progressDrawable.setSelf(tUIMessageBean.isSelf());
                        this.progressDrawable.setBackgroundDrawable(background);
                        this.msgContentFrame.setBackground(this.progressDrawable);
                        return;
                    }
                    progressDrawable.setProgress(i2);
                    this.msgContentFrame.setBackground(this.progressDrawable);
                    this.msgContentFrame.getBackground().invalidateSelf();
                    return;
                }
                return;
            }
            this.msgContentFrame.setBackground(this.normalBackground);
            ProgressDrawable progressDrawable3 = this.progressDrawable;
            if (progressDrawable3 != null) {
                progressDrawable3.setProgress(0);
            }
            if (i2 == 100) {
                if (!tUIMessageBean.isSelf()) {
                    this.fileStatusText.setText(R.string.downloaded);
                } else {
                    this.fileStatusText.setText(R.string.sended);
                }
                tUIMessageBean.setDownloadStatus(6);
            }
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public void clearHighLightBackground() {
        Drawable drawable = this.normalBackground;
        if (drawable != null) {
            drawable.setColorFilter(null);
        }
        ProgressDrawable progressDrawable = this.progressDrawable;
        if (progressDrawable != null) {
            progressDrawable.clearHighLightColor();
            this.progressDrawable.invalidateSelf();
        }
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public int getVariableLayout() {
        return R.layout.message_adapter_content_file;
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder
    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i2) {
        this.msgId = tUIMessageBean.getId();
        if (this.isForwardMode) {
            this.msgContentFrame.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
            this.statusImage.setVisibility(8);
        } else if (tUIMessageBean.isSelf()) {
            if (this.properties.getRightBubble() != null && this.properties.getRightBubble().getConstantState() != null) {
                this.msgContentFrame.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
            } else {
                this.msgContentFrame.setBackgroundResource(R.drawable.chat_bubble_self_cavity_bg);
            }
        } else if (this.properties.getLeftBubble() != null && this.properties.getLeftBubble().getConstantState() != null) {
            this.msgContentFrame.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
            FrameLayout frameLayout = this.msgContentFrame;
            frameLayout.setLayoutParams(frameLayout.getLayoutParams());
        } else {
            this.msgContentFrame.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
        }
        this.normalBackground = this.msgContentFrame.getBackground();
        this.progressListener = new ProgressPresenter.ProgressListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.FileMessageHolder.1
            @Override // com.tencent.qcloud.tuikit.tuichat.component.ProgressPresenter.ProgressListener
            public void onProgress(int i3) {
                FileMessageHolder.this.updateProgress(i3, tUIMessageBean);
            }
        };
        this.sendingProgress.setVisibility(8);
        final FileMessageBean fileMessageBean = (FileMessageBean) tUIMessageBean;
        final String dataPath = fileMessageBean.getDataPath();
        this.fileNameText.setText(fileMessageBean.getFileName());
        String formatFileSize = FileUtil.formatFileSize(fileMessageBean.getFileSize());
        final String fileName = fileMessageBean.getFileName();
        this.fileSizeText.setText(formatFileSize);
        if (!this.isMultiSelectMode) {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.FileMessageHolder.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (fileMessageBean.getDownloadStatus() == 6) {
                        FileUtil.openFile(dataPath, fileName);
                    }
                }
            });
        } else {
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.FileMessageHolder.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    OnItemClickListener onItemClickListener = FileMessageHolder.this.onItemClickListener;
                    if (onItemClickListener != null) {
                        onItemClickListener.onMessageClick(view, i2, tUIMessageBean);
                    }
                }
            });
        }
        if (fileMessageBean.getStatus() == 2 && fileMessageBean.getDownloadStatus() == 6) {
            this.fileStatusText.setText(R.string.sended);
        } else if (fileMessageBean.getStatus() == 1) {
            this.fileStatusText.setText(R.string.sending);
        } else if (fileMessageBean.getStatus() == 3) {
            this.fileStatusText.setText(R.string.send_failed);
        } else if (fileMessageBean.getDownloadStatus() == 4) {
            this.fileStatusText.setText(R.string.downloading);
        } else if (fileMessageBean.getDownloadStatus() == 6) {
            if (!fileMessageBean.isSelf()) {
                this.fileStatusText.setText(R.string.downloaded);
            } else {
                this.fileStatusText.setText(R.string.sended);
            }
        } else if (fileMessageBean.getDownloadStatus() == 5) {
            this.fileStatusText.setText(R.string.un_download);
        }
        if (fileMessageBean.getDownloadStatus() == 5) {
            if (this.isMultiSelectMode) {
                return;
            }
            this.msgContentFrame.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.FileMessageHolder.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FileMessageHolder.this.downloadFile(fileMessageBean, dataPath, fileName, true);
                }
            });
        }
        this.networkConnectionListener = new NetworkConnectionListener() { // from class: com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.FileMessageHolder.5
            @Override // com.tencent.qcloud.tuikit.tuichat.interfaces.NetworkConnectionListener
            public void onConnected() {
                if (fileMessageBean.getDownloadStatus() == 4) {
                    FileMessageHolder.this.downloadFile(fileMessageBean, dataPath, fileName, false);
                }
            }
        };
        TUIChatService.getInstance().registerNetworkListener(this.networkConnectionListener);
        ProgressPresenter.getInstance().registerProgressListener(tUIMessageBean.getId(), this.progressListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageContentHolder
    public void onRecycled() {
        this.progressListener = null;
        ProgressPresenter.getInstance().unregisterProgressListener(this.msgId, this.progressListener);
    }

    @Override // com.tencent.qcloud.tuikit.tuichat.ui.view.message.viewholder.MessageBaseHolder
    public void setHighLightBackground(int i2) {
        Drawable drawable = this.normalBackground;
        if (drawable != null) {
            drawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
        }
        ProgressDrawable progressDrawable = this.progressDrawable;
        if (progressDrawable != null) {
            progressDrawable.setHighLightColor(i2);
            this.progressDrawable.invalidateSelf();
        }
    }
}
