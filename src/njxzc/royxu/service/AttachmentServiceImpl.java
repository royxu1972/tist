package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;

import njxzc.royxu.domain.Attachment;
import njxzc.royxu.dao.AttachmentDao;

/**
 * 附件Service
 * @author LiangHong
 * @version 2015-10-02
 */
@Service
@Transactional
public class AttachmentServiceImpl {

	@Autowired
	private AttachmentDao attachmentDao;
	
	public void saveAttachment(Attachment attachment){
		attachmentDao.save(attachment);
	}
	
	public List<Attachment> loadAllAttachments(){
		return attachmentDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = attachmentDao.pagedQuery("from Attachment", pageNo,pageSize, conditions);
		return page;
	}
	
	public Page getPagedAttachments(int offset, int pageSize, Object... conditions) {
		Page page = attachmentDao.pagedQuery2("from Attachment", offset,pageSize, conditions);
		return page;
	}
	
	public void deleteAttachments(List<Attachment> attachments){
		attachmentDao.deleteAll(attachments);
	}
	
	public void updateAttachment(Attachment attachment){
		attachmentDao.update(attachment);
	}
	
	public void deleteAttachment(Attachment attachment){
		attachmentDao.delete(attachment);
	}
	
//	根据del_flag批量修改（等于删除）
	public void deleteAttachmentsBySqls(String[] ids) throws SQLException{
		attachmentDao.deleteAttachmentsBySqls(ids);
	}
	
	public void deleteAttachmentsByRelatedIdAndTname(String related_id,String related_table_name) throws Exception{
		attachmentDao.deleteAttachmentsByRelatedIdAndTname(related_id, related_table_name);
	}
	
}
