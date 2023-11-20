package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserService;
/**
 * ユーザー情報 Controller
 */
@Controller

public class UserController {
	 /**
	   * ユーザー情報 Service
	   */
	  //2行追加
	@Autowired
    private UserService userService; 
	  /**
	   * ユーザー情報一覧画面を表示
	   * @param  model Model
	   * @return  ユーザー情報一覧画面のHTML
	   */
	  @RequestMapping("/user/list")
		public String displayList(Model model) {

	    //3行追加
		  // バックエンドからユーザー情報を取得
	        List<User> userList = userService.searchAll();

	        // モデルにユーザーリストをセット
	        model.addAttribute("userlist", userList);

	        return "user/list"; // ユーザー情報一覧画面のHTMLテンプレートの名前



	  }
}
