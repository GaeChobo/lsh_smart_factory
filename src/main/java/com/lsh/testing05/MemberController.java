package com.lsh.testing05;

import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lsh.testing05.member.exception.MemberDeleteException;
import com.lsh.testing05.member.exception.MemberIdCheckException;
import com.lsh.testing05.member.exception.MemberImgDeleteException;
import com.lsh.testing05.member.exception.MemberLoginException;
import com.lsh.testing05.member.exception.MemberPwdCheckException;
import com.lsh.testing05.member.exception.MemberRegisterException;
import com.lsh.testing05.member.exception.MemberSelectException;
import com.lsh.testing05.member.exception.MemberUpdateException;
import com.lsh.testing05.member.exception.MemeberImgUpdateException;
import com.lsh.testing05.member.exception.WorkerPropertyRegisterException;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lsh.testing05.handler.MyExceptionHandler;
import com.lsh.testing05.member.service.MemberService;
import com.lsh.testing05.member.vo.MemberVO;
import com.lsh.testing05.member.vo.MemberFSVO;

@CrossOrigin(origins = "*")
@RestController
public class MemberController extends MyExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Inject
	MemberService service;
	
	@RequestMapping(value = "/SelectWorkerPropertyMain", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<MemberVO> SelectWorkerPropertyMain(@RequestBody MemberVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "SelectWorkerPropertyMain");
		
		return service.SelectWorkerPropertyMain(vo);
		
	}

	@RequestMapping(value = "/Registerworkerproperty", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String Registerworkerproperty(@RequestBody MemberVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
			
		String time1 = format1.format(time);
		
		logger.info(time1 + "Registerworkerproperty");
		
		System.out.println(vo.getORIGIN_ACCOUNT_ID());
		System.out.println(vo.getPROCESS_MAIN_CATEGORY_ID());
		System.out.println(vo.getORIGIN_EQUIPMENT_ID());
		System.out.println(vo.getORIGIN_ACCOUNT_DIVISION_ID());
		System.out.println(vo.getORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID());
		
		
		
		if(vo.getORIGIN_ACCOUNT_DIVISION_ID() == 1 || vo.getORIGIN_ACCOUNT_DIVISION_ID() == 3 && vo.getORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID() == 1) {
			
			service.Registerworkerproperty(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("Registerworkerproperty", 1);
			
			return obj.toString();
			
		}else {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("Registerworkerproperty", 0);
			
			return obj.toString();
		}
		
	}
	
	@RequestMapping(value = "/Updateworkerproperty", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String Updateworkerproperty(@RequestBody MemberVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
			
		String time1 = format1.format(time);
		
		logger.info(time1 + "Updateworkerproperty");
		
		try {
			
			System.out.println(vo.getPROCESS_MAIN_CATEGORY_ID());
			System.out.println(vo.getORIGIN_EQUIPMENT_ID());
			System.out.println(vo.getORIGIN_ACCOUNT_ID());
			

			service.Updateworkerproperty(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("Updateworkerproperty", 1);
			
			return obj.toString();
			
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("Updateworkerproperty", 0);
			
			return obj.toString();
		}
		
		
	}

	@RequestMapping(value = "/SelectWorkerProperty", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<MemberVO> SelectWorkerProperty(@RequestBody MemberVO vo) throws Exception {
		
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
			
		String time1 = format1.format(time);
		
		logger.info(time1 + "SelectWorkerProperty");
		
		List<MemberVO> resultlist = service.SelectWorkerProperty(vo);
		return resultlist;
	}


	@RequestMapping(value = "/CreateDayFind", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public List<MemberVO> CreateDayFind(@RequestBody MemberVO vo) throws Exception {
		
		return service.CreateDayFind(vo);
	}

	
	@RequestMapping(value = "/AllselectMember", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	@ResponseBody
	public List<MemberVO> selectAllMember() throws Exception {
		
		logger.info("Get Members");
		try {
		return service.AllselectMember();
		}
		catch(Exception e) {
			throw new MemberSelectException();
		}
		
	}
	
	@RequestMapping(value = "/WorketMemberSelect", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public List<MemberVO> WorketMemberSelect(MemberVO vo) throws Exception {
		
		logger.info("Get Worker Members");
		
		return service.WorketMemberSelect(vo);
	}

	@RequestMapping(value = "/AdminMemberSelect", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public List<MemberVO> AdminMemberSelect(MemberVO vo) throws Exception {
		
		logger.info("Get Admin Members");
		
		return service.AdminMemberSelect(vo);
	}
	
	
	@RequestMapping(value = "/UpdateMember" , method = RequestMethod.POST, produces="application/json;charset=utf-8") 
	public String UpdateMember(@RequestBody MemberVO vo, HttpSession session) throws Exception {
		
		logger.info("Update Member");
		
		System.out.println(vo.getORIGIN_ACCOUNT_DIVISION_ID());
		System.out.println(vo.getORIGIN_ACCOUNT_MEMBERNAME());
		System.out.println(vo.getORIGIN_ACCOUNT_TYPE());
		System.out.println(vo.getORIGIN_ACCOUNT_DEPARTMENT());
		System.out.println(vo.getORIGIN_ACCOUNT_TIER());
		System.out.println(vo.getORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID());
		System.out.println(vo.getORIGIN_ACCOUNT_PASSWORD());
		System.out.println(vo.getORIGIN_ACCOUNT_RESIDENTNUMBER());
		System.out.println(vo.getORIGIN_ACCOUNT_EMPLOYEENUMBER());
		
		int result = service.CheckMember(vo);
		
		if (result == 0) {
			
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdateFail", 0);
			
			return obj.toString();
			
		}
		else {
			
			service.UpdateMember(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("UpdateFail", 1);
			
			return obj.toString(); 
		}

	}
		
	@RequestMapping(value = "/DeleteMember", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String DeleteMember(@RequestBody MemberVO vo, HttpSession session, RedirectAttributes rttr) throws Exception {
		
		// 세션에 있는 member를 member변수에 넣어줌
		logger.info("Delete Member");
		
		int result = service.CheckMember(vo);

		try {
			
			if (result == 0) {


				JsonObject obj = new JsonObject();
				
				obj.addProperty("DeleteFail", 0);
				
				return obj.toString(); 
				
			}else {
				
				int DvisionResult = service.SelectDivisionId(vo);
				
				if (DvisionResult == 3) {
					
					service.DeleteWorkerProperty(vo);
				}
				
				service.DeleteMember(vo);
				
				JsonObject obj = new JsonObject();
				
				obj.addProperty("DeleteFail", 1);
				
				return obj.toString(); 
			}
			
		} catch(Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("DeleteFail", 2);
			
			return obj.toString(); 
		}
		
		
	}
	
 
	
	@RequestMapping(value = "/PassFinding" , method = RequestMethod.POST, produces="application/json;charset=utf-8")
	@ResponseBody
	public MemberVO PassFinding(@RequestBody MemberVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
			
		String time1 = format1.format(time);
		
		logger.info(time1 + "PassFinding");
				
		//사번 체크
		Integer EMPLOYEENUMBERCheck = service.PassFinding01(vo);
		System.out.println(EMPLOYEENUMBERCheck);
		
		//주민번호 체크
		Integer RESIDENTNUMBERCheck = service.PassFinding02(vo);
		System.out.println(RESIDENTNUMBERCheck);
		
		//둘 다 일치함
		if(EMPLOYEENUMBERCheck == 1 && RESIDENTNUMBERCheck == 1) {
			
			MemberVO sucessrs = service.PassFinding(vo);
			
			if (sucessrs == null) {
				
				vo.setPwd_find_fail(2);
				
				return vo;
				
			}else {
				
				sucessrs.setPwd_find_fail(1);
				
				return sucessrs;
			}
			

		}
		//둘중 하나 일치 안하는 경우겠찌 둘다거나
		else if(EMPLOYEENUMBERCheck == 1 && RESIDENTNUMBERCheck == 0){
			
			vo.setPwd_find_fail(2);
			
			return vo;
		}
		
		else if(EMPLOYEENUMBERCheck == 0 && RESIDENTNUMBERCheck == 1){
			
			vo.setPwd_find_fail(2);
			
			return vo;

			
		}

		
		else {
			
			vo.setPwd_find_fail(3);
			
			return vo;
		}

	}  

	@ResponseBody
	@RequestMapping(value = "PassChkMember", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public int PassChkMember(@RequestBody MemberVO vo) throws Exception {
		int result = service.PassChkMember(vo);
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "IdkChkMember", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public int IdChkMember(@RequestBody MemberVO vo) throws Exception {
		int result = service.IdChkMember(vo);
		return result;
	}
	@ResponseBody
	@RequestMapping(value = "CheckMember", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public int CheckMember(@RequestBody MemberVO vo) throws Exception {
		int result = service.CheckMember(vo);
		return result;
	}
	
	@RequestMapping(value = "/RegisterMember" , method = RequestMethod.POST, produces="application/json;charset=utf-8") 
	public String RegisterMember(MemberVO vo, MultipartHttpServletRequest request)  throws Exception {
		
		logger.info("post Register");
		
		int result = service.IdChkMember(vo);
		
		try {
			if(result >= 1) {
				
				logger.info("[중복] 회원 가입 실패");
				
				JsonObject obj = new JsonObject();

				obj.addProperty("RegisterON", 0);
				
				return obj.toString(); 

			}else if(result == 0) {
				
				//파일을 안넣을 경우까지 조건문으로 작성을 해야함

				MultipartFile filelist = request.getFile("img file");

				if(filelist == null) {

					//인코딩하는중
					String ORIGIN_ACCOUNT_MEMBERNAME1 = new String(request.getParameter("ORIGIN_ACCOUNT_MEMBERNAME"));
					ORIGIN_ACCOUNT_MEMBERNAME1 = new String(ORIGIN_ACCOUNT_MEMBERNAME1.getBytes("8859_1"), "UTF-8");
					
					String ORIGIN_ACCOUNT_TYPE1 = new String(request.getParameter("ORIGIN_ACCOUNT_TYPE"));
					ORIGIN_ACCOUNT_TYPE1 = new String(ORIGIN_ACCOUNT_TYPE1.getBytes("8859_1"), "UTF-8");
					
					String ORIGIN_ACCOUNT_DEPARTMENT1 = new String(request.getParameter("ORIGIN_ACCOUNT_DEPARTMENT"));
					ORIGIN_ACCOUNT_DEPARTMENT1 = new String(ORIGIN_ACCOUNT_DEPARTMENT1.getBytes("8859_1"), "UTF-8");
					
					String ORIGIN_ACCOUNT_TIER1 = new String(request.getParameter("ORIGIN_ACCOUNT_TIER"));
					ORIGIN_ACCOUNT_TIER1 = new String(ORIGIN_ACCOUNT_TIER1.getBytes("8859_1"), "UTF-8");
					
					vo.setORIGIN_ACCOUNT_MEMBERNAME(ORIGIN_ACCOUNT_MEMBERNAME1);
					vo.setORIGIN_ACCOUNT_TYPE(ORIGIN_ACCOUNT_TYPE1);
					vo.setORIGIN_ACCOUNT_DEPARTMENT(ORIGIN_ACCOUNT_DEPARTMENT1);
					vo.setORIGIN_ACCOUNT_TIER(ORIGIN_ACCOUNT_TIER1);
					
					service.RegisterMember(vo);
					
					JsonObject obj = new JsonObject();

					obj.addProperty("RegisterON", 1);
					
					return obj.toString(); 
			
				}
				else {

					SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
					
					Date time = new Date();
					
					String time1 = format1.format(time);
					
					//C로 변경완료
					
					String path = ("C:\\Html\\factory\\member\\img\\");
					
					String dbpath = ("http://182.208.252.210:5995/factory/member/img/");
					
					String dbrealpath = dbpath+time1;
					
					String realpath = path+time1;
					
					File Folder = new File(realpath);
					
					Folder.mkdirs();
					
					//인코딩하는중
					String ORIGIN_ACCOUNT_MEMBERNAME1 = new String(request.getParameter("ORIGIN_ACCOUNT_MEMBERNAME"));
					ORIGIN_ACCOUNT_MEMBERNAME1 = new String(ORIGIN_ACCOUNT_MEMBERNAME1.getBytes("8859_1"), "UTF-8");
					
					String ORIGIN_ACCOUNT_TYPE1 = new String(request.getParameter("ORIGIN_ACCOUNT_TYPE"));
					ORIGIN_ACCOUNT_TYPE1 = new String(ORIGIN_ACCOUNT_TYPE1.getBytes("8859_1"), "UTF-8");
					
					String ORIGIN_ACCOUNT_DEPARTMENT1 = new String(request.getParameter("ORIGIN_ACCOUNT_DEPARTMENT"));
					ORIGIN_ACCOUNT_DEPARTMENT1 = new String(ORIGIN_ACCOUNT_DEPARTMENT1.getBytes("8859_1"), "UTF-8");
					
					String ORIGIN_ACCOUNT_TIER1 = new String(request.getParameter("ORIGIN_ACCOUNT_TIER"));
					ORIGIN_ACCOUNT_TIER1 = new String(ORIGIN_ACCOUNT_TIER1.getBytes("8859_1"), "UTF-8");
					
					String test1 = new String(filelist.getOriginalFilename().getBytes("8859_1"), "UTF-8");
					
					File savefile = new File(realpath+"\\"+test1);
					
					String dbsavepath = dbrealpath+"/"+test1;
					
					System.out.println(dbsavepath);
					
					filelist.transferTo(savefile);
					
					String dircetory = savefile.toString();

					vo.setORIGIN_ACCOUNT_MEMBERNAME(ORIGIN_ACCOUNT_MEMBERNAME1);
					vo.setORIGIN_ACCOUNT_TYPE(ORIGIN_ACCOUNT_TYPE1);
					vo.setORIGIN_ACCOUNT_DEPARTMENT(ORIGIN_ACCOUNT_DEPARTMENT1);
					vo.setORIGIN_ACCOUNT_TIER(ORIGIN_ACCOUNT_TIER1);
					vo.setORIGIN_ACCOUNT_IMG_DIRECTORY(dbsavepath);
					
					service.RegisterMember(vo);
					
					JsonObject obj = new JsonObject();

					obj.addProperty("RegisterON", 1);
					
					return obj.toString(); 
				}

			}
		} catch (Exception e) {
			throw new MemberRegisterException();
		}
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/FindImgDirectory", method = RequestMethod.GET, produces="application/json;charset=utf-8")
	public String FindImgDirectory(MemberVO vo) throws Exception {
		
		String result = service.FindImgDirectory(vo);
		return result;
	}
	
	@RequestMapping(value = "/WorkerImgDelete", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String WorkerImgDelete(@RequestBody MemberVO vo) throws Exception {
		
		logger.info("Worker Img Delete");
		
		try {
			
			String result = service.FindImgDirectory(vo);
			
			File file = new File(result);
			
			if(file.exists()) {
				file.delete();
				System.out.println("파일 삭제 완료");
			}
			
			service.WorkerImgDelete(vo);
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("ImgDelete", 1);
			
			return obj.toString();
			
		} catch (Exception e) {
			
			JsonObject obj = new JsonObject();
			
			obj.addProperty("ImgDelete", 0);
			
			return obj.toString();
			
		}
		
		
	}

	@RequestMapping(value = "/WorkerImgUpdate" , method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String WorkerImgUpdate(MemberVO vo,  MultipartHttpServletRequest request) throws Exception {
		
		logger.info("WorkerImgUpdate");
		
		MultipartFile filelist = request.getFile("img file");
		
		try {
			
			if(filelist == null) {
				
				String result = service.FindImgDirectory(vo);
				
				System.out.println(result);
				
				File file = new File(result);
				
				if(file.exists()) {
					file.delete();
					System.out.println("파일 삭제 완료");
				}
				
				vo.setORIGIN_ACCOUNT_IMG_DIRECTORY(null);
				
				service.WorkerImgUpdate(vo);
				
				JsonObject obj = new JsonObject();
				
				obj.addProperty("ImgUpdate", 0);
				
				return obj.toString();
			} 
			else {
				
				SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
				
				Date time = new Date();

				String time1 = format1.format(time);
				
				//C로 변경완료
				
				String path = ("C:\\factory\\member\\img\\");
				
				String realpath = path+time1;
				
				File Folder = new File(realpath);
				
				Folder.mkdirs();
				
				//파일명 인코딩
				
				String test1 = new String(filelist.getOriginalFilename().getBytes("8859_1"), "UTF-8");
				
				File savefile = new File(realpath+"\\"+test1);

				filelist.transferTo(savefile);

				String dircetory = savefile.toString();

				vo.setORIGIN_ACCOUNT_IMG_DIRECTORY(dircetory);

				service.WorkerImgUpdate(vo);
				
				JsonObject obj = new JsonObject();
				
				obj.addProperty("ImgUpdate", 1);
				
				return obj.toString();

			}
			
		} catch(Exception e) {
			throw new MemeberImgUpdateException();
		}
		
		
	}
	
	@RequestMapping(value = "/LoginReturntest", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public List<MemberVO> LoginReturntest(@RequestBody MemberVO vo, RedirectAttributes rttr) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "LoginReturntest");
		
		return service.LoginReturntest(vo);
		
	}


	@RequestMapping(value = "/LoginReturn", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public MemberVO LoginReturn(@RequestBody MemberVO vo) throws Exception {
		
		SimpleDateFormat format1 = new SimpleDateFormat("yyMMdd_HHmmss");
		
		Date time = new Date();
				
		String time1 = format1.format(time);
		
		logger.info(time1 + "LoginReturn");
		
		MemberVO login = service.login(vo);

		if (login == null) {

			return vo;
			
		} else {
			
			return service.LoginReturn(vo);
			
		}
				

		

	}
		
		
		
	

	/*
	@RequestMapping(value = "/LoginMember", method = RequestMethod.POST, produces="application/json;charset=utf-8")
	public String login(@RequestBody MemberVO vo, HttpServletRequest req, RedirectAttributes rttr) throws Exception {
		logger.info("post login");
		
		HttpSession session = req.getSession();
	
		MemberVO login = service.login(vo);
	
		if (login == null) { 
			
			rttr.addAttribute("msg", "아이디나 비밀번호가 틀림");
			throw new MemberLoginException();
		}
		
		else {
			
			session.setAttribute("ORIGIN_ACCOUNT_EMPLOYEENUMBER", login);
			

			
			session.setAttribute("ORIGIN_ACCOUNT_ID", vo);
			session.setAttribute("ORIGIN_ACCOUNT_DIVISION_ID", vo);
			session.setAttribute("ORIGIN_ACCOUNT_MEMBERNAME", vo);
			session.setAttribute("ORIGIN_ACCOUNT_PASSWORD", vo);
			session.setAttribute("ORIGIN_ACCOUNT_TYPE", vo);
			session.setAttribute("ORIGIN_ACCOUNT_EMPLOYEENUMBER", vo);
			session.setAttribute("ORIGIN_ACCOUNT_DEPARTMENT", vo);
			session.setAttribute("ORIGIN_ACCOUNT_TIER", vo);
			session.setAttribute("ORIGIN_ACCOUNT_RESIDENTNUMBER", vo);
			session.setAttribute("ORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID", vo);
			
			
			int value1 = (int)session.getAttribute("ORIGIN_ACCOUNT_ID");
			int value2 = (int)session.getAttribute("ORIGIN_ACCOUNT_DIVISION_ID");
			String value3 = (String)session.getAttribute("ORIGIN_ACCOUNT_MEMBERNAME");
			String value4 = (String)session.getAttribute("ORIGIN_ACCOUNT_PASSWORD");
			String value5 = (String)session.getAttribute("ORIGIN_ACCOUNT_TYPE");
			String value6 = (String)session.getAttribute("ORIGIN_ACCOUNT_EMPLOYEENUMBER");
			String value7 = (String)session.getAttribute("ORIGIN_ACCOUNT_DEPARTMENT");
			String value8 = (String)session.getAttribute("ORIGIN_ACCOUNT_TIER");
			String value9 = (String)session.getAttribute("ORIGIN_ACCOUNT_RESIDENTNUMBER");
			int value10 = (int)session.getAttribute("ORIGIN_ACCOUNT_EMPLOYMENT_STATUS_ID");
			
			System.out.println(value1);
			System.out.println(value2);
			System.out.println(value3);
			System.out.println(value4);
			System.out.println(value5);
			System.out.println(value6);
			System.out.println(value7);
			System.out.println(value8);
			System.out.println(value9);
			System.out.println(value10);
			
			return "로그인 성공";
		}
		
		
	}
	*/
	
	
	@RequestMapping(value = "/Memberlogout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		
		session.invalidate();
		
		return "로그아웃 성공";
	}
}
