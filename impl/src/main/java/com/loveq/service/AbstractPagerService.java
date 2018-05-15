package com.loveq.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.loveq.domain.vo.CommonVO;

import java.util.List;

/**
 * @author tommy
 * 分页基类service
 */
public abstract class AbstractPagerService {
    protected <T, D extends CommonVO> PageInfo<T> page(D bean, PageQuery<T, D> query) {
        return PageHelper.startPage(bean.getPageNum(), bean.getPageSize()).doSelectPageInfo(() -> query.doQuery(bean));
    }

    public interface PageQuery<T, D extends CommonVO> {
        List<T> doQuery(D bean);
    }
}
