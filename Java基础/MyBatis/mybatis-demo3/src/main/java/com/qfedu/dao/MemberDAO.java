package com.qfedu.dao;

import com.qfedu.pojo.Member;
import com.qfedu.pojo.MemberSearcgCondition;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface MemberDAO {
    // 在多条件查询中，如果查询条件不确定，可以直接使用HashMap作为参数
    // 优点：无需单独定义传递查询条件的类
    // 缺点：
    // public List<Member> searchMember(HashMap<String,Object> params);

    // 也可以定义专门用于存放查询条件的实体类存放参数
    // 优点：
    // 缺点：需要单独定义一个类来封装参数
    public List<Member> searchMember(MemberSearcgCondition params);

    public List<Member> searchMemberByCity(List<String> citys);

//    public List<Member> searchMemberByNick(HashMap params);
    public List<Member> searchMemberByNick(@Param("keyWord") String keyWord);
}
