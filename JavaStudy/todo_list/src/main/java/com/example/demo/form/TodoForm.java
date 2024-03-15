package com.example.demo.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
/**
 * Tdo情報 リクエストデータ
 */
@Data
public class TodoForm {
  /**
   * ID
   */
  private Integer id;
  
  /**
   * todo
   */
  @NotEmpty(message = "Todoを入力してください")
  @Size(max = 50, message = "Todoは50文字以内で入力してください")
  private String todo;
  /**
   * 担当者
   */
  @NotEmpty(message = "担当者を入力してください")
  @Size(max = 50, message = "担当者は15文字以内で入力してください")
  private String person;
  /**
   * ステータス
   */
  @NotEmpty(message = "ステータスを入力してください")
  @Size(max = 50, message = "ステータスは15文字以内で入力してください")
  private String status;
  /**
   * メモ
   */
  @Size(max = 50, message = "メモは50文字以内で入力してください")
  private String memo;
	
}