package com.moor.imkf.model.entity;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class XbotForm implements Serializable {
    public static String Type_DataCity = "city";
    public static String Type_DataFile = "document";
    public static String Type_DataMulitSelect = "multichoice";
    public static String Type_DataMulitText = "multiline";
    public static String Type_DataSingleSelect = "singlechoice";
    public static String Type_DataSingleText = "singleline";
    public static String Type_Datadate = "date";
    public static String Type_HeadNote = "Type_HeadNote";
    public static String Type_Submit = "Type_Submit";
    public String flowid;
    public ArrayList<FormInfoBean> formInfo;
    public String formName;
    public String formNotes;
    public String formPrompt;

    /* loaded from: classes2.dex */
    public static class FormInfoBean implements Serializable {
        public int flag;
        public String name;
        public String remarks;
        public String[] select;
        public String type;
        public String var;
        public String value = "";
        public ArrayList<UploadFileBean> filelist = new ArrayList<>();
    }
}
