package thread.demo;

import java.util.Random;
import java.util.concurrent.*;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yumingxiao1
 * @create 2019/7/3
 * @since 1.0.0
 */
public class Demo {

    public static void main(String[] args){
        CountDownLatch latch=new CountDownLatch(4);
        Boss boss=new Boss(latch);
        Work w1=new Work(latch,"张三");
        Work w2=new Work(latch,"李四");
        Work w3=new Work(latch,"王二麻子");
        Work w4=new Work(latch,"赵六");
        /*Thread thread=new Thread(()->{
            System.out.println("cahislkasdas"+ "  "+ Thread.currentThread().getName());
        });
        thread.start();*/
        /*ExecutorService executorService=Executors.newCachedThreadPool();
        //executor.execute();
        //ExecutorService executorService= Executors.newFixedThreadPool(3);
        executorService.execute(w1);
        executorService.execute(w2);
        executorService.execute(w3);
        executorService.execute(w4);
        executorService.execute(boss);

        executorService.shutdown();*/

        //ThreadPoolExecutor pool=new ThreadPoolExecutor(5,10,30, TimeUnit.MILLISECONDS, new );

    }



    static class Work implements Runnable{

        private CountDownLatch countDownLatch;

        private String name;

        public Work(CountDownLatch countDownLatch, String name) {
            this.countDownLatch = countDownLatch;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(this.name+ "正在工作。。。。");
            try {
                Thread.sleep(new Random().nextInt(10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.name + "完成工作。。。。");
            this.countDownLatch.countDown();
        }
    }

    static class Boss implements Runnable{
        private CountDownLatch countDownLatch;

        public Boss(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                System.out.println("老板在等工人干完活。。。。");
                countDownLatch.await();
                System.out.println("工人干活完成，老板开始检查工作。。。。");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
