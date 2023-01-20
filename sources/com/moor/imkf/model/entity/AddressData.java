package com.moor.imkf.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AddressData implements Serializable, WebChatInterface {
    public List<AddressData> children = new ArrayList();
    public String label;
    public String value;

    @Override // com.moor.imkf.model.entity.WebChatInterface
    public String getCityId() {
        return this.value;
    }

    @Override // com.moor.imkf.model.entity.WebChatInterface
    public String getCityName() {
        return this.label;
    }

    @Override // com.moor.imkf.model.entity.WebChatInterface
    public List<AddressData> getOption() {
        return this.children;
    }
}
