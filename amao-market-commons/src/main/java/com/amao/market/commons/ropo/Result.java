package com.amao.market.commons.ropo;

import lombok.Data;

/**
 * 接口调用结果包装类
 * <p>
 * 可继承该类，按业务需求对返回结果进行扩充，针对每个错误编写其对应的函数方法
 *
 * @author LinYuchang
 */
@Data
public class Result<T> {

    /**
     * 错误码
     */
    protected int code;

    /**
     * 错误信息
     */
    protected String message;

    /**
     * 数据载荷
     */
    protected T data;

    /**
     * 接口调用耗时，单位毫秒
     */
    protected Long took;

    public Result() {
    }

    public Result(int code, T data, String message, Long took) {
        this.code = code;
        this.data = data;
        this.message = message;
        this.took = took;
    }

    /**
     * 调用成功
     *
     * @param data 数据
     * @param <T>  泛型
     * @return {@link Result}
     */
    public static <T> Result<T> C200(T data) {
        return Result.C200(data, null);
    }

    /**
     * 调用成功
     *
     * @param data    数据
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C200(T data, String message) {
        return new Result<>(200, data, message, null);
    }

    /**
     * 未获取到登录信息
     *
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C401(String message) {
        return Result.C401(null, message);
    }

    /**
     * 未获取到登录信息
     *
     * @param data    数据
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C401(T data, String message) {
        return new Result<>(401, data, message, null);
    }

    /**
     * 未通过权限校验
     *
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C403(String message) {
        return Result.C403(null, message);
    }

    /**
     * 未通过权限校验
     *
     * @param data    数据
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C403(T data, String message) {
        return new Result<>(403, data, message, null);
    }

    /**
     * 未找到目标资源
     *
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C404(String message) {
        return Result.C404(null, message);
    }

    /**
     * 未找到目标资源
     *
     * @param data    数据
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C404(T data, String message) {
        return new Result<>(404, data, message, null);
    }

    /**
     * 目标资源重复
     *
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C405(String message) {
        return Result.C405(null, message);
    }

    /**
     * 目标资源重复
     *
     * @param data    数据
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C405(T data, String message) {
        return new Result<>(405, data, message, null);
    }

    /**
     * 未通过参数校验
     *
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C408(String message) {
        return Result.C408(null, message);
    }

    /**
     * 未通过参数校验
     *
     * @param data    数据
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C408(T data, String message) {
        return new Result<>(408, data, message, null);
    }

    /**
     * 系统内部错误
     *
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C500(String message) {
        return Result.C500(null, message);
    }

    /**
     * 系统内部错误
     *
     * @param data    数据
     * @param message 错误信息
     * @param <T>     泛型
     * @return Result
     */
    public static <T> Result<T> C500(T data, String message) {
        return new Result<>(500, data, message, null);
    }

}
