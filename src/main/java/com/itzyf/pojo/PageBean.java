package com.itzyf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Author： 1ml
 * @Description： TODO
 * @Date： 2024/4/15 23:49
 * @Version： 1.0
 */

//分页返回结果对象
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    private Long total;//总条数
    private List<T> items;//当前页数据集合
}


