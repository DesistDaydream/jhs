package com.tencent.imsdk.group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class GroupSearchParam implements Serializable {
    private List<String> keywordList;
    private List<Integer> searchFieldList = new ArrayList();

    public void addSearchField(int i2) {
        this.searchFieldList.add(Integer.valueOf(i2));
    }

    public List<String> getKeywordList() {
        return this.keywordList;
    }

    public List<Integer> getSearchFieldList() {
        return this.searchFieldList;
    }

    public void removeSearchField(int i2) {
        this.searchFieldList.remove(Integer.valueOf(i2));
    }

    public void setKeywordList(List<String> list) {
        this.keywordList = list;
    }

    public void setSearchFieldList(List<Integer> list) {
        this.searchFieldList = list;
    }
}
