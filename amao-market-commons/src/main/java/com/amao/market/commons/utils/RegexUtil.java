package com.amao.market.commons.utils;

import java.util.regex.Pattern;

/**
 * 正则表达式判断工具类
 *
 * @author LinYuchang
 */
public class RegexUtil {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^1[35]\\d{9}|18[689]\\d{8}$");
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$");
    private static final String ID_CARD_PATTERN = "(^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$)";

    /**
     * 判断字符串是否为合法的手机号码
     *
     * @param phone 手机号码
     * @return true 如果是合法的手机号码，否则返回 false
     */
    public static boolean isValidPhone(String phone) {
        return phone != null && PHONE_PATTERN.matcher(phone).matches();
    }

    /**
     * 判断字符串是否为合法的邮箱地址
     *
     * @param email 邮箱地址
     * @return true 如果是合法的邮箱地址，否则返回 false
     */
    public static boolean isValidEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }


    /**
     * 判断字符串是否为合法的身份证号码
     *
     * @param idCard 身份证号码
     * @return true 如果是合法的身份证号码，否饿返回 false
     */
    public static boolean isValidIdCard(String idCard) {
        return idCard != null && Pattern.matches(ID_CARD_PATTERN, idCard);
    }

}
