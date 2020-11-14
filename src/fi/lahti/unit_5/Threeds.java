package fi.lahti.unit_5;

public class Threeds {
    static final int size = 10000000;
    static final int h = size / 2;
    float[] array = new float[size];

    public void calc() {
        long start = System.currentTimeMillis();

        float[] array1 = new float[h];
        float[] array2 = new float[h];

        System.arraycopy(array, 0, array1, 0, h);
        System.arraycopy(array, h, array2, 0, h);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (array1) {
                    for (int i = 0; i < array1.length - 1; i++) {
                        array1[i] = calculat(array1[i], i);
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (array2) {
                    for (int i = 0; i < array2.length - 1; i++) {
                        array2[i] = calculat(array2[i], i);
                    }
                }
            }
        });

        t1.start();
        t2.start();

        synchronized (array1){
            System.arraycopy(array1, 0, array, 0, h);

        }

        synchronized (array2){
            System.arraycopy(array2, 0, array, h, h);
        }

      long end = System.currentTimeMillis()- start;
                System.out.println(end);

    }

    public void calcJoin() {
        long start = System.currentTimeMillis();

        float[] array1 = new float[h];
        float[] array2 = new float[h];

        System.arraycopy(array, 0, array1, 0, h);
        System.arraycopy(array, h, array2, 0, h);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                         for (int i = 0; i < array1.length - 1; i++) {
                        array1[i] = calculat(array1[i], i);
                    }
                }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                        for (int i = 0; i < array2.length - 1; i++) {
                        array2[i] = calculat(array2[i], i);
                    }
                }
        });

        t1.start();
        t2.start();


        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.arraycopy(array1, 0, array, 0, h);
        System.arraycopy(array2, 0, array, h, h);


        long end = System.currentTimeMillis()- start;
        System.out.println(end);

    }


    public float calculat(float value , int index ){

        return (float) (value * Math.sin(0.2f + index / 5) * Math.cos(0.2f + index / 5) * Math.cos(0.4f + index / 2));
    }

}
