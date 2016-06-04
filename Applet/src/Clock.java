import java.applet.*;
import java.awt.*;
import java.util.*;
import java.text.*;

public class Clock extends Applet implements Runnable {

   int width, height;
   Thread t = null;
   boolean threadSuspended;
   int hours=0, minutes=0, seconds=0;
   String timeString = "";

   public void init() {
      width = getSize().width;
      height = getSize().height;
      setBackground( Color.black );
   }

   public void start() {
      if ( t == null ) {
         t = new Thread( this );
         t.setPriority( Thread.MIN_PRIORITY );
         threadSuspended = false;
         t.start();
      }
      else {
         if ( threadSuspended ) {
            threadSuspended = false;
            synchronized( this ) {
               notify();
            }
         }
      }
   }

   public void stop() {
      threadSuspended = true;
   }

   public void run() {
      try {
         while (true) {

            // Here's where the thread does some work
            Calendar cal = Calendar.getInstance();
            hours = cal.get( Calendar.HOUR_OF_DAY );
            if ( hours > 12 ) hours -= 12;
            minutes = cal.get( Calendar.MINUTE );
            seconds = cal.get( Calendar.SECOND );

            SimpleDateFormat formatter
               = new SimpleDateFormat( "hh:mm:ss", Locale.getDefault() );
            Date date = cal.getTime();
            timeString = formatter.format( date );

            // Now the thread checks to see if it should suspend itself
            if ( threadSuspended ) {
               synchronized( this ) {
                  while ( threadSuspended ) {
                     wait();
                  }
               }
            }
            repaint();
            t.sleep( 1000 );  // interval given in milliseconds
         }
      }
      catch (InterruptedException e) { }
   }

   void drawHand( double angle, int radius, Graphics g ) {
      angle -= 0.5 * Math.PI;
      int x = (int)( radius*Math.cos(angle) );
      int y = (int)( radius*Math.sin(angle) );
      g.drawLine( width/2, height/2, width/2 + x, height/2 + y );
   }

   void drawWedge( double angle, int radius, Graphics g ) {
      angle -= 0.5 * Math.PI;
      int x = (int)( radius*Math.cos(angle) );
      int y = (int)( radius*Math.sin(angle) );
      angle += 2*Math.PI/3;
      int x2 = (int)( 5*Math.cos(angle) );
      int y2 = (int)( 5*Math.sin(angle) );
      angle += 2*Math.PI/3;
      int x3 = (int)( 5*Math.cos(angle) );
      int y3 = (int)( 5*Math.sin(angle) );
      g.drawLine( width/2+x2, height/2+y2, width/2 + x, height/2 + y );
      g.drawLine( width/2+x3, height/2+y3, width/2 + x, height/2 + y );
      g.drawLine( width/2+x2, height/2+y2, width/2 + x3, height/2 + y3 );
   }

   public void paint( Graphics g ) {
	  
      g.setColor( Color.white );
      drawWedge( 2*Math.PI * hours / 12, width/5, g );
      drawWedge( 2*Math.PI * minutes / 60, width/3, g );
      g.setColor( Color.red );
      drawHand( 2*Math.PI * seconds / 60, width/2, g );
      g.setColor( Color.white );
      g.drawOval(0, 0, width, height);
     // g.setColor( Color.white );
      g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
     // g.drawString("12", width/2, 20);
     // g.drawString("6", width/2, height);
      
      double radius = width / 2.4;
      for ( int i = 0; i < 12; i++) {
         // Compute (x,y) positions along a circle,
         // using the sine and cosine of an appropriately computed angle.
         double angle = 2*Math.PI*i/(double)12;
         int x = (int)( radius*Math.cos(angle) );
         int y = (int)( radius*Math.sin(angle) );

         //g.setColor( spectrum[ i ] );
         g.drawString( ""+(i+1), width/2+x, height/2+y );
        // g.drawLine(width/2, height/2, width/2+x, height/2+y);
      }

      g.drawString( timeString, 10, height-10 );
   }
}