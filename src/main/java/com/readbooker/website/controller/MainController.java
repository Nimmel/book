package com.readbooker.website.controller;

//import com.waylau.spring.boot.blog.domain.Authority;
//import com.waylau.spring.boot.blog.domain.User;
//import com.waylau.spring.boot.blog.service.AuthorityService;
//import com.waylau.spring.boot.blog.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.readbooker.website.model.entity.User;
import com.readbooker.website.model.vo.ResultInfo;
import com.readbooker.website.service.BookService;
import com.readbooker.website.service.UserService;
import com.readbooker.website.util.CookieUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 主页控制器
 */
@Slf4j
@Controller
public class MainController {

	private static final Long ROLE_USER_AUTHORITY_ID = 2L;

	@Autowired
	private UserService userService;


  @Autowired(required=false)
  private BookService bookService;

//	@Autowired
//	private HttpServletResponse response;

//
//	@Autowired
//	private AuthorityService  authorityService;

	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}

	@GetMapping("/index")
	public String index(Model model) {
	  model.addAttribute("hotClicks",bookService.findTopsClickBooks(null,4));
    // 准备数据：首页默认不指定小说类型展示
    model.addAttribute("hotRecoms",bookService.findTopsRecommentBooks(null,10));
		return "index";
	}

	/**
	 * 获取登录界面
	 * @return
	 */
	@GetMapping("/login")
	public String loginGet() {
		return "login";
	}

	@PostMapping("/login")
	public String loginPost(HttpServletRequest request,HttpServletResponse response) {
		// 获取请求参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		// 检查登陆数据
		if(userService.checkUserPassword(username,password)){
			//登录成功标记
			request.getSession().setAttribute("user",username);
			CookieUtil.addCookie(response,"username",username,100);
		}
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
		return "login";
	}

	@GetMapping("/register_ok")
	public String registerOk() {
		return "register_ok";
	}


	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	/**
	 * 注册用户
	 * @return
	 */
	@PostMapping("/register")
	public void registerUser(HttpServletResponse response,User user) throws IOException {
		// 检查用户名是否存在
		ResultInfo retInfo = null;
		if(!userService.checkUserExist(user.getUsername())){
				userService.saveUser(user);
				retInfo = new ResultInfo(true,"注册成功");
		} else {
			String msg = String.format("注册失败，用户名(%s)已存在",user.getUsername());
			retInfo = new ResultInfo(false,msg);
		}
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(retInfo);
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(json);
	}

	@GetMapping("/search")
	public String search() {
		return "search";
	}

}
