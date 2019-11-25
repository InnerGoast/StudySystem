package com.seehope.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.seehope.po.Notice;
import com.seehope.po.utils.PageBean;

public interface INoticeService {
    /***
     * ��ѯ�Ѿ������˵���Ϣ�б�
     * @param status 
     * @param pageNum 
     * @param pageSize 
     * @return
     * @throws SQLException
     */
	public ArrayList<Notice> findPublishNotices(Integer status, Integer pageSize, Integer pageNum) throws SQLException;
    /***
     * �����û������id��ѯ��Ϣ��Ϣ
     * @param id
     * @return
     * @throws SQLException
     */
	public Notice getNoticeById(int id) throws SQLException;
	/**
	 * �����Ϣ��Ϣ
	 * @param notice
	 * @return
	 * @throws SQLException
	 */
	public int add(Notice notice) throws SQLException;
	/**
	 * ����idɾ����Ϣ��δ������
	 * @param nid
	 * @return
	 * @throws SQLException
	 */
	public int deleteNoticeById(Integer nid)throws SQLException;
	/***
	 * �޸�δ��������Ϣ
	 * @param notice
	 * @return
	 * @throws SQLException
	 */
	public int update(Notice notice)throws SQLException;
	/***
	 * ����������Ϣ
	 * @param ids
	 * @return
	 * @throws SQLException
	 */
	public int publish(String ids)throws SQLException;
	/****
	 * ��ѯ������
	 * @return
	 * @throws SQLException
	 */
	public Integer getTotalCount()throws SQLException;
	/***
	 * ��ҳ��ѯ����
	 * @param pageBean
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Notice> getNoticesByPage(PageBean<Notice> pageBean)throws SQLException;

}
