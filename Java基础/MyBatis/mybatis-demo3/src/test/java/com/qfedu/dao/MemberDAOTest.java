package com.qfedu.dao;

import com.qfedu.pojo.Member;
import com.qfedu.pojo.MemberSearcgCondition;
import com.qfedu.utils.MyBatisUtil;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MemberDAOTest extends TestCase {

    public void testSearchMember() {
        MemberSearcgCondition memberSearcgCondition = new MemberSearcgCondition();
        memberSearcgCondition.setGender("女");
        //memberSearcgCondition.setMinAge(18);
        //memberSearcgCondition.setMaxAge(23);
        memberSearcgCondition.setCity("新会");
        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members = memberDAO.searchMember(memberSearcgCondition);
        for(Member m:members){
            System.out.println(m);
        }
    }

    @Test
    public void testSearchMemberByCity(){
        List<String> citys = new ArrayList<>();
        citys.add("新会");
        citys.add("开平");
        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members = memberDAO.searchMemberByCity(citys);
        for(Member m:members){
            System.out.println(m);
        }
    }

    @Test
    public void testSearchMemberByNick(){
//        HashMap<String,Object> params = new HashMap<>();
//        params.put("keyWord","花");
        MemberDAO memberDAO = MyBatisUtil.getMapper(MemberDAO.class);
        List<Member> members = memberDAO.searchMemberByNick("花");
        for(Member m:members){
            System.out.println(m);
        }
    }
}