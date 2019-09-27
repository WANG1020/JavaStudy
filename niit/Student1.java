package Software.niit;

public class Student1 extends Person1{
	private String no;
	private double scoreOfEn;
	private double scoreOfMath;
	private double ScoreOfCh;
	public Student1(String name,String no, double scoreOfEn, double scoreOfMath, double scoreOfCh) {
		super(name);
		this.no = no;
		this.scoreOfEn = scoreOfEn;
		this.scoreOfMath = scoreOfMath;
		ScoreOfCh = scoreOfCh;
	}
	private double getAver() {
		double ave=0.0;
		ave=scoreOfEn+scoreOfMath+ScoreOfCh;
		return ave/3;
	}
	private double maxScore() {
		double maxscore=0;
		if(maxscore<scoreOfMath){
			maxscore=scoreOfMath;
		}
		else if(maxscore<ScoreOfCh){
			maxscore=ScoreOfCh;
		}
		else {
			maxscore=scoreOfEn;
		}
		return maxscore;
	}
	private double minScore() {
		double minscore=scoreOfMath;
		if(minscore>scoreOfEn) {
			minscore=scoreOfEn;
		}
		else {
			minscore=ScoreOfCh;
		}
		return minscore;
	}
	public String toString() {
		String string;
		string ="学号:"+no+"姓名:"+super.getName()+"性别:"+super.getSex()+"年龄:"
		+super.getAge()+"平均分:"+getAver()+"最高分:"+maxScore()+"最低分:"+minScore();
		return string;
	}
}
