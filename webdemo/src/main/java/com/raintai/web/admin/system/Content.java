package com.raintai.web.admin.system;

import java.util.HashMap;
import java.util.Map;

public class Content {

    //活动类型
    public static final String KAOJI = "kaoji";
    public static final String KAOJI_NAME = "考级";
    public static final String LAXIN = "laxin";
    public static final String LAXIN_NAME = "老拉新";

    public static Map<String, String> ACTIVITY_TYPE = new HashMap<String, String>();
    static {
        ACTIVITY_TYPE.put(KAOJI,KAOJI_NAME);
        ACTIVITY_TYPE.put(LAXIN,LAXIN_NAME);
        ACTIVITY_TYPE.put("null","－");
    }

    //来源
    public static final String H5 = "H5";
    public static final String H5_NAME = "H5";
    public static final String DUANXIN = "duanxin";
    public static final String DUANXIN_NAME = "短信";
    public static final String INNER = "inner";
    public static final String INNER_NAME = "内侧";
    public static final String WX_WZ = "wx_wz";
    public static final String WX_WZ_NAME = "微信文章";
    public static final String DX = "dx";
    public static final String DX_NAME = "短信";
    public static final String WX_CHAT = "wx_chat";
    public static final String WX_CHAT_NAME = "微信";
    public static final String WXWZ = "wxwz";
    public static final String WXWZ_NAME = "微信文章";
    public static final String WX_CHAT_MENU = "wx_chat_menu";
    public static final String WX_CHAT_MENU_NAME = "微信菜单";

    public static Map<String, String> FROMSOURCE = new HashMap<String, String>();
    static {
        FROMSOURCE.put(H5,H5_NAME);
        FROMSOURCE.put(DUANXIN,DUANXIN_NAME);
        FROMSOURCE.put(INNER,INNER_NAME);
        FROMSOURCE.put(WX_WZ,WX_WZ_NAME);
        FROMSOURCE.put(DX,DX_NAME);
        FROMSOURCE.put(WX_CHAT,WX_CHAT_NAME);
        FROMSOURCE.put(WXWZ,WXWZ_NAME);
        FROMSOURCE.put(WX_CHAT_MENU,WX_CHAT_MENU_NAME);
        FROMSOURCE.put("null","－");
    }

}
