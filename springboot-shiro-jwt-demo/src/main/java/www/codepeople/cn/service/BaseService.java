package www.codepeople.cn.service;

import www.codepeople.cn.dao.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${fzq} on 2018/12/21.
 */
public interface BaseService<T extends BaseEntity>{

    int insert(T var1);

    T findById(Serializable id);

    List<T> findAll();
 }
