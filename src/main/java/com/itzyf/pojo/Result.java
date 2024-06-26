package com.itzyf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author： 1ml
 * @Description： TODO
 * @Date： 2024/4/8 21:54
 * @Version： 1.0
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Result<T> {
    private Integer code; //业务状态吗 0-成功 1-失败
    private String message; //提示信息
    private T data; //响应数据

    public static <E> Result<E> success(E data) {
        return new Result<>(0, "操作成功", data);
    }

    public static Result success() {
        return new Result(0, "操作成功", null);
    }

    public static Result error(String message) {
        return new Result(1, message, null);
    }
}
