package com.m7.imkfsdk.view.imageviewer;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import com.m7.imkfsdk.R;
import com.m7.imkfsdk.chat.model.MoorImageInfoBean;
import com.m7.imkfsdk.utils.MoorImageUtil;
import com.m7.imkfsdk.view.imageviewer.listener.IMoorSimpleOnImageEventListener;
import com.m7.imkfsdk.view.imageviewer.photoview.MoorPhotoView;
import com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView;
import com.moor.imkf.lib.utils.MoorLogUtils;
import e.b.a.c;
import e.b.a.t.h;
import e.b.a.t.k.e;
import e.b.a.t.l.f;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class MoorImagePreviewAdapter extends PagerAdapter {
    private static final String TAG = "MoorImagePreviewAdapter";
    private final AppCompatActivity activity;
    private final List<MoorImageInfoBean> imageInfo;
    private HashMap<String, MoorSubsamplingScaleImageView> imageHashMap = new HashMap<>();
    private HashMap<String, MoorPhotoView> imageGifHashMap = new HashMap<>();
    private HashMap<Integer, View> imageViewHashMap = new HashMap<>();

    /* renamed from: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewAdapter$5  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass5 implements Runnable {
        public final /* synthetic */ MoorSubsamplingScaleImageView val$imageView;
        public final /* synthetic */ int val$position;
        public final /* synthetic */ ProgressBar val$progressBar;
        public final /* synthetic */ String val$url;

        public AnonymousClass5(String str, MoorSubsamplingScaleImageView moorSubsamplingScaleImageView, ProgressBar progressBar, int i2) {
            this.val$url = str;
            this.val$imageView = moorSubsamplingScaleImageView;
            this.val$progressBar = progressBar;
            this.val$position = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                final File file = c.G(MoorImagePreviewAdapter.this.activity).o().k(this.val$url).C1().get();
                MoorImagePreviewAdapter.this.activity.runOnUiThread(new Runnable() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewAdapter.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        MoorImageSource uri = MoorImageSource.uri(file.getAbsolutePath());
                        uri.dimensions(MoorImageUtil.getWidthHeight(file.getAbsolutePath())[0], MoorImageUtil.getWidthHeight(file.getAbsolutePath())[1]);
                        MoorImagePreviewAdapter.this.setImageSpec(file.getAbsolutePath(), AnonymousClass5.this.val$imageView);
                        AnonymousClass5.this.val$imageView.setOrientation(-1);
                        MoorImageSource uri2 = MoorImageSource.uri(Uri.fromFile(file));
                        if (MoorImageUtil.isBmpImageWithMime(file.getAbsolutePath(), file.getAbsolutePath())) {
                            uri2.tilingDisabled();
                        }
                        AnonymousClass5.this.val$imageView.setImage(uri);
                        AnonymousClass5.this.val$imageView.setOnImageEventListener(new IMoorSimpleOnImageEventListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewAdapter.5.1.1
                            @Override // com.m7.imkfsdk.view.imageviewer.listener.IMoorSimpleOnImageEventListener, com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnImageEventListener
                            public void onImageLoaded() {
                                super.onImageLoaded();
                                ((MoorImageInfoBean) MoorImagePreviewAdapter.this.imageInfo.get(AnonymousClass5.this.val$position)).setStartScale(AnonymousClass5.this.val$imageView.getScale());
                                AnonymousClass5.this.val$progressBar.setVisibility(8);
                            }

                            @Override // com.m7.imkfsdk.view.imageviewer.listener.IMoorSimpleOnImageEventListener, com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnImageEventListener
                            public void onReady() {
                                AnonymousClass5.this.val$progressBar.setVisibility(0);
                            }
                        });
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewAdapter$6  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass6 extends e<Bitmap> {
        public final /* synthetic */ MoorSubsamplingScaleImageView val$imageView;
        public final /* synthetic */ int val$position;
        public final /* synthetic */ ProgressBar val$progressBar;
        public final /* synthetic */ String val$url;

        public AnonymousClass6(String str, MoorSubsamplingScaleImageView moorSubsamplingScaleImageView, ProgressBar progressBar, int i2) {
            this.val$url = str;
            this.val$imageView = moorSubsamplingScaleImageView;
            this.val$progressBar = progressBar;
            this.val$position = i2;
        }

        @Override // e.b.a.t.k.p
        public void onLoadCleared(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.e, e.b.a.t.k.p
        public void onLoadFailed(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.e, e.b.a.t.k.p
        public void onLoadStarted(@Nullable Drawable drawable) {
        }

        @Override // e.b.a.t.k.p
        public /* bridge */ /* synthetic */ void onResourceReady(@NonNull Object obj, @Nullable f fVar) {
            onResourceReady((Bitmap) obj, (f<? super Bitmap>) fVar);
        }

        public void onResourceReady(@NonNull Bitmap bitmap, @Nullable f<? super Bitmap> fVar) {
            MoorImagePreviewAdapter.this.activity.runOnUiThread(new Runnable() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewAdapter.6.1
                @Override // java.lang.Runnable
                public void run() {
                    MoorImageSource uri = MoorImageSource.uri(AnonymousClass6.this.val$url);
                    uri.dimensions(MoorImageUtil.getWidthHeight(AnonymousClass6.this.val$url)[0], MoorImageUtil.getWidthHeight(AnonymousClass6.this.val$url)[1]);
                    AnonymousClass6 anonymousClass6 = AnonymousClass6.this;
                    MoorImagePreviewAdapter.this.setImageSpec(anonymousClass6.val$url, anonymousClass6.val$imageView);
                    AnonymousClass6.this.val$imageView.setOrientation(-1);
                    MoorImageSource uri2 = MoorImageSource.uri(Uri.fromFile(new File(AnonymousClass6.this.val$url)));
                    String str = AnonymousClass6.this.val$url;
                    if (MoorImageUtil.isBmpImageWithMime(str, str)) {
                        uri2.tilingDisabled();
                    }
                    AnonymousClass6.this.val$imageView.setImage(uri);
                    AnonymousClass6.this.val$imageView.setOnImageEventListener(new IMoorSimpleOnImageEventListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewAdapter.6.1.1
                        @Override // com.m7.imkfsdk.view.imageviewer.listener.IMoorSimpleOnImageEventListener, com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnImageEventListener
                        public void onImageLoaded() {
                            super.onImageLoaded();
                            ((MoorImageInfoBean) MoorImagePreviewAdapter.this.imageInfo.get(AnonymousClass6.this.val$position)).setStartScale(AnonymousClass6.this.val$imageView.getScale());
                            AnonymousClass6.this.val$progressBar.setVisibility(8);
                        }

                        @Override // com.m7.imkfsdk.view.imageviewer.listener.IMoorSimpleOnImageEventListener, com.m7.imkfsdk.view.imageviewer.subscaleview.MoorSubsamplingScaleImageView.OnImageEventListener
                        public void onReady() {
                            AnonymousClass6.this.val$progressBar.setVisibility(0);
                        }
                    });
                }
            });
        }
    }

    public MoorImagePreviewAdapter(AppCompatActivity appCompatActivity, @NonNull List<MoorImageInfoBean> list) {
        this.imageInfo = list;
        this.activity = appCompatActivity;
    }

    private void loadNativeImage(int i2, String str, ProgressBar progressBar, MoorSubsamplingScaleImageView moorSubsamplingScaleImageView, MoorPhotoView moorPhotoView) {
        if (!MoorImageUtil.isGifImageWithMime(str, str)) {
            h z = new h().D().z(R.drawable.ykfsdk_pic_thumb_bg);
            z.u();
            c.G(this.activity).m().k(str).l(z).j1(new AnonymousClass6(str, moorSubsamplingScaleImageView, progressBar, i2));
            return;
        }
        h z2 = new h().D().z(R.drawable.ykfsdk_pic_thumb_bg);
        z2.t(e.b.a.p.k.h.f9534d);
        c.G(this.activity).p().k(str).l(z2).m1(moorPhotoView);
        progressBar.setVisibility(8);
    }

    private void loadNetImage(int i2, String str, ProgressBar progressBar, MoorSubsamplingScaleImageView moorSubsamplingScaleImageView, MoorPhotoView moorPhotoView) {
        if (!MoorImageUtil.isGifImageWithMime(str, str)) {
            new Thread(new AnonymousClass5(str, moorSubsamplingScaleImageView, progressBar, i2)).start();
            return;
        }
        h z = new h().D().z(R.drawable.ykfsdk_pic_thumb_bg);
        z.t(e.b.a.p.k.h.f9534d);
        c.G(this.activity).p().k(str).l(z).m1(moorPhotoView);
        progressBar.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageSpec(String str, MoorSubsamplingScaleImageView moorSubsamplingScaleImageView) {
        if (MoorImageUtil.isLongImage(this.activity, str)) {
            moorSubsamplingScaleImageView.setMinimumScaleType(4);
            moorSubsamplingScaleImageView.setMinScale(MoorImageUtil.getLongImageMinScale(this.activity, str));
            moorSubsamplingScaleImageView.setMaxScale(MoorImageUtil.getLongImageMaxScale(this.activity, str));
            moorSubsamplingScaleImageView.setDoubleTapZoomScale(MoorImageUtil.getLongImageMaxScale(this.activity, str));
            return;
        }
        boolean isWideImage = MoorImageUtil.isWideImage(this.activity, str);
        boolean isSmallImage = MoorImageUtil.isSmallImage(this.activity, str);
        if (isWideImage) {
            moorSubsamplingScaleImageView.setMinimumScaleType(1);
            moorSubsamplingScaleImageView.setMinScale(MoorImagePreview.getInstance().getMinScale());
            moorSubsamplingScaleImageView.setMaxScale(MoorImagePreview.getInstance().getMaxScale());
            moorSubsamplingScaleImageView.setDoubleTapZoomScale(MoorImageUtil.getWideImageDoubleScale(this.activity, str));
        } else if (isSmallImage) {
            moorSubsamplingScaleImageView.setMinimumScaleType(3);
            moorSubsamplingScaleImageView.setMinScale(MoorImageUtil.getSmallImageMinScale(this.activity, str));
            moorSubsamplingScaleImageView.setMaxScale(MoorImageUtil.getSmallImageMaxScale(this.activity, str));
            moorSubsamplingScaleImageView.setDoubleTapZoomScale(MoorImageUtil.getSmallImageMaxScale(this.activity, str));
        } else {
            moorSubsamplingScaleImageView.setMinimumScaleType(1);
            moorSubsamplingScaleImageView.setMinScale(MoorImagePreview.getInstance().getMinScale());
            moorSubsamplingScaleImageView.setMaxScale(MoorImagePreview.getInstance().getMaxScale());
            moorSubsamplingScaleImageView.setDoubleTapZoomScale(MoorImagePreview.getInstance().getMediumScale());
        }
    }

    public void closePage() {
        try {
            HashMap<String, MoorSubsamplingScaleImageView> hashMap = this.imageHashMap;
            if (hashMap != null && hashMap.size() > 0) {
                for (Map.Entry<String, MoorSubsamplingScaleImageView> entry : this.imageHashMap.entrySet()) {
                    if (entry != null && entry.getValue() != null) {
                        entry.getValue().destroyDrawingCache();
                        entry.getValue().recycle();
                    }
                }
                this.imageHashMap.clear();
                this.imageHashMap = null;
            }
            HashMap<String, MoorPhotoView> hashMap2 = this.imageGifHashMap;
            if (hashMap2 != null && hashMap2.size() > 0) {
                for (Map.Entry<String, MoorPhotoView> entry2 : this.imageGifHashMap.entrySet()) {
                    if (entry2 != null && entry2.getValue() != null) {
                        entry2.getValue().destroyDrawingCache();
                        entry2.getValue().setImageBitmap(null);
                    }
                }
                this.imageGifHashMap.clear();
                this.imageGifHashMap = null;
            }
            HashMap<Integer, View> hashMap3 = this.imageViewHashMap;
            if (hashMap3 == null || hashMap3.size() <= 0) {
                return;
            }
            this.imageViewHashMap.clear();
            this.imageViewHashMap = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        View view;
        MoorPhotoView moorPhotoView;
        MoorSubsamplingScaleImageView moorSubsamplingScaleImageView;
        String path = this.imageInfo.get(i2).getPath();
        try {
            HashMap<String, MoorSubsamplingScaleImageView> hashMap = this.imageHashMap;
            if (hashMap != null && (moorSubsamplingScaleImageView = hashMap.get(path)) != null) {
                moorSubsamplingScaleImageView.resetScaleAndCenter();
                moorSubsamplingScaleImageView.destroyDrawingCache();
                moorSubsamplingScaleImageView.recycle();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            HashMap<String, MoorPhotoView> hashMap2 = this.imageGifHashMap;
            if (hashMap2 != null && (moorPhotoView = hashMap2.get(path)) != null) {
                moorPhotoView.destroyDrawingCache();
                moorPhotoView.setImageBitmap(null);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        try {
            HashMap<Integer, View> hashMap3 = this.imageViewHashMap;
            if (hashMap3 == null || (view = hashMap3.get(Integer.valueOf(i2))) == null) {
                return;
            }
            if (view instanceof MoorSubsamplingScaleImageView) {
                ((MoorSubsamplingScaleImageView) view).resetScaleAndCenter();
                ((MoorSubsamplingScaleImageView) view).destroyDrawingCache();
                ((MoorSubsamplingScaleImageView) view).recycle();
            } else if (view instanceof MoorPhotoView) {
                ((MoorPhotoView) view).destroyDrawingCache();
                ((MoorPhotoView) view).setImageBitmap(null);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return this.imageInfo.size();
    }

    public HashMap<Integer, View> getImageViewHashMap() {
        return this.imageViewHashMap;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(@NonNull Object obj) {
        return -2;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    @SuppressLint({"CheckResult"})
    public Object instantiateItem(@NonNull ViewGroup viewGroup, final int i2) {
        AppCompatActivity appCompatActivity = this.activity;
        if (appCompatActivity == null) {
            return viewGroup;
        }
        View inflate = View.inflate(appCompatActivity, R.layout.ykfsdk_item_photoview, null);
        ProgressBar progressBar = (ProgressBar) inflate.findViewById(R.id.progress_view);
        MoorSubsamplingScaleImageView moorSubsamplingScaleImageView = (MoorSubsamplingScaleImageView) inflate.findViewById(R.id.photo_view);
        MoorPhotoView moorPhotoView = (MoorPhotoView) inflate.findViewById(R.id.gif_view);
        String path = this.imageInfo.get(i2).getPath();
        moorSubsamplingScaleImageView.setMinimumScaleType(1);
        moorSubsamplingScaleImageView.setDoubleTapZoomStyle(2);
        moorSubsamplingScaleImageView.setDoubleTapZoomDuration(MoorImagePreview.getInstance().getZoomTransitionDuration());
        moorSubsamplingScaleImageView.setMinScale(MoorImagePreview.getInstance().getMinScale());
        moorSubsamplingScaleImageView.setMaxScale(MoorImagePreview.getInstance().getMaxScale());
        moorSubsamplingScaleImageView.setDoubleTapZoomScale(MoorImagePreview.getInstance().getMediumScale());
        moorPhotoView.setZoomTransitionDuration(MoorImagePreview.getInstance().getZoomTransitionDuration());
        moorPhotoView.setMinimumScale(MoorImagePreview.getInstance().getMinScale());
        moorPhotoView.setMaximumScale(MoorImagePreview.getInstance().getMaxScale());
        moorPhotoView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        moorSubsamplingScaleImageView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MoorImagePreview.getInstance().isEnableClickClose()) {
                    MoorImagePreviewAdapter.this.activity.onBackPressed();
                }
                if (MoorImagePreview.getInstance().getBigImageClickListener() != null) {
                    MoorImagePreview.getInstance().getBigImageClickListener().onClick(MoorImagePreviewAdapter.this.activity, view, i2);
                }
            }
        });
        moorPhotoView.setOnClickListener(new View.OnClickListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewAdapter.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MoorImagePreview.getInstance().isEnableClickClose()) {
                    MoorImagePreviewAdapter.this.activity.onBackPressed();
                }
                if (MoorImagePreview.getInstance().getBigImageClickListener() != null) {
                    MoorImagePreview.getInstance().getBigImageClickListener().onClick(MoorImagePreviewAdapter.this.activity, view, i2);
                }
            }
        });
        moorSubsamplingScaleImageView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewAdapter.3
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MoorImagePreview.getInstance().getBigImageLongClickListener() != null) {
                    return MoorImagePreview.getInstance().getBigImageLongClickListener().onLongClick(MoorImagePreviewAdapter.this.activity, view, i2);
                }
                return false;
            }
        });
        moorPhotoView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.m7.imkfsdk.view.imageviewer.MoorImagePreviewAdapter.4
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (MoorImagePreview.getInstance().getBigImageLongClickListener() != null) {
                    return MoorImagePreview.getInstance().getBigImageLongClickListener().onLongClick(MoorImagePreviewAdapter.this.activity, view, i2);
                }
                return false;
            }
        });
        if (!MoorImageUtil.isGifImageWithMime(path, path)) {
            moorSubsamplingScaleImageView.setVisibility(0);
            moorPhotoView.setVisibility(8);
            this.imageViewHashMap.put(Integer.valueOf(i2), moorSubsamplingScaleImageView);
        } else {
            moorSubsamplingScaleImageView.setVisibility(8);
            moorPhotoView.setVisibility(0);
            this.imageViewHashMap.put(Integer.valueOf(i2), moorPhotoView);
        }
        this.imageGifHashMap.remove(path);
        this.imageGifHashMap.put(path, moorPhotoView);
        this.imageHashMap.remove(path);
        this.imageHashMap.put(path, moorSubsamplingScaleImageView);
        String trim = path.trim();
        MoorLogUtils.d(trim);
        progressBar.setVisibility(0);
        if (trim.startsWith("http")) {
            loadNetImage(i2, trim, progressBar, moorSubsamplingScaleImageView, moorPhotoView);
        } else {
            loadNativeImage(i2, trim, progressBar, moorSubsamplingScaleImageView, moorPhotoView);
        }
        viewGroup.addView(inflate);
        return inflate;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i2, @NonNull Object obj) {
        super.setPrimaryItem(viewGroup, i2, obj);
    }
}
