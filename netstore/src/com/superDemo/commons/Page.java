package com.superDemo.commons;

import java.util.List;

public class Page {
    private List records;
    private int pageSize = 3;
    private int currentPageNum;
    private int totalPage;
    private int prePageNum;
    private int nextPageNum;

    private int startIndex;
    private int totalRecords;

    private String url;

    public Page(int currentPageNum, int totalRecords){
        this.currentPageNum = currentPageNum;
        this.totalRecords = totalRecords;

        totalPage = totalRecords%pageSize==0?totalRecords/pageSize:totalRecords/pageSize+1;

        startIndex = (currentPageNum-1)*pageSize;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPrePageNum() {
        prePageNum = currentPageNum-1>0?currentPageNum-1:1;
        return prePageNum;
    }

    public void setPrePageNum(int prePageNum) {
        this.prePageNum = prePageNum;
    }

    public int getNextPageNum() {
        nextPageNum = currentPageNum+1>totalPage?totalPage:currentPageNum+1;
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
