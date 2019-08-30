# 策略模式

策略模式是为了满足SOLID设计原则中的开闭原则而产生的.

开闭原则:即对修改关闭,对扩展开放.
策略模式的使用从一定程度上实现了程序的解耦,并且可维护性高很多.



~~~java
public interface State {
    
    void listenMusic();
}
~~~
开心状态下的实现.
~~~java
public class Happy implements State {
    
    public void listenMusic(){
        System.out.println("我要听摇滚...");
    }
}
~~~
伤心情况下的实现.
~~~java
public class Sorrow implements State {
    
    public void listenMusic(){
        System.out.println("我要听帕格尼尼24随想曲...");
    }
}
~~~

然后是主体类Human

~~~java
public class Person {
    
    private State state;
    
   private Person setState(State state) {
       this.state = state;
       return this;
   }
   
   public void listenMusic(){
       state.listenMusic();
   }
}
~~~

测试一下
~~~java
public class StrategyDemo {
    
    public static void main(String[] args){
      Person someOne = new Person();
      
      someOne.setState(new Happy()).listenMusic();
      
      someOne.setState(new Sorrow()).listenMusic();
    }
}
~~~

结果:
~~~cmd
我要听摇滚...
我要听帕格尼尼24随想曲...
~~~
当我们想要实现其他状态下的行为时,我们只需要实现对应的接口进行扩展.
不需要对已有的代码进行修改,因此策略模式完美的遵守了开闭原则
