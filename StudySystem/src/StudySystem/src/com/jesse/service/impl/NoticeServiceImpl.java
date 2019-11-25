package com.seehope.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import com.seehope.dao.INoticeDao;
import com.seehope.dao.ITypeDao;
import com.seehope.dao.IUserDao;
import com.seehope.dao.impl.NoticeDaoImpl;
import com.seehope.dao.impl.TypeDaoImpl;
import com.seehope.dao.impl.UserDaoImpl;
import com.seehope.po.Notice;
import com.seehope.po.Type;
import com.seehope.po.User;
import com.seehope.po.utils.PageBean;
import com.seehope.service.INoticeService;

public class NoticeServiceImpl implements INoticeService {
    private INoticeDao noticeDao =new NoticeDaoImpl();
    private ITypeDao typeDao =new TypeDaoImpl();
    private IUserDao userDao =new UserDaoImpl();
	/***
	 * 调用dao层查询已经发布了的消息列表
	 */
	public ArrayList<Notice> findPublishNotices(Integer status,Integer pageSize,Integer pageNum) throws SQLException{
		ArrayList<Notice> notices= noticeDao.getNoticesByPublish(status,pageSize,pageNum);
		for(Notice notice:notices){
			 String typename=typeDao.getNameById(notice.getType().getId());
			 notice.getType().setName(typename);
			 String username =userDao.getNameById(notice.getUser().getId());
			 notice.getUser().setName(username);
		}
		return notices;
	}
    /**
     * 根据id查询消息
     */
	@Override
	public Notice getNoticeById(int id) throws SQLException {
		Notice notice= noticeDao.getNoticeById(id);
		String typename=typeDao.getNameById(notice.getType().getId());
		notice.getType().setName(typename);
		return notice;
	}
	@Override
	public int add(Notice notice) throws SQLException {
		return noticeDao.add(notice);
	}
	@Override
	public int deleteNoticeById(Integer nid) throws SQLException {
		return noticeDao.deleteNoticeById(nid);
	}
	@Override
	public int update(Notice notice) throws SQLException {
		return noticeDao.update(notice);
	}
	@Override
	public int publish(String ids) throws SQLException {
		String[] aids=ids.split(",");
		int count=0;
		for(String aid:aids){
			Integer id =Integer.parseInt(aid);
			count=noticeDao.publish(id);
			
		}
		return count;
	}
	@Override
	public Integer getTotalCount() throws SQLException {
		return noticeDao.getTotalCount();
	}
	@Override
	public PageBean<Notice> getNoticesByPage(PageBean<Notice> pageBean)
			throws SQLException {
		 pageBean.setTotalCount(noticeDao.getTotalCount());
		 System.out.println(pageBean.getTotalCount());
		 pageBean.setPageList(noticeDao.getNoticesByPage(pageBean));
		 for(Notice notice:pageBean.getPageList()){
			 Type type =new Type();
			 String typename=typeDao.getNameById(notice.getType().getId());
			 type.setName(typename);
			 notice.setType(type);
			 User user =new User();
			 String username=userDao.getNameById(notice.getUser().getId());
			 user.setName(username);
			 notice.setUser(user);
		 }
		return pageBean;
	}

}
