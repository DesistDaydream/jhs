package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.FaceElement;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.GroupTipsElement;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.LocationElement;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageBaseElement;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.message.VideoElement;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public class V2TIMElem implements Serializable {
    private final String TAG = "V2TIMElem";
    private int elemIndex;
    private Message message;

    /* loaded from: classes3.dex */
    public class V2ProgressInfo {
        private long currentSize;
        private long totalSize;

        public V2ProgressInfo(long j2, long j3) {
            this.currentSize = j2;
            this.totalSize = j3;
        }

        public long getCurrentSize() {
            return this.currentSize;
        }

        public long getTotalSize() {
            return this.totalSize;
        }
    }

    public void appendElem(V2TIMElem v2TIMElem) {
        if (this.message == null) {
            IMLog.e("V2TIMElem", "appendElem error, must be first elem from message");
            return;
        }
        if (v2TIMElem instanceof V2TIMTextElem) {
            TextElement textElement = new TextElement();
            textElement.setTextContent(((V2TIMTextElem) v2TIMElem).getText());
            this.message.addElement(textElement);
        } else if (v2TIMElem instanceof V2TIMCustomElem) {
            CustomElement customElement = new CustomElement();
            V2TIMCustomElem v2TIMCustomElem = (V2TIMCustomElem) v2TIMElem;
            customElement.setData(v2TIMCustomElem.getData());
            customElement.setDescription(v2TIMCustomElem.getDescription());
            customElement.setExtension(v2TIMCustomElem.getExtension());
            this.message.addElement(customElement);
        } else if (v2TIMElem instanceof V2TIMFaceElem) {
            FaceElement faceElement = new FaceElement();
            V2TIMFaceElem v2TIMFaceElem = (V2TIMFaceElem) v2TIMElem;
            faceElement.setFaceIndex(v2TIMFaceElem.getIndex());
            faceElement.setFaceData(v2TIMFaceElem.getData());
            this.message.addElement(faceElement);
        } else if (v2TIMElem instanceof V2TIMLocationElem) {
            LocationElement locationElement = new LocationElement();
            V2TIMLocationElem v2TIMLocationElem = (V2TIMLocationElem) v2TIMElem;
            locationElement.setLatitude(v2TIMLocationElem.getLatitude());
            locationElement.setLongitude(v2TIMLocationElem.getLongitude());
            locationElement.setDescription(v2TIMLocationElem.getDesc());
            this.message.addElement(locationElement);
        } else {
            IMLog.e("V2TIMElem", "appendElem error, not support this elem type");
            return;
        }
        v2TIMElem.setMessage(this.message);
        v2TIMElem.setElemIndex(this.message.getMessageBaseElements().size() - 1);
    }

    public MessageBaseElement getElement() {
        Message message = this.message;
        if (message == null) {
            return null;
        }
        List<MessageBaseElement> messageBaseElements = message.getMessageBaseElements();
        if (this.elemIndex >= 0) {
            int size = messageBaseElements.size();
            int i2 = this.elemIndex;
            if (size > i2) {
                return messageBaseElements.get(i2);
            }
        }
        return null;
    }

    public Message getMessage() {
        return this.message;
    }

    public V2TIMElem getNextElem() {
        Message message = this.message;
        if (message == null) {
            return null;
        }
        List<MessageBaseElement> messageBaseElements = message.getMessageBaseElements();
        int i2 = this.elemIndex + 1;
        if (i2 >= messageBaseElements.size()) {
            return null;
        }
        V2TIMElem v2TIMElem = new V2TIMElem();
        MessageBaseElement messageBaseElement = messageBaseElements.get(i2);
        if (messageBaseElement instanceof TextElement) {
            v2TIMElem = new V2TIMTextElem();
        } else if (messageBaseElement instanceof ImageElement) {
            v2TIMElem = new V2TIMImageElem();
        } else if (messageBaseElement instanceof VideoElement) {
            v2TIMElem = new V2TIMVideoElem();
        } else if (messageBaseElement instanceof SoundElement) {
            v2TIMElem = new V2TIMSoundElem();
        } else if (messageBaseElement instanceof FaceElement) {
            v2TIMElem = new V2TIMFaceElem();
        } else if (messageBaseElement instanceof FileElement) {
            v2TIMElem = new V2TIMFileElem();
        } else if (messageBaseElement instanceof CustomElement) {
            v2TIMElem = new V2TIMCustomElem();
        } else if (messageBaseElement instanceof LocationElement) {
            v2TIMElem = new V2TIMLocationElem();
        } else if (messageBaseElement instanceof MergerElement) {
            v2TIMElem = new V2TIMMergerElem();
        } else if (messageBaseElement instanceof GroupTipsElement) {
            v2TIMElem = new V2TIMGroupTipsElem();
        }
        v2TIMElem.setMessage(this.message);
        v2TIMElem.setElemIndex(i2);
        return v2TIMElem;
    }

    public void setElemIndex(int i2) {
        this.elemIndex = i2;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
