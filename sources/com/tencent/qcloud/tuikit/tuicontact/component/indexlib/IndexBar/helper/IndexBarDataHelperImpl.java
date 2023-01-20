package com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.helper;

import android.text.TextUtils;
import com.tencent.android.tpns.mqtt.MqttTopic;
import com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.bean.BaseIndexPinyinBean;
import e.i.b.a.c;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes3.dex */
public class IndexBarDataHelperImpl implements IIndexBarDataHelper {
    @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.helper.IIndexBarDataHelper
    public IIndexBarDataHelper convert(List<? extends BaseIndexPinyinBean> list) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                BaseIndexPinyinBean baseIndexPinyinBean = list.get(i2);
                StringBuilder sb = new StringBuilder();
                if (baseIndexPinyinBean.isNeedToPinyin()) {
                    String target = baseIndexPinyinBean.getTarget();
                    for (int i3 = 0; i3 < target.length(); i3++) {
                        sb.append(c.g(target.charAt(i3)).toUpperCase());
                    }
                    baseIndexPinyinBean.setBaseIndexPinyin(sb.toString());
                }
            }
        }
        return this;
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.helper.IIndexBarDataHelper
    public IIndexBarDataHelper fillInexTag(List<? extends BaseIndexPinyinBean> list) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                BaseIndexPinyinBean baseIndexPinyinBean = list.get(i2);
                if (baseIndexPinyinBean.isNeedToPinyin()) {
                    if (TextUtils.isEmpty(baseIndexPinyinBean.getBaseIndexPinyin())) {
                        baseIndexPinyinBean.setBaseIndexTag(MqttTopic.MULTI_LEVEL_WILDCARD);
                    } else {
                        String substring = baseIndexPinyinBean.getBaseIndexPinyin().substring(0, 1);
                        if (substring.matches("[A-Z]")) {
                            baseIndexPinyinBean.setBaseIndexTag(substring);
                        } else {
                            baseIndexPinyinBean.setBaseIndexTag(MqttTopic.MULTI_LEVEL_WILDCARD);
                        }
                    }
                }
            }
        }
        return this;
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.helper.IIndexBarDataHelper
    public IIndexBarDataHelper getSortedIndexDatas(List<? extends BaseIndexPinyinBean> list, List<String> list2) {
        if (list != null && !list.isEmpty()) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                String baseIndexTag = list.get(i2).getBaseIndexTag();
                if (!list2.contains(baseIndexTag)) {
                    list2.add(baseIndexTag);
                }
            }
        }
        return this;
    }

    @Override // com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.helper.IIndexBarDataHelper
    public IIndexBarDataHelper sortSourceDatas(List<? extends BaseIndexPinyinBean> list) {
        if (list != null && !list.isEmpty()) {
            convert(list);
            fillInexTag(list);
            Collections.sort(list, new Comparator<BaseIndexPinyinBean>() { // from class: com.tencent.qcloud.tuikit.tuicontact.component.indexlib.IndexBar.helper.IndexBarDataHelperImpl.1
                @Override // java.util.Comparator
                public int compare(BaseIndexPinyinBean baseIndexPinyinBean, BaseIndexPinyinBean baseIndexPinyinBean2) {
                    if (baseIndexPinyinBean.isNeedToPinyin() && baseIndexPinyinBean2.isNeedToPinyin()) {
                        if (!baseIndexPinyinBean.getBaseIndexTag().equals(MqttTopic.MULTI_LEVEL_WILDCARD) || baseIndexPinyinBean2.getBaseIndexTag().equals(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                            if (baseIndexPinyinBean.getBaseIndexTag().equals(MqttTopic.MULTI_LEVEL_WILDCARD) || !baseIndexPinyinBean2.getBaseIndexTag().equals(MqttTopic.MULTI_LEVEL_WILDCARD)) {
                                return baseIndexPinyinBean.getBaseIndexPinyin().compareTo(baseIndexPinyinBean2.getBaseIndexPinyin());
                            }
                            return -1;
                        }
                        return 1;
                    }
                    return 0;
                }
            });
        }
        return this;
    }
}
