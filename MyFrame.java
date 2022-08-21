import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

    public class MyFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    MyFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Clock Program");
        this.setLayout(new GridLayout(3,1));
        this.setSize(350, 200);
        this.setResizable(false);

        timeFormat = new SimpleDateFormat("HH:mm:ss");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("dd. MMMMM, yyyy");

        timeLabel = new JLabel("",SwingConstants.CENTER);
        timeLabel.setFont(new Font("Verdana", Font.PLAIN,50));
        timeLabel.setForeground(new Color(0x00FF00)); //color green
        timeLabel.setBackground(Color.black); //background color black
        timeLabel.setOpaque(true);

        dayLabel = new JLabel("",SwingConstants.CENTER);        //centers the content that will be overwritten
        dayLabel.setFont(new Font("Arial", Font.PLAIN,35));

        dateLabel = new JLabel("",SwingConstants.CENTER);
        dateLabel.setFont(new Font("Arial", Font.PLAIN,25));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();

    }

    public void setTime(){

        while (true) {

            time = timeFormat.format(Calendar.getInstance().getTime());
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
