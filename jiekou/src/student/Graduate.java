package student;

import java.util.Scanner;
 
/**
 * �о�����
 * @author Administrator
 *
 */
public class Graduate implements StudentInterface,TeacherInterface{
	// ��Ա����
	String name;
	String sex;
	int age;
	double fee;
	double pay;
	
	// ʵ�ֽӿ��еĳ��󷽷�
	@Override
	public void setPay(double pay) {
		this.pay = pay * 12;
		System.out.println("���������Ϊ��" + this.pay);
	}
	
	// ʵ�ֽӿ��еĳ��󷽷�
	@Override
	public void getPay(double pay) {
		this.pay = pay * 12;
		System.out.println("���������Ϊ��" + this.pay);
	}
	
	// ʵ�ֽӿ��еĳ��󷽷�
	@Override
	public void setFee(double fee) {
		this.fee = fee;
		System.out.println("���ѧ������Ϊ��" + this.fee);
	}
	
	// ʵ�ֽӿ��еĳ��󷽷�
	@Override
	public void getFee(double fee) {
		this.fee = fee;
		System.out.println("���ѧ��Ϊ��" + this.fee);
	}
	
	/**
	 *  �Ƿ�Ҫ����˰��
	 * @return
	 */
	public boolean Loan(){
		if ((this.pay - this.fee) <42000) {
			System.out.println("���������" + this.pay + ",��ȥѧ��" + this.fee + "����" + (this.pay - this.fee));
			return true;
		}
		System.out.println("���������" + this.pay + ",��ȥѧ��" + this.fee +",��ȥ"+ 42000 + ",��" + 0.03 + "����" + (this.pay - this.fee - 3500)*0.03);
		return false;
	}
	public static void main(String[] args) {
		// ����һ���о�������
		Graduate graduate = new Graduate();
		// �о�������ĳ�ʼ��
		graduate.name = "zhangsan";
		System.out.println("���:" + graduate.name);
		
		try (// �����¹���
		Scanner input = new Scanner(System.in)) {
			System.out.println("����������¹��ʣ�");
			double pay = input.nextDouble();
			graduate.setPay(pay);
			
			// ����ѧ��
			System.out.println("���������ѧ�ѣ�");
			double fee = input.nextDouble();
			graduate.setFee(fee);
		    input.close();
		}
		// �ж��Ƿ����˰��
		boolean flag = graduate.Loan();
		if (flag) {
			System.out.println("(������˰)");
		}else {
			System.out.println("����Ҫ��˰");
		}
	}
 
}