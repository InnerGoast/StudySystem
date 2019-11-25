package com.seehope.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seehope.po.Notice;
import com.seehope.po.utils.PageBean;

public interface INoticeDao {
    /***
     * ��ѯ�Ѿ���������Ϣ�б�
     * @param status 
     * @param pageNum 
     * @param pageSize 
     * @return
     * @throws SQLException
     */
	public ArrayList<Notice> getNoticesByPublish(Integer status, Integer pageSize, Integer pageNum) throws SQLException;
    /***
     * ����id��ѯ��Ϣ
     * @param id
     * @return
     */
	public Notice getNoticeById(int id) throws SQLException;
	/***
	 * �����Ϣ��Ϣ
	 * @param notice
	 * @return
	 * @throws SQLException
	 */
	public int add(Notice notice)throws SQLException; 
	/***
	 * ����idɾ��δ��������Ϣ
	 * @param nid
	 * @return
	 * @throws SQLException
	 */
	public int deleteNoticeById(Integer nid)throws SQLException;
	/**
	 * ����id�޸�δ��������Ϣ
	 * @param notice
	 * @return
	 * @throws SQLException
	 */
	public int update(Notice notice)throws SQLException;
	/**
	 * ������Ϣ����id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int publish(Integer id)throws SQLException;
	/***
	 * ��ѯ������
	 * @return
	 * @throws SQLException
	 */
	public Integer getTotalCount()throws SQLException;
	/***
	 * ��ҳ��ѯ��Ϣ�б�
	 * @param pageBean
	 * @return
	 * @throws SQLException
	 */
	public List<Notice> getNoticesByPage(PageBean<Notice> pageBean)throws SQLException;

}
