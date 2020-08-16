import java.util.concurrent.ThreadFactory;

public class Elevator implements ThreadFactory {
	public String name;

	public Elevator() {
		
	}
	
	public Elevator(String name) {
		this.name=name;
	}
	
	@Override
	public Thread newThread(Runnable runnable) {
		// TODO Auto-generated method stub
		Thread t=new Thread(runnable);
		return t;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Elevator hp=new Elevator("ElevatorOperation");
		//Task task=new Task();
		Thread thread;
		System.out.println("starting the threads");
		System.out.println("The elevator is on the first floor");
		for(int i=1;i<=4;i++) {
			thread=hp.newThread(new Task(i));
			thread.start();
		}
		System.out.println("all threads are created now");
	}

}
