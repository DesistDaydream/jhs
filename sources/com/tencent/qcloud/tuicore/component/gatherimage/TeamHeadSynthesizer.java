package com.tencent.qcloud.tuicore.component.gatherimage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.qcloud.tuicore.R;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuicore.component.imageEngine.impl.GlideEngine;
import com.tencent.qcloud.tuicore.util.BackgroundTasks;
import com.tencent.qcloud.tuicore.util.ImageUtil;
import com.tencent.qcloud.tuicore.util.ThreadHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/* loaded from: classes3.dex */
public class TeamHeadSynthesizer implements Synthesizer {
    public ImageView imageView;
    public Context mContext;
    public MultiImageData multiImageData;
    private String currentImageId = "";
    public Callback callback = new Callback() { // from class: com.tencent.qcloud.tuicore.component.gatherimage.TeamHeadSynthesizer.1
        {
            TeamHeadSynthesizer.this = this;
        }

        @Override // com.tencent.qcloud.tuicore.component.gatherimage.TeamHeadSynthesizer.Callback
        public void onCall(Bitmap bitmap, String str) {
            if (TextUtils.equals(TeamHeadSynthesizer.this.getImageId(), str)) {
                GlideEngine.loadUserIcon(TeamHeadSynthesizer.this.imageView, bitmap);
            }
        }
    };

    /* loaded from: classes3.dex */
    public interface Callback {
        void onCall(Bitmap bitmap, String str);
    }

    public TeamHeadSynthesizer(Context context, ImageView imageView) {
        this.mContext = context;
        this.imageView = imageView;
        init();
    }

    private Bitmap asyncLoadImage(Object obj, int i2) throws ExecutionException, InterruptedException {
        return GlideEngine.loadBitmap(obj, i2);
    }

    private void init() {
        this.multiImageData = new MultiImageData();
    }

