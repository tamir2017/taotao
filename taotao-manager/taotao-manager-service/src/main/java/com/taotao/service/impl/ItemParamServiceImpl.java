package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;
	
	@Override
	public TaotaoResult getItemParamByCid(Long cid) {
		//根据cid查询规格参数模板
		TbItemParamExample example = new TbItemParamExample();
		Criteria criteria = example.createCriteria();
		criteria.andItemCatIdEqualTo(cid);
		//执行查询
		List<TbItemParam>list = itemParamMapper.selectByExampleWithBLOBs(example);
		//判断是否查询到结果
		if (list != null&&list.size() > 0) {
			TbItemParam itemParam = list.get(0);
			return TaotaoResult.ok(itemParam);
		}
		return TaotaoResult.ok();
	}

	@Override
	public TaotaoResult insertItemParam(Long cid, String paramDate) {
		TbItemParam itemParm = new TbItemParam();
		itemParm.setItemCatId(cid);
		itemParm.setParamData(paramDate);
		itemParm.setCreated(new Date());
		itemParm.setUpdated(new Date());
		itemParamMapper.insert(itemParm);
		return TaotaoResult.ok();
	}

}

