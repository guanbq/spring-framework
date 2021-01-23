package com.gbq.dao;

import org.apache.ibatis.annotations.Select;

public interface OrderMapper {

	@Select("select 'order' ")
	public String selectOrder();
}
