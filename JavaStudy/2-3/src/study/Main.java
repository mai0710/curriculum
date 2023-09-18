package study;

/**
*
* 本課題では、継承・オーバーロードメソッドの基本的な使い方を学んでいきましょう。
* 課題は問①から問③まであります。
* 指定された値と変数名を守って記述してください。
*
* @author  s.nanaumi
*/

public class Main {
	
    public static void main(String[] args) {

        // ③ Taskクラスのインスタンスを生成し、「doTask()」メソッドを呼び出しなさい。
    	Task task1 = new Task(10);
    	Task task2 = new Task(10,20);
    	Task task3 = new Task(10,20,70);
    	
    	task1.doTask();
    	task2.doTask();
    	task3.doTask();
    }

}
