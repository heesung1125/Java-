package Package001;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class mainclass {
	public static String marginCheck(String inputVal) {// 입력값 공백 제거
		 inputVal = inputVal.replace(" ", ""); 
		 return inputVal;
			 }
	
	   public static boolean starWithNotNumeric(String inputVal) {// 첫문자 검사 (숫자인지 기호인지)
		   Pattern p = Pattern.compile("^[0-9]*[\\+\\-\\*\\/]*[0-9]*=$");
		   Matcher m = p.matcher(inputVal);
		   
	      boolean a1 = m.matches(); //입력값 맨처음이 숫자이면 true 숫자가 아니면 false
	      return a1;
	   }
	
	public static String[] splitWithSign(String inputVal) {// 연산자 기준으로 계산해야 될 값 자르기
		String[] splitValues = inputVal.split("[\\+\\-\\*\\/\\=]");
		return splitValues;
	}
	
	public static String[] splitWithSign2(String inputVal) {// 문자열을 지정된 패턴으로 잘라서 배열로 반환하는 메소드(숫자를 기준으로 연산자 배열 반환)
		 String[] abcd = inputVal.split("[0-9*0-9]") ;
		 return abcd;
	}
	
	public static int[] stringArrToIntegerArr(String[] splitValues) {//splitValues의 배열 주소값을 기준으로 숫자형 num 배열변수 주소생성
		int [] num = new int[splitValues.length];	
		 	for(int cnt=0; cnt<splitValues.length; cnt++){ 
		 		try{
		 			num[cnt]= Integer.parseInt(splitValues[cnt]);
		 		}catch (java.lang.NumberFormatException e) { // 입력값 범위 초과시 에러메세지 안내
		 			System.out.println("입력값 범위 초과.(-2,147,483,648~2,147,483,647)");
		 			System.out.println("계산식을 다시 입력해 주세요");
		 			continue;
				}
		 	}
		return num;
	}
	
	public static char PopSign(String inputVal) {//계산해야 될 연산자 검사
		char sign = '+';
	 	char[] signArray = {'+','-','*','/'}; // for문에서 검사해야 될 연산자 배열
	 	for(int i=0; i<signArray.length; i++){		// inputVal에 입력된 연산자 검사 후 sign 변수에 저장
	 		int signOrder = inputVal.indexOf(signArray[i]);
	 		if(signOrder <0){	// 
	 			continue;
	 		}
	 		sign = inputVal.charAt(signOrder);
	 	}
	 	return sign;
	}

	public static boolean blockDivideByZero(int num, char sign) {// 0으로 나누기 금지 검사
		 if((num) == 0 && sign == '/'){
			 System.out.println("0으로 나누기는 불가능 합니다. 다시 입력해주세요!!!");
			 return true; // 0으로 나누는 상황이면 true 아니면 false
		 }
		 return false;
	}
	
	public static void calc(int[] num, char sign) {// 입력받은 값 계산
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

	public static boolean exit(String inputVal) {//종료 질문
	 	boolean yesno =true;
//	 	 if 문 사용하여 종료
//		 	if(inputVal.equals("y") || inputVal.equals("Y")){
//			yesno = true;
//	 		continue;
//	 	}else if(inputVal.equals("n") || inputVal.equals("N")){
//	 		yesno = false;
//	 		break;
//	 	}
	 	
//		switch 문 사용하여 종료	 	
	 	switch (inputVal) {
			case "y":
			case "Y": 
				System.out.println("재실행 합니다.");
				yesno = true;
				break;
			case "n":
			case "N": 
				System.out.println("종료 하겠습니다.");
				yesno = false;
				break;
	 	}
		return yesno;
	}
	
	public static String scan1(String inputVal) {//값 입력 받기
		 Scanner scan = new Scanner(System.in);
		 return inputVal = scan.nextLine();
		 
	}
	
	public static void main(String[] args) {
		String inputVal = new String();
		boolean yesno = true;
	    do{
		 System.out.println("ex)1+2= ");
		 System.out.print("계산식을 입력해 주세요: ");
		 // 값을 입력 받는 메소드
		 inputVal = scan1(inputVal);
		 
		 //입력값 검증 메소드
		 inputVal = marginCheck(inputVal);
		 
		 // 숫자를 제외한 기호로 로 시작하면 true를 반환하는 메소드		 
		 if( starWithNotNumeric(inputVal) != true ){  
			 System.out.println("입력 값이 잘 못 되었습니다.");
			 System.out.println("계산식을 다시 입력해 주세요");
			 continue;
		 }
		 // 문자열을 지정된 패턴으로 잘라서 배열로 반환하는 메소드
		 // +-*/연산자를 기준으로 계산값 나누기
		 String[] splitValues = splitWithSign(inputVal);
		 
		 // 문자열을 지정된 패턴으로 잘라서 배열로 반환하는 메소드
		 // 숫자를 기준으로 +-*/= 을 배열 반환
		 //String[] splitValues1 = splitWithSign(inputVal);
		 
	 	 // 문자열 인 splitValues변수의 값을 숫자형으로 변환 후 num 배열변수에 반환 하는 메소드
		 int[] num = stringArrToIntegerArr(splitValues);
	 		
		 //inputVal에 입력된 연산자 검사 후 sign 변수에 반환하는 메소드
		 char sign = PopSign(inputVal);
		 	
		 // 입력 받은 값을 계산 후 결과를 출력해주는 메소드
		 
		 //0으로 나누기를 방지하기 위한 메소드
		if( blockDivideByZero(num[1],sign) ) continue;

		// 계산식 메소드 calc
		calc(num, sign);
		
		//프로그램 종료 질의
	 	System.out.println("계속 하시겠습니까? (y/n)");
	 	inputVal = scan1(inputVal);

	 	// 종료 확인 메소드
	 	yesno = exit(inputVal);

		} while(yesno);
		System.out.println("종료 되었습니다.");
	}
	
}