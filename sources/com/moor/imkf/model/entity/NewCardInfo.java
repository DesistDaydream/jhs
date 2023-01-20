package com.moor.imkf.model.entity;

import com.qiniu.android.common.Constants;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class NewCardInfo implements Serializable {
    private NewCardInfoAttrs attr_one;
    private NewCardInfoAttrs attr_two;
    private String img;
    private String other_title_one;
    private String other_title_three;
    private String other_title_two;
    private String price;
    private String showCardInfoMsg;
    private String sub_title;
    private List<NewCardInfoTags> tags;
    private String target;
    private String target_url;
    private String title;

    /* loaded from: classes2.dex */
    public static final class Builder {
        private NewCardInfoAttrs attr_one;
        private NewCardInfoAttrs attr_two;
        private String other_title_one;
        private String other_title_three;
        private String other_title_two;
        private String price;
        private List<NewCardInfoTags> tags;
        private String target;
        private String showCardInfoMsg = "1";
        private String title = "主标题";
        private String sub_title = "副标题";
        private String img = "https://www.tianxiadengcang.com//index.php?m=Api&c=Goods&a=goodsThumImages&width=200&height=200&goods_id=168";

        public Builder() {
            NewCardInfoAttrs newCardInfoAttrs = new NewCardInfoAttrs();
            newCardInfoAttrs.setColor("#000000").setContent("X1");
            NewCardInfoAttrs newCardInfoAttrs2 = new NewCardInfoAttrs();
            newCardInfoAttrs2.setColor("#000000").setContent("已发货");
            this.attr_one = newCardInfoAttrs;
            this.attr_two = newCardInfoAttrs2;
            this.price = "￥200";
            this.other_title_one = "附加信息1";
            this.other_title_two = "附加信息2";
            this.other_title_three = "附加信息3";
            this.target = "http://www.baidu.com";
            NewCardInfoTags newCardInfoTags = new NewCardInfoTags();
            newCardInfoTags.setLabel("按钮名称1").setUrl("https://www.7moor.com").setFocusIframe("iframe名称1");
            NewCardInfoTags newCardInfoTags2 = new NewCardInfoTags();
            newCardInfoTags2.setLabel("按钮名称2").setUrl("").setFocusIframe("iframe名称2");
            ArrayList arrayList = new ArrayList();
            this.tags = arrayList;
            arrayList.add(newCardInfoTags);
            this.tags.add(newCardInfoTags2);
        }

        public NewCardInfo build() {
            return new NewCardInfo(this);
        }

        public Builder setAttr_one(NewCardInfoAttrs newCardInfoAttrs) {
            this.attr_one = newCardInfoAttrs;
            return this;
        }

        public Builder setAttr_two(NewCardInfoAttrs newCardInfoAttrs) {
            this.attr_two = newCardInfoAttrs;
            return this;
        }

        public Builder setImg(String str) {
            this.img = str;
            return this;
        }

        public Builder setOther_title_one(String str) {
            this.other_title_one = str;
            return this;
        }

        public Builder setOther_title_three(String str) {
            this.other_title_three = str;
            return this;
        }

        public Builder setOther_title_two(String str) {
            this.other_title_two = str;
            return this;
        }

        public Builder setPrice(String str) {
            this.price = str;
            return this;
        }

        public Builder setShowCardInfoMsg(String str) {
            this.showCardInfoMsg = str;
            return this;
        }

        public Builder setSub_title(String str) {
            this.sub_title = str;
            return this;
        }

        public Builder setTags(List<NewCardInfoTags> list) {
            this.tags = list;
            return this;
        }

        public Builder setTarget(String str) {
            this.target = str;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }
    }

    private String decode(String str) {
        if (str != null) {
            try {
                if (!"".equals(str)) {
                    return URLDecoder.decode(str, Constants.UTF_8);
                }
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return "";
    }

    public NewCardInfoAttrs getAttr_one() {
        return this.attr_one;
    }

    public NewCardInfoAttrs getAttr_two() {
        return this.attr_two;
    }

    public String getImg() {
        return decode(this.img);
    }

    public String getOther_title_one() {
        return decode(this.other_title_one);
    }

    public String getOther_title_three() {
        return decode(this.other_title_three);
    }

    public String getOther_title_two() {
        return decode(this.other_title_two);
    }

    public String getPrice() {
        return decode(this.price);
    }

    public String getShowCardInfoMsg() {
        return decode(this.showCardInfoMsg);
    }

    public String getSub_title() {
        return decode(this.sub_title);
    }

    public List<NewCardInfoTags> getTags() {
        return this.tags;
    }

    public String getTarget() {
        return decode(this.target);
    }

    public String getTarget_url() {
        return decode(this.target_url);
    }

    public String getTitle() {
        return decode(this.title);
    }

    public NewCardInfo setTarget_url(String str) {
        this.target_url = str;
        return this;
    }

    private NewCardInfo() {
    }

    private NewCardInfo(Builder builder) {
        this.showCardInfoMsg = builder.showCardInfoMsg;
        this.title = builder.title;
        this.sub_title = builder.sub_title;
        this.img = builder.img;
        this.attr_one = builder.attr_one;
        this.attr_two = builder.attr_two;
        this.price = builder.price;
        this.other_title_one = builder.other_title_one;
        this.other_title_two = builder.other_title_two;
        this.other_title_three = builder.other_title_three;
        this.target = builder.target;
        this.tags = builder.tags;
    }
}
