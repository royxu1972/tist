package njxzc.royxu.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.domain.Notice;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;

/**
 * 消息发布DAO接口
 * @author Author
 * @version 2015-07-17
 */
@Repository
public class NoticeDao extends BaseDao<Notice> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteNoticesBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update Notice set del_flag where = '1'";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	public void deleteNoticeAndFile(Notice notice) throws SQLException{
//		删除消息
		String sql = "update Notice set del_flag = '1' where notice_id = "+notice.getNotice_id();
		List<String> sqls = new ArrayList<String>();
		sqls.add(sql);
//		删除消息对应的文件
		sql = "update NoticeFile set del_flag = '1' where notice_id = "+notice.getNotice_id();
		sqls.add(sql);
		updateSqls(sqls);
	}
	
}
