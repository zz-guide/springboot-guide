package org.zz.demo1.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.zz.demo1.utils.TimeUtil;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseResult<T> {
    private Integer code;
    private Boolean status;
    private String message;
    private String time;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

    public void setDefaultTime(){
        this.time = TimeUtil.nowStr();
    }

    private static <T> ResponseResult<T> response(Integer code, Boolean status, String message, T data) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setStatus(status);
        responseResult.setMessage(message);
        responseResult.setData(data);
        responseResult.setDefaultTime();
        return responseResult;
    }

    private static <T> ResponseResult<T> response(Integer code, Boolean status, String message) {
        ResponseResult<T> responseResult = new ResponseResult<>();
        responseResult.setCode(code);
        responseResult.setStatus(status);
        responseResult.setMessage(message);
        responseResult.setDefaultTime();
        return responseResult;
    }

    public static <T> ResponseResult<T> success() {
        return response(HttpStatusEnum.SUCCESS.getCode(), true, HttpStatusEnum.SUCCESS.getMessage(), null);
    }

    public static <T> ResponseResult<T> success(HttpStatusEnum httpResponseEnum) {
        return response(httpResponseEnum.getCode(), true, httpResponseEnum.getMessage());
    }

    public static <T> ResponseResult<T> success(Integer code, String message) {
        return response(code, true, message);
    }

    public static <T> ResponseResult<T> success(String message, T data) {
        return response(HttpStatusEnum.SUCCESS.getCode(), true, message, data);
    }

    public static <T> ResponseResult<T> success(Integer code, String message, T data) {
        return response(code, true, message, data);
    }

    public static <T> ResponseResult<T> success(T data) {
        return response(HttpStatusEnum.SUCCESS.getCode(), true, HttpStatusEnum.SUCCESS.getMessage(), data);
    }

    public static <T> ResponseResult<T> success(String message) {
        return response(HttpStatusEnum.SUCCESS.getCode(), true, message, null);
    }

    public static <T> ResponseResult<T> fail() {
        return response(HttpStatusEnum.ERROR.getCode(), false, HttpStatusEnum.ERROR.getMessage(), null);
    }

    public static <T> ResponseResult<T> fail(HttpStatusEnum httpResponseEnum) {
        return response(httpResponseEnum.getCode(), false, httpResponseEnum.getMessage());
    }

    public static <T> ResponseResult<T> fail(Integer code, String message) {
        return response(code, false, message);
    }

    public static <T> ResponseResult<T> fail(String message, T data) {
        return response(HttpStatusEnum.ERROR.getCode(), false, message, data);
    }

    public static <T> ResponseResult<T> fail(Integer code, String message, T data) {
        return response(code, false, message, data);
    }

    public static <T> ResponseResult<T> fail(T data) {
        return response(HttpStatusEnum.ERROR.getCode(), false, HttpStatusEnum.ERROR.getMessage(), data);
    }

    public static <T> ResponseResult<T> fail(String message) {
        return response(HttpStatusEnum.ERROR.getCode(), false, message, null);
    }
}