package com.seehope.po.utils;

import java.util.List;

public class PageBean<T>{
       //��������
	   //��ǰҳ
	   private int thisPage;
	   //ÿҳ��ʾ��
	   private int pageNum;
	   //������
	   private int totalCount;
	   //��ҳ��
	   private int totalPage;
	   //��ҳ�û�����
	   private List<T> pageList;
	 //���ص�ǰҳ
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
	//������ҳ��
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