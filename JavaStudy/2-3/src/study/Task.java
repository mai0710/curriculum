package study;

//① TaskクラスにCalculatorクラスを継承させなさい。

class Task extends Calculator{
/**
 * タスクの実行
 */
	public void doTask() {

    // ② Calculator.javaのすべてのオーバーロードメソッド「plus」に適当な引数を与え、下記画像のよう出力されるようコーディングしなさい。
    // 尚、「どのクラスから呼び出しているか」を明確にするため、plus()には呼び出し元のキーワードを付与すること。
		
		int a = 10;
		int b = 19;
		int c = 70;
	
		System.out.println("pulsメソッドも引数が１つの場合：" + plus(a));
		System.out.println("pulsメソッドも引数が2つの場合：" + plus(a + b));
		System.out.println("pulsメソッドも引数が3つの場合：" + plus(a + b + c));
	}	
}