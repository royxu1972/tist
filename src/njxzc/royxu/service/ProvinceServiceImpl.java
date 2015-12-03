package njxzc.royxu.service;

import java.util.List;

import javax.annotation.Resource;

import njxzc.royxu.dao.*;
import njxzc.royxu.domain.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ProvinceServiceImpl {
	@Resource
	private ProvinceDao hatprovincedao;

	public List<HatProvince> findAllProvince() {
		return  hatprovincedao.loadAll();
	}
	
	/**
	 * @author 梁轰
	 * @param province_id
	 * @return
	 * 修改原因：增加根据City的父id获得省的名字
	 * 修改时间：2014年4月6日16:52:45
	 */
	public List<HatProvince> getProvince(String province_id){
		return hatprovincedao.getProvince(province_id);
	}
}
