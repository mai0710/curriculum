package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.service.AttendanceListService;

/**
 * ユーザー情報 Controller
 */
@Controller
public class AttendanceListController {

  /**
   * ユーザー情報 Service
   */
  @Autowired
  private AttendanceListService attendanceListService;

  /**
   * ユーザー情報一覧画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/attendanceList/list")
  public String displayList(Model model) {
    List<AttendanceList> attendanceList = AttendanceListService.searchAll();
    model.addAttribute("attendanceList", attendanceList);
    return "attendanceList/list";
  }

  /**
   * ユーザー新規登録画面を表示
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @GetMapping(value = "/attendanceList/add")
  public String displayAdd(Model model) {
    return "attendanceList/add";
  }

  /**
   * ユーザー情報詳細画面を表示
   * @param id 表示するユーザーID
   * @param model Model
   * @return ユーザー情報詳細画面
   */
  @GetMapping("/attendanceList/{id}")
  public String displayView(@PathVariable Long id, Model model) {
    return "attendanceList/view";
  }
}