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
        this.totalPage = (this.totalCount+this.pageSize-1)/this.pageSize;

        //判断页面不能小于1，也不能大于最大页数
        if (this.currentPage < 1) {
            this.currentPage = 1;
        }
        if (this.currentPage > this.totalPage) {
            this.currentPage = totalPage;
        }
    }

    //计算起始索引
    public int getStart() {
        return (this.currentPage - 1) * this.pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
