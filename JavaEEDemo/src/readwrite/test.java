package readwrite;

public class test {

	public static void main(String[] args) {
//		if(FileProcess.write("e:/ab.txt", "1234567890")){
//			System.out.println("write success!");
//		}
		String str;
		System.out.println(str=FileProcess.read("e:/ab.txt"));
		for(int i=0;i<str.length();i++){
			if(!Character.isDigit(str.charAt(i))){
				System.out.println("文件内容不是纯数字!");
				return;
			}
		}
		int i=Integer.parseInt(str);
		System.out.println(i);
	}

}
