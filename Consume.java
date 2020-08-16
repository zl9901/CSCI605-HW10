import java.util.Vector;
import java.util.Random;
public class Consume extends Thread {
	String info;
	static int length;
	int consumenum;
	static int producenum;
	static int emptyspace=10;
	static private 	Vector aVector = new Vector();
	static int count=0;
	static int count1=0;
	static int MAX=3;
	static int MIN=1;
	public Consume() {
		
	}
	
	public Consume(String info,int length,int consumenum,int producenum) {
		this.info=info;
		this.length=length;
		this.consumenum=consumenum;
		this.producenum=producenum;
	}
	
	public void isProtected2() {
		synchronized ( aVector ){
			Random random=new Random();
			int randNumber =random.nextInt(MAX - MIN + 1) + MIN;
			
			if(randNumber==1) {
			this.consumenum=3;
			count1+=1;
			System.out.println("count1:"+count1);
			if(count1==500) System.exit(1);
			aVector.notifyAll();
			while(length-emptyspace>=this.consumenum) {
					System.out.println("consume "+this.consumenum+" items");
					emptyspace+=this.consumenum;
					if( emptyspace>=producenum ) {
						break;
					}
			}
				try {
					aVector.wait();
					isProtected2();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			
			
			else if(randNumber==2) {
				this.consumenum=5;
				count1+=1;
				System.out.println("count1:"+count1);
				if(count1==500) System.exit(1);
				aVector.notifyAll();
				while(length-emptyspace>=this.consumenum) {
						System.out.println("consume "+this.consumenum+" items");
						emptyspace+=this.consumenum;
						if( emptyspace>=producenum ) {
							break;
						}
				}
					try {
						aVector.wait();
						isProtected2();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
			
			
			
			
			else {
				this.consumenum=2;
				count1+=1;
				System.out.println("count1:"+count1);
				if(count1==500) System.exit(1);
				aVector.notifyAll();
				while(length-emptyspace>=this.consumenum) {
						System.out.println("consume "+this.consumenum+" items");
						emptyspace+=this.consumenum;
						if( emptyspace>=producenum ) {
							break;
						}
				}
					try {
						aVector.wait();
						isProtected2();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
	

	public void isProtected1() {
			synchronized ( aVector ){
				count+=1;
				System.out.println("count:"+count);
				if(count==500) System.exit(1);
				aVector.notifyAll();
				while(emptyspace>=producenum) {
						System.out.println("produce "+producenum+" items");
						emptyspace-=producenum;
						if(length-emptyspace>=2) {
							break;
						}
				}
					try {
						aVector.wait();
						isProtected1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
	}
	


	public void run() {
		if(this.info.equals("producer")) {
			isProtected1();
		}else {
			isProtected2();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Vector aVector = new Vector();
		length=Integer.parseInt(args[0]);
		Consume addc[]=new Consume[1200];
		Consume addp[]=new Consume[1200];
		for(int index=0;index<1200;index++) {
			addc[index]=new Consume("consumer",length,3,4);
			addp[index]=new Consume("producer",length,3,4);
			addc[index].start();
			addp[index].start();
		}
		
			
		
		
	}
}
