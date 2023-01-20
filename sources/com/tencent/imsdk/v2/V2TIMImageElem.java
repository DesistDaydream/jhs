package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.message.DownloadParam;
import com.tencent.imsdk.message.DownloadProgressInfo;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.v2.V2TIMElem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class V2TIMImageElem extends V2TIMElem {
    public static final int V2TIM_IMAGE_TYPE_LARGE = 2;
    public static final int V2TIM_IMAGE_TYPE_ORIGIN = 0;
    public static final int V2TIM_IMAGE_TYPE_THUMB = 1;
    private ImageElement timImageElem;

    /* loaded from: classes3.dex */
    public class V2TIMImage implements Serializable {
        private int height;
        private int size;
        private int type;
        private String url;
        private String uuid;
        private int width;

        public V2TIMImage() {
            V2TIMImageElem.this = r1;
        }

        public void downloadImage(String str, final V2TIMDownloadCallback v2TIMDownloadCallback) {
            DownloadParam downloadParam = new DownloadParam();
            downloadParam.setDownloadFlag(DownloadParam.DOWNLOAD_FLAG_REQUEST_DIRECT_DOWNLOAD);
            downloadParam.setDownloadUrl(this.url);
            downloadParam.setFileSavePath(str);
            MessageCenter.getInstance().downloadMessageElement(downloadParam, new IMCallback<DownloadProgressInfo>(new V2TIMValueCallback<DownloadProgressInfo>() { // from class: com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.1
                {
                    V2TIMImage.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i2, String str2) {
                    V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback2 != null) {
                        v2TIMDownloadCallback2.onError(i2, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(DownloadProgressInfo downloadProgressInfo) {
                    V2TIMElem.V2ProgressInfo v2ProgressInfo = new V2TIMElem.V2ProgressInfo(downloadProgressInfo.getCurrentSize(), downloadProgressInfo.getTotalSize());
                    V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback2 != null) {
                        v2TIMDownloadCallback2.onProgress(v2ProgressInfo);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.3
                {
                    V2TIMImage.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(DownloadProgressInfo downloadProgressInfo) {
                    super.success((AnonymousClass3) downloadProgressInfo);
                }
            }, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.2
                {
                    V2TIMImage.this = this;
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i2, String str2) {
                    V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback2 != null) {
                        v2TIMDownloadCallback2.onError(i2, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    V2TIMDownloadCallback v2TIMDownloadCallback2 = v2TIMDownloadCallback;
                    if (v2TIMDownloadCallback2 != null) {
                        v2TIMDownloadCallback2.onSuccess();
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMImageElem.V2TIMImage.4
                {
                    V2TIMImage.this = this;
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i2, String str2) {
                    super.fail(i2, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }

        public int getHeight() {
            return this.height;
        }

        public int getSize() {
            return this.size;
        }

        public int getType() {
            return this.type;
        }

        public String getUUID() {
            return this.uuid;
        }

        public String getUrl() {
            return this.url;
        }

        public int getWidth() {
            return this.width;
        }

        public void setHeight(int i2) {
            this.height = i2;
        }

        public void setSize(int i2) {
            this.size = i2;
        }

        public void setType(int i2) {
            this.type = i2;
        }

        public void setUUID(String str) {
            this.uuid = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setWidth(int i2) {
            this.width = i2;
        }
    }

    public List<V2TIMImage> getImageList() {
        if (getElement() == null) {
            return null;
        }
        this.timImageElem = (ImageElement) getElement();
        ArrayList arrayList = new ArrayList();
        V2TIMImage v2TIMImage = new V2TIMImage();
        v2TIMImage.setUUID(this.timImageElem.getOriginImageUUID());
        v2TIMImage.setType(0);
        v2TIMImage.setSize(this.timImageElem.getOriginImageFileSize());
        v2TIMImage.setWidth(this.timImageElem.getOriginImageWidth());
        v2TIMImage.setHeight(this.timImageElem.getOriginImageHeight());
        v2TIMImage.setUrl(this.timImageElem.getOriginImageUrl());
        arrayList.add(v2TIMImage);
        V2TIMImage v2TIMImage2 = new V2TIMImage();
        v2TIMImage2.setUUID(this.timImageElem.getLargeImageUUID());
        v2TIMImage2.setType(2);
        v2TIMImage2.setSize(this.timImageElem.getLargeImageFileSize());
        v2TIMImage2.setWidth(this.timImageElem.getLargeImageWidth());
        v2TIMImage2.setHeight(this.timImageElem.getLargeImageHeight());
        v2TIMImage2.setUrl(this.timImageElem.getLargeImageUrl());
        arrayList.add(v2TIMImage2);
        V2TIMImage v2TIMImage3 = new V2TIMImage();
        v2TIMImage3.setUUID(this.timImageElem.getThumbImageUUID());
        v2TIMImage3.setType(1);
        v2TIMImage3.setSize(this.timImageElem.getThumbImageFileSize());
        v2TIMImage3.setWidth(this.timImageElem.getThumbImageWidth());
        v2TIMImage3.setHeight(this.timImageElem.getThumbImageHeight());
        v2TIMImage3.setUrl(this.timImageElem.getThumbImageUrl());
        arrayList.add(v2TIMImage3);
        return arrayList;
    }

    public String getPath() {
        if (getElement() == null) {
            return null;
        }
        ImageElement imageElement = (ImageElement) getElement();
        this.timImageElem = imageElement;
        return imageElement.getOriginImageFilePath();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V2TIMImageElem--->");
        sb.append(", localPath=");
        sb.append(getPath());
        for (V2TIMImage v2TIMImage : getImageList()) {
            sb.append(", type:");
            sb.append(v2TIMImage.getType());
            sb.append(", uuid:");
            sb.append(v2TIMImage.getUUID());
            sb.append(", height:");
            sb.append(v2TIMImage.getHeight());
            sb.append(", width:");
            sb.append(v2TIMImage.getWidth());
            sb.append(", size:");
            sb.append(v2TIMImage.getSize());
            sb.append(", url:" + v2TIMImage.getUrl());
        }
        return sb.toString();
    }
}
