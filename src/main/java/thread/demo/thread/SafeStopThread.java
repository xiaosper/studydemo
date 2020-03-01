package thread.demo.thread;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yumingxiao1
 * @Date 2019/12/18
 * @since 1.0.0
 */
public class SafeStopThread {

    public static void main(String[] args){
        ThreadDemo threadDemo=new SafeStopThread().new ThreadDemo();
        new Thread(threadDemo).start();

        Thread t2=new Thread(()->{
            try {
                Thread.sleep(1000);
                threadDemo.terminateThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();


    }

    class ThreadDemo implements Runnable{
        private  volatile boolean stop=false;
        @Override
        public void run() {
            while(!stop){
                System.out.println("线程在执行.......");
            }
            System.out.println("线程终止.....");
        }

        /**
         * 终止线程
         */
        public void terminateThread(){
            stop=true;
        }
    }
}
