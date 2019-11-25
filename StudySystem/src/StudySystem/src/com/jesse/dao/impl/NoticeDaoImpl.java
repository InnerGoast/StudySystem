package com.seehope.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.seehope.dao.INoticeDao;
import com.seehope.dao.impl.utils.DBUtils;
import com.seehope.po.Notice;
import com.seehope.po.Type;
import com.seehope.po.User;
import com.seehope.po.utils.PageBean;

public class NoticeDaoImpl implements INoticeDao {
    /**
     * @throws SQLException *
     * 
     */
	@Override
	public ArrayList<Notice> getNoticesByPublish(Integer status,Integer pageSize,Integer pageNum) throws SQLException {
		ArrayList<Notice> notices =new ArrayList<Notice>();
		//ªÒ»°Connection 
		Connection con=DBUtils.getConnection();
		String sql ="";
		if(status!=null){
			sql="select * from city_info_notice where publish_status="+status;
			if(pageSize!=null && pageNum!=null){
				sql="select * from city_info_notice where publish_status="+status+" limit ?,?";
			}
		}else{
			sql="select * from city_info_notice";
			if(pageSize!=null && pageNum!=null){
				sql="select * from city_info_notice limit ?,?";
			}
		}
		
		PreparedStatement pst =con.prepareStatement(sql);
		if(pageSize!=null && pageNum!=null){
			pst.setInt(1, (pageSize-1)*pageNum);
			pst.setInt(2, pageNum);
		}
		ResultSet rs =pst.executeQuery();
		while(rs.next()){
			Notice notice =new Notice();
			notice.setId(rs.getInt("id"));
			notice.setTitle(rs.getString("title"));
			notice.setContent(rs.getString("content"));
			notice.setCreateDate(rs.getDate("create_date"));
			notice.setPublishDate(rs.getDate("publish_date"));
			notice.setPublishStatus(rs.getInt("publish_status"));
			User user =new User();
			user.setId(rs.getInt("user_id"));
			notice.setUser(user);
			Type type =new Type();
			type.setId(rs.getInt("type_id"));
			notice.setType(type);
			notices.add(notice);
		}
		DBUtils.close(con, pst, rs);
		return notices;
	}

	@Override
	public Notice getNoticeById(int id) throws SQLException {
	    Connection con=DBUtils.getConnection();
	    PreparedStatement pst=con.prepareStatement("select * from city_info_notice where id=?");
	    pst.setInt(1, id);
	    Notice notice =null;
	    ResultSet rs =pst.executeQuery();
	    while(rs.next()){
	    	notice=new Notice();
	    	notice.setId(rs.getInt("id"));
	    	notice.setTitle(rs.getString("title"));
	    	notice.setContent(rs.getString("content"));
			notice.setCreateDate(rs.getDate("create_date"));
			notice.setPublishDate(rs.getDate("publish_date"));
			notice.setPublishStatus(rs.getInt("publish_status"));
			Type type =new Type();
			type.setId(rs.getInt("type_id"));
			notice.setType(type);
	    }
	    DBUtils.close(con, pst, rs);
		return notice;
	}

	@Override
	public int add(Notice notice) throws SQLException {
		int count=0;
		  Connection con=DBUtils.getConnection();
		  PreparedStatement pst=con.prepareStatement("insert into city_info_notice(title,content,create_date,publish_status,type_id,user_id) values(?,?,?,?,?,?)");
		  pst.setString(1, notice.getTitle());
		  pst.setString(2, notice.getContent());
		  Date date =new Date(notice.getCreateDate().getTime());
		  pst.setDate(3, date);
		  pst.setInt(4, notice.getPublishStatus());
		  pst.setInt(5, notice.getType().getId());
		  pst.setInt(6, notice.getUser().getId());
		  count =pst.executeUpdate();
		  DBUtils.close(con, pst, null);
		  return count;
	}

	@Override
	public int deleteNoticeById(Integer nid) throws SQLException {
		int count=0;
	    Connection con=DBUtils.getConnection();
	    PreparedStatement pst=con.prepareStatement("delete from city_info_notice where id=?");
	    pst.setInt(1, nid);
	    count=pst.executeUpdate();
	    DBUtils.close(con, pst, null);
		return count;
	}

	@Override
	public int update(Notice notice) throws SQLException {
		int count=0;
		  Connection con=DBUtils.getConnection();
		  PreparedStatement pst=con.prepareStatement("update city_info_notice set title=?,content=?,type_id=? where id=?");
		  pst.setString(1, notice.getTitle());
		  pst.setString(2, notice.getContent());
		  pst.setInt(3, notice.getType().getId());
		  pst.setInt(4, notice.getId());
		  count =pst.executeUpdate();
		  DBUtils.close(con, pst, null);
		  return count;
	}

	@Override
	public int publish(Integer id) throws SQLException {
		int count=0;
		  Connection con=DBUtils.getConnection();
		  PreparedStatement pst=con.prepareStatement("update city_info_notice set publish_status=1,publish_date=? where id=?");
          Date date =new Date(new java.util.Date().getTime());
          pst.setDate(1, date);
          pst.setInt(2, id);
		  count =pst.executeUpdate();
		  DBUtils.close(con, pst, null);
		  return count;
	}

	@Override
	public Integer getTotalCount() throws SQLException {
		  Integer totalCount=0;
		  Connection con=DBUtils.getConnection();
		  PreparedStatement pst=con.prepareStatement("select count(*) from city_info_notice");
		  ResultSet rs=pst.executeQuery();
		  while(rs.next()){
			  totalCount=rs.getInt(1);
		  }
		  DBUtils.close(con, pst, rs);
		  return totalCount;
	}

	@Override
	public List<Notice> getNoticesByPage(PageBean<Notice> pageBean) throws SQLException {
		Connection con=DBUtils.getConnection();
		PreparedStatement pst =con.prepareStatement("select * from city_info_notice limit ?,?");
		System.out.println(pageBean.getThisPage());
		System.out.println(pageBean.getPageNum());
		pst.setInt(1, (pageBean.getThisPage()-1)*pageBean.getPageNum());
		pst.setInt(2, pageBean.getPageNum());
		List<Notice> notices=new ArrayList<Notice>();
		ResultSet rs=pst.executeQuery();
		while(rs.next()){
			Notice notice =new Notice();
			notice.setId(rs.getInt("id"));
			notice.setTitle(rs.getString("title"));
			notice.setContent(rs.getString("content"));
			notice.setCreateDate(rs.getDate("create_date"));
			notice.setPublishDate(rs.getDate("publish_date"));
			notice.setPublishStatus(rs.getInt("publish_status"));
			User user =new User();
			user.setId(rs.getInt("user_id"));
			notice.setUser(user);
			Type type =new Type();
			type.setId(rs.getInt("type_id"));
			notice.setType(type);
			notices.add(notice);
		}
		return notices;
	}

}
