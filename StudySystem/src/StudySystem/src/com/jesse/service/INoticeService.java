package com.seehope.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.seehope.po.Notice;
import com.seehope.po.utils.PageBean;

public interface INoticeService {
    /***
     * 查询已经发布了的消息列表
     * @param status 
     * @param pageNum 
     * @param pageSize 
     * @return
     * @throws SQLException
     */
	public ArrayList<Notice> findPublishNotices(Integer status, Integer pageSize, Integer pageNum) throws SQLException;
    /***
     * 根据用户输入的id查询消息信息
     * @param id
     * @return
     * @throws SQLException
     */
	public Notice getNoticeById(int id) throws SQLException;
	/**
	 * 添加消息信息
	 * @param notice
	 * @return
	 * @throws SQLException
	 */
	public int add(Notice notice) throws SQLException;
	/**
	 * 根据id删除消息（未发布）
	 * @param nid
	 * @return
	 * @throws SQLException
	 */
	public int deleteNoticeById(Integer nid)throws SQLException;
	/***
	 * 修改未发布的消息
	 * @param notice
	 * @return
	 * @throws SQLException
	 */
	public int update(Notice notice)throws SQLException;
	/***
	 * 批量发布消息
	 * @param ids
	 * @return
	 * @throws SQLException
	 */
	public int publish(String ids)throws SQLException;
	/****
	 * 查询总条数
	 * @return
	 * @throws SQLException
	 */
	public Integer getTotalCount()throws SQLException;
	/***
	 * 分页查询数据
	 * @param pageBean
	 * @return
	 * @throws SQLException
	 */
	public PageBean<Notice> getNoticesByPage(PageBean<Notice> pageBean)throws SQLException;

}
