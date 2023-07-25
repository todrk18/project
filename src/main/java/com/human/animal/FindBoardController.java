package com.human.animal;

import java.io.File;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.human.VO.FindBoardVO;
import com.human.VO.PageVO;
import com.human.admin.FindBoard_admin;
import com.human.service.FindBoardService;
import com.human.util.UploadFileUtil;

@Controller
public class FindBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(FindBoardController.class);
	
	FindBoard_admin findboardAdmin = new FindBoard_admin();
	@Inject
	FindBoardService findboardsrv;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/list_findboard", method = RequestMethod.GET)
	public String list_findboard(Locale locale, Model model, @ModelAttribute("") PageVO pagevo ) throws Exception{
		//버전2. 검색어를 pagevo에 포함을 시킴
		// 클라이언트가   컨트롤러라만 호출하던지,  페이지번호 정보가 있던지 없던지, 검색어가 있던지 없던지. 이 정보를 pagevo가 받을 수 있다.
		
		// 서비스단에게 보내야 한다... 그리고 리턴받고 . 뷰에게 전달..
		// page정보
		if(pagevo.getPage() == null) {
			pagevo.setPage(1);
			System.out.println(pagevo.getPage() +" 로 페이지 번호가 설정됨.");
		}else {
			System.out.println(pagevo.getPage() +" 로 페이지 번호가 설정됨222.");
		}
		// 페이지 정보를 계산하기 위해서 3가지 정보.. 1. page  2. perpageNum(초기값) 3. totalCount

		
		int tcnt = findboardsrv.totalCnt(pagevo.getSearch_word());
		System.out.println(tcnt+"건 가져옴");
		pagevo.setTotalCount(tcnt);
		pagevo.calcPage();
		
		pagevo.prt();
		
		
		
		
		
		List<FindBoardVO> allList = findboardsrv.listAll(pagevo);
	//	System.out.println(allList.size() +"건 가져왔습니다.");
		model.addAttribute("fList", allList);
		model.addAttribute("pageVO", pagevo);
		return "findboard_view";
	}
	
	@RequestMapping(value = "/input_findboard", method = RequestMethod.GET)
	public String input_findboard(Locale locale, Model model, HttpSession f) {
		String userName = (String) f.getAttribute("nowUser");
		
		//Object loginInfo = f.getAttribute("nowUser");
		if(userName == null) {
			model.addAttribute("msg", false);
		}

		return "input_findboard";
	}	
	
	@RequestMapping(value = "/input_findboard_save", method = RequestMethod.POST)
	public String input_findboard_save(Locale locale, Model model, @ModelAttribute("animal_find")FindBoardVO vo,
			MultipartFile file) throws Exception {
		
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtil.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
		 fileName =  UploadFileUtil.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		vo.setImg_url(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setImg_thumb(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
	
		findboardsrv.insertOne(vo); //메서드명 수정결과 첨부파일은 배열로 저장되어있다.<기억!!>
   		
		return "redirect:/list_findboard";
	}
	
	@RequestMapping(value = "/findboard_detail", method = RequestMethod.GET)
	public String findboard_detail(Locale locale, Model model,
			@RequestParam("viewno") Integer viewno) throws Exception {

		model.addAttribute("viewvo", findboardsrv.view_findboard(viewno));
	
		return "findboard_viewform";  //뷰가 아니라 다른 매핑으로 리다이렉트.
	}
	
	@RequestMapping(value = "/deleteFindboard", method = RequestMethod.GET)
	public String deleteFindboard(Locale locale, Model model,
			@RequestParam("deltitle") Integer delno) throws Exception {
		
	
		//삭제기능 컨트롤러.. 쿼리 : delete from schedule where num=delno;
		findboardsrv.del_findboard(delno);
	
		
		return "redirect:/list_findboard";  //뷰가 아니라 다른 매핑으로 리다이렉트..
	}
		
	@RequestMapping(value = "/modFindboard", method = RequestMethod.GET)
	public String modFindboard(Locale locale, Model model,
			@RequestParam("modno") Integer modno) throws Exception {

		model.addAttribute("modvo", findboardsrv.mod_findboard(modno));		
		return "findboard_modform";  //뷰가 아니라 다른 매핑으로 리다이렉트..
	}
	
	@RequestMapping(value = "/modFindboard_pro", method = RequestMethod.POST)
	public String modFindboard_pro(Locale locale, Model model,
			@ModelAttribute("animal_find")FindBoardVO vo,MultipartFile file) throws Exception {

		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtil.calcPath(imgUploadPath);
		String fileName = null;

		if(file != null) {
		 fileName =  UploadFileUtil.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath); 
		} else {
		 fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		vo.setImg_url(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		vo.setImg_thumb(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		
		
		findboardsrv.mod_findboard(vo);
		return "redirect:/list_findboard";  //뷰가 아니라 다른 매핑으로 리다이렉트..
	}
	
	

}
