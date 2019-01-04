package cn.itcast.utils;

import java.util.List;

public class PageBean {
    //当前页数
    private Integer currentPage;
    //总页数
    private Integer totalCount;
    //每页显示条数
    private Integer pageSize;
    //总页数
    private Integer totalPage;
    //分页列表数据
    private List list;

    public PageBean(Integer currentPage, Integer totalCount, Integer pageSize) {
        this.totalCount = totalCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        if (this.currentPage == null) {
            //如果页面没有显示哪一页，显示第一夜
            this.currentPage = 1;
        }
        if (this.pageSize == null) {
            this.pageSize = 3;
        }

        //计算总页数
        this.totalPage = this.totalCount/this.pageSize;
    }


}
