
public class Main {

  public static void main(String[] args) {
    System.out.println(""
            + "Course is over!\n"
            + "After you have submitted this exercise, remember to give us "
            + "some feedback about this course\n");
// Feedbacks:
//
// 1. This is the best web course I have ever taken. Clear, understandable, 
// considerate explanation and helpful exercises with auto-tests and hint 
// messages. Finishing all the exercises really let me learn a lot about Java. 
// Respect and appreciation to all people who developed and maintained the 
// course.
//
// 2. A little thing I noticed about the final exercise Worm Game. In the 
// UserInterface.java file, public Updatable getUpdatable() method, if I return 
// the drawingboard I get from the frame, the game can run perfectly without any
// bug, but it will not pass the test. The only way I figured out to pass the 
// test, is to set an object variable to restore the drawingboard and return 
// that object variable, which I think is redundant since the drawingboard is 
// already stored in the content panel.
//
// For your reference, this is the code that can pass the test but need to use 
// an extra object variable:
// public Updatable getUpdatable() {
//   if(drawingBoard==null) return null;
//   return drawingBoard;
// }
// and this is the code can run the game but can not pass the test:
// public Updatable getUpdatable() {
//   if(frame==null) return null;
//   return (Updatable)frame.getContentPane().getComponent(0);
// }   
  }
}
