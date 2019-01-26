// Associated file: StopWatchUI.java

public class StopWatch
{
    private	double		elapsed = 0;
    private	boolean		running = false;
    private	long		startTime = 0;

    public void reset()
    {
        if (!running)
            elapsed = 0;
    }

    public void time()
    {
        if (running)
        {
            long	endTime = System.currentTimeMillis();

            elapsed += endTime - startTime;
            running = false;
        }
        else
        {
            startTime = System.currentTimeMillis();
            running = true;
        }
    }

    public double getElapsed()
    {
        return elapsed / 1000.0;
    }

    public boolean isRunning()
    {
        return running;
    }
}
