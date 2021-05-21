import java.util.*;
class tevenodd
{
	int counter = 1;
	static int n;
	public void odd()
	{
		synchronized (this)
		{
			while (counter<n) 
			{
             while(counter%2==0)
              {
                    try {
                        wait();
                    }
                    catch (
                        InterruptedException e) {
                        e.printStackTrace();
                    }
                }
  
                System.out.print(counter + " ");
  	            counter++;
  	            notify();
            }
        }
    }
  
    public void even()
    {
        synchronized (this)
        {
            while (counter<n) {
  
                while (counter%2==1) 
                {
                	try 
                	{
                        wait();
                	}
                	catch(InterruptedException e) 
                    {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }
    public static void main(String[] args) {
 		Scanner sc = new Scanner(System.in);
 		System.out.print("Enter the numer :");
 		n = sc.nextInt();

 		tevenodd t = new tevenodd();
 		
 		Thread t1 = new Thread(new Runnable() {
            public void run()
            {
                t.even();
            }
        });   	
         Thread t2 = new Thread(new Runnable() {
            public void run()
            {
                t.odd();
            }
        });
        t1.start();
        t2.start();
  }
}
