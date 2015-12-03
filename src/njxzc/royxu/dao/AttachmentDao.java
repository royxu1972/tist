package njxzc.royxu.dao;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.core.BaseDao;
import com.util.generate.FileUtils;

import njxzc.royxu.domain.Attachment;

/**
 * 附件DAO接口
 * @author LiangHong
 * @version 2015-10-02
 */
@Repository
public class AttachmentDao extends BaseDao<Attachment> {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
//	根据del_flag批量修改（等于删除）
	public void deleteAttachmentsBySqls(String[] ids) throws SQLException{
		List<String> sqls = new ArrayList<String>();
		for(String id : ids){
			String sql = "update Attachment set ? where = ?";
			sqls.add(sql);
		}
		updateSqls(sqls);
	}
	
	//根据关联id与所属表名删除附件
	@SuppressWarnings("unchecked")
	public void deleteAttachmentsByRelatedIdAndTname(String related_id,String related_table_name) throws Exception{
		List<Attachment> attachments = (List<Attachment>) find("from Attachment a where a.related_id='"+ related_id +"' and a.table_of_attachment='"+related_table_name+"'");
		//循环删除本地单个文件
		for(Attachment attachment : attachments){
			FileUtils.deleteFile(attachment.getFile_path());
		}
		//删除文件记录
		deleteAll(attachments);
	}
	
}
