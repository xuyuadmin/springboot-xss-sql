package com.xuyu.mapper;

import org.apache.ibatis.annotations.Select;

import com.xuyu.entity.UserEntity;



public interface UserMapper {

	@Select(" SELECT  * FROM user_info where userName=#{userName} and password=#{password}")
	public UserEntity login(UserEntity userEntity);

}
