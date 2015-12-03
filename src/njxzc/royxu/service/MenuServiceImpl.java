package njxzc.royxu.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import njxzc.royxu.dao.MenuDao;
import njxzc.royxu.domain.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.core.Page;
import com.util.TreeNode;

@Service
@Transactional
public class MenuServiceImpl {
	@Autowired
	private MenuDao menuDao;
	
	public void saveMenu(Menu menu) throws Exception{
		menuDao.saveMenu(menu);
	}
	
	public List<Menu> loadAllMenus(){
		return menuDao.loadAll();
	}
	
	public Page getSysParams(int pageNo, int pageSize, Object... conditions) {
		Page page = menuDao.pagedQuery("from Menu u where u.del_flag=0", pageNo,pageSize, conditions);
		return page;
	}
	
	public void delteMenus(List<Menu> menus){
		menuDao.deleteAll(menus);
	}
	
	public void updateMenu(Menu menu) throws Exception{
		menuDao.updateMenu(menu);
	}
	
	public int getMenuCountByFatherId(Integer father_id) throws SQLException{
		return menuDao.getMenuCountByFatherId(father_id);
	}
	
	public List<Menu> getMenuByMenuIds(String menu_ids) throws Exception {
		return menuDao.getMenuByMenuIds(menu_ids);
	}
	
	@SuppressWarnings("unchecked")
	public List<Menu> loadLevelOneMenus(){
		String hql = "from Menu m where m.menu_level=? or m.menu_level=? order by m.sort";
		List<Menu> menus = (List<Menu>) menuDao.find(hql,"1","0");
		return menus;
	}
	
	public List<TreeNode> getTree(Integer id) {
		String hql = (id != null && id > 0) ? "from Menu m where m.father_id="+ id +""
				: "from Menu m where m.father_id is null";
		System.err.println(hql);
		@SuppressWarnings("unchecked")
		List<Menu> professionQualificationlist = (List<Menu>) this.menuDao.find(hql);
		List<TreeNode> treeList = new ArrayList<TreeNode>();
		for (Menu m : professionQualificationlist) {
			treeList.add(tree(m, true));
		}
		return treeList;
	}
	
	
	/**
	 * 树形结构递归算法；
	 * 
	 * @param m
	 * @param recursive
	 * @return
	 */
	public TreeNode tree(Menu menu, boolean recursive) {
		TreeNode node = new TreeNode();
		node.setId(menu.getMenu_id());
		node.setText(menu.getMenu_name());
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("menu_id",menu.getMenu_id());
		attributes.put("menu_name",menu.getMenu_name());
		attributes.put("menu_level",menu.getMenu_level());
		attributes.put("href",menu.getHref());
		attributes.put("father_id",menu.getFather_id());
		attributes.put("del_flag",menu.getDel_flag());
		attributes.put("create_by",menu.getCreate_by());
		attributes.put("create_time",menu.getCreate_time());
		attributes.put("update_by",menu.getUpdate_by());
		attributes.put("update_time",menu.getUpdate_time());
		attributes.put("sort",menu.getSort());
		attributes.put("note",menu.getNote());
//		attributes.put("code", m.getNodeCode());//获取节点编码
//		attributes.put("rank", m.getRank());//获取排列顺序
//		attributes.put("status", m.getStatus());
		node.setAttributes(attributes);

		if (menu.getMenus()!=null&&menu.getMenus().size()>0) {//如果该节点有子节点
			node.setState("closed");
			if (recursive) {
				List<Menu> professionQualifications = menu.getMenus();
				List<TreeNode> children = new ArrayList<TreeNode>();
				for (Menu m1 : professionQualifications) {
					TreeNode t = tree(m1, true);
					children.add(t);
				}
				node.setChildren(children);
			}
		}

		return node;
	}
	
	public List<Menu> findMenuByFatherIdRoleId(int role_id,Integer father_id) throws SQLException{
		return menuDao.findMenuByFatherIdRoleId(role_id, father_id);
	}
	
	public List<Menu> findMenuByFatherIdRoleId(String role_ids,Integer father_id) throws SQLException{
		return menuDao.findMenuByFatherIdRoleId(role_ids, father_id);
	}
	
	public List<Menu> findMenusByUserId(int user_id) throws SQLException{
		return menuDao.findMenusByUserId(user_id);
	}
	
}
