package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.TodoEntity;
import com.example.demo.form.TodoForm;
import com.example.demo.service.TodoService;

/**
 * Todo情報 Controller
 */
@Controller
public class TodoController {

	/**
	 * Todo情報 Service
	 */
	@Autowired
	TodoService todoService;
	/**
	 * Todo情報一覧画面を表示
	 * @param  model Model
	 * @return  Todo情報一覧画面のHTML
	 */
	@GetMapping("/todo/list")
	public String todotList(Model model) {
		List<TodoEntity> todolist = todoService.searchAll();
		model.addAttribute("todolist", todolist);
		return "todo/list";
	}
	/**
	 * Todo新規登録画面を表示
	 * @param  model Model
	 * @return  Todo情報一覧画面
	 */
	@GetMapping("/todo/add")
	public String todoRegister(Model model) {
		model.addAttribute("todoRequest", new TodoForm());
		return "todo/add";
	}
	/**
	 * Todo新規登録
	 * @param  todoRequest リクエストデータ
	 * @param  model Model
	 * @return  Todo情報一覧画面
	 */
	@PostMapping("todo/create")
	public String todoCreate(@Validated  @ModelAttribute  TodoForm todoRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("todoRequest", new TodoForm());
			model.addAttribute("validationError", errorList);
			return "todo/add";
		}
		// Todo情報の登録
				todoService.create(todoRequest);
				return "redirect:/todo/list";
			}	
	/**
	 * Todo情報詳細画面を表示
	 * @param  id 表示するTodoID
	 * @param  model Model
	 * @return  Todo情報詳細画面
	 */
	@GetMapping("/todo/{id}")
	public String todoDetail(@PathVariable  Integer id, Model model) {
		TodoEntity todo = todoService.findById(id);
		model.addAttribute("todo", todo);
		return "todo/detail";
	}
	/**
	 * Todo編集画面を表示
	 * @param  id 表示するTodoID
	 * @param  model Model
	 * @return  Todo編集画面
	 */
	@GetMapping("/todo/{id}/edit")
	public String todoEdit(@PathVariable  Integer id, Model model) {
		TodoEntity todo = todoService.findById(id);
		TodoForm todoUpdateRequest = new TodoForm();
		todoUpdateRequest.setId(todo.getId());
		todoUpdateRequest.setTodo(todo.getTodo());
		todoUpdateRequest.setPerson(todo.getPerson());
		todoUpdateRequest.setStatus(todo.getStatus());
		todoUpdateRequest.setMemo(todo.getMemo());
		model.addAttribute("todoUpdateRequest", todoUpdateRequest);
		return "todo/edit";
	}
	/**
	 * Todo更新
	 * @param  todoRequest リクエストデータ
	 * @param  model Model
	 * @return  Todo情報詳細画面
	 */
	@PostMapping("/todo/update")
	public String todoUpdate(@Validated  @ModelAttribute  TodoForm todoUpdateRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
		    model.addAttribute("TodoUpdateRequest", todoUpdateRequest);
			return "todo/edit";
		}
		// 科目情報の更新
				todoService.update(todoUpdateRequest);
				return String.format("redirect:/todo/%d", todoUpdateRequest.getId());
			}
	 /**
		 * Todo情報削除
		 * @param  id 表示するID
		 * @param  model Model
		 * @return  Todo情報詳細画面
		 */
		@GetMapping("/todo/{id}/delete")
		public String todoDelete(@PathVariable Integer id, Model model) {
			// Todo情報の削除
			todoService.delete(id);
			return "redirect:/todo/list";
		}
	
}