package com.seehope.po.utils;

import java.util.List;

public class PageBean<T>{
       //定义属性
	   //当前页
	   private int thisPage;
	   //每页显示数
	   private int pageNum;
	   //总条数
	   private int totalCount;
	   //总页数
	   private int totalPage;
	   //分页用户集合
	   private List<T> pageList;
	 //返回当前页
	public int getThisPage() {
		if(thisPage<1){
			thisPage=1;
		}
		if(thisPage>getTotalCount()){
			thisPage=totalPage;
		}
		return thisPage;
	}
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	//返回总页数
	public int getTotalPage() {
		totalPage=totalCount%pageNum>0?(totalCount/pageNum)+1:(totalCount/pageNum);
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageList() {
		return pageList;
	}
	public void setPageList(List<T> pageList) {
		this.pageList = pageList;
	}
	
	   
}