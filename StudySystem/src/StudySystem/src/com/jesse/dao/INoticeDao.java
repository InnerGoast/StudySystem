package com.seehope.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seehope.po.Notice;
import com.seehope.po.utils.PageBean;

public interface INoticeDao {
    /***
     * 查询已经发布的消息列表
     * @param status 
     * @param pageNum 
     * @param pageSize 
     * @return
     * @throws SQLException
     */
	public ArrayList<Notice> getNoticesByPublish(Integer status, Integer pageSize, Integer pageNum) throws SQLException;
    /***
     * 根据id查询消息
     * @param id
     * @return
     */
	public Notice getNoticeById(int id) throws SQLException;
	/***
	 * 添加消息信息
	 * @param notice
	 * @return
	 * @throws SQLException
	 */
	public int add(Notice notice)throws SQLException; 
	/***
	 * 根据id删除未发布的消息
	 * @param nid
	 * @return
	 * @throws SQLException
	 */
	public int deleteNoticeById(Integer nid)throws SQLException;
	/**
	 * 根据id修改未发布的消息
	 * @param notice
	 * @return
	 * @throws SQLException
	 */
	public int update(Notice notice)throws SQLException;
	/**
	 * 发布消息根据id
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public int publish(Integer id)throws SQLException;
	/***
	 * 查询总条数
	 * @return
	 * @throws SQLException
	 */
	public Integer getTotalCount()throws SQLException;
	/***
	 * 分页查询消息列表
	 * @param pageBean
	 * @return
	 * @throws SQLException
	 */
	public List<Notice> getNoticesByPage(PageBean<Notice> pageBean)throws SQLException;

}
