package com.itzyf.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itzyf.mapper.ArticleMapper;
import com.itzyf.pojo.PageBean;
import com.itzyf.service.ArticleService;
import com.itzyf.utils.ThreadLocalUtil;
import jakarta.annotation.Resource;
import com.itzyf.pojo.Article;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Author： 1ml
 * @Description： TODO
 * @Date： 2024/4/15 0:21
 * @Version： 1.0
 */

@Service
public class ArticleServiceImp implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());
        article.setUpdateTime(LocalDateTime.now());

        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        article.setCreateUser(userId);

        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, Integer categoryId, String state) {
        //1.创建PageBean对象
        PageBean<Article> pageBean = new PageBean<>();
        //2.开启分页查询
        PageHelper.startPage(pageNum,pageSize);
        //3.调用mapper
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");
        List<Article> as = articleMapper.list(userId,categoryId,state);
        //Page中提供了方法，可以获取PageHelper分页查询后 得到的总记录条数和当前页数据
        Page<Article> p = (Page<Article>) as;

        pageBean.setTotal(p.getTotal());
        pageBean.setItems(p.getResult());
        return pageBean;
    }

    @Override
    public void update(Article article) {

    }

    @Override
    public void delete(Integer id) {
        articleMapper.delete(id);
    }
}
