import java.util.ArrayList;
public class ConcreteSubject implements Subject{
  private ArrayList<Base> registered = new ArrayList<Base>();
  
  public ConcreteSubject(){
    registered.add(HomeBase.getInstance());
  }
  
  //REGISTER
  public void register(Base newBase){
    if (registered.contains(newBase)) { //Prevents duplication bases
      return;
    } 
    else if (newBase instanceof Spy){ //If spy is already linked to Fieldbase, do not reg. Also prevents spys from re-registering
      if (newBase.getHQ() != null) {
        newBase.setHQ();
        return;
      }
    }
    registered.add(newBase);
  }

  //UNREGISTER
  public void unregister(Base base){
    if (base instanceof HomeBase || base instanceof Spy){ //Cannot remove HomeBase or Spy
      return;
    }
    else {
      registered.remove(base);
    }
    return;
  }

  //ENCRYPTION UPDATE
  public void notifyEncryption(Strategy newCipher, int newKey){
    for (int i = 0; i < registered.size(); i++){
      (registered.get(i)).updateEncryption(newCipher,newKey);
    }
  }

  //CHECK SPY DEATH
  public void checkSpy(Spy spy){
    if (spy.alive = false){ //If spy is dead remove from register
      registered.remove(spy);
    }
    return;
  }
}