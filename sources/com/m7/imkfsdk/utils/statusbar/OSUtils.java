package com.m7.imkfsdk.utils.statusbar;

import android.os.Environment;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class OSUtils {
    private static final String KEY_AMIGO_ROM_VERSION = "ro.gn.gnromvernumber";
    private static final String KEY_AMIGO_SYSTEM_UI_SUPPORT = "ro.gn.amigo.systemui.support";
    private static final String KEY_BASE_OS_VERSION = "ro.build.version.base_os";
    private static final String KEY_CLIENT_ID_BASE = "ro.com.google.clientidbase";
    private static final String KEY_COLOROS_ROM_VERSION = "ro.rom.different.version";
    private static final String KEY_COLOROS_THEME_VERSION = "ro.oppo.version";
    private static final String KEY_COLOROS_VERSION = "ro.oppo.theme.version";
    private static final String KEY_DISPLAY_ID = "ro.build.display.id";
    private static final String KEY_EMUI_API_LEVEL = "ro.build.hw_emui_api_level";
    private static final String KEY_EMUI_SYSTEM_VERSION = "ro.confg.hw_systemversion";
    private static final String KEY_EMUI_VERSION = "ro.build.version.emui";
    private static final String KEY_EUI_MODEL = "ro.product.letv_model";
    private static final String KEY_EUI_NAME = "ro.product.letv_name";
    private static final String KEY_EUI_VERSION = "ro.letv.release.version";
    private static final String KEY_EUI_VERSION_DATE = "ro.letv.release.version_date";
    private static final String KEY_FLYME_PUBLISHED = "ro.flyme.published";
    private static final String KEY_FLYME_SETUP = "ro.meizu.setupwizard.flyme";
    private static final String KEY_FUNTOUCHOS_BOARD_VERSION = "ro.vivo.board.version";
    private static final String KEY_FUNTOUCHOS_DISPLAY_ID = "ro.vivo.os.build.display.id";
    private static final String KEY_FUNTOUCHOS_OS_NAME = "ro.vivo.os.name";
    private static final String KEY_FUNTOUCHOS_OS_VERSION = "ro.vivo.os.version";
    private static final String KEY_FUNTOUCHOS_ROM_VERSION = "ro.vivo.rom.version";
    private static final String KEY_LENOVO_ADB = "ro.lenovo.adb";
    private static final String KEY_LENOVO_DEVICE = "ro.lenovo.device";
    private static final String KEY_LENOVO_PLATFORM = "ro.lenovo.platform";
    private static final String KEY_LG_FACTORY_VERSION = "ro.lge.factoryversion";
    private static final String KEY_LG_SW_VERSION = "ro.lge.swversion";
    private static final String KEY_LG_SW_VERSION_SHORT = "ro.lge.swversion_short";
    private static final String KEY_MIUI_VERSION = "ro.build.version.incremental";
    private static final String KEY_MIUI_VERSION_CODE = "ro.miui.ui.version.code";
    private static final String KEY_MIUI_VERSION_NANE = "ro.miui.ui.version.name";
    private static final String KEY_SENSE_BLUETOOTH_SAP = "ro.htc.bluetooth.sap";
    private static final String KEY_SENSE_BUILD_STAGE = "htc.build.stage";
    private static final String KEY_SONY_ENCRYPTED_DATA = "ro.sony.fota.encrypteddata";
    private static final String KEY_SONY_PROTOCOL_TYPE = "ro.sony.irremote.protocol_type";
    private static final String KEY_YULONG_VERSION_RELEASE = "ro.yulong.version.release";
    private static final String KEY_YULONG_VERSION_TAG = "ro.yulong.version.tag";
    private static final ROM ROM_TYPE = initRomType();
    private static final String VALUE_AMIGO_CLIENT_ID_BASE = "android-gionee";
    private static final String VALUE_AMIGO_DISPLAY_ID_CONTAIN = "amigo";
    private static final String VALUE_COLOROS_BASE_OS_VERSION_CONTAIN = "OPPO";
    private static final String VALUE_COLOROS_CLIENT_ID_BASE = "android-oppo";
    private static final String VALUE_FLYME_DISPLAY_ID_CONTAIN = "Flyme";
    private static final String VALUE_FUNTOUCHOS_CLIENT_ID_BASE = "android-vivo";
    private static final String VALUE_LENOVO_CLIENT_ID_BASE = "android-lenovo";
    private static final String VALUE_MIUI_CLIENT_ID_BASE = "android-xiaomi";
    private static final String VALUE_SAMSUNG_BASE_OS_VERSION_CONTAIN = "samsung";
    private static final String VALUE_SAMSUNG_CLIENT_ID_BASE = "android-samsung";
    private static final String VALUE_SENSE_CLIENT_ID_BASE = "android-htc-rev";
    private static final String VALUE_SONY_CLIENT_ID_BASE = "android-sonyericsson";
    private static final String VALUE_YULONG_CLIENT_ID_BASE = "android-coolpad";

    /* loaded from: classes2.dex */
    public enum ROM {
        MIUI,
        Flyme,
        EMUI,
        ColorOS,
        FuntouchOS,
        SmartisanOS,
        EUI,
        Sense,
        AmigoOS,
        _360OS,
        NubiaUI,
        H2OS,
        YunOS,
        YuLong,
        SamSung,
        Sony,
        Lenovo,
        LG,
        Google,
        Other;
        
        private int baseVersion = -1;
        private String version;

        ROM() {
        }

        public int getBaseVersion() {
            return this.baseVersion;
        }

        public String getVersion() {
            return this.version;
        }

        public void setBaseVersion(int i2) {
            this.baseVersion = i2;
        }

        public void setVersion(String str) {
            this.version = str;
        }
    }

    public static ROM getRomType() {
        return ROM_TYPE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:295:0x0437 -> B:319:0x044c). Please submit an issue!!! */
    private static ROM initRomType() {
        Properties properties;
        FileInputStream fileInputStream;
        char c2;
        ROM rom = ROM.Other;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                try {
                    properties = new Properties();
                    fileInputStream = new FileInputStream(new File(Environment.getRootDirectory(), "build.prop"));
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    try {
                        properties.load(fileInputStream);
                        c2 = 1;
                    } catch (IOException e2) {
                        e = e2;
                        fileInputStream2 = fileInputStream;
                        e.printStackTrace();
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        return rom;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e3) {
                            e3.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
        if (!properties.containsKey(KEY_MIUI_VERSION_NANE) && !properties.containsKey(KEY_MIUI_VERSION_CODE)) {
            if (!properties.containsKey(KEY_EMUI_VERSION) && !properties.containsKey(KEY_EMUI_API_LEVEL) && !properties.containsKey(KEY_EMUI_SYSTEM_VERSION)) {
                if (!properties.containsKey(KEY_FLYME_SETUP) && !properties.containsKey(KEY_FLYME_PUBLISHED)) {
                    if (!properties.containsKey(KEY_COLOROS_VERSION) && !properties.containsKey(KEY_COLOROS_THEME_VERSION) && !properties.containsKey(KEY_COLOROS_ROM_VERSION)) {
                        if (!properties.containsKey(KEY_FUNTOUCHOS_OS_NAME) && !properties.containsKey(KEY_FUNTOUCHOS_OS_VERSION) && !properties.containsKey(KEY_FUNTOUCHOS_DISPLAY_ID)) {
                            if (!properties.containsKey(KEY_EUI_VERSION) && !properties.containsKey(KEY_EUI_NAME) && !properties.containsKey(KEY_EUI_MODEL)) {
                                if (!properties.containsKey(KEY_AMIGO_ROM_VERSION) && !properties.containsKey(KEY_AMIGO_SYSTEM_UI_SUPPORT)) {
                                    if (!properties.containsKey(KEY_SONY_PROTOCOL_TYPE) && !properties.containsKey(KEY_SONY_ENCRYPTED_DATA)) {
                                        if (!properties.containsKey(KEY_YULONG_VERSION_RELEASE) && !properties.containsKey(KEY_YULONG_VERSION_TAG)) {
                                            if (!properties.containsKey(KEY_SENSE_BUILD_STAGE) && !properties.containsKey(KEY_SENSE_BLUETOOTH_SAP)) {
                                                if (!properties.containsKey(KEY_LG_SW_VERSION) && !properties.containsKey(KEY_LG_SW_VERSION_SHORT) && !properties.containsKey(KEY_LG_FACTORY_VERSION)) {
                                                    if (!properties.containsKey(KEY_LENOVO_DEVICE) && !properties.containsKey(KEY_LENOVO_PLATFORM) && !properties.containsKey(KEY_LENOVO_ADB)) {
                                                        if (properties.containsKey(KEY_DISPLAY_ID)) {
                                                            String property = properties.getProperty(KEY_DISPLAY_ID);
                                                            if (!TextUtils.isEmpty(property)) {
                                                                if (property.contains(VALUE_FLYME_DISPLAY_ID_CONTAIN)) {
                                                                    ROM rom2 = ROM.Flyme;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e6) {
                                                                        e6.printStackTrace();
                                                                    }
                                                                    return rom2;
                                                                } else if (property.contains(VALUE_AMIGO_DISPLAY_ID_CONTAIN)) {
                                                                    ROM rom3 = ROM.AmigoOS;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e7) {
                                                                        e7.printStackTrace();
                                                                    }
                                                                    return rom3;
                                                                }
                                                            }
                                                        } else if (properties.containsKey(KEY_BASE_OS_VERSION)) {
                                                            String property2 = properties.getProperty(KEY_BASE_OS_VERSION);
                                                            if (!TextUtils.isEmpty(property2)) {
                                                                if (property2.contains(VALUE_COLOROS_BASE_OS_VERSION_CONTAIN)) {
                                                                    ROM rom4 = ROM.ColorOS;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e8) {
                                                                        e8.printStackTrace();
                                                                    }
                                                                    return rom4;
                                                                } else if (property2.contains(VALUE_SAMSUNG_BASE_OS_VERSION_CONTAIN)) {
                                                                    ROM rom5 = ROM.SamSung;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e9) {
                                                                        e9.printStackTrace();
                                                                    }
                                                                    return rom5;
                                                                }
                                                            }
                                                        } else if (properties.containsKey(KEY_CLIENT_ID_BASE)) {
                                                            String property3 = properties.getProperty(KEY_CLIENT_ID_BASE);
                                                            switch (property3.hashCode()) {
                                                                case -1297558593:
                                                                    if (property3.equals(VALUE_AMIGO_CLIENT_ID_BASE)) {
                                                                        c2 = '\b';
                                                                        break;
                                                                    }
                                                                    c2 = 65535;
                                                                    break;
                                                                case -1158135215:
                                                                    if (property3.equals(VALUE_LENOVO_CLIENT_ID_BASE)) {
                                                                        c2 = 7;
                                                                        break;
                                                                    }
                                                                    c2 = 65535;
                                                                    break;
                                                                case -1037975490:
                                                                    if (property3.equals(VALUE_COLOROS_CLIENT_ID_BASE)) {
                                                                        break;
                                                                    }
                                                                    c2 = 65535;
                                                                    break;
                                                                case -1037773494:
                                                                    if (property3.equals(VALUE_FUNTOUCHOS_CLIENT_ID_BASE)) {
                                                                        c2 = 2;
                                                                        break;
                                                                    }
                                                                    c2 = 65535;
                                                                    break;
                                                                case -811278887:
                                                                    if (property3.equals(VALUE_MIUI_CLIENT_ID_BASE)) {
                                                                        c2 = 0;
                                                                        break;
                                                                    }
                                                                    c2 = 65535;
                                                                    break;
                                                                case -652932276:
                                                                    if (property3.equals(VALUE_YULONG_CLIENT_ID_BASE)) {
                                                                        c2 = 5;
                                                                        break;
                                                                    }
                                                                    c2 = 65535;
                                                                    break;
                                                                case -380192433:
                                                                    if (property3.equals(VALUE_SENSE_CLIENT_ID_BASE)) {
                                                                        c2 = 6;
                                                                        break;
                                                                    }
                                                                    c2 = 65535;
                                                                    break;
                                                                case -64814069:
                                                                    if (property3.equals(VALUE_SONY_CLIENT_ID_BASE)) {
                                                                        c2 = 4;
                                                                        break;
                                                                    }
                                                                    c2 = 65535;
                                                                    break;
                                                                case 259783324:
                                                                    if (property3.equals(VALUE_SAMSUNG_CLIENT_ID_BASE)) {
                                                                        c2 = 3;
                                                                        break;
                                                                    }
                                                                    c2 = 65535;
                                                                    break;
                                                                default:
                                                                    c2 = 65535;
                                                                    break;
                                                            }
                                                            switch (c2) {
                                                                case 0:
                                                                    ROM rom6 = ROM.MIUI;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e10) {
                                                                        e10.printStackTrace();
                                                                    }
                                                                    return rom6;
                                                                case 1:
                                                                    ROM rom7 = ROM.ColorOS;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e11) {
                                                                        e11.printStackTrace();
                                                                    }
                                                                    return rom7;
                                                                case 2:
                                                                    ROM rom8 = ROM.FuntouchOS;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e12) {
                                                                        e12.printStackTrace();
                                                                    }
                                                                    return rom8;
                                                                case 3:
                                                                    ROM rom9 = ROM.SamSung;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e13) {
                                                                        e13.printStackTrace();
                                                                    }
                                                                    return rom9;
                                                                case 4:
                                                                    ROM rom10 = ROM.Sony;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e14) {
                                                                        e14.printStackTrace();
                                                                    }
                                                                    return rom10;
                                                                case 5:
                                                                    ROM rom11 = ROM.YuLong;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e15) {
                                                                        e15.printStackTrace();
                                                                    }
                                                                    return rom11;
                                                                case 6:
                                                                    ROM rom12 = ROM.Sense;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e16) {
                                                                        e16.printStackTrace();
                                                                    }
                                                                    return rom12;
                                                                case 7:
                                                                    ROM rom13 = ROM.Lenovo;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e17) {
                                                                        e17.printStackTrace();
                                                                    }
                                                                    return rom13;
                                                                case '\b':
                                                                    ROM rom14 = ROM.AmigoOS;
                                                                    try {
                                                                        fileInputStream.close();
                                                                    } catch (IOException e18) {
                                                                        e18.printStackTrace();
                                                                    }
                                                                    return rom14;
                                                            }
                                                        }
                                                        fileInputStream.close();
                                                        return rom;
                                                    }
                                                    rom = ROM.Lenovo;
                                                    fileInputStream.close();
                                                    return rom;
                                                }
                                                rom = ROM.LG;
                                                fileInputStream.close();
                                                return rom;
                                            }
                                            rom = ROM.Sense;
                                            fileInputStream.close();
                                            return rom;
                                        }
                                        rom = ROM.YuLong;
                                        fileInputStream.close();
                                        return rom;
                                    }
                                    rom = ROM.Sony;
                                    fileInputStream.close();
                                    return rom;
                                }
                                rom = ROM.AmigoOS;
                                if (properties.containsKey(KEY_DISPLAY_ID)) {
                                    String property4 = properties.getProperty(KEY_DISPLAY_ID);
                                    Matcher matcher = Pattern.compile("amigo([\\d.]+)[a-zA-Z]*").matcher(property4);
                                    if (!TextUtils.isEmpty(property4) && matcher.find()) {
                                        try {
                                            String group = matcher.group(1);
                                            rom.setVersion(group);
                                            rom.setBaseVersion(Integer.parseInt(group.split("\\.")[0]));
                                        } catch (Exception e19) {
                                            e19.printStackTrace();
                                        }
                                    }
                                }
                                fileInputStream.close();
                                return rom;
                            }
                            rom = ROM.EUI;
                            if (properties.containsKey(KEY_EUI_VERSION)) {
                                String property5 = properties.getProperty(KEY_EUI_VERSION);
                                Matcher matcher2 = Pattern.compile("([\\d.]+)[^\\d]*").matcher(property5);
                                if (!TextUtils.isEmpty(property5) && matcher2.find()) {
                                    try {
                                        String group2 = matcher2.group(1);
                                        rom.setVersion(group2);
                                        rom.setBaseVersion(Integer.parseInt(group2.split("\\.")[0]));
                                    } catch (Exception e20) {
                                        e20.printStackTrace();
                                    }
                                }
                            }
                            fileInputStream.close();
                            return rom;
                        }
                        rom = ROM.FuntouchOS;
                        if (properties.containsKey(KEY_FUNTOUCHOS_OS_VERSION)) {
                            String property6 = properties.getProperty(KEY_FUNTOUCHOS_OS_VERSION);
                            if (!TextUtils.isEmpty(property6) && property6.matches("[\\d.]+")) {
                                try {
                                    rom.setVersion(property6);
                                    rom.setBaseVersion(Integer.parseInt(property6.split("\\.")[0]));
                                } catch (Exception e21) {
                                    e21.printStackTrace();
                                }
                            }
                        }
                        fileInputStream.close();
                        return rom;
                    }
                    rom = ROM.ColorOS;
                    if (properties.containsKey(KEY_COLOROS_ROM_VERSION)) {
                        String property7 = properties.getProperty(KEY_COLOROS_ROM_VERSION);
                        Matcher matcher3 = Pattern.compile("ColorOS([\\d.]+)").matcher(property7);
                        if (!TextUtils.isEmpty(property7) && matcher3.find()) {
                            try {
                                String group3 = matcher3.group(1);
                                rom.setVersion(group3);
                                rom.setBaseVersion(Integer.parseInt(group3.split("\\.")[0]));
                            } catch (Exception e22) {
                                e22.printStackTrace();
                            }
                        }
                    }
                    fileInputStream.close();
                    return rom;
                }
                rom = ROM.Flyme;
                if (properties.containsKey(KEY_DISPLAY_ID)) {
                    String property8 = properties.getProperty(KEY_DISPLAY_ID);
                    Matcher matcher4 = Pattern.compile("Flyme[^\\d]*([\\d.]+)[^\\d]*").matcher(property8);
                    if (!TextUtils.isEmpty(property8) && matcher4.find()) {
                        try {
                            String group4 = matcher4.group(1);
                            rom.setVersion(group4);
                            rom.setBaseVersion(Integer.parseInt(group4.split("\\.")[0]));
                        } catch (Exception e23) {
                            e23.printStackTrace();
                        }
                    }
                }
                fileInputStream.close();
                return rom;
            }
            rom = ROM.EMUI;
            if (properties.containsKey(KEY_EMUI_VERSION)) {
                String property9 = properties.getProperty(KEY_EMUI_VERSION);
                Matcher matcher5 = Pattern.compile("EmotionUI_([\\d.]+)").matcher(property9);
                if (!TextUtils.isEmpty(property9) && matcher5.find()) {
                    try {
                        String group5 = matcher5.group(1);
                        rom.setVersion(group5);
                        rom.setBaseVersion(Integer.parseInt(group5.split("\\.")[0]));
                    } catch (Exception e24) {
                        e24.printStackTrace();
                    }
                }
            }
            fileInputStream.close();
            return rom;
        }
        rom = ROM.MIUI;
        if (properties.containsKey(KEY_MIUI_VERSION_NANE)) {
            String property10 = properties.getProperty(KEY_MIUI_VERSION_NANE);
            if (!TextUtils.isEmpty(property10) && property10.matches("[Vv]\\d+")) {
                try {
                    rom.setBaseVersion(Integer.parseInt(property10.split("[Vv]")[1]));
                } catch (Exception e25) {
                    e25.printStackTrace();
                }
            }
        }
        if (properties.containsKey(KEY_MIUI_VERSION)) {
            String property11 = properties.getProperty(KEY_MIUI_VERSION);
            if (!TextUtils.isEmpty(property11) && property11.matches("[\\d.]+")) {
                rom.setVersion(property11);
            }
        }
        fileInputStream.close();
        return rom;
    }
}
