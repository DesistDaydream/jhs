package com.tencent.imsdk.relationship;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class FriendSearchParam implements Serializable {
    public static final int FIELD_ID_NICK_NAME = 2;
    public static final int FIELD_ID_REMARK = 4;
    public static final int FIELD_ID_USER_ID = 1;
    private List<String> keywordList;
    private List<Integer> searchFieldList = new ArrayList();

    public void addSearchField(int i2) {
        this.searchFieldList.add(Integer.valueOf(i2));
    }

    public List<String> getKeywordList() {
        return this.keywordList;
    }

    public void removeSearchField(int i2) {
        this.searchFieldList.remove(Integer.valueOf(i2));
    }

    public void setKeywordList(List<String> list) {
        this.keywordList = list;
    }
}
