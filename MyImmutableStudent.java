
/**
 * Write a description of class ImmutableStudent here.
 * This class must be Immutable
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyImmutableStudent
{
   private final int mnr;
   private final String name;
   private final Address address;
   public MyImmutableStudent( final int mnr, final String name, final Address address){
       this.mnr=mnr;
       this.name= name;
       this.address = new Address(
        address.getStreetname(),
        address.getStreetnumber(),
        address.getPostalcode(),
        address.getCityname()
       );
   }
     public int getMnr(){
       return mnr;
   }
   public String getName(){
       return name;
   }
   void changeMnrTo0(){
       /*this.mnr=0;*/
   }
}
