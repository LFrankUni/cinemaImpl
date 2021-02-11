/**--- Generated at Thu Feb 11 17:03:43 CET 2021 
 * --- No Change Allowed!  
 */
package generated.test.proxies;
import idManagement.Identifiable;
import db.executer.PersistenceException;
import generated.test.Class_1;
import generated.test.Class_2;
public interface IClass_1 extends Identifiable{
   public Class_1 getTheObject();
   public Integer getId();
   public Class_2 getC2() throws PersistenceException;
   public void setC2(Class_2 newC2)throws PersistenceException;
   public Boolean getA1() ;
   public void setA1(Boolean newA1) throws PersistenceException;
}
