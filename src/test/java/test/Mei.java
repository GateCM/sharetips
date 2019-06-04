//package meimei;
//
//import java.util.concurrent.Future;
//
///**
// * Created by yaoguang on 2019/3/25 20:51.
// * Description:
// *
// * @author <a href="mailto:chenxiaohui@cai-inc.com"/>
// */
//public class Mei {
//    public static void main(String[] args) {
//        CarInfo carInfo = getCarInfo(carId);
//        ReparirOrder reparirOrder = getById(orderId);
//        Future<CarInfo> task1 = pool.submit(new Runnable(){
//            @Override
//            public void run() {
//                return getCarInfo(carId);
//            }
//        });
//
//        Future<ReparirOrder> task2 = pool.submit(new Runnable(){
//            @Override
//            public void run() {
//                return getById(orderId);
//            }
//        });
//
//        reparirOrder reparirOrder1 = new RepairOrder();
//        ReparirOrder reparirOrder = task1.get();
//
//        reparirOrder.setOrderId..
//        reparirOrder.set...
//
//        CarInfo carInfo = task2.get();
//        carInfo.set.
//        ...
//
//
//    }
//}
