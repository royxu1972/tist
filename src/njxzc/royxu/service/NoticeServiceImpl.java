package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import njxzc.royxu.dao.NoticeDao;
import njxzc.royxu.domain.Notice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;


/**
 * 消息发布Service
 * @author Author
 * @version 2015-07-17
 */
@Service
@Transactional
public class NoticeServiceImpl {

	@Autowired
	private NoticeDao noticeDao;
	
	public void saveNotice(Notice notice){
		noticeDao.save(notice);
	}
	
	public List<Notice> loadAllNotices(){
		return noticeDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = noticeDao.pagedQuery("from Notice n where n.del_flag='0' order by n.notice_time desc", pageNo,pageSize, conditions);
		return page;
	}

	public Page getPagedHomeworks(int offset, int pageSize, Object... conditions) {
		Page page = noticeDao.pagedQuery2("from Notice n where n.del_flag='0' order by n.notice_time desc", offset,pageSize, conditions);
		return page;
	}
	
	public void deleteNotices(List<Notice> notices){
		noticeDao.deleteAll(notices);
	}
	
	public void updateNotice(Notice notice){
		noticeDao.update(notice);
	}
	
	public void deleteNotice(Notice notice){
		noticeDao.delete(notice);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteNoticesBySqls(String[] ids) throws SQLException{
		noticeDao.deleteNoticesBySqls(ids);
	}
	
	public void deleteNoticeAndFile(Notice notice) throws SQLException{
		noticeDao.deleteNoticeAndFile(notice);
	}

	public int counttotal(int rows) {
		String sql = "from Notice n where n.del_flag='0'";
		List<Notice> list = (List<Notice>)noticeDao.find(sql);
		return list.size()/rows + (list.size()%rows == 0? 0:1);
	}

	public List<Notice> searchById(String notice_id) {
		String sql = "from Notice n where n.del_flag='0' and n.notice_id=" + notice_id;
		List<Notice> list = (List<Notice>)noticeDao.find(sql);
		return list;
	}
	
}
