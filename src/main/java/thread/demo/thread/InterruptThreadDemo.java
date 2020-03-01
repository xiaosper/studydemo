package thread.demo.thread;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yumingxiao1
 * @Date 2019/12/18
 * @since 1.0.0
 */
public class InterruptThreadDemo {

    public static void main(String[] args){
        InterruptThread interruptThread=new InterruptThreadDemo().new InterruptThread("线程001");
        //运行线程
        interruptThread.start();
        Thread thread=new Thread(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //修改线程001的 中断标志位
            interruptThread.interrupt();
        });
        thread.start();
    }

    class InterruptThread extends Thread{

        public InterruptThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!isInterrupted()){
                System.out.println(this.getName()+" :正在运行。。。。。");
            }
            System.out.println(this.getName()+" :停止运行。。。。。");
        }
    }
}
