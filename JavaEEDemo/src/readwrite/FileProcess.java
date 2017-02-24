package readwrite;
/*
 * 字符串方式写入,读取文件
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileProcess {

	public static boolean write(String location,Object content) {
		boolean success=false;
		File f=new File(location);
		boolean flag=false;
		if(content instanceof String){}
		else if(content instanceof Integer){
			content=(String)content;
		}
//		else(content instanceof Byte){
//			content=(String)content;
//		}
		if(f.exists()){
			FileOutputStream fos=null;
			try {
				fos=new FileOutputStream(f);
				fos.write(String.valueOf(content).getBytes());
				fos.flush();
			} catch (FileNotFoundException e3) {
				e3.printStackTrace();
				return false;
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			finally{
				if(fos!=null){
					try {
						fos.close();
						success=true;
					} catch (IOException e) {
						e.printStackTrace();
						return false;
					}
				}
			}
		}
		else{
				try {
					flag=f.createNewFile();
				} catch (IOException e1) {
					e1.printStackTrace();
					return false;
				}
				finally{
					if (flag==true){
						System.out.println("文件创建成功");
					}
				}
				FileOutputStream fos=null;
				try {
					fos=new FileOutputStream(f);
					fos.write(String.valueOf(content).getBytes());
					fos.flush();
				} catch (FileNotFoundException e3) {
					e3.printStackTrace();
					return false;
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
				finally{
					if(fos!=null){
						try {
							fos.close();
					} catch (IOException e) {
						e.printStackTrace();
						return false;
						}
					}	
				}
				System.out.println("文件写入成功");
				success=true;
			}
		return success;
		}
	public static String read(String location) {
		String content="";
		File f= new File(location);
		FileInputStream fis=null;
		if(f.exists()){
			try {
				fis=new FileInputStream(f);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			byte b[]=new byte[128];
			int i=0;
			try {
				while((i=fis.read(b))!=-1){
					content+=new String(b,0,i);
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
		
	}
}
