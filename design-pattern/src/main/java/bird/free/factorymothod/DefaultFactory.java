package bird.free.factorymothod;

import io.netty.util.internal.StringUtil;

public class DefaultFactory extends AbstractFactory {


    Computer createComputer(String brand) {
        if(StringUtil.isNullOrEmpty(brand)){
            throw new NullPointerException(String.format("brand cannot be %s",brand));
        }
       switch (brand){
           case Computer.LENOVO:
               return new LenovoComputer(brand);
           case Computer.DELL:
               return new DellComputer(brand);
           default:
               return null;
       }
    }
}
