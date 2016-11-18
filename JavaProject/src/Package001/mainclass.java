package Package001;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class mainclass {
	public static String marginCheck(String inputVal) {// �Է°� ���� ����
		 inputVal = inputVal.replace(" ", ""); 
		 return inputVal;
			 }
	
	   public static boolean starWithNotNumeric(String inputVal) {// ù���� �˻� (�������� ��ȣ����)
		   Pattern p = Pattern.compile("^[0-9]*[\\+\\-\\*\\/]*[0-9]*=$");
		   Matcher m = p.matcher(inputVal);
		   
	      boolean a1 = m.matches(); //�Է°� ��ó���� �����̸� true ���ڰ� �ƴϸ� false
	      return a1;
	   }
	
	public static String[] splitWithSign(String inputVal) {// ������ �������� ����ؾ� �� �� �ڸ���
		String[] splitValues = inputVal.split("[\\+\\-\\*\\/\\=]");
		return splitValues;
	}
	
	public static String[] splitWithSign2(String inputVal) {// ���ڿ��� ������ �������� �߶� �迭�� ��ȯ�ϴ� �޼ҵ�(���ڸ� �������� ������ �迭 ��ȯ)
		 String[] abcd = inputVal.split("[0-9*0-9]") ;
		 return abcd;
	}
	
	public static int[] stringArrToIntegerArr(String[] splitValues) {//splitValues�� �迭 �ּҰ��� �������� ������ num �迭���� �ּһ���
		int [] num = new int[splitValues.length];	
		 	for(int cnt=0; cnt<splitValues.length; cnt++){ 
		 		try{
		 			num[cnt]= Integer.parseInt(splitValues[cnt]);
		 		}catch (java.lang.NumberFormatException e) { // �Է°� ���� �ʰ��� �����޼��� �ȳ�
		 			System.out.println("�Է°� ���� �ʰ�.(-2,147,483,648~2,147,483,647)");
		 			System.out.println("������ �ٽ� �Է��� �ּ���");
		 			continue;
				}
		 	}
		return num;
	}
	
	public static char PopSign(String inputVal) {//����ؾ� �� ������ �˻�
		char sign = '+';
	 	char[] signArray = {'+','-','*','/'}; // for������ �˻��ؾ� �� ������ �迭
	 	for(int i=0; i<signArray.length; i++){		// inputVal�� �Էµ� ������ �˻� �� sign ������ ����
	 		int signOrder = inputVal.indexOf(signArray[i]);
	 		if(signOrder <0){	// 
	 			continue;
	 		}
	 		sign = inputVal.charAt(signOrder);
	 	}
	 	return sign;
	}

	public static boolean blockDivideByZero(int num, char sign) {// 0���� ������ ���� �˻�
		 if((num) == 0 && sign == '/'){
			 System.out.println("0���� ������� �Ұ��� �մϴ�. �ٽ� �Է����ּ���!!!");
			 return true; // 0���� ������ ��Ȳ�̸� true �ƴϸ� false
		 }
		 return false;
	}
	
	public static void calc(int[] num, char sign) {// �Է¹��� �� ���
	 	long result=0;
	 	double result2=0;
	 	
	 	switch (sign) {
			case '+':
				result = (long)num[0] + (long)num[1];
				System.out.println(result);
				return;

			case '-':
				result = (long)num[0] - (long)num[1];
				System.out.println(result);
				return;
				
			case '*':
				result = (long)num[0] * (long)num[1];
				System.out.println(result);
				return;
				
			case '/':
				result2 = (double)num[0] / (double)num[1];
				System.out.println(result2);
				return;
		}
	}

	public static boolean exit(String inputVal) {//���� ����
	 	boolean yesno =true;
//	 	 if �� ����Ͽ� ����
//		 	if(inputVal.equals("y") || inputVal.equals("Y")){
//			yesno = true;
//	 		continue;
//	 	}else if(inputVal.equals("n") || inputVal.equals("N")){
//	 		yesno = false;
//	 		break;
//	 	}
	 	
//		switch �� ����Ͽ� ����	 	
	 	switch (inputVal) {
			case "y":
			case "Y": 
				System.out.println("����� �մϴ�.");
				yesno = true;
				break;
			case "n":
			case "N": 
				System.out.println("���� �ϰڽ��ϴ�.");
				yesno = false;
				break;
	 	}
		return yesno;
	}
	
	public static String scan1(String inputVal) {//�� �Է� �ޱ�
		 Scanner scan = new Scanner(System.in);
		 return inputVal = scan.nextLine();
		 
	}
	
	public static void main(String[] args) {
		String inputVal = new String();
		boolean yesno = true;
	    do{
		 System.out.println("ex)1+2= ");
		 System.out.print("������ �Է��� �ּ���: ");
		 // ���� �Է� �޴� �޼ҵ�
		 inputVal = scan1(inputVal);
		 
		 //�Է°� ���� �޼ҵ�
		 inputVal = marginCheck(inputVal);
		 
		 // ���ڸ� ������ ��ȣ�� �� �����ϸ� true�� ��ȯ�ϴ� �޼ҵ�		 
		 if( starWithNotNumeric(inputVal) != true ){  
			 System.out.println("�Է� ���� �� �� �Ǿ����ϴ�.");
			 System.out.println("������ �ٽ� �Է��� �ּ���");
			 continue;
		 }
		 // ���ڿ��� ������ �������� �߶� �迭�� ��ȯ�ϴ� �޼ҵ�
		 // +-*/�����ڸ� �������� ��갪 ������
		 String[] splitValues = splitWithSign(inputVal);
		 
		 // ���ڿ��� ������ �������� �߶� �迭�� ��ȯ�ϴ� �޼ҵ�
		 // ���ڸ� �������� +-*/= �� �迭 ��ȯ
		 //String[] splitValues1 = splitWithSign(inputVal);
		 
	 	 // ���ڿ� �� splitValues������ ���� ���������� ��ȯ �� num �迭������ ��ȯ �ϴ� �޼ҵ�
		 int[] num = stringArrToIntegerArr(splitValues);
	 		
		 //inputVal�� �Էµ� ������ �˻� �� sign ������ ��ȯ�ϴ� �޼ҵ�
		 char sign = PopSign(inputVal);
		 	
		 // �Է� ���� ���� ��� �� ����� ������ִ� �޼ҵ�
		 
		 //0���� �����⸦ �����ϱ� ���� �޼ҵ�
		if( blockDivideByZero(num[1],sign) ) continue;

		// ���� �޼ҵ� calc
		calc(num, sign);
		
		//���α׷� ���� ����
	 	System.out.println("��� �Ͻðڽ��ϱ�? (y/n)");
	 	inputVal = scan1(inputVal);

	 	// ���� Ȯ�� �޼ҵ�
	 	yesno = exit(inputVal);

		} while(yesno);
		System.out.println("���� �Ǿ����ϴ�.");
	}
	
}