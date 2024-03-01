
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.form.TodoForm;
import com.example.demo.repository.TodoRepository;

/**
 * 科目情報 Service
 */
@Service
public class TodoService {
	/**
	 * Todo情報 Repository
	 */
	@Autowired
	private TodoRepository todoRepository;

	/**
	 * Todo情報 全検索
	 * @return  検索結果
	 */
	public List<TodoEntity> searchAll() {
		return todoRepository.findAll();
	}
	/**
	 * Todo情報 新規登録
	 * @param  todo Todo情報
	 */
	public void create(TodoForm todoRequest) {
		TodoEntity todo = new TodoEntity();
		todo.setTodo(todoRequest.getTodo());
		todo.setPerson(todoRequest.getPerson());
		todo.setStatus(todoRequest.getStatus());
		todo.setMemo(todoRequest.getMemo());
		todoRepository.save(todo);
	}
	/**
	 * Todo情報 主キー検索
	 * @return  検索結果
	 */
	public TodoEntity findById(Integer id) {
		return todoRepository.getOne(id);
	}
	
	/**
	 * 科Todo情報 更新
	 * @param  todo Todo情報
	 */
	public void update(TodoForm todoUpdateRequest) {
		TodoEntity todo = findById(todoUpdateRequest.getId());
		todo.setTodo(todoUpdateRequest.getTodo());
		todo.setPerson(todoUpdateRequest.getPerson());
		todo.setStatus(todoUpdateRequest.getStatus());
		todo.setMemo(todoUpdateRequest.getMemo());
		todoRepository.save(todo);
	}
	/**
	 * Todo情報 物理削除
	 * @param  id ID
	 */
	public void delete(Integer id) {
		TodoEntity todo = findById(id);
		todoRepository.delete(todo);
	}
}