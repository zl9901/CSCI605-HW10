import java.util.*;
class Task implements Runnable{
		int curFloor;
		static int initialLocation=1;
		static int count=0;
		static Vector aVector=new Vector();
		
		public Task(int curFloor) {
			this.curFloor=curFloor;
		}
		public void run() {
			synchronized(aVector) {
				switch(this.curFloor) {
					case 1:
						//System.out.println("The passenger is on the first floor calling for elevator");
						
						break;
					case 2:
						System.out.println("The passenger is on the second floor calling for elevator");
						count+=1;
						if(count==1) {
							System.out.println("goes up  "+(curFloor-initialLocation)+"  layers");
							initialLocation=curFloor;
						}
						else if(count==2) {
							System.out.println("goes down  "+(initialLocation-curFloor)+"  layers");
							System.out.println("The elevator returns to the first floor successfully");
						}
						break;
					case 3:
						System.out.println("The passenger is on the third floor calling for elevator");
						count+=1;
						if(count==1) {
							System.out.println("goes up  "+(curFloor-initialLocation)+"  layers");
							initialLocation=curFloor;
						}
						else if(count==2) {
							System.out.println("goes up  "+(curFloor-initialLocation)+"  layers");
							System.out.println("The elevator returns to the first floor successfully");
						}
						break;
					case 4:
						System.out.println("the elevator is running now");
				}
				
			}
		}
	}