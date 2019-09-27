package Software.niit;

public class CLassVar {
	private int i=0;
	private static int j=0;
	public void print() {
		System.out.println("i="+i);
		System.out.println("j="+j);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CLassVar lv1=new CLassVar();
		lv1.i++;
		lv1.j++;
		lv1.print();
		CLassVar lv2=new CLassVar();
		lv2.print();
	}

}
