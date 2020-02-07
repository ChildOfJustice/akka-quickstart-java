package myTest;
import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

class PrintMyActorRefActor extends AbstractActor {
	private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
  static Props props() {
    return Props.create(PrintMyActorRefActor.class, PrintMyActorRefActor::new);
  }

  @Override
  public Receive createReceive() {
    return receiveBuilder()
            .matchEquals(
            "startAnim",
            p -> {
              System.out.println("Starting...");
              //First2D.goAnim.go();
              System.out.println("going!!!!");
              //ActorRef secondRef = getContext().actorOf(Props.empty(), "second-actor");
              //System.out.println("Second: " + secondRef);
              
            })

            .matchEquals(
                "hi",
            p -> {
              System.out.println("Hello");
//                  while(true) {
//                	  Thread.sleep(3000);
//                	  System.out.println("----");
//                  }
            })

            .match(String.class, s -> {
                //log.info("Received String message: {}", s);
                System.out.println("Received String message: " + s);
            })

            .matchAny(p -> {
                //log.info("received unknown message");
                System.out.println("received unknown message");
            })

            .build();
  }
}
public class test1 {
  public static void main(String[] args) throws java.io.IOException {
    ActorSystem system = ActorSystem.create("testSystem");

    ActorRef firstRef = system.actorOf(PrintMyActorRefActor.props(), "first-actor");



    firstRef.tell("printit", firstRef);

    firstRef.tell("hi", ActorRef.noSender());
    
    firstRef.tell(1, ActorRef.noSender());

    
    
    
    try {
      
    } finally {
      system.terminate();
    }
  }
  
}