    @Override // com.tencent.qcloud.tuicore.component.gatherimage.Synthesizer
    public boolean asyncLoadImageList(MultiImageData multiImageData) {
        List<Object> imageUrls = multiImageData.getImageUrls();
        for (int i2 = 0; i2 < imageUrls.size(); i2++) {
            Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), TUIThemeManager.getAttrResId(this.mContext, R.attr.core_default_user_icon));
            try {
                multiImageData.putBitmap(asyncLoadImage(imageUrls.get(i2), multiImageData.targetImageSize), i2);
            } catch (InterruptedException e2) {
                e2.printStackTrace();
                multiImageData.putBitmap(decodeResource, i2);
            } catch (ExecutionException e3) {
                e3.printStackTrace();
                multiImageData.putBitmap(decodeResource, i2);
            }
        }
        return true;
    }

    public int[] calculateGridParam(int i2) {
        int[] iArr = new int[2];
        if (i2 < 3) {
            iArr[0] = 1;
            iArr[1] = i2;
        } else if (i2 <= 4) {
            iArr[0] = 2;
            iArr[1] = 2;
        } else {
            iArr[0] = (i2 / 3) + (i2 % 3 == 0 ? 0 : 1);
            iArr[1] = 3;
        }
        return iArr;
    }

    public void clearImage() {
        GlideEngine.clear(this.imageView);
    }

    public void drawBitmapAtPosition(Canvas canvas, int i2, int i3, int i4, int i5, Bitmap bitmap) {
        if (bitmap == null && this.multiImageData.getDefaultImageResId() > 0) {
            bitmap = BitmapFactory.decodeResource(this.mContext.getResources(), this.multiImageData.getDefaultImageResId());
        }
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(i2, i3, i4, i5), (Paint) null);
        }
    }

    @Override // com.tencent.qcloud.tuicore.component.gatherimage.Synthesizer
    public void drawDrawable(Canvas canvas, MultiImageData multiImageData) {
        int i2;
        canvas.drawColor(multiImageData.bgColor);
        int size = multiImageData.size();
        int i3 = multiImageData.maxHeight;
        int i4 = multiImageData.gap;
        int i5 = (i3 + i4) / 2;
        int i6 = (i3 - i4) / 2;
        int i7 = multiImageData.maxWidth;
        int i8 = (i7 + i4) / 2;
        int i9 = (i7 - i4) / 2;
        int i10 = (i3 - multiImageData.targetImageSize) / 2;
        int i11 = 0;
        while (i11 < size) {
            int i12 = multiImageData.columnCount;
            int i13 = i11 / i12;
            int i14 = i11 % i12;
            int i15 = multiImageData.targetImageSize;
            int i16 = i5;
            double d2 = i15 * (i12 == 1 ? i14 + 0.5d : i14);
            int i17 = multiImageData.gap;
            int i18 = i6;
            int i19 = (int) (d2 + ((i14 + 1) * i17));
            int i20 = (int) ((i15 * (i12 == 1 ? i13 + 0.5d : i13)) + (i17 * (i13 + 1)));
            int i21 = i19 + i15;
            int i22 = i20 + i15;
            Bitmap bitmap = multiImageData.getBitmap(i11);
            if (size == 1) {
                i2 = i11;
                drawBitmapAtPosition(canvas, i19, i20, i21, i22, bitmap);
            } else {
                i2 = i11;
                if (size == 2) {
                    drawBitmapAtPosition(canvas, i19, i10, i21, i10 + multiImageData.targetImageSize, bitmap);
                } else if (size == 3) {
                    if (i2 == 0) {
                        drawBitmapAtPosition(canvas, i10, i20, i10 + multiImageData.targetImageSize, i22, bitmap);
                    } else {
                        int i23 = multiImageData.gap;
                        int i24 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i2 - 1) * i24) + (i23 * i2), i16, (i23 * i2) + (i24 * i2), i16 + i24, bitmap);
                    }
                } else if (size == 4) {
                    drawBitmapAtPosition(canvas, i19, i20, i21, i22, bitmap);
                } else if (size == 5) {
                    if (i2 == 0) {
                        int i25 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, i9 - i25, i9 - i25, i9, i9, bitmap);
                    } else if (i2 == 1) {
                        int i26 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, i8, i9 - i26, i8 + i26, i9, bitmap);
                    } else {
                        int i27 = multiImageData.gap;
                        int i28 = i2 - 1;
                        int i29 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i2 - 2) * i29) + (i27 * i28), i16, (i27 * i28) + (i28 * i29), i16 + i29, bitmap);
                    }
                } else if (size == 6) {
                    if (i2 < 3) {
                        int i30 = multiImageData.gap;
                        int i31 = i2 + 1;
                        int i32 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, (i32 * i2) + (i30 * i31), i18 - i32, (i30 * i31) + (i32 * i31), i18, bitmap);
                    } else {
                        int i33 = multiImageData.gap;
                        int i34 = i2 - 2;
                        int i35 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i2 - 3) * i35) + (i33 * i34), i16, (i33 * i34) + (i34 * i35), i16 + i35, bitmap);
                    }
                } else if (size == 7) {
                    if (i2 == 0) {
                        int i36 = multiImageData.gap;
                        int i37 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, i10, i36, i10 + i37, i36 + i37, bitmap);
                    } else if (i2 > 0 && i2 < 4) {
                        int i38 = multiImageData.gap;
                        int i39 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i2 - 1) * i39) + (i38 * i2), i10, (i38 * i2) + (i39 * i2), i10 + i39, bitmap);
                    } else {
                        int i40 = multiImageData.gap;
                        int i41 = i2 - 3;
                        int i42 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i2 - 4) * i42) + (i40 * i41), i16 + (i42 / 2), (i40 * i41) + (i41 * i42), i16 + (i42 / 2) + i42, bitmap);
                    }
                } else if (size == 8) {
                    if (i2 == 0) {
                        int i43 = multiImageData.targetImageSize;
                        int i44 = multiImageData.gap;
                        drawBitmapAtPosition(canvas, i9 - i43, i44, i9, i44 + i43, bitmap);
                    } else if (i2 == 1) {
                        int i45 = multiImageData.gap;
                        int i46 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, i8, i45, i8 + i46, i45 + i46, bitmap);
                    } else if (i2 > 1 && i2 < 5) {
                        int i47 = multiImageData.gap;
                        int i48 = i2 - 1;
                        int i49 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i2 - 2) * i49) + (i47 * i48), i10, (i47 * i48) + (i48 * i49), i10 + i49, bitmap);
                    } else {
                        int i50 = multiImageData.gap;
                        int i51 = i2 - 4;
                        int i52 = multiImageData.targetImageSize;
                        drawBitmapAtPosition(canvas, ((i2 - 5) * i52) + (i50 * i51), i16 + (i52 / 2), (i50 * i51) + (i51 * i52), i16 + (i52 / 2) + i52, bitmap);
                    }
                } else if (size == 9) {
                    drawBitmapAtPosition(canvas, i19, i20, i21, i22, bitmap);
                }
            }
            i11 = i2 + 1;
            i5 = i16;
            i6 = i18;
        }
    }

    public int getDefaultImage() {
        return this.multiImageData.getDefaultImageResId();
    }

    public String getImageId() {
        return this.currentImageId;
    }

    public MultiImageData getMultiImageData() {
        return this.multiImageData;
    }

    public void load(final String str) {
        final MultiImageData multiImageData;
        if (this.multiImageData.size() == 0) {
            if (str == null || TextUtils.equals(str, this.currentImageId)) {
                GlideEngine.loadUserIcon(this.imageView, Integer.valueOf(getDefaultImage()));
            }
        } else if (this.multiImageData.size() == 1) {
            if (str == null || TextUtils.equals(str, this.currentImageId)) {
                GlideEngine.loadUserIcon(this.imageView, this.multiImageData.getImageUrls().get(0));
            }
        } else {
            clearImage();
            try {
                multiImageData = this.multiImageData.m41clone();
            } catch (CloneNotSupportedException e2) {
                e2.printStackTrace();
                ArrayList arrayList = new ArrayList();
                List<Object> list = this.multiImageData.imageUrls;
                if (list != null) {
                    arrayList.addAll(list);
                }
                multiImageData = new MultiImageData(arrayList, this.multiImageData.defaultImageResId);
            }
            int[] calculateGridParam = calculateGridParam(this.multiImageData.size());
            multiImageData.rowCount = calculateGridParam[0];
            int i2 = calculateGridParam[1];
            multiImageData.columnCount = i2;
            int i3 = multiImageData.maxWidth - ((i2 + 1) * multiImageData.gap);
            if (i2 == 1) {
                i2 = 2;
            }
            multiImageData.targetImageSize = i3 / i2;
            ThreadHelper.INST.execute(new Runnable() { // from class: com.tencent.qcloud.tuicore.component.gatherimage.TeamHeadSynthesizer.2
                {
                    TeamHeadSynthesizer.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap bitmap;
                    File file = new File(TUIConfig.getImageBaseDir() + str);
                    boolean z = false;
                    if (file.exists() && file.isFile()) {
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        bitmap = BitmapFactory.decodeFile(file.getPath(), options);
                        if (options.outWidth > 0 && options.outHeight > 0) {
                            z = true;
                        }
                    } else {
                        bitmap = null;
                    }
                    if (!z) {
                        TeamHeadSynthesizer.this.asyncLoadImageList(multiImageData);
                        final Bitmap synthesizeImageList = TeamHeadSynthesizer.this.synthesizeImageList(multiImageData);
                        ImageUtil.storeBitmap(file, synthesizeImageList);
                        ImageUtil.setGroupConversationAvatar(str, file.getAbsolutePath());
                        BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuicore.component.gatherimage.TeamHeadSynthesizer.2.1
                            {
                                AnonymousClass2.this = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                TeamHeadSynthesizer.this.callback.onCall(synthesizeImageList, str);
                            }
                        });
                        return;
                    }
                    BackgroundTasks.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.qcloud.tuicore.component.gatherimage.TeamHeadSynthesizer.2.2
                        {
                            AnonymousClass2.this = this;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            TeamHeadSynthesizer.this.callback.onCall(bitmap, str);
                        }
                    });
                }
            });
        }
    }

    public void setBgColor(int i2) {
        this.multiImageData.bgColor = i2;
    }

    public void setDefaultImage(int i2) {
        this.multiImageData.setDefaultImageResId(i2);
    }

    public void setGap(int i2) {
        this.multiImageData.gap = i2;
    }

    public void setImageId(String str) {
        this.currentImageId = str;
    }

    public void setMaxWidthHeight(int i2, int i3) {
        MultiImageData multiImageData = this.multiImageData;
        multiImageData.maxWidth = i2;
        multiImageData.maxHeight = i3;
    }

    @Override // com.tencent.qcloud.tuicore.component.gatherimage.Synthesizer
    public Bitmap synthesizeImageList(MultiImageData multiImageData) {
        Bitmap createBitmap = Bitmap.createBitmap(multiImageData.maxWidth, multiImageData.maxHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawDrawable(canvas, multiImageData);
        canvas.save();
        canvas.restore();
        return createBitmap;
    }
}
