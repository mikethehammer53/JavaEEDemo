package com.user.reg;


import java.io.Serializable;
import java.util.Date;
//import java.util.Scanner;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3066821707838706520L;
	//账户权限等级
	private String identity="学生";
	private int accesslvl=1;
	//账户属性
	private String name;
	private String num;
	private String sex;
	private String age;
	private Date birth;
	private String addr;
	private String password;
	//科目成绩
	private float chinese;
	private float math;
	private float english;
	private float physics;
	private float chemistry;
	private float biology;
	private float history;
	private float geography;
	private float politics;
	public static float grades[]=new float[9];
    public static String subjectName[]={"语文","数学","英语","物理","化学","生物","历史","地理","政治"};
	public Student(){}
	public Student(String name,String num){
		this.name=name;
		this.num=num;
	}
	@Override
	public String toString() {
		return "[姓名:" + name + ", 学号:" + num + ", 性别:" + sex + ", 年龄:" + age + ", 生日:" + birth
				+ ", 住址:" + addr + "]";
	}
	//查看基本属性
	@SuppressWarnings("deprecation")
	public void view(){
		System.out.println("姓名:"+name);
		System.out.println("学号:"+num);
		System.out.println("性别:"+sex);
		System.out.println("密码:"+password);
		if(birth==null) return;
		age=String.valueOf(new Date().getYear()-birth.getYear());
		System.out.println("年龄:"+age);
		System.out.println("出生年月:"+(birth.toLocaleString()).split(" ")[0]);
		System.out.println("住址:"+addr);
		System.out.println("身份:"+identity);
	}
	//设置成绩
	/*public void setGrades(){
		@SuppressWarnings("resource")
		Scanner input=new Scanner(System.in);
		System.out.println("请输入各科目成绩");
		for(int i=0;i<=8;i++){
			float f=-1;
			System.out.print("请输入"+subjectName[i]+"成绩");
			if((f=input.nextFloat())>=0){
				grades[i]=f;	
			}
		}
	}*/
	//查看成绩
	public void viewGrades(){
		double sum=0;
		int sums=0;
		for(int l=0;l<=6;l+=3){
			switch(l){
			case 0:System.out.println("通识");
			case 3:System.out.println("理科");
			case 6:System.out.println("文科");
			for(int i=0;i<=2;i++){
				if(grades[i+l]>=0){
					System.out.print(subjectName[i+l]+"\t");
				}
			}
			System.out.println("平均成绩");
			System.out.println();
			for(int i=0;i<=2;i++){
				if(grades[i+l]>=0){
					System.out.print(grades[i+l]+"\t");
					sum+=grades[i+l];
					sums++;
				}
			}
			System.out.println(sum/sums);
			}
		}	
	}
	//setters&getters
	public String getName() {
		return name;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccseelvl() {
		return accesslvl;
	}
	public String getIdentity() {
		return identity;
	}
	public String getAge() {
		return age;
	}
	public int getAccesslvl() {
		return accesslvl;
	}
	public float getChinese() {
		return chinese;
	}
	public void setChinese(float chinese) {
		this.chinese =grades[0]= chinese;
	}
	public float getMath() {
		return math;
	}
	public void setMath(float math) {
		this.math=grades[1] = math;
	}
	public float getEnglish() {
		return english;
	}
	public void setEnglish(float english) {
		this.english=grades[2] = english;
	}
	public float getPhysics() {
		return physics;
	}
	public void setPhysics(float physics) {
		this.physics = grades[3]=physics;
	}
	public float getChemistry() {
		return chemistry;
	}
	public void setChemistry(float chemistry) {
		this.chemistry = grades[4]=chemistry;
	}
	public float getBiology() {
		return biology;
	}
	public void setBiology(float biology) {
		this.biology = grades[5]=biology;
	}
	public float getHistory() {
		return history;
	}
	public void setHistory(float history) {
		this.history = grades[6]=history;
	}
	public float getGeography() {
		return geography;
	}
	public void setGeography(float geography) {
		this.geography = grades[7]=geography;
	}
	public float getPolitics() {
		return politics;
	}
	public void setPolitics(float politics) {
		this.politics = grades[8]=politics;
	}
	public float[] getGrades() {
		return grades;
	}
	public void setGrades(float[] grades) {
		this.grades = grades;
	}
	//(科目,成绩)方法设置成绩
	public void setGrades(String subject,float grade){
		switch(subject){
		case "chinese": case "语文":{
			chinese=grades[0]=grade;
		}
		case "math":case "数学":{
			math=grades[1]=grade;
		}
		case "english":case "英语":{
			english=grades[2]=grade;
		}
		case "physics":case "物理":{
			physics=grades[3]=grade;
		}
		case "chemistry":case "化学":{
			chemistry=grades[4]=grade;
		}
		case "biology":case "生物":{
			biology=grades[5]=grade;
		}
		case "history":case "历史":{
			history=grades[6]=grade;	
		}
		case "geography":case "地理":{
			geography=grades[7]=grade;			
		}
		case "politics":case "政治":{
			politics=grades[8]=grade;
		}
		default:{
			System.out.println("输入错误,请重试");
			break;
		}
	}
	

	
	

	}

}
