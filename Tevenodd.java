import java.util.*;
class Tevenodd
{
	int counter = 1;
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();

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
 		System.out.print("Enter the number :");	
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
