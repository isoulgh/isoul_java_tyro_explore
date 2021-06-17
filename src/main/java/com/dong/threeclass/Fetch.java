//package dong.编写三个类;
//
//import com.kangqiao.study.Int;
//
//public class Fetch extends Thread{
//	Int store;
//	public Fetch(Int a,String name) {
//		// TODO Auto-generated constructor stub
//		super(name);
//		store = a;
//	}
//	@Override
//	public void run() {
//		while(true) {
//			synchronized (store) {
//
//				double temp = store.getData();
//
//				int fetch = (int)(Math.random()*100);
//
//				String tn = Thread.currentThread().getName();
//					if(store.flag == true) {
//						//�������߳�t1
//						store.setData(temp-fetch);
//						System.out.println(tn+"ȡ����"+fetch);
//						if(store.getData()<0) {
//							break;
//						}
//						store.flag = false;
//						store.notify();
//					}else {
//						try {
//							store.wait();
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//			}
//		}
//	}
//
//}
//
