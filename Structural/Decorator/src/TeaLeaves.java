public class TeaLeaves extends Tea {  
   public TeaLeaves() {
       teaIsSteeped = false;
   }
   
   public void steepTea() {
       teaIsSteeped = true;
       System.out.println("tea leaves are steeping");
   }
}
