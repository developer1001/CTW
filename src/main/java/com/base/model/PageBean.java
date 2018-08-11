package com.base.model;

/**
 * 分页。一般只需要传入expectPage参数即可，可根据需要传入perPage参数。
 */
public class PageBean {
    private long total;//总数
    private int perPage = 10;//每页加载数量，默认为10
    private int currentPage = 1;//当前页,默认第一页
    private int lastPage = (currentPage > 1 ? currentPage - 1 : 1);//上一页
    private int nextPage = currentPage + 1;//下一页
    private int expectPage = 1;//期待查询第几页

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPerPage() {
        return perPage;
    }

    public void setPerPage(int perPage) {
        this.perPage = perPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getExpectPage() {
        return expectPage;
    }

    public void setExpectPage(int expectPage) {
        this.expectPage = expectPage;
    }
}
