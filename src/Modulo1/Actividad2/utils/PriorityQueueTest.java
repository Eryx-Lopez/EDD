package Modulo1.Actividad2.utils;

import org.junit.Assert;
import org.junit.Test;

public class PriorityQueueTest {
    @Test
    public void addTest(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(6);
        queue.offer(8);
        queue.offer(10);
        queue.offer(1);

        Assert.assertEquals(6,queue.get(0)==6);
        Assert.assertEquals(6,queue.get(0)==8);
        Assert.assertEquals(6,queue.get(0)==10);
        Assert.assertEquals(6,queue.get(0)==1);
    }
    @Test
    public void offerTest(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(6);
        queue.offer(8);
        queue.offer(10);
        queue.offer(1);

        Assert.assertEquals(6,queue.get(0)==6);
        Assert.assertEquals(6,queue.get(0)==8);
        Assert.assertEquals(6,queue.get(0)==10);
        Assert.assertEquals(6,queue.get(0)==1);
    }
    @Test
    public void pollTest(){
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(6);
        queue.offer(8);
        queue.offer(10);
        queue.offer(1);

        Assert.assertEquals(6,queue.poll().get()==6);
        Assert.assertEquals(6,queue.poll().get()==8);
        Assert.assertEquals(6,queue.poll().get()==10);
        Assert.assertEquals(6,queue.poll().get()==1);
    }
}
