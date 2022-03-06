class Foo {
    
    CountDownLatch firstCompleted;
    CountDownLatch secondCompleted;
    public Foo() {
        firstCompleted = new CountDownLatch(1);
        secondCompleted = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstCompleted.countDown();
    }
    

    public void second(Runnable printSecond) throws InterruptedException {
        firstCompleted.await();
        printSecond.run();
        secondCompleted.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        firstCompleted.await();
        secondCompleted.await();
        printThird.run();
    }
}


class Foo {

    private final AtomicInteger lock = new AtomicInteger(0);

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while(lock.get() != 0  ) {
                
        }
        printFirst.run();
        lock.incrementAndGet();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while(lock.get() != 1  ) {
                
        }
        printSecond.run();
        lock.incrementAndGet();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while(lock.get() !=2  ) {
                
        }
        printThird.run();
    }
}