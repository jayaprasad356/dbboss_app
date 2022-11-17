package com.example.dpboss.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

public class Constant {
    public static final String MainBaseUrl = "https://dbboss.greymatterworks.in/";
    //public static final String MainBaseUrl = "http://192.168.43.38/abcd/";
    public static final String BaseUrl = MainBaseUrl + "api/";
    public static final String LOGIN_URL = BaseUrl + "login.php";
    public static final String SETTING_URL = BaseUrl + "settings.php";
    public static final String DASHBOARD_INFO = BaseUrl + "dashboard_info.php";




    public static final String ID = "id";
    public static final String PROFILE = "profile";
    public static final String USER_ID = "user_id";
    public static final String MOBILE = "mobile";
    public static final String STUDENT_NAME = "student_name";
    public static final String ID_NUMBER = "id_number";
    public static final String ECITY = "ecity";
    public static final String PIN_CODE = "pin_code";
    public static final String CODES = "codes";
    public static final String IMPORT_DATA = "import_data";
    public static final String ACCOUNT_NUM = "account_num";
    public static final String HOLDER_NAME = "holder_name";
    public static final String BANK = "bank";
    public static final String BRANCH = "branch";
    public static final String IFSC = "ifsc";

    public static final String EMAIL = "email";
    public static final String NAME = "name";
    public static final String BALANCE = "balance";

    public static final String SUCCESS = "success";
    public static final String MESSAGE = "message";
    public static final String DATA = "data";
    public static final String DASHBOARD_LIST = "dashboard_list";
    public static final String BANK_DETAILS = "bank_details";

    public static final String DATE = "date";
    public static final String DOB = "dob";

    public static final String AMOUNT = "amount";
    public static final String ORGANIZER_ID = "organizer_id";
    public static final String CITY = "city";
    public static final String PINCCODE = "pincode";
    public static final String PASSWORD = "password";
    public static final String DEVICE_ID = "device_id";
    public static final String REFERRED_BY = "referred_by";

    public static final String CONTACT = "contact";
    public static final String WHATSAPP = "whatsapp" ;
    public static final String WEB = "web";
    public static final String APP = "app";
}