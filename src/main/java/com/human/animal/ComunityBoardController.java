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

import com.human.VO.ComunityBoardVO;
import com.human.VO.PageVO;
import com.human.VO.ReplyVO;
import com.human.admin.ComunityBoard_admin;
import com.human.service.ComunityBoardService;
import com.human.service.ReplyService;
import com.human.util.UploadFileUtil;


@Controller
public class ComunityBoardController {
	

	private static final Logger logger = LoggerFactory.getLogger(ComunityBoardController.class);
	
	ComunityBoard_admin comunityboardAdmin = new ComunityBoard_admin();
	@Inject
	ComunityBoardService comunityboardsrv;
	
	@Inject
	private ReplyService replysrv;
	
	@Resource(name="uploadPath")
	private String uploadPath;
	
	@RequestMapping(value = "/list_comunityboard", method = RequestMethod.GET)
	public String list_comunityboard(Locale locale, Model model, @ModelAttribute("") PageVO pagevo ) throws Exception{
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

		
		int tcnt = comunityboardsrv.totalCnt(pagevo.getSearch_word());
		System.out.println(tcnt+"건 가져옴");
		pagevo.setTotalCount(tcnt);
		pagevo.calcPage();
		
		pagevo.prt();
		
		
		
		
		
		List<ComunityBoardVO> allList = comunityboardsrv.listAll(pagevo);
	//	System.out.println(allList.size() +"건 가져왔습니다.");
		model.addAttribute("cList", allList);
		model.addAttribute("pageVO", pagevo);
		return "comunityboard_view";
	}
	
	@RequestMapping(value = "/input_comunityboard", method = RequestMethod.GET)
	public String input_comunityboard(Locale locale, Model model, HttpSession f) {
		String userName = (String) f.getAttribute("nowUser");
		
		//Object loginInfo = f.getAttribute("nowUser");
		if(userName == null) {
			model.addAttribute("msg", false);
		}

		return "input_comunityboard";
	}	
	
	@RequestMapping(value = "/input_comunityboard_save", method = RequestMethod.POST)
	public String input_comunityboard_save(Locale locale, Model model, @ModelAttribute("comunity")ComunityBoardVO vo,
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
		
				
		comunityboardsrv.insertOne(vo); //메서드명 수정결과 첨부파일은 배열로 저장되어있다.<기억!!>
   		
		return "redirect:/list_comunityboard";
	}
	
	@RequestMapping(value = "/comunityboard_detail", method = RequestMethod.GET)
	public String comunityboard_detail(Locale locale, Model model,
			@RequestParam("viewno") Integer viewno) throws Exception {
	
		model.addAttribute("viewvo", comunityboardsrv.view_comunityboard(viewno));
		
		// 댓글 조회
		List<ReplyVO> reply = null;
		reply = replysrv.list(viewno);
		model.addAttribute("reply", reply);
	
		
		return "comunityboard_viewform";  //뷰가 아니라 다른 매핑으로 리다이렉트.
	}
	
	@RequestMapping(value = "/deleteComunityboard", method = RequestMethod.GET)
	public String deleteComunityboard(Locale locale, Model model,
			@RequestParam("deltitle") Integer delno) throws Exception {
		
	
		//삭제기능 컨트롤러.. 쿼리 : delete from schedule where num=delno;
		comunityboardsrv.del_comunityboard(delno);
		
		
		return "redirect:/list_comunityboard";  //뷰가 아니라 다른 매핑으로 리다이렉트..
	}
		
	@RequestMapping(value = "/modComunityboard", method = RequestMethod.GET)
	public String modComunityboard(Locale locale, Model model,
			@RequestParam("modno") Integer modno) throws Exception {

		model.addAttribute("modvo", comunityboardsrv.mod_comunityboard(modno));		
		return "comunityboard_modform";  //뷰가 아니라 다른 매핑으로 리다이렉트..
	}
	
	@RequestMapping(value = "/modComunityboard_pro", method = RequestMethod.POST)
	public String modComunityboard_pro(Locale locale, Model model,
			@ModelAttribute("comunity")ComunityBoardVO vo,MultipartFile file) throws Exception {
		
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
		
				
		
		comunityboardsrv.mod_comunityboard(vo);
		return "redirect:/list_comunityboard";  //뷰가 아니라 다른 매핑으로 리다이렉트..
	}
	
	


}
