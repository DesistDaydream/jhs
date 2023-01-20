package com.tencent.imsdk.group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupMemberSearchParam implements Serializable {
    private List<String> groupIDList;
    private List<String> keywordList;
    private List<Integer> searchFieldList = new ArrayList();

    public void addSearchField(int i2) {
        this.searchFieldList.add(Integer.valueOf(i2));
    }

    public List<String> getGroupIDList() {
        return this.groupIDList;
    }

    public List<String> getKeywordList() {
        return this.keywordList;
    }

    public void removeSearchField(int i2) {
        this.searchFieldList.remove(Integer.valueOf(i2));
    }

    public void setGroupIDList(List<String> list) {
        this.groupIDList = list;
    }

    public void setKeywordList(List<String> list) {
        this.keywordList = list;
    }
}
