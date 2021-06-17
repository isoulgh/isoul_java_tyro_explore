//package dong.编写三个类;
//
//import com.kangqiao.study.Int;
//
//public class Store  extends Thread{
//	Int store;
//	public Store(Int a,String name) {
//		// TODO Auto-generated constructor stub
//		super(name);
//		store = a;
//	}
//	@Override
//	public void run() {
//		while(true) {
//			synchronized (store) {
//				//ͬ�������
//				double temp = store.getData();
//				int store1;
//				store1 = (int)(Math.random()*100);
//				//run����������������ĸ��̵߳��õģ�
//				//ͨ����ǰ�̵߳��������ж�
//				String tn = Thread.currentThread().getName();
//					if(store.flag == false) {
//						//�������߳�t1
//						store.setData(temp+store1);
//						System.out.println(tn + "�ȴ���"+ store1);
//
//						store.flag = true;
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
