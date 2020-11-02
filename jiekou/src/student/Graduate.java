package student;

import java.util.Scanner;
 
/**
 * 研究生类
 * @author Administrator
 *
 */
public class Graduate implements StudentInterface,TeacherInterface{
	// 成员变量
	String name;
	String sex;
	int age;
	double fee;
	double pay;
	
	// 实现接口中的抽象方法
	@Override
	public void setPay(double pay) {
		this.pay = pay * 12;
		System.out.println("你的年收入为：" + this.pay);
	}
	
	// 实现接口中的抽象方法
	@Override
	public void getPay(double pay) {
		this.pay = pay * 12;
		System.out.println("你的月收入为：" + this.pay);
	}
	
	// 实现接口中的抽象方法
	@Override
	public void setFee(double fee) {
		this.fee = fee;
		System.out.println("你的学费设置为：" + this.fee);
	}
	
	// 实现接口中的抽象方法
	@Override
	public void getFee(double fee) {
		this.fee = fee;
		System.out.println("你的学费为：" + this.fee);
	}
	
	/**
	 *  是否要缴纳税款
	 * @return
	 */
	public boolean Loan(){
		if ((this.pay - this.fee) <42000) {
			System.out.println("你的年收入" + this.pay + ",减去学费" + this.fee + "等于" + (this.pay - this.fee));
			return true;
		}
		System.out.println("你的年收入" + this.pay + ",减去学费" + this.fee +",减去"+ 42000 + ",乘" + 0.03 + "等于" + (this.pay - this.fee - 3500)*0.03);
		return false;
	}
	public static void main(String[] args) {
		// 创建一个研究生对象
		Graduate graduate = new Graduate();
		// 研究生对象的初始化
		graduate.name = "zhangsan";
		System.out.println("你好:" + graduate.name);
		
		try (// 设置月工资
		Scanner input = new Scanner(System.in)) {
			System.out.println("请输入你的月工资：");
			double pay = input.nextDouble();
			graduate.setPay(pay);
			
			// 设置学费
			System.out.println("请输入你的学费：");
			double fee = input.nextDouble();
			graduate.setFee(fee);
		    input.close();
		}
		// 判断是否缴纳税款
		boolean flag = graduate.Loan();
		if (flag) {
			System.out.println("(无需纳税)");
		}else {
			System.out.println("你需要纳税");
		}
	}
 
}