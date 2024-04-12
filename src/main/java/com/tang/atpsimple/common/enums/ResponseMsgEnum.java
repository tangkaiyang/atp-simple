package com.tang.atpsimple.common.enums;

/**
 * 描述：返回码枚举类
 * <p>
 * 500~599 服务异常或所依赖的第三方系统服务异常；如：mysql，Kafka，redis
 * <p>
 * 600~699 内部服务异常
 * <p>
 * 700~899 外部服务异常
 * <p>
 * 900~999998 项目业务异常
 */
public enum ResponseMsgEnum {
    /**
     * 自定义返回码
     */
    CODE_200(200, "成功"),
    CODE_201(201, "用户登录失效，请刷新或重新登录！"),
    CODE_400(400, "校验失败"),
    CODE_402(402, "登录账号异常"),
    CODE_403(403, "越权"),
    CODE_404(404, "资源不存在"),
    CODE_408(408, "系统繁忙，请稍后重试"),
    CODE_430(430, "请求时间非法，请检查服务器时间"),
    CODE_431(431, "请求ID重复"),
    CODE_437(437, "用户不存在"),
    CODE_438(438, "暂无权限"),

    CODE_500(500, "服务异常"),
    CODE_510(510, "文件上传失败"),
    CODE_511(511, "上传或下载的文件过大"),
    CODE_512(512, "指定路径文件不存在"),
    CODE_520(520, "数据库操作失败，请稍后重试"),
    CODE_530(530, "kafka服务异常"),
    CODE_553(553, "文件大小为空，上传失败"),
    CODE_552(552, "下载文件失败"),
    CODE_540(540, "redis服务异常"),
    CODE_550(550, "ES服务异常"),

    CODE_900(900, "平台业务异常，请稍后重试"),


    CODE_999999(999999, "系统未知异常"),

    ;

    /**
     * 返回码
     */
    private int code;
    /**
     * 提示信息
     */
    private String message;

    ResponseMsgEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    /**
     * 根据返回码获取返回对象
     *
     * @param code 返回码
     * @return 返回对象
     */
    public static ResponseMsgEnum getByCode(int code) {
        ResponseMsgEnum[] var2 = values();
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            ResponseMsgEnum responseMsgEnum = var2[var4];
            if (responseMsgEnum.getCode() == code) {
                return responseMsgEnum;
            }
        }
        return null;
    }

    /**
     * 根据返回码获取提示信息
     *
     * @param code 返回码
     * @return 提示信息
     */
    public static String getMessageByCode(int code) {
        for (ResponseMsgEnum type : values()) {
            if (type.code == code) {
                return type.message;
            }
        }
        return null;
    }
}

