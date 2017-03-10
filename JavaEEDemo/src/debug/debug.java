package debug;

import dbProcess.UserCheck;

public class debug {

	public static void main(String[] args) {
		UserCheck usercheck=new UserCheck();
		/*if(usercheck.pwdcheck("admin", "1111")){
			System.out.println("pwd=1111");
		}
		if(usercheck.pwdcheck("admin", "123456")){
			System.out.println("pwd=123456");
		}*/
		for(int i=1;i<999999;i++){
			String pwd=String.valueOf(i);
			if(usercheck.pwdcheck("admin", pwd)){
				System.out.println("pwd="+pwd);
				break;
			}
		}
	}

}
