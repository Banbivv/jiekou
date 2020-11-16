# jiekou  
接口异常处理实验  

# 阅读程序  

## 实验目的  
掌握Java中抽象类和抽象方法的定义；   
掌握Java中接口的定义，熟练掌握接口的定义形式以及接口的实现方法  
了解异常的使用方法，并在程序中根据输入情况做异常处理  

## 实验过程  
package student;  

/**
 * 学生接口
 * @author Administrator
 *
 */
public interface StudentInterface {  
	
	// 设置学生的学费
	public abstract void setFee(double fee);
	
	// 获取学生的学费
	public abstract void getFee(double fee);
}


package student;  

/**
 * 教师接口
 * @author Administrator
 *
 */
public interface TeacherInterface {  
	
	// 设置教师的工资
	public abstract void setPay(double pay);
	
	// 获取教师的工资
	public abstract void getPay(double pay);
}


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
		try {
			System.out.println("你好:" + graduate.name);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	
	 try(// 设置月工资
		Scanner input = new Scanner(System.in)) {
			try {
				System.out.println("请输入你的月工资：");
			} catch (Exception e) {
				// TODO: handle exception
			}
			double pay = input.nextDouble();
			graduate.setPay(pay);
			
			// 设置学费
			try {
				System.out.println("请输入你的学费：");
			} catch (Exception e) {
				// TODO: handle exception
			}
			double fee = input.nextDouble();
			graduate.setFee(fee);
		    input.close();
		}
		
		// 判断是否缴纳税款
		boolean flag = graduate.Loan();
		if (flag) {
			try {
				System.out.println("(无需纳税)");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}else {
			try {
				System.out.println("你需要纳税");
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
 
}


## 实验结果  
图片已上传  


## 核心方法  
设计两个信息管理接口StudentInterface和TeacherInterface。  
其中,StudentInterface接口包括setFee方法和getFee方法,分别用于设置和获取学生的学费;  
TeacherInterface接口包括setPay方法和getPay方法,分别用于设置和获取教师的工资  
定义一个研究生类Graduate,实现StudentInterface接口和TeacherInterface接口,它定义的成员变量有name(姓名)、sex(性别)、age(年龄)、fee(每学期学费)、pay(月工资)。  
创建一个叫张三的博士研究生,统计他的年收入和学费,进行对他纳税的多少.  

## 实验感想  
更加掌握Java中抽象类和抽象方法的定义；   
学会Java中接口的定义，熟练掌握接口的定义形式以及接口的实现方法  
了解异常的使用方法，并在程序中根据输入情况做异常处理  
根据实验要求一步一步完成,不是很熟练的上网查的过程中更加全面了解了这个项目.  
