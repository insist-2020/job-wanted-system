package com.base.job.result;

public class BaseResult<T> {
    private int code;//状态码
    private String msg;
    private T data;

    public static <T> BaseResult<T> success(T data){
        BaseResult<T> result = new BaseResult<>();
        result.code = 0;
        result.msg = "success";
        result.data = data;
        return result;
    }

    public static <T> BaseResult<T> fail(int code,String msg){
        BaseResult<T> result = new BaseResult<>();
        result.code = code;
        result.msg = msg;
        return result;
    }

    //set get 是mvc转换为json时使用的
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
