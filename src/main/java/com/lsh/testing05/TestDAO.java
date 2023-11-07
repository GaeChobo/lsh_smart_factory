
   /*
package com.lsh.testing05;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lsh.testing05.member.dao.MemberDAO;
import com.lsh.testing05.member.vo.MemberVO;


@RestController
public class TestDAO {
   
    @Inject
    private MemberDAO dao;
   
   
    @RequestMapping(value = "/testDAO", method = RequestMethod.GET)
    public void testDAO(){
    	
    	
    	
        MemberVO vo = new MemberVO();
        vo.setORIGIN_ACCOUNT_DIVISION_ID(2);
        vo.setORIGIN_ACCOUNT_MEMBERNAME("김승우");
        vo.setORIGIN_ACCOUNT_PASSWORD("12345666");
        vo.setORIGIN_ACCOUNT_TYPE("관리자");
        vo.setORIGIN_ACCOUNT_EMPLOYEENUMBER("142233");
        vo.setORIGIN_ACCOUNT_DEPARTMENT("영업부");
        vo.setORIGIN_ACCOUNT_TIER("과장");
        vo.setORIGIN_ACCOUNT_RESIDENTNUMBER("850120-140522");
        vo.setORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID(1);
       
       
		dao.MemberRegister(vo);
		
		
    }
    
    
    @RequestMapping(value = "/testselect2", method = RequestMethod.GET)
    public ModelAndView testselect2() throws Exception {
    	
    	List<MemberVO> memberList = dao.AllselectMember();
    	ModelAndView mav = new ModelAndView();
    	mav.addObject(memberList);
    	
    	return mav;
    }
    
    
    // 전체 멤버 조회 
    @RequestMapping(value = "/testselect", method = RequestMethod.GET, produces="application/json;charset=utf-8")
    @ResponseBody 
    public List<MemberVO> testselect() throws Exception {
    	
    	return dao.AllselectMember();

    	
    	
    	
    	
    	if(memberList.size()>0) {
    		for(MemberVO list : memberList) {
    			
    			System.out.println("------------구분선-------------");
    			
    			System.out.println("멤버 IDX : "+list.ORIGIN_ACCOUNT_ID);
    			map.put("ORIGIN_ACCOUNT_ID", list.ORIGIN_ACCOUNT_ID);
    			
    			System.out.println("멤버 구분 IDX : "+list.ORIGIN_ACCOUNT_DIVISION_ID);
    			map.put("ORIGIN_ACCOUNT_DIVISION_ID", list.ORIGIN_ACCOUNT_DIVISION_ID);
    			
    			System.out.println("멤버 이름 : "+list.ORIGIN_ACCOUNT_MEMBERNAME);
    			map.put("ORIGIN_ACCOUNT_MEMBERNAME", list.ORIGIN_ACCOUNT_MEMBERNAME);
    			
    			System.out.println("멤버 패스워드 : "+list.ORIGIN_ACCOUNT_PASSWORD);
    			map.put("ORIGIN_ACCOUNT_PASSWORD", list.ORIGIN_ACCOUNT_PASSWORD);
    			
    			System.out.println("멤버 계정 구분명 : "+list.ORIGIN_ACCOUNT_TYPE);
    			System.out.println("멤버 사번 : "+list.ORIGIN_ACCOUNT_EMPLOYEENUMBER);
    			System.out.println("멤버 부서명 : "+list.ORIGIN_ACCOUNT_DEPARTMENT);
    			System.out.println("멤버 직급 : "+list.ORIGIN_ACCOUNT_TIER);
    			System.out.println("멤버 주민번호 : "+list.ORIGIN_ACCOUNT_RESIDENTNUMBER);
    			System.out.println("멤버 생성날짜 : "+list.ORIGIN_ACCOUNT_CREATEDATE);
    			System.out.println("멤버 재직여부 IDX : "+list.ORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID);
    			
    			
    		}
    		
    	
    	}
    	
    }
    
    // 회원가입 메소드 -아직 중복방지 ㄴ-
    @RequestMapping(value = "/register" , method = RequestMethod.POST, produces="application/json;charset=utf-8") 
	public MemberVO postRegister(MemberVO vo) throws Exception {
		
		
		dao.MemberRegister(vo);
		
		return null;
	}
    
}

*/